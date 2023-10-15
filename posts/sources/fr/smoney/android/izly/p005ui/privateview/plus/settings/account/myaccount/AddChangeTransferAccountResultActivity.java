package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.items.KeyValueObject;
import fr.smoney.android.izly.data.model.MakeBankAccountUpdateData;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.myaccount.AddChangeTransferAccountResultActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AddChangeTransferAccountResultActivity extends SmoneyABSActivity<AbstractC0338O9> implements View.OnClickListener {

    /* renamed from: A */
    public String f4805A;

    /* renamed from: x */
    public String f4806x;

    /* renamed from: y */
    public String f4807y;

    /* renamed from: z */
    public String f4808z;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492906;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "v");
        if (view == ((AbstractC0338O9) this.f4202w).f1145b) {
            setResult(-1);
            finish();
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689522);
        C0581Yd.m1767d(string, "getString(R.string.account_info_title)");
        c0297a.m2194a(this, string, null, getString(2131689523), EnumC1687fd.LONG_APPBAR_WITH_DESCRIPTION, EnumC0161Gd.COLOR_GREY, false, false);
        Intent intent = getIntent();
        C0581Yd.m1767d(intent, "intent");
        Bundle extras = intent.getExtras();
        ((AbstractC0338O9) this.f4202w).f1145b.setOnClickListener(this);
        if (extras != null) {
            MakeBankAccountUpdateData makeBankAccountUpdateData = (MakeBankAccountUpdateData) extras.getParcelable("fr.smoney.android.izly.extras.addTransferAccountData");
            if (makeBankAccountUpdateData != null) {
                this.f4808z = makeBankAccountUpdateData.f4391a;
                this.f4806x = makeBankAccountUpdateData.f4395f;
                this.f4807y = makeBankAccountUpdateData.f4396g;
                this.f4805A = !TextUtils.isEmpty(makeBankAccountUpdateData.f4392b) ? makeBankAccountUpdateData.f4392b : null;
            }
            String str = this.f4808z;
            String str2 = this.f4806x;
            String str3 = this.f4807y;
            String str4 = this.f4805A;
            ArrayList<KeyValueObject> arrayList = new ArrayList<>();
            arrayList.add(new KeyValueObject(getString(2131689512), str));
            arrayList.add(new KeyValueObject(getString(2131689519), str2));
            arrayList.add(new KeyValueObject(getString(2131689516), str3));
            if (str4 != null) {
                arrayList.add(new KeyValueObject(getString(2131689513), str4));
            }
            ((AbstractC0338O9) this.f4202w).f1146c.m819a(arrayList);
            return;
        }
        throw new RuntimeException("AddTransferAccountActivity.INTENT_EXTRAS_MODE is mandatory!");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @Nullable KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        setResult(-1);
        finish();
        return true;
    }
}
