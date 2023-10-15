package org.ksoap2.serialization;

import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Marshal {
    Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo);

    void register(SoapSerializationEnvelope soapSerializationEnvelope);

    void writeInstance(XmlSerializer xmlSerializer, Object obj);
}
