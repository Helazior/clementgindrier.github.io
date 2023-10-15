package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        this.fileChannel = fileChannel;
    }

    public void read(long j, C1946ke c1946ke, long j2) {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.fileChannel.transferTo(j, j2, c1946ke);
            j += transferTo;
            j2 -= transferTo;
        }
    }

    public void write(long j, C1946ke c1946ke, long j2) {
        if (j2 < 0 || j2 > c1946ke.f5398b) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(c1946ke, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }
}
