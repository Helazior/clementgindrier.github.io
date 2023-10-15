package p000;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: ve */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2301ve extends C1900ie {

    /* renamed from: a */
    public final /* synthetic */ Socket f6719a;

    public C2301ve(Socket socket) {
        this.f6719a = socket;
    }

    @Override // p000.C1900ie
    public IOException newTimeoutException(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // p000.C1900ie
    public void timedOut() {
        try {
            this.f6719a.close();
        } catch (AssertionError e) {
            if (C2263te.m338b(e)) {
                Logger logger = C2263te.f6595a;
                Level level = Level.WARNING;
                StringBuilder m253r = outline.m253r("Failed to close timed out socket ");
                m253r.append(this.f6719a);
                logger.log(level, m253r.toString(), (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            Logger logger2 = C2263te.f6595a;
            Level level2 = Level.WARNING;
            StringBuilder m253r2 = outline.m253r("Failed to close timed out socket ");
            m253r2.append(this.f6719a);
            logger2.log(level2, m253r2.toString(), (Throwable) e2);
        }
    }
}
