package org.spongycastle.crypto.generators;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import okhttp3.internal.http.StatusLine;
import org.kxml2.wap.Wbxml;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NaccacheSternKeyGenerationParameters param;
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, Wbxml.STR_T, 137, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA, 151, 157, 163, 167, 173, 179, 181, 191, Wbxml.EXT_1, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, StatusLine.HTTP_TEMP_REDIRECT, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557};
    private static final BigInteger ONE = BigInteger.valueOf(1);

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf(smallPrimes[i2]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i, i2, secureRandom);
        while (bigInteger.bitLength() != i) {
            bigInteger = new BigInteger(i, i2, secureRandom);
        }
        return bigInteger;
    }

    private static int getInt(SecureRandom secureRandom, int i) {
        int nextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((i * (secureRandom.nextInt() & Integer.MAX_VALUE)) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = nextInt % i;
        } while ((i - 1) + (nextInt - i2) < 0);
        return i2;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        vector3.removeElementAt(0);
        while (vector3.size() != 0) {
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
            vector3.removeElementAt(0);
        }
        return vector2;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger generatePrime;
        BigInteger add;
        BigInteger generatePrime2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger add2;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        boolean z;
        BigInteger bigInteger9;
        BigInteger bigInteger10;
        int i;
        long j;
        BigInteger bigInteger11;
        int i2;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean isDebug = this.param.isDebug();
        if (isDebug) {
            PrintStream printStream = System.out;
            StringBuilder m253r = outline.m253r("Fetching first ");
            m253r.append(this.param.getCntSmallPrimes());
            m253r.append(" primes.");
            printStream.println(m253r.toString());
        }
        Vector permuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigInteger12 = ONE;
        BigInteger bigInteger13 = bigInteger12;
        for (int i3 = 0; i3 < permuteList.size() / 2; i3++) {
            bigInteger13 = bigInteger13.multiply((BigInteger) permuteList.elementAt(i3));
        }
        for (int size = permuteList.size() / 2; size < permuteList.size(); size++) {
            bigInteger12 = bigInteger12.multiply((BigInteger) permuteList.elementAt(size));
        }
        BigInteger multiply = bigInteger13.multiply(bigInteger12);
        int bitLength = (((strength - multiply.bitLength()) - 48) / 2) + 1;
        BigInteger generatePrime3 = generatePrime(bitLength, certainty, random);
        BigInteger generatePrime4 = generatePrime(bitLength, certainty, random);
        if (isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger shiftLeft = generatePrime3.multiply(bigInteger13).shiftLeft(1);
        BigInteger shiftLeft2 = generatePrime4.multiply(bigInteger12).shiftLeft(1);
        long j2 = 0;
        while (true) {
            j2++;
            generatePrime = generatePrime(24, certainty, random);
            add = generatePrime.multiply(shiftLeft).add(ONE);
            if (add.isProbablePrime(certainty)) {
                while (true) {
                    do {
                        generatePrime2 = generatePrime(24, certainty, random);
                    } while (generatePrime.equals(generatePrime2));
                    BigInteger multiply2 = generatePrime2.multiply(shiftLeft2);
                    bigInteger = shiftLeft2;
                    bigInteger2 = ONE;
                    add2 = multiply2.add(bigInteger2);
                    if (add2.isProbablePrime(certainty)) {
                        break;
                    }
                    shiftLeft2 = bigInteger;
                    certainty = certainty;
                }
                bigInteger3 = shiftLeft;
                if (!multiply.gcd(generatePrime.multiply(generatePrime2)).equals(bigInteger2)) {
                    continue;
                } else if (add.multiply(add2).bitLength() >= strength) {
                    break;
                } else if (isDebug) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("key size too small. Should be " + strength + " but is actually " + add.multiply(add2).bitLength());
                }
            } else {
                bigInteger = shiftLeft2;
                bigInteger3 = shiftLeft;
            }
            shiftLeft2 = bigInteger;
            shiftLeft = bigInteger3;
        }
        if (isDebug) {
            bigInteger4 = generatePrime4;
            PrintStream printStream3 = System.out;
            bigInteger5 = generatePrime3;
            printStream3.println("needed " + j2 + " tries to generate p and q.");
        } else {
            bigInteger4 = generatePrime4;
            bigInteger5 = generatePrime3;
        }
        BigInteger multiply3 = add.multiply(add2);
        BigInteger multiply4 = add.subtract(bigInteger2).multiply(add2.subtract(bigInteger2));
        if (isDebug) {
            System.out.println("generating g");
        }
        long j3 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger6 = add;
            bigInteger7 = add2;
            int i4 = 0;
            while (i4 != permuteList.size()) {
                BigInteger divide = multiply4.divide((BigInteger) permuteList.elementAt(i4));
                while (true) {
                    j = j3 + 1;
                    bigInteger11 = new BigInteger(strength, certainty, random);
                    i2 = strength;
                    if (bigInteger11.modPow(divide, multiply3).equals(ONE)) {
                        j3 = j;
                        strength = i2;
                    }
                }
                vector.addElement(bigInteger11);
                i4++;
                j3 = j;
                strength = i2;
            }
            int i5 = strength;
            bigInteger8 = ONE;
            int i6 = 0;
            while (i6 < permuteList.size()) {
                bigInteger8 = bigInteger8.multiply(((BigInteger) vector.elementAt(i6)).modPow(multiply.divide((BigInteger) permuteList.elementAt(i6)), multiply3)).mod(multiply3);
                i6++;
                random = random;
            }
            SecureRandom secureRandom = random;
            int i7 = 0;
            while (true) {
                if (i7 >= permuteList.size()) {
                    z = false;
                    break;
                } else if (bigInteger8.modPow(multiply4.divide((BigInteger) permuteList.elementAt(i7)), multiply3).equals(ONE)) {
                    if (isDebug) {
                        PrintStream printStream4 = System.out;
                        StringBuilder m253r2 = outline.m253r("g has order phi(n)/");
                        m253r2.append(permuteList.elementAt(i7));
                        m253r2.append("\n g: ");
                        m253r2.append(bigInteger8);
                        printStream4.println(m253r2.toString());
                    }
                    z = true;
                } else {
                    i7++;
                }
            }
            if (!z) {
                BigInteger modPow = bigInteger8.modPow(multiply4.divide(BigInteger.valueOf(4L)), multiply3);
                BigInteger bigInteger14 = ONE;
                if (modPow.equals(bigInteger14)) {
                    if (isDebug) {
                        PrintStream printStream5 = System.out;
                        printStream5.println("g has order phi(n)/4\n g:" + bigInteger8);
                    }
                } else if (bigInteger8.modPow(multiply4.divide(generatePrime), multiply3).equals(bigInteger14)) {
                    if (isDebug) {
                        PrintStream printStream6 = System.out;
                        printStream6.println("g has order phi(n)/p'\n g: " + bigInteger8);
                    }
                } else if (!bigInteger8.modPow(multiply4.divide(generatePrime2), multiply3).equals(bigInteger14)) {
                    bigInteger10 = bigInteger5;
                    if (!bigInteger8.modPow(multiply4.divide(bigInteger10), multiply3).equals(bigInteger14)) {
                        bigInteger9 = bigInteger4;
                        if (!bigInteger8.modPow(multiply4.divide(bigInteger9), multiply3).equals(bigInteger14)) {
                            break;
                        } else if (isDebug) {
                            PrintStream printStream7 = System.out;
                            StringBuilder sb = new StringBuilder();
                            i = certainty;
                            sb.append("g has order phi(n)/b\n g: ");
                            sb.append(bigInteger8);
                            printStream7.println(sb.toString());
                            bigInteger5 = bigInteger10;
                            certainty = i;
                            add2 = bigInteger7;
                            strength = i5;
                            random = secureRandom;
                            bigInteger4 = bigInteger9;
                            add = bigInteger6;
                        }
                    } else {
                        if (isDebug) {
                            PrintStream printStream8 = System.out;
                            printStream8.println("g has order phi(n)/a\n g: " + bigInteger8);
                        }
                        bigInteger9 = bigInteger4;
                    }
                    i = certainty;
                    bigInteger5 = bigInteger10;
                    certainty = i;
                    add2 = bigInteger7;
                    strength = i5;
                    random = secureRandom;
                    bigInteger4 = bigInteger9;
                    add = bigInteger6;
                } else if (isDebug) {
                    PrintStream printStream9 = System.out;
                    printStream9.println("g has order phi(n)/q'\n g: " + bigInteger8);
                }
            }
            bigInteger9 = bigInteger4;
            bigInteger10 = bigInteger5;
            i = certainty;
            bigInteger5 = bigInteger10;
            certainty = i;
            add2 = bigInteger7;
            strength = i5;
            random = secureRandom;
            bigInteger4 = bigInteger9;
            add = bigInteger6;
        }
        if (isDebug) {
            PrintStream printStream10 = System.out;
            printStream10.println("needed " + j3 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            PrintStream printStream11 = System.out;
            printStream11.println("smallPrimes: " + permuteList);
            PrintStream printStream12 = System.out;
            printStream12.println("sigma:...... " + multiply + " (" + multiply.bitLength() + " bits)");
            PrintStream printStream13 = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("a:.......... ");
            sb2.append(bigInteger10);
            printStream13.println(sb2.toString());
            PrintStream printStream14 = System.out;
            printStream14.println("b:.......... " + bigInteger9);
            PrintStream printStream15 = System.out;
            printStream15.println("p':......... " + generatePrime);
            PrintStream printStream16 = System.out;
            printStream16.println("q':......... " + generatePrime2);
            PrintStream printStream17 = System.out;
            printStream17.println("p:.......... " + bigInteger6);
            PrintStream printStream18 = System.out;
            printStream18.println("q:.......... " + bigInteger7);
            PrintStream printStream19 = System.out;
            printStream19.println("n:.......... " + multiply3);
            PrintStream printStream20 = System.out;
            printStream20.println("phi(n):..... " + multiply4);
            PrintStream printStream21 = System.out;
            printStream21.println("g:.......... " + bigInteger8);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair(new NaccacheSternKeyParameters(false, bigInteger8, multiply3, multiply.bitLength()), new NaccacheSternPrivateKeyParameters(bigInteger8, multiply3, multiply.bitLength(), permuteList, multiply4));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}
