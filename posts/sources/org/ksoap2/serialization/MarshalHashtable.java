package org.ksoap2.serialization;

import java.util.Enumeration;
import java.util.Hashtable;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MarshalHashtable implements Marshal {
    public static final Class HASHTABLE_CLASS = new Hashtable().getClass();
    public static final String NAME = "Map";
    public static final String NAMESPACE = "http://xml.apache.org/xml-soap";
    public SoapSerializationEnvelope envelope;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ItemSoapObject extends SoapObject {

        /* renamed from: h */
        public Hashtable f5634h;
        public int resolvedIndex;
        private final /* synthetic */ MarshalHashtable this$0;

        public ItemSoapObject(MarshalHashtable marshalHashtable, Hashtable hashtable) {
            super(null, null);
            this.this$0 = marshalHashtable;
            this.resolvedIndex = -1;
            this.f5634h = hashtable;
            addProperty("key", null);
            addProperty("value", null);
        }

        @Override // org.ksoap2.serialization.SoapObject, org.ksoap2.serialization.KvmSerializable
        public void setProperty(int i, Object obj) {
            int i2 = this.resolvedIndex;
            if (i2 == -1) {
                super.setProperty(i, obj);
                this.resolvedIndex = i;
                return;
            }
            Object property = getProperty(i2 == 0 ? 0 : 1);
            if (i == 0) {
                this.f5634h.put(obj, property);
            } else {
                this.f5634h.put(property, obj);
            }
        }
    }

    @Override // org.ksoap2.serialization.Marshal
    public Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo) {
        Hashtable hashtable = new Hashtable();
        String name = xmlPullParser.getName();
        while (xmlPullParser.nextTag() != 3) {
            ItemSoapObject itemSoapObject = new ItemSoapObject(this, hashtable);
            xmlPullParser.require(2, null, "item");
            xmlPullParser.nextTag();
            SoapSerializationEnvelope soapSerializationEnvelope = this.envelope;
            PropertyInfo propertyInfo2 = PropertyInfo.OBJECT_TYPE;
            Object read = soapSerializationEnvelope.read(xmlPullParser, itemSoapObject, 0, null, null, propertyInfo2);
            xmlPullParser.nextTag();
            if (read != null) {
                itemSoapObject.setProperty(0, read);
            }
            Object read2 = this.envelope.read(xmlPullParser, itemSoapObject, 1, null, null, propertyInfo2);
            xmlPullParser.nextTag();
            if (read2 != null) {
                itemSoapObject.setProperty(1, read2);
            }
            xmlPullParser.require(3, null, "item");
        }
        xmlPullParser.require(3, null, name);
        return hashtable;
    }

    @Override // org.ksoap2.serialization.Marshal
    public void register(SoapSerializationEnvelope soapSerializationEnvelope) {
        this.envelope = soapSerializationEnvelope;
        soapSerializationEnvelope.addMapping(NAMESPACE, NAME, HASHTABLE_CLASS, this);
    }

    @Override // org.ksoap2.serialization.Marshal
    public void writeInstance(XmlSerializer xmlSerializer, Object obj) {
        Hashtable hashtable = (Hashtable) obj;
        SoapObject soapObject = new SoapObject(null, null);
        soapObject.addProperty("key", null);
        soapObject.addProperty("value", null);
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            xmlSerializer.startTag("", "item");
            Object nextElement = keys.nextElement();
            soapObject.setProperty(0, nextElement);
            soapObject.setProperty(1, hashtable.get(nextElement));
            this.envelope.writeObjectBody(xmlSerializer, soapObject);
            xmlSerializer.endTag("", "item");
        }
    }
}
