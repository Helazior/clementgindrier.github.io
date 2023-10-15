package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.i18n.MessageBundle;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ActuDetail implements Parcelable {
    @NotNull
    public static final C1694a CREATOR = new C1694a(null);

    /* renamed from: a */
    public long f4221a;

    /* renamed from: b */
    public String f4222b;

    /* renamed from: c */
    public String f4223c;

    /* renamed from: d */
    public String f4224d;

    /* renamed from: f */
    public String f4225f;

    /* renamed from: g */
    public EnumC0520V8 f4226g;

    /* renamed from: h */
    public String f4227h;
    @NotNull

    /* renamed from: i */
    public String f4228i = "none";

    /* renamed from: fr.smoney.android.izly.data.model.ActuDetail$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1694a implements Parcelable.Creator<ActuDetail> {
        public C1694a(C0565Xd c0565Xd) {
        }

        @Override // android.os.Parcelable.Creator
        public ActuDetail createFromParcel(Parcel parcel) {
            EnumC0520V8 enumC0520V8;
            C0581Yd.m1766e(parcel, "parcel");
            C0581Yd.m1766e(parcel, "parcel");
            ActuDetail actuDetail = new ActuDetail();
            actuDetail.f4221a = parcel.readLong();
            actuDetail.f4222b = String.valueOf(parcel.readString());
            actuDetail.f4223c = String.valueOf(parcel.readString());
            actuDetail.f4224d = String.valueOf(parcel.readString());
            actuDetail.f4225f = String.valueOf(parcel.readString());
            Integer valueOf = Integer.valueOf(parcel.readInt());
            EnumC0520V8[] values = EnumC0520V8.values();
            int i = 0;
            while (true) {
                if (i < 6) {
                    enumC0520V8 = values[i];
                    int i2 = enumC0520V8.f1850a;
                    if (valueOf != null && i2 == valueOf.intValue()) {
                        break;
                    }
                    i++;
                } else {
                    enumC0520V8 = EnumC0520V8.ERROR;
                    break;
                }
            }
            actuDetail.f4226g = enumC0520V8;
            actuDetail.f4227h = String.valueOf(parcel.readString());
            actuDetail.f4228i = String.valueOf(parcel.readString());
            return actuDetail;
        }

        @Override // android.os.Parcelable.Creator
        public ActuDetail[] newArray(int i) {
            return new ActuDetail[i];
        }
    }

    /* renamed from: a */
    public final void m975a(@NotNull String str) {
        C0581Yd.m1766e(str, "<set-?>");
        this.f4228i = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        C0581Yd.m1766e(parcel, "parcel");
        parcel.writeLong(this.f4221a);
        String str = this.f4222b;
        if (str != null) {
            parcel.writeString(str);
            String str2 = this.f4223c;
            if (str2 != null) {
                parcel.writeString(str2);
                String str3 = this.f4224d;
                if (str3 != null) {
                    parcel.writeString(str3);
                    String str4 = this.f4225f;
                    if (str4 != null) {
                        parcel.writeString(str4);
                        EnumC0520V8 enumC0520V8 = this.f4226g;
                        if (enumC0520V8 != null) {
                            parcel.writeInt(enumC0520V8.f1850a);
                            String str5 = this.f4227h;
                            if (str5 != null) {
                                parcel.writeString(str5);
                                parcel.writeString(this.f4228i);
                                return;
                            }
                            C0581Yd.m1761j("image");
                            throw null;
                        }
                        C0581Yd.m1761j("iconValue");
                        throw null;
                    }
                    C0581Yd.m1761j("longDesc");
                    throw null;
                }
                C0581Yd.m1761j("shortDesc");
                throw null;
            }
            C0581Yd.m1761j("subTitle");
            throw null;
        }
        C0581Yd.m1761j(MessageBundle.TITLE_ENTRY);
        throw null;
    }
}
