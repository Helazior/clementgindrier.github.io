package p000;

import android.content.DialogInterface;
import android.os.Bundle;

/* renamed from: ed */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1668ed extends DialogInterface$OnCancelListenerC0110E5 {

    /* renamed from: a */
    public EnumC1631dd f4163a;

    /* renamed from: b */
    public InterfaceC1669a f4164b;

    /* renamed from: c */
    public boolean f4165c;

    /* renamed from: ed$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1669a {
        /* renamed from: d */
        void mo241d(EnumC1631dd enumC1631dd);

        /* renamed from: h */
        void mo239h(EnumC1631dd enumC1631dd);

        /* renamed from: k */
        void mo238k(EnumC1631dd enumC1631dd, Bundle bundle);

        /* renamed from: l */
        void mo237l(EnumC1631dd enumC1631dd);
    }

    /* renamed from: m */
    public final Bundle m991m(InterfaceC1669a interfaceC1669a, EnumC1631dd enumC1631dd) {
        Bundle bundle = new Bundle();
        this.f4164b = interfaceC1669a;
        bundle.putSerializable("Argument.DialogFragmentType", enumC1631dd);
        bundle.putBoolean("Argument.DialogCallbackDefined", true);
        return bundle;
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        InterfaceC1669a interfaceC1669a;
        super.onCancel(dialogInterface);
        if (!this.f4165c || (interfaceC1669a = this.f4164b) == null) {
            return;
        }
        interfaceC1669a.mo239h(this.f4163a);
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f4163a = (EnumC1631dd) arguments.getSerializable("Argument.DialogFragmentType");
        this.f4165c = arguments.getBoolean("Argument.DialogCallbackDefined");
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onDetach() {
        this.f4164b = null;
        super.onDetach();
    }

    /* renamed from: r */
    public final void m990r(Bundle bundle) {
        InterfaceC1669a interfaceC1669a;
        if (!this.f4165c || (interfaceC1669a = this.f4164b) == null) {
            return;
        }
        interfaceC1669a.mo238k(this.f4163a, null);
    }
}
