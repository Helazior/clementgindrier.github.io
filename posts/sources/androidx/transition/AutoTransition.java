package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        m1277f();
    }

    /* renamed from: f */
    public final void m1277f() {
        m1263e(1);
        m1267a(new Fade(2));
        m1267a(new ChangeBounds());
        m1267a(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1277f();
    }
}
