package fr.smoney.android.izly.data.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import android.util.SparseArray;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Locale;
import org.spongycastle.crypto.tls.CipherSuite;

@SuppressLint({"ParcelCreator"})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class NewsFeedItem implements Parcelable, Comparable<NewsFeedItem> {

    /* renamed from: k */
    public static final SparseArray<EnumC1743a> f4470k;

    /* renamed from: l */
    public static final SparseArray<EnumC1744b> f4471l;

    /* renamed from: m */
    public static final SparseArray<EnumC1745c> f4472m;

    /* renamed from: n */
    public static final SparseArray<EnumC1746d> f4473n;

    /* renamed from: a */
    public double f4474a = -1.0d;

    /* renamed from: b */
    public long f4475b;

    /* renamed from: c */
    public int f4476c;

    /* renamed from: d */
    public EnumC1746d f4477d;

    /* renamed from: f */
    public EnumC1744b f4478f;

    /* renamed from: g */
    public EnumC1743a f4479g;

    /* renamed from: h */
    public NewsFeedContactLight f4480h;

    /* renamed from: i */
    public Long f4481i;

    /* renamed from: j */
    public EnumC1745c f4482j;

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedItem$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1743a {
        TYPE_P2P_PAY_IN(0),
        TYPE_P2P_PAY_OUT(1),
        TYPE_MONEY_IN_CB(2),
        TYPE_MONEY_OUT_TRANSFER(3),
        TYPE_P2P_PAY_REQUEST(4),
        TYPE_P2P_GET(5),
        TYPE_REFUND(6),
        TYPE_ECOMMERCE(7),
        TYPE_DISTRIBUTOR(8),
        TYPE_COMMISSION(9),
        TYPE_MONEY_IN_REFUND(10),
        TYPE_MONEY_OUT_REFUND(11),
        TYPE_COMMISSION_REFUND(15),
        TYPE_ACHAT_PASS(17),
        TYPE_PAY_IN(18),
        TYPE_PAY_IN_REFUND(19),
        MONEY_IN_BANK_ACCOUNT(27);
        

        /* renamed from: a */
        public int f4501a;

        EnumC1743a(int i) {
            this.f4501a = i;
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedItem$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1744b {
        CLIENTMONEYINCB(7),
        FLUXMONEYINCBREFUND(56),
        USERPAYINCARD(159),
        USERPAYINCARDREFUND(160),
        CLIENTMONEYINBANKACCOUNT(215),
        USERMONEYINBANKTRANSFER(222),
        CLIENTCASHMONEYIN(212),
        FLUXCLIENTCASHMONEYINREFUND(213),
        CLIENTMONEYOUTTRANSFER(8),
        FLUXMONEYOUTTRANSFERREFUND(57),
        USERPAYOUT(166),
        CLIENTPAYMENT(2),
        USERREFUNDPAYMENT(CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA);
        

        /* renamed from: a */
        public int f4516a;

        EnumC1744b(int i) {
            this.f4516a = i;
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedItem$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1745c {
        NoneDirection(0),
        InDirection(1),
        OutDirection(2);
        

        /* renamed from: a */
        public int f4521a;

        EnumC1745c(int i) {
            this.f4521a = i;
        }
    }

    /* renamed from: fr.smoney.android.izly.data.model.NewsFeedItem$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1746d {
        SUCCESS(0),
        PENDING(1),
        REFUNDED(2);
        

        /* renamed from: a */
        public int f4526a;

        EnumC1746d(int i) {
            this.f4526a = i;
        }
    }

    static {
        SparseArray<EnumC1743a> sparseArray = new SparseArray<>();
        EnumC1743a[] values = EnumC1743a.values();
        for (int i = 0; i < 17; i++) {
            EnumC1743a enumC1743a = values[i];
            sparseArray.append(enumC1743a.f4501a, enumC1743a);
        }
        f4470k = sparseArray;
        SparseArray<EnumC1744b> sparseArray2 = new SparseArray<>();
        EnumC1744b[] values2 = EnumC1744b.values();
        for (int i2 = 0; i2 < 13; i2++) {
            EnumC1744b enumC1744b = values2[i2];
            sparseArray2.append(enumC1744b.f4516a, enumC1744b);
        }
        f4471l = sparseArray2;
        SparseArray<EnumC1745c> sparseArray3 = new SparseArray<>();
        EnumC1745c[] values3 = EnumC1745c.values();
        for (int i3 = 0; i3 < 3; i3++) {
            EnumC1745c enumC1745c = values3[i3];
            sparseArray3.append(enumC1745c.f4521a, enumC1745c);
        }
        f4472m = sparseArray3;
        SparseArray<EnumC1746d> sparseArray4 = new SparseArray<>();
        EnumC1746d[] values4 = EnumC1746d.values();
        for (int i4 = 0; i4 < 3; i4++) {
            EnumC1746d enumC1746d = values4[i4];
            sparseArray4.append(enumC1746d.f4526a, enumC1746d);
        }
        f4473n = sparseArray4;
    }

    public NewsFeedItem() {
        mo960f();
    }

    /* renamed from: a */
    public static EnumC1743a m966a(int i) {
        return f4470k.get(i);
    }

    /* renamed from: b */
    public abstract String mo963b(Context context, String str);

    /* renamed from: c */
    public abstract Spanned mo962c(Context context, String str);

    @Override // java.lang.Comparable
    public int compareTo(NewsFeedItem newsFeedItem) {
        return this.f4481i.compareTo(newsFeedItem.f4481i);
    }

    /* renamed from: d */
    public String m965d(Context context, String str, double d) {
        if (d < ShadowDrawableWrapper.COS_45) {
            return null;
        }
        return context.getString(2131689871, String.format(Locale.getDefault(), "%1$.2f%2$s", Double.valueOf(d), str));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void mo961e(Parcel parcel) {
        this.f4475b = parcel.readLong();
        this.f4479g = (EnumC1743a) parcel.readSerializable();
        this.f4478f = (EnumC1744b) parcel.readSerializable();
        this.f4481i = Long.valueOf(parcel.readLong());
        this.f4480h = (NewsFeedContactLight) parcel.readParcelable(NewsFeedChatItem.class.getClassLoader());
        this.f4482j = (EnumC1745c) parcel.readSerializable();
        this.f4474a = parcel.readDouble();
    }

    /* renamed from: f */
    public abstract int mo960f();

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4475b);
        parcel.writeSerializable(this.f4479g);
        parcel.writeSerializable(this.f4478f);
        parcel.writeLong(this.f4481i.longValue());
        parcel.writeParcelable(this.f4480h, i);
        parcel.writeSerializable(this.f4482j);
        parcel.writeDouble(this.f4474a);
    }
}
