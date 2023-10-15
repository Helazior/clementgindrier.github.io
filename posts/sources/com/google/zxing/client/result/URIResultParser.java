package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class URIResultParser extends ResultParser {
    private static final String ALPHANUM_PART = "[a-zA-Z0-9\\-]";
    private static final Pattern URL_WITH_PROTOCOL_PATTERN = Pattern.compile("[a-zA-Z0-9]{2,}:");
    private static final Pattern URL_WITHOUT_PROTOCOL_PATTERN = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]{2,}(:\\d{1,5})?(/|\\?|$)");

    public static boolean isBasicallyValidURI(String str) {
        if (str.contains(" ")) {
            return false;
        }
        Matcher matcher = URL_WITH_PROTOCOL_PATTERN.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = URL_WITHOUT_PROTOCOL_PATTERN.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("URL:") && !massagedText.startsWith("URI:")) {
            String trim = massagedText.trim();
            if (isBasicallyValidURI(trim)) {
                return new URIParsedResult(trim, null);
            }
            return null;
        }
        return new URIParsedResult(massagedText.substring(4).trim(), null);
    }
}
