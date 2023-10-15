package p000;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* renamed from: G0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0143G0 {

    /* renamed from: a */
    public TextView f464a;

    /* renamed from: b */
    public TextClassifier f465b;

    public C0143G0(TextView textView) {
        this.f464a = textView;
    }

    /* renamed from: a */
    public TextClassifier m2446a() {
        TextClassifier textClassifier = this.f465b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.f464a.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
