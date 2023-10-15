package p000;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* renamed from: V0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class View$OnClickListenerC0487V0 extends AbstractC2211r5 implements View.OnClickListener {

    /* renamed from: z */
    public static final /* synthetic */ int f1772z = 0;

    /* renamed from: m */
    public final SearchView f1773m;

    /* renamed from: n */
    public final SearchableInfo f1774n;

    /* renamed from: o */
    public final Context f1775o;

    /* renamed from: p */
    public final WeakHashMap<String, Drawable.ConstantState> f1776p;

    /* renamed from: q */
    public final int f1777q;

    /* renamed from: r */
    public int f1778r;

    /* renamed from: s */
    public ColorStateList f1779s;

    /* renamed from: t */
    public int f1780t;

    /* renamed from: u */
    public int f1781u;

    /* renamed from: v */
    public int f1782v;

    /* renamed from: w */
    public int f1783w;

    /* renamed from: x */
    public int f1784x;

    /* renamed from: y */
    public int f1785y;

    /* renamed from: V0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0488a {

        /* renamed from: a */
        public final TextView f1786a;

        /* renamed from: b */
        public final TextView f1787b;

        /* renamed from: c */
        public final ImageView f1788c;

        /* renamed from: d */
        public final ImageView f1789d;

        /* renamed from: e */
        public final ImageView f1790e;

        public C0488a(View view) {
            this.f1786a = (TextView) view.findViewById(16908308);
            this.f1787b = (TextView) view.findViewById(16908309);
            this.f1788c = (ImageView) view.findViewById(16908295);
            this.f1789d = (ImageView) view.findViewById(16908296);
            this.f1790e = (ImageView) view.findViewById(C1930k.edit_query);
        }
    }

    public View$OnClickListenerC0487V0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.f2610r, null, true);
        this.f1778r = 1;
        this.f1780t = -1;
        this.f1781u = -1;
        this.f1782v = -1;
        this.f1783w = -1;
        this.f1784x = -1;
        this.f1785y = -1;
        this.f1773m = searchView;
        this.f1774n = searchableInfo;
        this.f1777q = searchView.f2611s;
        this.f1775o = context;
        this.f1776p = weakHashMap;
    }

    /* renamed from: h */
    public static String m1972h(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014f  */
    @Override // p000.AbstractC2172p5
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo445a(android.view.View r19, android.content.Context r20, android.database.Cursor r21) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnClickListenerC0487V0.mo445a(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    @Override // p000.AbstractC2172p5
    /* renamed from: b */
    public void mo444b(Cursor cursor) {
        try {
            super.mo444b(cursor);
            if (cursor != null) {
                this.f1780t = cursor.getColumnIndex("suggest_text_1");
                this.f1781u = cursor.getColumnIndex("suggest_text_2");
                this.f1782v = cursor.getColumnIndex("suggest_text_2_url");
                this.f1783w = cursor.getColumnIndex("suggest_icon_1");
                this.f1784x = cursor.getColumnIndex("suggest_icon_2");
                this.f1785y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // p000.AbstractC2172p5
    /* renamed from: c */
    public CharSequence mo443c(Cursor cursor) {
        String m1972h;
        String m1972h2;
        if (cursor == null) {
            return null;
        }
        String m1972h3 = m1972h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (m1972h3 != null) {
            return m1972h3;
        }
        if (!this.f1774n.shouldRewriteQueryFromData() || (m1972h2 = m1972h(cursor, cursor.getColumnIndex("suggest_intent_data"))) == null) {
            if (!this.f1774n.shouldRewriteQueryFromText() || (m1972h = m1972h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
                return null;
            }
            return m1972h;
        }
        return m1972h2;
    }

    @Override // p000.AbstractC2211r5, p000.AbstractC2172p5
    /* renamed from: d */
    public View mo420d(Context context, Cursor cursor, ViewGroup viewGroup) {
        View inflate = this.f6344l.inflate(this.f6342j, viewGroup, false);
        inflate.setTag(new C0488a(inflate));
        ((ImageView) inflate.findViewById(C1930k.edit_query)).setImageResource(this.f1777q);
        return inflate;
    }

    /* renamed from: e */
    public Drawable m1975e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f6224d.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable m1974f(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnClickListenerC0487V0.m1974f(java.lang.String):android.graphics.drawable.Drawable");
    }

    /* renamed from: g */
    public Cursor m1973g(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f6224d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // p000.AbstractC2172p5, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.f6344l.inflate(this.f6343k, viewGroup, false);
            if (inflate != null) {
                ((C0488a) inflate.getTag()).f1786a.setText(e.toString());
            }
            return inflate;
        }
    }

    @Override // p000.AbstractC2172p5, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View mo420d = mo420d(this.f6224d, this.f6223c, viewGroup);
            ((C0488a) mo420d.getTag()).f1786a.setText(e.toString());
            return mo420d;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    /* renamed from: i */
    public final void m1971i(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1971i(this.f6223c);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1971i(this.f6223c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1773m.m1599m((CharSequence) tag);
        }
    }
}
