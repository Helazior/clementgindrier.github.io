package org.ksoap2.serialization;

import java.util.Hashtable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface KvmSerializable {
    Object getProperty(int i);

    int getPropertyCount();

    void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo);

    void setProperty(int i, Object obj);
}
