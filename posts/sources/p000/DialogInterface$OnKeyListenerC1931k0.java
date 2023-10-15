package p000;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import p000.C1850h0;
import p000.InterfaceC2165p0;

/* renamed from: k0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DialogInterface$OnKeyListenerC1931k0 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, InterfaceC2165p0.InterfaceC2166a {

    /* renamed from: a */
    public C1905j0 f5370a;

    /* renamed from: b */
    public DialogInterfaceC2336x f5371b;

    /* renamed from: c */
    public C1850h0 f5372c;

    public DialogInterface$OnKeyListenerC1931k0(C1905j0 c1905j0) {
        this.f5370a = c1905j0;
    }

    @Override // p000.InterfaceC2165p0.InterfaceC2166a
    /* renamed from: a */
    public boolean mo458a(C1905j0 c1905j0) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5370a.performItemAction((C1950l0) ((C1850h0.C1851a) this.f5372c.m790a()).getItem(i), 0);
    }

    @Override // p000.InterfaceC2165p0.InterfaceC2166a
    public void onCloseMenu(C1905j0 c1905j0, boolean z) {
        DialogInterfaceC2336x dialogInterfaceC2336x;
        if ((z || c1905j0 == this.f5370a) && (dialogInterfaceC2336x = this.f5371b) != null) {
            dialogInterfaceC2336x.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        C1850h0 c1850h0 = this.f5372c;
        C1905j0 c1905j0 = this.f5370a;
        InterfaceC2165p0.InterfaceC2166a interfaceC2166a = c1850h0.f5109g;
        if (interfaceC2166a != null) {
            interfaceC2166a.onCloseMenu(c1905j0, true);
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f5371b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f5371b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f5370a.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f5370a.performShortcut(i, keyEvent, 0);
    }
}
