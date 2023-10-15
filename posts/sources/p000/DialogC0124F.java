package p000;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import java.lang.ref.WeakReference;
import p000.AbstractC0485V;
import p000.C0195I4;

/* renamed from: F */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DialogC0124F extends Dialog implements InterfaceC2360y {
    private AbstractC2394z mDelegate;
    private final C0195I4.InterfaceC0196a mKeyDispatcher;

    /* renamed from: F$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0125a implements C0195I4.InterfaceC0196a {
        public C0125a() {
        }

        @Override // p000.C0195I4.InterfaceC0196a
        /* renamed from: e */
        public boolean mo1514e(KeyEvent keyEvent) {
            return DialogC0124F.this.superDispatchKeyEvent(keyEvent);
        }
    }

    public DialogC0124F(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C1671f.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo45a(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().mo35k();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0195I4.m2385b(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) getDelegate().mo43c(i);
    }

    public AbstractC2394z getDelegate() {
        if (this.mDelegate == null) {
            C2396z1<WeakReference<AbstractC2394z>> c2396z1 = AbstractC2394z.f6895a;
            this.mDelegate = new LayoutInflater$Factory2C0000A(getContext(), getWindow(), this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().mo40f();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().mo38h();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().mo39g();
        super.onCreate(bundle);
        getDelegate().mo36j(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().mo30p();
    }

    @Override // p000.InterfaceC2360y
    public void onSupportActionModeFinished(AbstractC0485V abstractC0485V) {
    }

    @Override // p000.InterfaceC2360y
    public void onSupportActionModeStarted(AbstractC0485V abstractC0485V) {
    }

    @Override // p000.InterfaceC2360y
    public AbstractC0485V onWindowStartingSupportActionMode(AbstractC0485V.InterfaceC0486a interfaceC0486a) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        getDelegate().mo27s(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().mo22x(charSequence);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().mo28r(i);
    }

    public DialogC0124F(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new C0125a();
        AbstractC2394z delegate = getDelegate();
        delegate.mo23w(getThemeResId(context, i));
        delegate.mo36j(null);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().mo26t(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().mo25u(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().mo22x(getContext().getString(i));
    }

    public DialogC0124F(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new C0125a();
    }
}
