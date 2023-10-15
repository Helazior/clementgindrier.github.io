package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new C0812a();

    /* renamed from: a */
    public ArrayList<FragmentState> f3126a;

    /* renamed from: b */
    public ArrayList<String> f3127b;

    /* renamed from: c */
    public BackStackState[] f3128c;

    /* renamed from: d */
    public String f3129d;

    /* renamed from: f */
    public int f3130f;

    /* renamed from: androidx.fragment.app.FragmentManagerState$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0812a implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
        this.f3129d = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f3126a);
        parcel.writeStringList(this.f3127b);
        parcel.writeTypedArray(this.f3128c, i);
        parcel.writeString(this.f3129d);
        parcel.writeInt(this.f3130f);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f3129d = null;
        this.f3126a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f3127b = parcel.createStringArrayList();
        this.f3128c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f3129d = parcel.readString();
        this.f3130f = parcel.readInt();
    }
}
