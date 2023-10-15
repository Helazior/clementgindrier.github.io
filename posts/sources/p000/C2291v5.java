package p000;

import android.graphics.Rect;
import java.util.Comparator;
import p000.AbstractC2229s5;

/* renamed from: v5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2291v5<T> implements Comparator<T> {

    /* renamed from: a */
    public final Rect f6694a = new Rect();

    /* renamed from: b */
    public final Rect f6695b = new Rect();

    /* renamed from: c */
    public final boolean f6696c;

    /* renamed from: d */
    public final InterfaceC2253t5<T> f6697d;

    public C2291v5(boolean z, InterfaceC2253t5<T> interfaceC2253t5) {
        this.f6696c = z;
        this.f6697d = interfaceC2253t5;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.f6694a;
        Rect rect2 = this.f6695b;
        ((AbstractC2229s5.C2230a) this.f6697d).m399a(t, rect);
        ((AbstractC2229s5.C2230a) this.f6697d).m399a(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            return this.f6696c ? 1 : -1;
        } else if (i3 > i4) {
            return this.f6696c ? -1 : 1;
        } else {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.right;
            int i8 = rect2.right;
            if (i7 < i8) {
                return this.f6696c ? 1 : -1;
            } else if (i7 > i8) {
                return this.f6696c ? -1 : 1;
            } else {
                return 0;
            }
        }
    }
}
