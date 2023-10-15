package p000;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import p000.AbstractC1668ed;

/* renamed from: Vc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0525Vc extends AbstractC1668ed {

    /* renamed from: d */
    public String f1860d;

    /* renamed from: f */
    public String f1861f;

    /* renamed from: g */
    public String f1862g;

    /* renamed from: h */
    public String f1863h;

    /* renamed from: Vc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class DialogInterface$OnClickListenerC0526a implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0526a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractC1668ed.InterfaceC1669a interfaceC1669a;
            C0525Vc c0525Vc = C0525Vc.this;
            if (!c0525Vc.f4165c || (interfaceC1669a = c0525Vc.f4164b) == null) {
                return;
            }
            interfaceC1669a.mo237l(c0525Vc.f4163a);
        }
    }

    /* renamed from: Vc$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class DialogInterface$OnClickListenerC0527b implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0527b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            C0525Vc.this.m990r(null);
        }
    }

    /* renamed from: s */
    public static C0525Vc m1826s(String str, String str2, String str3, String str4, AbstractC1668ed.InterfaceC1669a interfaceC1669a, EnumC1631dd enumC1631dd) {
        C0525Vc c0525Vc = new C0525Vc();
        Bundle m991m = c0525Vc.m991m(interfaceC1669a, enumC1631dd);
        m991m.putString("Argument.DialogTitle", str);
        m991m.putString("Argument.DialogMsg", str2);
        m991m.putString("Argument.DialogBtnPositiveText", str3);
        m991m.putString("Argument.DialogBtnNegativeText", str4);
        c0525Vc.setArguments(m991m);
        return c0525Vc;
    }

    @Override // p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        setCancelable(false);
        this.f1860d = arguments.getString("Argument.DialogTitle");
        this.f1861f = arguments.getString("Argument.DialogMsg");
        this.f1862g = arguments.getString("Argument.DialogBtnPositiveText");
        this.f1863h = arguments.getString("Argument.DialogBtnNegativeText");
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(this.f1860d).setMessage(this.f1861f).setPositiveButton(this.f1862g, new DialogInterface$OnClickListenerC0527b()).setNegativeButton(this.f1863h, new DialogInterface$OnClickListenerC0526a()).create();
    }
}
