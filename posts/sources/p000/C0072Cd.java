package p000;

import java.util.regex.Pattern;

/* renamed from: Cd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0072Cd extends AbstractC0096Dd {

    /* renamed from: b */
    public Pattern f311b;

    /* renamed from: c */
    public boolean f312c;

    public C0072Cd(String str, Pattern pattern, boolean z) {
        super(str);
        if (pattern != null) {
            this.f311b = pattern;
            this.f312c = z;
            return;
        }
        throw new IllegalArgumentException("pattern must not be null");
    }

    @Override // p000.AbstractC0096Dd
    /* renamed from: a */
    public boolean mo2475a(String str) {
        return this.f312c ? !this.f311b.matcher(str).matches() : this.f311b.matcher(str).matches();
    }
}
