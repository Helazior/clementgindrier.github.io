package p000;

import fr.smoney.android.izly.data.model.MoneyOutTransferData;
import fr.smoney.android.izly.data.model.ServerError;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: N8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0314N8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f1034a = new StringBuilder();

    /* renamed from: b */
    public ServerError f1035b = null;

    /* renamed from: c */
    public MoneyOutTransferData f1036c = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f1034a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f1035b.f4600a = this.f1034a.toString();
        } else if (str2.equals("Code")) {
            this.f1035b.f4601b = Integer.parseInt(this.f1034a.toString());
        } else if (str2.equals("Msg")) {
            this.f1035b.f4603d = this.f1034a.toString();
        } else if (str2.equals("Title")) {
            this.f1035b.f4604f = this.f1034a.toString();
        } else if (str2.equals("Prio")) {
            this.f1035b.f4605g = Integer.parseInt(this.f1034a.toString());
        } else if (str2.equals("ID")) {
            this.f1036c.f4452a = Long.parseLong(this.f1034a.toString());
        } else if (str2.equals("AALIAS")) {
            this.f1036c.f4453b = this.f1034a.toString();
        } else if (str2.equals("AHNT")) {
            this.f1036c.f4454c = this.f1034a.toString();
        } else if (str2.equals("DEB")) {
            this.f1036c.f4455d = Double.parseDouble(C0374Q7.m2088g(this.f1034a.toString()));
        } else if (str2.equals("CRED")) {
            this.f1036c.f4456f = Double.parseDouble(C0374Q7.m2088g(this.f1034a.toString()));
        } else if (str2.equals("COM")) {
            this.f1036c.f4457g = Double.parseDouble(C0374Q7.m2088g(this.f1034a.toString()));
        } else if (str2.equals("COMHT")) {
            this.f1036c.f4458h = Double.parseDouble(C0374Q7.m2088g(this.f1034a.toString()));
        } else if (str2.equals("BAL")) {
            this.f1036c.f4459i.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f1034a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f1036c.f4459i.f4232c = C0154G8.f499a.parse(this.f1034a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f1034a.setLength(0);
        if (str2.equals("E")) {
            this.f1035b = new ServerError();
        } else if (str2.equals("RMOT")) {
            this.f1036c = new MoneyOutTransferData();
        }
    }
}
