package org.kobjects.xmlrpc;

import java.io.FileReader;
import org.kobjects.xml.XmlReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Driver {
    public static void main(String[] strArr) {
        new XmlRpcParser(new XmlReader(new FileReader(strArr[0]))).parseResponse();
    }
}
