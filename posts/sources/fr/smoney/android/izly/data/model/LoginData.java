package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LoginData implements Parcelable {
    public static final Parcelable.Creator<LoginData> CREATOR = new C1724a();

    /* renamed from: A */
    public String f4348A;

    /* renamed from: B */
    public String f4349B;

    /* renamed from: C */
    public String f4350C;

    /* renamed from: E */
    public boolean f4352E;

    /* renamed from: F */
    public boolean f4353F;

    /* renamed from: K */
    public String f4358K;

    /* renamed from: M */
    public String f4360M;

    /* renamed from: N */
    public String f4361N;

    /* renamed from: l */
    public int f4372l;

    /* renamed from: m */
    public int f4373m;

    /* renamed from: n */
    public int f4374n;

    /* renamed from: o */
    public int f4375o;

    /* renamed from: p */
    public int f4376p;

    /* renamed from: q */
    public String f4377q;

    /* renamed from: r */
    public String f4378r;

    /* renamed from: s */
    public String f4379s;

    /* renamed from: t */
    public int f4380t;

    /* renamed from: u */
    public String f4381u;

    /* renamed from: v */
    public String f4382v;

    /* renamed from: w */
    public int f4383w;

    /* renamed from: x */
    public int f4384x;

    /* renamed from: y */
    public String f4385y;

    /* renamed from: z */
    public String f4386z;

    /* renamed from: d */
    public double f4365d = -1.0d;

    /* renamed from: f */
    public double f4366f = -1.0d;

    /* renamed from: g */
    public double f4367g = -1.0d;

    /* renamed from: h */
    public double f4368h = -1.0d;

    /* renamed from: i */
    public double f4369i = -1.0d;

    /* renamed from: j */
    public double f4370j = -1.0d;

    /* renamed from: H */
    public boolean f4355H = false;

    /* renamed from: I */
    public boolean f4356I = false;

    /* renamed from: J */
    public boolean f4357J = false;

    /* renamed from: a */
    public String f4362a = "";

    /* renamed from: b */
    public String f4363b = "";

    /* renamed from: c */
    public String f4364c = "";

    /* renamed from: k */
    public String f4371k = "";

    /* renamed from: D */
    public BalanceData f4351D = new BalanceData();

    /* renamed from: L */
    public List<ServiceData> f4359L = new ArrayList();

    /* renamed from: G */
    public int f4354G = 0;

    /* renamed from: fr.smoney.android.izly.data.model.LoginData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1724a implements Parcelable.Creator<LoginData> {
        @Override // android.os.Parcelable.Creator
        public LoginData createFromParcel(Parcel parcel) {
            LoginData loginData = new LoginData();
            loginData.f4362a = parcel.readString();
            loginData.f4363b = parcel.readString();
            loginData.f4364c = parcel.readString();
            loginData.f4365d = parcel.readDouble();
            loginData.f4366f = parcel.readDouble();
            loginData.f4367g = parcel.readDouble();
            loginData.f4368h = parcel.readDouble();
            loginData.f4369i = parcel.readDouble();
            loginData.f4370j = parcel.readDouble();
            loginData.f4371k = parcel.readString();
            loginData.f4372l = parcel.readInt();
            loginData.f4373m = parcel.readInt();
            loginData.f4374n = parcel.readInt();
            loginData.f4375o = parcel.readInt();
            loginData.f4376p = parcel.readInt();
            loginData.f4358K = parcel.readString();
            loginData.f4377q = parcel.readString();
            loginData.f4378r = parcel.readString();
            loginData.f4379s = parcel.readString();
            loginData.f4380t = parcel.readInt();
            loginData.f4381u = parcel.readString();
            loginData.f4382v = parcel.readString();
            loginData.f4383w = parcel.readInt();
            loginData.f4384x = parcel.readInt();
            loginData.f4385y = parcel.readString();
            loginData.f4386z = parcel.readString();
            loginData.f4348A = parcel.readString();
            loginData.f4349B = parcel.readString();
            loginData.f4350C = parcel.readString();
            loginData.f4354G = parcel.readInt();
            loginData.f4355H = parcel.readInt() == 1;
            loginData.f4352E = parcel.readInt() == 1;
            loginData.f4353F = parcel.readInt() == 1;
            loginData.f4356I = parcel.readInt() == 1;
            loginData.f4357J = parcel.readInt() == 1;
            parcel.readTypedList(loginData.f4359L, ServiceData.CREATOR);
            loginData.f4360M = parcel.readString();
            loginData.f4361N = parcel.readString();
            loginData.f4351D = new BalanceData(parcel);
            return loginData;
        }

        @Override // android.os.Parcelable.Creator
        public LoginData[] newArray(int i) {
            return new LoginData[i];
        }
    }

    /* renamed from: a */
    public boolean m969a() {
        return this.f4354G == 3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4362a);
        parcel.writeString(this.f4363b);
        parcel.writeString(this.f4364c);
        parcel.writeDouble(this.f4365d);
        parcel.writeDouble(this.f4366f);
        parcel.writeDouble(this.f4367g);
        parcel.writeDouble(this.f4368h);
        parcel.writeDouble(this.f4369i);
        parcel.writeDouble(this.f4370j);
        parcel.writeString(this.f4371k);
        parcel.writeInt(this.f4372l);
        parcel.writeInt(this.f4373m);
        parcel.writeInt(this.f4374n);
        parcel.writeInt(this.f4375o);
        parcel.writeInt(this.f4376p);
        parcel.writeString(this.f4358K);
        parcel.writeString(this.f4377q);
        parcel.writeString(this.f4378r);
        parcel.writeString(this.f4379s);
        parcel.writeInt(this.f4380t);
        parcel.writeString(this.f4381u);
        parcel.writeString(this.f4382v);
        parcel.writeInt(this.f4383w);
        parcel.writeInt(this.f4384x);
        parcel.writeString(this.f4385y);
        parcel.writeString(this.f4386z);
        parcel.writeString(this.f4348A);
        parcel.writeString(this.f4349B);
        parcel.writeString(this.f4350C);
        parcel.writeInt(this.f4354G);
        parcel.writeInt(this.f4355H ? 1 : 0);
        parcel.writeInt(this.f4352E ? 1 : 0);
        parcel.writeInt(this.f4353F ? 1 : 0);
        parcel.writeInt(this.f4356I ? 1 : 0);
        parcel.writeInt(this.f4357J ? 1 : 0);
        parcel.writeTypedList(this.f4359L);
        parcel.writeString(this.f4360M);
        parcel.writeString(this.f4361N);
        BalanceData balanceData = this.f4351D;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }
}
