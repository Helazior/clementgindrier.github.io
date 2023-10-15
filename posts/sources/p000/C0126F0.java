package p000;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;

/* renamed from: F0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0126F0 extends AbstractView$OnTouchListenerC0325O0 {

    /* renamed from: k */
    public final /* synthetic */ AppCompatSpinner.C0665d f430k;

    /* renamed from: l */
    public final /* synthetic */ AppCompatSpinner f431l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0126F0(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner.C0665d c0665d) {
        super(view);
        this.f431l = appCompatSpinner;
        this.f430k = c0665d;
    }

    @Override // p000.AbstractView$OnTouchListenerC0325O0
    /* renamed from: b */
    public InterfaceC2222s0 mo1640b() {
        return this.f430k;
    }

    @Override // p000.AbstractView$OnTouchListenerC0325O0
    @SuppressLint({"SyntheticAccessor"})
    /* renamed from: c */
    public boolean mo1639c() {
        if (this.f431l.f2476g.mo1632a()) {
            return true;
        }
        this.f431l.m1634b();
        return true;
    }
}
