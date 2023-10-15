package org.spongycastle.crypto.engines;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NaccacheSternEngine implements AsymmetricBlockCipher {
    private boolean forEncryption;
    private NaccacheSternKeyParameters key;
    private static BigInteger ZERO = BigInteger.valueOf(0);
    private static BigInteger ONE = BigInteger.valueOf(1);
    private Vector[] lookup = null;
    private boolean debug = false;

    private static BigInteger chineseRemainder(Vector vector, Vector vector2) {
        BigInteger bigInteger = ZERO;
        BigInteger bigInteger2 = ONE;
        for (int i = 0; i < vector2.size(); i++) {
            bigInteger2 = bigInteger2.multiply((BigInteger) vector2.elementAt(i));
        }
        for (int i2 = 0; i2 < vector2.size(); i2++) {
            BigInteger bigInteger3 = (BigInteger) vector2.elementAt(i2);
            BigInteger divide = bigInteger2.divide(bigInteger3);
            bigInteger = bigInteger.add(divide.multiply(divide.modInverse(bigInteger3)).multiply((BigInteger) vector.elementAt(i2)));
        }
        return bigInteger.mod(bigInteger2);
    }

    public byte[] addCryptedBlocks(byte[] bArr, byte[] bArr2) {
        if (this.forEncryption) {
            if (bArr.length > getOutputBlockSize() || bArr2.length > getOutputBlockSize()) {
                throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
            }
        } else if (bArr.length > getInputBlockSize() || bArr2.length > getInputBlockSize()) {
            throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        BigInteger mod = bigInteger.multiply(bigInteger2).mod(this.key.getModulus());
        if (this.debug) {
            PrintStream printStream = System.out;
            printStream.println("c(m1) as BigInteger:....... " + bigInteger);
            PrintStream printStream2 = System.out;
            printStream2.println("c(m2) as BigInteger:....... " + bigInteger2);
            PrintStream printStream3 = System.out;
            printStream3.println("c(m1)*c(m2)%n = c(m1+m2)%n: " + mod);
        }
        byte[] byteArray = this.key.getModulus().toByteArray();
        Arrays.fill(byteArray, (byte) 0);
        System.arraycopy(mod.toByteArray(), 0, byteArray, byteArray.length - mod.toByteArray().length, mod.toByteArray().length);
        return byteArray;
    }

    public byte[] encrypt(BigInteger bigInteger) {
        byte[] byteArray = this.key.getModulus().toByteArray();
        Arrays.fill(byteArray, (byte) 0);
        byte[] byteArray2 = this.key.getG().modPow(bigInteger, this.key.getModulus()).toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, byteArray.length - byteArray2.length, byteArray2.length);
        if (this.debug) {
            PrintStream printStream = System.out;
            StringBuilder m253r = outline.m253r("Encrypted value is:  ");
            m253r.append(new BigInteger(byteArray));
            printStream.println(m253r.toString());
        }
        return byteArray;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        if (this.forEncryption) {
            return ((this.key.getLowerSigmaBound() + 7) / 8) - 1;
        }
        return this.key.getModulus().toByteArray().length;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        if (this.forEncryption) {
            return this.key.getModulus().toByteArray().length;
        }
        return ((this.key.getLowerSigmaBound() + 7) / 8) - 1;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        this.key = (NaccacheSternKeyParameters) cipherParameters;
        if (this.forEncryption) {
            return;
        }
        if (this.debug) {
            System.out.println("Constructing lookup Array");
        }
        NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.key;
        Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
        this.lookup = new Vector[smallPrimes.size()];
        for (int i = 0; i < smallPrimes.size(); i++) {
            BigInteger bigInteger = (BigInteger) smallPrimes.elementAt(i);
            int intValue = bigInteger.intValue();
            this.lookup[i] = new Vector();
            this.lookup[i].addElement(ONE);
            if (this.debug) {
                PrintStream printStream = System.out;
                printStream.println("Constructing lookup ArrayList for " + intValue);
            }
            BigInteger bigInteger2 = ZERO;
            for (int i2 = 1; i2 < intValue; i2++) {
                bigInteger2 = bigInteger2.add(naccacheSternPrivateKeyParameters.getPhi_n());
                this.lookup[i].addElement(naccacheSternPrivateKeyParameters.getG().modPow(bigInteger2.divide(bigInteger), naccacheSternPrivateKeyParameters.getModulus()));
            }
        }
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        if (this.key != null) {
            if (i2 <= getInputBlockSize() + 1) {
                if (!this.forEncryption && i2 < getInputBlockSize()) {
                    throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
                }
                if (i != 0 || i2 != bArr.length) {
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, i, bArr2, 0, i2);
                    bArr = bArr2;
                }
                BigInteger bigInteger = new BigInteger(1, bArr);
                if (this.debug) {
                    PrintStream printStream = System.out;
                    printStream.println("input as BigInteger: " + bigInteger);
                }
                if (this.forEncryption) {
                    return encrypt(bigInteger);
                }
                Vector vector = new Vector();
                NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.key;
                Vector smallPrimes = naccacheSternPrivateKeyParameters.getSmallPrimes();
                for (int i3 = 0; i3 < smallPrimes.size(); i3++) {
                    BigInteger modPow = bigInteger.modPow(naccacheSternPrivateKeyParameters.getPhi_n().divide((BigInteger) smallPrimes.elementAt(i3)), naccacheSternPrivateKeyParameters.getModulus());
                    Vector[] vectorArr = this.lookup;
                    Vector vector2 = vectorArr[i3];
                    if (vectorArr[i3].size() != ((BigInteger) smallPrimes.elementAt(i3)).intValue()) {
                        if (this.debug) {
                            PrintStream printStream2 = System.out;
                            StringBuilder m253r = outline.m253r("Prime is ");
                            m253r.append(smallPrimes.elementAt(i3));
                            m253r.append(", lookup table has size ");
                            m253r.append(vector2.size());
                            printStream2.println(m253r.toString());
                        }
                        StringBuilder m253r2 = outline.m253r("Error in lookup Array for ");
                        m253r2.append(((BigInteger) smallPrimes.elementAt(i3)).intValue());
                        m253r2.append(": Size mismatch. Expected ArrayList with length ");
                        m253r2.append(((BigInteger) smallPrimes.elementAt(i3)).intValue());
                        m253r2.append(" but found ArrayList of length ");
                        m253r2.append(this.lookup[i3].size());
                        throw new InvalidCipherTextException(m253r2.toString());
                    }
                    int indexOf = vector2.indexOf(modPow);
                    if (indexOf == -1) {
                        if (this.debug) {
                            PrintStream printStream3 = System.out;
                            StringBuilder m253r3 = outline.m253r("Actual prime is ");
                            m253r3.append(smallPrimes.elementAt(i3));
                            printStream3.println(m253r3.toString());
                            PrintStream printStream4 = System.out;
                            printStream4.println("Decrypted value is " + modPow);
                            PrintStream printStream5 = System.out;
                            StringBuilder m253r4 = outline.m253r("LookupList for ");
                            m253r4.append(smallPrimes.elementAt(i3));
                            m253r4.append(" with size ");
                            m253r4.append(this.lookup[i3].size());
                            m253r4.append(" is: ");
                            printStream5.println(m253r4.toString());
                            for (int i4 = 0; i4 < this.lookup[i3].size(); i4++) {
                                System.out.println(this.lookup[i3].elementAt(i4));
                            }
                        }
                        throw new InvalidCipherTextException("Lookup failed");
                    }
                    vector.addElement(BigInteger.valueOf(indexOf));
                }
                return chineseRemainder(vector, smallPrimes).toByteArray();
            }
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        }
        throw new IllegalStateException("NaccacheStern engine not initialised");
    }

    public byte[] processData(byte[] bArr) {
        byte[] processBlock;
        if (this.debug) {
            System.out.println();
        }
        if (bArr.length > getInputBlockSize()) {
            int inputBlockSize = getInputBlockSize();
            int outputBlockSize = getOutputBlockSize();
            if (this.debug) {
                PrintStream printStream = System.out;
                printStream.println("Input blocksize is:  " + inputBlockSize + " bytes");
                PrintStream printStream2 = System.out;
                printStream2.println("Output blocksize is: " + outputBlockSize + " bytes");
                PrintStream printStream3 = System.out;
                StringBuilder m253r = outline.m253r("Data has length:.... ");
                m253r.append(bArr.length);
                m253r.append(" bytes");
                printStream3.println(m253r.toString());
            }
            byte[] bArr2 = new byte[((bArr.length / inputBlockSize) + 1) * outputBlockSize];
            int i = 0;
            int i2 = 0;
            while (i < bArr.length) {
                int i3 = i + inputBlockSize;
                if (i3 < bArr.length) {
                    processBlock = processBlock(bArr, i, inputBlockSize);
                    i = i3;
                } else {
                    processBlock = processBlock(bArr, i, bArr.length - i);
                    i = (bArr.length - i) + i;
                }
                if (this.debug) {
                    PrintStream printStream4 = System.out;
                    printStream4.println("new datapos is " + i);
                }
                if (processBlock != null) {
                    System.arraycopy(processBlock, 0, bArr2, i2, processBlock.length);
                    i2 += processBlock.length;
                } else {
                    if (this.debug) {
                        System.out.println("cipher returned null");
                    }
                    throw new InvalidCipherTextException("cipher returned null");
                }
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            if (this.debug) {
                PrintStream printStream5 = System.out;
                printStream5.println("returning " + i2 + " bytes");
            }
            return bArr3;
        }
        if (this.debug) {
            System.out.println("data size is less then input block size, processing directly");
        }
        return processBlock(bArr, 0, bArr.length);
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }
}
