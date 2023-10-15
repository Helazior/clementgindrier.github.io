package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ProInfos implements Parcelable {
    public static final Parcelable.Creator<ProInfos> CREATOR;

    /* renamed from: a */
    public boolean f4556a;

    /* renamed from: b */
    public String f4557b;

    /* renamed from: c */
    public String f4558c;

    /* renamed from: d */
    public double f4559d;

    /* renamed from: f */
    public double f4560f;

    /* renamed from: g */
    public double f4561g;

    /* renamed from: h */
    public boolean f4562h;

    /* renamed from: i */
    public boolean f4563i;

    /* renamed from: j */
    public int f4564j;

    /* renamed from: k */
    public boolean f4565k;

    /* renamed from: l */
    public boolean f4566l;

    /* renamed from: m */
    public int f4567m;

    /* renamed from: n */
    public String f4568n;

    /* renamed from: o */
    public String f4569o;

    /* renamed from: p */
    public ArrayList<PromotionalOffer> f4570p;

    /* renamed from: q */
    public ArrayList<ProProduct> f4571q;

    /* renamed from: r */
    public ArrayList<String> f4572r;

    /* renamed from: fr.smoney.android.izly.data.model.ProInfos$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1758a implements Parcelable.Creator<ProInfos> {
        @Override // android.os.Parcelable.Creator
        public ProInfos createFromParcel(Parcel parcel) {
            return new ProInfos(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ProInfos[] newArray(int i) {
            return new ProInfos[i];
        }
    }

    static {
        new DecimalFormat("0.00");
        new DecimalFormat(CrashlyticsReportDataCapture.SIGNAL_DEFAULT);
        CREATOR = new C1758a();
    }

    public ProInfos() {
        this.f4559d = -1.0d;
        this.f4560f = -1.0d;
        this.f4561g = -1.0d;
        this.f4570p = new ArrayList<>();
        this.f4571q = new ArrayList<>();
        this.f4572r = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4556a ? 1 : 0);
        parcel.writeString(this.f4557b);
        parcel.writeString(this.f4558c);
        parcel.writeDouble(this.f4559d);
        parcel.writeDouble(this.f4560f);
        parcel.writeDouble(this.f4561g);
        parcel.writeInt(this.f4562h ? 1 : 0);
        parcel.writeInt(this.f4563i ? 1 : 0);
        parcel.writeInt(this.f4564j);
        parcel.writeInt(this.f4565k ? 1 : 0);
        parcel.writeInt(this.f4566l ? 1 : 0);
        parcel.writeInt(this.f4567m);
        parcel.writeString(this.f4568n);
        parcel.writeString(this.f4569o);
        int size = this.f4570p.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.f4570p.get(i2), i);
        }
        int size2 = this.f4571q.size();
        parcel.writeInt(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            parcel.writeParcelable(this.f4571q.get(i3), i);
        }
        int size3 = this.f4572r.size();
        parcel.writeInt(size3);
        for (int i4 = 0; i4 < size3; i4++) {
            parcel.writeString(this.f4572r.get(i4));
        }
    }

    public ProInfos(Parcel parcel) {
        this.f4559d = -1.0d;
        this.f4560f = -1.0d;
        this.f4561g = -1.0d;
        this.f4556a = parcel.readInt() == 1;
        this.f4557b = parcel.readString();
        this.f4558c = parcel.readString();
        this.f4559d = parcel.readDouble();
        this.f4560f = parcel.readDouble();
        this.f4561g = parcel.readDouble();
        this.f4562h = parcel.readInt() == 1;
        this.f4563i = parcel.readInt() == 1;
        this.f4564j = parcel.readInt();
        this.f4565k = parcel.readInt() == 1;
        this.f4566l = parcel.readInt() == 1;
        this.f4567m = parcel.readInt();
        this.f4568n = parcel.readString();
        this.f4569o = parcel.readString();
        int readInt = parcel.readInt();
        this.f4570p = new ArrayList<>();
        for (int i = 0; i < readInt; i++) {
            this.f4570p.add((PromotionalOffer) parcel.readParcelable(ProInfos.class.getClassLoader()));
        }
        int readInt2 = parcel.readInt();
        this.f4571q = new ArrayList<>();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.f4571q.add((ProProduct) parcel.readParcelable(ProInfos.class.getClassLoader()));
        }
        int readInt3 = parcel.readInt();
        this.f4572r = new ArrayList<>();
        for (int i3 = 0; i3 < readInt3; i3++) {
            this.f4572r.add(parcel.readString());
        }
    }
}
