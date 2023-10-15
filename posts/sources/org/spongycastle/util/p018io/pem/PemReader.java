package org.spongycastle.util.p018io.pem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.spongycastle.util.encoders.Base64;

/* renamed from: org.spongycastle.util.io.pem.PemReader */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PemReader extends BufferedReader {
    private static final String BEGIN = "-----BEGIN ";
    private static final String END = "-----END ";

    public PemReader(Reader reader) {
        super(reader);
    }

    private PemObject loadObject(String str) {
        String readLine;
        String m266e = outline.m266e(END, str);
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            } else if (readLine.indexOf(":") >= 0) {
                int indexOf = readLine.indexOf(58);
                arrayList.add(new PemHeader(readLine.substring(0, indexOf), readLine.substring(indexOf + 1).trim()));
            } else if (readLine.indexOf(m266e) != -1) {
                break;
            } else {
                stringBuffer.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new PemObject(str, arrayList, Base64.decode(stringBuffer.toString()));
        }
        throw new IOException(outline.m266e(m266e, " not found"));
    }

    public PemObject readPemObject() {
        String readLine = readLine();
        while (readLine != null && !readLine.startsWith(BEGIN)) {
            readLine = readLine();
        }
        if (readLine != null) {
            String substring = readLine.substring(11);
            int indexOf = substring.indexOf(45);
            String substring2 = substring.substring(0, indexOf);
            if (indexOf > 0) {
                return loadObject(substring2);
            }
            return null;
        }
        return null;
    }
}
