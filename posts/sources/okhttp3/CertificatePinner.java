package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            Objects.requireNonNull(str, "pattern == null");
            for (String str2 : strArr) {
                this.pins.add(new Pin(str, str2));
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), null);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Pin {
        private static final String WILDCARD = "*.";
        public final String canonicalHostname;
        public final C2011ne hash;
        public final String hashAlgorithm;
        public final String pattern;

        public Pin(String str, String str2) {
            String host;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                StringBuilder m253r = outline.m253r("http://");
                m253r.append(str.substring(2));
                host = HttpUrl.parse(m253r.toString()).host();
            } else {
                host = HttpUrl.parse("http://" + str).host();
            }
            this.canonicalHostname = host;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = C2011ne.m561b(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = C2011ne.m561b(str2.substring(7));
            } else {
                throw new IllegalArgumentException(outline.m266e("pins must start with 'sha256/' or 'sha1/': ", str2));
            }
            if (this.hash == null) {
                throw new IllegalArgumentException(outline.m266e("pins must be base64: ", str2));
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.hashAlgorithm.hashCode();
            return this.hash.hashCode() + ((hashCode + ((this.pattern.hashCode() + 527) * 31)) * 31);
        }

        public boolean matches(String str) {
            if (this.pattern.startsWith(WILDCARD)) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.canonicalHostname.length()) {
                    String str2 = this.canonicalHostname;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.canonicalHostname);
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.mo562a();
        }
    }

    public CertificatePinner(Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder m253r = outline.m253r("sha256/");
            m253r.append(sha256((X509Certificate) certificate).mo562a());
            return m253r.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static C2011ne sha1(X509Certificate x509Certificate) {
        return C2011ne.m554i(x509Certificate.getPublicKey().getEncoded()).mo551l();
    }

    public static C2011ne sha256(X509Certificate x509Certificate) {
        return C2011ne.m554i(x509Certificate.getPublicKey().getEncoded()).m558e("SHA-256");
    }

    public void check(String str, List<Certificate> list) {
        List<Pin> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.clean(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = findMatchingPins.size();
            C2011ne c2011ne = null;
            C2011ne c2011ne2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                Pin pin = findMatchingPins.get(i2);
                if (pin.hashAlgorithm.equals("sha256/")) {
                    if (c2011ne == null) {
                        c2011ne = sha256(x509Certificate);
                    }
                    if (pin.hash.equals(c2011ne)) {
                        return;
                    }
                } else if (pin.hashAlgorithm.equals("sha1/")) {
                    if (c2011ne2 == null) {
                        c2011ne2 = sha1(x509Certificate);
                    }
                    if (pin.hash.equals(c2011ne2)) {
                        return;
                    }
                } else {
                    StringBuilder m253r = outline.m253r("unsupported hashAlgorithm: ");
                    m253r.append(pin.hashAlgorithm);
                    throw new AssertionError(m253r.toString());
                }
            }
        }
        StringBuilder m252s = outline.m252s("Certificate pinning failure!", "\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            m252s.append("\n    ");
            m252s.append(pin(x509Certificate2));
            m252s.append(": ");
            m252s.append(x509Certificate2.getSubjectDN().getName());
        }
        m252s.append("\n  Pinned certificates for ");
        m252s.append(str);
        m252s.append(":");
        int size4 = findMatchingPins.size();
        for (int i4 = 0; i4 < size4; i4++) {
            m252s.append("\n    ");
            m252s.append(findMatchingPins.get(i4));
        }
        throw new SSLPeerUnverifiedException(m252s.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner) && this.pins.equals(certificatePinner.pins)) {
                return true;
            }
        }
        return false;
    }

    public List<Pin> findMatchingPins(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return this.pins.hashCode() + ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31);
    }

    public CertificatePinner withCertificateChainCleaner(@Nullable CertificateChainCleaner certificateChainCleaner) {
        return Util.equal(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public void check(String str, Certificate... certificateArr) {
        check(str, Arrays.asList(certificateArr));
    }
}
