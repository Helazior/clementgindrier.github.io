package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Support implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C1768a();

    /* renamed from: a */
    public long f4611a;

    /* renamed from: b */
    public EnumC0576Y8 f4612b;

    /* renamed from: c */
    public String f4613c;

    /* renamed from: d */
    public String f4614d;

    /* renamed from: f */
    public String f4615f;

    /* renamed from: g */
    public String f4616g;

    /* renamed from: h */
    public boolean f4617h;

    /* renamed from: i */
    public int f4618i;

    /* renamed from: fr.smoney.android.izly.data.model.Support$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1768a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new Support(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new Support[i];
        }
    }

    public Support(long j, EnumC0576Y8 enumC0576Y8, String str, String str2, String str3, String str4, boolean z, int i) {
        this.f4611a = j;
        this.f4616g = str4;
        this.f4617h = z;
        this.f4612b = enumC0576Y8;
        this.f4613c = str;
        this.f4614d = str2;
        this.f4615f = str3;
        this.f4618i = i;
    }

    /* renamed from: a */
    public String m959a() {
        String str = this.f4615f;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = this.f4615f;
        Time time = C0278Ld.f920a;
        return new SimpleDateFormat("dd/MM/yy").format(new Date(C0278Ld.m2212f(str2)));
    }

    /* renamed from: b */
    public String m958b() {
        String str = this.f4616g;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = this.f4616g;
        Time time = C0278Ld.f920a;
        return new SimpleDateFormat("dd/MM/yy").format(new Date(C0278Ld.m2212f(str2)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("Support{id=");
        m253r.append(this.f4611a);
        m253r.append(", type=");
        m253r.append(this.f4612b);
        m253r.append(", crous='");
        m253r.append(this.f4613c);
        m253r.append('\'');
        m253r.append(", label='");
        m253r.append(this.f4614d);
        m253r.append('\'');
        m253r.append(", expiration='");
        m253r.append(this.f4615f);
        m253r.append('\'');
        m253r.append(", opositeDate='");
        m253r.append(this.f4616g);
        m253r.append('\'');
        m253r.append(", isOpositePermanent=");
        m253r.append(this.f4617h);
        m253r.append('}');
        return m253r.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{this.f4613c, this.f4614d, this.f4615f, this.f4616g, this.f4612b.name()});
        parcel.writeLong(this.f4611a);
        parcel.writeBooleanArray(new boolean[]{this.f4617h});
        parcel.writeInt(this.f4618i);
    }

    public Support(Parcel parcel) {
        String[] strArr = new String[5];
        parcel.readStringArray(strArr);
        this.f4613c = strArr[0];
        this.f4614d = strArr[1];
        this.f4615f = strArr[2];
        this.f4616g = strArr[3];
        this.f4612b = EnumC0576Y8.valueOf(strArr[4]);
        this.f4611a = parcel.readLong();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f4617h = zArr[0];
        this.f4618i = parcel.readInt();
    }
}
