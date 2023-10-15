package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    public static final C2011ne PREFIX_CLEAN = C2011ne.m557f("OkHttp cache v1\n");
    public static final C2011ne PREFIX_DIRTY = C2011ne.m557f("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    private final C2011ne metadata;
    public int sourceCount;
    public InterfaceC0073Ce upstream;
    public long upstreamPos;
    public Thread upstreamReader;
    public final C1946ke upstreamBuffer = new C1946ke();
    public final C1946ke buffer = new C1946ke();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RelaySource implements InterfaceC0073Ce {
        private FileOperator fileOperator;
        private long sourcePos;
        private final C0097De timeout = new C0097De();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                int i = relay.sourceCount - 1;
                relay.sourceCount = i;
                if (i == 0) {
                    RandomAccessFile randomAccessFile2 = relay.file;
                    relay.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
            if (r0 != 2) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
            r2 = java.lang.Math.min(r23, r7 - r21.sourcePos);
            r21.fileOperator.read(r21.sourcePos + 32, r22, r2);
            r21.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
            r0 = r21.this$0;
            r12 = r0.upstream.read(r0.upstreamBuffer, r0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0069, code lost:
            if (r12 != (-1)) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
            r21.this$0.commit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
            r2 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
            r0 = r21.this$0;
            r0.upstreamReader = null;
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007f, code lost:
            r2 = java.lang.Math.min(r12, r23);
            r21.this$0.upstreamBuffer.m673H(r22, 0, r2);
            r21.sourcePos += r2;
            r21.fileOperator.write(r7 + 32, r21.this$0.upstreamBuffer.clone(), r12);
            r4 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
            r0 = r21.this$0;
            r0.buffer.write(r0.upstreamBuffer, r12);
            r0 = r21.this$0;
            r5 = r0.buffer;
            r7 = r5.f5398b;
            r9 = r0.bufferMaxSize;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
            if (r7 <= r9) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00be, code lost:
            r5.skip(r7 - r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c2, code lost:
            r5 = r21.this$0;
            r5.upstreamPos += r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c9, code lost:
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ca, code lost:
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
            r0 = r21.this$0;
            r0.upstreamReader = null;
            r0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00da, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00dd, code lost:
            monitor-enter(r21.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00de, code lost:
            r3 = r21.this$0;
            r3.upstreamReader = null;
            r3.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e6, code lost:
            throw r0;
         */
        @Override // p000.InterfaceC0073Ce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(p000.C1946ke r22, long r23) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(ke, long):long");
        }

        @Override // p000.InterfaceC0073Ce
        public C0097De timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, InterfaceC0073Ce interfaceC0073Ce, long j, C2011ne c2011ne, long j2) {
        this.file = randomAccessFile;
        this.upstream = interfaceC0073Ce;
        this.complete = interfaceC0073Ce == null;
        this.upstreamPos = j;
        this.metadata = c2011ne;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, InterfaceC0073Ce interfaceC0073Ce, C2011ne c2011ne, long j) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, interfaceC0073Ce, 0L, c2011ne, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        C1946ke c1946ke = new C1946ke();
        fileOperator.read(0L, c1946ke, 32L);
        C2011ne c2011ne = PREFIX_CLEAN;
        if (c1946ke.mo90e(c2011ne.mo550m()).equals(c2011ne)) {
            long readLong = c1946ke.readLong();
            long readLong2 = c1946ke.readLong();
            C1946ke c1946ke2 = new C1946ke();
            fileOperator.read(readLong + 32, c1946ke2, readLong2);
            return new Relay(randomAccessFile, null, readLong, c1946ke2.m668M(), 0L);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(C2011ne c2011ne, long j, long j2) {
        C1946ke c1946ke = new C1946ke();
        c1946ke.m663R(c2011ne);
        c1946ke.m656Y(j);
        c1946ke.m656Y(j2);
        if (c1946ke.f5398b == 32) {
            new FileOperator(this.file.getChannel()).write(0L, c1946ke, 32L);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) {
        C1946ke c1946ke = new C1946ke();
        c1946ke.m663R(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, c1946ke, this.metadata.mo550m());
    }

    public void commit(long j) {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.mo550m());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public C2011ne metadata() {
        return this.metadata;
    }

    public InterfaceC0073Ce newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
