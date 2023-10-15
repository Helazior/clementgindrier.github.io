package p000;

/* renamed from: Id */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0208Id {
    /* renamed from: a */
    public static boolean m2384a(String str) {
        boolean z;
        if (str.length() == 10 || str.length() == 11) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                } else if (!Character.isDigit(Character.valueOf(str.charAt(i)).charValue())) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
