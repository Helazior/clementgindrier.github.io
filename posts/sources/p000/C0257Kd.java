package p000;

import android.util.Patterns;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Kd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0257Kd {
    @NotNull

    /* renamed from: a */
    public static final C0257Kd f842a = null;

    static {
        Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+\\']{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    }

    /* renamed from: a */
    public static final boolean m2234a(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.toString().length() == 0) {
                return false;
            }
            return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
        }
        return false;
    }
}
