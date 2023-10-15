package p000;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;

/* renamed from: n5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionMode$CallbackC2001n5 implements ActionMode.Callback {

    /* renamed from: a */
    public final ActionMode.Callback f5532a;

    /* renamed from: b */
    public final TextView f5533b;

    /* renamed from: c */
    public Class<?> f5534c;

    /* renamed from: d */
    public Method f5535d;

    /* renamed from: e */
    public boolean f5536e;

    /* renamed from: f */
    public boolean f5537f = false;

    public ActionMode$CallbackC2001n5(ActionMode.Callback callback, TextView textView) {
        this.f5532a = callback;
        this.f5533b = textView;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f5532a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f5532a.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f5532a.onDestroyActionMode(actionMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009f A[SYNTHETIC] */
    @Override // android.view.ActionMode.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onPrepareActionMode(android.view.ActionMode r13, android.view.Menu r14) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ActionMode$CallbackC2001n5.onPrepareActionMode(android.view.ActionMode, android.view.Menu):boolean");
    }
}
