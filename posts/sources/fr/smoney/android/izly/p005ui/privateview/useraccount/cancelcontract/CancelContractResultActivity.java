package fr.smoney.android.izly.p005ui.privateview.useraccount.cancelcontract;

import android.os.Bundle;
import android.view.View;
import fr.smoney.android.izly.SmoneyABSActivity;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.cancelcontract.CancelContractResultActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CancelContractResultActivity extends SmoneyABSActivity<AbstractC0994ca> implements View.OnClickListener {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492915;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f4197r.m119d(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        if (C0581Yd.m1770a(view, ((AbstractC0994ca) this.f4202w).f3800b)) {
            this.f4197r.m119d(true);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690100), "getString(R.string.resiliation_compte)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_RED, false, false);
        ((AbstractC0994ca) this.f4202w).f3800b.setOnClickListener(this);
    }
}
