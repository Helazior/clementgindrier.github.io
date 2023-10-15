package p000;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;

/* renamed from: T1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0444T1 {

    /* renamed from: b */
    public static HashMap<String, Constructor<? extends AbstractC0328O1>> f1449b;

    /* renamed from: a */
    public HashMap<Integer, ArrayList<AbstractC0328O1>> f1450a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends AbstractC0328O1>> hashMap = new HashMap<>();
        f1449b = hashMap;
        try {
            hashMap.put("KeyAttribute", C0346P1.class.getConstructor(new Class[0]));
            f1449b.put("KeyPosition", C0466U1.class.getConstructor(new Class[0]));
            f1449b.put("KeyCycle", C0391R1.class.getConstructor(new Class[0]));
            f1449b.put("KeyTimeCycle", C0531W1.class.getConstructor(new Class[0]));
            f1449b.put("KeyTrigger", C0548X1.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public C0444T1(Context context, XmlPullParser xmlPullParser) {
        Exception e;
        AbstractC0328O1 abstractC0328O1;
        HashMap<String, C0393R2> hashMap;
        try {
            int eventType = xmlPullParser.getEventType();
            AbstractC0328O1 abstractC0328O12 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (f1449b.containsKey(name)) {
                        try {
                            abstractC0328O1 = f1449b.get(name).newInstance(new Object[0]);
                            try {
                                abstractC0328O1.mo1814c(context, Xml.asAttributeSet(xmlPullParser));
                                m2033b(abstractC0328O1);
                            } catch (Exception e2) {
                                e = e2;
                                Log.e("KeyFrames", "unable to create ", e);
                                abstractC0328O12 = abstractC0328O1;
                                continue;
                                eventType = xmlPullParser.next();
                            }
                        } catch (Exception e3) {
                            AbstractC0328O1 abstractC0328O13 = abstractC0328O12;
                            e = e3;
                            abstractC0328O1 = abstractC0328O13;
                        }
                        abstractC0328O12 = abstractC0328O1;
                        continue;
                    } else if (name.equalsIgnoreCase("CustomAttribute") && abstractC0328O12 != null && (hashMap = abstractC0328O12.f1116d) != null) {
                        C0393R2.m2050e(context, xmlPullParser, hashMap);
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m2034a(C0585Z1 c0585z1) {
        ArrayList<AbstractC0328O1> arrayList = this.f1450a.get(Integer.valueOf(c0585z1.f2073b));
        if (arrayList != null) {
            c0585z1.f2093v.addAll(arrayList);
        }
        ArrayList<AbstractC0328O1> arrayList2 = this.f1450a.get(-1);
        if (arrayList2 != null) {
            Iterator<AbstractC0328O1> it = arrayList2.iterator();
            while (it.hasNext()) {
                AbstractC0328O1 next = it.next();
                String str = ((ConstraintLayout.LayoutParams) c0585z1.f2072a.getLayoutParams()).f2860U;
                String str2 = next.f1115c;
                if ((str2 == null || str == null) ? false : str.matches(str2)) {
                    c0585z1.f2093v.add(next);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m2033b(AbstractC0328O1 abstractC0328O1) {
        if (!this.f1450a.containsKey(Integer.valueOf(abstractC0328O1.f1114b))) {
            this.f1450a.put(Integer.valueOf(abstractC0328O1.f1114b), new ArrayList<>());
        }
        this.f1450a.get(Integer.valueOf(abstractC0328O1.f1114b)).add(abstractC0328O1);
    }
}
