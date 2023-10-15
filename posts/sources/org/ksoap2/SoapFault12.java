package org.ksoap2;

import org.kxml2.kdom.Node;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SoapFault12 extends SoapFault {
    private static final long serialVersionUID = 1012001;
    public Node Code;
    public Node Detail;
    public Node Node;
    public Node Reason;
    public Node Role;

    public SoapFault12() {
        this.version = 120;
    }

    private void parseSelf(XmlPullParser xmlPullParser) {
        xmlPullParser.require(2, SoapEnvelope.ENV2003, "Fault");
        while (xmlPullParser.nextTag() == 2) {
            String name = xmlPullParser.getName();
            xmlPullParser.nextTag();
            if (name.equals("Code")) {
                Node node = new Node();
                this.Code = node;
                node.parse(xmlPullParser);
            } else if (name.equals("Reason")) {
                Node node2 = new Node();
                this.Reason = node2;
                node2.parse(xmlPullParser);
            } else if (name.equals("Node")) {
                Node node3 = new Node();
                this.Node = node3;
                node3.parse(xmlPullParser);
            } else if (name.equals("Role")) {
                Node node4 = new Node();
                this.Role = node4;
                node4.parse(xmlPullParser);
            } else if (name.equals("Detail")) {
                Node node5 = new Node();
                this.Detail = node5;
                node5.parse(xmlPullParser);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("unexpected tag:");
                stringBuffer.append(name);
                throw new RuntimeException(stringBuffer.toString());
            }
            xmlPullParser.require(3, SoapEnvelope.ENV2003, name);
        }
        xmlPullParser.require(3, SoapEnvelope.ENV2003, "Fault");
        xmlPullParser.nextTag();
    }

    @Override // org.ksoap2.SoapFault, java.lang.Throwable
    public String getMessage() {
        return this.Reason.getElement(SoapEnvelope.ENV2003, "Text").getText(0);
    }

    @Override // org.ksoap2.SoapFault
    public void parse(XmlPullParser xmlPullParser) {
        parseSelf(xmlPullParser);
        this.faultcode = this.Code.getElement(SoapEnvelope.ENV2003, "Value").getText(0);
        this.faultstring = this.Reason.getElement(SoapEnvelope.ENV2003, "Text").getText(0);
        this.detail = this.Detail;
        this.faultactor = null;
    }

    @Override // org.ksoap2.SoapFault, java.lang.Throwable
    public String toString() {
        String text = this.Reason.getElement(SoapEnvelope.ENV2003, "Text").getText(0);
        String text2 = this.Code.getElement(SoapEnvelope.ENV2003, "Value").getText(0);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Code: ");
        stringBuffer.append(text2);
        stringBuffer.append(", Reason: ");
        stringBuffer.append(text);
        return stringBuffer.toString();
    }

    @Override // org.ksoap2.SoapFault
    public void write(XmlSerializer xmlSerializer) {
        xmlSerializer.startTag(SoapEnvelope.ENV2003, "Fault");
        xmlSerializer.startTag(SoapEnvelope.ENV2003, "Code");
        this.Code.write(xmlSerializer);
        xmlSerializer.endTag(SoapEnvelope.ENV2003, "Code");
        xmlSerializer.startTag(SoapEnvelope.ENV2003, "Reason");
        this.Reason.write(xmlSerializer);
        xmlSerializer.endTag(SoapEnvelope.ENV2003, "Reason");
        if (this.Node != null) {
            xmlSerializer.startTag(SoapEnvelope.ENV2003, "Node");
            this.Node.write(xmlSerializer);
            xmlSerializer.endTag(SoapEnvelope.ENV2003, "Node");
        }
        if (this.Role != null) {
            xmlSerializer.startTag(SoapEnvelope.ENV2003, "Role");
            this.Role.write(xmlSerializer);
            xmlSerializer.endTag(SoapEnvelope.ENV2003, "Role");
        }
        if (this.Detail != null) {
            xmlSerializer.startTag(SoapEnvelope.ENV2003, "Detail");
            this.Detail.write(xmlSerializer);
            xmlSerializer.endTag(SoapEnvelope.ENV2003, "Detail");
        }
        xmlSerializer.endTag(SoapEnvelope.ENV2003, "Fault");
    }

    public SoapFault12(int i) {
        this.version = i;
    }
}
