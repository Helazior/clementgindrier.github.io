package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* renamed from: j8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1923j8 extends AbstractC1894i8 {

    /* renamed from: d */
    public final SparseIntArray f5349d;

    /* renamed from: e */
    public final Parcel f5350e;

    /* renamed from: f */
    public final int f5351f;

    /* renamed from: g */
    public final int f5352g;

    /* renamed from: h */
    public final String f5353h;

    /* renamed from: i */
    public int f5354i;

    /* renamed from: j */
    public int f5355j;

    /* renamed from: k */
    public int f5356k;

    public C1923j8(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C2339x1(), new C2339x1(), new C2339x1());
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: a */
    public void mo698a() {
        int i = this.f5354i;
        if (i >= 0) {
            int i2 = this.f5349d.get(i);
            int dataPosition = this.f5350e.dataPosition();
            this.f5350e.setDataPosition(i2);
            this.f5350e.writeInt(dataPosition - i2);
            this.f5350e.setDataPosition(dataPosition);
        }
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: b */
    public AbstractC1894i8 mo697b() {
        Parcel parcel = this.f5350e;
        int dataPosition = parcel.dataPosition();
        int i = this.f5355j;
        if (i == this.f5351f) {
            i = this.f5352g;
        }
        return new C1923j8(parcel, dataPosition, i, outline.m262i(new StringBuilder(), this.f5353h, "  "), this.f5282a, this.f5283b, this.f5284c);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: f */
    public boolean mo696f() {
        return this.f5350e.readInt() != 0;
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: g */
    public byte[] mo695g() {
        int readInt = this.f5350e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f5350e.readByteArray(bArr);
        return bArr;
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: h */
    public CharSequence mo694h() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f5350e);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: i */
    public boolean mo693i(int i) {
        while (this.f5355j < this.f5352g) {
            int i2 = this.f5356k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f5350e.setDataPosition(this.f5355j);
            int readInt = this.f5350e.readInt();
            this.f5356k = this.f5350e.readInt();
            this.f5355j += readInt;
        }
        return this.f5356k == i;
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: j */
    public int mo692j() {
        return this.f5350e.readInt();
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: l */
    public <T extends Parcelable> T mo691l() {
        return (T) this.f5350e.readParcelable(C1923j8.class.getClassLoader());
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: n */
    public String mo690n() {
        return this.f5350e.readString();
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: p */
    public void mo689p(int i) {
        mo698a();
        this.f5354i = i;
        this.f5349d.put(i, this.f5350e.dataPosition());
        this.f5350e.writeInt(0);
        this.f5350e.writeInt(i);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: q */
    public void mo688q(boolean z) {
        this.f5350e.writeInt(z ? 1 : 0);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: r */
    public void mo687r(byte[] bArr) {
        if (bArr != null) {
            this.f5350e.writeInt(bArr.length);
            this.f5350e.writeByteArray(bArr);
            return;
        }
        this.f5350e.writeInt(-1);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: s */
    public void mo686s(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f5350e, 0);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: t */
    public void mo685t(int i) {
        this.f5350e.writeInt(i);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: u */
    public void mo684u(Parcelable parcelable) {
        this.f5350e.writeParcelable(parcelable, 0);
    }

    @Override // p000.AbstractC1894i8
    /* renamed from: v */
    public void mo683v(String str) {
        this.f5350e.writeString(str);
    }

    public C1923j8(Parcel parcel, int i, int i2, String str, C2339x1<String, Method> c2339x1, C2339x1<String, Method> c2339x12, C2339x1<String, Class> c2339x13) {
        super(c2339x1, c2339x12, c2339x13);
        this.f5349d = new SparseIntArray();
        this.f5354i = -1;
        this.f5355j = 0;
        this.f5356k = -1;
        this.f5350e = parcel;
        this.f5351f = i;
        this.f5352g = i2;
        this.f5355j = i;
        this.f5353h = str;
    }
}
