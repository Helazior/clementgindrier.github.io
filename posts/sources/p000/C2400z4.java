package p000;

import android.util.Log;
import java.io.Writer;

@Deprecated
/* renamed from: z4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2399z4 extends Writer {

    /* renamed from: a */
    public final String f6914a;

    /* renamed from: b */
    public StringBuilder f6915b = new StringBuilder(128);

    public C2399z4(String str) {
        this.f6914a = str;
    }

    /* renamed from: E */
    public final void m5E() {
        if (this.f6915b.length() > 0) {
            Log.d(this.f6914a, this.f6915b.toString());
            StringBuilder sb = this.f6915b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m5E();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m5E();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m5E();
            } else {
                this.f6915b.append(c);
            }
        }
    }
}
