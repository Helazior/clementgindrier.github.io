package p000;

import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* renamed from: Sd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0441Sd {
    @NotNull
    /* renamed from: a */
    public static final <T> List<T> m2036a(@NotNull T... tArr) {
        C0581Yd.m1766e(tArr, "elements");
        if (tArr.length > 0) {
            C0581Yd.m1766e(tArr, "$this$asList");
            List<T> asList = Arrays.asList(tArr);
            C0581Yd.m1767d(asList, "ArraysUtilJVM.asList(this)");
            return asList;
        }
        return C0484Ud.f1769a;
    }
}
