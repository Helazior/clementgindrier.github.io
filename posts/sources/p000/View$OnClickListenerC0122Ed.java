package p000;

import android.view.View;
import android.widget.ToggleButton;
import fr.smoney.android.izly.p005ui.widget.CustomAmountToogleButtonView;

/* renamed from: Ed */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class View$OnClickListenerC0122Ed implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ View f425a;

    /* renamed from: b */
    public final /* synthetic */ Object f426b;

    /* renamed from: c */
    public final /* synthetic */ CustomAmountToogleButtonView f427c;

    public View$OnClickListenerC0122Ed(CustomAmountToogleButtonView customAmountToogleButtonView, View view, Object obj) {
        this.f427c = customAmountToogleButtonView;
        this.f425a = view;
        this.f426b = obj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((ToggleButton) this.f425a.findViewById(2131296783)).isChecked()) {
            this.f427c.f4964m[0] = this.f425a.getId();
            this.f427c.m829d(((Integer) this.f426b).intValue(), false);
            return;
        }
        this.f427c.m829d(0, true);
    }
}
