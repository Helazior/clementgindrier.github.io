package p000;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* renamed from: y1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2362y1<E> extends AbstractC0077D1<E, E> {

    /* renamed from: d */
    public final /* synthetic */ C2396z1 f6851d;

    public C2362y1(C2396z1 c2396z1) {
        this.f6851d = c2396z1;
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: a */
    public void mo77a() {
        this.f6851d.clear();
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: b */
    public Object mo76b(int i, int i2) {
        return this.f6851d.f6910b[i];
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: c */
    public Map<E, E> mo75c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: d */
    public int mo74d() {
        return this.f6851d.f6911c;
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: e */
    public int mo73e(Object obj) {
        return this.f6851d.indexOf(obj);
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: f */
    public int mo72f(Object obj) {
        return this.f6851d.indexOf(obj);
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: g */
    public void mo71g(E e, E e2) {
        this.f6851d.add(e);
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: h */
    public void mo70h(int i) {
        this.f6851d.m8e(i);
    }

    @Override // p000.AbstractC0077D1
    /* renamed from: i */
    public E mo69i(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
