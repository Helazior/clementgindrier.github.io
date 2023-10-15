package p000;

import android.os.Bundle;
import p000.AbstractC1668ed;

/* renamed from: Xc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0564Xc extends C0543Wc {
    /* renamed from: t */
    public static C0564Xc m1793t(String str, String str2, String str3, AbstractC1668ed.InterfaceC1669a interfaceC1669a, EnumC1631dd enumC1631dd) {
        C0564Xc c0564Xc = new C0564Xc();
        Bundle m991m = c0564Xc.m991m(interfaceC1669a, enumC1631dd);
        m991m.putString("Argument.DialogTitle", str);
        m991m.putString("Argument.DialogMsg", str2);
        m991m.putString("Argument.DialogBtnText", str3);
        c0564Xc.setArguments(m991m);
        return c0564Xc;
    }

    @Override // p000.C0543Wc, p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(false);
    }
}
