package org.kobjects.xmlrpc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.kobjects.base64.Base64;
import org.kobjects.isodate.IsoDate;
import org.kobjects.xml.XmlReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class XmlRpcParser {
    private XmlReader parser;

    public XmlRpcParser(XmlReader xmlReader) {
        this.parser = null;
        this.parser = xmlReader;
    }

    private final int nextTag() {
        this.parser.getType();
        int next = this.parser.next();
        if (next == 4 && this.parser.isWhitespace()) {
            next = this.parser.next();
        }
        if (next == 3 || next == 2) {
            return next;
        }
        throw new IOException(outline.m273H("unexpected type: ", next));
    }

    private final String nextText() {
        String str;
        if (this.parser.getType() == 2) {
            int next = this.parser.next();
            if (next == 4) {
                String text = this.parser.getText();
                str = text;
                next = this.parser.next();
            } else {
                str = "";
            }
            if (next == 3) {
                return str;
            }
            throw new IOException("END_TAG expected");
        }
        throw new IOException("precondition: START_TAG");
    }

    private final Vector parseArray() {
        nextTag();
        int nextTag = nextTag();
        Vector vector = new Vector();
        while (nextTag != 3) {
            vector.addElement(parseValue());
            nextTag = this.parser.getType();
        }
        nextTag();
        nextTag();
        return vector;
    }

    private final Object parseFault() {
        nextTag();
        Object parseValue = parseValue();
        nextTag();
        return parseValue;
    }

    private final Object parseParams() {
        Vector vector = new Vector();
        int nextTag = nextTag();
        while (nextTag != 3) {
            nextTag();
            vector.addElement(parseValue());
            nextTag = nextTag();
        }
        nextTag();
        return vector;
    }

    private final Hashtable parseStruct() {
        Hashtable hashtable = new Hashtable();
        int nextTag = nextTag();
        while (nextTag != 3) {
            nextTag();
            String nextText = nextText();
            nextTag();
            hashtable.put(nextText, parseValue());
            nextTag = nextTag();
        }
        nextTag();
        return hashtable;
    }

    private final Object parseValue() {
        Object obj;
        Object num;
        int next = this.parser.next();
        if (next == 4) {
            String text = this.parser.getText();
            obj = text;
            next = this.parser.next();
        } else {
            obj = null;
        }
        if (next == 2) {
            String name = this.parser.getName();
            if (name.equals("array")) {
                obj = parseArray();
            } else if (name.equals("struct")) {
                obj = parseStruct();
            } else {
                if (name.equals("string")) {
                    num = nextText();
                } else if (!name.equals("i4") && !name.equals("int")) {
                    if (name.equals("boolean")) {
                        num = new Boolean(nextText().trim().equals("1"));
                    } else if (name.equals("dateTime.iso8601")) {
                        num = IsoDate.stringToDate(nextText(), 3);
                    } else if (name.equals("base64")) {
                        num = Base64.decode(nextText());
                    } else {
                        if (name.equals("double")) {
                            num = nextText();
                        }
                        nextTag();
                    }
                } else {
                    num = new Integer(Integer.parseInt(nextText().trim()));
                }
                obj = num;
                nextTag();
            }
        }
        nextTag();
        return obj;
    }

    public final Object parseResponse() {
        nextTag();
        if (nextTag() == 2) {
            if ("fault".equals(this.parser.getName())) {
                return parseFault();
            }
            if (CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY.equals(this.parser.getName())) {
                return parseParams();
            }
        }
        return null;
    }
}
