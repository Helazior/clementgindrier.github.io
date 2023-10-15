package com.google.zxing.client.result;

import com.google.zxing.Result;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class TelResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String str;
        String massagedText = ResultParser.getMassagedText(result);
        if (massagedText.startsWith("tel:") || massagedText.startsWith("TEL:")) {
            if (massagedText.startsWith("TEL:")) {
                StringBuilder m253r = outline.m253r("tel:");
                m253r.append(massagedText.substring(4));
                str = m253r.toString();
            } else {
                str = massagedText;
            }
            int indexOf = massagedText.indexOf(63, 4);
            return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
        }
        return null;
    }
}
