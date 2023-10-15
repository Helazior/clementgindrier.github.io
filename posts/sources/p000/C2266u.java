package p000;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* renamed from: u */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2266u extends CursorAdapter {

    /* renamed from: a */
    public final int f6600a;

    /* renamed from: b */
    public final int f6601b;

    /* renamed from: c */
    public final /* synthetic */ AlertController.RecycleListView f6602c;

    /* renamed from: d */
    public final /* synthetic */ AlertController f6603d;

    /* renamed from: f */
    public final /* synthetic */ AlertController.C0632b f6604f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2266u(AlertController.C0632b c0632b, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.f6604f = c0632b;
        this.f6602c = recycleListView;
        this.f6603d = alertController;
        Cursor cursor2 = getCursor();
        this.f6600a = cursor2.getColumnIndexOrThrow(c0632b.f2272K);
        this.f6601b = cursor2.getColumnIndexOrThrow(c0632b.f2273L);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f6600a));
        this.f6602c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f6601b) == 1);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6604f.f2276b.inflate(this.f6603d.f2227M, viewGroup, false);
    }
}
