package org.ksoap2.serialization;

import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.SoapFault12;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SoapSerializationEnvelope extends SoapEnvelope {
    private static final String ANY_TYPE_LABEL = "anyType";
    private static final String ARRAY_MAPPING_NAME = "Array";
    private static final String ARRAY_TYPE_LABEL = "arrayType";
    public static final Marshal DEFAULT_MARSHAL = new C2072DM();
    private static final String HREF_LABEL = "href";
    private static final String ID_LABEL = "id";
    private static final String ITEM_LABEL = "item";
    private static final String NIL_LABEL = "nil";
    private static final String NULL_LABEL = "null";
    public static final int QNAME_MARSHAL = 3;
    public static final int QNAME_NAMESPACE = 0;
    public static final int QNAME_TYPE = 1;
    private static final String ROOT_LABEL = "root";
    private static final String TYPE_LABEL = "type";
    public static /* synthetic */ Class class$org$ksoap2$serialization$SoapObject;
    public boolean addAdornments;
    public boolean avoidExceptionForUnknownProperty;
    public Hashtable classToQName;
    public boolean dotNet;
    public Hashtable idMap;
    public boolean implicitTypes;
    public Vector multiRef;
    public Hashtable properties;
    public Hashtable qNameToClass;

    public SoapSerializationEnvelope(int i) {
        super(i);
        this.properties = new Hashtable();
        this.idMap = new Hashtable();
        this.qNameToClass = new Hashtable();
        this.classToQName = new Hashtable();
        this.addAdornments = true;
        addMapping(this.enc, ARRAY_MAPPING_NAME, PropertyInfo.VECTOR_CLASS);
        DEFAULT_MARSHAL.register(this);
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private int getIndex(String str, int i, int i2) {
        return (str != null && str.length() - i >= 3) ? Integer.parseInt(str.substring(i + 1, str.length() - 1)) : i2;
    }

    private void writeElement(XmlSerializer xmlSerializer, Object obj, PropertyInfo propertyInfo, Object obj2) {
        if (obj2 != null) {
            ((Marshal) obj2).writeInstance(xmlSerializer, obj);
        } else if (obj instanceof SoapObject) {
            writeObjectBody(xmlSerializer, (SoapObject) obj);
        } else if (obj instanceof KvmSerializable) {
            writeObjectBody(xmlSerializer, (KvmSerializable) obj);
        } else if (obj instanceof Vector) {
            writeVectorBody(xmlSerializer, (Vector) obj, propertyInfo.elementType);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot serialize: ");
            stringBuffer.append(obj);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public void addMapping(String str, String str2, Class cls, Marshal marshal) {
        this.qNameToClass.put(new SoapPrimitive(str, str2, null), marshal == 0 ? cls : marshal);
        this.classToQName.put(cls.getName(), new Object[]{str, str2, null, marshal});
    }

    public void addTemplate(SoapObject soapObject) {
        this.qNameToClass.put(new SoapPrimitive(soapObject.namespace, soapObject.name, null), soapObject);
    }

    public Object[] getInfo(Object obj, Object obj2) {
        Object[] objArr;
        if (obj == null) {
            obj = ((obj2 instanceof SoapObject) || (obj2 instanceof SoapPrimitive)) ? obj2 : obj2.getClass();
        }
        if (obj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) obj;
            return new Object[]{soapObject.getNamespace(), soapObject.getName(), null, null};
        } else if (!(obj instanceof SoapPrimitive)) {
            return (!(obj instanceof Class) || obj == PropertyInfo.OBJECT_CLASS || (objArr = (Object[]) this.classToQName.get(((Class) obj).getName())) == null) ? new Object[]{this.xsd, ANY_TYPE_LABEL, null, null} : objArr;
        } else {
            SoapPrimitive soapPrimitive = (SoapPrimitive) obj;
            return new Object[]{soapPrimitive.getNamespace(), soapPrimitive.getName(), null, DEFAULT_MARSHAL};
        }
    }

    public Object getResponse() {
        Object obj = this.bodyIn;
        if (!(obj instanceof SoapFault)) {
            KvmSerializable kvmSerializable = (KvmSerializable) obj;
            if (kvmSerializable.getPropertyCount() == 0) {
                return null;
            }
            if (kvmSerializable.getPropertyCount() == 1) {
                return kvmSerializable.getProperty(0);
            }
            Vector vector = new Vector();
            for (int i = 0; i < kvmSerializable.getPropertyCount(); i++) {
                vector.add(kvmSerializable.getProperty(i));
            }
            return vector;
        }
        throw ((SoapFault) obj);
    }

    public boolean isAddAdornments() {
        return this.addAdornments;
    }

    @Override // org.ksoap2.SoapEnvelope
    public void parseBody(XmlPullParser xmlPullParser) {
        SoapFault soapFault12;
        this.bodyIn = null;
        xmlPullParser.nextTag();
        if (xmlPullParser.getEventType() == 2 && xmlPullParser.getNamespace().equals(this.env) && xmlPullParser.getName().equals("Fault")) {
            if (this.version < 120) {
                soapFault12 = new SoapFault(this.version);
            } else {
                soapFault12 = new SoapFault12(this.version);
            }
            soapFault12.parse(xmlPullParser);
            this.bodyIn = soapFault12;
            return;
        }
        while (xmlPullParser.getEventType() == 2) {
            String attributeValue = xmlPullParser.getAttributeValue(this.enc, ROOT_LABEL);
            Object read = read(xmlPullParser, null, -1, xmlPullParser.getNamespace(), xmlPullParser.getName(), PropertyInfo.OBJECT_TYPE);
            if ("1".equals(attributeValue) || this.bodyIn == null) {
                this.bodyIn = read;
            }
            xmlPullParser.nextTag();
        }
    }

    public Object read(XmlPullParser xmlPullParser, Object obj, int i, String str, String str2, PropertyInfo propertyInfo) {
        Object obj2;
        String name = xmlPullParser.getName();
        String attributeValue = xmlPullParser.getAttributeValue(null, HREF_LABEL);
        if (attributeValue == null) {
            String attributeValue2 = xmlPullParser.getAttributeValue(this.xsi, NIL_LABEL);
            String attributeValue3 = xmlPullParser.getAttributeValue(null, ID_LABEL);
            if (attributeValue2 == null) {
                attributeValue2 = xmlPullParser.getAttributeValue(this.xsi, NULL_LABEL);
            }
            if (attributeValue2 != null && SoapEnvelope.stringToBoolean(attributeValue2)) {
                xmlPullParser.nextTag();
                xmlPullParser.require(3, null, name);
                obj2 = null;
            } else {
                String attributeValue4 = xmlPullParser.getAttributeValue(this.xsi, TYPE_LABEL);
                if (attributeValue4 != null) {
                    int indexOf = attributeValue4.indexOf(58);
                    str2 = attributeValue4.substring(indexOf + 1);
                    str = xmlPullParser.getNamespace(indexOf == -1 ? "" : attributeValue4.substring(0, indexOf));
                } else if (str2 == null && str == null) {
                    if (xmlPullParser.getAttributeValue(this.enc, ARRAY_TYPE_LABEL) != null) {
                        str = this.enc;
                        str2 = ARRAY_MAPPING_NAME;
                    } else {
                        Object[] info = getInfo(propertyInfo.type, null);
                        String str3 = (String) info[0];
                        str2 = (String) info[1];
                        str = str3;
                    }
                }
                if (attributeValue4 == null) {
                    this.implicitTypes = true;
                }
                Object readInstance = readInstance(xmlPullParser, str, str2, propertyInfo);
                if (readInstance == null) {
                    readInstance = readUnknown(xmlPullParser, str, str2);
                }
                obj2 = readInstance;
            }
            if (attributeValue3 != null) {
                Object obj3 = this.idMap.get(attributeValue3);
                if (obj3 instanceof FwdRef) {
                    FwdRef fwdRef = (FwdRef) obj3;
                    do {
                        Object obj4 = fwdRef.obj;
                        if (obj4 instanceof KvmSerializable) {
                            ((KvmSerializable) obj4).setProperty(fwdRef.index, obj2);
                        } else {
                            ((Vector) obj4).setElementAt(obj2, fwdRef.index);
                        }
                        fwdRef = fwdRef.next;
                    } while (fwdRef != null);
                } else if (obj3 != null) {
                    throw new RuntimeException("double ID");
                }
                this.idMap.put(attributeValue3, obj2);
            }
        } else if (obj != null) {
            String substring = attributeValue.substring(1);
            obj2 = this.idMap.get(substring);
            if (obj2 == null || (obj2 instanceof FwdRef)) {
                FwdRef fwdRef2 = new FwdRef();
                fwdRef2.next = (FwdRef) obj2;
                fwdRef2.obj = obj;
                fwdRef2.index = i;
                this.idMap.put(substring, fwdRef2);
                obj2 = null;
            }
            xmlPullParser.nextTag();
            xmlPullParser.require(3, null, name);
        } else {
            throw new RuntimeException("href at root level?!?");
        }
        xmlPullParser.require(3, null, name);
        return obj2;
    }

    public Object readInstance(XmlPullParser xmlPullParser, String str, String str2, PropertyInfo propertyInfo) {
        Object newInstance;
        Object obj = this.qNameToClass.get(new SoapPrimitive(str, str2, null));
        if (obj == null) {
            return null;
        }
        if (obj instanceof Marshal) {
            return ((Marshal) obj).readInstance(xmlPullParser, str, str2, propertyInfo);
        }
        if (obj instanceof SoapObject) {
            newInstance = ((SoapObject) obj).newInstance();
        } else {
            Class cls = class$org$ksoap2$serialization$SoapObject;
            if (cls == null) {
                cls = class$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = cls;
            }
            if (obj == cls) {
                newInstance = new SoapObject(str, str2);
            } else {
                try {
                    newInstance = ((Class) obj).newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e.toString());
                }
            }
        }
        if (newInstance instanceof SoapObject) {
            readSerializable(xmlPullParser, (SoapObject) newInstance);
        } else if (newInstance instanceof KvmSerializable) {
            readSerializable(xmlPullParser, (KvmSerializable) newInstance);
        } else if (newInstance instanceof Vector) {
            readVector(xmlPullParser, (Vector) newInstance, propertyInfo.elementType);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("no deserializer for ");
            stringBuffer.append(newInstance.getClass());
            throw new RuntimeException(stringBuffer.toString());
        }
        return newInstance;
    }

    public void readSerializable(XmlPullParser xmlPullParser, SoapObject soapObject) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            soapObject.addAttribute(xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
        }
        readSerializable(xmlPullParser, (KvmSerializable) soapObject);
    }

    public Object readUnknown(XmlPullParser xmlPullParser, String str, String str2) {
        AttributeContainer attributeContainer;
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        Vector vector = new Vector();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            AttributeInfo attributeInfo = new AttributeInfo();
            attributeInfo.setName(xmlPullParser.getAttributeName(i));
            attributeInfo.setValue(xmlPullParser.getAttributeValue(i));
            attributeInfo.setNamespace(xmlPullParser.getAttributeNamespace(i));
            attributeInfo.setType(xmlPullParser.getAttributeType(i));
            vector.addElement(attributeInfo);
        }
        xmlPullParser.next();
        String str3 = null;
        if (xmlPullParser.getEventType() == 4) {
            str3 = xmlPullParser.getText();
            attributeContainer = new SoapPrimitive(str, str2, str3);
            for (int i2 = 0; i2 < vector.size(); i2++) {
                attributeContainer.addAttribute((AttributeInfo) vector.elementAt(i2));
            }
            xmlPullParser.next();
        } else if (xmlPullParser.getEventType() == 3) {
            attributeContainer = new SoapObject(str, str2);
            for (int i3 = 0; i3 < vector.size(); i3++) {
                attributeContainer.addAttribute((AttributeInfo) vector.elementAt(i3));
            }
        } else {
            attributeContainer = null;
        }
        if (xmlPullParser.getEventType() == 2) {
            if (str3 != null && str3.trim().length() != 0) {
                throw new RuntimeException("Malformed input: Mixed content");
            }
            SoapObject soapObject = new SoapObject(str, str2);
            for (int i4 = 0; i4 < vector.size(); i4++) {
                soapObject.addAttribute((AttributeInfo) vector.elementAt(i4));
            }
            while (xmlPullParser.getEventType() != 3) {
                soapObject.addProperty(xmlPullParser.getName(), read(xmlPullParser, soapObject, soapObject.getPropertyCount(), null, null, PropertyInfo.OBJECT_TYPE));
                xmlPullParser.nextTag();
            }
            attributeContainer = soapObject;
        }
        xmlPullParser.require(3, namespace, name);
        return attributeContainer;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readVector(org.xmlpull.p019v1.XmlPullParser r18, java.util.Vector r19, org.ksoap2.serialization.PropertyInfo r20) {
        /*
            r17 = this;
            r7 = r17
            r8 = r18
            r9 = r19
            int r0 = r19.size()
            java.lang.String r1 = r7.enc
            java.lang.String r2 = "arrayType"
            java.lang.String r1 = r8.getAttributeValue(r1, r2)
            r2 = 1
            r10 = 0
            r11 = 0
            if (r1 == 0) goto L49
            r0 = 58
            int r0 = r1.indexOf(r0)
            java.lang.String r3 = "["
            int r3 = r1.indexOf(r3, r0)
            int r4 = r0 + 1
            java.lang.String r4 = r1.substring(r4, r3)
            r5 = -1
            if (r0 != r5) goto L2f
            java.lang.String r0 = ""
            goto L33
        L2f:
            java.lang.String r0 = r1.substring(r11, r0)
        L33:
            java.lang.String r0 = r8.getNamespace(r0)
            int r1 = r7.getIndex(r1, r3, r5)
            if (r1 == r5) goto L45
            r9.setSize(r1)
            r12 = r0
            r0 = r1
            r14 = r4
            r13 = 0
            goto L4c
        L45:
            r12 = r0
            r0 = r1
            r14 = r4
            goto L4b
        L49:
            r12 = r10
            r14 = r12
        L4b:
            r13 = 1
        L4c:
            if (r20 != 0) goto L52
            org.ksoap2.serialization.PropertyInfo r1 = org.ksoap2.serialization.PropertyInfo.OBJECT_TYPE
            r15 = r1
            goto L54
        L52:
            r15 = r20
        L54:
            r18.nextTag()
            java.lang.String r1 = r7.enc
            java.lang.String r2 = "offset"
            java.lang.String r1 = r8.getAttributeValue(r1, r2)
            int r1 = r7.getIndex(r1, r11, r11)
        L63:
            int r2 = r18.getEventType()
            r3 = 3
            if (r2 == r3) goto L9c
            java.lang.String r2 = r7.enc
            java.lang.String r3 = "position"
            java.lang.String r2 = r8.getAttributeValue(r2, r3)
            int r6 = r7.getIndex(r2, r11, r1)
            if (r13 == 0) goto L7f
            if (r6 < r0) goto L7f
            int r0 = r6 + 1
            r9.setSize(r0)
        L7f:
            r16 = r0
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r6
            r4 = r12
            r5 = r14
            r11 = r6
            r6 = r15
            java.lang.Object r0 = r0.read(r1, r2, r3, r4, r5, r6)
            r9.setElementAt(r0, r11)
            int r1 = r11 + 1
            r18.nextTag()
            r0 = r16
            r11 = 0
            goto L63
        L9c:
            r8.require(r3, r10, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ksoap2.serialization.SoapSerializationEnvelope.readVector(org.xmlpull.v1.XmlPullParser, java.util.Vector, org.ksoap2.serialization.PropertyInfo):void");
    }

    public void setAddAdornments(boolean z) {
        this.addAdornments = z;
    }

    public void setBodyOutEmpty(boolean z) {
        if (z) {
            this.bodyOut = null;
        }
    }

    @Override // org.ksoap2.SoapEnvelope
    public void writeBody(XmlSerializer xmlSerializer) {
        if (this.bodyOut != null) {
            Vector vector = new Vector();
            this.multiRef = vector;
            vector.addElement(this.bodyOut);
            Object[] info = getInfo(null, this.bodyOut);
            xmlSerializer.startTag(this.dotNet ? "" : (String) info[0], (String) info[1]);
            if (this.dotNet) {
                xmlSerializer.attribute(null, "xmlns", (String) info[0]);
            }
            if (this.addAdornments) {
                xmlSerializer.attribute(null, ID_LABEL, info[2] == null ? "o0" : (String) info[2]);
                xmlSerializer.attribute(this.enc, ROOT_LABEL, "1");
            }
            writeElement(xmlSerializer, this.bodyOut, null, info[3]);
            xmlSerializer.endTag(this.dotNet ? "" : (String) info[0], (String) info[1]);
        }
    }

    public void writeObjectBody(XmlSerializer xmlSerializer, SoapObject soapObject) {
        int attributeCount = soapObject.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            AttributeInfo attributeInfo = new AttributeInfo();
            soapObject.getAttributeInfo(i, attributeInfo);
            xmlSerializer.attribute(attributeInfo.getNamespace(), attributeInfo.getName(), attributeInfo.getValue().toString());
        }
        writeObjectBody(xmlSerializer, (KvmSerializable) soapObject);
    }

    public void writeProperty(XmlSerializer xmlSerializer, Object obj, PropertyInfo propertyInfo) {
        StringBuffer stringBuffer;
        if (obj == null) {
            xmlSerializer.attribute(this.xsi, this.version >= 120 ? NIL_LABEL : NULL_LABEL, "true");
            return;
        }
        Object[] info = getInfo(null, obj);
        if (!propertyInfo.multiRef && info[2] == null) {
            if (!this.implicitTypes || obj.getClass() != propertyInfo.type) {
                String prefix = xmlSerializer.getPrefix((String) info[0], true);
                String str = this.xsi;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(prefix);
                stringBuffer2.append(":");
                stringBuffer2.append(info[1]);
                xmlSerializer.attribute(str, TYPE_LABEL, stringBuffer2.toString());
            }
            writeElement(xmlSerializer, obj, propertyInfo, info[3]);
            return;
        }
        int indexOf = this.multiRef.indexOf(obj);
        if (indexOf == -1) {
            indexOf = this.multiRef.size();
            this.multiRef.addElement(obj);
        }
        if (info[2] == null) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("#o");
            stringBuffer.append(indexOf);
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("#");
            stringBuffer.append(info[2]);
        }
        xmlSerializer.attribute(null, HREF_LABEL, stringBuffer.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeVectorBody(org.xmlpull.p019v1.XmlSerializer r12, java.util.Vector r13, org.ksoap2.serialization.PropertyInfo r14) {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = "item"
            if (r14 != 0) goto L8
            org.ksoap2.serialization.PropertyInfo r14 = org.ksoap2.serialization.PropertyInfo.OBJECT_TYPE
            goto Lf
        L8:
            java.lang.String r2 = r14.name
            if (r2 == 0) goto Lf
            java.lang.String r1 = r14.namespace
            goto L11
        Lf:
            r2 = r1
            r1 = r0
        L11:
            int r3 = r13.size()
            java.lang.Object r4 = r14.type
            java.lang.Object[] r0 = r11.getInfo(r4, r0)
            boolean r4 = r11.implicitTypes
            java.lang.String r5 = "]"
            java.lang.String r6 = "["
            r7 = 1
            r8 = 0
            if (r4 != 0) goto L54
            java.lang.String r4 = r11.enc
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            r10 = r0[r8]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r10 = r12.getPrefix(r10, r8)
            r9.append(r10)
            java.lang.String r10 = ":"
            r9.append(r10)
            r0 = r0[r7]
            r9.append(r0)
            r9.append(r6)
            r9.append(r3)
            r9.append(r5)
            java.lang.String r0 = r9.toString()
            java.lang.String r9 = "arrayType"
            r12.attribute(r4, r9, r0)
            goto L5b
        L54:
            if (r1 != 0) goto L5b
            r0 = r0[r8]
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L5b:
            r0 = 0
            r4 = 0
        L5d:
            if (r0 >= r3) goto L93
            java.lang.Object r9 = r13.elementAt(r0)
            if (r9 != 0) goto L67
            r4 = 1
            goto L90
        L67:
            r12.startTag(r1, r2)
            if (r4 == 0) goto L86
            java.lang.String r4 = r11.enc
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            r9.append(r6)
            r9.append(r0)
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "position"
            r12.attribute(r4, r10, r9)
            r4 = 0
        L86:
            java.lang.Object r9 = r13.elementAt(r0)
            r11.writeProperty(r12, r9, r14)
            r12.endTag(r1, r2)
        L90:
            int r0 = r0 + 1
            goto L5d
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ksoap2.serialization.SoapSerializationEnvelope.writeVectorBody(org.xmlpull.v1.XmlSerializer, java.util.Vector, org.ksoap2.serialization.PropertyInfo):void");
    }

    public void addMapping(String str, String str2, Class cls) {
        addMapping(str, str2, cls, null);
    }

    public void readSerializable(XmlPullParser xmlPullParser, KvmSerializable kvmSerializable) {
        while (xmlPullParser.nextTag() != 3) {
            String name = xmlPullParser.getName();
            if (this.implicitTypes && (kvmSerializable instanceof SoapObject)) {
                ((SoapObject) kvmSerializable).addProperty(xmlPullParser.getName(), read(xmlPullParser, kvmSerializable, kvmSerializable.getPropertyCount(), ((SoapObject) kvmSerializable).getNamespace(), name, PropertyInfo.OBJECT_TYPE));
            } else {
                PropertyInfo propertyInfo = new PropertyInfo();
                int propertyCount = kvmSerializable.getPropertyCount();
                boolean z = false;
                for (int i = 0; i < propertyCount && !z; i++) {
                    propertyInfo.clear();
                    kvmSerializable.getPropertyInfo(i, this.properties, propertyInfo);
                    if ((name.equals(propertyInfo.name) && propertyInfo.namespace == null) || (name.equals(propertyInfo.name) && xmlPullParser.getNamespace().equals(propertyInfo.namespace))) {
                        kvmSerializable.setProperty(i, read(xmlPullParser, kvmSerializable, i, null, null, propertyInfo));
                        z = true;
                    }
                }
                if (z) {
                    continue;
                } else if (!this.avoidExceptionForUnknownProperty) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unknown Property: ");
                    stringBuffer.append(name);
                    throw new RuntimeException(stringBuffer.toString());
                } else {
                    while (true) {
                        if (xmlPullParser.next() != 3 || !name.equals(xmlPullParser.getName())) {
                        }
                    }
                }
            }
        }
        xmlPullParser.require(3, null, null);
    }

    public void writeObjectBody(XmlSerializer xmlSerializer, KvmSerializable kvmSerializable) {
        String str;
        String str2;
        int propertyCount = kvmSerializable.getPropertyCount();
        PropertyInfo propertyInfo = new PropertyInfo();
        for (int i = 0; i < propertyCount; i++) {
            Object property = kvmSerializable.getProperty(i);
            kvmSerializable.getPropertyInfo(i, this.properties, propertyInfo);
            if (!(property instanceof SoapObject)) {
                if ((propertyInfo.flags & 1) == 0) {
                    xmlSerializer.startTag(propertyInfo.namespace, propertyInfo.name);
                    writeProperty(xmlSerializer, kvmSerializable.getProperty(i), propertyInfo);
                    xmlSerializer.endTag(propertyInfo.namespace, propertyInfo.name);
                }
            } else {
                SoapObject soapObject = (SoapObject) property;
                Object[] info = getInfo(null, soapObject);
                String str3 = (String) info[0];
                String str4 = (String) info[1];
                String str5 = propertyInfo.name;
                if (str5 != null && str5.length() > 0) {
                    str = propertyInfo.name;
                } else {
                    str = (String) info[1];
                }
                String str6 = propertyInfo.namespace;
                if (str6 != null && str6.length() > 0) {
                    str2 = propertyInfo.namespace;
                } else {
                    str2 = (String) info[0];
                }
                xmlSerializer.startTag(str2, str);
                if (!this.implicitTypes) {
                    String prefix = xmlSerializer.getPrefix(str2, true);
                    String str7 = this.xsi;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(prefix);
                    stringBuffer.append(":");
                    stringBuffer.append(str4);
                    xmlSerializer.attribute(str7, TYPE_LABEL, stringBuffer.toString());
                }
                writeObjectBody(xmlSerializer, soapObject);
                xmlSerializer.endTag(str2, str);
            }
        }
    }
}
