package p000;

import java.util.List;

/* renamed from: D3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0086D3 {

    /* renamed from: a */
    public final int[] f346a;

    /* renamed from: b */
    public final float[] f347b;

    public C0086D3(List<Integer> list, List<Float> list2) {
        int size = list.size();
        this.f346a = new int[size];
        this.f347b = new float[size];
        for (int i = 0; i < size; i++) {
            this.f346a[i] = list.get(i).intValue();
            this.f347b[i] = list2.get(i).floatValue();
        }
    }

    public C0086D3(int i, int i2) {
        this.f346a = new int[]{i, i2};
        this.f347b = new float[]{0.0f, 1.0f};
    }

    public C0086D3(int i, int i2, int i3) {
        this.f346a = new int[]{i, i2, i3};
        this.f347b = new float[]{0.0f, 0.5f, 1.0f};
    }
}
