package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import p000.AbstractC0352P5;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0802a();

    /* renamed from: a */
    public final int[] f3078a;

    /* renamed from: b */
    public final ArrayList<String> f3079b;

    /* renamed from: c */
    public final int[] f3080c;

    /* renamed from: d */
    public final int[] f3081d;

    /* renamed from: f */
    public final int f3082f;

    /* renamed from: g */
    public final int f3083g;

    /* renamed from: h */
    public final String f3084h;

    /* renamed from: i */
    public final int f3085i;

    /* renamed from: j */
    public final int f3086j;

    /* renamed from: k */
    public final CharSequence f3087k;

    /* renamed from: l */
    public final int f3088l;

    /* renamed from: m */
    public final CharSequence f3089m;

    /* renamed from: n */
    public final ArrayList<String> f3090n;

    /* renamed from: o */
    public final ArrayList<String> f3091o;

    /* renamed from: p */
    public final boolean f3092p;

    /* renamed from: androidx.fragment.app.BackStackState$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0802a implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(C0088D5 c0088d5) {
        int size = c0088d5.f1188a.size();
        this.f3078a = new int[size * 5];
        if (c0088d5.f1195h) {
            this.f3079b = new ArrayList<>(size);
            this.f3080c = new int[size];
            this.f3081d = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                AbstractC0352P5.C0353a c0353a = c0088d5.f1188a.get(i);
                int i3 = i2 + 1;
                this.f3078a[i2] = c0353a.f1204a;
                ArrayList<String> arrayList = this.f3079b;
                Fragment fragment = c0353a.f1205b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f3078a;
                int i4 = i3 + 1;
                iArr[i3] = c0353a.f1206c;
                int i5 = i4 + 1;
                iArr[i4] = c0353a.f1207d;
                int i6 = i5 + 1;
                iArr[i5] = c0353a.f1208e;
                iArr[i6] = c0353a.f1209f;
                this.f3080c[i] = c0353a.f1210g.ordinal();
                this.f3081d[i] = c0353a.f1211h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.f3082f = c0088d5.f1193f;
            this.f3083g = c0088d5.f1194g;
            this.f3084h = c0088d5.f1196i;
            this.f3085i = c0088d5.f351s;
            this.f3086j = c0088d5.f1197j;
            this.f3087k = c0088d5.f1198k;
            this.f3088l = c0088d5.f1199l;
            this.f3089m = c0088d5.f1200m;
            this.f3090n = c0088d5.f1201n;
            this.f3091o = c0088d5.f1202o;
            this.f3092p = c0088d5.f1203p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f3078a);
        parcel.writeStringList(this.f3079b);
        parcel.writeIntArray(this.f3080c);
        parcel.writeIntArray(this.f3081d);
        parcel.writeInt(this.f3082f);
        parcel.writeInt(this.f3083g);
        parcel.writeString(this.f3084h);
        parcel.writeInt(this.f3085i);
        parcel.writeInt(this.f3086j);
        TextUtils.writeToParcel(this.f3087k, parcel, 0);
        parcel.writeInt(this.f3088l);
        TextUtils.writeToParcel(this.f3089m, parcel, 0);
        parcel.writeStringList(this.f3090n);
        parcel.writeStringList(this.f3091o);
        parcel.writeInt(this.f3092p ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f3078a = parcel.createIntArray();
        this.f3079b = parcel.createStringArrayList();
        this.f3080c = parcel.createIntArray();
        this.f3081d = parcel.createIntArray();
        this.f3082f = parcel.readInt();
        this.f3083g = parcel.readInt();
        this.f3084h = parcel.readString();
        this.f3085i = parcel.readInt();
        this.f3086j = parcel.readInt();
        this.f3087k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3088l = parcel.readInt();
        this.f3089m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3090n = parcel.createStringArrayList();
        this.f3091o = parcel.createStringArrayList();
        this.f3092p = parcel.readInt() != 0;
    }
}
