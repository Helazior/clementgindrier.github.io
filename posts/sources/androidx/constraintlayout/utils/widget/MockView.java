package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import org.spongycastle.asn1.x509.DisplayText;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MockView extends View {

    /* renamed from: a */
    public Paint f2812a;

    /* renamed from: b */
    public Paint f2813b;

    /* renamed from: c */
    public Paint f2814c;

    /* renamed from: d */
    public boolean f2815d;

    /* renamed from: f */
    public boolean f2816f;

    /* renamed from: g */
    public String f2817g;

    /* renamed from: h */
    public Rect f2818h;

    /* renamed from: i */
    public int f2819i;

    /* renamed from: j */
    public int f2820j;

    /* renamed from: k */
    public int f2821k;

    /* renamed from: l */
    public int f2822l;

    public MockView(Context context) {
        super(context);
        this.f2812a = new Paint();
        this.f2813b = new Paint();
        this.f2814c = new Paint();
        this.f2815d = true;
        this.f2816f = true;
        this.f2817g = null;
        this.f2818h = new Rect();
        this.f2819i = Color.argb(255, 0, 0, 0);
        this.f2820j = Color.argb(255, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE);
        this.f2821k = Color.argb(255, 50, 50, 50);
        this.f2822l = 4;
        m1543a(context, null);
    }

    /* renamed from: a */
    public final void m1543a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.MockView_mock_label) {
                    this.f2817g = obtainStyledAttributes.getString(index);
                } else if (index == C0533W2.MockView_mock_showDiagonals) {
                    this.f2815d = obtainStyledAttributes.getBoolean(index, this.f2815d);
                } else if (index == C0533W2.MockView_mock_diagonalsColor) {
                    this.f2819i = obtainStyledAttributes.getColor(index, this.f2819i);
                } else if (index == C0533W2.MockView_mock_labelBackgroundColor) {
                    this.f2821k = obtainStyledAttributes.getColor(index, this.f2821k);
                } else if (index == C0533W2.MockView_mock_labelColor) {
                    this.f2820j = obtainStyledAttributes.getColor(index, this.f2820j);
                } else if (index == C0533W2.MockView_mock_showLabel) {
                    this.f2816f = obtainStyledAttributes.getBoolean(index, this.f2816f);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f2817g == null) {
            try {
                this.f2817g = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f2812a.setColor(this.f2819i);
        this.f2812a.setAntiAlias(true);
        this.f2813b.setColor(this.f2820j);
        this.f2813b.setAntiAlias(true);
        this.f2814c.setColor(this.f2821k);
        this.f2822l = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * this.f2822l);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2815d) {
            width--;
            height--;
            float f = width;
            float f2 = height;
            canvas.drawLine(0.0f, 0.0f, f, f2, this.f2812a);
            canvas.drawLine(0.0f, f2, f, 0.0f, this.f2812a);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.f2812a);
            canvas.drawLine(f, 0.0f, f, f2, this.f2812a);
            canvas.drawLine(f, f2, 0.0f, f2, this.f2812a);
            canvas.drawLine(0.0f, f2, 0.0f, 0.0f, this.f2812a);
        }
        String str = this.f2817g;
        if (str == null || !this.f2816f) {
            return;
        }
        this.f2813b.getTextBounds(str, 0, str.length(), this.f2818h);
        float width2 = (width - this.f2818h.width()) / 2.0f;
        float height2 = ((height - this.f2818h.height()) / 2.0f) + this.f2818h.height();
        this.f2818h.offset((int) width2, (int) height2);
        Rect rect = this.f2818h;
        int i = rect.left;
        int i2 = this.f2822l;
        rect.set(i - i2, rect.top - i2, rect.right + i2, rect.bottom + i2);
        canvas.drawRect(this.f2818h, this.f2814c);
        canvas.drawText(this.f2817g, width2, height2, this.f2813b);
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2812a = new Paint();
        this.f2813b = new Paint();
        this.f2814c = new Paint();
        this.f2815d = true;
        this.f2816f = true;
        this.f2817g = null;
        this.f2818h = new Rect();
        this.f2819i = Color.argb(255, 0, 0, 0);
        this.f2820j = Color.argb(255, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE);
        this.f2821k = Color.argb(255, 50, 50, 50);
        this.f2822l = 4;
        m1543a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2812a = new Paint();
        this.f2813b = new Paint();
        this.f2814c = new Paint();
        this.f2815d = true;
        this.f2816f = true;
        this.f2817g = null;
        this.f2818h = new Rect();
        this.f2819i = Color.argb(255, 0, 0, 0);
        this.f2820j = Color.argb(255, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE, (int) DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE);
        this.f2821k = Color.argb(255, 50, 50, 50);
        this.f2822l = 4;
        m1543a(context, attributeSet);
    }
}
