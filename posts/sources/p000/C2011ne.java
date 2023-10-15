package p000;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: ne */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2011ne implements Serializable, Comparable<C2011ne> {

    /* renamed from: d */
    public static final char[] f5560d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: f */
    public static final C2011ne f5561f = m554i(new byte[0]);

    /* renamed from: a */
    public final byte[] f5562a;

    /* renamed from: b */
    public transient int f5563b;

    /* renamed from: c */
    public transient String f5564c;

    public C2011ne(byte[] bArr) {
        this.f5562a = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
        r5 = null;
     */
    @javax.annotation.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000.C2011ne m561b(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2011ne.m561b(java.lang.String):ne");
    }

    /* renamed from: c */
    public static C2011ne m560c(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (m559d(str.charAt(i2 + 1)) + (m559d(str.charAt(i2)) << 4));
            }
            return m554i(bArr);
        }
        throw new IllegalArgumentException(outline.m266e("Unexpected hex string: ", str));
    }

    /* renamed from: d */
    public static int m559d(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = 'A';
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c);
                }
            }
            return (c - c2) + 10;
        }
        return c - '0';
    }

    /* renamed from: f */
    public static C2011ne m557f(String str) {
        if (str != null) {
            C2011ne c2011ne = new C2011ne(str.getBytes(C0123Ee.f428a));
            c2011ne.f5564c = str;
            return c2011ne;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: i */
    public static C2011ne m554i(byte... bArr) {
        if (bArr != null) {
            return new C2011ne((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            int i = 0;
            while (i < readInt) {
                int read = objectInputStream.read(bArr, i, readInt - i);
                if (read == -1) {
                    throw new EOFException();
                }
                i += read;
            }
            C2011ne c2011ne = new C2011ne(bArr);
            try {
                Field declaredField = C2011ne.class.getDeclaredField("a");
                declaredField.setAccessible(true);
                declaredField.set(this, c2011ne.f5562a);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (NoSuchFieldException unused2) {
                throw new AssertionError();
            }
        }
        throw new IllegalArgumentException(outline.m273H("byteCount < 0: ", readInt));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f5562a.length);
        objectOutputStream.write(this.f5562a);
    }

    /* renamed from: a */
    public String mo562a() {
        byte[] bArr = this.f5562a;
        byte[] bArr2 = C1929je.f5367a;
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & 255) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & 15) << 2) | ((bArr[i7] & 255) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i9] = 61;
            bArr3[i9 + 1] = 61;
        } else if (length2 == 2) {
            int i10 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & 255) >> 2];
            int i11 = i10 + 1;
            int i12 = length + 1;
            bArr3[i10] = bArr2[((bArr[i12] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i11] = bArr2[(bArr[i12] & 15) << 2];
            bArr3[i11 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(p000.C2011ne r10) {
        /*
            r9 = this;
            ne r10 = (p000.C2011ne) r10
            int r0 = r9.mo550m()
            int r1 = r10.mo550m()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L10:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.mo556g(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.mo556g(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L25
            int r4 = r4 + 1
            goto L10
        L25:
            if (r7 >= r8) goto L29
        L27:
            r3 = -1
            goto L31
        L29:
            r3 = 1
            goto L31
        L2b:
            if (r0 != r1) goto L2e
            goto L31
        L2e:
            if (r0 >= r1) goto L29
            goto L27
        L31:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2011ne.compareTo(java.lang.Object):int");
    }

    /* renamed from: e */
    public final C2011ne m558e(String str) {
        try {
            return m554i(MessageDigest.getInstance(str).digest(this.f5562a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2011ne) {
            C2011ne c2011ne = (C2011ne) obj;
            int mo550m = c2011ne.mo550m();
            byte[] bArr = this.f5562a;
            if (mo550m == bArr.length && c2011ne.mo552k(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public byte mo556g(int i) {
        return this.f5562a[i];
    }

    /* renamed from: h */
    public String mo555h() {
        byte[] bArr = this.f5562a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f5560d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public int hashCode() {
        int i = this.f5563b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f5562a);
        this.f5563b = hashCode;
        return hashCode;
    }

    /* renamed from: j */
    public boolean mo553j(int i, C2011ne c2011ne, int i2, int i3) {
        return c2011ne.mo552k(i2, this.f5562a, i, i3);
    }

    /* renamed from: k */
    public boolean mo552k(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f5562a;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C0123Ee.m2458a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public C2011ne mo551l() {
        return m558e("SHA-1");
    }

    /* renamed from: m */
    public int mo550m() {
        return this.f5562a.length;
    }

    /* renamed from: n */
    public C2011ne mo549n(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f5562a;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 >= 0) {
                    if (i == 0 && i2 == bArr.length) {
                        return this;
                    }
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i, bArr2, 0, i3);
                    return new C2011ne(bArr2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(outline.m263h(outline.m253r("endIndex > length("), this.f5562a.length, ")"));
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    /* renamed from: o */
    public C2011ne mo548o() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f5562a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new C2011ne(bArr2);
            }
            i++;
        }
    }

    /* renamed from: p */
    public byte[] mo547p() {
        return (byte[]) this.f5562a.clone();
    }

    /* renamed from: q */
    public String mo546q() {
        String str = this.f5564c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f5562a, C0123Ee.f428a);
        this.f5564c = str2;
        return str2;
    }

    /* renamed from: r */
    public void mo545r(C1946ke c1946ke) {
        byte[] bArr = this.f5562a;
        c1946ke.m661T(bArr, 0, bArr.length);
    }

    public String toString() {
        if (this.f5562a.length == 0) {
            return "[size=0]";
        }
        String mo546q = mo546q();
        int length = mo546q.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = mo546q.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = mo546q.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i == -1) {
            if (this.f5562a.length <= 64) {
                StringBuilder m253r = outline.m253r("[hex=");
                m253r.append(mo555h());
                m253r.append("]");
                return m253r.toString();
            }
            StringBuilder m253r2 = outline.m253r("[size=");
            m253r2.append(this.f5562a.length);
            m253r2.append(" hex=");
            m253r2.append(mo549n(0, 64).mo555h());
            m253r2.append("…]");
            return m253r2.toString();
        }
        String replace = mo546q.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i < mo546q.length()) {
            StringBuilder m253r3 = outline.m253r("[size=");
            m253r3.append(this.f5562a.length);
            m253r3.append(" text=");
            m253r3.append(replace);
            m253r3.append("…]");
            return m253r3.toString();
        }
        return outline.m265f("[text=", replace, "]");
    }
}
