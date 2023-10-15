package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class JDKPKCS12KeyStore extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    public static final int CERTIFICATE = 1;
    public static final int KEY = 2;
    public static final int KEY_PRIVATE = 0;
    public static final int KEY_PUBLIC = 1;
    public static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    public static final int NULL = 0;
    private static final int SALT_SIZE = 20;
    public static final int SEALED = 4;
    public static final int SECRET = 3;
    private static final Provider bcProvider = new BouncyCastleProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private ASN1ObjectIdentifier keyAlgorithm;
    private IgnoresCaseHashtable keys = new IgnoresCaseHashtable();
    private Hashtable localIds = new Hashtable();
    private IgnoresCaseHashtable certs = new IgnoresCaseHashtable();
    private Hashtable chainCerts = new Hashtable();
    private Hashtable keyCerts = new Hashtable();
    public SecureRandom random = new SecureRandom();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class BCPKCS12KeyStore extends JDKPKCS12KeyStore {
        public BCPKCS12KeyStore() {
            super(JDKPKCS12KeyStore.bcProvider, PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class BCPKCS12KeyStore3DES extends JDKPKCS12KeyStore {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BCPKCS12KeyStore3DES() {
            /*
                r2 = this;
                java.security.Provider r0 = org.spongycastle.jce.provider.JDKPKCS12KeyStore.access$200()
                org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC
                r2.<init>(r0, r1, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKPKCS12KeyStore.BCPKCS12KeyStore3DES.<init>():void");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DefPKCS12KeyStore extends JDKPKCS12KeyStore {
        public DefPKCS12KeyStore() {
            super(null, PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DefPKCS12KeyStore3DES extends JDKPKCS12KeyStore {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DefPKCS12KeyStore3DES() {
            /*
                r2 = this;
                org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC
                r1 = 0
                r2.<init>(r1, r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKPKCS12KeyStore.DefPKCS12KeyStore3DES.<init>():void");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public Object get(String str) {
            String str2 = (String) this.keys.get(Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.get(str2);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public void put(String str, Object obj) {
            String lowerCase = Strings.toLowerCase(str);
            String str2 = (String) this.keys.get(lowerCase);
            if (str2 != null) {
                this.orig.remove(str2);
            }
            this.keys.put(lowerCase, str);
            this.orig.put(str, obj);
        }

        public Object remove(String str) {
            String str2 = (String) this.keys.remove(Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.remove(str2);
        }
    }

    public JDKPKCS12KeyStore(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        try {
            if (provider != null) {
                this.certFact = CertificateFactory.getInstance("X.509", provider);
            } else {
                this.certFact = CertificateFactory.getInstance("X.509");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(outline.m275F(e, outline.m253r("can't create cert factory - ")));
        }
    }

    private static byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) {
        String id = aSN1ObjectIdentifier.getId();
        Provider provider = bcProvider;
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(id, provider);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        BCPBEKey bCPBEKey = (BCPBEKey) secretKeyFactory.generateSecret(new PBEKeySpec(cArr));
        bCPBEKey.setTryWrongPKCS12Zero(z);
        Mac mac = Mac.getInstance(aSN1ObjectIdentifier.getId(), provider);
        mac.init(bCPBEKey, pBEParameterSpec);
        mac.update(bArr2);
        return mac.doFinal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) ASN1Primitive.fromByteArray(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x01ac A[Catch: CertificateEncodingException -> 0x024e, TryCatch #2 {CertificateEncodingException -> 0x024e, blocks: (B:26:0x015d, B:28:0x0180, B:30:0x018d, B:34:0x019c, B:35:0x01a4, B:37:0x01ac, B:38:0x01b7, B:39:0x01bc, B:41:0x01c2, B:44:0x01f1, B:45:0x0232), top: B:118:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c2 A[Catch: CertificateEncodingException -> 0x024e, LOOP:3: B:39:0x01bc->B:41:0x01c2, LOOP_END, TryCatch #2 {CertificateEncodingException -> 0x024e, blocks: (B:26:0x015d, B:28:0x0180, B:30:0x018d, B:34:0x019c, B:35:0x01a4, B:37:0x01ac, B:38:0x01b7, B:39:0x01bc, B:41:0x01c2, B:44:0x01f1, B:45:0x0232), top: B:118:0x015d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doStore(java.io.OutputStream r19, char[] r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKPKCS12KeyStore.doStore(java.io.OutputStream, char[], boolean):void");
    }

    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) {
        String id = algorithmIdentifier.getAlgorithm().getId();
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(id, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            BCPBEKey bCPBEKey = (BCPBEKey) secretKeyFactory.generateSecret(pBEKeySpec);
            bCPBEKey.setTryWrongPKCS12Zero(z2);
            Cipher cipher = Cipher.getInstance(id, provider);
            cipher.init(z ? 1 : 2, bCPBEKey, pBEParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            throw new IOException(outline.m275F(e, outline.m253r("exception decrypting data - ")));
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys = this.certs.keys();
        while (keys.hasMoreElements()) {
            hashtable.put(keys.nextElement(), "cert");
        }
        Enumeration keys2 = this.keys.keys();
        while (keys2.hasMoreElements()) {
            String str = (String) keys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return (this.certs.get(str) == null && this.keys.get(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) {
        Key key = (Key) this.keys.remove(str);
        Certificate certificate = (Certificate) this.certs.remove(str);
        if (certificate != null) {
            this.chainCerts.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.localIds.remove(str);
            if (str2 != null) {
                certificate = (Certificate) this.keyCerts.remove(str2);
            }
            if (certificate != null) {
                this.chainCerts.remove(new CertId(certificate.getPublicKey()));
            }
        }
        if (certificate == null && key == null) {
            throw new KeyStoreException(outline.m266e("no such entry as ", str));
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.certs.get(str);
            if (certificate == null) {
                String str2 = (String) this.localIds.get(str);
                if (str2 != null) {
                    return (Certificate) this.keyCerts.get(str2);
                }
                return (Certificate) this.keyCerts.get(str);
            }
            return certificate;
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.certs.elements();
        Enumeration keys = this.certs.keys();
        while (elements.hasMoreElements()) {
            String str = (String) keys.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.keyCerts.elements();
        Enumeration keys2 = this.keyCerts.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys2.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa A[SYNTHETIC] */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 == 0) goto Lc5
            boolean r0 = r8.engineIsKeyEntry(r9)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            java.security.cert.Certificate r9 = r8.engineGetCertificate(r9)
            if (r9 == 0) goto Lc4
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
        L15:
            if (r9 == 0) goto Lb0
            r2 = r9
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.X509Extensions.AuthorityKeyIdentifier
            java.lang.String r3 = r3.getId()
            byte[] r3 = r2.getExtensionValue(r3)
            if (r3 == 0) goto L67
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch: java.io.IOException -> L5c
            r4.<init>(r3)     // Catch: java.io.IOException -> L5c
            org.spongycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch: java.io.IOException -> L5c
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3     // Catch: java.io.IOException -> L5c
            byte[] r3 = r3.getOctets()     // Catch: java.io.IOException -> L5c
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch: java.io.IOException -> L5c
            r4.<init>(r3)     // Catch: java.io.IOException -> L5c
            org.spongycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch: java.io.IOException -> L5c
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3     // Catch: java.io.IOException -> L5c
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r3 = org.spongycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r3)     // Catch: java.io.IOException -> L5c
            byte[] r4 = r3.getKeyIdentifier()     // Catch: java.io.IOException -> L5c
            if (r4 == 0) goto L67
            java.util.Hashtable r4 = r8.chainCerts     // Catch: java.io.IOException -> L5c
            org.spongycastle.jce.provider.JDKPKCS12KeyStore$CertId r5 = new org.spongycastle.jce.provider.JDKPKCS12KeyStore$CertId     // Catch: java.io.IOException -> L5c
            byte[] r3 = r3.getKeyIdentifier()     // Catch: java.io.IOException -> L5c
            r5.<init>(r3)     // Catch: java.io.IOException -> L5c
            java.lang.Object r3 = r4.get(r5)     // Catch: java.io.IOException -> L5c
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3     // Catch: java.io.IOException -> L5c
            goto L68
        L5c:
            r9 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L67:
            r3 = r1
        L68:
            if (r3 != 0) goto La5
            java.security.Principal r4 = r2.getIssuerDN()
            java.security.Principal r5 = r2.getSubjectDN()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto La5
            java.util.Hashtable r5 = r8.chainCerts
            java.util.Enumeration r5 = r5.keys()
        L7e:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto La5
            java.util.Hashtable r6 = r8.chainCerts
            java.lang.Object r7 = r5.nextElement()
            java.lang.Object r6 = r6.get(r7)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            java.security.Principal r7 = r6.getSubjectDN()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L7e
            java.security.PublicKey r7 = r6.getPublicKey()     // Catch: java.lang.Exception -> La3
            r2.verify(r7)     // Catch: java.lang.Exception -> La3
            r3 = r6
            goto La5
        La3:
            goto L7e
        La5:
            r0.addElement(r9)
            if (r3 == r9) goto Lad
            r9 = r3
            goto L15
        Lad:
            r9 = r1
            goto L15
        Lb0:
            int r9 = r0.size()
            java.security.cert.Certificate[] r1 = new java.security.cert.Certificate[r9]
            r2 = 0
        Lb7:
            if (r2 == r9) goto Lc4
            java.lang.Object r3 = r0.elementAt(r2)
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3
            r1[r2] = r3
            int r2 = r2 + 1
            goto Lb7
        Lc4:
            return r1
        Lc5:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "null alias passed to getCertificateChain."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKPKCS12KeyStore.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.certs.get(str) != null && this.keys.get(str) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.keys.get(str) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00db  */
    /* JADX WARN: Type inference failed for: r1v42, types: [org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier] */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v42 */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void engineLoad(java.io.InputStream r20, char[] r21) {
        /*
            Method dump skipped, instructions count: 1463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JDKPKCS12KeyStore.engineLoad(java.io.InputStream, char[]):void");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) {
        if (this.keys.get(str) == null) {
            this.certs.put(str, certificate);
            this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException(outline.m265f("There is a key entry with the name ", str, "."));
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration keys = this.certs.keys();
        while (keys.hasMoreElements()) {
            hashtable.put(keys.nextElement(), "cert");
        }
        Enumeration keys2 = this.keys.keys();
        while (keys2.hasMoreElements()) {
            String str = (String) keys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) {
        char[] password;
        if (loadStoreParameter != null) {
            if (loadStoreParameter instanceof JDKPKCS12StoreParameter) {
                JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
                KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
                if (protectionParameter == null) {
                    password = null;
                } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
                    password = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                } else {
                    StringBuilder m253r = outline.m253r("No support for protection parameter of type ");
                    m253r.append(protectionParameter.getClass().getName());
                    throw new IllegalArgumentException(m253r.toString());
                }
                doStore(jDKPKCS12StoreParameter.getOutputStream(), password, jDKPKCS12StoreParameter.isUseDEREncoding());
                return;
            }
            StringBuilder m253r2 = outline.m253r("No support for 'param' of type ");
            m253r2.append(loadStoreParameter.getClass().getName());
            throw new IllegalArgumentException(m253r2.toString());
        }
        throw new IllegalArgumentException("'param' arg cannot be null");
    }

    @Override // org.spongycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) {
        String id = algorithmIdentifier.getAlgorithm().getId();
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(id, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            SecretKey generateSecret = secretKeyFactory.generateSecret(pBEKeySpec);
            ((BCPBEKey) generateSecret).setTryWrongPKCS12Zero(z);
            Cipher cipher = Cipher.getInstance(id, provider);
            cipher.init(4, generateSecret, pBEParameterSpec);
            return (PrivateKey) cipher.unwrap(bArr, "", 2);
        } catch (Exception e) {
            throw new IOException(outline.m275F(e, outline.m253r("exception unwrapping private key - ")));
        }
    }

    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(str, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher cipher = Cipher.getInstance(str, provider);
            cipher.init(3, secretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipher.wrap(key);
        } catch (Exception e) {
            throw new IOException(outline.m275F(e, outline.m253r("exception encrypting data - ")));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class CertId {

        /* renamed from: id */
        public byte[] f6109id;

        public CertId(PublicKey publicKey) {
            this.f6109id = JDKPKCS12KeyStore.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CertId) {
                return Arrays.areEqual(this.f6109id, ((CertId) obj).f6109id);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f6109id);
        }

        public CertId(byte[] bArr) {
            this.f6109id = bArr;
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) {
        if ((key instanceof PrivateKey) && certificateArr == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.keys.get(str) != null) {
            engineDeleteEntry(str);
        }
        this.keys.put(str, key);
        this.certs.put(str, certificateArr[0]);
        for (int i = 0; i != certificateArr.length; i++) {
            this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) {
        doStore(outputStream, cArr, false);
    }
}
