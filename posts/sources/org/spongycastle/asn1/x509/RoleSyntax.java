package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RoleSyntax extends ASN1Object {
    private GeneralNames roleAuthority;
    private GeneralName roleName;

    public RoleSyntax(GeneralNames generalNames, GeneralName generalName) {
        if (generalName != null && generalName.getTagNo() == 6 && !((ASN1String) generalName.getName()).getString().equals("")) {
            this.roleAuthority = generalNames;
            this.roleName = generalName;
            return;
        }
        throw new IllegalArgumentException("the role name MUST be non empty and MUST use the URI option of GeneralName");
    }

    public static RoleSyntax getInstance(Object obj) {
        if (obj instanceof RoleSyntax) {
            return (RoleSyntax) obj;
        }
        if (obj != null) {
            return new RoleSyntax(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralNames getRoleAuthority() {
        return this.roleAuthority;
    }

    public String[] getRoleAuthorityAsString() {
        GeneralNames generalNames = this.roleAuthority;
        if (generalNames == null) {
            return new String[0];
        }
        GeneralName[] names = generalNames.getNames();
        String[] strArr = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            ASN1Encodable name = names[i].getName();
            if (name instanceof ASN1String) {
                strArr[i] = ((ASN1String) name).getString();
            } else {
                strArr[i] = name.toString();
            }
        }
        return strArr;
    }

    public GeneralName getRoleName() {
        return this.roleName;
    }

    public String getRoleNameAsString() {
        return ((ASN1String) this.roleName.getName()).getString();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.roleAuthority;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, generalNames));
        }
        aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.roleName));
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("Name: ");
        m253r.append(getRoleNameAsString());
        m253r.append(" - Auth: ");
        StringBuffer stringBuffer = new StringBuffer(m253r.toString());
        GeneralNames generalNames = this.roleAuthority;
        if (generalNames != null && generalNames.getNames().length != 0) {
            String[] roleAuthorityAsString = getRoleAuthorityAsString();
            stringBuffer.append('[');
            stringBuffer.append(roleAuthorityAsString[0]);
            for (int i = 1; i < roleAuthorityAsString.length; i++) {
                stringBuffer.append(", ");
                stringBuffer.append(roleAuthorityAsString[i]);
            }
            stringBuffer.append(']');
        } else {
            stringBuffer.append("N/A");
        }
        return stringBuffer.toString();
    }

    public RoleSyntax(GeneralName generalName) {
        this(null, generalName);
    }

    public RoleSyntax(String str) {
        this(new GeneralName(6, str == null ? "" : str));
    }

    private RoleSyntax(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() >= 1 && aSN1Sequence.size() <= 2) {
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.roleAuthority = GeneralNames.getInstance(aSN1TaggedObject, false);
                } else if (tagNo == 1) {
                    this.roleName = GeneralName.getInstance(aSN1TaggedObject, true);
                } else {
                    throw new IllegalArgumentException("Unknown tag in RoleSyntax");
                }
            }
            return;
        }
        throw new IllegalArgumentException(outline.m259l(aSN1Sequence, outline.m253r("Bad sequence size: ")));
    }
}
