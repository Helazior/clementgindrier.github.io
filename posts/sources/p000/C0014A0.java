package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: A0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0014A0 {

    /* renamed from: a */
    public final CompoundButton f105a;

    /* renamed from: b */
    public ColorStateList f106b = null;

    /* renamed from: c */
    public PorterDuff.Mode f107c = null;

    /* renamed from: d */
    public boolean f108d = false;

    /* renamed from: e */
    public boolean f109e = false;

    /* renamed from: f */
    public boolean f110f;

    public C0014A0(CompoundButton compoundButton) {
        this.f105a = compoundButton;
    }

    /* renamed from: a */
    public void m2599a() {
        Drawable m2677A = LayoutInflater$Factory2C0000A.C0010h.m2677A(this.f105a);
        if (m2677A != null) {
            if (this.f108d || this.f109e) {
                Drawable mutate = LayoutInflater$Factory2C0000A.C0010h.m2604x0(m2677A).mutate();
                if (this.f108d) {
                    mutate.setTintList(this.f106b);
                }
                if (this.f109e) {
                    mutate.setTintMode(this.f107c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f105a.getDrawableState());
                }
                this.f105a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b A[Catch: all -> 0x0068, TRY_ENTER, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x001b, B:5:0x0023, B:7:0x0029, B:11:0x003b, B:13:0x0043, B:15:0x0049, B:16:0x0056, B:18:0x005e, B:21:0x006a, B:23:0x0072), top: B:31:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: all -> 0x0068, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x001b, B:5:0x0023, B:7:0x0029, B:11:0x003b, B:13:0x0043, B:15:0x0049, B:16:0x0056, B:18:0x005e, B:21:0x006a, B:23:0x0072), top: B:31:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072 A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #1 {all -> 0x0068, blocks: (B:3:0x001b, B:5:0x0023, B:7:0x0029, B:11:0x003b, B:13:0x0043, B:15:0x0049, B:16:0x0056, B:18:0x005e, B:21:0x006a, B:23:0x0072), top: B:31:0x001b }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2598b(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f105a
            android.content.Context r0 = r0.getContext()
            int[] r3 = p000.C2012o.CompoundButton
            r8 = 0
            b1 r0 = p000.C0954b1.m1196r(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f105a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.f3660b
            r7 = 0
            r4 = r10
            r6 = r11
            p000.C0492V4.m1951t(r1, r2, r3, r4, r5, r6, r7)
            int r10 = p000.C2012o.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L68
            boolean r11 = r0.m1198p(r10)     // Catch: java.lang.Throwable -> L68
            if (r11 == 0) goto L38
            int r10 = r0.m1201m(r10, r8)     // Catch: java.lang.Throwable -> L68
            if (r10 == 0) goto L38
            android.widget.CompoundButton r11 = r9.f105a     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L68
            android.content.Context r1 = r11.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L68
            android.graphics.drawable.Drawable r10 = p000.C0279M.m2210b(r1, r10)     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L68
            r11.setButtonDrawable(r10)     // Catch: android.content.res.Resources.NotFoundException -> L38 java.lang.Throwable -> L68
            r10 = 1
            goto L39
        L38:
            r10 = 0
        L39:
            if (r10 != 0) goto L56
            int r10 = p000.C2012o.CompoundButton_android_button     // Catch: java.lang.Throwable -> L68
            boolean r11 = r0.m1198p(r10)     // Catch: java.lang.Throwable -> L68
            if (r11 == 0) goto L56
            int r10 = r0.m1201m(r10, r8)     // Catch: java.lang.Throwable -> L68
            if (r10 == 0) goto L56
            android.widget.CompoundButton r11 = r9.f105a     // Catch: java.lang.Throwable -> L68
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L68
            android.graphics.drawable.Drawable r10 = p000.C0279M.m2210b(r1, r10)     // Catch: java.lang.Throwable -> L68
            r11.setButtonDrawable(r10)     // Catch: java.lang.Throwable -> L68
        L56:
            int r10 = p000.C2012o.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L68
            boolean r11 = r0.m1198p(r10)     // Catch: java.lang.Throwable -> L68
            if (r11 == 0) goto L6a
            android.widget.CompoundButton r11 = r9.f105a     // Catch: java.lang.Throwable -> L68
            android.content.res.ColorStateList r10 = r0.m1211c(r10)     // Catch: java.lang.Throwable -> L68
            r11.setButtonTintList(r10)     // Catch: java.lang.Throwable -> L68
            goto L6a
        L68:
            r10 = move-exception
            goto L87
        L6a:
            int r10 = p000.C2012o.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L68
            boolean r11 = r0.m1198p(r10)     // Catch: java.lang.Throwable -> L68
            if (r11 == 0) goto L81
            android.widget.CompoundButton r11 = r9.f105a     // Catch: java.lang.Throwable -> L68
            r1 = -1
            int r10 = r0.m1204j(r10, r1)     // Catch: java.lang.Throwable -> L68
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = p000.C0263L0.m2226c(r10, r1)     // Catch: java.lang.Throwable -> L68
            r11.setButtonTintMode(r10)     // Catch: java.lang.Throwable -> L68
        L81:
            android.content.res.TypedArray r10 = r0.f3660b
            r10.recycle()
            return
        L87:
            android.content.res.TypedArray r11 = r0.f3660b
            r11.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0014A0.m2598b(android.util.AttributeSet, int):void");
    }
}
