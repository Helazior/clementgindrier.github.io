package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GetNewsFeedData implements Parcelable {
    public static final Parcelable.Creator<GetNewsFeedData> CREATOR = new C1719a();

    /* renamed from: a */
    public BalanceData f4336a;

    /* renamed from: b */
    public long f4337b = -1;

    /* renamed from: c */
    public long f4338c = -1;

    /* renamed from: d */
    public int f4339d = 1;

    /* renamed from: f */
    public boolean f4340f = false;

    /* renamed from: g */
    public List<NewsFeedItem> f4341g = new ArrayList();

    /* renamed from: fr.smoney.android.izly.data.model.GetNewsFeedData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1719a implements Parcelable.Creator<GetNewsFeedData> {
        @Override // android.os.Parcelable.Creator
        public GetNewsFeedData createFromParcel(Parcel parcel) {
            GetNewsFeedData getNewsFeedData = new GetNewsFeedData();
            getNewsFeedData.f4337b = parcel.readLong();
            getNewsFeedData.f4338c = parcel.readLong();
            getNewsFeedData.f4339d = parcel.readInt();
            getNewsFeedData.f4340f = parcel.readInt() == 1;
            int readInt = parcel.readInt();
            for (int i = 0; i < readInt; i++) {
                getNewsFeedData.f4341g.add((NewsFeedItem) parcel.readParcelable(GetNewsFeedData.class.getClassLoader()));
            }
            getNewsFeedData.f4336a = new BalanceData(parcel);
            return getNewsFeedData;
        }

        @Override // android.os.Parcelable.Creator
        public GetNewsFeedData[] newArray(int i) {
            return new GetNewsFeedData[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4337b);
        parcel.writeLong(this.f4338c);
        parcel.writeInt(this.f4339d);
        parcel.writeInt(this.f4340f ? 1 : 0);
        int size = this.f4341g.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.f4341g.get(i2), 0);
        }
        BalanceData balanceData = this.f4336a;
        parcel.writeDouble(balanceData.f4230a);
        parcel.writeDouble(balanceData.f4231b);
        parcel.writeLong(balanceData.f4232c);
    }
}
