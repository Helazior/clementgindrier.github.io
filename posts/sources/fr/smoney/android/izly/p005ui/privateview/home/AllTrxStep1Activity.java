package fr.smoney.android.izly.p005ui.privateview.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.IconButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.BalanceData;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1668ed;

/* renamed from: fr.smoney.android.izly.ui.privateview.home.AllTrxStep1Activity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AllTrxStep1Activity extends SmoneyABSActivity<AbstractC2028oc> implements AbstractC1668ed.InterfaceC1669a, CustomAmountToogleButtonView.InterfaceC1818a {
    @Nullable

    /* renamed from: A */
    public static String f4781A;

    /* renamed from: x */
    public boolean f4782x;

    /* renamed from: y */
    public boolean f4783y;
    @Nullable

    /* renamed from: z */
    public SessionStateReceiver f4784z;

    /* renamed from: fr.smoney.android.izly.ui.privateview.home.AllTrxStep1Activity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1794a implements InterfaceC1879hd {
        public C1794a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 0) {
                AllTrxStep1Activity allTrxStep1Activity = AllTrxStep1Activity.this;
                String str = AllTrxStep1Activity.f4781A;
                allTrxStep1Activity.m979K();
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493076;
    }

    /* renamed from: L */
    public double m908L() {
        return ((AbstractC2028oc) this.f4202w).f5606a.m832a(this.f4197r);
    }

    /* renamed from: M */
    public void m907M(@NotNull int[] iArr, double d, double d2, @NotNull String str) {
        C0581Yd.m1766e(iArr, "amountStep");
        C0581Yd.m1766e(str, "amountLimitInfoMsg");
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        CustomAmountToogleButtonView customAmountToogleButtonView = ((AbstractC2028oc) this.f4202w).f5606a;
        C0479U8 c0479u8 = this.f4197r.f6816a;
        customAmountToogleButtonView.f4957f = this;
        customAmountToogleButtonView.m827f(Currency.getInstance(c0479u8.f1712b.f4371k).getSymbol(), arrayList);
        customAmountToogleButtonView.m828e();
        customAmountToogleButtonView.f4959h = str;
        if (d != -1.0d && d2 != -1.0d) {
            customAmountToogleButtonView.f4954b.setHint(str);
        } else {
            customAmountToogleButtonView.f4954b.setHint(2131689546);
        }
    }

    /* renamed from: N */
    public void m906N(@Nullable BalanceData balanceData) {
        this.f4197r.f6816a.f1712b.f4351D = balanceData;
    }

    /* renamed from: O */
    public void m905O(double d, @NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Resources resources = getResources();
        C0581Yd.m1767d(resources, "resources");
        double d2 = resources.getDisplayMetrics().widthPixels * 0.285d * 2 * d;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i = (int) (d2 + 50);
        layoutParams.height = i / 2;
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.AlertType) {
            finish();
        } else {
            this.f4197r.m102u(enumC1631dd);
        }
    }

    /* renamed from: j */
    public void mo826j(boolean z) {
        boolean z2 = z && m908L() >= this.f4197r.f6816a.f1712b.f4367g && m908L() <= this.f4197r.f6816a.f1712b.f4368h && this.f4782x && this.f4783y;
        IconButton iconButton = ((AbstractC2028oc) this.f4202w).f5608c.f6633a;
        C0581Yd.m1767d(iconButton, "mDataBinding.bSubmit.bSubmit");
        iconButton.setEnabled(z2);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(32);
        overridePendingTransition(2130771986, 2130771987);
        this.f4784z = new SessionStateReceiver(this, new C1794a());
        Currency currency = Currency.getInstance(this.f4197r.f6816a.f1712b.f4371k);
        C0581Yd.m1767d(currency, "Currency.getInstance(mem…r.loginData.currencyCode)");
        f4781A = currency.getSymbol();
        LinearLayout linearLayout = ((AbstractC2028oc) this.f4202w).f5612h;
        C0581Yd.m1767d(linearLayout, "mDataBinding.firstCircle");
        m905O(1.4d, linearLayout);
        LinearLayout linearLayout2 = ((AbstractC2028oc) this.f4202w).f5615k;
        C0581Yd.m1767d(linearLayout2, "mDataBinding.secondCircle");
        m905O(1.85d, linearLayout2);
        LinearLayout linearLayout3 = ((AbstractC2028oc) this.f4202w).f5619o;
        C0581Yd.m1767d(linearLayout3, "mDataBinding.thirdCircle");
        m905O(2.6d, linearLayout3);
        ImageView imageView = ((AbstractC2028oc) this.f4202w).f5609d;
        C0581Yd.m1767d(imageView, "mDataBinding.bigSquare");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Resources resources = getResources();
        C0581Yd.m1767d(resources, "resources");
        layoutParams.height = ((int) (((resources.getDisplayMetrics().widthPixels * 0.285d) * 2) * 1.55d)) - 25;
        ImageView imageView2 = ((AbstractC2028oc) this.f4202w).f5609d;
        C0581Yd.m1767d(imageView2, "mDataBinding.bigSquare");
        imageView2.setLayoutParams(layoutParams);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        finish();
        return true;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f4784z;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        SessionStateReceiver sessionStateReceiver = this.f4784z;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
        super.onResume();
    }
}
