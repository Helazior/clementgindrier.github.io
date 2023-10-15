package p000;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: r5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2211r5 extends AbstractC2172p5 {

    /* renamed from: j */
    public int f6342j;

    /* renamed from: k */
    public int f6343k;

    /* renamed from: l */
    public LayoutInflater f6344l;

    @Deprecated
    public AbstractC2211r5(Context context, int i, Cursor cursor, boolean z) {
        super(context, null, z);
        this.f6343k = i;
        this.f6342j = i;
        this.f6344l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // p000.AbstractC2172p5
    /* renamed from: d */
    public View mo420d(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6344l.inflate(this.f6342j, viewGroup, false);
    }
}
