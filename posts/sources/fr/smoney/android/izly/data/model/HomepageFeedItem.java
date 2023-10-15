package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HomepageFeedItem extends NewsFeedItem {
    public static final Parcelable.Creator<HomepageFeedItem> CREATOR = new C1720a();

    /* renamed from: o */
    public double f4342o;

    /* renamed from: p */
    public String f4343p;

    /* renamed from: q */
    public EnumC2029od f4344q;

    /* renamed from: fr.smoney.android.izly.data.model.HomepageFeedItem$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1720a implements Parcelable.Creator<HomepageFeedItem> {
        @Override // android.os.Parcelable.Creator
        public HomepageFeedItem createFromParcel(Parcel parcel) {
            return new HomepageFeedItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HomepageFeedItem[] newArray(int i) {
            return new HomepageFeedItem[i];
        }
    }

    public HomepageFeedItem() {
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: b */
    public String mo963b(Context context, String str) {
        return null;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: c */
    public Spanned mo962c(Context context, String str) {
        return null;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: e */
    public void mo961e(Parcel parcel) {
        super.mo961e(parcel);
        this.f4342o = parcel.readDouble();
        this.f4343p = parcel.readString();
        this.f4344q = (EnumC2029od) parcel.readSerializable();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    /* renamed from: g */
    public String m970g(String str) {
        return str.length() > 40 ? String.format("%s...", str.substring(0, 37)) : str;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeDouble(this.f4342o);
        parcel.writeString(this.f4343p);
        parcel.writeSerializable(this.f4344q);
    }

    public HomepageFeedItem(Parcel parcel) {
        mo961e(parcel);
    }
}
