package p000;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: q5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2192q5 extends Filter {

    /* renamed from: a */
    public InterfaceC2193a f6263a;

    /* renamed from: q5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC2193a {
    }

    public C2192q5(InterfaceC2193a interfaceC2193a) {
        this.f6263a = interfaceC2193a;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return ((View$OnClickListenerC0487V0) this.f6263a).mo443c((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r5) {
        /*
            r4 = this;
            q5$a r0 = r4.f6263a
            V0 r0 = (p000.View$OnClickListenerC0487V0) r0
            java.util.Objects.requireNonNull(r0)
            if (r5 != 0) goto Lc
            java.lang.String r5 = ""
            goto L10
        Lc:
            java.lang.String r5 = r5.toString()
        L10:
            androidx.appcompat.widget.SearchView r1 = r0.f1773m
            int r1 = r1.getVisibility()
            r2 = 0
            if (r1 != 0) goto L38
            androidx.appcompat.widget.SearchView r1 = r0.f1773m
            int r1 = r1.getWindowVisibility()
            if (r1 == 0) goto L22
            goto L38
        L22:
            android.app.SearchableInfo r1 = r0.f1774n     // Catch: java.lang.RuntimeException -> L30
            r3 = 50
            android.database.Cursor r5 = r0.m1973g(r1, r5, r3)     // Catch: java.lang.RuntimeException -> L30
            if (r5 == 0) goto L38
            r5.getCount()     // Catch: java.lang.RuntimeException -> L30
            goto L39
        L30:
            r5 = move-exception
            java.lang.String r0 = "SuggestionsAdapter"
            java.lang.String r1 = "Search suggestions query threw an exception."
            android.util.Log.w(r0, r1, r5)
        L38:
            r5 = r2
        L39:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r5 == 0) goto L49
            int r1 = r5.getCount()
            r0.count = r1
            r0.values = r5
            goto L4e
        L49:
            r5 = 0
            r0.count = r5
            r0.values = r2
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2192q5.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        InterfaceC2193a interfaceC2193a = this.f6263a;
        Cursor cursor = ((AbstractC2172p5) interfaceC2193a).f6223c;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((View$OnClickListenerC0487V0) interfaceC2193a).mo444b((Cursor) obj);
    }
}
