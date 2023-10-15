package fr.smoney.android.izly.p005ui.privateview.plus.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.about.legalmentions.LegalMentionsActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.about.supportinformation.SupportInformationActivity;
import fr.smoney.android.izly.p005ui.privateview.plus.about.whoweare.WhoWeAreActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.about.AboutActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AboutActivity extends SmoneyABSActivity<AbstractC2025o9> implements View.OnClickListener {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492892;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        if (C0581Yd.m1770a(view, ((AbstractC2025o9) this.f4202w).f5590a)) {
            startActivity(new Intent(this, LegalMentionsActivity.class));
        } else if (C0581Yd.m1770a(view, ((AbstractC2025o9) this.f4202w).f5592c)) {
            startActivity(new Intent(this, WhoWeAreActivity.class));
        } else if (C0581Yd.m1770a(view, ((AbstractC2025o9) this.f4202w).f5591b)) {
            startActivity(new Intent(this, SupportInformationActivity.class));
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689503), "getString(R.string.about_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230988, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, true);
        ((AbstractC2025o9) this.f4202w).f5590a.setOnClickListener(this);
        ((AbstractC2025o9) this.f4202w).f5592c.setOnClickListener(this);
        ((AbstractC2025o9) this.f4202w).f5591b.setOnClickListener(this);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }
}
