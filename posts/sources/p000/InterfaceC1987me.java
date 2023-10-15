package p000;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* renamed from: me */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface InterfaceC1987me extends InterfaceC0073Ce, ReadableByteChannel {
    /* renamed from: A */
    boolean mo96A(long j, C2011ne c2011ne);

    /* renamed from: B */
    long mo95B();

    /* renamed from: C */
    String mo94C(Charset charset);

    /* renamed from: D */
    InputStream mo93D();

    /* renamed from: a */
    C1946ke mo91a();

    /* renamed from: e */
    C2011ne mo90e(long j);

    /* renamed from: h */
    boolean mo89h(long j);

    /* renamed from: j */
    String mo88j();

    /* renamed from: k */
    byte[] mo87k();

    /* renamed from: l */
    int mo86l();

    /* renamed from: m */
    boolean mo85m();

    /* renamed from: o */
    byte[] mo84o(long j);

    /* renamed from: r */
    void mo83r(C1946ke c1946ke, long j);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    /* renamed from: s */
    short mo82s();

    void skip(long j);

    /* renamed from: u */
    long mo81u();

    /* renamed from: v */
    String mo80v(long j);

    /* renamed from: w */
    void mo79w(long j);

    /* renamed from: z */
    long mo78z(byte b);
}
