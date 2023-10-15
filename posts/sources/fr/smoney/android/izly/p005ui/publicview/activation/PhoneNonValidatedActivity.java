package fr.smoney.android.izly.p005ui.publicview.activation;

import android.os.Bundle;
import android.view.KeyEvent;
import fr.smoney.android.izly.SmoneyABSActivity;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.publicview.activation.PhoneNonValidatedActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PhoneNonValidatedActivity extends SmoneyABSActivity<AbstractC0378Qb> {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493039;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131690190);
        C0581Yd.m1767d(string, "getString(R.string.sms_validation_title)");
        c0297a.m2194a(this, string, 2131230962, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, false, false);
        m983F(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        this.f4197r.m119d(true);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }
}
