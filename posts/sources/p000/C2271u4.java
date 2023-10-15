package p000;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* renamed from: u4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2271u4 implements Spannable {
    @Override // java.lang.CharSequence
    public char charAt(int i) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        throw null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        throw null;
    }

    /* renamed from: u4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2272a {

        /* renamed from: a */
        public final TextPaint f6624a;

        /* renamed from: b */
        public final TextDirectionHeuristic f6625b;

        /* renamed from: c */
        public final int f6626c;

        /* renamed from: d */
        public final int f6627d;

        public C2272a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f6624a = textPaint;
            this.f6625b = textDirectionHeuristic;
            this.f6626c = i;
            this.f6627d = i2;
        }

        /* renamed from: a */
        public boolean m302a(C2272a c2272a) {
            int i = Build.VERSION.SDK_INT;
            if ((i < 23 || (this.f6626c == c2272a.f6626c && this.f6627d == c2272a.f6627d)) && this.f6624a.getTextSize() == c2272a.f6624a.getTextSize() && this.f6624a.getTextScaleX() == c2272a.f6624a.getTextScaleX() && this.f6624a.getTextSkewX() == c2272a.f6624a.getTextSkewX() && this.f6624a.getLetterSpacing() == c2272a.f6624a.getLetterSpacing() && TextUtils.equals(this.f6624a.getFontFeatureSettings(), c2272a.f6624a.getFontFeatureSettings()) && this.f6624a.getFlags() == c2272a.f6624a.getFlags()) {
                if (i >= 24) {
                    if (!this.f6624a.getTextLocales().equals(c2272a.f6624a.getTextLocales())) {
                        return false;
                    }
                } else if (!this.f6624a.getTextLocale().equals(c2272a.f6624a.getTextLocale())) {
                    return false;
                }
                return this.f6624a.getTypeface() == null ? c2272a.f6624a.getTypeface() == null : this.f6624a.getTypeface().equals(c2272a.f6624a.getTypeface());
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C2272a) {
                C2272a c2272a = (C2272a) obj;
                return m302a(c2272a) && this.f6625b == c2272a.f6625b;
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Objects.hash(Float.valueOf(this.f6624a.getTextSize()), Float.valueOf(this.f6624a.getTextScaleX()), Float.valueOf(this.f6624a.getTextSkewX()), Float.valueOf(this.f6624a.getLetterSpacing()), Integer.valueOf(this.f6624a.getFlags()), this.f6624a.getTextLocales(), this.f6624a.getTypeface(), Boolean.valueOf(this.f6624a.isElegantTextHeight()), this.f6625b, Integer.valueOf(this.f6626c), Integer.valueOf(this.f6627d));
            }
            return Objects.hash(Float.valueOf(this.f6624a.getTextSize()), Float.valueOf(this.f6624a.getTextScaleX()), Float.valueOf(this.f6624a.getTextSkewX()), Float.valueOf(this.f6624a.getLetterSpacing()), Integer.valueOf(this.f6624a.getFlags()), this.f6624a.getTextLocale(), this.f6624a.getTypeface(), Boolean.valueOf(this.f6624a.isElegantTextHeight()), this.f6625b, Integer.valueOf(this.f6626c), Integer.valueOf(this.f6627d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder m253r = outline.m253r("textSize=");
            m253r.append(this.f6624a.getTextSize());
            sb.append(m253r.toString());
            sb.append(", textScaleX=" + this.f6624a.getTextScaleX());
            sb.append(", textSkewX=" + this.f6624a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            StringBuilder m253r2 = outline.m253r(", letterSpacing=");
            m253r2.append(this.f6624a.getLetterSpacing());
            sb.append(m253r2.toString());
            sb.append(", elegantTextHeight=" + this.f6624a.isElegantTextHeight());
            if (i >= 24) {
                StringBuilder m253r3 = outline.m253r(", textLocale=");
                m253r3.append(this.f6624a.getTextLocales());
                sb.append(m253r3.toString());
            } else {
                StringBuilder m253r4 = outline.m253r(", textLocale=");
                m253r4.append(this.f6624a.getTextLocale());
                sb.append(m253r4.toString());
            }
            StringBuilder m253r5 = outline.m253r(", typeface=");
            m253r5.append(this.f6624a.getTypeface());
            sb.append(m253r5.toString());
            if (i >= 26) {
                StringBuilder m253r6 = outline.m253r(", variationSettings=");
                m253r6.append(this.f6624a.getFontVariationSettings());
                sb.append(m253r6.toString());
            }
            StringBuilder m253r7 = outline.m253r(", textDir=");
            m253r7.append(this.f6625b);
            sb.append(m253r7.toString());
            sb.append(", breakStrategy=" + this.f6626c);
            sb.append(", hyphenationFrequency=" + this.f6627d);
            sb.append("}");
            return sb.toString();
        }

        public C2272a(PrecomputedText.Params params) {
            this.f6624a = params.getTextPaint();
            this.f6625b = params.getTextDirection();
            this.f6626c = params.getBreakStrategy();
            this.f6627d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }
    }
}
