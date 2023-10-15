package p000;

import android.content.DialogInterface;
import fr.smoney.android.izly.p005ui.publicview.login.LoginActivity;

/* renamed from: Ad */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DialogInterface$OnCancelListenerC0029Ad implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    public final /* synthetic */ LoginActivity f156a;

    public DialogInterface$OnCancelListenerC0029Ad(LoginActivity loginActivity) {
        this.f156a = loginActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f156a.finish();
    }
}
