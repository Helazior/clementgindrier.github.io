package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mysupports;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.IconTextView;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.items.KeyValueObject;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.Support;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleSpinner;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import java.util.ArrayList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mysupports.DetailSupportActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DetailSupportActivity extends SmoneyABSActivity<AbstractC0253Ka> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener {

    /* renamed from: x */
    public C0462Tc f4848x;

    /* renamed from: y */
    public Support f4849y;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492950;
    }

    /* renamed from: L */
    public final void m874L(@Nullable ServerError serverError) {
        if (serverError != null) {
            if (serverError.f4601b == 120) {
                this.f4197r.m126E(C0543Wc.m1819s(serverError.f4604f, serverError.f4603d, getString(17039370)));
                return;
            }
            this.f4197r.m124G(serverError);
            return;
        }
        setResult(-1);
        finish();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@Nullable EnumC1631dd enumC1631dd) {
        this.f4197r.m102u(enumC1631dd);
        this.f4197r.m106q(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @Nullable Bundle bundle) {
        this.f4197r.m108o(i, i2, i3, bundle);
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i2 == 252) {
            m874L(c0479u8.f1731k0);
        } else if (i2 != 253) {
        } else {
            m874L(c0479u8.f1729j0);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@Nullable EnumC1631dd enumC1631dd) {
        this.f4197r.m106q(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @NotNull Bundle bundle) {
        DetailSupportActivity detailSupportActivity;
        int i;
        int nextInt;
        C0581Yd.m1766e(bundle, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (enumC1631dd == null || enumC1631dd.ordinal() != 7) {
            this.f4197r.m100w(enumC1631dd, bundle);
            return;
        }
        String string = bundle.getString("Data.Password");
        Support support = this.f4849y;
        C0581Yd.m1768c(support);
        if (support.m958b() == null) {
            C2329w8 c2329w8 = this.f4197r;
            C0479U8 c0479u8 = c2329w8.f6816a;
            SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
            LoginData loginData = c0479u8.f1712b;
            String str = loginData.f4362a;
            String str2 = loginData.f4364c;
            Support support2 = this.f4849y;
            C0581Yd.m1768c(support2);
            long j = support2.f4611a;
            CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC0253Ka) this.f4202w).f798h;
            C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.motifLayout");
            Spinner spinner = customBorderSimpleSpinner.f4971a.f6629b;
            C0581Yd.m1767d(spinner, "mDataBinding.motifLayout.spinner");
            Object selectedItem = spinner.getSelectedItem();
            Objects.requireNonNull(selectedItem, "null cannot be cast to non-null type fr.smoney.android.izly.data.items.SupportMotif");
            int i2 = ((EnumC0458T8) selectedItem).f1601a;
            int size = smoneyRequestManager.f4688a.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    Intent valueAt = smoneyRequestManager.f4688a.valueAt(i3);
                    int i4 = size;
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 252 && valueAt.getStringExtra("fr.smoney.android.izly.extras.PutOppositionUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.PutOppositionSessionId").equals(str2)) {
                        nextInt = smoneyRequestManager.f4688a.keyAt(i3);
                        break;
                    } else {
                        i3++;
                        size = i4;
                    }
                } else {
                    nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                    Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                    intent.putExtra("com.foxykeep.datadroid.extras.workerType", 252);
                    intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                    intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                    intent.putExtra("fr.smoney.android.izly.extras.PutOppositionUserId", str);
                    intent.putExtra("fr.smoney.android.izly.extras.PutOppositionSessionId", str2);
                    intent.putExtra("fr.smoney.android.izly.extras.PutOppositionSupportId", j);
                    intent.putExtra("fr.smoney.android.izly.extras.PutOppositionMotif", i2);
                    intent.putExtra("fr.smoney.android.izly.extras.PutOppositionPassword", string);
                    smoneyRequestManager.m956b(intent);
                    smoneyRequestManager.f4688a.append(nextInt, intent);
                    smoneyRequestManager.f4693f.f1731k0 = null;
                    break;
                }
            }
            this.f4197r.m120c(nextInt, 252, true);
            return;
        }
        C2329w8 c2329w82 = this.f4197r;
        C0479U8 c0479u82 = c2329w82.f6816a;
        SmoneyRequestManager smoneyRequestManager2 = c2329w82.f6817b;
        LoginData loginData2 = c0479u82.f1712b;
        String str3 = loginData2.f4362a;
        String str4 = loginData2.f4364c;
        Support support3 = this.f4849y;
        C0581Yd.m1768c(support3);
        long j2 = support3.f4611a;
        int size2 = smoneyRequestManager2.f4688a.size();
        int i5 = 0;
        while (true) {
            if (i5 < size2) {
                Intent valueAt2 = smoneyRequestManager2.f4688a.valueAt(i5);
                int i6 = size2;
                if (valueAt2.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 253 && valueAt2.getStringExtra("fr.smoney.android.izly.extras.RiseOppositionUserId").equals(str3) && valueAt2.getStringExtra("fr.smoney.android.izly.extras.RiseOppositionSessionId").equals(str4)) {
                    i = smoneyRequestManager2.f4688a.keyAt(i5);
                    detailSupportActivity = this;
                    break;
                }
                i5++;
                size2 = i6;
            } else {
                int nextInt2 = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent2 = new Intent(smoneyRequestManager2.f4689b, SmoneyService.class);
                intent2.putExtra("com.foxykeep.datadroid.extras.workerType", 253);
                intent2.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager2.f4692e);
                intent2.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt2);
                intent2.putExtra("fr.smoney.android.izly.extras.RiseOppositionUserId", str3);
                intent2.putExtra("fr.smoney.android.izly.extras.RiseOppositionSessionId", str4);
                intent2.putExtra("fr.smoney.android.izly.extras.RiseOppositionSupportId", j2);
                intent2.putExtra("fr.smoney.android.izly.extras.RiseOppositionPassword", string);
                smoneyRequestManager2.m956b(intent2);
                smoneyRequestManager2.f4688a.append(nextInt2, intent2);
                smoneyRequestManager2.f4693f.f1729j0 = null;
                detailSupportActivity = this;
                i = nextInt2;
                break;
            }
        }
        detailSupportActivity.f4197r.m120c(i, 253, true);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 252) {
            m874L(c0479u8.f1731k0);
        } else if (i != 253) {
        } else {
            m874L(c0479u8.f1729j0);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f2196f.m1721a();
        setResult(-1);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "v");
        Object obj = this.f4202w;
        if (view != ((AbstractC0253Ka) obj).f792a && view != ((AbstractC0253Ka) obj).f793b) {
            if (view == ((AbstractC0253Ka) obj).f794c || view == ((AbstractC0253Ka) obj).f795d) {
                setResult(-1);
                finish();
                return;
            }
            return;
        }
        this.f4197r.m126E(C0617ad.m1725s(this, this));
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        EnumC0161Gd enumC0161Gd = EnumC0161Gd.COLOR_RED;
        EnumC1687fd enumC1687fd = EnumC1687fd.LONG_APPBAR_ONLY_TEXT;
        super.onCreate(bundle);
        if (!getIntent().hasExtra("support_extra")) {
            finish();
        }
        this.f4849y = (Support) getIntent().getParcelableExtra("support_extra");
        getIntent().removeExtra("support_extra");
        IconTextView iconTextView = ((AbstractC0253Ka) this.f4202w).f794c;
        C0581Yd.m1767d(iconTextView, "mDataBinding.bAnuller");
        String string = getString(2131690056);
        C0581Yd.m1767d(string, "getString(R.string.p2p_g…details_b_cancel_request)");
        String upperCase = string.toUpperCase();
        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase()");
        iconTextView.setText(upperCase);
        IconTextView iconTextView2 = ((AbstractC0253Ka) this.f4202w).f795d;
        C0581Yd.m1767d(iconTextView2, "mDataBinding.bAnuller2");
        String string2 = getString(2131690056);
        C0581Yd.m1767d(string2, "getString(R.string.p2p_g…details_b_cancel_request)");
        String upperCase2 = string2.toUpperCase();
        C0581Yd.m1767d(upperCase2, "(this as java.lang.String).toUpperCase()");
        iconTextView2.setText(upperCase2);
        ArrayList<KeyValueObject> arrayList = new ArrayList<>();
        String string3 = getString(2131690219);
        Support support = this.f4849y;
        C0581Yd.m1768c(support);
        EnumC0576Y8 enumC0576Y8 = support.f4612b;
        C0581Yd.m1767d(enumC0576Y8, "mSupport!!.type");
        arrayList.add(new KeyValueObject(string3, getString(enumC0576Y8.f2048a)));
        String.valueOf(this.f4849y);
        Support support2 = this.f4849y;
        if (support2 != null) {
            C0581Yd.m1768c(support2);
            if (support2.f4613c != null) {
                Support support3 = this.f4849y;
                C0581Yd.m1768c(support3);
                if (support3.f4613c.length() > 0) {
                    String string4 = getString(2131689740);
                    Support support4 = this.f4849y;
                    C0581Yd.m1768c(support4);
                    arrayList.add(new KeyValueObject(string4, support4.f4613c));
                }
            }
            Support support5 = this.f4849y;
            C0581Yd.m1768c(support5);
            if (support5.f4612b == EnumC0576Y8.CARD) {
                String string5 = getString(2131690197);
                Support support6 = this.f4849y;
                C0581Yd.m1768c(support6);
                arrayList.add(new KeyValueObject(string5, support6.f4614d));
            }
            Support support7 = this.f4849y;
            C0581Yd.m1768c(support7);
            if (support7.m959a() != null) {
                String string6 = getString(2131689804);
                Support support8 = this.f4849y;
                C0581Yd.m1768c(support8);
                arrayList.add(new KeyValueObject(string6, support8.m959a()));
            }
            Support support9 = this.f4849y;
            C0581Yd.m1768c(support9);
            String str = support9.f4616g;
            if (str != null && str.length() > 0) {
                C0296Md.C0297a c0297a = C0296Md.f999a;
                String string7 = getString(2131690246);
                C0581Yd.m1767d(string7, "getString(R.string.unblock_media)");
                c0297a.m2194a(this, string7, null, null, enumC1687fd, enumC0161Gd, true, false);
                ConstraintLayout constraintLayout = ((AbstractC0253Ka) this.f4202w).f797g;
                C0581Yd.m1767d(constraintLayout, "mDataBinding.containerUnblockSupport");
                constraintLayout.setVisibility(0);
                String string8 = getString(2131690054);
                Support support10 = this.f4849y;
                C0581Yd.m1768c(support10);
                arrayList.add(new KeyValueObject(string8, support10.m958b()));
                Support support11 = this.f4849y;
                C0581Yd.m1768c(support11);
                if (support11.f4617h) {
                    arrayList.add(new KeyValueObject(getString(2131689976), getString(2131690066)));
                    IconTextView iconTextView3 = ((AbstractC0253Ka) this.f4202w).f792a;
                    C0581Yd.m1767d(iconTextView3, "mDataBinding.bAction");
                    iconTextView3.setVisibility(8);
                    CustomFontTextView customFontTextView = ((AbstractC0253Ka) this.f4202w).f799i;
                    C0581Yd.m1767d(customFontTextView, "mDataBinding.riseInstruction");
                    customFontTextView.setVisibility(0);
                } else {
                    IconTextView iconTextView4 = ((AbstractC0253Ka) this.f4202w).f793b;
                    C0581Yd.m1767d(iconTextView4, "mDataBinding.bAction2");
                    String string9 = getString(2131689888);
                    C0581Yd.m1767d(string9, "getString(R.string.i_wish_unblock)");
                    String upperCase3 = string9.toUpperCase();
                    C0581Yd.m1767d(upperCase3, "(this as java.lang.String).toUpperCase()");
                    iconTextView4.setText(upperCase3);
                    String string10 = getString(2131689976);
                    Support support12 = this.f4849y;
                    C0581Yd.m1768c(support12);
                    int i = support12.f4618i;
                    arrayList.add(new KeyValueObject(string10, getString(i != 2 ? i != 3 ? i != 5 ? 2131690030 : 2131689921 : 2131689792 : 2131690195)));
                }
            } else {
                C0296Md.C0297a c0297a2 = C0296Md.f999a;
                String string11 = getString(2131690052);
                C0581Yd.m1767d(string11, "getString(R.string.oppose_media)");
                c0297a2.m2194a(this, string11, null, null, enumC1687fd, enumC0161Gd, true, false);
                C0462Tc c0462Tc = new C0462Tc(this, 2131492974, EnumC0458T8.values());
                this.f4848x = c0462Tc;
                ((AbstractC0253Ka) this.f4202w).f798h.setAdapter(c0462Tc);
                ConstraintLayout constraintLayout2 = ((AbstractC0253Ka) this.f4202w).f796f;
                C0581Yd.m1767d(constraintLayout2, "mDataBinding.containerBlockSupport");
                constraintLayout2.setVisibility(0);
                IconTextView iconTextView5 = ((AbstractC0253Ka) this.f4202w).f792a;
                C0581Yd.m1767d(iconTextView5, "mDataBinding.bAction");
                String string12 = getString(2131689887);
                C0581Yd.m1767d(string12, "getString(R.string.i_wish_oppose)");
                String upperCase4 = string12.toUpperCase();
                C0581Yd.m1767d(upperCase4, "(this as java.lang.String).toUpperCase()");
                iconTextView5.setText(upperCase4);
            }
        }
        ((AbstractC0253Ka) this.f4202w).f800j.m819a(arrayList);
        ((AbstractC0253Ka) this.f4202w).f792a.setOnClickListener(this);
        ((AbstractC0253Ka) this.f4202w).f793b.setOnClickListener(this);
        ((AbstractC0253Ka) this.f4202w).f794c.setOnClickListener(this);
        ((AbstractC0253Ka) this.f4202w).f795d.setOnClickListener(this);
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
}
