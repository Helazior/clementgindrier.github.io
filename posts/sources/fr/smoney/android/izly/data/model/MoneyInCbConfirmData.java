package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MoneyInCbConfirmData implements Parcelable {
    public static final Parcelable.Creator<MoneyInCbConfirmData> CREATOR = new C1733a();

    /* renamed from: a */
    public MoneyInCb f4426a;

    /* renamed from: b */
    public boolean f4427b;

    /* renamed from: c */
    public CurrentUserSubscriptionPlan f4428c;

    /* renamed from: d */
    public CbUser f4429d;

    /* renamed from: f */
    public String f4430f;

    /* renamed from: g */
    public String f4431g;

    /* renamed from: h */
    public BalanceData f4432h;

    /* renamed from: i */
    public String f4433i;

    /* renamed from: fr.smoney.android.izly.data.model.MoneyInCbConfirmData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1733a implements Parcelable.Creator<MoneyInCbConfirmData> {
        @Override // android.os.Parcelable.Creator
        public MoneyInCbConfirmData createFromParcel(Parcel parcel) {
            return new MoneyInCbConfirmData(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        public MoneyInCbConfirmData[] newArray(int i) {
            return new MoneyInCbConfirmData[i];
        }
    }

    public MoneyInCbConfirmData() {
        this.f4426a = new MoneyInCb();
        this.f4430f = null;
        this.f4431g = null;
        this.f4427b = false;
        this.f4428c = new CurrentUserSubscriptionPlan();
        this.f4429d = new CbUser();
        this.f4432h = new BalanceData();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.f4426a.writeToParcel(parcel, i);
        parcel.writeString(this.f4430f);
        parcel.writeString(this.f4431g);
        parcel.writeInt(this.f4427b ? 1 : 0);
        CurrentUserSubscriptionPlan currentUserSubscriptionPlan = this.f4428c;
        parcel.writeTypedList(currentUserSubscriptionPlan.f4266a);
        parcel.writeInt(currentUserSubscriptionPlan.f4267b);
        parcel.writeLong(currentUserSubscriptionPlan.f4268c);
        parcel.writeLong(currentUserSubscriptionPlan.f4269d);
        parcel.writeFloat(currentUserSubscriptionPlan.f4270f);
        CbUser cbUser = this.f4429d;
        parcel.writeString(cbUser.f4239a);
        parcel.writeString(cbUser.f4240b);
        BalanceData balanceData = this.f4432h;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
        parcel.writeString(this.f4433i);
    }

    public MoneyInCbConfirmData(Parcel parcel, C1733a c1733a) {
        this.f4426a = new MoneyInCb(parcel);
        this.f4430f = parcel.readString();
        this.f4431g = parcel.readString();
        this.f4427b = parcel.readInt() == 1;
        this.f4428c = new CurrentUserSubscriptionPlan(parcel);
        this.f4429d = new CbUser(parcel);
        this.f4432h = new BalanceData(parcel);
        this.f4433i = parcel.readString();
    }
}
