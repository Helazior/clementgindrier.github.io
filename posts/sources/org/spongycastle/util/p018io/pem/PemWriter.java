package org.spongycastle.util.p018io.pem;

import java.io.BufferedWriter;
import java.io.Writer;
import org.spongycastle.util.encoders.Base64;

/* renamed from: org.spongycastle.util.io.pem.PemWriter */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PemWriter extends BufferedWriter {
    private static final int LINE_LENGTH = 64;
    private char[] buf;
    private final int nlLength;

    public PemWriter(Writer writer) {
        super(writer);
        this.buf = new char[64];
        String property = System.getProperty("line.separator");
        if (property != null) {
            this.nlLength = property.length();
        } else {
            this.nlLength = 2;
        }
    }

    private void writeEncoded(byte[] bArr) {
        char[] cArr;
        int i;
        byte[] encode = Base64.encode(bArr);
        int i2 = 0;
        while (i2 < encode.length) {
            int i3 = 0;
            while (true) {
                cArr = this.buf;
                if (i3 != cArr.length && (i = i2 + i3) < encode.length) {
                    cArr[i3] = (char) encode[i];
                    i3++;
                }
            }
            write(cArr, 0, i3);
            newLine();
            i2 += this.buf.length;
        }
    }

    private void writePostEncapsulationBoundary(String str) {
        write("-----END " + str + "-----");
        newLine();
    }

    private void writePreEncapsulationBoundary(String str) {
        write("-----BEGIN " + str + "-----");
        newLine();
    }

    public int getOutputSize(PemObject pemObject) {
        int length = ((pemObject.getType().length() + 10 + this.nlLength) * 2) + 6 + 4;
        if (!pemObject.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : pemObject.getHeaders()) {
                length += pemHeader.getValue().length() + pemHeader.getName().length() + 2 + this.nlLength;
            }
            length += this.nlLength;
        }
        int length2 = ((pemObject.getContent().length + 2) / 3) * 4;
        return ((((length2 + 64) - 1) / 64) * this.nlLength) + length2 + length;
    }

    public void writeObject(PemObjectGenerator pemObjectGenerator) {
        PemObject generate = pemObjectGenerator.generate();
        writePreEncapsulationBoundary(generate.getType());
        if (!generate.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : generate.getHeaders()) {
                write(pemHeader.getName());
                write(": ");
                write(pemHeader.getValue());
                newLine();
            }
            newLine();
        }
        writeEncoded(generate.getContent());
        writePostEncapsulationBoundary(generate.getType());
    }
}
