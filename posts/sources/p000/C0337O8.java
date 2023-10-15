package p000;

import android.text.TextUtils;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.Transaction;
import fr.smoney.android.izly.data.model.TransactionListData;
import fr.smoney.android.izly.data.model.TransactionMessage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: O8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0337O8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f1138a = new StringBuilder();

    /* renamed from: b */
    public ServerError f1139b = null;

    /* renamed from: c */
    public TransactionListData f1140c = null;

    /* renamed from: d */
    public int f1141d = -1;

    /* renamed from: e */
    public Transaction f1142e = null;

    /* renamed from: f */
    public TransactionMessage f1143f = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f1138a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f1139b.f4600a = this.f1138a.toString();
        } else if (str2.equals("Code")) {
            this.f1139b.f4601b = Integer.parseInt(this.f1138a.toString());
        } else if (str2.equals("Msg")) {
            this.f1139b.f4603d = this.f1138a.toString();
        } else if (str2.equals("Title")) {
            this.f1139b.f4604f = this.f1138a.toString();
        } else if (str2.equals("Prio")) {
            this.f1139b.f4605g = Integer.parseInt(this.f1138a.toString());
        } else if (str2.equals("RPL")) {
            TransactionListData transactionListData = this.f1140c;
            transactionListData.f4655a = this.f1141d > transactionListData.f4656b.size();
        } else if (str2.equals("P")) {
            Transaction transaction = this.f1142e;
            long j = transaction.f4642v;
            if (j == 0) {
                transaction.f4632l = transaction.f4631k;
            } else {
                transaction.f4632l = j;
            }
            this.f1140c.f4656b.add(transaction);
        } else if (str2.equals("ID")) {
            this.f1142e.f4622a = Long.parseLong(this.f1138a.toString());
        } else if (str2.equals("RECCLI")) {
            this.f1142e.f4623b = this.f1138a.toString().equals("1");
        } else if (str2.equals("ISREAD")) {
            this.f1142e.f4624c = this.f1138a.toString().equals("1");
        } else if (str2.equals("DEB")) {
            this.f1142e.f4625d = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("DEBHT")) {
            this.f1142e.f4626f = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("TAX")) {
            this.f1142e.f4630j = this.f1138a.toString();
        } else if (str2.equals("CRED")) {
            this.f1142e.f4627g = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("CREDHT")) {
            this.f1142e.f4628h = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("COM")) {
            this.f1142e.f4629i = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("DATE")) {
            try {
                this.f1142e.f4631k = C0154G8.f499a.parse(this.f1138a.toString()).getTime();
            } catch (ParseException e) {
                throw new SAXException(e);
            }
        } else if (str2.equals("MSG")) {
            this.f1142e.f4633m = this.f1138a.toString();
        } else if (str2.equals("TYPE")) {
            this.f1142e.f4634n = Integer.parseInt(this.f1138a.toString());
        } else if (str2.equals("TYPEDIRECTION")) {
            this.f1142e.f4635o = Integer.parseInt(this.f1138a.toString());
        } else if (str2.equals("USERFNAME")) {
            this.f1142e.f4637q = this.f1138a.toString();
        } else if (str2.equals("USERLNAME")) {
            this.f1142e.f4638r = this.f1138a.toString();
        } else if (str2.equals("USERID")) {
            this.f1142e.f4636p = this.f1138a.toString();
        } else if (str2.equals("USERTYPE")) {
            this.f1142e.f4646z = Integer.parseInt(this.f1138a.toString());
        } else if (str2.equals("STATUS")) {
            this.f1142e.f4639s = Integer.parseInt(this.f1138a.toString());
        } else if (str2.equals("DURATIONTYPE")) {
            Transaction transaction2 = this.f1142e;
            int parseInt = Integer.parseInt(this.f1138a.toString());
            Objects.requireNonNull(transaction2);
            Transaction.EnumC1770b enumC1770b = Transaction.f4619C.get(parseInt);
            transaction2.f4640t = enumC1770b;
            if (enumC1770b == null) {
                transaction2.f4640t = Transaction.EnumC1770b.Unknown;
            }
        } else if (str2.equals("RESPMSG")) {
            this.f1142e.f4641u = this.f1138a.toString();
        } else if (str2.equals("RESPDATE")) {
            try {
                if (TextUtils.isEmpty(this.f1138a.toString())) {
                    this.f1142e.f4642v = -1L;
                } else {
                    this.f1142e.f4642v = C0154G8.f499a.parse(this.f1138a.toString()).getTime();
                }
            } catch (ParseException e2) {
                throw new SAXException(e2);
            }
        } else if (str2.equals("INFOMSG")) {
            this.f1142e.f4643w = this.f1138a.toString();
        } else if (str2.equals("ATTACHMENTNAME")) {
            this.f1142e.f4644x = this.f1138a.toString();
        } else if (str2.equals("ATTACHMENTID")) {
            this.f1142e.f4645y = this.f1138a.toString();
        } else if (str2.equals("BAL")) {
            this.f1140c.f4657c.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("CASHBAL")) {
            this.f1140c.f4657c.f4231b = Double.parseDouble(C0374Q7.m2088g(this.f1138a.toString()));
        } else if (str2.equals("LUD")) {
            try {
                this.f1140c.f4657c.f4232c = C0154G8.f499a.parse(this.f1138a.toString()).getTime();
            } catch (ParseException e3) {
                throw new SAXException(e3);
            }
        } else if (str2.equals("MSGID")) {
            this.f1143f.f4658a = Long.parseLong(this.f1138a.toString());
        } else if (str2.equals("MSGDATE")) {
            try {
                this.f1143f.f4659b = C0154G8.f499a.parse(this.f1138a.toString()).getTime();
            } catch (ParseException e4) {
                throw new SAXException(e4);
            }
        } else if (str2.equals("MSGUSER")) {
            this.f1143f.f4660c = this.f1138a.toString();
        } else if (str2.equals("MSGTEXT")) {
            this.f1143f.f4661d = this.f1138a.toString();
        } else if (str2.equals("CHATMSG")) {
            this.f1142e.f4620A.add(this.f1143f);
            this.f1143f = null;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f1138a.setLength(0);
        if (str2.equals("E")) {
            this.f1139b = new ServerError();
        } else if (str2.equals("RPL")) {
            this.f1140c = new TransactionListData();
        } else if (str2.equals("PL")) {
            this.f1140c.f4656b = new ArrayList<>();
            this.f1141d = Integer.parseInt(attributes.getValue("NB"));
        } else if (str2.equals("P")) {
            this.f1142e = new Transaction();
        } else if (str2.equals("CHATMSG")) {
            this.f1143f = new TransactionMessage();
        }
    }
}
