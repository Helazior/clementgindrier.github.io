package p000;

import android.util.SparseArray;
import fr.smoney.android.izly.data.model.MoneyOutTransferAccountData;
import fr.smoney.android.izly.data.model.ServerError;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: L8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0273L8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f902a = new StringBuilder();

    /* renamed from: b */
    public ServerError f903b = null;

    /* renamed from: c */
    public MoneyOutTransferAccountData f904c = null;

    /* renamed from: d */
    public SparseArray<Float> f905d = new SparseArray<>();

    /* renamed from: e */
    public int f906e = 0;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f902a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f903b.f4600a = this.f902a.toString();
        } else if (str2.equals("Code")) {
            this.f903b.f4601b = Integer.parseInt(this.f902a.toString());
        } else if (str2.equals("Msg")) {
            this.f903b.f4603d = this.f902a.toString();
        } else if (str2.equals("Title")) {
            this.f903b.f4604f = this.f902a.toString();
        } else if (str2.equals("Prio")) {
            this.f903b.f4605g = Integer.parseInt(this.f902a.toString());
        } else if (str2.equals("ALIAS")) {
            this.f904c.f4437a = this.f902a.toString();
        } else if (str2.equals("HNTIBAN")) {
            this.f904c.f4438b = this.f902a.toString();
        } else if (str2.equals("HNTBIC")) {
            this.f904c.f4439c = this.f902a.toString();
        } else if (str2.equals("STEPS")) {
            int size = this.f905d.size();
            this.f904c.f4440d = new float[size];
            for (int i = 0; i < size; i++) {
                this.f904c.f4440d[i] = this.f905d.get(i).floatValue();
            }
        } else if (str2.equals("STEP")) {
            SparseArray<Float> sparseArray = this.f905d;
            int i2 = this.f906e;
            this.f906e = i2 + 1;
            sparseArray.put(i2, Float.valueOf(Float.parseFloat(this.f902a.toString())));
        } else if (str2.equals("BAL")) {
            this.f904c.f4441f.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f902a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f904c.f4441f.f4232c = C0154G8.f499a.parse(this.f902a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f902a.setLength(0);
        if (str2.equals("E")) {
            this.f903b = new ServerError();
        } else if (str2.equals("RMOTA")) {
            this.f904c = new MoneyOutTransferAccountData();
        }
    }
}
