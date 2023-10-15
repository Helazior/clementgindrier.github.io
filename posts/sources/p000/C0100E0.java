package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: E0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0100E0 extends C0076D0 {

    /* renamed from: d */
    public final SeekBar f367d;

    /* renamed from: e */
    public Drawable f368e;

    /* renamed from: f */
    public ColorStateList f369f;

    /* renamed from: g */
    public PorterDuff.Mode f370g;

    /* renamed from: h */
    public boolean f371h;

    /* renamed from: i */
    public boolean f372i;

    public C0100E0(SeekBar seekBar) {
        super(seekBar);
        this.f369f = null;
        this.f370g = null;
        this.f371h = false;
        this.f372i = false;
        this.f367d = seekBar;
    }

    @Override // p000.C0076D0
    /* renamed from: a */
    public void mo2474a(AttributeSet attributeSet, int i) {
        super.mo2474a(attributeSet, i);
        Context context = this.f367d.getContext();
        int[] iArr = C2012o.AppCompatSeekBar;
        C0954b1 m1196r = C0954b1.m1196r(context, attributeSet, iArr, i, 0);
        SeekBar seekBar = this.f367d;
        C0492V4.m1951t(seekBar, seekBar.getContext(), iArr, attributeSet, m1196r.f3660b, i, 0);
        Drawable m1206h = m1196r.m1206h(C2012o.AppCompatSeekBar_android_thumb);
        if (m1206h != null) {
            this.f367d.setThumb(m1206h);
        }
        Drawable m1207g = m1196r.m1207g(C2012o.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f368e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f368e = m1207g;
        if (m1207g != null) {
            m1207g.setCallback(this.f367d);
            SeekBar seekBar2 = this.f367d;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            LayoutInflater$Factory2C0000A.C0010h.m2632j0(m1207g, C0492V4.C0496d.m1921d(seekBar2));
            if (m1207g.isStateful()) {
                m1207g.setState(this.f367d.getDrawableState());
            }
            m2473c();
        }
        this.f367d.invalidate();
        int i2 = C2012o.AppCompatSeekBar_tickMarkTintMode;
        if (m1196r.m1198p(i2)) {
            this.f370g = C0263L0.m2226c(m1196r.m1204j(i2, -1), this.f370g);
            this.f372i = true;
        }
        int i3 = C2012o.AppCompatSeekBar_tickMarkTint;
        if (m1196r.m1198p(i3)) {
            this.f369f = m1196r.m1211c(i3);
            this.f371h = true;
        }
        m1196r.f3660b.recycle();
        m2473c();
    }

    /* renamed from: c */
    public final void m2473c() {
        Drawable drawable = this.f368e;
        if (drawable != null) {
            if (this.f371h || this.f372i) {
                Drawable m2604x0 = LayoutInflater$Factory2C0000A.C0010h.m2604x0(drawable.mutate());
                this.f368e = m2604x0;
                if (this.f371h) {
                    m2604x0.setTintList(this.f369f);
                }
                if (this.f372i) {
                    this.f368e.setTintMode(this.f370g);
                }
                if (this.f368e.isStateful()) {
                    this.f368e.setState(this.f367d.getDrawableState());
                }
            }
        }
    }

    /* renamed from: d */
    public void m2472d(Canvas canvas) {
        if (this.f368e != null) {
            int max = this.f367d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f368e.getIntrinsicWidth();
                int intrinsicHeight = this.f368e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f368e.setBounds(-i, -i2, i, i2);
                float width = ((this.f367d.getWidth() - this.f367d.getPaddingLeft()) - this.f367d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f367d.getPaddingLeft(), this.f367d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f368e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
