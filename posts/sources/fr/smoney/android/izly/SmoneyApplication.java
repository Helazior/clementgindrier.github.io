package fr.smoney.android.izly;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import fr.smoney.android.izly.data.model.ActuDetail;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SmoneyApplication extends Application {

    /* renamed from: c */
    public static final String f4204c = SmoneyApplication.class.getSimpleName();

    /* renamed from: d */
    public static C0479U8 f4205d;

    /* renamed from: f */
    public static SmoneyRequestManager f4206f;

    /* renamed from: g */
    public static C0065C8 f4207g;

    /* renamed from: h */
    public static C2408zc f4208h;

    /* renamed from: i */
    public static C0027Ac f4209i;

    /* renamed from: j */
    public static ActuDetail f4210j;

    /* renamed from: a */
    public boolean f4211a;

    /* renamed from: b */
    public boolean f4212b;

    /* renamed from: a */
    public final TrustManager[] m978a(Context context) {
        String[] strArr;
        AssetManager assets = context.getResources().getAssets();
        try {
            strArr = assets.list("certificate_authority");
        } catch (Exception e) {
            e.toString();
            strArr = null;
        }
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        for (int i = 0; i < strArr.length; i++) {
            try {
                m977b(keyStore, assets.open("certificate_authority/" + strArr[i]));
            } catch (IOException e2) {
                e2.toString();
            } catch (KeyStoreException e3) {
                e3.toString();
            } catch (NoSuchAlgorithmException e4) {
                e4.toString();
            } catch (CertificateException e5) {
                e5.toString();
            }
        }
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        return trustManagerFactory.getTrustManagers();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C0062C6.m2512e(this);
    }

    /* renamed from: b */
    public final void m977b(KeyStore keyStore, InputStream inputStream) {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            Certificate generateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
            String str = "ca=" + ((X509Certificate) generateCertificate).getSubjectDN();
            bufferedInputStream.close();
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", generateCertificate);
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }

    /* renamed from: c */
    public void m976c() {
        f4206f = null;
        f4205d = null;
        C2408zc c2408zc = f4208h;
        if (c2408zc != null) {
            ImageLoader imageLoader = c2408zc.f6934a;
            imageLoader.clearMemoryCache();
            imageLoader.clearDiskCache();
            c2408zc.f6934a = null;
            f4208h = null;
        }
        C0065C8 c0065c8 = f4207g;
        if (c0065c8 != null) {
            c0065c8.f295g = null;
            c0065c8.f289a = null;
            c0065c8.f290b = false;
            c0065c8.f292d = null;
            c0065c8.f293e = false;
            f4207g = null;
        }
        C0027Ac c0027Ac = f4209i;
        if (c0027Ac != null) {
            c0027Ac.f155d = null;
            c0027Ac.f152a = null;
            f4209i = null;
        }
        Context applicationContext = getApplicationContext();
        f4205d = new C0479U8();
        f4206f = new SmoneyRequestManager(applicationContext, f4205d);
        f4208h = new C2408zc(applicationContext);
        f4207g = new C0065C8(applicationContext);
        f4209i = new C0027Ac(applicationContext);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        this.f4212b = false;
        m976c();
        try {
            m978a(getApplicationContext());
        } catch (KeyStoreException e) {
            e.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.toString();
        }
    }
}
