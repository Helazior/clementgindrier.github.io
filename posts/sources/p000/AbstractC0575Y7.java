package p000;

/* renamed from: Y7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0575Y7 extends AbstractC0250K7 {

    /* renamed from: a */
    public static final String[] f2043a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    /* renamed from: b */
    public static int m1774b(C0290M7 c0290m7, int i) {
        int[] iArr;
        if (c0290m7 == null || (iArr = (int[]) c0290m7.f970a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }

    /* renamed from: c */
    public int m1773c(C0290M7 c0290m7) {
        Integer num;
        if (c0290m7 == null || (num = (Integer) c0290m7.f970a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }
}
