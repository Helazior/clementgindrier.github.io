package p000;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import p000.AbstractC1668ed;

/* renamed from: Wc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0543Wc extends AbstractC1668ed {

    /* renamed from: h */
    public static final EnumC1631dd f1946h = EnumC1631dd.AlertType;

    /* renamed from: d */
    public String f1947d;

    /* renamed from: f */
    public String f1948f;

    /* renamed from: g */
    public String f1949g;

    /* renamed from: Wc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class DialogInterface$OnClickListenerC0544a implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0544a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractC1668ed.InterfaceC1669a interfaceC1669a;
            C0543Wc c0543Wc = C0543Wc.this;
            if (!c0543Wc.f4165c || (interfaceC1669a = c0543Wc.f4164b) == null) {
                return;
            }
            interfaceC1669a.mo241d(c0543Wc.f4163a);
        }
    }

    /* renamed from: s */
    public static C0543Wc m1819s(String str, String str2, String str3) {
        C0543Wc c0543Wc = new C0543Wc();
        EnumC1631dd enumC1631dd = f1946h;
        Bundle bundle = new Bundle();
        bundle.putSerializable("Argument.DialogFragmentType", enumC1631dd);
        bundle.putBoolean("Argument.DialogCallbackDefined", false);
        bundle.putString("Argument.DialogTitle", str);
        bundle.putString("Argument.DialogMsg", str2);
        bundle.putString("Argument.DialogBtnText", str3);
        c0543Wc.setArguments(bundle);
        return c0543Wc;
    }

    @Override // p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f1947d = arguments.getString("Argument.DialogTitle");
        this.f1948f = arguments.getString("Argument.DialogMsg");
        this.f1949g = arguments.getString("Argument.DialogBtnText");
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(this.f1947d).setMessage(this.f1948f).setNeutralButton(this.f1949g, new DialogInterface$OnClickListenerC0544a()).create();
    }
}
