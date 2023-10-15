package com.google.zxing.client.result;

import com.google.zxing.Result;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class URLTOResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        int indexOf;
        String massagedText = ResultParser.getMassagedText(result);
        if ((massagedText.startsWith("urlto:") || massagedText.startsWith("URLTO:")) && (indexOf = massagedText.indexOf(58, 6)) >= 0) {
            return new URIParsedResult(massagedText.substring(indexOf + 1), indexOf > 6 ? massagedText.substring(6, indexOf) : null);
        }
        return null;
    }
}
