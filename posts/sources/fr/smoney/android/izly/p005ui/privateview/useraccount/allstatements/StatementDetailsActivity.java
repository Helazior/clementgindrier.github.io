package fr.smoney.android.izly.p005ui.privateview.useraccount.allstatements;

import android.os.Bundle;
import android.view.MenuItem;
import com.pdfview.PDFView;
import fr.smoney.android.izly.SmoneyABSActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.allstatements.StatementDetailsActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class StatementDetailsActivity extends SmoneyABSActivity<AbstractC1846gc> {

    /* renamed from: x */
    public String f4886x;

    /* renamed from: y */
    public final String f4887y = "intentFilePathPDF";

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493055;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689807), "getString(R.string.extract_profile)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, (r19 & 128) != 0 ? false : false);
        if (getIntent().hasExtra(this.f4887y)) {
            this.f4886x = String.valueOf(getIntent().getStringExtra(this.f4887y));
        }
        PDFView pDFView = ((AbstractC1846gc) this.f4202w).f5093b;
        String str = this.f4886x;
        if (str != null) {
            pDFView.fromFile(str).show();
        } else {
            C0581Yd.m1761j("filepath");
            throw null;
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            this.f2196f.m1721a();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
