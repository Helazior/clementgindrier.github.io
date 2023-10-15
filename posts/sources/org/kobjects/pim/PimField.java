package org.kobjects.pim;

import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PimField {
    public String name;
    public Hashtable properties;
    public Object value;

    public PimField(PimField pimField) {
        this(pimField.name);
        Object obj = pimField.value;
        if (obj instanceof String[]) {
            int length = ((String[]) obj).length;
            String[] strArr = new String[length];
            System.arraycopy((String[]) obj, 0, strArr, 0, length);
            this.value = strArr;
        } else {
            this.value = obj;
        }
        if (pimField.properties != null) {
            this.properties = new Hashtable();
            Enumeration keys = pimField.properties.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                this.properties.put(str, pimField.properties.get(str));
            }
        }
    }

    public boolean getAttribute(String str) {
        String property = getProperty("type");
        return (property == null || property.indexOf(str) == -1) ? false : true;
    }

    public String getProperty(String str) {
        Hashtable hashtable = this.properties;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public Object getValue() {
        return this.value;
    }

    public Enumeration propertyNames() {
        return this.properties.keys();
    }

    public void setAttribute(String str, boolean z) {
        if (getAttribute(str) == z) {
            return;
        }
        String property = getProperty("type");
        if (z) {
            if (property != null && property.length() != 0) {
                str = outline.m266e(property, str);
            }
        } else {
            int indexOf = property.indexOf(str);
            if (indexOf > 0) {
                indexOf--;
            }
            if (indexOf != -1) {
                str = property.substring(0, indexOf) + property.substring(str.length() + indexOf + 1);
            } else {
                str = property;
            }
        }
        setProperty("type", str);
    }

    public void setProperty(String str, String str2) {
        if (this.properties == null) {
            if (str2 == null) {
                return;
            }
            this.properties = new Hashtable();
        }
        if (str2 == null) {
            this.properties.remove(str);
        } else {
            this.properties.put(str, str2);
        }
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (this.properties != null) {
            StringBuilder m253r = outline.m253r(";");
            m253r.append(this.properties);
            str = m253r.toString();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(":");
        sb.append(this.value);
        return sb.toString();
    }

    public PimField(String str) {
        this.name = str;
    }
}
