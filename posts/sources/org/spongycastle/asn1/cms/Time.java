package org.spongycastle.asn1.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERUTCTime;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Time extends ASN1Object implements ASN1Choice {
    public ASN1Primitive time;

    public Time(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTCTime) && !(aSN1Primitive instanceof DERGeneralizedTime)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.time = aSN1Primitive;
    }

    public static Time getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public Date getDate() {
        try {
            ASN1Primitive aSN1Primitive = this.time;
            if (aSN1Primitive instanceof DERUTCTime) {
                return ((DERUTCTime) aSN1Primitive).getAdjustedDate();
            }
            return ((DERGeneralizedTime) aSN1Primitive).getDate();
        } catch (ParseException e) {
            StringBuilder m253r = outline.m253r("invalid date string: ");
            m253r.append(e.getMessage());
            throw new IllegalStateException(m253r.toString());
        }
    }

    public String getTime() {
        ASN1Primitive aSN1Primitive = this.time;
        if (aSN1Primitive instanceof DERUTCTime) {
            return ((DERUTCTime) aSN1Primitive).getAdjustedTime();
        }
        return ((DERGeneralizedTime) aSN1Primitive).getTime();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }

    public static Time getInstance(Object obj) {
        if (obj != null && !(obj instanceof Time)) {
            if (obj instanceof DERUTCTime) {
                return new Time((DERUTCTime) obj);
            }
            if (obj instanceof DERGeneralizedTime) {
                return new Time((DERGeneralizedTime) obj);
            }
            throw new IllegalArgumentException(outline.m274G(obj, outline.m253r("unknown object in factory: ")));
        }
        return (Time) obj;
    }

    public Time(Date date) {
        SimpleDateFormat simpleDateFormat;
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        new SimpleDateFormat("yyyyMMddHHmmss").setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int parseInt = Integer.parseInt(str.substring(0, 4));
        if (parseInt >= 1950 && parseInt <= 2049) {
            this.time = new DERUTCTime(str.substring(2));
        } else {
            this.time = new DERGeneralizedTime(str);
        }
    }
}
