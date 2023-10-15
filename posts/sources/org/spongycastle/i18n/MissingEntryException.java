package org.spongycastle.i18n;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MissingEntryException extends RuntimeException {
    private String debugMsg;
    public final String key;
    public final ClassLoader loader;
    public final Locale locale;
    public final String resource;

    public MissingEntryException(String str, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str);
        this.resource = str2;
        this.key = str3;
        this.locale = locale;
        this.loader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getDebugMsg() {
        if (this.debugMsg == null) {
            StringBuilder m253r = outline.m253r("Can not find entry ");
            m253r.append(this.key);
            m253r.append(" in resource file ");
            m253r.append(this.resource);
            m253r.append(" for the locale ");
            m253r.append(this.locale);
            m253r.append(".");
            this.debugMsg = m253r.toString();
            ClassLoader classLoader = this.loader;
            if (classLoader instanceof URLClassLoader) {
                URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
                this.debugMsg = outline.m262i(new StringBuilder(), this.debugMsg, " The following entries in the classpath were searched: ");
                for (int i = 0; i != uRLs.length; i++) {
                    this.debugMsg += uRLs[i] + " ";
                }
            }
        }
        return this.debugMsg;
    }

    public String getKey() {
        return this.key;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getResource() {
        return this.resource;
    }

    public MissingEntryException(String str, Throwable th, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str, th);
        this.resource = str2;
        this.key = str3;
        this.locale = locale;
        this.loader = classLoader;
    }
}
