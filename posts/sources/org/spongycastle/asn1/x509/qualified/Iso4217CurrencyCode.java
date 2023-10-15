package org.spongycastle.asn1.x509.qualified;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERPrintableString;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Iso4217CurrencyCode extends ASN1Object implements ASN1Choice {
    public int numeric;
    public ASN1Encodable obj;
    public final int ALPHABETIC_MAXSIZE = 3;
    public final int NUMERIC_MINSIZE = 1;
    public final int NUMERIC_MAXSIZE = 999;

    public Iso4217CurrencyCode(int i) {
        if (i <= 999 && i >= 1) {
            this.obj = new ASN1Integer(i);
            return;
        }
        throw new IllegalArgumentException("wrong size in numeric code : not in (1..999)");
    }

    public static Iso4217CurrencyCode getInstance(Object obj) {
        if (obj != null && !(obj instanceof Iso4217CurrencyCode)) {
            if (obj instanceof ASN1Integer) {
                return new Iso4217CurrencyCode(DERInteger.getInstance(obj).getValue().intValue());
            }
            if (obj instanceof DERPrintableString) {
                return new Iso4217CurrencyCode(DERPrintableString.getInstance(obj).getString());
            }
            throw new IllegalArgumentException("unknown object in getInstance");
        }
        return (Iso4217CurrencyCode) obj;
    }

    public String getAlphabetic() {
        return ((DERPrintableString) this.obj).getString();
    }

    public int getNumeric() {
        return ((ASN1Integer) this.obj).getValue().intValue();
    }

    public boolean isAlphabetic() {
        return this.obj instanceof DERPrintableString;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.obj.toASN1Primitive();
    }

    public Iso4217CurrencyCode(String str) {
        if (str.length() <= 3) {
            this.obj = new DERPrintableString(str);
            return;
        }
        throw new IllegalArgumentException("wrong size in alphabetic code : max size is 3");
    }
}
