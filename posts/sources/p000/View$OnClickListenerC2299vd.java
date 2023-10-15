package p000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.data.model.GetContactDetailsData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.UpdateUserProfileData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mysupports.ListSupportActivity;
import fr.smoney.android.izly.p005ui.privateview.useraccount.allstatements.AllStatementsActivity;
import fr.smoney.android.izly.p005ui.privateview.useraccount.cancelcontract.CancelContractActivity;
import fr.smoney.android.izly.p005ui.privateview.useraccount.eventlist.EventListActivity;
import fr.smoney.android.izly.p005ui.privateview.useraccount.history.HistoryActivity;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleSpinner;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: vd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC2298vd extends AbstractC0044B8<AbstractC0254Kb> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener, TextWatcher {

    /* renamed from: l */
    public GetContactDetailsData f6713l;

    /* renamed from: n */
    public C0295Mc f6715n;

    /* renamed from: o */
    public SessionStateReceiver f6716o;

    /* renamed from: j */
    public final String f6711j = "savedStateContactDetailsData";

    /* renamed from: k */
    public final String f6712k = "dd/MM/yyyy";

    /* renamed from: m */
    public final Time f6714m = new Time();

    /* renamed from: vd$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2299a implements InterfaceC1879hd {
        public C2299a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                View$OnClickListenerC2298vd.this.m233w();
            }
        }
    }

    /* renamed from: vd$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2300b implements AdapterView.OnItemSelectedListener {
        public C2300b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@Nullable AdapterView<?> adapterView, @NotNull View view, int i, long j) {
            C0581Yd.m1766e(view, "view");
            GetContactDetailsData getContactDetailsData = View$OnClickListenerC2298vd.this.f6713l;
            C0581Yd.m1768c(getContactDetailsData);
            EnumC0539W8 enumC0539W8 = EnumC0539W8.f1912H.get(getContactDetailsData.f4326u);
            C0581Yd.m1767d(enumC0539W8, "CountryCode.getCountry(m…actDetailsData!!.country)");
            if (enumC0539W8.f1937a != View$OnClickListenerC2298vd.this.m231y()) {
                View$OnClickListenerC2298vd.this.m242C();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
        }
    }

    /* renamed from: A */
    public final void m244A(UpdateUserProfileData updateUserProfileData, ServerError serverError) {
        if (serverError != null) {
            this.f197b.m124G(serverError);
        } else if (updateUserProfileData == null) {
            this.f197b.m126E(C0580Yc.m1772t(getActivity(), this));
        } else {
            C0479U8 c0479u8 = this.f197b.f6816a;
            if (!c0479u8.f1712b.m969a()) {
                LoginData loginData = c0479u8.f1712b;
                loginData.f4352E = true;
                loginData.f4353F = true;
            }
            this.f197b.m126E(C0543Wc.m1819s(getString(2131690228), getString(2131690019), getString(2131689575)));
        }
    }

    /* renamed from: B */
    public final void m243B() {
        C0479U8 c0479u8 = this.f197b.f6816a;
        TextView textView = ((AbstractC0254Kb) this.f202h).f834y;
        C0581Yd.m1767d(textView, "mDataBinding.tvAppbarName");
        StringBuilder sb = new StringBuilder();
        GetContactDetailsData getContactDetailsData = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData);
        sb.append(getContactDetailsData.f4330y);
        sb.append(" ");
        GetContactDetailsData getContactDetailsData2 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData2);
        String str = getContactDetailsData2.f4331z;
        C0581Yd.m1767d(str, "mContactDetailsData!!.lastName");
        String upperCase = str.toUpperCase();
        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase()");
        sb.append(upperCase);
        textView.setText(sb.toString());
        TextView textView2 = ((AbstractC0254Kb) this.f202h).f833x;
        C0581Yd.m1767d(textView2, "mDataBinding.tvAppbarEmail");
        GetContactDetailsData getContactDetailsData3 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData3);
        textView2.setText(getContactDetailsData3.f4295A);
        TextView textView3 = ((AbstractC0254Kb) this.f202h).f835z;
        C0581Yd.m1767d(textView3, "mDataBinding.tvAppbarPseudo");
        GetContactDetailsData getContactDetailsData4 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData4);
        textView3.setText(getContactDetailsData4.f4308b);
        Time time = this.f6714m;
        GetContactDetailsData getContactDetailsData5 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData5);
        time.set(C0278Ld.m2213e(getContactDetailsData5.f4327v));
        TextView textView4 = ((AbstractC0254Kb) this.f202h).f832w;
        C0581Yd.m1767d(textView4, "mDataBinding.tvAppbarBirth");
        textView4.setText(DateFormat.format(this.f6712k, this.f6714m.toMillis(true)));
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0254Kb) this.f202h).f825p;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.cetAddress");
        GetContactDetailsData getContactDetailsData6 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData6);
        customBorderSimpleEditText.setText(getContactDetailsData6.f4323r);
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0254Kb) this.f202h).f827r;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.cetPostalcode");
        GetContactDetailsData getContactDetailsData7 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData7);
        customBorderSimpleEditText2.setText(getContactDetailsData7.f4324s);
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0254Kb) this.f202h).f826q;
        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.cetCity");
        GetContactDetailsData getContactDetailsData8 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData8);
        customBorderSimpleEditText3.setText(getContactDetailsData8.f4325t);
        GetContactDetailsData getContactDetailsData9 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData9);
        EnumC0539W8 enumC0539W8 = EnumC0539W8.f1912H.get(getContactDetailsData9.f4326u);
        if (enumC0539W8 != null) {
            ((AbstractC0254Kb) this.f202h).f831v.setSelection(enumC0539W8.ordinal());
        }
        CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC0254Kb) this.f202h).f828s;
        C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.cetSecondaryEmail");
        GetContactDetailsData getContactDetailsData10 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData10);
        customBorderSimpleEditText4.setText(getContactDetailsData10.f4329x);
        TextView textView5 = ((AbstractC0254Kb) this.f202h).f802A;
        C0581Yd.m1767d(textView5, "mDataBinding.tvCellphoneAccount");
        GetContactDetailsData getContactDetailsData11 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData11);
        textView5.setText(getContactDetailsData11.f4311f);
        TextView textView6 = ((AbstractC0254Kb) this.f202h).f805D;
        C0581Yd.m1767d(textView6, "mDataBinding.tvCodesocietyAccount");
        GetContactDetailsData getContactDetailsData12 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData12);
        textView6.setText(String.valueOf(getContactDetailsData12.f4298D));
        TextView textView7 = ((AbstractC0254Kb) this.f202h).f809H;
        C0581Yd.m1767d(textView7, "mDataBinding.tvTarifcodeAccount");
        GetContactDetailsData getContactDetailsData13 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData13);
        textView7.setText(getContactDetailsData13.f4300F);
        TextView textView8 = ((AbstractC0254Kb) this.f202h).f807F;
        C0581Yd.m1767d(textView8, "mDataBinding.tvCrousdateAccount");
        String str2 = this.f6712k;
        GetContactDetailsData getContactDetailsData14 = this.f6713l;
        C0581Yd.m1768c(getContactDetailsData14);
        textView8.setText(DateFormat.format(str2, C0278Ld.m2213e(getContactDetailsData14.f4299E)));
        C0581Yd.m1768c(this.f6713l);
        CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC0254Kb) this.f202h).f831v;
        C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.spCountry");
        Spinner spinner = customBorderSimpleSpinner.f4971a.f6629b;
        C0581Yd.m1767d(spinner, "mDataBinding.spCountry.spinner");
        spinner.setOnItemSelectedListener(new C2300b());
        Button button = ((AbstractC0254Kb) this.f202h).f824o;
        C0581Yd.m1767d(button, "mDataBinding.bModify");
        button.setEnabled(false);
        if (c0479u8.f1712b.m969a()) {
            ((AbstractC0254Kb) this.f202h).f825p.m825a();
            ((AbstractC0254Kb) this.f202h).f827r.m825a();
            ((AbstractC0254Kb) this.f202h).f826q.m825a();
            ((AbstractC0254Kb) this.f202h).f828s.m825a();
            CustomBorderSimpleSpinner customBorderSimpleSpinner2 = ((AbstractC0254Kb) this.f202h).f831v;
            C0581Yd.m1767d(customBorderSimpleSpinner2, "mDataBinding.spCountry");
            customBorderSimpleSpinner2.setEnabled(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r0.f4323r != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
        if (r0.f4325t != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r0.f4324s != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
        if (android.text.TextUtils.isEmpty(r0.m824b()) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
        r0 = ((p000.AbstractC0254Kb) r3.f202h).f824o;
        p000.C0581Yd.m1767d(r0, "mDataBinding.bModify");
        r0.setEnabled(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
        if (r0.m822d() != false) goto L8;
     */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m242C() {
        /*
            r3 = this;
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r0 = r0.f828s
            java.lang.String r1 = "mDataBinding.cetSecondaryEmail"
            p000.C0581Yd.m1767d(r0, r1)
            java.lang.String r0 = r0.m824b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "mDataBinding.bModify"
            if (r0 != 0) goto L26
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r0 = r0.f828s
            p000.C0581Yd.m1767d(r0, r1)
            boolean r0 = r0.m822d()
            if (r0 == 0) goto L9e
        L26:
            fr.smoney.android.izly.data.model.GetContactDetailsData r0 = r3.f6713l
            if (r0 == 0) goto L9e
            int r0 = r3.m231y()
            if (r0 == 0) goto L9e
            fr.smoney.android.izly.data.model.GetContactDetailsData r0 = r3.f6713l
            if (r0 == 0) goto L3b
            p000.C0581Yd.m1768c(r0)
            java.lang.String r0 = r0.f4323r
            if (r0 == 0) goto L90
        L3b:
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r0 = r0.f825p
            java.lang.String r1 = "mDataBinding.cetAddress"
            p000.C0581Yd.m1767d(r0, r1)
            java.lang.String r0 = r0.m824b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L9e
            fr.smoney.android.izly.data.model.GetContactDetailsData r0 = r3.f6713l
            if (r0 == 0) goto L5b
            p000.C0581Yd.m1768c(r0)
            java.lang.String r0 = r0.f4325t
            if (r0 == 0) goto L90
        L5b:
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r0 = r0.f826q
            java.lang.String r1 = "mDataBinding.cetCity"
            p000.C0581Yd.m1767d(r0, r1)
            java.lang.String r0 = r0.m824b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L9e
            fr.smoney.android.izly.data.model.GetContactDetailsData r0 = r3.f6713l
            if (r0 == 0) goto L7b
            p000.C0581Yd.m1768c(r0)
            java.lang.String r0 = r0.f4324s
            if (r0 == 0) goto L90
        L7b:
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r0 = r0.f827r
            java.lang.String r1 = "mDataBinding.cetPostalcode"
            p000.C0581Yd.m1767d(r0, r1)
            java.lang.String r0 = r0.m824b()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L9e
        L90:
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            android.widget.Button r0 = r0.f824o
            p000.C0581Yd.m1767d(r0, r2)
            r1 = 1
            r0.setEnabled(r1)
            goto Lab
        L9e:
            B extends androidx.databinding.ViewDataBinding r0 = r3.f202h
            Kb r0 = (p000.AbstractC0254Kb) r0
            android.widget.Button r0 = r0.f824o
            p000.C0581Yd.m1767d(r0, r2)
            r1 = 0
            r0.setEnabled(r1)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnClickListenerC2298vd.m242C():void");
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        m242C();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 1) {
            this.f197b.m102u(enumC1631dd);
        } else if (m2556r() == 224) {
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f197b.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 173) {
                m244A((UpdateUserProfileData) bundle.getParcelable("fr.smoney.android.izly.extras.updateUserProfileData"), serverError);
            } else if (i2 != 224) {
            } else {
                m230z((GetContactDetailsData) bundle.getParcelable("fr.smoney.android.izly.extras.GetContactDetails"), serverError);
            }
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.ProgressType && m2556r() == 224) {
            this.f197b.m130A();
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
                return;
            }
            return;
        }
        this.f197b.m106q(enumC1631dd);
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                int m2556r = m2556r();
                if (m2556r == 173) {
                    m232x();
                    return;
                } else if (m2556r != 224) {
                    this.f197b.m100w(enumC1631dd, bundle);
                    return;
                } else {
                    m233w();
                    return;
                }
            } else if (ordinal == 35) {
                m232x();
                return;
            } else if (ordinal == 14) {
                bundle.getInt("Data.SelectItem");
                return;
            } else if (ordinal == 15) {
                this.f6714m.set(bundle.getLong("Data.Date"));
                m242C();
                return;
            }
        }
        this.f197b.m100w(enumC1631dd, bundle);
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f197b.m103t(enumC1631dd);
        } else if (m2556r() == 224) {
            AppCompatActivity appCompatActivity = this.f201g;
            if (appCompatActivity instanceof InterfaceC1928jd) {
                Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                ((InterfaceC1928jd) appCompatActivity).mo681m();
            }
        } else {
            this.f197b.m103t(enumC1631dd);
        }
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo236m() {
        return 2131493029;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f197b.f6816a;
        if (i == 173) {
            m244A(c0479u8.f1696M, c0479u8.f1697N);
        } else if (i != 224) {
        } else {
            m230z(c0479u8.f1703T, c0479u8.f1704U);
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Objects.requireNonNull(this.f197b);
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0254Kb) this.f202h).f828s;
        customBorderSimpleEditText.f4970f.add(new C0072Cd(getString(2131690199), Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"), false));
        ((AbstractC0254Kb) this.f202h).f828s.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC0254Kb) this.f202h).f825p.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC0254Kb) this.f202h).f827r.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC0254Kb) this.f202h).f826q.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC0254Kb) this.f202h).f825p.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f812b.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f811a.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f815f.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f829t.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f827r.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f826q.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f830u.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f824o.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f814d.setOnClickListener(this);
        ((AbstractC0254Kb) this.f202h).f813c.setOnClickListener(this);
        FragmentActivity activity = getActivity();
        C0581Yd.m1768c(activity);
        C0581Yd.m1767d(activity, "activity!!");
        this.f6715n = new C0295Mc(activity);
        Iterator it = EnumSet.allOf(EnumC0539W8.class).iterator();
        while (it.hasNext()) {
            C0295Mc c0295Mc = this.f6715n;
            C0581Yd.m1768c(c0295Mc);
            c0295Mc.add((EnumC0539W8) it.next());
        }
        ((AbstractC0254Kb) this.f202h).f831v.setAdapter(this.f6715n);
        if (bundle != null) {
            this.f6713l = (GetContactDetailsData) bundle.getParcelable(this.f6711j);
        }
        if (this.f6713l == null) {
            m233w();
        } else {
            m243B();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f202h;
        if (view == ((AbstractC0254Kb) obj).f824o) {
            Context context = getContext();
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(((Button) view).getWindowToken(), 0);
            m232x();
        } else if (view != ((AbstractC0254Kb) obj).f826q && view != ((AbstractC0254Kb) obj).f827r && view != ((AbstractC0254Kb) obj).f825p) {
            if (view == ((AbstractC0254Kb) obj).f830u) {
                this.f201g.onBackPressed();
            } else if (view == ((AbstractC0254Kb) obj).f829t) {
                Context context2 = getContext();
                String string = getString(2131690018);
                View inflate = ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(2131493056, (ViewGroup) null);
                ((TextView) inflate.findViewById(2131296935)).setText(string);
                PopupWindow popupWindow = new PopupWindow(context2);
                popupWindow.setContentView(inflate);
                popupWindow.setHeight(-2);
                popupWindow.setWidth(-2);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                if (popupWindow.isAboveAnchor()) {
                    popupWindow.setBackgroundDrawable(context2.getResources().getDrawable(2131230828));
                } else {
                    popupWindow.setBackgroundDrawable(context2.getResources().getDrawable(2131230829));
                }
                popupWindow.showAsDropDown(view, -(((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin * 10), 0);
            } else if (view == ((AbstractC0254Kb) obj).f812b) {
                startActivity(new Intent(this.f201g, ListSupportActivity.class));
            } else if (view == ((AbstractC0254Kb) obj).f811a) {
                startActivity(new Intent(this.f201g, HistoryActivity.class));
            } else if (view == ((AbstractC0254Kb) obj).f814d) {
                startActivity(new Intent(this.f201g, AllStatementsActivity.class));
            } else if (view == ((AbstractC0254Kb) obj).f815f) {
                startActivity(new Intent(this.f201g, EventListActivity.class));
            } else if (view == ((AbstractC0254Kb) obj).f813c) {
                startActivity(new Intent(this.f201g, CancelContractActivity.class));
            }
        } else if (this.f197b.f6816a.f1712b.m969a()) {
            this.f197b.m126E(C0543Wc.m1819s(getString(2131689967), getString(2131689966), getString(17039370)));
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        this.f6716o = new SessionStateReceiver(appCompatActivity, new C2299a());
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C0581Yd.m1766e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        getActivity();
        Object obj = this.f202h;
        C0581Yd.m1767d(obj, "mDataBinding");
        return ((AbstractC0254Kb) obj).getRoot();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f6716o;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f6716o;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(this.f6711j, this.f6713l);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: s */
    public boolean mo234s() {
        Objects.requireNonNull(this.f197b);
        return false;
    }

    /* renamed from: w */
    public final void m233w() {
        int i;
        String stringExtra;
        String stringExtra2;
        C2387y8 c2387y8 = this.f197b;
        C0479U8 c0479u8 = c2387y8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2387y8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 224 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsContactId").equals(str) && (((stringExtra = valueAt.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsLatitude")) == null || stringExtra.equals(null)) && ((stringExtra2 = valueAt.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsLongitude")) == null || stringExtra2.equals(null)))) {
                i = smoneyRequestManager.f4688a.keyAt(i2);
                break;
            }
        }
        int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
        Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 224);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.GetContactDetailsUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.GetContactDetailsSessionId", str2);
        intent.putExtra("fr.smoney.android.izly.extras.GetContactDetailsContactId", str);
        intent.putExtra("fr.smoney.android.izly.extras.GetContactDetailsLatitude", (String) null);
        intent.putExtra("fr.smoney.android.izly.extras.GetContactDetailsLongitude", (String) null);
        smoneyRequestManager.m956b(intent);
        smoneyRequestManager.f4688a.append(nextInt, intent);
        C0479U8 c0479u82 = smoneyRequestManager.f4693f;
        c0479u82.f1703T = null;
        c0479u82.f1704U = null;
        i = nextInt;
        this.f197b.m120c(i, 224, true);
    }

    /* renamed from: x */
    public final void m232x() {
        String str;
        int i;
        String str2;
        String str3;
        C2387y8 c2387y8 = this.f197b;
        C0479U8 c0479u8 = c2387y8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2387y8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str4 = loginData.f4362a;
        String str5 = loginData.f4364c;
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0254Kb) this.f202h).f828s;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.cetSecondaryEmail");
        String m824b = customBorderSimpleEditText.m824b();
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0254Kb) this.f202h).f825p;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.cetAddress");
        String m824b2 = customBorderSimpleEditText2.m824b();
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0254Kb) this.f202h).f827r;
        String str6 = "mDataBinding.cetPostalcode";
        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.cetPostalcode");
        String m824b3 = customBorderSimpleEditText3.m824b();
        CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC0254Kb) this.f202h).f826q;
        C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.cetCity");
        String m824b4 = customBorderSimpleEditText4.m824b();
        int m231y = m231y();
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            str = str6;
            String str7 = m824b4;
            String str8 = m824b3;
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                int i3 = size;
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 173 && valueAt.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileUserId").equals(str4) && valueAt.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileSessionId").equals(str5)) {
                    if (valueAt.getIntExtra("fr.smoney.android.izly.extras.updateUserProfileCountry", 0) == m231y && valueAt.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileEmail").equals(m824b) && valueAt.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileAddress").equals(m824b2)) {
                        str3 = str8;
                        if (valueAt.getStringExtra("fr.smoney.android.izly.extras.updateUserProfilePostCode").equals(str3)) {
                            str2 = str7;
                            if (valueAt.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileCity").equals(str2)) {
                                i = smoneyRequestManager.f4688a.keyAt(i2);
                                break;
                            }
                        }
                    } else {
                        str3 = str8;
                    }
                    str2 = str7;
                } else {
                    str2 = str7;
                    str3 = str8;
                }
                i2++;
                m824b4 = str2;
                m824b3 = str3;
                str6 = str;
                size = i3;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 173);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfileUserId", str4);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfileSessionId", str5);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfileEmail", m824b);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfileAddress", m824b2);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfilePostCode", str8);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfileCity", str7);
                intent.putExtra("fr.smoney.android.izly.extras.updateUserProfileCountry", m231y);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1696M = null;
                c0479u82.f1697N = null;
                i = nextInt;
                break;
            }
        }
        this.f197b.m120c(i, 173, true);
        CustomBorderSimpleEditText customBorderSimpleEditText5 = ((AbstractC0254Kb) this.f202h).f827r;
        C0581Yd.m1767d(customBorderSimpleEditText5, str);
        new Bundle().putString("code_postal", customBorderSimpleEditText5.m824b());
    }

    /* renamed from: y */
    public final int m231y() {
        C0295Mc c0295Mc = this.f6715n;
        C0581Yd.m1768c(c0295Mc);
        if (c0295Mc.getCount() > 0) {
            C0295Mc c0295Mc2 = this.f6715n;
            C0581Yd.m1768c(c0295Mc2);
            CustomBorderSimpleSpinner customBorderSimpleSpinner = ((AbstractC0254Kb) this.f202h).f831v;
            C0581Yd.m1767d(customBorderSimpleSpinner, "mDataBinding.spCountry");
            Spinner spinner = customBorderSimpleSpinner.f4971a.f6629b;
            C0581Yd.m1767d(spinner, "mDataBinding.spCountry.spinner");
            EnumC0539W8 item = c0295Mc2.getItem(spinner.getSelectedItemPosition());
            C0581Yd.m1768c(item);
            C0581Yd.m1767d(item, "mSpinnerAdapterCountry!!…r.selectedItemPosition)!!");
            return item.f1937a;
        }
        return 0;
    }

    /* renamed from: z */
    public final void m230z(GetContactDetailsData getContactDetailsData, ServerError serverError) {
        if (serverError != null) {
            this.f197b.m124G(serverError);
        } else if (getContactDetailsData == null) {
            this.f197b.m126E(C0580Yc.m1772t(getActivity(), this));
        } else {
            this.f6713l = getContactDetailsData;
            m243B();
        }
    }
}
