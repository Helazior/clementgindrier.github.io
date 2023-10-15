package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetContactDetailsData implements Parcelable {
    public static final Parcelable.Creator<GetContactDetailsData> CREATOR = new C1715a();

    /* renamed from: A */
    public String f4295A;

    /* renamed from: B */
    public String f4296B;

    /* renamed from: C */
    public String f4297C;

    /* renamed from: D */
    public int f4298D;

    /* renamed from: E */
    public long f4299E;

    /* renamed from: F */
    public String f4300F;

    /* renamed from: G */
    public boolean f4301G;

    /* renamed from: H */
    public boolean f4302H;

    /* renamed from: L */
    public PreAuthorizationContainerData f4306L;

    /* renamed from: a */
    public String f4307a;

    /* renamed from: b */
    public String f4308b;

    /* renamed from: d */
    public String f4310d;

    /* renamed from: f */
    public String f4311f;

    /* renamed from: g */
    public String f4312g;

    /* renamed from: h */
    public boolean f4313h;

    /* renamed from: i */
    public String f4314i;

    /* renamed from: j */
    public boolean f4315j;

    /* renamed from: k */
    public boolean f4316k;

    /* renamed from: l */
    public boolean f4317l;

    /* renamed from: m */
    public boolean f4318m;

    /* renamed from: n */
    public boolean f4319n;

    /* renamed from: o */
    public boolean f4320o;

    /* renamed from: p */
    public boolean f4321p;

    /* renamed from: q */
    public boolean f4322q;

    /* renamed from: r */
    public String f4323r;

    /* renamed from: s */
    public String f4324s;

    /* renamed from: t */
    public String f4325t;

    /* renamed from: u */
    public int f4326u;

    /* renamed from: v */
    public long f4327v;

    /* renamed from: w */
    public int f4328w;

    /* renamed from: x */
    public String f4329x;

    /* renamed from: y */
    public String f4330y;

    /* renamed from: z */
    public String f4331z;

    /* renamed from: I */
    public ArrayList<Transaction> f4303I = new ArrayList<>();

    /* renamed from: J */
    public ArrayList<NearPro$Tills> f4304J = new ArrayList<>();

    /* renamed from: c */
    public BalanceData f4309c = new BalanceData();

    /* renamed from: K */
    public ProInfos f4305K = new ProInfos();

    /* renamed from: fr.smoney.android.izly.data.model.GetContactDetailsData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1715a implements Parcelable.Creator<GetContactDetailsData> {
        @Override // android.os.Parcelable.Creator
        public GetContactDetailsData createFromParcel(Parcel parcel) {
            GetContactDetailsData getContactDetailsData = new GetContactDetailsData();
            getContactDetailsData.f4310d = parcel.readString();
            getContactDetailsData.f4311f = parcel.readString();
            getContactDetailsData.f4312g = parcel.readString();
            getContactDetailsData.f4313h = parcel.readInt() == 1;
            getContactDetailsData.f4307a = parcel.readString();
            getContactDetailsData.f4314i = parcel.readString();
            getContactDetailsData.f4315j = parcel.readInt() == 1;
            getContactDetailsData.f4308b = parcel.readString();
            getContactDetailsData.f4316k = parcel.readInt() == 1;
            getContactDetailsData.f4317l = parcel.readInt() == 1;
            getContactDetailsData.f4318m = parcel.readInt() == 1;
            getContactDetailsData.f4319n = parcel.readInt() == 1;
            getContactDetailsData.f4320o = parcel.readInt() == 1;
            getContactDetailsData.f4321p = parcel.readInt() == 1;
            getContactDetailsData.f4322q = parcel.readInt() == 1;
            getContactDetailsData.f4323r = parcel.readString();
            getContactDetailsData.f4324s = parcel.readString();
            getContactDetailsData.f4325t = parcel.readString();
            getContactDetailsData.f4326u = parcel.readInt();
            getContactDetailsData.f4327v = parcel.readLong();
            getContactDetailsData.f4328w = parcel.readInt();
            getContactDetailsData.f4329x = parcel.readString();
            getContactDetailsData.f4330y = parcel.readString();
            getContactDetailsData.f4331z = parcel.readString();
            getContactDetailsData.f4301G = parcel.readInt() == 1;
            getContactDetailsData.f4302H = parcel.readInt() == 1;
            getContactDetailsData.f4295A = parcel.readString();
            getContactDetailsData.f4297C = parcel.readString();
            getContactDetailsData.f4298D = parcel.readInt();
            getContactDetailsData.f4299E = parcel.readLong();
            getContactDetailsData.f4300F = parcel.readString();
            getContactDetailsData.f4296B = parcel.readString();
            getContactDetailsData.f4306L = (PreAuthorizationContainerData) parcel.readParcelable(GetContactDetailsData.class.getClassLoader());
            int readInt = parcel.readInt();
            for (int i = 0; i < readInt; i++) {
                getContactDetailsData.f4304J.add((NearPro$Tills) parcel.readParcelable(GetContactDetailsData.class.getClassLoader()));
            }
            int readInt2 = parcel.readInt();
            getContactDetailsData.f4303I = new ArrayList<>();
            for (int i2 = 0; i2 < readInt2; i2++) {
                getContactDetailsData.f4303I.add((Transaction) parcel.readParcelable(GetContactDetailsData.class.getClassLoader()));
            }
            getContactDetailsData.f4309c = new BalanceData(parcel);
            getContactDetailsData.f4305K = new ProInfos(parcel);
            return getContactDetailsData;
        }

        @Override // android.os.Parcelable.Creator
        public GetContactDetailsData[] newArray(int i) {
            return new GetContactDetailsData[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4310d);
        parcel.writeString(this.f4311f);
        parcel.writeString(this.f4312g);
        parcel.writeInt(this.f4313h ? 1 : 0);
        parcel.writeString(this.f4307a);
        parcel.writeString(this.f4314i);
        parcel.writeInt(this.f4315j ? 1 : 0);
        parcel.writeString(this.f4308b);
        parcel.writeInt(this.f4316k ? 1 : 0);
        parcel.writeInt(this.f4317l ? 1 : 0);
        parcel.writeInt(this.f4318m ? 1 : 0);
        parcel.writeInt(this.f4319n ? 1 : 0);
        parcel.writeInt(this.f4320o ? 1 : 0);
        parcel.writeInt(this.f4321p ? 1 : 0);
        parcel.writeInt(this.f4322q ? 1 : 0);
        parcel.writeString(this.f4323r);
        parcel.writeString(this.f4324s);
        parcel.writeString(this.f4325t);
        parcel.writeInt(this.f4326u);
        parcel.writeLong(this.f4327v);
        parcel.writeInt(this.f4328w);
        parcel.writeString(this.f4329x);
        parcel.writeString(this.f4330y);
        parcel.writeString(this.f4331z);
        parcel.writeInt(this.f4301G ? 1 : 0);
        parcel.writeInt(this.f4302H ? 1 : 0);
        parcel.writeString(this.f4295A);
        parcel.writeString(this.f4297C);
        parcel.writeInt(this.f4298D);
        parcel.writeLong(this.f4299E);
        parcel.writeString(this.f4300F);
        parcel.writeString(this.f4296B);
        parcel.writeParcelable(this.f4306L, i);
        int size = this.f4304J.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.f4304J.get(i2), 0);
        }
        int size2 = this.f4303I.size();
        parcel.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            parcel.writeParcelable(this.f4303I.get(i3), i);
        }
        BalanceData balanceData = this.f4309c;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
        ProInfos proInfos = this.f4305K;
        if (proInfos != null) {
            proInfos.writeToParcel(parcel, i);
        }
    }
}
