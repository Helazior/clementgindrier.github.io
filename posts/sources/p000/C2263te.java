package p000;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* renamed from: te */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2263te {

    /* renamed from: a */
    public static final Logger f6595a = Logger.getLogger(C2263te.class.getName());

    /* renamed from: te$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2264a implements InterfaceC0050Be {

        /* renamed from: a */
        public final /* synthetic */ C0097De f6596a;

        /* renamed from: b */
        public final /* synthetic */ OutputStream f6597b;

        public C2264a(C0097De c0097De, OutputStream outputStream) {
            this.f6596a = c0097De;
            this.f6597b = outputStream;
        }

        @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6597b.close();
        }

        @Override // p000.InterfaceC0050Be, java.io.Flushable
        public void flush() {
            this.f6597b.flush();
        }

        @Override // p000.InterfaceC0050Be
        public C0097De timeout() {
            return this.f6596a;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("sink(");
            m253r.append(this.f6597b);
            m253r.append(")");
            return m253r.toString();
        }

        @Override // p000.InterfaceC0050Be
        public void write(C1946ke c1946ke, long j) {
            C0123Ee.m2457b(c1946ke.f5398b, 0L, j);
            while (j > 0) {
                this.f6596a.throwIfReached();
                C2393ye c2393ye = c1946ke.f5397a;
                int min = (int) Math.min(j, c2393ye.f6890c - c2393ye.f6889b);
                this.f6597b.write(c2393ye.f6888a, c2393ye.f6889b, min);
                int i = c2393ye.f6889b + min;
                c2393ye.f6889b = i;
                long j2 = min;
                j -= j2;
                c1946ke.f5398b -= j2;
                if (i == c2393ye.f6890c) {
                    c1946ke.f5397a = c2393ye.m49a();
                    C2410ze.m1a(c2393ye);
                }
            }
        }
    }

    /* renamed from: te$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2265b implements InterfaceC0073Ce {

        /* renamed from: a */
        public final /* synthetic */ C0097De f6598a;

        /* renamed from: b */
        public final /* synthetic */ InputStream f6599b;

        public C2265b(C0097De c0097De, InputStream inputStream) {
            this.f6598a = c0097De;
            this.f6599b = inputStream;
        }

        @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6599b.close();
        }

        @Override // p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return 0L;
                }
                try {
                    this.f6598a.throwIfReached();
                    C2393ye m664Q = c1946ke.m664Q(1);
                    int read = this.f6599b.read(m664Q.f6888a, m664Q.f6890c, (int) Math.min(j, 8192 - m664Q.f6890c));
                    if (read == -1) {
                        return -1L;
                    }
                    m664Q.f6890c += read;
                    long j2 = read;
                    c1946ke.f5398b += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (C2263te.m338b(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }
            throw new IllegalArgumentException(outline.m272I("byteCount < 0: ", j));
        }

        @Override // p000.InterfaceC0073Ce
        public C0097De timeout() {
            return this.f6598a;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("source(");
            m253r.append(this.f6599b);
            m253r.append(")");
            return m253r.toString();
        }
    }

    /* renamed from: a */
    public static InterfaceC0050Be m339a(File file) {
        if (file != null) {
            return m336d(new FileOutputStream(file, true), new C0097De());
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    public static boolean m338b(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: c */
    public static InterfaceC0050Be m337c(File file) {
        if (file != null) {
            return m336d(new FileOutputStream(file), new C0097De());
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: d */
    public static InterfaceC0050Be m336d(OutputStream outputStream, C0097De c0097De) {
        if (outputStream != null) {
            return new C2264a(c0097De, outputStream);
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: e */
    public static InterfaceC0050Be m335e(Socket socket) {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                C2301ve c2301ve = new C2301ve(socket);
                return c2301ve.sink(m336d(socket.getOutputStream(), c2301ve));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: f */
    public static InterfaceC0073Ce m334f(InputStream inputStream) {
        return m333g(inputStream, new C0097De());
    }

    /* renamed from: g */
    public static InterfaceC0073Ce m333g(InputStream inputStream, C0097De c0097De) {
        if (inputStream != null) {
            return new C2265b(c0097De, inputStream);
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: h */
    public static InterfaceC0073Ce m332h(Socket socket) {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                C2301ve c2301ve = new C2301ve(socket);
                return c2301ve.source(m333g(socket.getInputStream(), c2301ve));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }
}
