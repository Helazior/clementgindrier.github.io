package p000;

import android.util.SparseIntArray;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import fr.smoney.android.izly.data.model.MoneyInCbCbListData;
import fr.smoney.android.izly.data.model.ServerError;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: I8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0200I8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f643a = new StringBuilder();

    /* renamed from: b */
    public ServerError f644b = null;

    /* renamed from: c */
    public MoneyInCbCbListData f645c = null;

    /* renamed from: d */
    public MoneyInCbCb f646d = null;

    /* renamed from: e */
    public SparseIntArray f647e = new SparseIntArray();

    /* renamed from: f */
    public int f648f = 0;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f643a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f644b.f4600a = this.f643a.toString();
        } else if (str2.equals("Code")) {
            this.f644b.f4601b = Integer.parseInt(this.f643a.toString());
        } else if (str2.equals("Msg")) {
            this.f644b.f4603d = this.f643a.toString();
        } else if (str2.equals("Title")) {
            this.f644b.f4604f = this.f643a.toString();
        } else if (str2.equals("Prio")) {
            this.f644b.f4605g = Integer.parseInt(this.f643a.toString());
        } else if (str2.equals("CB")) {
            this.f645c.f4423a.add(this.f646d);
        } else if (str2.equals("ID")) {
            this.f646d.f4418a = this.f643a.toString();
        } else if (str2.equals("DEFAULT")) {
            this.f646d.f4422f = this.f643a.toString().equals("True");
        } else if (str2.equals("ALIAS")) {
            this.f646d.f4419b = this.f643a.toString();
        } else if (str2.equals("NWK")) {
            this.f646d.f4420c = Integer.parseInt(this.f643a.toString());
        } else if (str2.equals("HNT")) {
            this.f646d.f4421d = this.f643a.toString();
        } else if (str2.equals("STEPS")) {
            int size = this.f647e.size();
            this.f645c.f4424b = new int[size];
            for (int i = 0; i < size; i++) {
                this.f645c.f4424b[i] = this.f647e.get(i);
            }
        } else if (str2.equals("STEP")) {
            SparseIntArray sparseIntArray = this.f647e;
            int i2 = this.f648f;
            this.f648f = i2 + 1;
            sparseIntArray.put(i2, Integer.parseInt(this.f643a.toString()));
        } else if (str2.equals("BAL")) {
            this.f645c.f4425c.f4230a = Double.parseDouble(this.f643a.toString());
        } else if (str2.equals("CASHBAL")) {
            this.f645c.f4425c.f4231b = Double.parseDouble(this.f643a.toString());
        } else if (str2.equals("LUD")) {
            try {
                this.f645c.f4425c.f4232c = C0154G8.f499a.parse(this.f643a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f643a.setLength(0);
        if (str2.equals("E")) {
            this.f644b = new ServerError();
        } else if (str2.equals("RCBL")) {
            this.f645c = new MoneyInCbCbListData();
        } else if (str2.equals("CB")) {
            this.f646d = new MoneyInCbCb();
        }
    }
}
