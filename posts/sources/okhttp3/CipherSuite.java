package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import org.kxml2.wap.Wbxml;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CipherSuite {
    private static final Map<String, CipherSuite> INSTANCES;
    public static final Comparator<String> ORDER_BY_NAME;
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    public static final CipherSuite TLS_FALLBACK_SCSV;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA;
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5;
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA;
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256;
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5;
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA;
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
    public final String javaName;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: okhttp3.CipherSuite.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                int min = Math.min(str.length(), str2.length());
                for (int i = 4; i < min; i++) {
                    char charAt = str.charAt(i);
                    char charAt2 = str2.charAt(i);
                    if (charAt != charAt2) {
                        return charAt < charAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        ORDER_BY_NAME = comparator;
        INSTANCES = new TreeMap(comparator);
        TLS_RSA_WITH_NULL_MD5 = m532of("SSL_RSA_WITH_NULL_MD5", 1);
        TLS_RSA_WITH_NULL_SHA = m532of("SSL_RSA_WITH_NULL_SHA", 2);
        TLS_RSA_EXPORT_WITH_RC4_40_MD5 = m532of("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        TLS_RSA_WITH_RC4_128_MD5 = m532of("SSL_RSA_WITH_RC4_128_MD5", 4);
        TLS_RSA_WITH_RC4_128_SHA = m532of("SSL_RSA_WITH_RC4_128_SHA", 5);
        TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = m532of("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        TLS_RSA_WITH_DES_CBC_SHA = m532of("SSL_RSA_WITH_DES_CBC_SHA", 9);
        TLS_RSA_WITH_3DES_EDE_CBC_SHA = m532of("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = m532of("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        TLS_DHE_DSS_WITH_DES_CBC_SHA = m532of("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = m532of("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = m532of("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        TLS_DHE_RSA_WITH_DES_CBC_SHA = m532of("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = m532of("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = m532of("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        TLS_DH_anon_WITH_RC4_128_MD5 = m532of("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = m532of("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        TLS_DH_anon_WITH_DES_CBC_SHA = m532of("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = m532of("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        TLS_KRB5_WITH_DES_CBC_SHA = m532of("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        TLS_KRB5_WITH_3DES_EDE_CBC_SHA = m532of("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        TLS_KRB5_WITH_RC4_128_SHA = m532of("TLS_KRB5_WITH_RC4_128_SHA", 32);
        TLS_KRB5_WITH_DES_CBC_MD5 = m532of("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = m532of("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        TLS_KRB5_WITH_RC4_128_MD5 = m532of("TLS_KRB5_WITH_RC4_128_MD5", 36);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = m532of("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        TLS_KRB5_EXPORT_WITH_RC4_40_SHA = m532of("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = m532of("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = m532of("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        TLS_RSA_WITH_AES_128_CBC_SHA = m532of("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA = m532of("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA = m532of("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        TLS_DH_anon_WITH_AES_128_CBC_SHA = m532of("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        TLS_RSA_WITH_AES_256_CBC_SHA = m532of("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA = m532of("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA = m532of("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        TLS_DH_anon_WITH_AES_256_CBC_SHA = m532of("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        TLS_RSA_WITH_NULL_SHA256 = m532of("TLS_RSA_WITH_NULL_SHA256", 59);
        TLS_RSA_WITH_AES_128_CBC_SHA256 = m532of("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        TLS_RSA_WITH_AES_256_CBC_SHA256 = m532of("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = m532of("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = m532of("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = m532of("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = m532of("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = m532of("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = m532of("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = m532of("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        TLS_DH_anon_WITH_AES_128_CBC_SHA256 = m532of("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        TLS_DH_anon_WITH_AES_256_CBC_SHA256 = m532of("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = m532of("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Wbxml.LITERAL_A);
        TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = m532of("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = m532of("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        TLS_PSK_WITH_RC4_128_SHA = m532of("TLS_PSK_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_PSK_WITH_RC4_128_SHA);
        TLS_PSK_WITH_3DES_EDE_CBC_SHA = m532of("TLS_PSK_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA);
        TLS_PSK_WITH_AES_128_CBC_SHA = m532of("TLS_PSK_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        TLS_PSK_WITH_AES_256_CBC_SHA = m532of("TLS_PSK_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA);
        TLS_RSA_WITH_SEED_CBC_SHA = m532of("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        TLS_RSA_WITH_AES_128_GCM_SHA256 = m532of("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        TLS_RSA_WITH_AES_256_GCM_SHA384 = m532of("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = m532of("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = m532of("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = m532of("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = m532of("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        TLS_DH_anon_WITH_AES_128_GCM_SHA256 = m532of("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        TLS_DH_anon_WITH_AES_256_GCM_SHA384 = m532of("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        TLS_EMPTY_RENEGOTIATION_INFO_SCSV = m532of("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        TLS_FALLBACK_SCSV = m532of("TLS_FALLBACK_SCSV", 22016);
        TLS_ECDH_ECDSA_WITH_NULL_SHA = m532of("TLS_ECDH_ECDSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_NULL_SHA);
        TLS_ECDH_ECDSA_WITH_RC4_128_SHA = m532of("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA);
        TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = m532of("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = m532of("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = m532of("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_NULL_SHA = m532of("TLS_ECDHE_ECDSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_NULL_SHA);
        TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = m532of("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA);
        TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = m532of("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = m532of("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = m532of("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
        TLS_ECDH_RSA_WITH_NULL_SHA = m532of("TLS_ECDH_RSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_NULL_SHA);
        TLS_ECDH_RSA_WITH_RC4_128_SHA = m532of("TLS_ECDH_RSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA);
        TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = m532of("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = m532of("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = m532of("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_RSA_WITH_NULL_SHA = m532of("TLS_ECDHE_RSA_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_NULL_SHA);
        TLS_ECDHE_RSA_WITH_RC4_128_SHA = m532of("TLS_ECDHE_RSA_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA);
        TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = m532of("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = m532of("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = m532of("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        TLS_ECDH_anon_WITH_NULL_SHA = m532of("TLS_ECDH_anon_WITH_NULL_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_NULL_SHA);
        TLS_ECDH_anon_WITH_RC4_128_SHA = m532of("TLS_ECDH_anon_WITH_RC4_128_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_RC4_128_SHA);
        TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = m532of("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA);
        TLS_ECDH_anon_WITH_AES_128_CBC_SHA = m532of("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
        TLS_ECDH_anon_WITH_AES_256_CBC_SHA = m532of("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
        TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = m532of("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = m532of("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = m532of("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = m532of("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = m532of("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = m532of("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = m532of("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256);
        TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = m532of("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384);
        TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = m532of("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = m532of("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = m532of("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = m532of("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = m532of("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = m532of("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = m532of("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256);
        TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = m532of("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", org.spongycastle.crypto.tls.CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384);
        TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = m532of("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = m532of("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = m532of("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = m532of("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private CipherSuite(String str) {
        Objects.requireNonNull(str);
        this.javaName = str;
    }

    public static synchronized CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite;
        synchronized (CipherSuite.class) {
            Map<String, CipherSuite> map = INSTANCES;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = new CipherSuite(str);
                map.put(str, cipherSuite);
            }
        }
        return cipherSuite;
    }

    public static List<CipherSuite> forJavaNames(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: of */
    private static CipherSuite m532of(String str, int i) {
        return forJavaName(str);
    }

    public String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
