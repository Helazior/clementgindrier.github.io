package org.ksoap2.serialization;

import java.util.Hashtable;
import java.util.Vector;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SoapObject extends AttributeContainer implements KvmSerializable {
    private static final String EMPTY_STRING = "";
    public static /* synthetic */ Class class$java$lang$String;
    public static /* synthetic */ Class class$org$ksoap2$serialization$SoapObject;
    public String name;
    public String namespace;
    public Vector properties;

    public SoapObject() {
        this("", "");
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private Integer propertyIndex(String str) {
        if (str != null) {
            for (int i = 0; i < this.properties.size(); i++) {
                if (str.equals(((PropertyInfo) this.properties.elementAt(i)).getName())) {
                    return new Integer(i);
                }
            }
            return null;
        }
        return null;
    }

    public SoapObject addProperty(String str, Object obj) {
        PropertyInfo propertyInfo = new PropertyInfo();
        propertyInfo.name = str;
        propertyInfo.type = obj == null ? PropertyInfo.OBJECT_CLASS : obj.getClass();
        propertyInfo.value = obj;
        return addProperty(propertyInfo);
    }

    public SoapObject addPropertyIfValue(String str, Object obj) {
        return obj != null ? addProperty(str, obj) : this;
    }

    public SoapObject addSoapObject(SoapObject soapObject) {
        this.properties.addElement(soapObject);
        return this;
    }

    public boolean equals(Object obj) {
        int size;
        if (obj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) obj;
            if (this.name.equals(soapObject.name) && this.namespace.equals(soapObject.namespace) && (size = this.properties.size()) == soapObject.properties.size()) {
                for (int i = 0; i < size; i++) {
                    if (!soapObject.isPropertyEqual(this.properties.elementAt(i), i)) {
                        return false;
                    }
                }
                return attributesAreEqual(soapObject);
            }
            return false;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public Object getPrimitiveProperty(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            PropertyInfo propertyInfo = (PropertyInfo) this.properties.elementAt(propertyIndex.intValue());
            Object type = propertyInfo.getType();
            Class cls = class$org$ksoap2$serialization$SoapObject;
            if (cls == null) {
                cls = class$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = cls;
            }
            if (type != cls) {
                return propertyInfo.getValue();
            }
            PropertyInfo propertyInfo2 = new PropertyInfo();
            Class cls2 = class$java$lang$String;
            if (cls2 == null) {
                cls2 = class$("java.lang.String");
                class$java$lang$String = cls2;
            }
            propertyInfo2.setType(cls2);
            propertyInfo2.setValue("");
            propertyInfo2.setName(str);
            return propertyInfo2.getValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("illegal property: ");
        stringBuffer.append(str);
        throw new RuntimeException(stringBuffer.toString());
    }

    public String getPrimitivePropertyAsString(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            PropertyInfo propertyInfo = (PropertyInfo) this.properties.elementAt(propertyIndex.intValue());
            Object type = propertyInfo.getType();
            Class cls = class$org$ksoap2$serialization$SoapObject;
            if (cls == null) {
                cls = class$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = cls;
            }
            return type != cls ? propertyInfo.getValue().toString() : "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("illegal property: ");
        stringBuffer.append(str);
        throw new RuntimeException(stringBuffer.toString());
    }

    public Object getPrimitivePropertySafely(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            PropertyInfo propertyInfo = (PropertyInfo) this.properties.elementAt(propertyIndex.intValue());
            Object type = propertyInfo.getType();
            Class cls = class$org$ksoap2$serialization$SoapObject;
            if (cls == null) {
                cls = class$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = cls;
            }
            if (type != cls) {
                return propertyInfo.getValue().toString();
            }
            PropertyInfo propertyInfo2 = new PropertyInfo();
            Class cls2 = class$java$lang$String;
            if (cls2 == null) {
                cls2 = class$("java.lang.String");
                class$java$lang$String = cls2;
            }
            propertyInfo2.setType(cls2);
            propertyInfo2.setValue("");
            propertyInfo2.setName(str);
            return propertyInfo2.getValue();
        }
        return new NullSoapObject();
    }

    public String getPrimitivePropertySafelyAsString(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            PropertyInfo propertyInfo = (PropertyInfo) this.properties.elementAt(propertyIndex.intValue());
            Object type = propertyInfo.getType();
            Class cls = class$org$ksoap2$serialization$SoapObject;
            if (cls == null) {
                cls = class$("org.ksoap2.serialization.SoapObject");
                class$org$ksoap2$serialization$SoapObject = cls;
            }
            if (type != cls) {
                return propertyInfo.getValue().toString();
            }
        }
        return "";
    }

    @Override // org.ksoap2.serialization.KvmSerializable
    public Object getProperty(int i) {
        Object elementAt = this.properties.elementAt(i);
        if (elementAt instanceof PropertyInfo) {
            return ((PropertyInfo) elementAt).getValue();
        }
        return (SoapObject) elementAt;
    }

    public String getPropertyAsString(int i) {
        return ((PropertyInfo) this.properties.elementAt(i)).getValue().toString();
    }

    @Override // org.ksoap2.serialization.KvmSerializable
    public int getPropertyCount() {
        return this.properties.size();
    }

    @Override // org.ksoap2.serialization.KvmSerializable
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        getPropertyInfo(i, propertyInfo);
    }

    public Object getPropertySafely(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            return getProperty(propertyIndex.intValue());
        }
        return new NullSoapObject();
    }

    public String getPropertySafelyAsString(String str) {
        Object property;
        Integer propertyIndex = propertyIndex(str);
        return (propertyIndex == null || (property = getProperty(propertyIndex.intValue())) == null) ? "" : property.toString();
    }

    public boolean hasProperty(String str) {
        return propertyIndex(str) != null;
    }

    public boolean isPropertyEqual(Object obj, int i) {
        if (i >= getPropertyCount()) {
            return false;
        }
        Object elementAt = this.properties.elementAt(i);
        if ((obj instanceof PropertyInfo) && (elementAt instanceof PropertyInfo)) {
            PropertyInfo propertyInfo = (PropertyInfo) obj;
            PropertyInfo propertyInfo2 = (PropertyInfo) elementAt;
            return propertyInfo.getName().equals(propertyInfo2.getName()) && propertyInfo.getValue().equals(propertyInfo2.getValue());
        } else if ((obj instanceof SoapObject) && (elementAt instanceof SoapObject)) {
            return ((SoapObject) obj).equals((SoapObject) elementAt);
        } else {
            return false;
        }
    }

    public SoapObject newInstance() {
        SoapObject soapObject = new SoapObject(this.namespace, this.name);
        for (int i = 0; i < this.properties.size(); i++) {
            Object elementAt = this.properties.elementAt(i);
            if (elementAt instanceof PropertyInfo) {
                soapObject.addProperty((PropertyInfo) ((PropertyInfo) this.properties.elementAt(i)).clone());
            } else if (elementAt instanceof SoapObject) {
                soapObject.addSoapObject(((SoapObject) elementAt).newInstance());
            }
        }
        for (int i2 = 0; i2 < getAttributeCount(); i2++) {
            AttributeInfo attributeInfo = new AttributeInfo();
            getAttributeInfo(i2, attributeInfo);
            soapObject.addAttribute(attributeInfo);
        }
        return soapObject;
    }

    public void setProperty(int i, Object obj) {
        Object elementAt = this.properties.elementAt(i);
        if (elementAt instanceof PropertyInfo) {
            ((PropertyInfo) elementAt).setValue(obj);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        stringBuffer.append(this.name);
        stringBuffer.append("{");
        StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.toString());
        for (int i = 0; i < getPropertyCount(); i++) {
            Object elementAt = this.properties.elementAt(i);
            if (elementAt instanceof PropertyInfo) {
                stringBuffer2.append("");
                stringBuffer2.append(((PropertyInfo) elementAt).getName());
                stringBuffer2.append("=");
                stringBuffer2.append(getProperty(i));
                stringBuffer2.append("; ");
            } else {
                stringBuffer2.append(((SoapObject) elementAt).toString());
            }
        }
        stringBuffer2.append("}");
        return stringBuffer2.toString();
    }

    public SoapObject(String str, String str2) {
        this.properties = new Vector();
        this.namespace = str;
        this.name = str2;
    }

    public SoapObject addPropertyIfValue(PropertyInfo propertyInfo, Object obj) {
        if (obj != null) {
            propertyInfo.setValue(obj);
            return addProperty(propertyInfo);
        }
        return this;
    }

    public void getPropertyInfo(int i, PropertyInfo propertyInfo) {
        Object elementAt = this.properties.elementAt(i);
        if (elementAt instanceof PropertyInfo) {
            PropertyInfo propertyInfo2 = (PropertyInfo) elementAt;
            propertyInfo.name = propertyInfo2.name;
            propertyInfo.namespace = propertyInfo2.namespace;
            propertyInfo.flags = propertyInfo2.flags;
            propertyInfo.type = propertyInfo2.type;
            propertyInfo.elementType = propertyInfo2.elementType;
            propertyInfo.value = propertyInfo2.value;
            propertyInfo.multiRef = propertyInfo2.multiRef;
            return;
        }
        propertyInfo.name = null;
        propertyInfo.namespace = null;
        propertyInfo.flags = 0;
        propertyInfo.type = null;
        propertyInfo.elementType = null;
        propertyInfo.value = elementAt;
        propertyInfo.multiRef = false;
    }

    public String getPropertyAsString(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            return getProperty(propertyIndex.intValue()).toString();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("illegal property: ");
        stringBuffer.append(str);
        throw new RuntimeException(stringBuffer.toString());
    }

    public SoapObject addPropertyIfValue(PropertyInfo propertyInfo) {
        if (propertyInfo.value != null) {
            this.properties.addElement(propertyInfo);
        }
        return this;
    }

    public Object getPropertySafely(String str, Object obj) {
        Integer propertyIndex = propertyIndex(str);
        return propertyIndex != null ? getProperty(propertyIndex.intValue()) : obj;
    }

    public String getPropertySafelyAsString(String str, Object obj) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex == null) {
            return obj != null ? obj.toString() : "";
        }
        Object property = getProperty(propertyIndex.intValue());
        return property != null ? property.toString() : "";
    }

    public Object getProperty(String str) {
        Integer propertyIndex = propertyIndex(str);
        if (propertyIndex != null) {
            return getProperty(propertyIndex.intValue());
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("illegal property: ");
        stringBuffer.append(str);
        throw new RuntimeException(stringBuffer.toString());
    }

    public SoapObject addProperty(PropertyInfo propertyInfo) {
        this.properties.addElement(propertyInfo);
        return this;
    }
}
