package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0813a();

    /* renamed from: a */
    public final String f3131a;

    /* renamed from: b */
    public final String f3132b;

    /* renamed from: c */
    public final boolean f3133c;

    /* renamed from: d */
    public final int f3134d;

    /* renamed from: f */
    public final int f3135f;

    /* renamed from: g */
    public final String f3136g;

    /* renamed from: h */
    public final boolean f3137h;

    /* renamed from: i */
    public final boolean f3138i;

    /* renamed from: j */
    public final boolean f3139j;

    /* renamed from: k */
    public final Bundle f3140k;

    /* renamed from: l */
    public final boolean f3141l;

    /* renamed from: m */
    public final int f3142m;

    /* renamed from: n */
    public Bundle f3143n;

    /* renamed from: o */
    public Fragment f3144o;

    /* renamed from: androidx.fragment.app.FragmentState$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0813a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f3131a = fragment.getClass().getName();
        this.f3132b = fragment.mWho;
        this.f3133c = fragment.mFromLayout;
        this.f3134d = fragment.mFragmentId;
        this.f3135f = fragment.mContainerId;
        this.f3136g = fragment.mTag;
        this.f3137h = fragment.mRetainInstance;
        this.f3138i = fragment.mRemoving;
        this.f3139j = fragment.mDetached;
        this.f3140k = fragment.mArguments;
        this.f3141l = fragment.mHidden;
        this.f3142m = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3131a);
        sb.append(" (");
        sb.append(this.f3132b);
        sb.append(")}:");
        if (this.f3133c) {
            sb.append(" fromLayout");
        }
        if (this.f3135f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3135f));
        }
        String str = this.f3136g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f3136g);
        }
        if (this.f3137h) {
            sb.append(" retainInstance");
        }
        if (this.f3138i) {
            sb.append(" removing");
        }
        if (this.f3139j) {
            sb.append(" detached");
        }
        if (this.f3141l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3131a);
        parcel.writeString(this.f3132b);
        parcel.writeInt(this.f3133c ? 1 : 0);
        parcel.writeInt(this.f3134d);
        parcel.writeInt(this.f3135f);
        parcel.writeString(this.f3136g);
        parcel.writeInt(this.f3137h ? 1 : 0);
        parcel.writeInt(this.f3138i ? 1 : 0);
        parcel.writeInt(this.f3139j ? 1 : 0);
        parcel.writeBundle(this.f3140k);
        parcel.writeInt(this.f3141l ? 1 : 0);
        parcel.writeBundle(this.f3143n);
        parcel.writeInt(this.f3142m);
    }

    public FragmentState(Parcel parcel) {
        this.f3131a = parcel.readString();
        this.f3132b = parcel.readString();
        this.f3133c = parcel.readInt() != 0;
        this.f3134d = parcel.readInt();
        this.f3135f = parcel.readInt();
        this.f3136g = parcel.readString();
        this.f3137h = parcel.readInt() != 0;
        this.f3138i = parcel.readInt() != 0;
        this.f3139j = parcel.readInt() != 0;
        this.f3140k = parcel.readBundle();
        this.f3141l = parcel.readInt() != 0;
        this.f3143n = parcel.readBundle();
        this.f3142m = parcel.readInt();
    }
}
