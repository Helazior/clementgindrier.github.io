package p000;

import fr.smoney.android.izly.data.model.MoneyInCbConfirmData;
import fr.smoney.android.izly.data.model.ServerError;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: J8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0223J8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f700a = new StringBuilder();

    /* renamed from: b */
    public ServerError f701b = null;

    /* renamed from: c */
    public MoneyInCbConfirmData f702c = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f700a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f701b.f4600a = this.f700a.toString();
        } else if (str2.equals("Code")) {
            this.f701b.f4601b = Integer.parseInt(this.f700a.toString());
        } else if (str2.equals("Msg")) {
            this.f701b.f4603d = this.f700a.toString();
        } else if (str2.equals("Title")) {
            this.f701b.f4604f = this.f700a.toString();
        } else if (str2.equals("Prio")) {
            this.f701b.f4605g = Integer.parseInt(this.f700a.toString());
        } else if (str2.equals("ID")) {
            this.f702c.f4426a.f4412a = Long.parseLong(this.f700a.toString());
        } else if (str2.equals("DATE")) {
            try {
                this.f702c.f4426a.f4413b = C0154G8.f499a.parse(this.f700a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        } else if (str2.equals("CID")) {
            this.f702c.f4426a.f4414c.f4418a = this.f700a.toString();
        } else if (str2.equals("CALIAS")) {
            this.f702c.f4426a.f4414c.f4419b = this.f700a.toString();
        } else if (str2.equals("RDURL")) {
            this.f702c.f4430f = this.f700a.toString();
        } else if (str2.equals("RDPARAMS")) {
            this.f702c.f4431g = this.f700a.toString();
        } else if (str2.equals("CNWK")) {
            this.f702c.f4426a.f4414c.f4420c = Integer.parseInt(this.f700a.toString());
        } else if (str2.equals("CHNT")) {
            this.f702c.f4426a.f4414c.f4421d = this.f700a.toString();
        } else if (str2.equals("DEB")) {
            this.f702c.f4426a.f4415d = Double.parseDouble(C0374Q7.m2088g(this.f700a.toString()));
        } else if (str2.equals("CRED")) {
            this.f702c.f4426a.f4416f = Double.parseDouble(C0374Q7.m2088g(this.f700a.toString()));
        } else if (str2.equals("COM")) {
            if (this.f700a.toString().length() > 0) {
                this.f702c.f4426a.f4417g = Double.parseDouble(C0374Q7.m2088g(this.f700a.toString()));
            }
        } else if (str2.equals("BAL")) {
            this.f702c.f4432h.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f700a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f702c.f4432h.f4232c = C0154G8.f499a.parse(this.f700a.toString()).getTime();
            } catch (ParseException e2) {
                throw new SAXException(e2);
            }
        } else if (str2.equals("SID")) {
            this.f702c.f4433i = this.f700a.toString();
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f700a.setLength(0);
        if (str2.equals("E")) {
            this.f701b = new ServerError();
        } else if (str2.equals("RMINC")) {
            this.f702c = new MoneyInCbConfirmData();
        }
    }
}
