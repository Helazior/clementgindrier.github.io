package org.ksoap2.serialization;

import java.math.BigDecimal;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MarshalFloat implements Marshal {
    public static /* synthetic */ Class class$java$lang$Double;
    public static /* synthetic */ Class class$java$lang$Float;
    public static /* synthetic */ Class class$java$math$BigDecimal;

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.ksoap2.serialization.Marshal
    public Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo) {
        String nextText = xmlPullParser.nextText();
        if (str2.equals("float")) {
            return new Float(nextText);
        }
        if (str2.equals("double")) {
            return new Double(nextText);
        }
        if (str2.equals("decimal")) {
            return new BigDecimal(nextText);
        }
        throw new RuntimeException("float, double, or decimal expected");
    }

    @Override // org.ksoap2.serialization.Marshal
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        String str = soapSerializationEnvelope.xsd;
        Class cls = class$java$lang$Float;
        if (cls == null) {
            cls = class$("java.lang.Float");
            class$java$lang$Float = cls;
        }
        soapSerializationEnvelope.addMapping(str, "float", cls, this);
        String str2 = soapSerializationEnvelope.xsd;
        Class cls2 = class$java$lang$Double;
        if (cls2 == null) {
            cls2 = class$("java.lang.Double");
            class$java$lang$Double = cls2;
        }
        soapSerializationEnvelope.addMapping(str2, "double", cls2, this);
        String str3 = soapSerializationEnvelope.xsd;
        Class cls3 = class$java$math$BigDecimal;
        if (cls3 == null) {
            cls3 = class$("java.math.BigDecimal");
            class$java$math$BigDecimal = cls3;
        }
        soapSerializationEnvelope.addMapping(str3, "decimal", cls3, this);
    }

    @Override // org.ksoap2.serialization.Marshal
    public void writeInstance(XmlSerializer xmlSerializer, Object obj) {
        xmlSerializer.text(obj.toString());
    }
}
