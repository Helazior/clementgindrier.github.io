package org.kobjects.pim;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Vector;
import org.kobjects.p008io.LookAheadReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PimParser {
    public LookAheadReader reader;
    public Class type;

    public PimParser(Reader reader, Class cls) {
        this.reader = new LookAheadReader(reader);
        this.type = cls;
    }

    public String[] readArrayValue(int i) {
        int i2;
        Vector vector = new Vector();
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        do {
            stringBuffer.append(this.reader.readTo(";\n\r"));
            int read = this.reader.read();
            if (read != 10) {
                if (read != 13) {
                    if (read != 59) {
                        continue;
                    } else {
                        vector.addElement(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        continue;
                    }
                } else if (this.reader.peek(0) == 10) {
                    this.reader.read();
                }
            }
            if (this.reader.peek(0) != 32) {
                z = false;
                continue;
            } else {
                this.reader.read();
                continue;
            }
        } while (z);
        if (stringBuffer.length() != 0) {
            vector.addElement(stringBuffer.toString());
        }
        String[] strArr = new String[i];
        for (i2 = 0; i2 < Math.min(i, vector.size()); i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    public PimItem readItem() {
        Object readArrayValue;
        String readName = readName();
        if (readName == null) {
            return null;
        }
        if (readName.equals("begin")) {
            try {
                PimItem pimItem = (PimItem) this.type.newInstance();
                this.reader.read();
                if (!pimItem.getType().equals(readStringValue().toLowerCase())) {
                    throw new RuntimeException("item types do not match!");
                }
                while (true) {
                    String readName2 = readName();
                    if (readName2.equals("end")) {
                        this.reader.read();
                        PrintStream printStream = System.out;
                        StringBuilder m253r = outline.m253r("end:");
                        m253r.append(readStringValue());
                        printStream.println(m253r.toString());
                        return pimItem;
                    }
                    PimField pimField = new PimField(readName2);
                    readProperties(pimField);
                    if (pimItem.getType(readName2) != 1) {
                        readArrayValue = readStringValue();
                    } else {
                        readArrayValue = readArrayValue(pimItem.getArraySize(readName2));
                    }
                    pimField.setValue(readArrayValue);
                    PrintStream printStream2 = System.out;
                    printStream2.println("value:" + readArrayValue);
                    pimItem.addField(pimField);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        } else {
            throw new RuntimeException("'begin:' expected");
        }
    }

    public String readName() {
        String lowerCase = this.reader.readTo(":;").trim().toLowerCase();
        PrintStream printStream = System.out;
        printStream.println("name:" + lowerCase);
        if (this.reader.peek(0) == -1) {
            return null;
        }
        return lowerCase;
    }

    public void readProperties(PimField pimField) {
        int read = this.reader.read();
        while (read == 32) {
            read = this.reader.read();
        }
        while (read != 58) {
            String lowerCase = this.reader.readTo(":;=").trim().toLowerCase();
            int read2 = this.reader.read();
            if (read2 == 61) {
                pimField.setProperty(lowerCase, this.reader.readTo(":;").trim().toLowerCase());
                read = this.reader.read();
            } else {
                pimField.setAttribute(lowerCase, true);
                read = read2;
            }
        }
    }

    public String readStringValue() {
        String readLine = this.reader.readLine();
        while (this.reader.peek(0) == 32) {
            this.reader.read();
            readLine = readLine + this.reader.readLine();
        }
        return readLine;
    }
}
