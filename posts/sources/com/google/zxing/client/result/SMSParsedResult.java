package com.google.zxing.client.result;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class SMSParsedResult extends ParsedResult {
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb);
        ParsedResult.maybeAppend(this.subject, sb);
        ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String getSMSURI() {
        StringBuilder m253r = outline.m253r("sms:");
        boolean z = true;
        for (int i = 0; i < this.numbers.length; i++) {
            if (z) {
                z = false;
            } else {
                m253r.append(',');
            }
            m253r.append(this.numbers[i]);
            String[] strArr = this.vias;
            if (strArr != null && strArr[i] != null) {
                m253r.append(";via=");
                m253r.append(this.vias[i]);
            }
        }
        boolean z2 = this.body != null;
        boolean z3 = this.subject != null;
        if (z2 || z3) {
            m253r.append('?');
            if (z2) {
                m253r.append("body=");
                m253r.append(this.body);
            }
            if (z3) {
                if (z2) {
                    m253r.append('&');
                }
                m253r.append("subject=");
                m253r.append(this.subject);
            }
        }
        return m253r.toString();
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getVias() {
        return this.vias;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
