package p000;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* renamed from: X */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0546X extends ContextWrapper {

    /* renamed from: a */
    public int f1952a;

    /* renamed from: b */
    public Resources.Theme f1953b;

    /* renamed from: c */
    public LayoutInflater f1954c;

    /* renamed from: d */
    public Configuration f1955d;

    /* renamed from: e */
    public Resources f1956e;

    public C0546X() {
        super(null);
    }

    /* renamed from: a */
    public void m1818a(Configuration configuration) {
        if (this.f1956e == null) {
            if (this.f1955d == null) {
                this.f1955d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* renamed from: b */
    public final void m1817b() {
        if (this.f1953b == null) {
            this.f1953b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1953b.setTo(theme);
            }
        }
        this.f1953b.applyStyle(this.f1952a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f1956e == null) {
            Configuration configuration = this.f1955d;
            if (configuration == null) {
                this.f1956e = super.getResources();
            } else {
                this.f1956e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f1956e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f1954c == null) {
                this.f1954c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f1954c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1953b;
        if (theme != null) {
            return theme;
        }
        if (this.f1952a == 0) {
            this.f1952a = C1988n.Theme_AppCompat_Light;
        }
        m1817b();
        return this.f1953b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f1952a != i) {
            this.f1952a = i;
            m1817b();
        }
    }

    public C0546X(Context context, int i) {
        super(context);
        this.f1952a = i;
    }

    public C0546X(Context context, Resources.Theme theme) {
        super(context);
        this.f1953b = theme;
    }
}
