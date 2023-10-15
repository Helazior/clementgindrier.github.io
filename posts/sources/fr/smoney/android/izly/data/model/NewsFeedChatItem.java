package fr.smoney.android.izly.data.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import fr.smoney.android.izly.data.model.NewsFeedItem;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NewsFeedChatItem extends NewsFeedItem {
    public static final Parcelable.Creator<NewsFeedChatItem> CREATOR = new C1739a();

    /* renamed from: o */
    public NewsFeedItem.EnumC1745c f4463o;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedChatItem$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1739a implements Parcelable.Creator<NewsFeedChatItem> {
        @Override // android.os.Parcelable.Creator
        public NewsFeedChatItem createFromParcel(Parcel parcel) {
            return new NewsFeedChatItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NewsFeedChatItem[] newArray(int i) {
            return new NewsFeedChatItem[i];
        }
    }

    public NewsFeedChatItem() {
    }

    /* renamed from: g */
    public static NewsFeedItem.EnumC1745c m967g(int i) {
        return NewsFeedItem.f4472m.get(i);
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
        this.f4463o = (NewsFeedItem.EnumC1745c) parcel.readSerializable();
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem
    /* renamed from: f */
    public int mo960f() {
        return 1;
    }

    @Override // fr.smoney.android.izly.data.model.NewsFeedItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeSerializable(this.f4463o);
    }

    public NewsFeedChatItem(Parcel parcel) {
        mo961e(parcel);
    }
}
