package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class EmailAddressResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String massagedText = ResultParser.getMassagedText(result);
        String str2 = null;
        if (!massagedText.startsWith("mailto:") && !massagedText.startsWith("MAILTO:")) {
            if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
                return new EmailAddressParsedResult(massagedText, null, null, outline.m266e("mailto:", massagedText));
            }
            return null;
        }
        String substring = massagedText.substring(7);
        int indexOf = substring.indexOf(63);
        if (indexOf >= 0) {
            substring = substring.substring(0, indexOf);
        }
        String urlDecode = ResultParser.urlDecode(substring);
        Map<String, String> parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
        if (parseNameValuePairs != null) {
            if (urlDecode.length() == 0) {
                urlDecode = parseNameValuePairs.get("to");
            }
            str2 = parseNameValuePairs.get("subject");
            str = parseNameValuePairs.get("body");
        } else {
            str = null;
        }
        return new EmailAddressParsedResult(urlDecode, str2, str, massagedText);
    }
}
