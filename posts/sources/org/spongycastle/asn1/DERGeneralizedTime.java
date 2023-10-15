package org.spongycastle.asn1;

import com.google.android.material.badge.BadgeDrawable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DERGeneralizedTime extends ASN1Primitive {
    private byte[] time;

    public DERGeneralizedTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("invalid date string: ");
            m253r.append(e.getMessage());
            throw new IllegalArgumentException(m253r.toString());
        }
    }

    private String calculateGMTOffset() {
        String str;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
        }
        int i = rawOffset / 3600000;
        int i2 = (rawOffset - (((i * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(getDate())) {
                i += str.equals(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX) ? 1 : -1;
            }
        } catch (ParseException unused) {
        }
        StringBuilder m252s = outline.m252s("GMT", str);
        m252s.append(convert(i));
        m252s.append(":");
        m252s.append(convert(i2));
        return m252s.toString();
    }

    private String convert(int i) {
        if (i < 10) {
            return outline.m273H(CrashlyticsReportDataCapture.SIGNAL_DEFAULT, i);
        }
        return Integer.toString(i);
    }

    public static ASN1GeneralizedTime getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1GeneralizedTime)) {
            if (obj instanceof DERGeneralizedTime) {
                return new ASN1GeneralizedTime(((DERGeneralizedTime) obj).time);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (ASN1GeneralizedTime) obj;
    }

    private boolean hasFractionalSeconds() {
        int i = 0;
        while (true) {
            byte[] bArr = this.time;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERGeneralizedTime) {
            return Arrays.areEqual(this.time, ((DERGeneralizedTime) aSN1Primitive).time);
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.writeEncoded(24, this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getDate() {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        char charAt;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.endsWith("Z")) {
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (fromByteArray.indexOf(45) <= 0 && fromByteArray.indexOf(43) <= 0) {
            if (hasFractionalSeconds()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss");
            }
            simpleDateFormat = simpleDateFormat2;
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        } else {
            fromByteArray = getTime();
            if (hasFractionalSeconds()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        }
        if (hasFractionalSeconds()) {
            String substring = fromByteArray.substring(14);
            int i = 1;
            while (i < substring.length() && '0' <= (charAt = substring.charAt(i)) && charAt <= '9') {
                i++;
            }
            int i2 = i - 1;
            if (i2 > 3) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, 4) + substring.substring(i));
            } else if (i2 == 1) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, i) + "00" + substring.substring(i));
            } else if (i2 == 2) {
                fromByteArray = fromByteArray.substring(0, 14) + (substring.substring(0, i) + CrashlyticsReportDataCapture.SIGNAL_DEFAULT + substring.substring(i));
            }
        }
        return simpleDateFormat.parse(fromByteArray);
    }

    public String getTime() {
        int length;
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.charAt(fromByteArray.length() - 1) == 'Z') {
            return fromByteArray.substring(0, fromByteArray.length() - 1) + "GMT+00:00";
        }
        int length2 = fromByteArray.length() - 5;
        char charAt = fromByteArray.charAt(length2);
        if (charAt != '-' && charAt != '+') {
            char charAt2 = fromByteArray.charAt(fromByteArray.length() - 3);
            if (charAt2 != '-' && charAt2 != '+') {
                StringBuilder m253r = outline.m253r(fromByteArray);
                m253r.append(calculateGMTOffset());
                return m253r.toString();
            }
            return fromByteArray.substring(0, length) + "GMT" + fromByteArray.substring(length) + ":00";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(fromByteArray.substring(0, length2));
        sb.append("GMT");
        int i = length2 + 3;
        sb.append(fromByteArray.substring(length2, i));
        sb.append(":");
        sb.append(fromByteArray.substring(i));
        return sb.toString();
    }

    public String getTimeString() {
        return Strings.fromByteArray(this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public DERGeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public static ASN1GeneralizedTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof DERGeneralizedTime)) {
            return new ASN1GeneralizedTime(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }

    public DERGeneralizedTime(byte[] bArr) {
        this.time = bArr;
    }
}
