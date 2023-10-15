package p000;

import android.content.Context;
import java.util.concurrent.Callable;
import p000.C1999n4;

/* renamed from: j4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CallableC1915j4 implements Callable<C1999n4.C2000a> {

    /* renamed from: a */
    public final /* synthetic */ String f5335a;

    /* renamed from: b */
    public final /* synthetic */ Context f5336b;

    /* renamed from: c */
    public final /* synthetic */ C1886i4 f5337c;

    /* renamed from: d */
    public final /* synthetic */ int f5338d;

    public CallableC1915j4(String str, Context context, C1886i4 c1886i4, int i) {
        this.f5335a = str;
        this.f5336b = context;
        this.f5337c = c1886i4;
        this.f5338d = i;
    }

    @Override // java.util.concurrent.Callable
    public C1999n4.C2000a call() {
        return C1999n4.m576a(this.f5335a, this.f5336b, this.f5337c, this.f5338d);
    }
}
