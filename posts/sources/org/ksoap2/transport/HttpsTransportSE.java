package org.ksoap2.transport;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HttpsTransportSE extends HttpTransportSE {
    public static final String PROTOCOL = "https";
    private static final String PROTOCOL_FULL = "https://";
    public final String file;
    public final String host;
    public final int port;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpsTransportSE(java.lang.String r3, int r4, java.lang.String r5, int r6) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "https://"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = ":"
            r0.append(r1)
            r0.append(r4)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r6)
            r2.host = r3
            r2.port = r4
            r2.file = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ksoap2.transport.HttpsTransportSE.<init>(java.lang.String, int, java.lang.String, int):void");
    }

    @Override // org.ksoap2.transport.HttpTransportSE, org.ksoap2.transport.Transport
    public ServiceConnection getServiceConnection() {
        return new HttpsServiceConnectionSE(this.proxy, this.host, this.port, this.file, this.timeout);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpsTransportSE(java.net.Proxy r3, java.lang.String r4, int r5, java.lang.String r6, int r7) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "https://"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ":"
            r0.append(r1)
            r0.append(r5)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r2.<init>(r3, r0)
            r2.host = r4
            r2.port = r5
            r2.file = r6
            r2.timeout = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ksoap2.transport.HttpsTransportSE.<init>(java.net.Proxy, java.lang.String, int, java.lang.String, int):void");
    }
}
