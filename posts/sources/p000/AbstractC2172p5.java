package p000;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import p000.C2192q5;

/* renamed from: p5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2172p5 extends BaseAdapter implements Filterable, C2192q5.InterfaceC2193a {

    /* renamed from: a */
    public boolean f6221a;

    /* renamed from: b */
    public boolean f6222b;

    /* renamed from: c */
    public Cursor f6223c;

    /* renamed from: d */
    public Context f6224d;

    /* renamed from: f */
    public int f6225f;

    /* renamed from: g */
    public C2173a f6226g;

    /* renamed from: h */
    public DataSetObserver f6227h;

    /* renamed from: i */
    public C2192q5 f6228i;

    /* renamed from: p5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2173a extends ContentObserver {
        public C2173a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Cursor cursor;
            AbstractC2172p5 abstractC2172p5 = AbstractC2172p5.this;
            if (!abstractC2172p5.f6222b || (cursor = abstractC2172p5.f6223c) == null || cursor.isClosed()) {
                return;
            }
            abstractC2172p5.f6221a = abstractC2172p5.f6223c.requery();
        }
    }

    /* renamed from: p5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2174b extends DataSetObserver {
        public C2174b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC2172p5 abstractC2172p5 = AbstractC2172p5.this;
            abstractC2172p5.f6221a = true;
            abstractC2172p5.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC2172p5 abstractC2172p5 = AbstractC2172p5.this;
            abstractC2172p5.f6221a = false;
            abstractC2172p5.notifyDataSetInvalidated();
        }
    }

    public AbstractC2172p5(Context context, Cursor cursor, boolean z) {
        int i = z ? 1 : 2;
        if ((i & 1) == 1) {
            i |= 2;
            this.f6222b = true;
        } else {
            this.f6222b = false;
        }
        boolean z2 = cursor != null;
        this.f6223c = cursor;
        this.f6221a = z2;
        this.f6224d = context;
        this.f6225f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f6226g = new C2173a();
            this.f6227h = new C2174b();
        } else {
            this.f6226g = null;
            this.f6227h = null;
        }
        if (z2) {
            C2173a c2173a = this.f6226g;
            if (c2173a != null) {
                cursor.registerContentObserver(c2173a);
            }
            DataSetObserver dataSetObserver = this.f6227h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: a */
    public abstract void mo445a(View view, Context context, Cursor cursor);

    /* renamed from: b */
    public void mo444b(Cursor cursor) {
        Cursor cursor2 = this.f6223c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C2173a c2173a = this.f6226g;
                if (c2173a != null) {
                    cursor2.unregisterContentObserver(c2173a);
                }
                DataSetObserver dataSetObserver = this.f6227h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f6223c = cursor;
            if (cursor != null) {
                C2173a c2173a2 = this.f6226g;
                if (c2173a2 != null) {
                    cursor.registerContentObserver(c2173a2);
                }
                DataSetObserver dataSetObserver2 = this.f6227h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f6225f = cursor.getColumnIndexOrThrow("_id");
                this.f6221a = true;
                notifyDataSetChanged();
            } else {
                this.f6225f = -1;
                this.f6221a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    /* renamed from: c */
    public abstract CharSequence mo443c(Cursor cursor);

    /* renamed from: d */
    public abstract View mo420d(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f6221a || (cursor = this.f6223c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f6221a) {
            this.f6223c.moveToPosition(i);
            if (view == null) {
                AbstractC2211r5 abstractC2211r5 = (AbstractC2211r5) this;
                view = abstractC2211r5.f6344l.inflate(abstractC2211r5.f6343k, viewGroup, false);
            }
            mo445a(view, this.f6224d, this.f6223c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f6228i == null) {
            this.f6228i = new C2192q5(this);
        }
        return this.f6228i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f6221a || (cursor = this.f6223c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f6223c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f6221a && (cursor = this.f6223c) != null && cursor.moveToPosition(i)) {
            return this.f6223c.getLong(this.f6225f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f6221a) {
            if (this.f6223c.moveToPosition(i)) {
                if (view == null) {
                    view = mo420d(this.f6224d, this.f6223c, viewGroup);
                }
                mo445a(view, this.f6224d, this.f6223c);
                return view;
            }
            throw new IllegalStateException(outline.m273H("couldn't move cursor to position ", i));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
