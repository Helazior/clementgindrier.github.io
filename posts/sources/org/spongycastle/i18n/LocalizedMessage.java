package org.spongycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.spongycastle.i18n.filter.Filter;
import org.spongycastle.i18n.filter.TrustedInput;
import org.spongycastle.i18n.filter.UntrustedInput;
import org.spongycastle.i18n.filter.UntrustedUrlInput;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LocalizedMessage {
    public static final String DEFAULT_ENCODING = "ISO-8859-1";
    public FilteredArguments arguments;
    public String encoding;
    public FilteredArguments extraArgs;
    public Filter filter;

    /* renamed from: id */
    public final String f6075id;
    public ClassLoader loader;
    public final String resource;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class FilteredArguments {
        public static final int FILTER = 1;
        public static final int FILTER_URL = 2;
        public static final int NO_FILTER = 0;
        public int[] argFilterType;
        public Object[] arguments;
        public Filter filter;
        public Object[] filteredArgs;
        public boolean[] isLocaleSpecific;
        public Object[] unpackedArgs;

        public FilteredArguments(LocalizedMessage localizedMessage) {
            this(new Object[0]);
        }

        private Object filter(int i, Object obj) {
            Filter filter = this.filter;
            if (filter != null) {
                if (obj == null) {
                    obj = "null";
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        return filter.doFilterUrl(obj.toString());
                    }
                    return filter.doFilter(obj.toString());
                }
            }
            return obj;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        public Filter getFilter() {
            return this.filter;
        }

        public Object[] getFilteredArgs(Locale locale) {
            Object filter;
            Object[] objArr = new Object[this.unpackedArgs.length];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.unpackedArgs;
                if (i >= objArr2.length) {
                    return objArr;
                }
                Object[] objArr3 = this.filteredArgs;
                if (objArr3[i] != null) {
                    filter = objArr3[i];
                } else {
                    Object obj = objArr2[i];
                    if (this.isLocaleSpecific[i]) {
                        filter = filter(this.argFilterType[i], ((LocaleString) obj).getLocaleString(locale));
                    } else {
                        filter = filter(this.argFilterType[i], obj);
                        this.filteredArgs[i] = filter;
                    }
                }
                objArr[i] = filter;
                i++;
            }
        }

        public boolean isEmpty() {
            return this.unpackedArgs.length == 0;
        }

        public void setFilter(Filter filter) {
            if (filter != this.filter) {
                for (int i = 0; i < this.unpackedArgs.length; i++) {
                    this.filteredArgs[i] = null;
                }
            }
            this.filter = filter;
        }

        public FilteredArguments(Object[] objArr) {
            this.filter = null;
            this.arguments = objArr;
            this.unpackedArgs = new Object[objArr.length];
            this.filteredArgs = new Object[objArr.length];
            this.isLocaleSpecific = new boolean[objArr.length];
            this.argFilterType = new int[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] instanceof TrustedInput) {
                    this.unpackedArgs[i] = ((TrustedInput) objArr[i]).getInput();
                    this.argFilterType[i] = 0;
                } else if (objArr[i] instanceof UntrustedInput) {
                    this.unpackedArgs[i] = ((UntrustedInput) objArr[i]).getInput();
                    if (objArr[i] instanceof UntrustedUrlInput) {
                        this.argFilterType[i] = 2;
                    } else {
                        this.argFilterType[i] = 1;
                    }
                } else {
                    this.unpackedArgs[i] = objArr[i];
                    this.argFilterType[i] = 1;
                }
                this.isLocaleSpecific[i] = this.unpackedArgs[i] instanceof LocaleString;
            }
        }
    }

    public LocalizedMessage(String str, String str2) {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (str != null && str2 != null) {
            this.f6075id = str2;
            this.resource = str;
            this.arguments = new FilteredArguments(this);
            return;
        }
        throw null;
    }

    public String addExtraArgs(String str, Locale locale) {
        if (this.extraArgs != null) {
            StringBuffer stringBuffer = new StringBuffer(str);
            Object[] filteredArgs = this.extraArgs.getFilteredArgs(locale);
            for (Object obj : filteredArgs) {
                stringBuffer.append(obj);
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public String formatWithTimeZone(String str, Object[] objArr, Locale locale, TimeZone timeZone) {
        MessageFormat messageFormat = new MessageFormat(" ");
        messageFormat.setLocale(locale);
        messageFormat.applyPattern(str);
        if (!timeZone.equals(TimeZone.getDefault())) {
            Format[] formats = messageFormat.getFormats();
            for (int i = 0; i < formats.length; i++) {
                if (formats[i] instanceof DateFormat) {
                    DateFormat dateFormat = (DateFormat) formats[i];
                    dateFormat.setTimeZone(timeZone);
                    messageFormat.setFormat(i, dateFormat);
                }
            }
        }
        return messageFormat.format(objArr);
    }

    public Object[] getArguments() {
        return this.arguments.getArguments();
    }

    public ClassLoader getClassLoader() {
        return this.loader;
    }

    public String getEntry(String str, Locale locale, TimeZone timeZone) {
        ResourceBundle bundle;
        String str2 = this.f6075id;
        if (str != null) {
            str2 = outline.m265f(str2, ".", str);
        }
        String str3 = str2;
        try {
            ClassLoader classLoader = this.loader;
            if (classLoader == null) {
                bundle = ResourceBundle.getBundle(this.resource, locale);
            } else {
                bundle = ResourceBundle.getBundle(this.resource, locale, classLoader);
            }
            String string = bundle.getString(str3);
            if (!this.encoding.equals("ISO-8859-1")) {
                string = new String(string.getBytes("ISO-8859-1"), this.encoding);
            }
            if (!this.arguments.isEmpty()) {
                string = formatWithTimeZone(string, this.arguments.getFilteredArgs(locale), locale, timeZone);
            }
            return addExtraArgs(string, locale);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MissingResourceException unused) {
            String m262i = outline.m262i(outline.m251t("Can't find entry ", str3, " in resource file "), this.resource, ".");
            String str4 = this.resource;
            ClassLoader classLoader2 = this.loader;
            if (classLoader2 == null) {
                classLoader2 = getClassLoader();
            }
            throw new MissingEntryException(m262i, str4, str3, locale, classLoader2);
        }
    }

    public Object[] getExtraArgs() {
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments == null) {
            return null;
        }
        return filteredArguments.getArguments();
    }

    public Filter getFilter() {
        return this.filter;
    }

    public String getId() {
        return this.f6075id;
    }

    public String getResource() {
        return this.resource;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.loader = classLoader;
    }

    public void setExtraArgument(Object obj) {
        setExtraArguments(new Object[]{obj});
    }

    public void setExtraArguments(Object[] objArr) {
        if (objArr != null) {
            FilteredArguments filteredArguments = new FilteredArguments(objArr);
            this.extraArgs = filteredArguments;
            filteredArguments.setFilter(this.filter);
            return;
        }
        this.extraArgs = null;
    }

    public void setFilter(Filter filter) {
        this.arguments.setFilter(filter);
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null) {
            filteredArguments.setFilter(filter);
        }
        this.filter = filter;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource: \"");
        stringBuffer.append(this.resource);
        stringBuffer.append("\" Id: \"");
        stringBuffer.append(this.f6075id);
        stringBuffer.append("\"");
        stringBuffer.append(" Arguments: ");
        stringBuffer.append(this.arguments.getArguments().length);
        stringBuffer.append(" normal");
        FilteredArguments filteredArguments = this.extraArgs;
        if (filteredArguments != null && filteredArguments.getArguments().length > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.extraArgs.getArguments().length);
            stringBuffer.append(" extra");
        }
        stringBuffer.append(" Encoding: ");
        stringBuffer.append(this.encoding);
        stringBuffer.append(" ClassLoader: ");
        stringBuffer.append(this.loader);
        return stringBuffer.toString();
    }

    public LocalizedMessage(String str, String str2, String str3) {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (str != null && str2 != null) {
            this.f6075id = str2;
            this.resource = str;
            this.arguments = new FilteredArguments(this);
            if (Charset.isSupported(str3)) {
                this.encoding = str3;
                return;
            }
            throw new UnsupportedEncodingException(outline.m265f("The encoding \"", str3, "\" is not supported."));
        }
        throw null;
    }

    public LocalizedMessage(String str, String str2, Object[] objArr) {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (str != null && str2 != null && objArr != null) {
            this.f6075id = str2;
            this.resource = str;
            this.arguments = new FilteredArguments(objArr);
            return;
        }
        throw null;
    }

    public LocalizedMessage(String str, String str2, String str3, Object[] objArr) {
        this.encoding = "ISO-8859-1";
        this.extraArgs = null;
        this.filter = null;
        this.loader = null;
        if (str != null && str2 != null && objArr != null) {
            this.f6075id = str2;
            this.resource = str;
            this.arguments = new FilteredArguments(objArr);
            if (Charset.isSupported(str3)) {
                this.encoding = str3;
                return;
            }
            throw new UnsupportedEncodingException(outline.m265f("The encoding \"", str3, "\" is not supported."));
        }
        throw null;
    }
}
