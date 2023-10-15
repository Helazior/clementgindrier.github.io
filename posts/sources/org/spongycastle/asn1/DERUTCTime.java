package org.spongycastle.asn1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DERUTCTime extends ASN1Primitive {
    private byte[] time;

    public DERUTCTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("invalid date string: ");
            m253r.append(e.getMessage());
            throw new IllegalArgumentException(m253r.toString());
        }
    }

    public static ASN1UTCTime getInstance(Object obj) {
        if (obj != null && !(obj instanceof ASN1UTCTime)) {
            if (obj instanceof DERUTCTime) {
                return new ASN1UTCTime(((DERUTCTime) obj).time);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("illegal object in getInstance: ")));
        }
        return (ASN1UTCTime) obj;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERUTCTime) {
            return Arrays.areEqual(this.time, ((DERUTCTime) aSN1Primitive).time);
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) {
        aSN1OutputStream.write(23);
        int length = this.time.length;
        aSN1OutputStream.writeLength(length);
        for (int i = 0; i != length; i++) {
            aSN1OutputStream.write(this.time[i]);
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getAdjustedDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(getAdjustedTime());
    }

    public String getAdjustedTime() {
        String time = getTime();
        if (time.charAt(0) < '5') {
            return outline.m266e("20", time);
        }
        return outline.m266e("19", time);
    }

    public Date getDate() {
        return new SimpleDateFormat("yyMMddHHmmssz").parse(getTime());
    }

    public String getTime() {
        String fromByteArray = Strings.fromByteArray(this.time);
        if (fromByteArray.indexOf(45) < 0 && fromByteArray.indexOf(43) < 0) {
            if (fromByteArray.length() == 11) {
                return fromByteArray.substring(0, 10) + "00GMT+00:00";
            }
            return fromByteArray.substring(0, 12) + "GMT+00:00";
        }
        int indexOf = fromByteArray.indexOf(45);
        if (indexOf < 0) {
            indexOf = fromByteArray.indexOf(43);
        }
        if (indexOf == fromByteArray.length() - 3) {
            fromByteArray = outline.m266e(fromByteArray, "00");
        }
        if (indexOf == 10) {
            return fromByteArray.substring(0, 10) + "00GMT" + fromByteArray.substring(10, 13) + ":" + fromByteArray.substring(13, 15);
        }
        return fromByteArray.substring(0, 12) + "GMT" + fromByteArray.substring(12, 15) + ":" + fromByteArray.substring(15, 17);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return Strings.fromByteArray(this.time);
    }

    public DERUTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (!z && !(object instanceof ASN1UTCTime)) {
            return new ASN1UTCTime(((ASN1OctetString) object).getOctets());
        }
        return getInstance(object);
    }

    public DERUTCTime(byte[] bArr) {
        this.time = bArr;
    }
}
