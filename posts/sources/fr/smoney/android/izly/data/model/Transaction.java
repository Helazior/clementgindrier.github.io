package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Transaction extends Operation {

    /* renamed from: C */
    public static final SparseArray<EnumC1770b> f4619C = new SparseArray<>();
    public static final Parcelable.Creator<Transaction> CREATOR = new C1769a();

    /* renamed from: A */
    public ArrayList<TransactionMessage> f4620A;

    /* renamed from: B */
    public boolean f4621B;

    /* renamed from: a */
    public long f4622a;

    /* renamed from: b */
    public boolean f4623b;

    /* renamed from: c */
    public boolean f4624c;

    /* renamed from: d */
    public double f4625d;

    /* renamed from: f */
    public double f4626f;

    /* renamed from: g */
    public double f4627g;

    /* renamed from: h */
    public double f4628h;

    /* renamed from: i */
    public double f4629i;

    /* renamed from: j */
    public String f4630j;

    /* renamed from: k */
    public long f4631k;

    /* renamed from: l */
    public long f4632l;

    /* renamed from: m */
    public String f4633m;

    /* renamed from: n */
    public int f4634n;

    /* renamed from: o */
    public int f4635o;

    /* renamed from: p */
    public String f4636p;

    /* renamed from: q */
    public String f4637q;

    /* renamed from: r */
    public String f4638r;

    /* renamed from: s */
    public int f4639s;

    /* renamed from: t */
    public EnumC1770b f4640t;

    /* renamed from: u */
    public String f4641u;

    /* renamed from: v */
    public long f4642v;

    /* renamed from: w */
    public String f4643w;

    /* renamed from: x */
    public String f4644x;

    /* renamed from: y */
    public String f4645y;

    /* renamed from: z */
    public int f4646z;

    /* renamed from: fr.smoney.android.izly.data.model.Transaction$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1769a implements Parcelable.Creator<Transaction> {
        @Override // android.os.Parcelable.Creator
        public Transaction createFromParcel(Parcel parcel) {
            return new Transaction(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public Transaction[] newArray(int i) {
            return new Transaction[i];
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.Transaction$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1770b {
        Unknown(-1),
        PerReload(0),
        PerDay(1),
        PerWeek(2),
        PerMonth(3),
        PerYear(4);
        

        /* renamed from: a */
        public int f4654a;

        EnumC1770b(int i) {
            this.f4654a = 0;
            this.f4654a = i;
        }
    }

    static {
        EnumC1770b[] values = EnumC1770b.values();
        for (int i = 0; i < 6; i++) {
            EnumC1770b enumC1770b = values[i];
            f4619C.put(enumC1770b.f4654a, enumC1770b);
        }
    }

    public Transaction() {
        this.f4620A = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4622a);
        parcel.writeInt(this.f4623b ? 1 : 0);
        parcel.writeInt(this.f4624c ? 1 : 0);
        parcel.writeDouble(this.f4625d);
        parcel.writeDouble(this.f4626f);
        parcel.writeDouble(this.f4627g);
        parcel.writeDouble(this.f4628h);
        parcel.writeDouble(this.f4629i);
        parcel.writeString(this.f4630j);
        parcel.writeLong(this.f4631k);
        parcel.writeLong(this.f4632l);
        parcel.writeString(this.f4633m);
        parcel.writeInt(this.f4634n);
        parcel.writeString(this.f4636p);
        parcel.writeString(this.f4637q);
        parcel.writeString(this.f4638r);
        parcel.writeInt(this.f4639s);
        parcel.writeSerializable(this.f4640t);
        parcel.writeString(this.f4641u);
        parcel.writeLong(this.f4642v);
        parcel.writeString(this.f4643w);
        parcel.writeString(this.f4644x);
        parcel.writeString(this.f4645y);
        parcel.writeInt(this.f4646z);
        parcel.writeTypedList(this.f4620A);
        parcel.writeInt(this.f4621B ? 1 : 0);
    }

    public Transaction(Parcel parcel, C1769a c1769a) {
        this.f4622a = parcel.readLong();
        this.f4623b = parcel.readInt() == 1;
        this.f4624c = parcel.readInt() == 1;
        this.f4625d = parcel.readDouble();
        this.f4626f = parcel.readDouble();
        this.f4627g = parcel.readDouble();
        this.f4628h = parcel.readDouble();
        this.f4629i = parcel.readDouble();
        this.f4630j = parcel.readString();
        this.f4631k = parcel.readLong();
        this.f4632l = parcel.readLong();
        this.f4633m = parcel.readString();
        this.f4634n = parcel.readInt();
        this.f4636p = parcel.readString();
        this.f4637q = parcel.readString();
        this.f4638r = parcel.readString();
        this.f4639s = parcel.readInt();
        this.f4640t = (EnumC1770b) parcel.readSerializable();
        this.f4641u = parcel.readString();
        this.f4642v = parcel.readLong();
        this.f4643w = parcel.readString();
        this.f4644x = parcel.readString();
        this.f4645y = parcel.readString();
        this.f4646z = parcel.readInt();
        ArrayList<TransactionMessage> arrayList = new ArrayList<>();
        this.f4620A = arrayList;
        parcel.readTypedList(arrayList, TransactionMessage.CREATOR);
        this.f4621B = parcel.readInt() == 1;
    }
}
