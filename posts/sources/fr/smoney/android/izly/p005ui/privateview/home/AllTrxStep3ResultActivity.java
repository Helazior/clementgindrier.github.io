package fr.smoney.android.izly.p005ui.privateview.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.IconButton;
import android.widget.TextView;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.items.KeyValueObject;
import fr.smoney.android.izly.data.model.MakeMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.MoneyInCbConfirmData;
import fr.smoney.android.izly.data.model.MoneyOutTransferConfirmData;
import fr.smoney.android.izly.p005ui.widget.CustomDetailBodyView;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.home.AllTrxStep3ResultActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AllTrxStep3ResultActivity extends SmoneyABSActivity<AbstractC2239sc> implements View.OnClickListener {

    /* renamed from: A */
    public AllTrxWorkFlowObject f4794A;
    @NotNull

    /* renamed from: x */
    public final String f4795x = "fr.smoney.android.izly.extras.trxWorkflowObject";
    @NotNull

    /* renamed from: y */
    public final String f4796y = "fr.smoney.android.izly.extras.trxWorkflowExtraObject";

    /* renamed from: z */
    public Object f4797z;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493078;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f4197r.m129B();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "v");
        if (view == ((AbstractC2239sc) this.f4202w).f6410b) {
            this.f4197r.m129B();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z;
        boolean z2;
        super.onCreate(bundle);
        overridePendingTransition(2130771986, 2130771987);
        Intent intent = getIntent();
        if (intent != null) {
            this.f4797z = intent.getParcelableExtra(this.f4796y);
            this.f4794A = (AllTrxWorkFlowObject) intent.getParcelableExtra(this.f4795x);
        }
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689524);
        C0581Yd.m1767d(string, "getString(R.string.accuse_reception)");
        String upperCase = string.toUpperCase();
        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase()");
        c0297a.m2194a(this, upperCase, 2131230939, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, false, false);
        ((AbstractC2239sc) this.f4202w).f6410b.setOnClickListener(this);
        AllTrxWorkFlowObject allTrxWorkFlowObject = this.f4794A;
        C0581Yd.m1768c(allTrxWorkFlowObject);
        EnumC0115E8 enumC0115E8 = allTrxWorkFlowObject.f4799b;
        if (enumC0115E8 == null) {
            return;
        }
        int ordinal = enumC0115E8.ordinal();
        if (ordinal == 0) {
            MoneyInCbConfirmData moneyInCbConfirmData = (MoneyInCbConfirmData) this.f4797z;
            TextView textView = (TextView) findViewById(2131296982);
            C0581Yd.m1767d(textView, "tvInfo");
            textView.setVisibility(0);
            Currency currency = Currency.getInstance(this.f4197r.f6816a.f1712b.f4371k);
            C0581Yd.m1767d(currency, "Currency.getInstance(mem…r.loginData.currencyCode)");
            String symbol = currency.getSymbol();
            ArrayList<KeyValueObject> arrayList = new ArrayList<>();
            String string2 = getString(2131689544);
            C0581Yd.m1768c(moneyInCbConfirmData);
            arrayList.add(new KeyValueObject(string2, outline.m254q(new Object[]{Double.valueOf(moneyInCbConfirmData.f4426a.f4416f), symbol}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            String string3 = getString(2131689586);
            AllTrxWorkFlowObject allTrxWorkFlowObject2 = this.f4794A;
            C0581Yd.m1768c(allTrxWorkFlowObject2);
            arrayList.add(new KeyValueObject(string3, allTrxWorkFlowObject2.f4802f));
            arrayList.add(new KeyValueObject(getString(2131689741), C0278Ld.m2214d(this, moneyInCbConfirmData.f4426a.f4413b)));
            double d = moneyInCbConfirmData.f4432h.f4231b;
            if (d > 0) {
                z = true;
                arrayList.add(new KeyValueObject(getString(2131690098), outline.m254q(new Object[]{Double.valueOf(d), symbol}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            } else {
                z = true;
            }
            this.f4197r.f6816a.f1681B0 = z;
            View findViewById = findViewById(2131296982);
            C0581Yd.m1767d(findViewById, "findViewById<View>(R.id.tv_info_trx3)");
            findViewById.setVisibility(0);
            ((AbstractC2239sc) this.f4202w).f6412d.m819a(arrayList);
        } else if (ordinal == 1) {
            MakeMoneyInBankAccountData makeMoneyInBankAccountData = (MakeMoneyInBankAccountData) this.f4797z;
            C0479U8 c0479u8 = this.f4197r.f6816a;
            Currency currency2 = Currency.getInstance(c0479u8.f1712b.f4371k);
            C0581Yd.m1767d(currency2, "Currency.getInstance(mMe…r.loginData.currencyCode)");
            String symbol2 = currency2.getSymbol();
            BigDecimal bigDecimal = new BigDecimal(c0479u8.f1712b.f4351D.f4230a);
            C0581Yd.m1768c(makeMoneyInBankAccountData);
            BigDecimal bigDecimal2 = new BigDecimal(makeMoneyInBankAccountData.f4403b);
            ArrayList<KeyValueObject> arrayList2 = new ArrayList<>();
            arrayList2.add(new KeyValueObject(getString(2131689544), outline.m254q(new Object[]{Double.valueOf(bigDecimal2.doubleValue()), symbol2}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            arrayList2.add(new KeyValueObject(getString(2131689741), C0278Ld.m2215c(this, C0278Ld.m2212f(makeMoneyInBankAccountData.f4402a), true, true, false, false)));
            arrayList2.add(new KeyValueObject(getString(2131689689), outline.m254q(new Object[]{Double.valueOf(bigDecimal.doubleValue()), symbol2}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            arrayList2.add(new KeyValueObject(getString(2131689688), outline.m254q(new Object[]{Double.valueOf(bigDecimal2.doubleValue() + bigDecimal.doubleValue()), symbol2}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            double d2 = c0479u8.f1712b.f4351D.f4231b;
            if (d2 > 0) {
                arrayList2.add(new KeyValueObject(getString(2131690098), outline.m254q(new Object[]{Double.valueOf(d2), symbol2}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            }
            ((AbstractC2239sc) this.f4202w).f6412d.m819a(arrayList2);
            this.f4197r.f6816a.f1681B0 = true;
        } else if (ordinal == 2) {
            CustomDetailBodyView customDetailBodyView = ((AbstractC2239sc) this.f4202w).f6412d;
            AllTrxWorkFlowObject allTrxWorkFlowObject3 = this.f4794A;
            C0581Yd.m1768c(allTrxWorkFlowObject3);
            customDetailBodyView.m819a(allTrxWorkFlowObject3.f4798a);
            IconButton iconButton = ((AbstractC2239sc) this.f4202w).f6410b;
            C0581Yd.m1767d(iconButton, "mDataBinding.btnClose");
            iconButton.setVisibility(0);
        } else if (ordinal != 3) {
        } else {
            MoneyOutTransferConfirmData moneyOutTransferConfirmData = (MoneyOutTransferConfirmData) this.f4797z;
            TextView textView2 = (TextView) findViewById(2131297001);
            C0581Yd.m1767d(textView2, "tvInfo");
            textView2.setVisibility(8);
            Currency currency3 = Currency.getInstance(this.f4197r.f6816a.f1712b.f4371k);
            C0581Yd.m1767d(currency3, "Currency.getInstance(mem…r.loginData.currencyCode)");
            String symbol3 = currency3.getSymbol();
            ArrayList<KeyValueObject> arrayList3 = new ArrayList<>();
            String string4 = getString(2131690242);
            C0581Yd.m1768c(moneyOutTransferConfirmData);
            arrayList3.add(new KeyValueObject(string4, moneyOutTransferConfirmData.f4444c));
            arrayList3.add(new KeyValueObject(getString(2131689544), outline.m254q(new Object[]{Double.valueOf(moneyOutTransferConfirmData.f4446f), symbol3}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            arrayList3.add(new KeyValueObject(getString(2131689741), new SimpleDateFormat("EEEE dd MMMM yyyy 'à' HH'h'mm", Locale.getDefault()).format(Long.valueOf(moneyOutTransferConfirmData.f4443b))));
            double d3 = 0;
            if (moneyOutTransferConfirmData.f4448h > d3) {
                String string5 = getString(2131689969);
                String format = String.format(Locale.getDefault(), "%1$.2f%2$s", Arrays.copyOf(new Object[]{Double.valueOf(moneyOutTransferConfirmData.f4448h), symbol3}, 2));
                C0581Yd.m1767d(format, "java.lang.String.format(locale, format, *args)");
                arrayList3.add(new KeyValueObject(string5, format));
            }
            double d4 = this.f4197r.f6816a.f1712b.f4351D.f4230a;
            arrayList3.add(new KeyValueObject(getString(2131689689), outline.m254q(new Object[]{Double.valueOf(moneyOutTransferConfirmData.f4446f + d4), symbol3}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            arrayList3.add(new KeyValueObject(getString(2131689688), outline.m254q(new Object[]{Double.valueOf(d4), symbol3}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            double d5 = this.f4197r.f6816a.f1712b.f4351D.f4231b;
            if (d5 > d3) {
                z2 = true;
                arrayList3.add(new KeyValueObject(getString(2131690098), outline.m254q(new Object[]{Double.valueOf(d5), symbol3}, 2, "%1$.2f%2$s", "java.lang.String.format(format, *args)")));
            } else {
                z2 = true;
            }
            this.f4197r.f6816a.f1685D0 = z2;
            ((AbstractC2239sc) this.f4202w).f6412d.m819a(arrayList3);
        }
    }
}
