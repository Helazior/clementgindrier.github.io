package p000;

import android.content.Context;
import android.os.Parcelable;

/* renamed from: p0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface InterfaceC2165p0 {

    /* renamed from: p0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC2166a {
        /* renamed from: a */
        boolean mo458a(C1905j0 c1905j0);

        void onCloseMenu(C1905j0 c1905j0, boolean z);
    }

    boolean collapseItemActionView(C1905j0 c1905j0, C1950l0 c1950l0);

    boolean expandItemActionView(C1905j0 c1905j0, C1950l0 c1950l0);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, C1905j0 c1905j0);

    void onCloseMenu(C1905j0 c1905j0, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(SubMenuC2267u0 subMenuC2267u0);

    void setCallback(InterfaceC2166a interfaceC2166a);

    void updateMenuView(boolean z);
}
