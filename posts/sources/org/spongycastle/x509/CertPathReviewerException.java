package org.spongycastle.x509;

import java.security.cert.CertPath;
import org.spongycastle.i18n.ErrorBundle;
import org.spongycastle.i18n.LocalizedException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath;
    private int index;

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th) {
        super(errorBundle, th);
        this.index = -1;
        this.certPath = null;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }

    public CertPathReviewerException(ErrorBundle errorBundle) {
        super(errorBundle);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th, CertPath certPath, int i) {
        super(errorBundle, th);
        this.index = -1;
        this.certPath = null;
        if (certPath != null && i != -1) {
            if (i >= -1 && i < certPath.getCertificates().size()) {
                this.certPath = certPath;
                this.index = i;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public CertPathReviewerException(ErrorBundle errorBundle, CertPath certPath, int i) {
        super(errorBundle);
        this.index = -1;
        this.certPath = null;
        if (certPath != null && i != -1) {
            if (i >= -1 && i < certPath.getCertificates().size()) {
                this.certPath = certPath;
                this.index = i;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }
}
