package fr.smoney.android.izly.p005ui.privateview.plus.settings.security.opposite;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import fr.smoney.android.izly.SmoneyABSActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.security.opposite.BlockAccountResultActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class BlockAccountResultActivity extends SmoneyABSActivity<AbstractC0480U9> implements View.OnClickListener {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492911;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "v");
        if (C0581Yd.m1770a(view, ((AbstractC0480U9) this.f4202w).f1762a)) {
            this.f4197r.m119d(false);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ((AbstractC0480U9) this.f4202w).f1762a.setOnClickListener(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        this.f4197r.m119d(false);
        return true;
    }
}
