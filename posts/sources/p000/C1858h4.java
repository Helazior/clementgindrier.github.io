package p000;

import java.util.Comparator;

/* renamed from: h4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1858h4 {

    /* renamed from: a */
    public static final Comparator<byte[]> f5141a = new C1859a();

    /* renamed from: h4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1859a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length != bArr4.length) {
                i = bArr3.length;
                i2 = bArr4.length;
            } else {
                for (int i3 = 0; i3 < bArr3.length; i3++) {
                    if (bArr3[i3] != bArr4[i3]) {
                        i = bArr3[i3];
                        i2 = bArr4[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[LOOP:1: B:15:0x004b->B:30:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0094 A[EDGE_INSN: B:79:0x0094->B:32:0x0094 ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000.C2020o4 m781a(android.content.Context r20, p000.C1886i4 r21, android.os.CancellationSignal r22) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1858h4.m781a(android.content.Context, i4, android.os.CancellationSignal):o4");
    }
}
