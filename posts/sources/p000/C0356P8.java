package p000;

import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.OAuthData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.ServiceData;
import fr.smoney.android.izly.data.model.UserData;
import java.text.ParseException;
import java.util.Currency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: P8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0356P8 extends DefaultHandler {

    /* renamed from: a */
    public StringBuilder f1219a = new StringBuilder();

    /* renamed from: b */
    public ServerError f1220b = null;

    /* renamed from: c */
    public LoginData f1221c = null;

    /* renamed from: d */
    public UserData f1222d = null;

    /* renamed from: e */
    public boolean f1223e = false;

    /* renamed from: f */
    public boolean f1224f = false;

    /* renamed from: g */
    public OAuthData f1225g = null;

    /* renamed from: h */
    public ServiceData f1226h = null;

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) {
        super.characters(cArr, i, i2);
        this.f1219a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str2.equals("Error")) {
            this.f1220b.f4600a = this.f1219a.toString();
        } else if (str2.equals("Code")) {
            this.f1220b.f4601b = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("Msg")) {
            this.f1220b.f4603d = this.f1219a.toString();
        } else if (str2.equals("Title")) {
            this.f1220b.f4604f = this.f1219a.toString();
        } else if (str2.equals("Prio")) {
            this.f1220b.f4605g = Integer.parseInt(this.f1219a.toString());
        } else if (this.f1223e && str2.equals("UID")) {
            this.f1221c.f4362a = this.f1219a.toString();
        } else if (str2.equals("USER_ID")) {
            this.f1221c.f4363b = this.f1219a.toString();
        } else if (str2.equals("SID")) {
            this.f1221c.f4364c = this.f1219a.toString();
        } else if (str2.equals("P2PPAYMIN")) {
            this.f1221c.f4365d = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
        } else if (str2.equals("P2PPAYMAX")) {
            this.f1221c.f4366f = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
        } else if (str2.equals("MONEYINMIN")) {
            this.f1221c.f4367g = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
        } else if (str2.equals("MONEYINMAX")) {
            this.f1221c.f4368h = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
        } else if (str2.equals("MONEYOUTMIN")) {
            this.f1221c.f4369i = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
        } else if (str2.equals("MONEYOUTMAX")) {
            this.f1221c.f4370j = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
        } else if (str2.equals("CUR")) {
            this.f1221c.f4371k = this.f1219a.toString();
            try {
                Currency.getInstance(this.f1221c.f4371k);
            } catch (IllegalArgumentException e) {
                throw new SAXException(e);
            }
        } else if (str2.equals("STATUS")) {
            this.f1221c.f4372l = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("BLOCKED")) {
            this.f1221c.f4373m = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("NBP2PGET")) {
            this.f1221c.f4374n = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("NBP2PREQUEST")) {
            this.f1221c.f4375o = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("NBTRANSAC")) {
            this.f1221c.f4376p = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("TOKEN")) {
            this.f1221c.f4358K = this.f1219a.toString();
        } else if (str2.equals("FNAME")) {
            this.f1221c.f4377q = this.f1219a.toString();
        } else if (str2.equals("LNAME")) {
            this.f1221c.f4378r = this.f1219a.toString();
        } else if (str2.equals("EMAIL")) {
            this.f1221c.f4379s = this.f1219a.toString();
        } else if (str2.equals("AGE")) {
            this.f1221c.f4380t = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("ZIP_CODE")) {
            this.f1221c.f4381u = this.f1219a.toString();
        } else if (str2.equals("CROUS")) {
            this.f1221c.f4382v = this.f1219a.toString();
        } else if (str2.equals("CATEGORY_USERID")) {
            this.f1221c.f4383w = Integer.parseInt(this.f1219a.toString());
        } else if (str2.equals("ALIAS")) {
            this.f1221c.f4385y = this.f1219a.toString();
        } else {
            try {
                if (str2.equals("OPTIN")) {
                    this.f1221c.f4352E = Integer.parseInt(this.f1219a.toString().trim()) == 1;
                } else if (str2.equals("OPTINPARTNERS")) {
                    this.f1221c.f4353F = Integer.parseInt(this.f1219a.toString().trim()) == 1;
                } else if (str2.equals("CROUS_NAME")) {
                    this.f1221c.f4386z = this.f1219a.toString();
                } else if (str2.equals("SUBSCRIPTION_DATE")) {
                    this.f1221c.f4349B = this.f1219a.toString();
                } else if (str2.equals("TERMS_CONDITIONS_AGREEMENT_DATE")) {
                    this.f1221c.f4348A = this.f1219a.toString();
                } else if (str2.equals("SERVICE")) {
                    this.f1221c.f4359L.add(this.f1226h);
                    this.f1226h = null;
                } else if (str2.equals("ID")) {
                    this.f1226h.f4606a = Integer.parseInt(this.f1219a.toString());
                } else if (!str2.equals("CGU_EXPIRED") && !str2.equals("CGU_EXPIRED")) {
                    if (str2.equals("BAL")) {
                        this.f1221c.f4351D.f4230a = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
                    } else if (str2.equals("CASHBAL")) {
                        this.f1221c.f4351D.f4231b = Double.parseDouble(C0374Q7.m2088g(this.f1219a.toString()));
                    } else if (str2.equals("LUD")) {
                        try {
                            this.f1221c.f4351D.f4232c = C0154G8.f499a.parse(this.f1219a.toString()).getTime();
                        } catch (ParseException e2) {
                            throw new SAXException(e2);
                        }
                    } else if (this.f1224f && str2.equals("UID")) {
                        this.f1222d.f4665a = this.f1219a.toString();
                    } else if (str2.equals("SALT")) {
                        this.f1222d.f4666b = this.f1219a.toString();
                    } else if (str2.equals("USERSTATUS")) {
                        try {
                            this.f1221c.f4354G = Integer.parseInt(this.f1219a.toString().trim());
                        } catch (NumberFormatException e3) {
                            throw new SAXException(e3);
                        }
                    } else if (str2.equals("PROCASHIER")) {
                        this.f1221c.f4355H = Integer.parseInt(this.f1219a.toString().trim()) == 1;
                    } else if (str2.equals("ACCESS_TOKEN")) {
                        this.f1225g.f4533a = this.f1219a.toString();
                    } else if (str2.equals("EXPIRES_IN")) {
                        this.f1225g.f4535c = Long.parseLong(this.f1219a.toString());
                    } else if (str2.equals("REFRESH_TOKEN")) {
                        this.f1225g.f4534b = this.f1219a.toString();
                    } else if (str2.equals("NEWVERSION")) {
                        this.f1221c.f4356I = Integer.parseInt(this.f1219a.toString()) == 1;
                    } else if (str2.equals("BankCode")) {
                        LoginData loginData = this.f1221c;
                        loginData.f4350C = this.f1221c.f4350C + "," + this.f1219a.toString();
                    } else if (str2.equals("SEED")) {
                        this.f1221c.f4360M = this.f1219a.toString();
                    } else if (str2.equals("NSSE")) {
                        this.f1221c.f4361N = this.f1219a.toString();
                    }
                } else {
                    try {
                        if (Integer.parseInt(this.f1219a.toString()) == 1) {
                            r0 = true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                    ServiceData serviceData = this.f1226h;
                    if (serviceData != null) {
                        serviceData.f4607b = r0;
                    } else {
                        this.f1221c.f4357J = r0;
                    }
                }
            } catch (NumberFormatException unused2) {
            }
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f1219a.setLength(0);
        if (str2.equals("E")) {
            this.f1220b = new ServerError();
        } else if (str2.equals("Logon")) {
            this.f1221c = new LoginData();
            this.f1223e = true;
        } else if (str2.equals("UserData")) {
            this.f1222d = new UserData();
            this.f1224f = true;
        } else if (str2.equals("OAUTH")) {
            this.f1225g = new OAuthData();
        } else if (str2.equals("SERVICE")) {
            this.f1226h = new ServiceData();
        }
    }
}
