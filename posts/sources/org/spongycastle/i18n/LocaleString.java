package org.spongycastle.i18n;

import java.util.Locale;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LocaleString extends LocalizedMessage {
    public LocaleString(String str, String str2) {
        super(str, str2);
    }

    public String getLocaleString(Locale locale) {
        return getEntry(null, locale, null);
    }

    public LocaleString(String str, String str2, String str3) {
        super(str, str2, str3);
    }
}
