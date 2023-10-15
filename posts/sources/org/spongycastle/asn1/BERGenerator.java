package org.spongycastle.asn1;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;
    private int _tagNo;
    private boolean _tagged;

    public BERGenerator(OutputStream outputStream) {
        super(outputStream);
        this._tagged = false;
    }

    private void writeHdr(int i) {
        this._out.write(i);
        this._out.write(128);
    }

    @Override // org.spongycastle.asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this._out;
    }

    public void writeBERBody(InputStream inputStream) {
        while (true) {
            int read = inputStream.read();
            if (read < 0) {
                return;
            }
            this._out.write(read);
        }
    }

    public void writeBEREnd() {
        this._out.write(0);
        this._out.write(0);
        if (this._tagged && this._isExplicit) {
            this._out.write(0);
            this._out.write(0);
        }
    }

    public void writeBERHeader(int i) {
        if (this._tagged) {
            int i2 = this._tagNo | 128;
            if (this._isExplicit) {
                writeHdr(i2 | 32);
                writeHdr(i);
                return;
            } else if ((i & 32) != 0) {
                writeHdr(i2 | 32);
                return;
            } else {
                writeHdr(i2);
                return;
            }
        }
        writeHdr(i);
    }

    public BERGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this._tagged = false;
        this._tagged = true;
        this._isExplicit = z;
        this._tagNo = i;
    }
}
