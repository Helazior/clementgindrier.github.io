package org.ksoap2.transport;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.kxml2.p009io.KXmlParser;
import org.kxml2.p009io.KXmlSerializer;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class Transport {
    public static final String CONTENT_TYPE_SOAP_XML_CHARSET_UTF_8 = "application/soap+xml;charset=utf-8";
    public static final String CONTENT_TYPE_XML_CHARSET_UTF_8 = "text/xml;charset=utf-8";
    public static final String USER_AGENT = "ksoap2-android/2.6.0+";
    private int bufferLength;
    public boolean debug;
    public Proxy proxy;
    public String requestDump;
    public String responseDump;
    public int timeout;
    public String url;
    private String xmlVersionTag;

    public Transport() {
        this.timeout = 20000;
        this.xmlVersionTag = "";
        this.bufferLength = 262144;
    }

    public abstract List call(String str, SoapEnvelope soapEnvelope, List list);

    public abstract List call(String str, SoapEnvelope soapEnvelope, List list, File file);

    public void call(String str, SoapEnvelope soapEnvelope) {
        call(str, soapEnvelope, null);
    }

    public byte[] createRequestData(SoapEnvelope soapEnvelope, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.bufferLength);
        byteArrayOutputStream.write(this.xmlVersionTag.getBytes());
        XmlSerializer kXmlSerializer = new KXmlSerializer();
        kXmlSerializer.setOutput(byteArrayOutputStream, str);
        soapEnvelope.write(kXmlSerializer);
        kXmlSerializer.flush();
        byteArrayOutputStream.write(13);
        byteArrayOutputStream.write(10);
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public String getHost() {
        return new URL(this.url).getHost();
    }

    public String getPath() {
        return new URL(this.url).getPath();
    }

    public int getPort() {
        return new URL(this.url).getPort();
    }

    public abstract ServiceConnection getServiceConnection();

    public void parseResponse(SoapEnvelope soapEnvelope, InputStream inputStream) {
        KXmlParser kXmlParser = new KXmlParser();
        kXmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
        kXmlParser.setInput(inputStream, null);
        soapEnvelope.parse(kXmlParser);
        inputStream.close();
    }

    public void reset() {
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setXmlVersionTag(String str) {
        this.xmlVersionTag = str;
    }

    public Transport(String str) {
        this((Proxy) null, str);
    }

    public Transport(String str, int i) {
        this.timeout = 20000;
        this.xmlVersionTag = "";
        this.bufferLength = 262144;
        this.url = str;
        this.timeout = i;
    }

    public byte[] createRequestData(SoapEnvelope soapEnvelope) {
        return createRequestData(soapEnvelope, null);
    }

    public Transport(String str, int i, int i2) {
        this.timeout = 20000;
        this.xmlVersionTag = "";
        this.bufferLength = 262144;
        this.url = str;
        this.timeout = i;
        this.bufferLength = i2;
    }

    public Transport(Proxy proxy, String str) {
        this.timeout = 20000;
        this.xmlVersionTag = "";
        this.bufferLength = 262144;
        this.proxy = proxy;
        this.url = str;
    }

    public Transport(Proxy proxy, String str, int i) {
        this.timeout = 20000;
        this.xmlVersionTag = "";
        this.bufferLength = 262144;
        this.proxy = proxy;
        this.url = str;
        this.timeout = i;
    }

    public Transport(Proxy proxy, String str, int i, int i2) {
        this.timeout = 20000;
        this.xmlVersionTag = "";
        this.bufferLength = 262144;
        this.proxy = proxy;
        this.url = str;
        this.timeout = i;
        this.bufferLength = i2;
    }
}
