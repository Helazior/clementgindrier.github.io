package org.xmlpull.p019v1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: org.xmlpull.v1.XmlPullParserFactory */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    public static final Class referenceContextClass;
    public String classNamesLocation;
    public Hashtable features = new Hashtable();
    public Vector parserClasses;
    public Vector serializerClasses;

    static {
        new XmlPullParserFactory();
        referenceContextClass = XmlPullParserFactory.class;
    }

    public static XmlPullParserFactory newInstance() {
        return newInstance(null, null);
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isNamespaceAware() {
        return getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() {
        Vector vector = this.parserClasses;
        if (vector != null) {
            if (vector.size() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < this.parserClasses.size(); i++) {
                    Class cls = (Class) this.parserClasses.elementAt(i);
                    try {
                        XmlPullParser xmlPullParser = (XmlPullParser) cls.newInstance();
                        Enumeration keys = this.features.keys();
                        while (keys.hasMoreElements()) {
                            String str = (String) keys.nextElement();
                            Boolean bool = (Boolean) this.features.get(str);
                            if (bool != null && bool.booleanValue()) {
                                xmlPullParser.setFeature(str, true);
                            }
                        }
                        return xmlPullParser;
                    } catch (Exception e) {
                        stringBuffer.append(cls.getName() + ": " + e.toString() + "; ");
                    }
                }
                throw new XmlPullParserException("could not create parser: " + ((Object) stringBuffer));
            }
            StringBuilder m253r = outline.m253r("No valid parser classes found in ");
            m253r.append(this.classNamesLocation);
            throw new XmlPullParserException(m253r.toString());
        }
        StringBuilder m253r2 = outline.m253r("Factory initialization was incomplete - has not tried ");
        m253r2.append(this.classNamesLocation);
        throw new XmlPullParserException(m253r2.toString());
    }

    public XmlSerializer newSerializer() {
        Vector vector = this.serializerClasses;
        if (vector != null) {
            if (vector.size() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < this.serializerClasses.size(); i++) {
                    Class cls = (Class) this.serializerClasses.elementAt(i);
                    try {
                        return (XmlSerializer) cls.newInstance();
                    } catch (Exception e) {
                        stringBuffer.append(cls.getName() + ": " + e.toString() + "; ");
                    }
                }
                throw new XmlPullParserException("could not create serializer: " + ((Object) stringBuffer));
            }
            StringBuilder m253r = outline.m253r("No valid serializer classes found in ");
            m253r.append(this.classNamesLocation);
            throw new XmlPullParserException(m253r.toString());
        }
        StringBuilder m253r2 = outline.m253r("Factory initialization incomplete - has not tried ");
        m253r2.append(this.classNamesLocation);
        throw new XmlPullParserException(m253r2.toString());
    }

    public void setFeature(String str, boolean z) {
        this.features.put(str, new Boolean(z));
    }

    public void setNamespaceAware(boolean z) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(z));
    }

    public void setValidating(boolean z) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.xmlpull.p019v1.XmlPullParserFactory newInstance(java.lang.String r11, java.lang.Class r12) {
        /*
            if (r12 != 0) goto L4
            java.lang.Class r12 = org.xmlpull.p019v1.XmlPullParserFactory.referenceContextClass
        L4:
            java.lang.String r0 = "'"
            r1 = 0
            if (r11 == 0) goto L1f
            int r2 = r11.length()
            if (r2 == 0) goto L1f
            java.lang.String r2 = "DEFAULT"
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L18
            goto L1f
        L18:
            java.lang.String r12 = "parameter classNames to newInstance() that contained '"
            java.lang.String r12 = p000.outline.m265f(r12, r11, r0)
            goto L3f
        L1f:
            java.lang.String r11 = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory"
            java.io.InputStream r11 = r12.getResourceAsStream(r11)     // Catch: java.lang.Exception -> Lbf
            if (r11 == 0) goto Lb7
            java.lang.StringBuffer r12 = new java.lang.StringBuffer     // Catch: java.lang.Exception -> Lbf
            r12.<init>()     // Catch: java.lang.Exception -> Lbf
        L2c:
            int r2 = r11.read()     // Catch: java.lang.Exception -> Lbf
            if (r2 >= 0) goto Lad
            r11.close()     // Catch: java.lang.Exception -> Lbf
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Exception -> Lbf
            java.lang.String r12 = "resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '"
            java.lang.String r12 = p000.outline.m265f(r12, r11, r0)
        L3f:
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            java.util.Vector r2 = new java.util.Vector
            r2.<init>()
            r3 = 0
            r4 = r1
        L4b:
            int r5 = r11.length()
            if (r3 >= r5) goto L9f
            r5 = 44
            int r5 = r11.indexOf(r5, r3)
            r6 = -1
            if (r5 != r6) goto L5e
            int r5 = r11.length()
        L5e:
            java.lang.String r3 = r11.substring(r3, r5)
            java.lang.Class r6 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> L6b
            java.lang.Object r7 = r6.newInstance()     // Catch: java.lang.Exception -> L6c
            goto L6d
        L6b:
            r6 = r1
        L6c:
            r7 = r1
        L6d:
            if (r6 == 0) goto L9c
            boolean r8 = r7 instanceof org.xmlpull.p019v1.XmlPullParser
            r9 = 1
            if (r8 == 0) goto L79
            r0.addElement(r6)
            r8 = 1
            goto L7a
        L79:
            r8 = 0
        L7a:
            boolean r10 = r7 instanceof org.xmlpull.p019v1.XmlSerializer
            if (r10 == 0) goto L82
            r2.addElement(r6)
            r8 = 1
        L82:
            boolean r6 = r7 instanceof org.xmlpull.p019v1.XmlPullParserFactory
            if (r6 == 0) goto L8c
            if (r4 != 0) goto L8d
            r4 = r7
            org.xmlpull.v1.XmlPullParserFactory r4 = (org.xmlpull.p019v1.XmlPullParserFactory) r4
            goto L8d
        L8c:
            r9 = r8
        L8d:
            if (r9 == 0) goto L90
            goto L9c
        L90:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r12 = "incompatible class: "
            java.lang.String r12 = p000.outline.m266e(r12, r3)
            r11.<init>(r12)
            throw r11
        L9c:
            int r3 = r5 + 1
            goto L4b
        L9f:
            if (r4 != 0) goto La6
            org.xmlpull.v1.XmlPullParserFactory r4 = new org.xmlpull.v1.XmlPullParserFactory
            r4.<init>()
        La6:
            r4.parserClasses = r0
            r4.serializerClasses = r2
            r4.classNamesLocation = r12
            return r4
        Lad:
            r3 = 32
            if (r2 <= r3) goto L2c
            char r2 = (char) r2
            r12.append(r2)     // Catch: java.lang.Exception -> Lbf
            goto L2c
        Lb7:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch: java.lang.Exception -> Lbf
            java.lang.String r12 = "resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available"
            r11.<init>(r12)     // Catch: java.lang.Exception -> Lbf
            throw r11     // Catch: java.lang.Exception -> Lbf
        Lbf:
            r11 = move-exception
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException
            r12.<init>(r1, r1, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.p019v1.XmlPullParserFactory.newInstance(java.lang.String, java.lang.Class):org.xmlpull.v1.XmlPullParserFactory");
    }
}
