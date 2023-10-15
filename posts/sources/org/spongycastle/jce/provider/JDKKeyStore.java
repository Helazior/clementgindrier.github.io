package org.spongycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.p013io.DigestInputStream;
import org.spongycastle.crypto.p013io.DigestOutputStream;
import org.spongycastle.crypto.p013io.MacInputStream;
import org.spongycastle.crypto.p013io.MacOutputStream;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.p018io.Streams;
import org.spongycastle.util.p018io.TeeOutputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class JDKKeyStore extends KeyStoreSpi implements BCKeyStore {
    public static final int CERTIFICATE = 1;
    public static final int KEY = 2;
    private static final String KEY_CIPHER = "PBEWithSHAAnd3-KeyTripleDES-CBC";
    public static final int KEY_PRIVATE = 0;
    public static final int KEY_PUBLIC = 1;
    private static final int KEY_SALT_SIZE = 20;
    public static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    public static final int NULL = 0;
    public static final int SEALED = 4;
    public static final int SECRET = 3;
    private static final String STORE_CIPHER = "PBEWithSHAAndTwofish-CBC";
    private static final int STORE_SALT_SIZE = 20;
    private static final int STORE_VERSION = 2;
    public Hashtable table = new Hashtable();
    public SecureRandom random = new SecureRandom();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class BouncyCastleStore extends JDKKeyStore {
        @Override // org.spongycastle.jce.provider.JDKKeyStore, java.security.KeyStoreSpi
        public void engineLoad(InputStream inputStream, char[] cArr) {
            this.table.clear();
            if (inputStream == null) {
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int readInt = dataInputStream.readInt();
            if (readInt != 2 && readInt != 0 && readInt != 1) {
                throw new IOException("Wrong version of key store.");
            }
            int readInt2 = dataInputStream.readInt();
            byte[] bArr = new byte[readInt2];
            if (readInt2 == 20) {
                dataInputStream.readFully(bArr);
                int readInt3 = dataInputStream.readInt();
                if (readInt3 >= 0 && readInt3 <= 4096) {
                    CipherInputStream cipherInputStream = new CipherInputStream(dataInputStream, makePBECipher(readInt == 0 ? "OldPBEWithSHAAndTwofish-CBC" : JDKKeyStore.STORE_CIPHER, 2, cArr, bArr, readInt3));
                    SHA1Digest sHA1Digest = new SHA1Digest();
                    loadStore(new DigestInputStream(cipherInputStream, sHA1Digest));
                    byte[] bArr2 = new byte[sHA1Digest.getDigestSize()];
                    sHA1Digest.doFinal(bArr2, 0);
                    byte[] bArr3 = new byte[sHA1Digest.getDigestSize()];
                    Streams.readFully(cipherInputStream, bArr3);
                    if (Arrays.constantTimeAreEqual(bArr2, bArr3)) {
                        return;
                    }
                    this.table.clear();
                    throw new IOException("KeyStore integrity check failed.");
                }
                throw new IOException("Key store corrupted.");
            }
            throw new IOException("Key store corrupted.");
        }

        @Override // org.spongycastle.jce.provider.JDKKeyStore, java.security.KeyStoreSpi
        public void engineStore(OutputStream outputStream, char[] cArr) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            byte[] bArr = new byte[20];
            int nextInt = (this.random.nextInt() & 1023) + 1024;
            this.random.nextBytes(bArr);
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(dataOutputStream, makePBECipher(JDKKeyStore.STORE_CIPHER, 1, cArr, bArr, nextInt));
            DigestOutputStream digestOutputStream = new DigestOutputStream(new SHA1Digest());
            saveStore(new TeeOutputStream(cipherOutputStream, digestOutputStream));
            cipherOutputStream.write(digestOutputStream.getDigest());
            cipherOutputStream.close();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class StoreEntry {
        public String alias;
        public Certificate[] certChain;
        public Date date;
        public Object obj;
        public int type;

        public StoreEntry(String str, Certificate certificate) {
            this.date = new Date();
            this.type = 1;
            this.alias = str;
            this.obj = certificate;
            this.certChain = null;
        }

        public String getAlias() {
            return this.alias;
        }

        public Certificate[] getCertificateChain() {
            return this.certChain;
        }

        public Date getDate() {
            return this.date;
        }

        public Object getObject() {
            return this.obj;
        }

        public int getType() {
            return this.type;
        }

        public Object getObject(char[] cArr) {
            Key decodeKey;
            if (cArr == null || cArr.length == 0) {
                Object obj = this.obj;
                if (obj instanceof Key) {
                    return obj;
                }
            }
            if (this.type == 4) {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) this.obj));
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr);
                    try {
                        return JDKKeyStore.this.decodeKey(new DataInputStream(new CipherInputStream(dataInputStream, JDKKeyStore.this.makePBECipher(JDKKeyStore.KEY_CIPHER, 2, cArr, bArr, dataInputStream.readInt()))));
                    } catch (Exception unused) {
                        DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) this.obj));
                        byte[] bArr2 = new byte[dataInputStream2.readInt()];
                        dataInputStream2.readFully(bArr2);
                        int readInt = dataInputStream2.readInt();
                        try {
                            decodeKey = JDKKeyStore.this.decodeKey(new DataInputStream(new CipherInputStream(dataInputStream2, JDKKeyStore.this.makePBECipher("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr2, readInt))));
                        } catch (Exception unused2) {
                            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) this.obj));
                            bArr2 = new byte[dataInputStream3.readInt()];
                            dataInputStream3.readFully(bArr2);
                            readInt = dataInputStream3.readInt();
                            decodeKey = JDKKeyStore.this.decodeKey(new DataInputStream(new CipherInputStream(dataInputStream3, JDKKeyStore.this.makePBECipher("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr2, readInt))));
                        }
                        byte[] bArr3 = bArr2;
                        int i = readInt;
                        if (decodeKey != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                            dataOutputStream.writeInt(bArr3.length);
                            dataOutputStream.write(bArr3);
                            dataOutputStream.writeInt(i);
                            DataOutputStream dataOutputStream2 = new DataOutputStream(new CipherOutputStream(dataOutputStream, JDKKeyStore.this.makePBECipher(JDKKeyStore.KEY_CIPHER, 1, cArr, bArr3, i)));
                            JDKKeyStore.this.encodeKey(decodeKey, dataOutputStream2);
                            dataOutputStream2.close();
                            this.obj = byteArrayOutputStream.toByteArray();
                            return decodeKey;
                        }
                        throw new UnrecoverableKeyException("no match");
                    }
                } catch (Exception unused3) {
                    throw new UnrecoverableKeyException("no match");
                }
            }
            throw new RuntimeException("forget something!");
        }

        public StoreEntry(String str, byte[] bArr, Certificate[] certificateArr) {
            this.date = new Date();
            this.type = 3;
            this.alias = str;
            this.obj = bArr;
            this.certChain = certificateArr;
        }

        public StoreEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
            this.date = new Date();
            this.type = 4;
            this.alias = str;
            this.certChain = certificateArr;
            byte[] bArr = new byte[20];
            JDKKeyStore.this.random.setSeed(System.currentTimeMillis());
            JDKKeyStore.this.random.nextBytes(bArr);
            int nextInt = (JDKKeyStore.this.random.nextInt() & 1023) + 1024;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            DataOutputStream dataOutputStream2 = new DataOutputStream(new CipherOutputStream(dataOutputStream, JDKKeyStore.this.makePBECipher(JDKKeyStore.KEY_CIPHER, 1, cArr, bArr, nextInt)));
            JDKKeyStore.this.encodeKey(key, dataOutputStream2);
            dataOutputStream2.close();
            this.obj = byteArrayOutputStream.toByteArray();
        }

        public StoreEntry(String str, Date date, int i, Object obj) {
            this.date = new Date();
            this.alias = str;
            this.date = date;
            this.type = i;
            this.obj = obj;
        }

        public StoreEntry(String str, Date date, int i, Object obj, Certificate[] certificateArr) {
            this.date = new Date();
            this.alias = str;
            this.date = date;
            this.type = i;
            this.obj = obj;
            this.certChain = certificateArr;
        }
    }

    private Certificate decodeCertificate(DataInputStream dataInputStream) {
        String readUTF = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        try {
            return CertificateFactory.getInstance(readUTF, BouncyCastleProvider.PROVIDER_NAME).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (NoSuchProviderException e) {
            throw new IOException(e.toString());
        } catch (CertificateException e2) {
            throw new IOException(e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Key decodeKey(DataInputStream dataInputStream) {
        KeySpec pKCS8EncodedKeySpec;
        int read = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        String readUTF2 = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        if (!readUTF.equals("PKCS#8") && !readUTF.equals("PKCS8")) {
            if (!readUTF.equals("X.509") && !readUTF.equals("X509")) {
                if (readUTF.equals("RAW")) {
                    return new SecretKeySpec(bArr, readUTF2);
                }
                throw new IOException(outline.m265f("Key format ", readUTF, " not recognised!"));
            }
            pKCS8EncodedKeySpec = new X509EncodedKeySpec(bArr);
        } else {
            pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr);
        }
        try {
            if (read != 0) {
                if (read != 1) {
                    if (read == 2) {
                        return SecretKeyFactory.getInstance(readUTF2, BouncyCastleProvider.PROVIDER_NAME).generateSecret(pKCS8EncodedKeySpec);
                    }
                    throw new IOException("Key type " + read + " not recognised!");
                }
                return KeyFactory.getInstance(readUTF2, BouncyCastleProvider.PROVIDER_NAME).generatePublic(pKCS8EncodedKeySpec);
            }
            return KeyFactory.getInstance(readUTF2, BouncyCastleProvider.PROVIDER_NAME).generatePrivate(pKCS8EncodedKeySpec);
        } catch (Exception e) {
            throw new IOException(outline.m275F(e, outline.m253r("Exception creating key: ")));
        }
    }

    private void encodeCertificate(Certificate certificate, DataOutputStream dataOutputStream) {
        try {
            byte[] encoded = certificate.getEncoded();
            dataOutputStream.writeUTF(certificate.getType());
            dataOutputStream.writeInt(encoded.length);
            dataOutputStream.write(encoded);
        } catch (CertificateEncodingException e) {
            throw new IOException(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encodeKey(Key key, DataOutputStream dataOutputStream) {
        byte[] encoded = key.getEncoded();
        if (key instanceof PrivateKey) {
            dataOutputStream.write(0);
        } else if (key instanceof PublicKey) {
            dataOutputStream.write(1);
        } else {
            dataOutputStream.write(2);
        }
        dataOutputStream.writeUTF(key.getFormat());
        dataOutputStream.writeUTF(key.getAlgorithm());
        dataOutputStream.writeInt(encoded.length);
        dataOutputStream.write(encoded);
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        return this.table.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return this.table.get(str) != null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) {
        if (this.table.get(str) != null) {
            this.table.remove(str);
            return;
        }
        throw new KeyStoreException(outline.m266e("no such entry as ", str));
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        if (storeEntry != null) {
            if (storeEntry.getType() == 1) {
                return (Certificate) storeEntry.getObject();
            }
            Certificate[] certificateChain = storeEntry.getCertificateChain();
            if (certificateChain != null) {
                return certificateChain[0];
            }
            return null;
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.table.elements();
        while (elements.hasMoreElements()) {
            StoreEntry storeEntry = (StoreEntry) elements.nextElement();
            if (storeEntry.getObject() instanceof Certificate) {
                if (((Certificate) storeEntry.getObject()).equals(certificate)) {
                    return storeEntry.getAlias();
                }
            } else {
                Certificate[] certificateChain = storeEntry.getCertificateChain();
                if (certificateChain != null && certificateChain[0].equals(certificate)) {
                    return storeEntry.getAlias();
                }
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        if (storeEntry != null) {
            return storeEntry.getCertificateChain();
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        if (storeEntry != null) {
            return storeEntry.getDate();
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        if (storeEntry == null || storeEntry.getType() == 1) {
            return null;
        }
        return (Key) storeEntry.getObject(cArr);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        return storeEntry != null && storeEntry.getType() == 1;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        return (storeEntry == null || storeEntry.getType() == 1) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) {
        CipherParameters generateDerivedMacParameters;
        this.table.clear();
        if (inputStream == null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        if (readInt != 2 && readInt != 0 && readInt != 1) {
            throw new IOException("Wrong version of key store.");
        }
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 0) {
            byte[] bArr = new byte[readInt2];
            dataInputStream.readFully(bArr);
            int readInt3 = dataInputStream.readInt();
            HMac hMac = new HMac(new SHA1Digest());
            if (cArr != null && cArr.length != 0) {
                byte[] PKCS12PasswordToBytes = PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
                PKCS12ParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
                pKCS12ParametersGenerator.init(PKCS12PasswordToBytes, bArr, readInt3);
                if (readInt != 2) {
                    generateDerivedMacParameters = pKCS12ParametersGenerator.generateDerivedMacParameters(hMac.getMacSize());
                } else {
                    generateDerivedMacParameters = pKCS12ParametersGenerator.generateDerivedMacParameters(hMac.getMacSize() * 8);
                }
                Arrays.fill(PKCS12PasswordToBytes, (byte) 0);
                hMac.init(generateDerivedMacParameters);
                loadStore(new MacInputStream(dataInputStream, hMac));
                byte[] bArr2 = new byte[hMac.getMacSize()];
                hMac.doFinal(bArr2, 0);
                byte[] bArr3 = new byte[hMac.getMacSize()];
                dataInputStream.readFully(bArr3);
                if (Arrays.constantTimeAreEqual(bArr2, bArr3)) {
                    return;
                }
                this.table.clear();
                throw new IOException("KeyStore integrity check failed.");
            }
            loadStore(dataInputStream);
            dataInputStream.readFully(new byte[hMac.getMacSize()]);
            return;
        }
        throw new IOException("Invalid salt detected");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) {
        StoreEntry storeEntry = (StoreEntry) this.table.get(str);
        if (storeEntry != null && storeEntry.getType() != 1) {
            throw new KeyStoreException(outline.m266e("key store already has a key entry with alias ", str));
        }
        this.table.put(str, new StoreEntry(str, certificate));
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        this.table.put(str, new StoreEntry(str, bArr, certificateArr));
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.table.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] bArr = new byte[20];
        int nextInt = (this.random.nextInt() & 1023) + 1024;
        this.random.nextBytes(bArr);
        dataOutputStream.writeInt(2);
        dataOutputStream.writeInt(20);
        dataOutputStream.write(bArr);
        dataOutputStream.writeInt(nextInt);
        HMac hMac = new HMac(new SHA1Digest());
        MacOutputStream macOutputStream = new MacOutputStream(hMac);
        PKCS12ParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
        byte[] PKCS12PasswordToBytes = PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        pKCS12ParametersGenerator.init(PKCS12PasswordToBytes, bArr, nextInt);
        hMac.init(pKCS12ParametersGenerator.generateDerivedMacParameters(hMac.getMacSize() * 8));
        for (int i = 0; i != PKCS12PasswordToBytes.length; i++) {
            PKCS12PasswordToBytes[i] = 0;
        }
        saveStore(new TeeOutputStream(dataOutputStream, macOutputStream));
        byte[] bArr2 = new byte[hMac.getMacSize()];
        hMac.doFinal(bArr2, 0);
        dataOutputStream.write(bArr2);
        dataOutputStream.close();
    }

    public void loadStore(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        for (int read = dataInputStream.read(); read > 0; read = dataInputStream.read()) {
            String readUTF = dataInputStream.readUTF();
            Date date = new Date(dataInputStream.readLong());
            int readInt = dataInputStream.readInt();
            Certificate[] certificateArr = null;
            if (readInt != 0) {
                certificateArr = new Certificate[readInt];
                for (int i = 0; i != readInt; i++) {
                    certificateArr[i] = decodeCertificate(dataInputStream);
                }
            }
            Certificate[] certificateArr2 = certificateArr;
            if (read == 1) {
                this.table.put(readUTF, new StoreEntry(readUTF, date, 1, decodeCertificate(dataInputStream)));
            } else if (read == 2) {
                this.table.put(readUTF, new StoreEntry(readUTF, date, 2, decodeKey(dataInputStream), certificateArr2));
            } else if (read != 3 && read != 4) {
                throw new RuntimeException("Unknown object type in store.");
            } else {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr);
                this.table.put(readUTF, new StoreEntry(readUTF, date, read, bArr, certificateArr2));
            }
        }
    }

    public Cipher makePBECipher(String str, int i, char[] cArr, byte[] bArr, int i2) {
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(str, BouncyCastleProvider.PROVIDER_NAME);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i2);
            Cipher cipher = Cipher.getInstance(str, BouncyCastleProvider.PROVIDER_NAME);
            cipher.init(i, secretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipher;
        } catch (Exception e) {
            throw new IOException("Error initialising store of key store: " + e);
        }
    }

    public void saveStore(OutputStream outputStream) {
        Enumeration elements = this.table.elements();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        while (true) {
            if (elements.hasMoreElements()) {
                StoreEntry storeEntry = (StoreEntry) elements.nextElement();
                dataOutputStream.write(storeEntry.getType());
                dataOutputStream.writeUTF(storeEntry.getAlias());
                dataOutputStream.writeLong(storeEntry.getDate().getTime());
                Certificate[] certificateChain = storeEntry.getCertificateChain();
                if (certificateChain == null) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(certificateChain.length);
                    for (int i = 0; i != certificateChain.length; i++) {
                        encodeCertificate(certificateChain[i], dataOutputStream);
                    }
                }
                int type = storeEntry.getType();
                if (type == 1) {
                    encodeCertificate((Certificate) storeEntry.getObject(), dataOutputStream);
                } else if (type == 2) {
                    encodeKey((Key) storeEntry.getObject(), dataOutputStream);
                } else if (type != 3 && type != 4) {
                    throw new RuntimeException("Unknown object type in store.");
                } else {
                    byte[] bArr = (byte[]) storeEntry.getObject();
                    dataOutputStream.writeInt(bArr.length);
                    dataOutputStream.write(bArr);
                }
            } else {
                dataOutputStream.write(0);
                return;
            }
        }
    }

    @Override // org.spongycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        if ((key instanceof PrivateKey) && certificateArr == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        try {
            this.table.put(str, new StoreEntry(str, key, cArr, certificateArr));
        } catch (Exception e) {
            throw new KeyStoreException(e.toString());
        }
    }
}
