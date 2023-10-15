package p000;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: c5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0988c5 extends ClickableSpan {

    /* renamed from: a */
    public final int f3792a;

    /* renamed from: b */
    public final C1617d5 f3793b;

    /* renamed from: c */
    public final int f3794c;

    public C0988c5(int i, C1617d5 c1617d5, int i2) {
        this.f3792a = i;
        this.f3793b = c1617d5;
        this.f3794c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f3792a);
        C1617d5 c1617d5 = this.f3793b;
        c1617d5.f3986a.performAction(this.f3794c, bundle);
    }
}
