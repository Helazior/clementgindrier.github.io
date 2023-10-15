package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.myaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.GetBankAccountData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MakeBankAccountUpdateData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.myaccount.AddTransferAccountActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AddTransferAccountActivity extends SmoneyABSActivity<AbstractC0292M9> implements View.OnClickListener, TextWatcher, SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: C */
    public static final /* synthetic */ int f4809C = 0;

    /* renamed from: A */
    public String f4810A;

    /* renamed from: B */
    public int f4811B;

    /* renamed from: x */
    public final String f4812x = "savedStateCurrentPassword";

    /* renamed from: y */
    public GetBankAccountData f4813y;

    /* renamed from: z */
    public SessionStateReceiver f4814z;

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.myaccount.AddTransferAccountActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1797a implements InterfaceC1879hd {
        public C1797a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                AddTransferAccountActivity addTransferAccountActivity = AddTransferAccountActivity.this;
                int i = AddTransferAccountActivity.f4809C;
                if (addTransferAccountActivity.m982H() == 91) {
                    AddTransferAccountActivity.this.m893M();
                }
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492905;
    }

    /* renamed from: L */
    public final void m894L() {
        GetBankAccountData getBankAccountData = this.f4813y;
        if (getBankAccountData != null) {
            C0581Yd.m1768c(getBankAccountData);
            if (getBankAccountData.f4280b != null) {
                CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0292M9) this.f4202w).f978c;
                C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etAlias");
                GetBankAccountData getBankAccountData2 = this.f4813y;
                C0581Yd.m1768c(getBankAccountData2);
                customBorderSimpleEditText.setText(getBankAccountData2.f4280b);
            }
        }
        ((AbstractC0292M9) this.f4202w).f978c.f4966a.f6403a.addTextChangedListener(this);
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0292M9) this.f4202w).f980f;
        customBorderSimpleEditText2.f4970f.add(new C0072Cd(getString(2131689541), Pattern.compile("[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}"), false));
        ((AbstractC0292M9) this.f4202w).f980f.f4966a.f6403a.addTextChangedListener(this);
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0292M9) this.f4202w).f979d;
        customBorderSimpleEditText3.f4970f.add(new C0072Cd(getString(2131689540), Pattern.compile("([a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?)"), false));
        ((AbstractC0292M9) this.f4202w).f979d.f4966a.f6403a.addTextChangedListener(this);
        ((AbstractC0292M9) this.f4202w).f977b.setOnClickListener(this);
    }

    /* renamed from: M */
    public final void m893M() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0292M9) this.f4202w).f978c;
        C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etAlias");
        EditText editText = customBorderSimpleEditText.f4966a.f6403a;
        C0581Yd.m1767d(editText, "mDataBinding.etAlias.editText");
        String obj = editText.getText().toString();
        CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0292M9) this.f4202w).f980f;
        C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etIban");
        EditText editText2 = customBorderSimpleEditText2.f4966a.f6403a;
        C0581Yd.m1767d(editText2, "mDataBinding.etIban.editText");
        String obj2 = editText2.getText().toString();
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0292M9) this.f4202w).f979d;
        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.etBic");
        EditText editText3 = customBorderSimpleEditText3.f4966a.f6403a;
        C0581Yd.m1767d(editText3, "mDataBinding.etBic.editText");
        String obj3 = editText3.getText().toString();
        String str3 = this.f4810A;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            String str4 = str3;
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                int i3 = size;
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 91 && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateAlias").equals(obj) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateIban").equals(obj2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateBic").equals(obj3)) {
                    String stringExtra = valueAt.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdatePassword");
                    str3 = str4;
                    if (stringExtra.equals(str3)) {
                        i = smoneyRequestManager.f4688a.keyAt(i2);
                        break;
                    }
                } else {
                    str3 = str4;
                }
                i2++;
                size = i3;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 91);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateAlias", obj);
                intent.putExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateIban", obj2);
                intent.putExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateBic", obj3);
                intent.putExtra("fr.smoney.android.izly.extras.makeBankAccountUpdatePassword", str4);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1686E = null;
                c0479u82.f1688F = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 91, true);
    }

    /* renamed from: N */
    public final void m892N(MakeBankAccountUpdateData makeBankAccountUpdateData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (makeBankAccountUpdateData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            Intent intent = new Intent(this, AddChangeTransferAccountResultActivity.class);
            intent.putExtra("fr.smoney.android.izly.extras.addTransferAccountData", makeBankAccountUpdateData);
            startActivityForResult(intent, 11);
        }
    }

    /* renamed from: O */
    public final void m891O(GetBankAccountData getBankAccountData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (getBankAccountData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            this.f4813y = getBankAccountData;
            m894L();
        }
    }

    /* renamed from: P */
    public final boolean m890P() {
        GetBankAccountData getBankAccountData = this.f4813y;
        if (getBankAccountData != null) {
            C0581Yd.m1768c(getBankAccountData);
            if (getBankAccountData.f4280b != null) {
                CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0292M9) this.f4202w).f978c;
                C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etAlias");
                EditText editText = customBorderSimpleEditText.f4966a.f6403a;
                C0581Yd.m1767d(editText, "mDataBinding.etAlias.editText");
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0292M9) this.f4202w).f978c;
                    C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etAlias");
                    EditText editText2 = customBorderSimpleEditText2.f4966a.f6403a;
                    C0581Yd.m1767d(editText2, "mDataBinding.etAlias.editText");
                    String obj = editText2.getText().toString();
                    GetBankAccountData getBankAccountData2 = this.f4813y;
                    C0581Yd.m1768c(getBankAccountData2);
                    String str = getBankAccountData2.f4280b;
                    C0581Yd.m1767d(str, "mBankAccountData!!.alias");
                    if (obj.compareTo(str) != 0) {
                        return true;
                    }
                }
            }
        }
        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0292M9) this.f4202w).f978c;
        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.etAlias");
        EditText editText3 = customBorderSimpleEditText3.f4966a.f6403a;
        C0581Yd.m1767d(editText3, "mDataBinding.etAlias.editText");
        return !TextUtils.isEmpty(editText3.getText().toString());
    }

    /* renamed from: Q */
    public final boolean m889Q() {
        GetBankAccountData getBankAccountData = this.f4813y;
        if (getBankAccountData != null) {
            C0581Yd.m1768c(getBankAccountData);
            if (getBankAccountData.f4283f != null) {
                CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0292M9) this.f4202w).f979d;
                C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etBic");
                if (customBorderSimpleEditText.m822d()) {
                    CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0292M9) this.f4202w).f979d;
                    C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etBic");
                    EditText editText = customBorderSimpleEditText2.f4966a.f6403a;
                    C0581Yd.m1767d(editText, "mDataBinding.etBic.editText");
                    if (!TextUtils.isEmpty(editText.getText().toString())) {
                        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0292M9) this.f4202w).f979d;
                        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.etBic");
                        EditText editText2 = customBorderSimpleEditText3.f4966a.f6403a;
                        C0581Yd.m1767d(editText2, "mDataBinding.etBic.editText");
                        String obj = editText2.getText().toString();
                        GetBankAccountData getBankAccountData2 = this.f4813y;
                        C0581Yd.m1768c(getBankAccountData2);
                        String str = getBankAccountData2.f4283f;
                        C0581Yd.m1767d(str, "mBankAccountData!!.bic");
                        if (obj.compareTo(str) != 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC0292M9) this.f4202w).f979d;
        C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.etBic");
        if (customBorderSimpleEditText4.m822d()) {
            CustomBorderSimpleEditText customBorderSimpleEditText5 = ((AbstractC0292M9) this.f4202w).f979d;
            C0581Yd.m1767d(customBorderSimpleEditText5, "mDataBinding.etBic");
            EditText editText3 = customBorderSimpleEditText5.f4966a.f6403a;
            C0581Yd.m1767d(editText3, "mDataBinding.etBic.editText");
            if (!TextUtils.isEmpty(editText3.getText().toString())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: R */
    public final boolean m888R() {
        GetBankAccountData getBankAccountData = this.f4813y;
        if (getBankAccountData != null) {
            C0581Yd.m1768c(getBankAccountData);
            if (getBankAccountData.f4281c != null) {
                CustomBorderSimpleEditText customBorderSimpleEditText = ((AbstractC0292M9) this.f4202w).f980f;
                C0581Yd.m1767d(customBorderSimpleEditText, "mDataBinding.etIban");
                if (customBorderSimpleEditText.m822d()) {
                    CustomBorderSimpleEditText customBorderSimpleEditText2 = ((AbstractC0292M9) this.f4202w).f980f;
                    C0581Yd.m1767d(customBorderSimpleEditText2, "mDataBinding.etIban");
                    EditText editText = customBorderSimpleEditText2.f4966a.f6403a;
                    C0581Yd.m1767d(editText, "mDataBinding.etIban.editText");
                    if (!TextUtils.isEmpty(editText.getText().toString())) {
                        CustomBorderSimpleEditText customBorderSimpleEditText3 = ((AbstractC0292M9) this.f4202w).f980f;
                        C0581Yd.m1767d(customBorderSimpleEditText3, "mDataBinding.etIban");
                        EditText editText2 = customBorderSimpleEditText3.f4966a.f6403a;
                        C0581Yd.m1767d(editText2, "mDataBinding.etIban.editText");
                        String obj = editText2.getText().toString();
                        GetBankAccountData getBankAccountData2 = this.f4813y;
                        C0581Yd.m1768c(getBankAccountData2);
                        String str = getBankAccountData2.f4281c;
                        C0581Yd.m1767d(str, "mBankAccountData!!.iban");
                        if (obj.compareTo(str) != 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        CustomBorderSimpleEditText customBorderSimpleEditText4 = ((AbstractC0292M9) this.f4202w).f980f;
        C0581Yd.m1767d(customBorderSimpleEditText4, "mDataBinding.etIban");
        if (customBorderSimpleEditText4.m822d()) {
            CustomBorderSimpleEditText customBorderSimpleEditText5 = ((AbstractC0292M9) this.f4202w).f980f;
            C0581Yd.m1767d(customBorderSimpleEditText5, "mDataBinding.etIban");
            EditText editText3 = customBorderSimpleEditText5.f4966a.f6403a;
            C0581Yd.m1767d(editText3, "mDataBinding.etIban.editText");
            if (!TextUtils.isEmpty(editText3.getText().toString())) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        m890P();
        m888R();
        m889Q();
        boolean z = false;
        if (this.f4811B == 0) {
            Button button = ((AbstractC0292M9) this.f4202w).f977b;
            C0581Yd.m1767d(button, "mDataBinding.bModifyIban");
            if (m890P() && m888R() && m889Q()) {
                z = true;
            }
            button.setEnabled(z);
            return;
        }
        Button button2 = ((AbstractC0292M9) this.f4202w).f977b;
        C0581Yd.m1767d(button2, "mDataBinding.bModifyIban");
        button2.setEnabled((m890P() || m888R() || m889Q()) ? true : true);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 91) {
                m892N((MakeBankAccountUpdateData) bundle.getParcelable("fr.smoney.android.izly.extras.changeTransferAccountData"), serverError);
            } else if (i2 == 225) {
                m891O((GetBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.getBankAccountData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd != EnumC1631dd.InputPasswordType) {
            this.f4197r.m106q(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 7) {
                this.f4810A = bundle.getString("Data.Password");
                m893M();
                return;
            } else if (ordinal == 9) {
                if (m982H() == 91) {
                    m893M();
                    return;
                } else {
                    this.f4197r.m100w(enumC1631dd, bundle);
                    return;
                }
            }
        }
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 91) {
            m892N(c0479u8.f1686E, c0479u8.f1688F);
        } else if (i == 225) {
            m891O(c0479u8.f1705V, c0479u8.f1706W);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 == -1 && i == 11) {
            setResult(-1);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        if (view == ((AbstractC0292M9) this.f4202w).f977b) {
            this.f4197r.m126E(C0617ad.m1725s(this, this));
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        this.f4814z = new SessionStateReceiver(this, new C1797a());
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689522);
        C0581Yd.m1767d(string, "getString(R.string.account_info_title)");
        c0297a.m2194a(this, string, null, getString(2131689521), EnumC1687fd.LONG_APPBAR_WITH_DESCRIPTION, EnumC0161Gd.COLOR_GREY, true, false);
        if (extras != null) {
            this.f4813y = (GetBankAccountData) extras.getParcelable("fr.smoney.android.izly.intentBankAccount");
            this.f4811B = extras.getInt("fr.smoney.android.izly.intentExtrasMode");
        }
        if (bundle != null) {
            this.f4810A = bundle.getString(this.f4812x);
        }
        m894L();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        finish();
        return true;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f4814z;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f4814z;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(this.f4812x, this.f4810A);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }
}
