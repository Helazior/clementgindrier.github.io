package fr.smoney.android.izly.p005ui.privateview.plus.settings.security.secretkey;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.UpdatePasswordData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.security.secretkey.ChangePasswordActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ChangePasswordActivity extends SmoneyABSActivity<AbstractC2026oa> implements View.OnClickListener, SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: C */
    public static final /* synthetic */ int f4868C = 0;

    /* renamed from: A */
    public C0049Bd f4869A;

    /* renamed from: B */
    public C0049Bd f4870B;

    /* renamed from: x */
    public final String f4871x = "savedStateCurrentPassword";

    /* renamed from: y */
    public String f4872y;

    /* renamed from: z */
    public C0049Bd f4873z;

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.security.secretkey.ChangePasswordActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C1804a implements TextWatcher {

        /* renamed from: a */
        public final View f4874a;

        /* renamed from: b */
        public final /* synthetic */ ChangePasswordActivity f4875b;

        public C1804a(@NotNull ChangePasswordActivity changePasswordActivity, View view) {
            C0581Yd.m1766e(view, "mView");
            this.f4875b = changePasswordActivity;
            this.f4874a = view;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            C0581Yd.m1766e(editable, "s");
            View view = this.f4874a;
            ChangePasswordActivity changePasswordActivity = this.f4875b;
            int i = ChangePasswordActivity.f4868C;
            if (C0581Yd.m1770a(view, ((AbstractC2026oa) changePasswordActivity.f4202w).f5600d)) {
                ChangePasswordActivity changePasswordActivity2 = this.f4875b;
                C0049Bd c0049Bd = changePasswordActivity2.f4870B;
                if (c0049Bd != null) {
                    CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2026oa) changePasswordActivity2.f4202w).f5600d;
                    C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etNewPassword");
                    c0049Bd.m2551b(customBorderSimpleEditText.m824b());
                }
            } else if (C0581Yd.m1770a(this.f4874a, ((AbstractC2026oa) this.f4875b.f4202w).f5602g)) {
                ChangePasswordActivity changePasswordActivity3 = this.f4875b;
                C0049Bd c0049Bd2 = changePasswordActivity3.f4873z;
                if (c0049Bd2 != null) {
                    CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2026oa) changePasswordActivity3.f4202w).f5602g;
                    C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etOldPassword");
                    c0049Bd2.m2551b(customBorderSimpleEditText2.m824b());
                }
                ChangePasswordActivity changePasswordActivity4 = this.f4875b;
                C0049Bd c0049Bd3 = changePasswordActivity4.f4869A;
                if (c0049Bd3 != null) {
                    CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC2026oa) changePasswordActivity4.f4202w).f5602g;
                    C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.etOldPassword");
                    c0049Bd3.m2551b(customBorderSimpleEditText3.m824b());
                }
            }
            ChangePasswordActivity changePasswordActivity5 = this.f4875b;
            CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC2026oa) changePasswordActivity5.f4202w).f5602g;
            C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.etOldPassword");
            if (customBorderSimpleEditText4.m821e()) {
                CustomBorderSimpleEditText customBorderSimpleEditText5 = ((AbstractC2026oa) changePasswordActivity5.f4202w).f5601f;
                C0581Yd.m1767d(customBorderSimpleEditText5, "mDataBinding.etNewPasswordConfirm");
                if (customBorderSimpleEditText5.m821e()) {
                    CustomBorderSimpleEditText customBorderSimpleEditText6 = ((AbstractC2026oa) changePasswordActivity5.f4202w).f5601f;
                    C0581Yd.m1767d(customBorderSimpleEditText6, "mDataBinding.etNewPasswordConfirm");
                    if (customBorderSimpleEditText6.m821e()) {
                        Button button = ((AbstractC2026oa) changePasswordActivity5.f4202w).f5599c;
                        C0581Yd.m1767d(button, "mDataBinding.bConfirm");
                        button.setEnabled(true);
                        return;
                    }
                }
            }
            Button button2 = ((AbstractC2026oa) changePasswordActivity5.f4202w).f5599c;
            C0581Yd.m1767d(button2, "mDataBinding.bConfirm");
            button2.setEnabled(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            C0581Yd.m1766e(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            C0581Yd.m1766e(charSequence, "s");
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492921;
    }

    /* renamed from: L */
    public final void m863L() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2026oa) this.f4202w).f5600d;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etNewPassword");
        String m824b = customBorderSimpleEditText.m824b();
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2026oa) this.f4202w).f5602g;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etOldPassword");
        String m824b2 = customBorderSimpleEditText2.m824b();
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 161 && valueAt.getStringExtra("fr.smoney.android.izly.extras.updatePasswordUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.updatePasswordSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.updatePasswordNewPassword").equals(m824b) && valueAt.getStringExtra("fr.smoney.android.izly.extras.updatePasswordPassword").equals(m824b2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 161);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.updatePasswordUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.updatePasswordSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.updatePasswordNewPassword", m824b);
                intent.putExtra("fr.smoney.android.izly.extras.updatePasswordPassword", m824b2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1690G = null;
                c0479u82.f1691H = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 161, true);
    }

    /* renamed from: M */
    public final void m862M(UpdatePasswordData updatePasswordData, ServerError serverError) {
        if (serverError == null) {
            if (updatePasswordData == null) {
                this.f4197r.m126E(C0580Yc.m1772t(this, this));
                return;
            }
            SmoneyApplication.f4207g.m2505d();
            SmoneyApplication.f4207g.m2508a();
            this.f4197r.m126E(C0525Vc.m1826s(getString(2131689682), getString(2131690057), getString(2131689575), null, this, EnumC1631dd.AlertType));
            return;
        }
        this.f4197r.m124G(serverError);
        if (serverError.f4601b == 169) {
            CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2026oa) this.f4202w).f5600d;
            C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etNewPassword");
            customBorderSimpleEditText.setText("");
            CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2026oa) this.f4202w).f5601f;
            C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etNewPasswordConfirm");
            customBorderSimpleEditText2.setText("");
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 161) {
                m862M((UpdatePasswordData) bundle.getParcelable("fr.smoney.android.izly.extras.updatePasswordData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 0) {
                this.f4197r.m119d(false);
                return;
            } else if (ordinal == 9) {
                if (m982H() == 161) {
                    m863L();
                    return;
                } else {
                    this.f4197r.m100w(enumC1631dd, bundle);
                    return;
                }
            }
        }
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m103t(enumC1631dd);
        } else if (m982H() == 161) {
            finish();
        } else {
            this.f4197r.m103t(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 161) {
            m862M(c0479u8.f1690G, c0479u8.f1691H);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC2026oa) obj).f5599c) {
            CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2026oa) obj).f5600d;
            C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etNewPassword");
            String m824b = customBorderSimpleEditText.m824b();
            CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2026oa) this.f4202w).f5601f;
            C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etNewPasswordConfirm");
            if (!m824b.equals(customBorderSimpleEditText2.m824b())) {
                this.f4197r.m126E(C0543Wc.m1819s(getString(2131689648), getString(2131689647), getString(17039370)));
                return;
            }
            CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC2026oa) this.f4202w).f5600d;
            C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.etNewPassword");
            String m824b2 = customBorderSimpleEditText3.m824b();
            CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC2026oa) this.f4202w).f5602g;
            C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.etOldPassword");
            if (m824b2.equals(customBorderSimpleEditText4.m824b())) {
                this.f4197r.m126E(C0543Wc.m1819s(getString(2131689650), getString(2131689649), getString(17039370)));
                return;
            }
            CustomBorderSimpleEditText customBorderSimpleEditText5 = ((AbstractC2026oa) this.f4202w).f5600d;
            C0581Yd.m1767d(customBorderSimpleEditText5, "mDataBinding.etNewPassword");
            this.f4872y = customBorderSimpleEditText5.m824b();
            m863L();
        } else if (view == ((AbstractC2026oa) obj).f5598b) {
            finish();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689963);
        C0581Yd.m1767d(string, "getString(R.string.modif_code_title)");
        c0297a.m2194a(this, string, null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_GREY, true, false);
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC2026oa) this.f4202w).f5602g;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etOldPassword");
        EditText editText = customBorderSimpleEditText.f4966a.f6403a;
        C0581Yd.m1767d(editText, "mDataBinding.etOldPassword.editText");
        editText.setInputType(18);
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC2026oa) this.f4202w).f5602g;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etOldPassword");
        EditText editText2 = customBorderSimpleEditText2.f4966a.f6403a;
        C0581Yd.m1767d(editText2, "mDataBinding.etOldPassword.editText");
        editText2.setMaxLines(2131361812);
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC2026oa) this.f4202w).f5602g;
        customBorderSimpleEditText3.f4970f.add(new C0072Cd(getString(2131690201), Pattern.compile("[0-9]{6}$"), false));
        CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC2026oa) this.f4202w).f5602g;
        customBorderSimpleEditText4.f4970f.add(new C0072Cd(getString(2131690200), Pattern.compile("0{6}|1{6}|2{6}|3{6}|4{6}|5{6}|6{6}|7{6}|8{6}|9{6}"), true));
        CustomBorderSimpleEditText customBorderSimpleEditText5 = ((AbstractC2026oa) this.f4202w).f5602g;
        customBorderSimpleEditText5.f4970f.add(new C0072Cd(getString(2131690203), Pattern.compile("012345|123456|234567|345678|456789|567890|678901|789012|890123|901234|987654|876543|765432|654321|543210|432109|321098|210987|109876|098765"), true));
        CustomBorderSimpleEditText customBorderSimpleEditText6 = ((AbstractC2026oa) this.f4202w).f5602g;
        C0581Yd.m1767d(customBorderSimpleEditText6, "mDataBinding.etOldPassword");
        customBorderSimpleEditText6.f4966a.f6403a.addTextChangedListener(new C1804a(this, customBorderSimpleEditText6));
        CustomBorderSimpleEditText customBorderSimpleEditText7 = ((AbstractC2026oa) this.f4202w).f5600d;
        C0581Yd.m1767d(customBorderSimpleEditText7, "mDataBinding.etNewPassword");
        EditText editText3 = customBorderSimpleEditText7.f4966a.f6403a;
        C0581Yd.m1767d(editText3, "mDataBinding.etNewPassword.editText");
        editText3.setInputType(18);
        CustomBorderSimpleEditText customBorderSimpleEditText8 = ((AbstractC2026oa) this.f4202w).f5600d;
        C0581Yd.m1767d(customBorderSimpleEditText8, "mDataBinding.etNewPassword");
        EditText editText4 = customBorderSimpleEditText8.f4966a.f6403a;
        C0581Yd.m1767d(editText4, "mDataBinding.etNewPassword.editText");
        editText4.setMaxLines(2131361812);
        CustomBorderSimpleEditText customBorderSimpleEditText9 = ((AbstractC2026oa) this.f4202w).f5600d;
        customBorderSimpleEditText9.f4970f.add(new C0072Cd(getString(2131690201), Pattern.compile("[0-9]{6}$"), false));
        CustomBorderSimpleEditText customBorderSimpleEditText10 = ((AbstractC2026oa) this.f4202w).f5600d;
        customBorderSimpleEditText10.f4970f.add(new C0072Cd(getString(2131690200), Pattern.compile("0{6}|1{6}|2{6}|3{6}|4{6}|5{6}|6{6}|7{6}|8{6}|9{6}"), true));
        CustomBorderSimpleEditText customBorderSimpleEditText11 = ((AbstractC2026oa) this.f4202w).f5600d;
        customBorderSimpleEditText11.f4970f.add(new C0072Cd(getString(2131690203), Pattern.compile("012345|123456|234567|345678|456789|567890|678901|789012|890123|901234|987654|876543|765432|654321|543210|432109|321098|210987|109876|098765"), true));
        CustomBorderSimpleEditText customBorderSimpleEditText12 = ((AbstractC2026oa) this.f4202w).f5600d;
        String string2 = getString(2131689651);
        CustomBorderSimpleEditText customBorderSimpleEditText13 = ((AbstractC2026oa) this.f4202w).f5602g;
        C0581Yd.m1767d(customBorderSimpleEditText13, "mDataBinding.etOldPassword");
        C0049Bd c0049Bd = new C0049Bd(customBorderSimpleEditText12, string2, customBorderSimpleEditText13.m824b(), true);
        this.f4873z = c0049Bd;
        ((AbstractC2026oa) this.f4202w).f5600d.f4970f.add(c0049Bd);
        CustomBorderSimpleEditText customBorderSimpleEditText14 = ((AbstractC2026oa) this.f4202w).f5600d;
        C0581Yd.m1767d(customBorderSimpleEditText14, "mDataBinding.etNewPassword");
        customBorderSimpleEditText14.f4966a.f6403a.addTextChangedListener(new C1804a(this, customBorderSimpleEditText14));
        CustomBorderSimpleEditText customBorderSimpleEditText15 = ((AbstractC2026oa) this.f4202w).f5601f;
        C0581Yd.m1767d(customBorderSimpleEditText15, "mDataBinding.etNewPasswordConfirm");
        EditText editText5 = customBorderSimpleEditText15.f4966a.f6403a;
        C0581Yd.m1767d(editText5, "mDataBinding.etNewPasswordConfirm.editText");
        editText5.setInputType(18);
        CustomBorderSimpleEditText customBorderSimpleEditText16 = ((AbstractC2026oa) this.f4202w).f5601f;
        C0581Yd.m1767d(customBorderSimpleEditText16, "mDataBinding.etNewPasswordConfirm");
        EditText editText6 = customBorderSimpleEditText16.f4966a.f6403a;
        C0581Yd.m1767d(editText6, "mDataBinding.etNewPasswordConfirm.editText");
        editText6.setMaxLines(2131361812);
        CustomBorderSimpleEditText customBorderSimpleEditText17 = ((AbstractC2026oa) this.f4202w).f5601f;
        String string3 = getString(2131690202);
        CustomBorderSimpleEditText customBorderSimpleEditText18 = ((AbstractC2026oa) this.f4202w).f5600d;
        C0581Yd.m1767d(customBorderSimpleEditText18, "mDataBinding.etNewPassword");
        C0049Bd c0049Bd2 = new C0049Bd(customBorderSimpleEditText17, string3, customBorderSimpleEditText18.m824b(), false);
        this.f4870B = c0049Bd2;
        ((AbstractC2026oa) this.f4202w).f5601f.f4970f.add(c0049Bd2);
        CustomBorderSimpleEditText customBorderSimpleEditText19 = ((AbstractC2026oa) this.f4202w).f5601f;
        String string4 = getString(2131689651);
        CustomBorderSimpleEditText customBorderSimpleEditText20 = ((AbstractC2026oa) this.f4202w).f5602g;
        C0581Yd.m1767d(customBorderSimpleEditText20, "mDataBinding.etOldPassword");
        C0049Bd c0049Bd3 = new C0049Bd(customBorderSimpleEditText19, string4, customBorderSimpleEditText20.m824b(), true);
        this.f4869A = c0049Bd3;
        ((AbstractC2026oa) this.f4202w).f5601f.f4970f.add(c0049Bd3);
        CustomBorderSimpleEditText customBorderSimpleEditText21 = ((AbstractC2026oa) this.f4202w).f5601f;
        customBorderSimpleEditText21.f4970f.add(new C0072Cd(getString(2131690201), Pattern.compile("[0-9]{6}$"), false));
        CustomBorderSimpleEditText customBorderSimpleEditText22 = ((AbstractC2026oa) this.f4202w).f5601f;
        customBorderSimpleEditText22.f4970f.add(new C0072Cd(getString(2131690200), Pattern.compile("0{6}|1{6}|2{6}|3{6}|4{6}|5{6}|6{6}|7{6}|8{6}|9{6}"), true));
        CustomBorderSimpleEditText customBorderSimpleEditText23 = ((AbstractC2026oa) this.f4202w).f5601f;
        customBorderSimpleEditText23.f4970f.add(new C0072Cd(getString(2131690203), Pattern.compile("012345|123456|234567|345678|456789|567890|678901|789012|890123|901234|987654|876543|765432|654321|543210|432109|321098|210987|109876|098765"), true));
        CustomBorderSimpleEditText customBorderSimpleEditText24 = ((AbstractC2026oa) this.f4202w).f5601f;
        C0581Yd.m1767d(customBorderSimpleEditText24, "mDataBinding.etNewPasswordConfirm");
        customBorderSimpleEditText24.f4966a.f6403a.addTextChangedListener(new C1804a(this, customBorderSimpleEditText24));
        ((AbstractC2026oa) this.f4202w).f5599c.setOnClickListener(this);
        ((AbstractC2026oa) this.f4202w).f5598b.setOnClickListener(this);
        if (bundle != null) {
            this.f4872y = bundle.getString(this.f4871x);
        }
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

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(this.f4871x, this.f4872y);
    }
}
