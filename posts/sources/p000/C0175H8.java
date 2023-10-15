package p000;

import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.SetDeviceTokenData;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: H8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0175H8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f577a = new StringBuilder();

    /* renamed from: b */
    public ServerError f578b = null;

    /* renamed from: c */
    public SetDeviceTokenData f579c = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f577a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f578b.f4600a = this.f577a.toString();
        } else if (str2.equals("Code")) {
            this.f578b.f4601b = Integer.parseInt(this.f577a.toString());
        } else if (str2.equals("Msg")) {
            this.f578b.f4603d = this.f577a.toString();
        } else if (str2.equals("Title")) {
            this.f578b.f4604f = this.f577a.toString();
        } else if (str2.equals("Prio")) {
            this.f578b.f4605g = Integer.parseInt(this.f577a.toString());
        } else if (str2.equals("BAL")) {
            this.f579c.f4610b.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f577a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f579c.f4610b.f4232c = C0154G8.f499a.parse(this.f577a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f577a.setLength(0);
        if (str2.equals("E")) {
            this.f578b = new ServerError();
        } else if (str2.equals("UP")) {
            this.f579c = new SetDeviceTokenData();
        }
    }
}
