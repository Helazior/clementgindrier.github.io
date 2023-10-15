package org.ksoap2.serialization;

import java.util.Date;
import org.kobjects.isodate.IsoDate;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MarshalDate implements Marshal {
    public static Class DATE_CLASS = new Date().getClass();

    @Override // org.ksoap2.serialization.Marshal
    public Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo) {
        return IsoDate.stringToDate(xmlPullParser.nextText(), 3);
    }

    @Override // org.ksoap2.serialization.Marshal
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "dateTime", DATE_CLASS, this);
    }

    @Override // org.ksoap2.serialization.Marshal
    public void writeInstance(XmlSerializer xmlSerializer, Object obj) {
        xmlSerializer.text(IsoDate.dateToString((Date) obj, 3));
    }
}
