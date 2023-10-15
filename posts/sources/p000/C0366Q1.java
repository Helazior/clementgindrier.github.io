package p000;

import java.util.HashMap;

/* renamed from: Q1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0366Q1 {

    /* renamed from: a */
    public HashMap<Object, HashMap<String, float[]>> f1247a = new HashMap<>();

    /* renamed from: a */
    public float m2142a(Object obj, String str, int i) {
        if (this.f1247a.containsKey(obj)) {
            HashMap<String, float[]> hashMap = this.f1247a.get(obj);
            if (hashMap.containsKey(str)) {
                float[] fArr = hashMap.get(str);
                if (fArr.length > i) {
                    return fArr[i];
                }
                return Float.NaN;
            }
            return Float.NaN;
        }
        return Float.NaN;
    }
}
