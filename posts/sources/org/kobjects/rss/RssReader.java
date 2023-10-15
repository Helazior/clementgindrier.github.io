package org.kobjects.rss;

import java.io.Reader;
import org.kobjects.xml.XmlReader;
import org.spongycastle.i18n.MessageBundle;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RssReader {
    public static final int AUTHOR = 4;
    public static final int DATE = 3;
    public static final int DESCRIPTION = 2;
    public static final int LINK = 1;
    public static final int TITLE = 0;

    /* renamed from: xr */
    public XmlReader f5633xr;

    public RssReader(Reader reader) {
        this.f5633xr = new XmlReader(reader);
    }

    public String[] next() {
        String[] strArr = new String[5];
        while (this.f5633xr.next() != 1) {
            if (this.f5633xr.getType() == 2) {
                String lowerCase = this.f5633xr.getName().toLowerCase();
                if (lowerCase.equals("item") || lowerCase.endsWith(":item")) {
                    while (this.f5633xr.next() != 3) {
                        if (this.f5633xr.getType() == 2) {
                            String lowerCase2 = this.f5633xr.getName().toLowerCase();
                            int indexOf = lowerCase2.indexOf(":");
                            if (indexOf != -1) {
                                lowerCase2 = lowerCase2.substring(indexOf + 1);
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            readText(stringBuffer);
                            String stringBuffer2 = stringBuffer.toString();
                            if (lowerCase2.equals(MessageBundle.TITLE_ENTRY)) {
                                strArr[0] = stringBuffer2;
                            } else if (lowerCase2.equals("link")) {
                                strArr[1] = stringBuffer2;
                            } else if (lowerCase2.equals("description")) {
                                strArr[2] = stringBuffer2;
                            } else if (lowerCase2.equals("date")) {
                                strArr[3] = stringBuffer2;
                            } else if (lowerCase2.equals("author")) {
                                strArr[4] = stringBuffer2;
                            }
                        }
                    }
                    return strArr;
                }
            }
        }
        return null;
    }

    public void readText(StringBuffer stringBuffer) {
        while (this.f5633xr.next() != 3) {
            int type = this.f5633xr.getType();
            if (type == 2) {
                readText(stringBuffer);
            } else if (type == 4) {
                stringBuffer.append(this.f5633xr.getText());
            }
        }
    }
}
