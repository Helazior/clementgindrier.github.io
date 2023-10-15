package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.DecimalFormat;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PromotionalOffer implements Parcelable {
    public static final Parcelable.Creator<PromotionalOffer> CREATOR;

    /* renamed from: a */
    public int f4580a;

    /* renamed from: b */
    public boolean f4581b;

    /* renamed from: c */
    public String f4582c;

    /* renamed from: d */
    public String f4583d;

    /* renamed from: f */
    public String f4584f;

    /* renamed from: g */
    public String f4585g;

    /* renamed from: h */
    public long f4586h;

    /* renamed from: i */
    public long f4587i;

    /* renamed from: j */
    public String f4588j;

    /* renamed from: k */
    public String f4589k;

    /* renamed from: l */
    public String f4590l;

    /* renamed from: m */
    public double f4591m;

    /* renamed from: n */
    public EnumC1761b f4592n;

    /* renamed from: fr.smoney.android.izly.data.model.PromotionalOffer$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1760a implements Parcelable.Creator<PromotionalOffer> {
        @Override // android.os.Parcelable.Creator
        public PromotionalOffer createFromParcel(Parcel parcel) {
            return new PromotionalOffer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PromotionalOffer[] newArray(int i) {
            return new PromotionalOffer[i];
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.PromotionalOffer$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1761b {
        GLOBAL,
        GEOLOCALIZED
    }

    static {
        new DecimalFormat("0.00");
        CREATOR = new C1760a();
    }

    public PromotionalOffer() {
        this.f4589k = null;
        this.f4590l = null;
        this.f4591m = -1.0d;
        this.f4592n = EnumC1761b.GEOLOCALIZED;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4580a);
        parcel.writeInt(this.f4581b ? 1 : 0);
        parcel.writeString(this.f4582c);
        parcel.writeString(this.f4583d);
        parcel.writeString(this.f4584f);
        parcel.writeString(this.f4585g);
        parcel.writeLong(this.f4586h);
        parcel.writeLong(this.f4587i);
        parcel.writeString(this.f4588j);
        parcel.writeString(this.f4589k);
        parcel.writeString(this.f4590l);
        parcel.writeDouble(this.f4591m);
        parcel.writeSerializable(this.f4592n);
    }

    public PromotionalOffer(Parcel parcel) {
        this.f4589k = null;
        this.f4590l = null;
        this.f4591m = -1.0d;
        this.f4592n = EnumC1761b.GEOLOCALIZED;
        this.f4580a = parcel.readInt();
        this.f4581b = parcel.readInt() == 1;
        this.f4582c = parcel.readString();
        this.f4583d = parcel.readString();
        this.f4584f = parcel.readString();
        this.f4585g = parcel.readString();
        this.f4586h = parcel.readLong();
        this.f4587i = parcel.readLong();
        this.f4588j = parcel.readString();
        this.f4589k = parcel.readString();
        this.f4590l = parcel.readString();
        this.f4591m = parcel.readDouble();
        this.f4592n = (EnumC1761b) parcel.readSerializable();
    }
}
