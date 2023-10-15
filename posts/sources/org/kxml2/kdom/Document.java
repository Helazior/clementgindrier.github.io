package org.kxml2.kdom;

import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Document extends Node {
    public String encoding;
    public int rootIndex = -1;
    public Boolean standalone;

    @Override // org.kxml2.kdom.Node
    public void addChild(int i, int i2, Object obj) {
        if (i2 == 2) {
            this.rootIndex = i;
        } else {
            int i3 = this.rootIndex;
            if (i3 >= i) {
                this.rootIndex = i3 + 1;
            }
        }
        super.addChild(i, i2, obj);
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getName() {
        return "#document";
    }

    public Element getRootElement() {
        int i = this.rootIndex;
        if (i != -1) {
            return (Element) getChild(i);
        }
        throw new RuntimeException("Document has no root element!");
    }

    public Boolean getStandalone() {
        return this.standalone;
    }

    @Override // org.kxml2.kdom.Node
    public void parse(XmlPullParser xmlPullParser) {
        xmlPullParser.require(0, null, null);
        xmlPullParser.nextToken();
        this.encoding = xmlPullParser.getInputEncoding();
        this.standalone = (Boolean) xmlPullParser.getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone");
        super.parse(xmlPullParser);
        if (xmlPullParser.getEventType() != 1) {
            throw new RuntimeException("Document end expected!");
        }
    }

    @Override // org.kxml2.kdom.Node
    public void removeChild(int i) {
        int i2 = this.rootIndex;
        if (i == i2) {
            this.rootIndex = -1;
        } else if (i < i2) {
            this.rootIndex = i2 - 1;
        }
        super.removeChild(i);
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setStandalone(Boolean bool) {
        this.standalone = bool;
    }

    @Override // org.kxml2.kdom.Node
    public void write(XmlSerializer xmlSerializer) {
        xmlSerializer.startDocument(this.encoding, this.standalone);
        writeChildren(xmlSerializer);
        xmlSerializer.endDocument();
    }
}
