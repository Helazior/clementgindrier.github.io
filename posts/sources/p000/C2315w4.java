package p000;

/* renamed from: w4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2314w4 {

    /* renamed from: a */
    public static final InterfaceC2290v4 f6744a = new C2318d(null, false);

    /* renamed from: b */
    public static final InterfaceC2290v4 f6745b = new C2318d(null, true);

    /* renamed from: c */
    public static final InterfaceC2290v4 f6746c;

    /* renamed from: d */
    public static final InterfaceC2290v4 f6747d;

    /* renamed from: w4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2315a implements InterfaceC2316b {

        /* renamed from: a */
        public static final C2315a f6748a = new C2315a();

        @Override // p000.C2314w4.InterfaceC2316b
        /* renamed from: a */
        public int mo194a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i));
                InterfaceC2290v4 interfaceC2290v4 = C2314w4.f6744a;
                if (directionality != 0) {
                    if (directionality != 1 && directionality != 2) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i4 = 2;
                                break;
                        }
                        i++;
                    }
                    i4 = 0;
                    i++;
                }
                i4 = 1;
                i++;
            }
            return i4;
        }
    }

    /* renamed from: w4$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC2316b {
        /* renamed from: a */
        int mo194a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: w4$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC2317c implements InterfaceC2290v4 {

        /* renamed from: a */
        public final InterfaceC2316b f6749a;

        public AbstractC2317c(InterfaceC2316b interfaceC2316b) {
            this.f6749a = interfaceC2316b;
        }

        /* renamed from: a */
        public abstract boolean mo192a();

        /* renamed from: b */
        public boolean m193b(CharSequence charSequence, int i, int i2) {
            if (i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                InterfaceC2316b interfaceC2316b = this.f6749a;
                if (interfaceC2316b == null) {
                    return mo192a();
                }
                int mo194a = interfaceC2316b.mo194a(charSequence, i, i2);
                if (mo194a != 0) {
                    if (mo194a != 1) {
                        return mo192a();
                    }
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: w4$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2318d extends AbstractC2317c {

        /* renamed from: b */
        public final boolean f6750b;

        public C2318d(InterfaceC2316b interfaceC2316b, boolean z) {
            super(interfaceC2316b);
            this.f6750b = z;
        }

        @Override // p000.C2314w4.AbstractC2317c
        /* renamed from: a */
        public boolean mo192a() {
            return this.f6750b;
        }
    }

    static {
        C2315a c2315a = C2315a.f6748a;
        f6746c = new C2318d(c2315a, false);
        f6747d = new C2318d(c2315a, true);
    }
}
