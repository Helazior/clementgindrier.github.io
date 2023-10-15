package p000;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import p000.AbstractC1668ed;

/* renamed from: cd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0997cd extends AbstractC1668ed {

    /* renamed from: d */
    public String f3819d;

    /* renamed from: f */
    public CharSequence[] f3820f;

    /* renamed from: cd$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class DialogInterface$OnClickListenerC0998a implements DialogInterface.OnClickListener {
        public DialogInterface$OnClickListenerC0998a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AbstractC1668ed.InterfaceC1669a interfaceC1669a;
            Bundle bundle = new Bundle();
            bundle.putInt("Data.SelectItem", i);
            C0997cd c0997cd = C0997cd.this;
            if (!c0997cd.f4165c || (interfaceC1669a = c0997cd.f4164b) == null) {
                return;
            }
            interfaceC1669a.mo238k(c0997cd.f4163a, bundle);
        }
    }

    /* renamed from: s */
    public static C0997cd m1121s(String str, CharSequence[] charSequenceArr, AbstractC1668ed.InterfaceC1669a interfaceC1669a, EnumC1631dd enumC1631dd) {
        C0997cd c0997cd = new C0997cd();
        Bundle m991m = c0997cd.m991m(interfaceC1669a, enumC1631dd);
        m991m.putString("Argument.DialogTitle", str);
        m991m.putCharSequenceArray("Argument.DialogItems", charSequenceArr);
        c0997cd.setArguments(m991m);
        return c0997cd;
    }

    @Override // p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f3819d = arguments.getString("Argument.DialogTitle");
        this.f3820f = arguments.getCharSequenceArray("Argument.DialogItems");
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public Dialog onCreateDialog(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(this.f3819d).setItems(this.f3820f, new DialogInterface$OnClickListenerC0998a()).create();
    }
}
