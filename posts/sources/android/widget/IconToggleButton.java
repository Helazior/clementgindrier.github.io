package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.joanzapata.android.iconify.Iconify;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IconToggleButton extends ToggleButton {
    public IconToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Iconify.addIcons(this);
            return;
        }
        setTextOn(getTextOn());
        setTextOff(getTextOff());
    }

    @Override // android.widget.ToggleButton
    public void setTextOff(CharSequence charSequence) {
        super.setTextOff(Iconify.compute(charSequence));
    }

    @Override // android.widget.ToggleButton
    public void setTextOn(CharSequence charSequence) {
        super.setTextOn(Iconify.compute(charSequence));
    }

    public IconToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IconToggleButton(Context context) {
        super(context);
        init();
    }
}
