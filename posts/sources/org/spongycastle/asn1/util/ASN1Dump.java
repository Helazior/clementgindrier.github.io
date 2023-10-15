package org.spongycastle.asn1.util;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.BERApplicationSpecific;
import org.spongycastle.asn1.BERConstructedOctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERBoolean;
import org.spongycastle.asn1.DEREnumerated;
import org.spongycastle.asn1.DERExternal;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERT61String;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.DERUTCTime;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVisibleString;
import org.spongycastle.util.encoders.Hex;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    public static void _dumpAsString(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String property = System.getProperty("line.separator");
        if (aSN1Primitive instanceof ASN1Sequence) {
            Enumeration objects = ((ASN1Sequence) aSN1Primitive).getObjects();
            String str2 = str + TAB;
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSequence) {
                stringBuffer.append("BER Sequence");
            } else if (aSN1Primitive instanceof DERSequence) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(property);
            while (objects.hasMoreElements()) {
                Object nextElement = objects.nextElement();
                if (nextElement != null && !nextElement.equals(new DERNull())) {
                    if (nextElement instanceof ASN1Primitive) {
                        _dumpAsString(str2, z, (ASN1Primitive) nextElement, stringBuffer);
                    } else {
                        _dumpAsString(str2, z, ((ASN1Encodable) nextElement).toASN1Primitive(), stringBuffer);
                    }
                } else {
                    stringBuffer.append(str2);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                }
            }
        } else if (aSN1Primitive instanceof DERTaggedObject) {
            String str3 = str + TAB;
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERTaggedObject) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            DERTaggedObject dERTaggedObject = (DERTaggedObject) aSN1Primitive;
            stringBuffer.append(Integer.toString(dERTaggedObject.getTagNo()));
            stringBuffer.append(']');
            if (!dERTaggedObject.isExplicit()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(property);
            if (dERTaggedObject.isEmpty()) {
                stringBuffer.append(str3);
                stringBuffer.append("EMPTY");
                stringBuffer.append(property);
                return;
            }
            _dumpAsString(str3, z, dERTaggedObject.getObject(), stringBuffer);
        } else if (aSN1Primitive instanceof BERSet) {
            Enumeration objects2 = ((ASN1Set) aSN1Primitive).getObjects();
            String str4 = str + TAB;
            stringBuffer.append(str);
            stringBuffer.append("BER Set");
            stringBuffer.append(property);
            while (objects2.hasMoreElements()) {
                Object nextElement2 = objects2.nextElement();
                if (nextElement2 == null) {
                    stringBuffer.append(str4);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement2 instanceof ASN1Primitive) {
                    _dumpAsString(str4, z, (ASN1Primitive) nextElement2, stringBuffer);
                } else {
                    _dumpAsString(str4, z, ((ASN1Encodable) nextElement2).toASN1Primitive(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof DERSet) {
            Enumeration objects3 = ((ASN1Set) aSN1Primitive).getObjects();
            String str5 = str + TAB;
            stringBuffer.append(str);
            stringBuffer.append("DER Set");
            stringBuffer.append(property);
            while (objects3.hasMoreElements()) {
                Object nextElement3 = objects3.nextElement();
                if (nextElement3 == null) {
                    stringBuffer.append(str5);
                    stringBuffer.append("NULL");
                    stringBuffer.append(property);
                } else if (nextElement3 instanceof ASN1Primitive) {
                    _dumpAsString(str5, z, (ASN1Primitive) nextElement3, stringBuffer);
                } else {
                    _dumpAsString(str5, z, ((ASN1Encodable) nextElement3).toASN1Primitive(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            StringBuilder m252s = outline.m252s(str, "ObjectIdentifier(");
            m252s.append(((ASN1ObjectIdentifier) aSN1Primitive).getId());
            m252s.append(")");
            m252s.append(property);
            stringBuffer.append(m252s.toString());
        } else if (aSN1Primitive instanceof DERBoolean) {
            StringBuilder m252s2 = outline.m252s(str, "Boolean(");
            m252s2.append(((DERBoolean) aSN1Primitive).isTrue());
            m252s2.append(")");
            m252s2.append(property);
            stringBuffer.append(m252s2.toString());
        } else if (aSN1Primitive instanceof ASN1Integer) {
            StringBuilder m252s3 = outline.m252s(str, "Integer(");
            m252s3.append(((ASN1Integer) aSN1Primitive).getValue());
            m252s3.append(")");
            m252s3.append(property);
            stringBuffer.append(m252s3.toString());
        } else if (aSN1Primitive instanceof BERConstructedOctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
            StringBuilder m251t = outline.m251t(str, "BER Constructed Octet String", "[");
            m251t.append(aSN1OctetString.getOctets().length);
            m251t.append("] ");
            stringBuffer.append(m251t.toString());
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, aSN1OctetString.getOctets()));
            } else {
                stringBuffer.append(property);
            }
        } else if (aSN1Primitive instanceof DEROctetString) {
            ASN1OctetString aSN1OctetString2 = (ASN1OctetString) aSN1Primitive;
            StringBuilder m251t2 = outline.m251t(str, "DER Octet String", "[");
            m251t2.append(aSN1OctetString2.getOctets().length);
            m251t2.append("] ");
            stringBuffer.append(m251t2.toString());
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, aSN1OctetString2.getOctets()));
            } else {
                stringBuffer.append(property);
            }
        } else if (aSN1Primitive instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) aSN1Primitive;
            StringBuilder m251t3 = outline.m251t(str, "DER Bit String", "[");
            m251t3.append(dERBitString.getBytes().length);
            m251t3.append(", ");
            m251t3.append(dERBitString.getPadBits());
            m251t3.append("] ");
            stringBuffer.append(m251t3.toString());
            if (z) {
                stringBuffer.append(dumpBinaryDataAsString(str, dERBitString.getBytes()));
            } else {
                stringBuffer.append(property);
            }
        } else if (aSN1Primitive instanceof DERIA5String) {
            StringBuilder m252s4 = outline.m252s(str, "IA5String(");
            m252s4.append(((DERIA5String) aSN1Primitive).getString());
            m252s4.append(") ");
            m252s4.append(property);
            stringBuffer.append(m252s4.toString());
        } else if (aSN1Primitive instanceof DERUTF8String) {
            StringBuilder m252s5 = outline.m252s(str, "UTF8String(");
            m252s5.append(((DERUTF8String) aSN1Primitive).getString());
            m252s5.append(") ");
            m252s5.append(property);
            stringBuffer.append(m252s5.toString());
        } else if (aSN1Primitive instanceof DERPrintableString) {
            StringBuilder m252s6 = outline.m252s(str, "PrintableString(");
            m252s6.append(((DERPrintableString) aSN1Primitive).getString());
            m252s6.append(") ");
            m252s6.append(property);
            stringBuffer.append(m252s6.toString());
        } else if (aSN1Primitive instanceof DERVisibleString) {
            StringBuilder m252s7 = outline.m252s(str, "VisibleString(");
            m252s7.append(((DERVisibleString) aSN1Primitive).getString());
            m252s7.append(") ");
            m252s7.append(property);
            stringBuffer.append(m252s7.toString());
        } else if (aSN1Primitive instanceof DERBMPString) {
            StringBuilder m252s8 = outline.m252s(str, "BMPString(");
            m252s8.append(((DERBMPString) aSN1Primitive).getString());
            m252s8.append(") ");
            m252s8.append(property);
            stringBuffer.append(m252s8.toString());
        } else if (aSN1Primitive instanceof DERT61String) {
            StringBuilder m252s9 = outline.m252s(str, "T61String(");
            m252s9.append(((DERT61String) aSN1Primitive).getString());
            m252s9.append(") ");
            m252s9.append(property);
            stringBuffer.append(m252s9.toString());
        } else if (aSN1Primitive instanceof DERUTCTime) {
            StringBuilder m252s10 = outline.m252s(str, "UTCTime(");
            m252s10.append(((DERUTCTime) aSN1Primitive).getTime());
            m252s10.append(") ");
            m252s10.append(property);
            stringBuffer.append(m252s10.toString());
        } else if (aSN1Primitive instanceof DERGeneralizedTime) {
            StringBuilder m252s11 = outline.m252s(str, "GeneralizedTime(");
            m252s11.append(((DERGeneralizedTime) aSN1Primitive).getTime());
            m252s11.append(") ");
            m252s11.append(property);
            stringBuffer.append(m252s11.toString());
        } else if (aSN1Primitive instanceof BERApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific(ASN1Encoding.BER, str, z, aSN1Primitive, property));
        } else if (aSN1Primitive instanceof DERApplicationSpecific) {
            stringBuffer.append(outputApplicationSpecific(ASN1Encoding.DER, str, z, aSN1Primitive, property));
        } else if (aSN1Primitive instanceof DEREnumerated) {
            StringBuilder m252s12 = outline.m252s(str, "DER Enumerated(");
            m252s12.append(((DEREnumerated) aSN1Primitive).getValue());
            m252s12.append(")");
            m252s12.append(property);
            stringBuffer.append(m252s12.toString());
        } else if (aSN1Primitive instanceof DERExternal) {
            DERExternal dERExternal = (DERExternal) aSN1Primitive;
            stringBuffer.append(str + "External " + property);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(TAB);
            String sb2 = sb.toString();
            if (dERExternal.getDirectReference() != null) {
                StringBuilder m252s13 = outline.m252s(sb2, "Direct Reference: ");
                m252s13.append(dERExternal.getDirectReference().getId());
                m252s13.append(property);
                stringBuffer.append(m252s13.toString());
            }
            if (dERExternal.getIndirectReference() != null) {
                StringBuilder m252s14 = outline.m252s(sb2, "Indirect Reference: ");
                m252s14.append(dERExternal.getIndirectReference().toString());
                m252s14.append(property);
                stringBuffer.append(m252s14.toString());
            }
            if (dERExternal.getDataValueDescriptor() != null) {
                _dumpAsString(sb2, z, dERExternal.getDataValueDescriptor(), stringBuffer);
            }
            StringBuilder m252s15 = outline.m252s(sb2, "Encoding: ");
            m252s15.append(dERExternal.getEncoding());
            m252s15.append(property);
            stringBuffer.append(m252s15.toString());
            _dumpAsString(sb2, z, dERExternal.getExternalContent(), stringBuffer);
        } else {
            StringBuilder m253r = outline.m253r(str);
            m253r.append(aSN1Primitive.toString());
            m253r.append(property);
            stringBuffer.append(m253r.toString());
        }
    }

    private static String calculateAscString(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 != i + i2; i3++) {
            if (bArr[i3] >= 32 && bArr[i3] <= 126) {
                stringBuffer.append((char) bArr[i3]);
            }
        }
        return stringBuffer.toString();
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    private static String dumpBinaryDataAsString(String str, byte[] bArr) {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + TAB;
        stringBuffer.append(property);
        for (int i = 0; i < bArr.length; i += 32) {
            if (bArr.length - i > 32) {
                stringBuffer.append(str2);
                stringBuffer.append(new String(Hex.encode(bArr, i, 32)));
                stringBuffer.append(TAB);
                stringBuffer.append(calculateAscString(bArr, i, 32));
                stringBuffer.append(property);
            } else {
                stringBuffer.append(str2);
                stringBuffer.append(new String(Hex.encode(bArr, i, bArr.length - i)));
                for (int length = bArr.length - i; length != 32; length++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(TAB);
                stringBuffer.append(calculateAscString(bArr, i, bArr.length - i));
                stringBuffer.append(property);
            }
        }
        return stringBuffer.toString();
    }

    private static String outputApplicationSpecific(String str, String str2, boolean z, ASN1Primitive aSN1Primitive, String str3) {
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) aSN1Primitive;
        StringBuffer stringBuffer = new StringBuffer();
        if (dERApplicationSpecific.isConstructed()) {
            try {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
                stringBuffer.append(str2 + str + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "]" + str3);
                Enumeration objects = aSN1Sequence.getObjects();
                while (objects.hasMoreElements()) {
                    _dumpAsString(str2 + TAB, z, (ASN1Primitive) objects.nextElement(), stringBuffer);
                }
            } catch (IOException e) {
                stringBuffer.append(e);
            }
            return stringBuffer.toString();
        }
        StringBuilder m251t = outline.m251t(str2, str, " ApplicationSpecific[");
        m251t.append(dERApplicationSpecific.getApplicationTag());
        m251t.append("] (");
        return outline.m261j(m251t, new String(Hex.encode(dERApplicationSpecific.getContents())), ")", str3);
    }

    public static String dumpAsString(Object obj, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            _dumpAsString("", z, (ASN1Primitive) obj, stringBuffer);
        } else if (obj instanceof ASN1Encodable) {
            _dumpAsString("", z, ((ASN1Encodable) obj).toASN1Primitive(), stringBuffer);
        } else {
            StringBuilder m253r = outline.m253r("unknown object type ");
            m253r.append(obj.toString());
            return m253r.toString();
        }
        return stringBuffer.toString();
    }
}
