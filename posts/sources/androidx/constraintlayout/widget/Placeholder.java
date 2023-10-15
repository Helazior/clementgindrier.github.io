package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import p000.C2248t2;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Placeholder extends View {

    /* renamed from: a */
    public int f2927a;

    /* renamed from: b */
    public View f2928b;

    /* renamed from: c */
    public int f2929c;

    public Placeholder(Context context) {
        super(context);
        this.f2927a = -1;
        this.f2928b = null;
        this.f2929c = 4;
        m1521a(null);
    }

    /* renamed from: a */
    public final void m1521a(AttributeSet attributeSet) {
        super.setVisibility(this.f2929c);
        this.f2927a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ConstraintLayout_placeholder_content) {
                    this.f2927a = obtainStyledAttributes.getResourceId(index, this.f2927a);
                } else if (index == C0533W2.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f2929c = obtainStyledAttributes.getInt(index, this.f2929c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public void m1520b() {
        if (this.f2928b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2928b.getLayoutParams();
        layoutParams2.f2889l0.f6503k0 = 0;
        C2248t2.EnumC2249a m359r = layoutParams.f2889l0.m359r();
        C2248t2.EnumC2249a enumC2249a = C2248t2.EnumC2249a.FIXED;
        if (m359r != enumC2249a) {
            layoutParams.f2889l0.m370S(layoutParams2.f2889l0.m354w());
        }
        if (layoutParams.f2889l0.m355v() != enumC2249a) {
            layoutParams.f2889l0.m375N(layoutParams2.f2889l0.m360q());
        }
        layoutParams2.f2889l0.f6503k0 = 8;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f2927a == i) {
            return;
        }
        View view = this.f2928b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f2928b.getLayoutParams()).f2867a0 = false;
            this.f2928b = null;
        }
        this.f2927a = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.f2929c = i;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2927a = -1;
        this.f2928b = null;
        this.f2929c = 4;
        m1521a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2927a = -1;
        this.f2928b = null;
        this.f2929c = 4;
        m1521a(attributeSet);
    }
}
