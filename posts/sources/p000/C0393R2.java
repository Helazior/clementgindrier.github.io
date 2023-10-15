package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.p019v1.XmlPullParser;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: R2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0393R2 {

    /* renamed from: a */
    public String f1323a;

    /* renamed from: b */
    public EnumC0394a f1324b;

    /* renamed from: c */
    public int f1325c;

    /* renamed from: d */
    public float f1326d;

    /* renamed from: e */
    public String f1327e;

    /* renamed from: f */
    public boolean f1328f;

    /* renamed from: g */
    public int f1329g;

    /* renamed from: R2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC0394a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public C0393R2(String str, EnumC0394a enumC0394a, Object obj) {
        this.f1323a = str;
        this.f1324b = enumC0394a;
        m2047h(obj);
    }

    /* renamed from: a */
    public static int m2054a(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    /* renamed from: e */
    public static void m2050e(Context context, XmlPullParser xmlPullParser, HashMap<String, C0393R2> hashMap) {
        EnumC0394a enumC0394a;
        Object string;
        EnumC0394a enumC0394a2 = EnumC0394a.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0533W2.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        EnumC0394a enumC0394a3 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == C0533W2.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == C0533W2.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                enumC0394a3 = EnumC0394a.BOOLEAN_TYPE;
            } else {
                if (index == C0533W2.CustomAttribute_customColorValue) {
                    enumC0394a = EnumC0394a.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == C0533W2.CustomAttribute_customColorDrawableValue) {
                    enumC0394a = EnumC0394a.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else {
                    if (index == C0533W2.CustomAttribute_customPixelDimension) {
                        obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                    } else if (index == C0533W2.CustomAttribute_customDimension) {
                        obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                    } else if (index == C0533W2.CustomAttribute_customFloatValue) {
                        enumC0394a = EnumC0394a.FLOAT_TYPE;
                        string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == C0533W2.CustomAttribute_customIntegerValue) {
                        enumC0394a = EnumC0394a.INT_TYPE;
                        string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                    } else if (index == C0533W2.CustomAttribute_customStringValue) {
                        enumC0394a = EnumC0394a.STRING_TYPE;
                        string = obtainStyledAttributes.getString(index);
                    }
                    enumC0394a3 = enumC0394a2;
                }
                Object obj2 = string;
                enumC0394a3 = enumC0394a;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new C0393R2(str, enumC0394a3, obj));
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: f */
    public static void m2049f(View view, HashMap<String, C0393R2> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            C0393R2 c0393r2 = hashMap.get(str);
            String m266e = outline.m266e("set", str);
            try {
                switch (c0393r2.f1324b.ordinal()) {
                    case 0:
                        cls.getMethod(m266e, Integer.TYPE).invoke(view, Integer.valueOf(c0393r2.f1325c));
                        break;
                    case 1:
                        cls.getMethod(m266e, Float.TYPE).invoke(view, Float.valueOf(c0393r2.f1326d));
                        break;
                    case 2:
                        cls.getMethod(m266e, Integer.TYPE).invoke(view, Integer.valueOf(c0393r2.f1329g));
                        break;
                    case 3:
                        Method method = cls.getMethod(m266e, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(c0393r2.f1329g);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(m266e, CharSequence.class).invoke(view, c0393r2.f1327e);
                        break;
                    case 5:
                        cls.getMethod(m266e, Boolean.TYPE).invoke(view, Boolean.valueOf(c0393r2.f1328f));
                        break;
                    case 6:
                        cls.getMethod(m266e, Float.TYPE).invoke(view, Float.valueOf(c0393r2.f1326d));
                        break;
                }
            } catch (IllegalAccessException e) {
                StringBuilder m251t = outline.m251t(" Custom Attribute \"", str, "\" not found on ");
                m251t.append(cls.getName());
                Log.e("TransitionLayout", m251t.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(m266e);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                StringBuilder m251t2 = outline.m251t(" Custom Attribute \"", str, "\" not found on ");
                m251t2.append(cls.getName());
                Log.e("TransitionLayout", m251t2.toString());
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public float m2053b() {
        switch (this.f1324b.ordinal()) {
            case 0:
                return this.f1325c;
            case 1:
                return this.f1326d;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.f1328f ? 1.0f : 0.0f;
            case 6:
                return this.f1326d;
            default:
                return Float.NaN;
        }
    }

    /* renamed from: c */
    public void m2052c(float[] fArr) {
        switch (this.f1324b.ordinal()) {
            case 0:
                fArr[0] = this.f1325c;
                return;
            case 1:
                fArr[0] = this.f1326d;
                return;
            case 2:
            case 3:
                int i = this.f1329g;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.f1328f ? 1.0f : 0.0f;
                return;
            case 6:
                fArr[0] = this.f1326d;
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    public int m2051d() {
        int ordinal = this.f1324b.ordinal();
        return (ordinal == 2 || ordinal == 3) ? 4 : 1;
    }

    /* renamed from: g */
    public void m2048g(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        StringBuilder m253r = outline.m253r("set");
        m253r.append(this.f1323a);
        String sb = m253r.toString();
        try {
            boolean z = true;
            switch (this.f1324b.ordinal()) {
                case 0:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((m2054a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m2054a((int) (fArr[3] * 255.0f)) << 24) | (m2054a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m2054a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(sb, Drawable.class);
                    int m2054a = m2054a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
                    int m2054a2 = m2054a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((m2054a << 16) | (m2054a((int) (fArr[3] * 255.0f)) << 24) | (m2054a2 << 8) | m2054a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + this.f1323a);
                case 5:
                    Method method2 = cls.getMethod(sb, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view, objArr);
                    return;
                case 6:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            StringBuilder m251t = outline.m251t("cannot access method ", sb, "on View \"");
            m251t.append(LayoutInflater$Factory2C0000A.C0010h.m2673E(view));
            m251t.append("\"");
            Log.e("TransitionLayout", m251t.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            StringBuilder m251t2 = outline.m251t("no method ", sb, "on View \"");
            m251t2.append(LayoutInflater$Factory2C0000A.C0010h.m2673E(view));
            m251t2.append("\"");
            Log.e("TransitionLayout", m251t2.toString());
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: h */
    public void m2047h(Object obj) {
        switch (this.f1324b.ordinal()) {
            case 0:
                this.f1325c = ((Integer) obj).intValue();
                return;
            case 1:
                this.f1326d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f1329g = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1327e = (String) obj;
                return;
            case 5:
                this.f1328f = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.f1326d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public C0393R2(C0393R2 c0393r2, Object obj) {
        this.f1323a = c0393r2.f1323a;
        this.f1324b = c0393r2.f1324b;
        m2047h(obj);
    }
}
