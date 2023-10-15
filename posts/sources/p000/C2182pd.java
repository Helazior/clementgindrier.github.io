package p000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pdfview.subsamplincscaleimageview.SubsamplingScaleImageView;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.ActuDetail;
import fr.smoney.android.izly.data.model.ActuList;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.helpers.SessionStateReceiver;
import fr.smoney.android.izly.p005ui.privateview.news.ActusDetailActivity;
import java.util.Locale;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0069Cc;
import p000.C0296Md;

/* renamed from: pd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2182pd extends AbstractC0044B8<AbstractC2198q9> implements SmoneyRequestManager.InterfaceC1778a, C0069Cc.InterfaceC0070a {

    /* renamed from: j */
    public SessionStateReceiver f6251j;

    /* renamed from: k */
    public C0069Cc f6252k;

    /* renamed from: pd$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2183a implements InterfaceC1879hd {
        public C2183a() {
        }

        @Override // p000.InterfaceC1879hd
        /* renamed from: a */
        public void mo2a(@NotNull Context context, @Nullable Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1768c(intent);
            if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
                C2182pd.this.m437w();
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f197b.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 270) {
                m436x((ActuList) bundle.getParcelable("fr.smoney.android.izly.extras.ActuListData"), serverError);
            }
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 4) {
            this.f197b.m106q(enumC1631dd);
            return;
        }
        this.f197b.m130A();
        AppCompatActivity appCompatActivity = this.f201g;
        if (appCompatActivity instanceof InterfaceC1928jd) {
            Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
            ((InterfaceC1928jd) appCompatActivity).mo681m();
        }
    }

    @Override // p000.C0069Cc.InterfaceC0070a
    /* renamed from: j */
    public void mo438j(@Nullable ActuDetail actuDetail) {
        SmoneyApplication.f4210j = actuDetail;
        startActivity(new Intent(getContext(), ActusDetailActivity.class));
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f197b.m100w(enumC1631dd, bundle);
        } else if (m2556r() == 270) {
            m437w();
        } else {
            this.f197b.m100w(enumC1631dd, bundle);
        }
    }

    @Override // p000.AbstractC0044B8, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m2556r() == 270) {
                    Objects.requireNonNull(SmoneyApplication.f4205d);
                    AppCompatActivity appCompatActivity = this.f201g;
                    if (appCompatActivity instanceof InterfaceC1928jd) {
                        Objects.requireNonNull(appCompatActivity, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                        ((InterfaceC1928jd) appCompatActivity).mo681m();
                        return;
                    }
                    return;
                }
                this.f197b.m103t(enumC1631dd);
                return;
            } else if (ordinal == 52) {
                AppCompatActivity appCompatActivity2 = this.f201g;
                if (appCompatActivity2 instanceof InterfaceC1928jd) {
                    Objects.requireNonNull(appCompatActivity2, "null cannot be cast to non-null type fr.smoney.android.izly.ui.listener.ReturnToHomeListener");
                    ((InterfaceC1928jd) appCompatActivity2).mo681m();
                    return;
                }
                return;
            }
        }
        this.f197b.m103t(enumC1631dd);
    }

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo236m() {
        return 2131492894;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        if (i == 270) {
            Objects.requireNonNull(this.f197b.f6816a);
            Objects.requireNonNull(this.f197b.f6816a);
            m436x(null, null);
        }
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        AppCompatActivity appCompatActivity = this.f201g;
        C0296Md.C0297a c0297a = C0296Md.f999a;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        String string = getString(2131689533);
        C0581Yd.m1767d(string, "getString(R.string.actus_title)");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        String upperCase = string.toUpperCase(locale);
        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        c0297a.m2194a(appCompatActivity, upperCase, 2131230938, getString(2131689531), EnumC1687fd.LONG_APPBAR_WITH_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, false, (r19 & 128) != 0 ? false : false);
        super.onActivityCreated(bundle);
        m437w();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppCompatActivity appCompatActivity = this.f201g;
        C0581Yd.m1767d(appCompatActivity, "mActivity");
        this.f6251j = new SessionStateReceiver(appCompatActivity, new C2183a());
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C0581Yd.m1766e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Object obj = this.f202h;
        C0581Yd.m1767d(obj, "mDataBinding");
        return ((AbstractC2198q9) obj).getRoot();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onPause() {
        SessionStateReceiver sessionStateReceiver = this.f6251j;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m938b();
        super.onPause();
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SessionStateReceiver sessionStateReceiver = this.f6251j;
        C0581Yd.m1768c(sessionStateReceiver);
        sessionStateReceiver.m939a();
    }

    /* renamed from: w */
    public final void m437w() {
        int i;
        C2387y8 c2387y8 = this.f197b;
        SmoneyRequestManager smoneyRequestManager = c2387y8.f6817b;
        LoginData loginData = c2387y8.f6816a.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 270 && valueAt.getStringExtra("fr.smoney.android.izly.extras.actuListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.actuListSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", SubsamplingScaleImageView.ORIENTATION_270);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.actuListUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.actuListSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                Objects.requireNonNull(smoneyRequestManager.f4693f);
                i = nextInt;
                break;
            }
        }
        this.f197b.m120c(i, SubsamplingScaleImageView.ORIENTATION_270, true);
    }

    /* renamed from: x */
    public final void m436x(ActuList actuList, ServerError serverError) {
        if (serverError != null) {
            this.f197b.m124G(serverError);
        } else if (actuList == null) {
            this.f197b.m126E(C0580Yc.m1772t(getContext(), this));
        } else if (!actuList.m974a().isEmpty()) {
            C0581Yd.m1766e(actuList, "list");
            RecyclerView recyclerView = ((AbstractC2198q9) this.f202h).f6296b;
            C0581Yd.m1767d(recyclerView, "this");
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            this.f6252k = new C0069Cc(actuList, this);
            RecyclerView recyclerView2 = ((AbstractC2198q9) this.f202h).f6296b;
            C0581Yd.m1767d(recyclerView2, "mDataBinding.rvActus");
            C0069Cc c0069Cc = this.f6252k;
            if (c0069Cc != null) {
                recyclerView2.setAdapter(c0069Cc);
            } else {
                C0581Yd.m1761j("actusAdapter");
                throw null;
            }
        }
    }
}
