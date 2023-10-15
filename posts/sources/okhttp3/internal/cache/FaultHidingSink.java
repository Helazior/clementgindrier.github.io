package okhttp3.internal.cache;

import java.io.IOException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FaultHidingSink extends AbstractC2030oe {
    private boolean hasErrors;

    public FaultHidingSink(InterfaceC0050Be interfaceC0050Be) {
        super(interfaceC0050Be);
    }

    @Override // p000.AbstractC2030oe, p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // p000.AbstractC2030oe, p000.InterfaceC0050Be, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    public void onException(IOException iOException) {
    }

    @Override // p000.AbstractC2030oe, p000.InterfaceC0050Be
    public void write(C1946ke c1946ke, long j) {
        if (this.hasErrors) {
            c1946ke.skip(j);
            return;
        }
        try {
            super.write(c1946ke, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }
}
