package p000;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;

/* renamed from: Gb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0157Gb extends ViewDataBinding {

    /* renamed from: a */
    public final EditText f503a;

    /* renamed from: b */
    public final ConstraintLayout f504b;

    public AbstractC0157Gb(Object obj, View view, int i, ImageView imageView, CustomFontTextView customFontTextView, EditText editText, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.f503a = editText;
        this.f504b = constraintLayout;
    }
}
