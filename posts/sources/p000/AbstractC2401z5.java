package p000;

import android.util.FloatProperty;

/* renamed from: z5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2400z5<T> {
    public final String mPropertyName;

    /* renamed from: z5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2401a extends AbstractC2400z5<T> {

        /* renamed from: a */
        public final /* synthetic */ FloatProperty f6916a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2401a(String str, FloatProperty floatProperty) {
            super(str);
            this.f6916a = floatProperty;
        }

        @Override // p000.AbstractC2400z5
        public float getValue(T t) {
            return ((Float) this.f6916a.get(t)).floatValue();
        }

        @Override // p000.AbstractC2400z5
        public void setValue(T t, float f) {
            this.f6916a.setValue(t, f);
        }
    }

    public AbstractC2400z5(String str) {
        this.mPropertyName = str;
    }

    public static <T> AbstractC2400z5<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new C2401a(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);
}
