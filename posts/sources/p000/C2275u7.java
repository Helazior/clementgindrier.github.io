package p000;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* renamed from: u7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2275u7 extends AbstractC0575Y7 {
    @Override // p000.AbstractC0250K7
    /* renamed from: a */
    public long mo299a(ViewGroup viewGroup, Transition transition, C0290M7 c0290m7, C0290M7 c0290m72) {
        int i;
        int round;
        int i2;
        if (c0290m7 == null && c0290m72 == null) {
            return 0L;
        }
        if (c0290m72 == null || m1773c(c0290m7) == 0) {
            i = -1;
        } else {
            c0290m7 = c0290m72;
            i = 1;
        }
        int m1774b = AbstractC0575Y7.m1774b(c0290m7, 0);
        int m1774b2 = AbstractC0575Y7.m1774b(c0290m7, 1);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i2 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round2 = Math.round(viewGroup.getTranslationX() + (viewGroup.getWidth() / 2) + iArr[0]);
            int i3 = iArr[1];
            round = Math.round(viewGroup.getTranslationY() + (viewGroup.getHeight() / 2) + i3);
            i2 = round2;
        }
        float f = i2 - m1774b;
        float f2 = round - m1774b2;
        float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
        float width = viewGroup.getWidth() - 0.0f;
        float height = viewGroup.getHeight() - 0.0f;
        float sqrt2 = sqrt / ((float) Math.sqrt((height * height) + (width * width)));
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i)) / 3.0f) * sqrt2);
    }
}
