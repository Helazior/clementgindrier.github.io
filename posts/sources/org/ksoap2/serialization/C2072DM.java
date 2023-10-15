package org.ksoap2.serialization;

import org.ksoap2.SoapEnvelope;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* renamed from: org.ksoap2.serialization.DM */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2072DM implements Marshal {
    @Override // org.ksoap2.serialization.Marshal
    public Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo) {
        String nextText = xmlPullParser.nextText();
        char charAt = str2.charAt(0);
        if (charAt != 'b') {
            if (charAt != 'i') {
                if (charAt != 'l') {
                    if (charAt == 's') {
                        return nextText;
                    }
                    throw new RuntimeException();
                }
                return new Long(Long.parseLong(nextText));
            }
            return new Integer(Integer.parseInt(nextText));
        }
        return new Boolean(SoapEnvelope.stringToBoolean(nextText));
    }

    @Override // org.ksoap2.serialization.Marshal
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "int", PropertyInfo.INTEGER_CLASS, this);
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "long", PropertyInfo.LONG_CLASS, this);
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "string", PropertyInfo.STRING_CLASS, this);
        soapSerializationEnvelope.addMapping(soapSerializationEnvelope.xsd, "boolean", PropertyInfo.BOOLEAN_CLASS, this);
    }

    @Override // org.ksoap2.serialization.Marshal
    public void writeInstance(XmlSerializer xmlSerializer, Object obj) {
        if (obj instanceof AttributeContainer) {
            AttributeContainer attributeContainer = (AttributeContainer) obj;
            int attributeCount = attributeContainer.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                AttributeInfo attributeInfo = new AttributeInfo();
                attributeContainer.getAttributeInfo(i, attributeInfo);
                xmlSerializer.attribute(attributeInfo.getNamespace(), attributeInfo.getName(), attributeInfo.getValue().toString());
            }
        }
        xmlSerializer.text(obj.toString());
    }
}
