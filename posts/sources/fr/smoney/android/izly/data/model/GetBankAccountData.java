package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetBankAccountData implements Parcelable {
    public static final Parcelable.Creator<GetBankAccountData> CREATOR = new C1713a();

    /* renamed from: a */
    public long f4279a;

    /* renamed from: b */
    public String f4280b;

    /* renamed from: c */
    public String f4281c;

    /* renamed from: d */
    public String f4282d;

    /* renamed from: f */
    public String f4283f;

    /* renamed from: g */
    public String f4284g;

    /* renamed from: h */
    public boolean f4285h;

    /* renamed from: i */
    public boolean f4286i;

    /* renamed from: j */
    public String f4287j;

    /* renamed from: fr.smoney.android.izly.data.model.GetBankAccountData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1713a implements Parcelable.Creator<GetBankAccountData> {
        @Override // android.os.Parcelable.Creator
        public GetBankAccountData createFromParcel(Parcel parcel) {
            return new GetBankAccountData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GetBankAccountData[] newArray(int i) {
            return new GetBankAccountData[i];
        }
    }

    public GetBankAccountData() {
        this.f4286i = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4279a);
        parcel.writeString(this.f4280b);
        parcel.writeString(this.f4284g);
        parcel.writeString(this.f4282d);
        parcel.writeString(this.f4283f);
        parcel.writeString(this.f4281c);
        parcel.writeInt(this.f4285h ? 1 : 0);
        parcel.writeInt(this.f4286i ? 1 : 0);
        parcel.writeString(this.f4287j);
    }

    public GetBankAccountData(Parcel parcel) {
        this.f4286i = true;
        this.f4279a = parcel.readLong();
        this.f4280b = parcel.readString();
        this.f4284g = parcel.readString();
        this.f4282d = parcel.readString();
        this.f4283f = parcel.readString();
        this.f4281c = parcel.readString();
        this.f4285h = parcel.readInt() == 1;
        this.f4286i = parcel.readInt() == 1;
        this.f4287j = parcel.readString();
    }
}
