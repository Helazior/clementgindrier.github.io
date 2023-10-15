package p000;

import android.app.Dialog;
import android.os.Bundle;

/* renamed from: G */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0142G extends DialogInterface$OnCancelListenerC0110E5 {
    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public Dialog onCreateDialog(Bundle bundle) {
        throw null;
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof DialogC0124F) {
            DialogC0124F dialogC0124F = (DialogC0124F) dialog;
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                dialog.getWindow().addFlags(24);
            }
            dialogC0124F.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
