package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.widget.ContentLoadingProgressBar;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    public final Runnable f2997a;

    /* renamed from: b */
    public final Runnable f2998b;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f2997a);
        removeCallbacks(this.f2998b);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2997a);
        removeCallbacks(this.f2998b);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2997a = new Runnable() { // from class: g5
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f2998b = new Runnable() { // from class: h5
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
                Objects.requireNonNull(contentLoadingProgressBar);
                System.currentTimeMillis();
                contentLoadingProgressBar.setVisibility(0);
            }
        };
    }
}
