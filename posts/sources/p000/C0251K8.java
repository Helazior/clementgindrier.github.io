package p000;

import fr.smoney.android.izly.data.model.MoneyInCbData;
import fr.smoney.android.izly.data.model.ServerError;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: K8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0251K8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f785a = new StringBuilder();

    /* renamed from: b */
    public ServerError f786b = null;

    /* renamed from: c */
    public MoneyInCbData f787c = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f785a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f786b.f4600a = this.f785a.toString();
        } else if (str2.equals("Code")) {
            this.f786b.f4601b = Integer.parseInt(this.f785a.toString());
        } else if (str2.equals("Msg")) {
            this.f786b.f4603d = this.f785a.toString();
        } else if (str2.equals("Title")) {
            this.f786b.f4604f = this.f785a.toString();
        } else if (str2.equals("Prio")) {
            this.f786b.f4605g = Integer.parseInt(this.f785a.toString());
        } else if (str2.equals("ID")) {
            this.f787c.f4434a.f4412a = Long.parseLong(this.f785a.toString());
        } else if (str2.equals("DATE")) {
            try {
                this.f787c.f4434a.f4413b = C0154G8.f499a.parse(this.f785a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        } else if (str2.equals("CID")) {
            this.f787c.f4434a.f4414c.f4418a = this.f785a.toString();
        } else if (str2.equals("CALIAS")) {
            this.f787c.f4434a.f4414c.f4419b = this.f785a.toString();
        } else if (str2.equals("CNWK")) {
            this.f787c.f4434a.f4414c.f4420c = Integer.parseInt(this.f785a.toString());
        } else if (str2.equals("CHNT")) {
            this.f787c.f4434a.f4414c.f4421d = this.f785a.toString();
        } else if (str2.equals("DEB")) {
            this.f787c.f4434a.f4415d = Double.parseDouble(C0374Q7.m2088g(this.f785a.toString()));
        } else if (str2.equals("CRED")) {
            this.f787c.f4434a.f4416f = Double.parseDouble(C0374Q7.m2088g(this.f785a.toString()));
        } else if (str2.equals("COM")) {
            if (this.f785a.toString().length() > 0) {
                this.f787c.f4434a.f4417g = Double.parseDouble(C0374Q7.m2088g(this.f785a.toString()));
            }
        } else if (str2.equals("BAL")) {
            this.f787c.f4436c.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f785a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f787c.f4436c.f4232c = C0154G8.f499a.parse(this.f785a.toString()).getTime();
            } catch (ParseException e2) {
                throw new SAXException(e2);
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f785a.setLength(0);
        if (str2.equals("E")) {
            this.f786b = new ServerError();
        } else if (str2.equals("RMIN")) {
            this.f787c = new MoneyInCbData();
        }
    }
}
