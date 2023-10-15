package org.ksoap2.serialization;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SoapPrimitive extends AttributeContainer {
    public String name;
    public String namespace;
    public String value;

    public SoapPrimitive(String str, String str2, String str3) {
        this.namespace = str;
        this.name = str2;
        this.value = str3;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj instanceof SoapPrimitive) {
            SoapPrimitive soapPrimitive = (SoapPrimitive) obj;
            return (this.name.equals(soapPrimitive.name) && ((str = this.namespace) != null ? str.equals(soapPrimitive.namespace) : soapPrimitive.namespace == null) && ((str2 = this.value) != null ? str2.equals(soapPrimitive.value) : soapPrimitive.value == null)) && attributesAreEqual(soapPrimitive);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode();
        String str = this.namespace;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return this.value;
    }
}
