package p000;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.p005ui.privateview.plus.about.AboutActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.PreSettingsActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.transfer.TransferStep1Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;
import p000.C0379Qc;

/* renamed from: rd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2219rd extends AbstractC0044B8<AbstractC0438Sb> implements C0379Qc.InterfaceC0380a {
    @Override // p000.C0379Qc.InterfaceC0380a
    /* renamed from: e */
    public void mo418e(@Nullable EnumC0560X8 enumC0560X8) {
        if (enumC0560X8 != null) {
            int ordinal = enumC0560X8.ordinal();
            if (ordinal == 0) {
                startActivity(new Intent(getContext(), TransferStep1Activity.class), null);
            } else if (ordinal == 1) {
                startActivity(new Intent(getContext(), PreSettingsActivity.class));
            } else if (ordinal == 2) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://help.izly.fr/")));
            } else if (ordinal == 3) {
                startActivity(new Intent(getContext(), AboutActivity.class));
            } else if (ordinal != 4) {
                if (ordinal == 5) {
                    throw new IllegalArgumentException();
                }
            } else {
                this.f197b.m126E(C0525Vc.m1826s(getString(2131689919), getString(2131689783), getString(17039370), getString(17039360), this, EnumC1631dd.LogoutType));
            }
        }
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo236m() {
        return 2131493040;
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        String string = getString(2131689571);
        C0581Yd.m1767d(string, "getString(R.string.bottom_nav_bar_icon_plus)");
        c0297a.m2194a(appCompatActivity, string, 2131230938, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, false, (r19 & 128) != 0 ? false : false);
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C0581Yd.m1766e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        LoginData loginData = SmoneyApplication.f4205d.f1712b;
        if (loginData != null) {
            C0581Yd.m1767d(loginData, "mMemoryProvider.loginData");
            if (loginData.f4380t >= 18) {
                EnumC0560X8[] enumC0560X8Arr = {EnumC0560X8.TRANSFER, EnumC0560X8.SETTINGS, EnumC0560X8.HELP, EnumC0560X8.ABOUT, EnumC0560X8.LOGOUT};
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f201g, 1, false);
                AppCompatActivity appCompatActivity = this.f201g;
                C0581Yd.m1767d(appCompatActivity, "mActivity");
                C0379Qc c0379Qc = new C0379Qc(enumC0560X8Arr, appCompatActivity, this);
                RecyclerView recyclerView = ((AbstractC0438Sb) this.f202h).f1433b;
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(c0379Qc);
            } else {
                this.f197b.m126E(C0543Wc.m1819s(getString(2131689791), getString(2131689635), getString(17039370)));
            }
        } else {
            this.f197b.m126E(C0543Wc.m1819s(getString(2131689771), getString(2131689770), getString(17039370)));
        }
        Object obj = this.f202h;
        C0581Yd.m1767d(obj, "mDataBinding");
        return ((AbstractC0438Sb) obj).getRoot();
    }
}
