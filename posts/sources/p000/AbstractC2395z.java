package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* renamed from: z */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2394z {

    /* renamed from: a */
    public static final C2396z1<WeakReference<AbstractC2394z>> f6895a = new C2396z1<>(0);

    /* renamed from: b */
    public static final Object f6896b = new Object();

    /* renamed from: q */
    public static void m29q(AbstractC2394z abstractC2394z) {
        synchronized (f6896b) {
            Iterator<WeakReference<AbstractC2394z>> it = f6895a.iterator();
            while (it.hasNext()) {
                AbstractC2394z abstractC2394z2 = it.next().get();
                if (abstractC2394z2 == abstractC2394z || abstractC2394z2 == null) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: a */
    public abstract void mo45a(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: b */
    public Context mo44b(Context context) {
        return context;
    }

    /* renamed from: c */
    public abstract <T extends View> T mo43c(int i);

    /* renamed from: d */
    public int mo42d() {
        return -100;
    }

    /* renamed from: e */
    public abstract MenuInflater mo41e();

    /* renamed from: f */
    public abstract ActionBar mo40f();

    /* renamed from: g */
    public abstract void mo39g();

    /* renamed from: h */
    public abstract void mo38h();

    /* renamed from: i */
    public abstract void mo37i(Configuration configuration);

    /* renamed from: j */
    public abstract void mo36j(Bundle bundle);

    /* renamed from: k */
    public abstract void mo35k();

    /* renamed from: l */
    public abstract void mo34l(Bundle bundle);

    /* renamed from: m */
    public abstract void mo33m();

    /* renamed from: n */
    public abstract void mo32n(Bundle bundle);

    /* renamed from: o */
    public abstract void mo31o();

    /* renamed from: p */
    public abstract void mo30p();

    /* renamed from: r */
    public abstract boolean mo28r(int i);

    /* renamed from: s */
    public abstract void mo27s(int i);

    /* renamed from: t */
    public abstract void mo26t(View view);

    /* renamed from: u */
    public abstract void mo25u(View view, ViewGroup.LayoutParams layoutParams);

    /* renamed from: v */
    public abstract void mo24v(Toolbar toolbar);

    /* renamed from: w */
    public void mo23w(int i) {
    }

    /* renamed from: x */
    public abstract void mo22x(CharSequence charSequence);
}
