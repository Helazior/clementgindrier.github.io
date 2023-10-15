package p000;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: I5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0197I5<E> extends AbstractC0132F5 {

    /* renamed from: a */
    public final Activity f638a;

    /* renamed from: b */
    public final Context f639b;

    /* renamed from: c */
    public final Handler f640c;

    /* renamed from: d */
    public final int f641d;

    /* renamed from: f */
    public final LayoutInflater$Factory2C0236K5 f642f;

    public AbstractC0197I5(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.f642f = new LayoutInflater$Factory2C0236K5();
        this.f638a = fragmentActivity;
        LayoutInflater$Factory2C0000A.C0010h.m2637h(fragmentActivity, "context == null");
        this.f639b = fragmentActivity;
        LayoutInflater$Factory2C0000A.C0010h.m2637h(handler, "handler == null");
        this.f640c = handler;
        this.f641d = 0;
    }

    /* renamed from: d */
    public abstract void mo1439d(Fragment fragment);

    /* renamed from: e */
    public abstract void mo1438e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: f */
    public abstract E mo1437f();

    /* renamed from: g */
    public abstract LayoutInflater mo1436g();

    /* renamed from: h */
    public abstract int mo1435h();

    /* renamed from: i */
    public abstract boolean mo1434i();

    /* renamed from: j */
    public abstract void mo1433j(Fragment fragment, String[] strArr, int i);

    /* renamed from: k */
    public abstract boolean mo1432k(Fragment fragment);

    /* renamed from: l */
    public abstract boolean mo1431l(String str);

    /* renamed from: m */
    public abstract void mo1430m(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle);

    /* renamed from: n */
    public abstract void mo1429n(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle);

    /* renamed from: o */
    public abstract void mo1428o();
}
