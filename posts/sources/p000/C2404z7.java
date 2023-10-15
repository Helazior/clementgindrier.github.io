package p000;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* renamed from: z7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2403z7 implements InterfaceC2351x7 {

    /* renamed from: b */
    public static Class<?> f6917b;

    /* renamed from: c */
    public static boolean f6918c;

    /* renamed from: d */
    public static Method f6919d;

    /* renamed from: f */
    public static boolean f6920f;

    /* renamed from: g */
    public static Method f6921g;

    /* renamed from: h */
    public static boolean f6922h;

    /* renamed from: a */
    public final View f6923a;

    public C2403z7(View view) {
        this.f6923a = view;
    }

    /* renamed from: b */
    public static void m3b() {
        if (f6918c) {
            return;
        }
        try {
            f6917b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e);
        }
        f6918c = true;
    }

    @Override // p000.InterfaceC2351x7
    /* renamed from: a */
    public void mo4a(ViewGroup viewGroup, View view) {
    }

    @Override // p000.InterfaceC2351x7
    public void setVisibility(int i) {
        this.f6923a.setVisibility(i);
    }
}
