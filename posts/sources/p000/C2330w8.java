package p000;

import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.LoginData;

/* renamed from: w8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2329w8 extends C2352x8 {
    @Override // p000.C2352x8
    /* renamed from: v */
    public void mo101v() {
        ((SmoneyApplication) this.f6821f.getApplication()).f4211a = false;
        super.mo101v();
    }

    @Override // p000.C2352x8
    /* renamed from: x */
    public void mo99x() {
        super.mo99x();
        m123H();
        SmoneyApplication smoneyApplication = (SmoneyApplication) this.f6821f.getApplication();
        smoneyApplication.f4211a = true;
        if (smoneyApplication.f4212b) {
            return;
        }
        smoneyApplication.f4212b = true;
        LoginData loginData = SmoneyApplication.f4205d.f1712b;
        if (loginData != null) {
            SmoneyApplication.f4206f.m952f(loginData.f4362a, loginData.f4364c);
        }
    }

    @Override // p000.C2352x8
    /* renamed from: z */
    public void mo97z() {
        SmoneyApplication smoneyApplication = (SmoneyApplication) this.f6821f.getApplication();
        if (smoneyApplication.f4211a) {
            return;
        }
        smoneyApplication.f4212b = false;
    }
}
