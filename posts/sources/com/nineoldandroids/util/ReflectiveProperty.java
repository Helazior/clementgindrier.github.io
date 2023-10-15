package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String m266e = outline.m266e(PREFIX_GET, str2);
        try {
            try {
                this.mGetter = cls.getMethod(m266e, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(m266e, null);
                this.mGetter = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String m266e2 = outline.m266e(PREFIX_IS, str2);
            try {
                try {
                    try {
                        this.mGetter = cls.getMethod(m266e2, null);
                    } catch (NoSuchMethodException unused3) {
                        Field field = cls.getField(str);
                        this.mField = field;
                        Class<?> type = field.getType();
                        if (typesMatch(cls2, type)) {
                            return;
                        }
                        throw new NoSuchPropertyException("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                    }
                } catch (NoSuchMethodException unused4) {
                    Method declaredMethod2 = cls.getDeclaredMethod(m266e2, null);
                    this.mGetter = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
            } catch (NoSuchFieldException unused5) {
                throw new NoSuchPropertyException(outline.m266e("No accessor method or field found for property with name ", str));
            }
        }
        Class<?> returnType = this.mGetter.getReturnType();
        if (typesMatch(cls2, returnType)) {
            try {
                Method declaredMethod3 = cls.getDeclaredMethod(outline.m266e(PREFIX_SET, str2), returnType);
                this.mSetter = declaredMethod3;
                declaredMethod3.setAccessible(true);
                return;
            } catch (NoSuchMethodException unused6) {
                return;
            }
        }
        throw new NoSuchPropertyException("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
    }

    private boolean typesMatch(Class<V> cls, Class cls2) {
        if (cls2 != cls) {
            if (cls2.isPrimitive()) {
                if (cls2 == Float.TYPE && cls == Float.class) {
                    return true;
                }
                if (cls2 == Integer.TYPE && cls == Integer.class) {
                    return true;
                }
                if (cls2 == Boolean.TYPE && cls == Boolean.class) {
                    return true;
                }
                if (cls2 == Long.TYPE && cls == Long.class) {
                    return true;
                }
                if (cls2 == Double.TYPE && cls == Double.class) {
                    return true;
                }
                if (cls2 == Short.TYPE && cls == Short.class) {
                    return true;
                }
                if (cls2 == Byte.TYPE && cls == Byte.class) {
                    return true;
                }
                return cls2 == Character.TYPE && cls == Character.class;
            }
            return false;
        }
        return true;
    }

    @Override // com.nineoldandroids.util.Property
    public V get(T t) {
        Method method = this.mGetter;
        if (method != null) {
            try {
                return (V) method.invoke(t, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        Field field = this.mField;
        if (field != null) {
            try {
                return (V) field.get(t);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        throw new AssertionError();
    }

    @Override // com.nineoldandroids.util.Property
    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }

    @Override // com.nineoldandroids.util.Property
    public void set(T t, V v) {
        Method method = this.mSetter;
        if (method != null) {
            try {
                method.invoke(t, v);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        Field field = this.mField;
        if (field != null) {
            try {
                field.set(t, v);
                return;
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }
        StringBuilder m253r = outline.m253r("Property ");
        m253r.append(getName());
        m253r.append(" is read-only");
        throw new UnsupportedOperationException(m253r.toString());
    }
}
