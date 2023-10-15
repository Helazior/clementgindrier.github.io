package p000;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

/* renamed from: ce */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0999ce implements Serializable {

    /* renamed from: a */
    public final Pattern f3822a;

    /* renamed from: ce$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1000a implements Serializable {
        @NotNull

        /* renamed from: a */
        public final String f3823a;

        /* renamed from: b */
        public final int f3824b;

        public C1000a(@NotNull String str, int i) {
            C0581Yd.m1766e(str, "pattern");
            this.f3823a = str;
            this.f3824b = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f3823a, this.f3824b);
            C0581Yd.m1767d(compile, "Pattern.compile(pattern, flags)");
            return new C0999ce(compile);
        }
    }

    public C0999ce(@NotNull Pattern pattern) {
        C0581Yd.m1766e(pattern, "nativePattern");
        this.f3822a = pattern;
    }

    private final Object writeReplace() {
        String pattern = this.f3822a.pattern();
        C0581Yd.m1767d(pattern, "nativePattern.pattern()");
        return new C1000a(pattern, this.f3822a.flags());
    }

    @NotNull
    /* renamed from: a */
    public final String m1120a(@NotNull CharSequence charSequence, @NotNull String str) {
        C0581Yd.m1766e(charSequence, "input");
        C0581Yd.m1766e(str, "replacement");
        String replaceAll = this.f3822a.matcher(charSequence).replaceAll(str);
        C0581Yd.m1767d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public String toString() {
        String pattern = this.f3822a.toString();
        C0581Yd.m1767d(pattern, "nativePattern.toString()");
        return pattern;
    }

    public C0999ce(@NotNull String str) {
        C0581Yd.m1766e(str, "pattern");
        Pattern compile = Pattern.compile(str);
        C0581Yd.m1767d(compile, "Pattern.compile(pattern)");
        C0581Yd.m1766e(compile, "nativePattern");
        this.f3822a = compile;
    }
}
