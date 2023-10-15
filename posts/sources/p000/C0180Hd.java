package p000;

import android.text.method.NumberKeyListener;

/* renamed from: Hd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0180Hd extends NumberKeyListener {

    /* renamed from: g */
    public static final char[][] f590g = {new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'}, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ','}, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ','}};

    /* renamed from: a */
    public char[] f591a;

    /* renamed from: b */
    public boolean f592b;

    /* renamed from: c */
    public int f593c;

    /* renamed from: d */
    public final int f594d;

    /* renamed from: f */
    public Integer f595f;

    public C0180Hd(boolean z, int i, int i2, int i3) {
        this.f592b = z;
        this.f594d = i2;
        if (!z) {
            this.f593c = 0;
        } else if (i == 1) {
            this.f593c = 1;
        } else if (i == 2) {
            this.f593c = 2;
        } else if (i != 3) {
            this.f593c = 0;
        } else {
            this.f593c = 3;
        }
        this.f591a = f590g[this.f593c];
        this.f595f = Integer.valueOf(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d2  */
    @Override // android.text.method.NumberKeyListener, android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence filter(java.lang.CharSequence r17, int r18, int r19, android.text.Spanned r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0180Hd.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }

    @Override // android.text.method.NumberKeyListener
    public char[] getAcceptedChars() {
        return this.f591a;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return (!this.f592b || this.f593c == 0) ? 2 : 8194;
    }
}
