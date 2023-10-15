package p000;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;

/* renamed from: Zc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0596Zc extends AbstractC1668ed {

    /* renamed from: g */
    public static final EnumC1631dd f2113g = EnumC1631dd.InformationType;
    @NotNull

    /* renamed from: h */
    public static final C0596Zc f2114h = null;

    /* renamed from: d */
    public String f2115d;

    /* renamed from: f */
    public AbstractC0293Ma f2116f;

    /* renamed from: Zc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnClickListenerC0597a implements View.OnClickListener {
        public View$OnClickListenerC0597a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AbstractC1668ed.InterfaceC1669a interfaceC1669a;
            C0596Zc c0596Zc = C0596Zc.this;
            if (!c0596Zc.f4165c || (interfaceC1669a = c0596Zc.f4164b) == null) {
                return;
            }
            interfaceC1669a.mo241d(c0596Zc.f4163a);
        }
    }

    @Override // p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f2115d = String.valueOf(arguments.getString("Argument.DialogTitle"));
        }
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        FragmentActivity activity = getActivity();
        C0581Yd.m1768c(activity);
        C0581Yd.m1767d(activity, "activity!!");
        ViewDataBinding inflate = DataBindingUtil.inflate(activity.getLayoutInflater(), 2131492952, null, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…          false\n        )");
        AbstractC0293Ma abstractC0293Ma = (AbstractC0293Ma) inflate;
        this.f2116f = abstractC0293Ma;
        if (abstractC0293Ma != null) {
            abstractC0293Ma.f984a.setOnClickListener(new View$OnClickListenerC0597a());
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            String str = this.f2115d;
            if (str == null) {
                C0581Yd.m1761j("mTitle");
                throw null;
            }
            AlertDialog.Builder title = builder.setTitle(str);
            AbstractC0293Ma abstractC0293Ma2 = this.f2116f;
            if (abstractC0293Ma2 == null) {
                C0581Yd.m1761j("binding");
                throw null;
            }
            AlertDialog create = title.setView(abstractC0293Ma2.getRoot()).create();
            C0581Yd.m1767d(create, "AlertDialog.Builder(acti…ew(binding.root).create()");
            return create;
        }
        C0581Yd.m1761j("binding");
        throw null;
    }
}
