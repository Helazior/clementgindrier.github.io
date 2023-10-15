package fr.smoney.android.izly.p005ui.privateview.news;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.ActuDetail;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.MessageBundle;
import p000.C2307w3;

/* renamed from: fr.smoney.android.izly.ui.privateview.news.ActusDetailActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ActusDetailActivity extends SmoneyABSActivity<AbstractC2236s9> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener {

    /* renamed from: x */
    public String f4803x;

    /* renamed from: y */
    public SessionStateReceiver f4804y;

    /* renamed from: fr.smoney.android.izly.ui.privateview.news.ActusDetailActivity$SessionStateReceiver */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class SessionStateReceiver extends BroadcastReceiver {
        public SessionStateReceiver(ActusDetailActivity actusDetailActivity) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            C0581Yd.m1766e(context, "context");
            C0581Yd.m1766e(intent, "intent");
            intent.getIntExtra("fr.smoney.android.izly.sessionState", -1);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492895;
    }

    /* renamed from: L */
    public final void m896L(@NotNull ActuDetail actuDetail) {
        C0581Yd.m1766e(actuDetail, ErrorBundle.DETAIL_ENTRY);
        String str = actuDetail.f4227h;
        if (str != null) {
            Glide.with((FragmentActivity) this).asBitmap().load(Base64.decode(str, 0)).placeholder(2131230812).fitCenter().into(((AbstractC2236s9) this.f4202w).f6399c);
            ImageView imageView = ((AbstractC2236s9) this.f4202w).f6399c;
            C0581Yd.m1767d(imageView, "mDataBinding.ivActuDetail");
            Drawable drawable = imageView.getDrawable();
            Object obj = C2307w3.f6741a;
            if (C0581Yd.m1770a(drawable, C2307w3.C2310c.m202b(this, 2131230812))) {
                ImageView imageView2 = ((AbstractC2236s9) this.f4202w).f6399c;
                C0581Yd.m1767d(imageView2, "mDataBinding.ivActuDetail");
                imageView2.setVisibility(8);
            }
            TextView textView = ((AbstractC2236s9) this.f4202w).f6402g;
            C0581Yd.m1767d(textView, "mDataBinding.tvActuDetailTitle");
            String str2 = actuDetail.f4222b;
            if (str2 != null) {
                textView.setText(str2);
                TextView textView2 = ((AbstractC2236s9) this.f4202w).f6400d;
                C0581Yd.m1767d(textView2, "mDataBinding.tvActuDetailDescriptionOne");
                String str3 = actuDetail.f4224d;
                if (str3 != null) {
                    textView2.setText(str3);
                    TextView textView3 = ((AbstractC2236s9) this.f4202w).f6401f;
                    C0581Yd.m1767d(textView3, "mDataBinding.tvActuDetailText");
                    String str4 = actuDetail.f4225f;
                    if (str4 != null) {
                        textView3.setText(str4);
                        String str5 = actuDetail.f4228i;
                        this.f4803x = str5;
                        if (str5 != null) {
                            C0581Yd.m1766e(str5, "$this$compareTo");
                            C0581Yd.m1766e("none", "other");
                            if (str5.compareToIgnoreCase("none") == 0) {
                                Button button = ((AbstractC2236s9) this.f4202w).f6398b;
                                C0581Yd.m1767d(button, "mDataBinding.btnGoWebsite");
                                button.setVisibility(8);
                            }
                            ((AbstractC2236s9) this.f4202w).f6398b.setOnClickListener(this);
                            return;
                        }
                        C0581Yd.m1761j("url");
                        throw null;
                    }
                    C0581Yd.m1761j("longDesc");
                    throw null;
                }
                C0581Yd.m1761j("shortDesc");
                throw null;
            }
            C0581Yd.m1761j(MessageBundle.TITLE_ENTRY);
            throw null;
        }
        C0581Yd.m1761j("image");
        throw null;
    }

    /* renamed from: M */
    public final void m895M(ActuDetail actuDetail, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (actuDetail == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            m896L(actuDetail);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 271) {
                m895M((ActuDetail) bundle.getParcelable("fr.smoney.android.izly.extras.ActuDetailData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 4) {
            this.f4197r.m106q(enumC1631dd);
            return;
        }
        this.f4197r.m130A();
        this.f4197r.m129B();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        if (enumC1631dd == null || enumC1631dd.ordinal() != 9) {
            this.f4197r.m100w(enumC1631dd, bundle);
        } else if (m982H() != 271) {
            this.f4197r.m100w(enumC1631dd, bundle);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: l */
    public void mo237l(@Nullable EnumC1631dd enumC1631dd) {
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 9) {
                if (m982H() == 271) {
                    Objects.requireNonNull(SmoneyApplication.f4205d);
                    this.f4197r.m129B();
                    return;
                }
                this.f4197r.m103t(enumC1631dd);
                return;
            } else if (ordinal == 52) {
                this.f4197r.m129B();
                return;
            }
        }
        this.f4197r.m103t(enumC1631dd);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        if (i == 271) {
            Objects.requireNonNull(this.f4197r.f6816a);
            Objects.requireNonNull(this.f4197r.f6816a);
            m895M(null, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        if (C0581Yd.m1770a(view, ((AbstractC2236s9) this.f4202w).f6398b)) {
            String str = this.f4803x;
            if (str != null) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } else {
                C0581Yd.m1761j("url");
                throw null;
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689533), "getString(R.string.actus_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230938, getString(2131689531), EnumC1687fd.LONG_APPBAR_WITH_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, (r19 & 128) != 0 ? false : false);
        ActuDetail actuDetail = SmoneyApplication.f4210j;
        C0581Yd.m1767d(actuDetail, "SmoneyApplication.objectToBePassed");
        m896L(actuDetail);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        this.f2196f.m1721a();
        return true;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        unregisterReceiver(this.f4804y);
        this.f4804y = null;
        super.onPause();
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
        if (this.f4804y == null) {
            this.f4804y = new SessionStateReceiver(this);
        }
        registerReceiver(this.f4804y, intentFilter);
    }
}
