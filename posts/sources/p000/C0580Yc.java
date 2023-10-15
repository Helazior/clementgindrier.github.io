package p000;

import android.content.Context;
import android.os.Bundle;
import p000.AbstractC1668ed;

/* renamed from: Yc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0580Yc extends C0525Vc {

    /* renamed from: i */
    public static final EnumC1631dd f2060i = EnumC1631dd.ConnexionErrorType;

    /* renamed from: t */
    public static C0580Yc m1772t(Context context, AbstractC1668ed.InterfaceC1669a interfaceC1669a) {
        C0580Yc c0580Yc = new C0580Yc();
        Bundle m991m = c0580Yc.m991m(interfaceC1669a, f2060i);
        m991m.putString("Argument.DialogTitle", context.getString(2131689769));
        m991m.putString("Argument.DialogMsg", context.getString(2131689768));
        m991m.putString("Argument.DialogBtnPositiveText", context.getString(2131689767));
        m991m.putString("Argument.DialogBtnNegativeText", context.getString(17039360));
        c0580Yc.setArguments(m991m);
        return c0580Yc;
    }

    /* renamed from: u */
    public static C0580Yc m1771u(Context context, AbstractC1668ed.InterfaceC1669a interfaceC1669a, EnumC1631dd enumC1631dd) {
        C0580Yc c0580Yc = new C0580Yc();
        Bundle m991m = c0580Yc.m991m(interfaceC1669a, enumC1631dd);
        m991m.putString("Argument.DialogTitle", context.getString(2131689769));
        m991m.putString("Argument.DialogMsg", context.getString(2131689768));
        m991m.putString("Argument.DialogBtnPositiveText", context.getString(2131689767));
        m991m.putString("Argument.DialogBtnNegativeText", context.getString(17039360));
        c0580Yc.setArguments(m991m);
        return c0580Yc;
    }
}
