package p000;

import android.content.Context;
import java.util.concurrent.Callable;
import p000.C1999n4;

/* renamed from: l4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CallableC1956l4 implements Callable<C1999n4.C2000a> {

    /* renamed from: a */
    public final /* synthetic */ String f5456a;

    /* renamed from: b */
    public final /* synthetic */ Context f5457b;

    /* renamed from: c */
    public final /* synthetic */ C1886i4 f5458c;

    /* renamed from: d */
    public final /* synthetic */ int f5459d;

    public CallableC1956l4(String str, Context context, C1886i4 c1886i4, int i) {
        this.f5456a = str;
        this.f5457b = context;
        this.f5458c = c1886i4;
        this.f5459d = i;
    }

    @Override // java.util.concurrent.Callable
    public C1999n4.C2000a call() {
        return C1999n4.m576a(this.f5456a, this.f5457b, this.f5458c, this.f5459d);
    }
}
