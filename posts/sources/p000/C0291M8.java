package p000;

import fr.smoney.android.izly.data.model.MoneyOutTransferConfirmData;
import fr.smoney.android.izly.data.model.ServerError;
import java.text.ParseException;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: M8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0291M8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f973a = new StringBuilder();

    /* renamed from: b */
    public ServerError f974b = null;

    /* renamed from: c */
    public MoneyOutTransferConfirmData f975c = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f973a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f974b.f4600a = this.f973a.toString();
        } else if (str2.equals("Code")) {
            this.f974b.f4601b = Integer.parseInt(this.f973a.toString());
        } else if (str2.equals("Msg")) {
            this.f974b.f4603d = this.f973a.toString();
        } else if (str2.equals("Title")) {
            this.f974b.f4604f = this.f973a.toString();
        } else if (str2.equals("Prio")) {
            this.f974b.f4605g = Integer.parseInt(this.f973a.toString());
        } else if (str2.equals("ID")) {
            this.f975c.f4442a = Long.parseLong(this.f973a.toString());
        } else if (str2.equals("DATE")) {
            this.f975c.f4443b = new Date().getTime();
        } else if (str2.equals("AALIAS")) {
            this.f975c.f4444c = this.f973a.toString();
        } else if (str2.equals("AHNT")) {
            this.f975c.f4445d = this.f973a.toString();
        } else if (str2.equals("DEB")) {
            this.f975c.f4446f = Double.parseDouble(C0374Q7.m2088g(this.f973a.toString()));
        } else if (str2.equals("CRED")) {
            this.f975c.f4447g = Double.parseDouble(C0374Q7.m2088g(this.f973a.toString()));
        } else if (str2.equals("COM")) {
            this.f975c.f4448h = Double.parseDouble(C0374Q7.m2088g(this.f973a.toString()));
        } else if (str2.equals("COMHT")) {
            this.f975c.f4449i = Double.parseDouble(C0374Q7.m2088g(this.f973a.toString()));
        } else if (str2.equals("BAL")) {
            this.f975c.f4450j.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f973a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f975c.f4450j.f4232c = C0154G8.f499a.parse(this.f973a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        } else if (str2.equals("SID")) {
            this.f975c.f4451k = this.f973a.toString();
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f973a.setLength(0);
        if (str2.equals("E")) {
            this.f974b = new ServerError();
        } else if (str2.equals("RMOTC")) {
            this.f975c = new MoneyOutTransferConfirmData();
        }
    }
}
