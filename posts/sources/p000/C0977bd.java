package p000;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

/* renamed from: bd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0977bd extends AbstractC1668ed {

    /* renamed from: g */
    public static final EnumC1631dd f3743g = EnumC1631dd.ProgressType;

    /* renamed from: d */
    public String f3744d;

    /* renamed from: f */
    public String f3745f;

    @Override // p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f3744d = arguments.getString("Argument.DialogTitle");
        this.f3745f = arguments.getString("Argument.DialogMsg");
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public Dialog onCreateDialog(Bundle bundle) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity(), 2131755269);
        progressDialog.setTitle(this.f3744d);
        progressDialog.setMessage(this.f3745f);
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}
