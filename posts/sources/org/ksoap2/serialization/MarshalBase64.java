package org.ksoap2.serialization;

import org.kobjects.base64.Base64;
import org.ksoap2.SoapEnvelope;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MarshalBase64 implements Marshal {
    public static Class BYTE_ARRAY_CLASS = new byte[0].getClass();

    @Override // org.ksoap2.serialization.Marshal
    public Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo) {
        return Base64.decode(xmlPullParser.nextText());
    }

    @Override // org.ksoap2.serialization.Marshal
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "base64Binary", BYTE_ARRAY_CLASS, this);
        soapSerializationEnvelope.addMapping(SoapEnvelope.ENC, "base64", BYTE_ARRAY_CLASS, this);
    }

    @Override // org.ksoap2.serialization.Marshal
    public void writeInstance(XmlSerializer xmlSerializer, Object obj) {
        xmlSerializer.text(Base64.encode((byte[]) obj));
    }
}
