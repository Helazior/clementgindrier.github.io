package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.internal.http2.Settings;
import p000.C2307w3;

/* renamed from: j0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1905j0 implements InterfaceMenuC0534W3 {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private InterfaceC1906a mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private C1950l0 mExpandedItem;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    private boolean mOverrideVisibleItems;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private int mDefaultShowAsAction = 0;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private boolean mOptionalIconsVisible = false;
    private boolean mIsClosing = false;
    private ArrayList<C1950l0> mTempShortcutItemList = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<InterfaceC2165p0>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mGroupDividerEnabled = false;
    private ArrayList<C1950l0> mItems = new ArrayList<>();
    private ArrayList<C1950l0> mVisibleItems = new ArrayList<>();
    private boolean mIsVisibleItemsStale = true;
    private ArrayList<C1950l0> mActionItems = new ArrayList<>();
    private ArrayList<C1950l0> mNonActionItems = new ArrayList<>();
    private boolean mIsActionItemsStale = true;

    /* renamed from: j0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1906a {
        boolean onMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem);

        void onMenuModeChange(C1905j0 c1905j0);
    }

    /* renamed from: j0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1907b {
        /* renamed from: a */
        boolean mo723a(C1950l0 c1950l0);
    }

    public C1905j0(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        setShortcutsVisibleInner(true);
    }

    private C1950l0 createNewMenuItem(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C1950l0(this, i, i2, i3, i4, charSequence, i5);
    }

    private void dispatchPresenterUpdate(boolean z) {
        if (this.mPresenters.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p0 = next.get();
            if (interfaceC2165p0 == null) {
                this.mPresenters.remove(next);
            } else {
                interfaceC2165p0.updateMenuView(z);
            }
        }
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray == null || this.mPresenters.isEmpty()) {
            return;
        }
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p0 = next.get();
            if (interfaceC2165p0 == null) {
                this.mPresenters.remove(next);
            } else {
                int id = interfaceC2165p0.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    interfaceC2165p0.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (this.mPresenters.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p0 = next.get();
            if (interfaceC2165p0 == null) {
                this.mPresenters.remove(next);
            } else {
                int id = interfaceC2165p0.getId();
                if (id > 0 && (onSaveInstanceState = interfaceC2165p0.onSaveInstanceState()) != null) {
                    sparseArray.put(id, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
    }

    private boolean dispatchSubMenuSelected(SubMenuC2267u0 subMenuC2267u0, InterfaceC2165p0 interfaceC2165p0) {
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        boolean onSubMenuSelected = interfaceC2165p0 != null ? interfaceC2165p0.onSubMenuSelected(subMenuC2267u0) : false;
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p02 = next.get();
            if (interfaceC2165p02 == null) {
                this.mPresenters.remove(next);
            } else if (!onSubMenuSelected) {
                onSubMenuSelected = interfaceC2165p02.onSubMenuSelected(subMenuC2267u0);
            }
        }
        return onSubMenuSelected;
    }

    private static int findInsertIndex(ArrayList<C1950l0> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f5414d <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int getOrdering(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i2 < iArr.length) {
                return (i & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int i, boolean z) {
        if (i < 0 || i >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(i);
        if (z) {
            onItemsChanged(true);
        }
    }

    private void setHeaderInternal(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i > 0) {
                this.mHeaderTitle = resources.getText(i);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i2 > 0) {
                Context context = getContext();
                Object obj = C2307w3.f6741a;
                this.mHeaderIcon = C2307w3.C2310c.m202b(context, i2);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    private void setShortcutsVisibleInner(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (z && this.mResources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this.mContext);
            Context context = this.mContext;
            Method method = C0535W4.f1890a;
            if (Build.VERSION.SDK_INT >= 28) {
                z2 = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            } else {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
                z2 = identifier != 0 && resources.getBoolean(identifier);
            }
            if (z2) {
                z3 = true;
            }
        }
        this.mShortcutsVisible = z3;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    public MenuItem addInternal(int i, int i2, int i3, CharSequence charSequence) {
        int ordering = getOrdering(i3);
        C1950l0 createNewMenuItem = createNewMenuItem(i, i2, i3, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.f5410D = contextMenuInfo;
        }
        ArrayList<C1950l0> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    public void addMenuPresenter(InterfaceC2165p0 interfaceC2165p0) {
        addMenuPresenter(interfaceC2165p0, this.mContext);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        InterfaceC1906a interfaceC1906a = this.mCallback;
        if (interfaceC1906a != null) {
            interfaceC1906a.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        C1950l0 c1950l0 = this.mExpandedItem;
        if (c1950l0 != null) {
            collapseItemActionView(c1950l0);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p0 = next.get();
            if (interfaceC2165p0 == null) {
                this.mPresenters.remove(next);
            } else {
                interfaceC2165p0.onCloseMenu(this, z);
            }
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(C1950l0 c1950l0) {
        boolean z = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == c1950l0) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<InterfaceC2165p0> next = it.next();
                InterfaceC2165p0 interfaceC2165p0 = next.get();
                if (interfaceC2165p0 == null) {
                    this.mPresenters.remove(next);
                } else {
                    z = interfaceC2165p0.collapseItemActionView(this, c1950l0);
                    if (z) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z) {
                this.mExpandedItem = null;
            }
        }
        return z;
    }

    public boolean dispatchMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
        InterfaceC1906a interfaceC1906a = this.mCallback;
        return interfaceC1906a != null && interfaceC1906a.onMenuItemSelected(c1905j0, menuItem);
    }

    public boolean expandItemActionView(C1950l0 c1950l0) {
        boolean z = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p0 = next.get();
            if (interfaceC2165p0 == null) {
                this.mPresenters.remove(next);
            } else {
                z = interfaceC2165p0.expandItemActionView(this, c1950l0);
                if (z) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z) {
            this.mExpandedItem = c1950l0;
        }
        return z;
    }

    public int findGroupIndex(int i) {
        return findGroupIndex(i, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C1950l0 c1950l0 = this.mItems.get(i2);
            if (c1950l0.f5411a == i) {
                return c1950l0;
            }
            if (c1950l0.hasSubMenu() && (findItem = c1950l0.f5425o.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mItems.get(i2).f5411a == i) {
                return i2;
            }
        }
        return -1;
    }

    public C1950l0 findItemWithShortcutForKey(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<C1950l0> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i2 = 0; i2 < size; i2++) {
            C1950l0 c1950l0 = arrayList.get(i2);
            if (isQwertyMode) {
                c = c1950l0.f5420j;
            } else {
                c = c1950l0.f5418h;
            }
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c == '\b' && i == 67))) {
                return c1950l0;
            }
        }
        return null;
    }

    public void findItemsWithShortcutForKey(List<C1950l0> list, int i, KeyEvent keyEvent) {
        char c;
        int i2;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.mItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                C1950l0 c1950l0 = this.mItems.get(i3);
                if (c1950l0.hasSubMenu()) {
                    c1950l0.f5425o.findItemsWithShortcutForKey(list, i, keyEvent);
                }
                if (isQwertyMode) {
                    c = c1950l0.f5420j;
                } else {
                    c = c1950l0.f5418h;
                }
                if (isQwertyMode) {
                    i2 = c1950l0.f5421k;
                } else {
                    i2 = c1950l0.f5419i;
                }
                if (((modifiers & 69647) == (i2 & 69647)) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (isQwertyMode && c == '\b' && i == 67)) && c1950l0.isEnabled()) {
                        list.add(c1950l0);
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<C1950l0> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<InterfaceC2165p0> next = it.next();
                InterfaceC2165p0 interfaceC2165p0 = next.get();
                if (interfaceC2165p0 == null) {
                    this.mPresenters.remove(next);
                } else {
                    z |= interfaceC2165p0.flagActionItems();
                }
            }
            if (z) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i = 0; i < size; i++) {
                    C1950l0 c1950l0 = visibleItems.get(i);
                    if (c1950l0.m643g()) {
                        this.mActionItems.add(c1950l0);
                    } else {
                        this.mNonActionItems.add(c1950l0);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<C1950l0> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public C1950l0 getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.mItems.get(i);
    }

    public ArrayList<C1950l0> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public C1905j0 getRootMenu() {
        return this;
    }

    public ArrayList<C1950l0> getVisibleItems() {
        if (this.mIsVisibleItemsStale) {
            this.mVisibleItems.clear();
            int size = this.mItems.size();
            for (int i = 0; i < size; i++) {
                C1950l0 c1950l0 = this.mItems.get(i);
                if (c1950l0.isVisible()) {
                    this.mVisibleItems.add(c1950l0);
                }
            }
            this.mIsVisibleItemsStale = false;
            this.mIsActionItemsStale = true;
            return this.mVisibleItems;
        }
        return this.mVisibleItems;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.mItems.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemActionRequestChanged(C1950l0 c1950l0) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(C1950l0 c1950l0) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            dispatchPresenterUpdate(z);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return performItemAction(findItem(i), i2);
    }

    public boolean performItemAction(MenuItem menuItem, int i) {
        return performItemAction(menuItem, null, i);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C1950l0 findItemWithShortcutForKey = findItemWithShortcutForKey(i, keyEvent);
        boolean performItemAction = findItemWithShortcutForKey != null ? performItemAction(findItemWithShortcutForKey, i2) : false;
        if ((i2 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int findGroupIndex = findGroupIndex(i);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.mItems.get(findGroupIndex).f5412b != i) {
                    break;
                }
                removeItemAtInt(findGroupIndex, false);
                i2 = i3;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        removeItemAtInt(findItemIndex(i), true);
    }

    public void removeItemAt(int i) {
        removeItemAtInt(i, true);
    }

    public void removeMenuPresenter(InterfaceC2165p0 interfaceC2165p0) {
        Iterator<WeakReference<InterfaceC2165p0>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<InterfaceC2165p0> next = it.next();
            InterfaceC2165p0 interfaceC2165p02 = next.get();
            if (interfaceC2165p02 == null || interfaceC2165p02 == interfaceC2165p0) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuC2267u0) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i2 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuC2267u0) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(InterfaceC1906a interfaceC1906a) {
        this.mCallback = interfaceC1906a;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public C1905j0 setDefaultShowAsAction(int i) {
        this.mDefaultShowAsAction = i;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i = 0; i < size; i++) {
            C1950l0 c1950l0 = this.mItems.get(i);
            if (c1950l0.f5412b == groupId && c1950l0.m642h() && c1950l0.isCheckable()) {
                c1950l0.m640j(c1950l0 == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1950l0 c1950l0 = this.mItems.get(i2);
            if (c1950l0.f5412b == i) {
                c1950l0.m639k(z2);
                c1950l0.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mGroupDividerEnabled = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.mItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1950l0 c1950l0 = this.mItems.get(i2);
            if (c1950l0.f5412b == i) {
                c1950l0.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.mItems.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C1950l0 c1950l0 = this.mItems.get(i2);
            if (c1950l0.f5412b == i && c1950l0.m637m(z)) {
                z2 = true;
            }
        }
        if (z2) {
            onItemsChanged(true);
        }
    }

    public C1905j0 setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    public C1905j0 setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    public C1905j0 setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z) {
        this.mOptionalIconsVisible = z;
    }

    public void setOverrideVisibleItems(boolean z) {
        this.mOverrideVisibleItems = z;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mQwertyMode = z;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z) {
        if (this.mShortcutsVisible == z) {
            return;
        }
        setShortcutsVisibleInner(z);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged) {
            return;
        }
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return addInternal(0, 0, 0, this.mResources.getString(i));
    }

    public void addMenuPresenter(InterfaceC2165p0 interfaceC2165p0, Context context) {
        this.mPresenters.add(new WeakReference<>(interfaceC2165p0));
        interfaceC2165p0.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    public int findGroupIndex(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.mItems.get(i2).f5412b == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performItemAction(android.view.MenuItem r7, p000.InterfaceC2165p0 r8, int r9) {
        /*
            r6 = this;
            l0 r7 = (p000.C1950l0) r7
            r0 = 0
            if (r7 == 0) goto La5
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto La5
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f5426p
            r2 = 1
            if (r1 == 0) goto L19
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L19
            goto L21
        L19:
            j0 r1 = r7.f5424n
            boolean r1 = r1.dispatchMenuItemSelected(r1, r7)
            if (r1 == 0) goto L23
        L21:
            r1 = 1
            goto L47
        L23:
            android.content.Intent r1 = r7.f5417g
            if (r1 == 0) goto L3b
            j0 r1 = r7.f5424n     // Catch: android.content.ActivityNotFoundException -> L33
            android.content.Context r1 = r1.getContext()     // Catch: android.content.ActivityNotFoundException -> L33
            android.content.Intent r3 = r7.f5417g     // Catch: android.content.ActivityNotFoundException -> L33
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L33
            goto L21
        L33:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L3b:
            G4 r1 = r7.f5407A
            if (r1 == 0) goto L46
            boolean r1 = r1.mo605e()
            if (r1 == 0) goto L46
            goto L21
        L46:
            r1 = 0
        L47:
            G4 r3 = r7.f5407A
            if (r3 == 0) goto L53
            boolean r4 = r3.mo607a()
            if (r4 == 0) goto L53
            r4 = 1
            goto L54
        L53:
            r4 = 0
        L54:
            boolean r5 = r7.m644f()
            if (r5 == 0) goto L65
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto La4
            r6.close(r2)
            goto La4
        L65:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L76
            if (r4 == 0) goto L6e
            goto L76
        L6e:
            r7 = r9 & 1
            if (r7 != 0) goto La4
            r6.close(r2)
            goto La4
        L76:
            r9 = r9 & 4
            if (r9 != 0) goto L7d
            r6.close(r0)
        L7d:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L93
            u0 r9 = new u0
            android.content.Context r0 = r6.getContext()
            r9.<init>(r0, r6, r7)
            r7.f5425o = r9
            java.lang.CharSequence r0 = r7.f5415e
            r9.setHeaderTitle(r0)
        L93:
            u0 r7 = r7.f5425o
            if (r4 == 0) goto L9a
            r3.mo604f(r7)
        L9a:
            boolean r7 = r6.dispatchSubMenuSelected(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto La4
            r6.close(r2)
        La4:
            return r1
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1905j0.performItemAction(android.view.MenuItem, p0, int):boolean");
    }

    public C1905j0 setHeaderIconInt(int i) {
        setHeaderInternal(0, null, i, null, null);
        return this;
    }

    public C1905j0 setHeaderTitleInt(int i) {
        setHeaderInternal(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return addInternal(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C1950l0 c1950l0 = (C1950l0) addInternal(i, i2, i3, charSequence);
        SubMenuC2267u0 subMenuC2267u0 = new SubMenuC2267u0(this.mContext, this, c1950l0);
        c1950l0.f5425o = subMenuC2267u0;
        subMenuC2267u0.setHeaderTitle(c1950l0.f5415e);
        return subMenuC2267u0;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return addInternal(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }
}
