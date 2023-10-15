package fr.smoney.android.izly.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PreAuthorizationContainerData implements Parcelable {
    public static final Parcelable.Creator<PreAuthorizationContainerData> CREATOR;

    /* renamed from: a */
    public Contact f4543a;

    /* renamed from: b */
    public double f4544b;

    /* renamed from: c */
    public long f4545c;

    /* renamed from: d */
    public PreAuthorization f4546d;

    /* renamed from: f */
    public EnumC1757b f4547f;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class PreAuthorization implements Parcelable {
        public static final Parcelable.Creator<PreAuthorization> CREATOR = new C1755a();

        /* renamed from: a */
        public String f4548a;

        /* renamed from: b */
        public int f4549b;

        /* renamed from: fr.smoney.android.izly.data.model.PreAuthorizationContainerData$PreAuthorization$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C1755a implements Parcelable.Creator<PreAuthorization> {
            @Override // android.os.Parcelable.Creator
            public PreAuthorization createFromParcel(Parcel parcel) {
                return new PreAuthorization(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public PreAuthorization[] newArray(int i) {
                return new PreAuthorization[i];
            }
        }

        public PreAuthorization() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f4548a);
            parcel.writeInt(this.f4549b);
        }

        public PreAuthorization(Parcel parcel) {
            this.f4548a = parcel.readString();
            this.f4549b = parcel.readInt();
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.PreAuthorizationContainerData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1756a implements Parcelable.Creator<PreAuthorizationContainerData> {
        @Override // android.os.Parcelable.Creator
        public PreAuthorizationContainerData createFromParcel(Parcel parcel) {
            return new PreAuthorizationContainerData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PreAuthorizationContainerData[] newArray(int i) {
            return new PreAuthorizationContainerData[i];
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.PreAuthorizationContainerData$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1757b {
        Pending(0),
        Canceled(1),
        Expired(2),
        Accepted(3);
        

        /* renamed from: a */
        public int f4555a;

        EnumC1757b(int i) {
            this.f4555a = i;
        }
    }

    static {
        SparseArray sparseArray = new SparseArray();
        EnumC1757b[] values = EnumC1757b.values();
        for (int i = 0; i < 4; i++) {
            EnumC1757b enumC1757b = values[i];
            sparseArray.append(enumC1757b.f4555a, enumC1757b);
        }
        CREATOR = new C1756a();
    }

    public PreAuthorizationContainerData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f4544b);
        parcel.writeLong(this.f4545c);
        parcel.writeParcelable(this.f4543a, i);
        parcel.writeParcelable(this.f4546d, i);
        parcel.writeSerializable(this.f4547f);
    }

    public PreAuthorizationContainerData(Parcel parcel) {
        this.f4544b = parcel.readDouble();
        this.f4545c = parcel.readLong();
        this.f4543a = (Contact) parcel.readParcelable(PreAuthorizationContainerData.class.getClassLoader());
        this.f4546d = (PreAuthorization) parcel.readParcelable(PreAuthorizationContainerData.class.getClassLoader());
        this.f4547f = (EnumC1757b) parcel.readSerializable();
    }
}
