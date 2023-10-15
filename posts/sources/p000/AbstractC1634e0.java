package p000;

import android.content.Context;
import android.view.LayoutInflater;
import p000.InterfaceC2165p0;

/* renamed from: e0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1634e0 implements InterfaceC2165p0 {

    /* renamed from: a */
    public Context f4098a;

    /* renamed from: b */
    public Context f4099b;

    /* renamed from: c */
    public C1905j0 f4100c;

    /* renamed from: d */
    public LayoutInflater f4101d;

    /* renamed from: f */
    public InterfaceC2165p0.InterfaceC2166a f4102f;

    /* renamed from: g */
    public int f4103g;

    /* renamed from: h */
    public int f4104h;

    /* renamed from: i */
    public InterfaceC2186q0 f4105i;

    /* renamed from: j */
    public int f4106j;

    public AbstractC1634e0(Context context, int i, int i2) {
        this.f4098a = context;
        this.f4101d = LayoutInflater.from(context);
        this.f4103g = i;
        this.f4104h = i2;
    }

    @Override // p000.InterfaceC2165p0
    public boolean collapseItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public boolean expandItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public int getId() {
        return this.f4106j;
    }

    @Override // p000.InterfaceC2165p0
    public void setCallback(InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        this.f4102f = interfaceC2166a;
    }
}
