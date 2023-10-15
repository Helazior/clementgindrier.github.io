package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FieldDescriptor {
    private final String name;
    private final Map<Class<?>, Object> properties;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Builder {
        private final String name;
        private Map<Class<?>, Object> properties = null;

        public Builder(String str) {
            this.name = str;
        }

        public FieldDescriptor build() {
            Map unmodifiableMap;
            String str = this.name;
            if (this.properties == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.properties));
            }
            return new FieldDescriptor(str, unmodifiableMap);
        }

        public <T extends Annotation> Builder withProperty(T t) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t.annotationType(), t);
            return this;
        }
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    /* renamed from: of */
    public static FieldDescriptor m1074of(String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldDescriptor) {
            FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
            return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public <T extends Annotation> T getProperty(Class<T> cls) {
        return (T) this.properties.get(cls);
    }

    public int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("FieldDescriptor{name=");
        m253r.append(this.name);
        m253r.append(", properties=");
        m253r.append(this.properties.values());
        m253r.append("}");
        return m253r.toString();
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }
}
