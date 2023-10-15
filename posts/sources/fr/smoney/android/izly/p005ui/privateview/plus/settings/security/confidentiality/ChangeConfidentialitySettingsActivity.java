package fr.smoney.android.izly.p005ui.privateview.plus.settings.security.confidentiality;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.GetConfidentialitySettingsData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.SetConfidentialitySettingsData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.security.confidentiality.ChangeConfidentialitySettingsActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ChangeConfidentialitySettingsActivity extends SmoneyABSActivity<AbstractC1983ma> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener {

    /* renamed from: J */
    public static final /* synthetic */ int f4851J = 0;

    /* renamed from: H */
    public GetConfidentialitySettingsData f4859H;

    /* renamed from: I */
    public SessionStateReceiver f4860I;

    /* renamed from: x */
    public final String f4861x = "savedInstanceStateCurrentParameter";

    /* renamed from: y */
    public final String f4862y = "savedInstanceStateCurrentItemSelected";

    /* renamed from: z */
    public final String f4863z = "savedInstanceStateGetConfidentialitySettings";

    /* renamed from: A */
    public final int f4852A = 1;

    /* renamed from: B */
    public final int f4853B = 2;

    /* renamed from: C */
    public final int f4854C = 3;

    /* renamed from: D */
    public final int f4855D = 4;

    /* renamed from: E */
    public final int f4856E = 5;

    /* renamed from: F */
    public int f4857F = -1;

    /* renamed from: G */
    public int f4858G = -1;

    /* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.security.confidentiality.ChangeConfidentialitySettingsActivity$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1803a implements InterfaceC1879hd {
        public C1803a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                ChangeConfidentialitySettingsActivity changeConfidentialitySettingsActivity = ChangeConfidentialitySettingsActivity.this;
                int i = ChangeConfidentialitySettingsActivity.f4851J;
                changeConfidentialitySettingsActivity.m869M();
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492920;
    }

    /* renamed from: L */
    public final void m870L() {
        Button button = ((AbstractC1983ma) this.f4202w).f5498g;
        C0581Yd.m1767d(button, "mDataBinding.spPhoto");
        String[] stringArray = getResources().getStringArray(2130903040);
        GetConfidentialitySettingsData getConfidentialitySettingsData = this.f4859H;
        C0581Yd.m1768c(getConfidentialitySettingsData);
        button.setText(stringArray[getConfidentialitySettingsData.f4288a]);
        Button button2 = ((AbstractC1983ma) this.f4202w).f5495c;
        C0581Yd.m1767d(button2, "mDataBinding.spFirstnameLastname");
        String[] stringArray2 = getResources().getStringArray(2130903040);
        GetConfidentialitySettingsData getConfidentialitySettingsData2 = this.f4859H;
        C0581Yd.m1768c(getConfidentialitySettingsData2);
        button2.setText(stringArray2[getConfidentialitySettingsData2.f4289b]);
        Button button3 = ((AbstractC1983ma) this.f4202w).f5496d;
        C0581Yd.m1767d(button3, "mDataBinding.spMobile");
        String[] stringArray3 = getResources().getStringArray(2130903040);
        GetConfidentialitySettingsData getConfidentialitySettingsData3 = this.f4859H;
        C0581Yd.m1768c(getConfidentialitySettingsData3);
        button3.setText(stringArray3[getConfidentialitySettingsData3.f4290c]);
        Button button4 = ((AbstractC1983ma) this.f4202w).f5497f;
        C0581Yd.m1767d(button4, "mDataBinding.spNickname");
        String[] stringArray4 = getResources().getStringArray(2130903040);
        GetConfidentialitySettingsData getConfidentialitySettingsData4 = this.f4859H;
        C0581Yd.m1768c(getConfidentialitySettingsData4);
        button4.setText(stringArray4[getConfidentialitySettingsData4.f4291d]);
        Button button5 = ((AbstractC1983ma) this.f4202w).f5493a;
        C0581Yd.m1767d(button5, "mDataBinding.spAddress");
        String[] stringArray5 = getResources().getStringArray(2130903040);
        GetConfidentialitySettingsData getConfidentialitySettingsData5 = this.f4859H;
        C0581Yd.m1768c(getConfidentialitySettingsData5);
        button5.setText(stringArray5[getConfidentialitySettingsData5.f4292f]);
        Button button6 = ((AbstractC1983ma) this.f4202w).f5494b;
        C0581Yd.m1767d(button6, "mDataBinding.spEmail");
        String[] stringArray6 = getResources().getStringArray(2130903040);
        GetConfidentialitySettingsData getConfidentialitySettingsData6 = this.f4859H;
        C0581Yd.m1768c(getConfidentialitySettingsData6);
        button6.setText(stringArray6[getConfidentialitySettingsData6.f4293g]);
    }

    /* renamed from: M */
    public final void m869M() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 171 && valueAt.getStringExtra("fr.smoney.android.izly.extras.getConfidentialitySettingsUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.getConfidentialitySettingsSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 171);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.getConfidentialitySettingsUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.getConfidentialitySettingsSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1692I = null;
                c0479u82.f1693J = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 171, true);
    }

    /* renamed from: N */
    public final void m868N() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        if (this.f4857F == 0) {
            i = this.f4858G;
        } else {
            GetConfidentialitySettingsData getConfidentialitySettingsData = this.f4859H;
            C0581Yd.m1768c(getConfidentialitySettingsData);
            i = getConfidentialitySettingsData.f4288a;
        }
        if (this.f4857F == this.f4852A) {
            i2 = this.f4858G;
        } else {
            GetConfidentialitySettingsData getConfidentialitySettingsData2 = this.f4859H;
            C0581Yd.m1768c(getConfidentialitySettingsData2);
            i2 = getConfidentialitySettingsData2.f4289b;
        }
        if (this.f4857F == this.f4853B) {
            i3 = this.f4858G;
        } else {
            GetConfidentialitySettingsData getConfidentialitySettingsData3 = this.f4859H;
            C0581Yd.m1768c(getConfidentialitySettingsData3);
            i3 = getConfidentialitySettingsData3.f4290c;
        }
        if (this.f4857F == this.f4854C) {
            i4 = this.f4858G;
        } else {
            GetConfidentialitySettingsData getConfidentialitySettingsData4 = this.f4859H;
            C0581Yd.m1768c(getConfidentialitySettingsData4);
            i4 = getConfidentialitySettingsData4.f4291d;
        }
        if (this.f4857F == this.f4855D) {
            i5 = this.f4858G;
        } else {
            GetConfidentialitySettingsData getConfidentialitySettingsData5 = this.f4859H;
            C0581Yd.m1768c(getConfidentialitySettingsData5);
            i5 = getConfidentialitySettingsData5.f4292f;
        }
        if (this.f4857F == this.f4856E) {
            i6 = this.f4858G;
        } else {
            GetConfidentialitySettingsData getConfidentialitySettingsData6 = this.f4859H;
            C0581Yd.m1768c(getConfidentialitySettingsData6);
            i6 = getConfidentialitySettingsData6.f4293g;
        }
        int size = smoneyRequestManager.f4688a.size();
        int i11 = 0;
        while (true) {
            int i12 = i6;
            int i13 = i5;
            int i14 = i4;
            if (i11 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i11);
                int i15 = size;
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 172 && valueAt.getStringExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsSessionId").equals(str2) && valueAt.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsPhoto", -1) == i && valueAt.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsName", -1) == i2 && valueAt.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsPhoneNumber", -1) == i3) {
                    i8 = i14;
                    if (valueAt.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsNickname", -1) == i8) {
                        i9 = i13;
                        if (valueAt.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsAddress", -1) == i9) {
                            int intExtra = valueAt.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsEmail", -1);
                            i10 = i12;
                            if (intExtra == i10) {
                                i7 = smoneyRequestManager.f4688a.keyAt(i11);
                                break;
                            }
                            i11++;
                            i5 = i9;
                            i6 = i10;
                            i4 = i8;
                            size = i15;
                        }
                        i10 = i12;
                        i11++;
                        i5 = i9;
                        i6 = i10;
                        i4 = i8;
                        size = i15;
                    }
                } else {
                    i8 = i14;
                }
                i9 = i13;
                i10 = i12;
                i11++;
                i5 = i9;
                i6 = i10;
                i4 = i8;
                size = i15;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 172);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsPhoto", i);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsName", i2);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsPhoneNumber", i3);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsNickname", i14);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsAddress", i13);
                intent.putExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsEmail", i12);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1694K = null;
                c0479u82.f1695L = null;
                i7 = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i7, 172, true);
    }

    /* renamed from: O */
    public final void m867O(GetConfidentialitySettingsData getConfidentialitySettingsData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (getConfidentialitySettingsData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            this.f4859H = getConfidentialitySettingsData;
            m870L();
        }
    }

    /* renamed from: P */
    public final void m866P(SetConfidentialitySettingsData setConfidentialitySettingsData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (setConfidentialitySettingsData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            int i = this.f4857F;
            if (i == 0) {
                GetConfidentialitySettingsData getConfidentialitySettingsData = this.f4859H;
                C0581Yd.m1768c(getConfidentialitySettingsData);
                getConfidentialitySettingsData.f4288a = this.f4858G;
                Button button = ((AbstractC1983ma) this.f4202w).f5498g;
                C0581Yd.m1767d(button, "mDataBinding.spPhoto");
                button.setText(getResources().getStringArray(2130903040)[this.f4858G]);
            } else if (i == this.f4852A) {
                GetConfidentialitySettingsData getConfidentialitySettingsData2 = this.f4859H;
                C0581Yd.m1768c(getConfidentialitySettingsData2);
                getConfidentialitySettingsData2.f4289b = this.f4858G;
                Button button2 = ((AbstractC1983ma) this.f4202w).f5495c;
                C0581Yd.m1767d(button2, "mDataBinding.spFirstnameLastname");
                button2.setText(getResources().getStringArray(2130903040)[this.f4858G]);
            } else if (i == this.f4853B) {
                GetConfidentialitySettingsData getConfidentialitySettingsData3 = this.f4859H;
                C0581Yd.m1768c(getConfidentialitySettingsData3);
                getConfidentialitySettingsData3.f4290c = this.f4858G;
                Button button3 = ((AbstractC1983ma) this.f4202w).f5496d;
                C0581Yd.m1767d(button3, "mDataBinding.spMobile");
                button3.setText(getResources().getStringArray(2130903040)[this.f4858G]);
            } else if (i == this.f4854C) {
                GetConfidentialitySettingsData getConfidentialitySettingsData4 = this.f4859H;
                C0581Yd.m1768c(getConfidentialitySettingsData4);
                getConfidentialitySettingsData4.f4291d = this.f4858G;
                Button button4 = ((AbstractC1983ma) this.f4202w).f5497f;
                C0581Yd.m1767d(button4, "mDataBinding.spNickname");
                button4.setText(getResources().getStringArray(2130903040)[this.f4858G]);
            } else if (i == this.f4855D) {
                GetConfidentialitySettingsData getConfidentialitySettingsData5 = this.f4859H;
                C0581Yd.m1768c(getConfidentialitySettingsData5);
                getConfidentialitySettingsData5.f4292f = this.f4858G;
                Button button5 = ((AbstractC1983ma) this.f4202w).f5493a;
                C0581Yd.m1767d(button5, "mDataBinding.spAddress");
                button5.setText(getResources().getStringArray(2130903040)[this.f4858G]);
            } else if (i == this.f4856E) {
                GetConfidentialitySettingsData getConfidentialitySettingsData6 = this.f4859H;
                C0581Yd.m1768c(getConfidentialitySettingsData6);
                getConfidentialitySettingsData6.f4293g = this.f4858G;
                Button button6 = ((AbstractC1983ma) this.f4202w).f5494b;
                C0581Yd.m1767d(button6, "mDataBinding.spEmail");
                button6.setText(getResources().getStringArray(2130903040)[this.f4858G]);
            }
            this.f4857F = -1;
            this.f4858G = -1;
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 171) {
                m867O((GetConfidentialitySettingsData) bundle.getParcelable("fr.smoney.android.izly.extras.getConfidentialitySettingsData"), serverError);
            } else if (i2 == 172) {
                m866P((SetConfidentialitySettingsData) bundle.getParcelable("fr.smoney.android.izly.extras.setConfidentialitySettingsData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        int m982H = m982H();
        if (enumC1631dd == EnumC1631dd.ProgressType && (m982H == 171 || m982H == 172)) {
            this.f4197r.m130A();
            finish();
            return;
        }
        this.f4197r.m106q(enumC1631dd);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r4.f4288a != r3) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r4.f4289b != r3) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r4.f4290c != r3) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
        if (r4.f4291d != r3) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        if (r4.f4292f != r3) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
        if (r4.f4293g != r3) goto L12;
     */
    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo238k(@org.jetbrains.annotations.Nullable p000.EnumC1631dd r3, @org.jetbrains.annotations.NotNull android.os.Bundle r4) {
        /*
            r2 = this;
            java.lang.String r0 = "data"
            p000.C0581Yd.m1766e(r4, r0)
            if (r3 != 0) goto L8
            goto L14
        L8:
            int r0 = r3.ordinal()
            r1 = 9
            if (r0 == r1) goto L7f
            r1 = 11
            if (r0 == r1) goto L1b
        L14:
            w8 r0 = r2.f4197r
            r0.m100w(r3, r4)
            goto L98
        L1b:
            java.lang.String r3 = "Data.SelectItem"
            int r3 = r4.getInt(r3)
            r2.f4858G = r3
            int r4 = r2.f4857F
            r0 = 1
            if (r4 != 0) goto L32
            fr.smoney.android.izly.data.model.GetConfidentialitySettingsData r4 = r2.f4859H
            p000.C0581Yd.m1768c(r4)
            int r4 = r4.f4288a
            if (r4 == r3) goto L78
            goto L79
        L32:
            int r1 = r2.f4852A
            if (r4 != r1) goto L40
            fr.smoney.android.izly.data.model.GetConfidentialitySettingsData r4 = r2.f4859H
            p000.C0581Yd.m1768c(r4)
            int r4 = r4.f4289b
            if (r4 == r3) goto L78
            goto L79
        L40:
            int r1 = r2.f4853B
            if (r4 != r1) goto L4e
            fr.smoney.android.izly.data.model.GetConfidentialitySettingsData r4 = r2.f4859H
            p000.C0581Yd.m1768c(r4)
            int r4 = r4.f4290c
            if (r4 == r3) goto L78
            goto L79
        L4e:
            int r1 = r2.f4854C
            if (r4 != r1) goto L5c
            fr.smoney.android.izly.data.model.GetConfidentialitySettingsData r4 = r2.f4859H
            p000.C0581Yd.m1768c(r4)
            int r4 = r4.f4291d
            if (r4 == r3) goto L78
            goto L79
        L5c:
            int r1 = r2.f4855D
            if (r4 != r1) goto L6a
            fr.smoney.android.izly.data.model.GetConfidentialitySettingsData r4 = r2.f4859H
            p000.C0581Yd.m1768c(r4)
            int r4 = r4.f4292f
            if (r4 == r3) goto L78
            goto L79
        L6a:
            int r1 = r2.f4856E
            if (r4 != r1) goto L78
            fr.smoney.android.izly.data.model.GetConfidentialitySettingsData r4 = r2.f4859H
            p000.C0581Yd.m1768c(r4)
            int r4 = r4.f4293g
            if (r4 == r3) goto L78
            goto L79
        L78:
            r0 = 0
        L79:
            if (r0 == 0) goto L98
            r2.m868N()
            goto L98
        L7f:
            int r0 = r2.m982H()
            r1 = 171(0xab, float:2.4E-43)
            if (r0 == r1) goto L95
            r1 = 172(0xac, float:2.41E-43)
            if (r0 == r1) goto L91
            w8 r0 = r2.f4197r
            r0.m100w(r3, r4)
            goto L98
        L91:
            r2.m868N()
            goto L98
        L95:
            r2.m869M()
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.plus.settings.security.confidentiality.ChangeConfidentialitySettingsActivity.mo238k(dd, android.os.Bundle):void");
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m103t(enumC1631dd);
        } else if (m982H() == 171) {
            finish();
        } else {
            this.f4197r.m103t(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 171) {
            m867O(c0479u8.f1692I, c0479u8.f1693J);
        } else if (i == 172) {
            m866P(c0479u8.f1694K, c0479u8.f1695L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "view");
        Object obj = this.f4202w;
        if (view == ((AbstractC1983ma) obj).f5498g) {
            this.f4857F = 0;
            this.f4197r.m126E(C0997cd.m1121s(getString(2131689646), getResources().getTextArray(2130903040), this, EnumC1631dd.ConfidentialitySettingType));
        } else if (view == ((AbstractC1983ma) obj).f5495c) {
            this.f4857F = this.f4852A;
            this.f4197r.m126E(C0997cd.m1121s(getString(2131689643), getResources().getTextArray(2130903040), this, EnumC1631dd.ConfidentialitySettingType));
        } else if (view == ((AbstractC1983ma) obj).f5496d) {
            this.f4857F = this.f4853B;
            this.f4197r.m126E(C0997cd.m1121s(getString(2131689644), getResources().getTextArray(2130903040), this, EnumC1631dd.ConfidentialitySettingType));
        } else if (view == ((AbstractC1983ma) obj).f5497f) {
            this.f4857F = this.f4854C;
            this.f4197r.m126E(C0997cd.m1121s(getString(2131689645), getResources().getTextArray(2130903040), this, EnumC1631dd.ConfidentialitySettingType));
        } else if (view == ((AbstractC1983ma) obj).f5493a) {
            this.f4857F = this.f4855D;
            this.f4197r.m126E(C0997cd.m1121s(getString(2131689639), getResources().getTextArray(2130903040), this, EnumC1631dd.ConfidentialitySettingType));
        } else if (view == ((AbstractC1983ma) obj).f5494b) {
            this.f4857F = this.f4856E;
            this.f4197r.m126E(C0997cd.m1121s(getString(2131689642), getResources().getTextArray(2130903040), this, EnumC1631dd.ConfidentialitySettingType));
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActionBar m1681z = m1681z();
        C0581Yd.m1768c(m1681z);
        m1681z.mo1704q(true);
        m1681z.mo1708m(true);
        ((AbstractC1983ma) this.f4202w).f5498g.setOnClickListener(this);
        ((AbstractC1983ma) this.f4202w).f5495c.setOnClickListener(this);
        ((AbstractC1983ma) this.f4202w).f5496d.setOnClickListener(this);
        ((AbstractC1983ma) this.f4202w).f5497f.setOnClickListener(this);
        ((AbstractC1983ma) this.f4202w).f5493a.setOnClickListener(this);
        ((AbstractC1983ma) this.f4202w).f5494b.setOnClickListener(this);
        this.f4860I = new SessionStateReceiver(this, new C1803a());
        if (bundle != null) {
            this.f4857F = bundle.getInt(this.f4861x);
            this.f4858G = bundle.getInt(this.f4862y);
            this.f4859H = (GetConfidentialitySettingsData) bundle.getParcelable(this.f4863z);
        }
        if (this.f4859H == null) {
            m869M();
        } else {
            m870L();
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

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f4860I;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f4860I;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        bundle.putInt(this.f4861x, this.f4857F);
        bundle.putInt(this.f4862y, this.f4858G);
        bundle.putParcelable(this.f4863z, this.f4859H);
        super.onSaveInstanceState(bundle);
    }
}
