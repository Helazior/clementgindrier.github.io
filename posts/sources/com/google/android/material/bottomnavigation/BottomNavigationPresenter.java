package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ParcelableSparseArray;
import p000.InterfaceC2165p0;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BottomNavigationPresenter implements InterfaceC2165p0 {

    /* renamed from: id */
    private int f3870id;
    private C1905j0 menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public ParcelableSparseArray badgeSavedStates;
        public int selectedItemId;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }

        public SavedState(Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // p000.InterfaceC2165p0
    public boolean collapseItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public boolean expandItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public boolean flagActionItems() {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public int getId() {
        return this.f3870id;
    }

    public InterfaceC2186q0 getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    @Override // p000.InterfaceC2165p0
    public void initForMenu(Context context, C1905j0 c1905j0) {
        this.menu = c1905j0;
        this.menuView.initialize(c1905j0);
    }

    @Override // p000.InterfaceC2165p0
    public void onCloseMenu(C1905j0 c1905j0, boolean z) {
    }

    @Override // p000.InterfaceC2165p0
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.setBadgeDrawables(BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    @Override // p000.InterfaceC2165p0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    @Override // p000.InterfaceC2165p0
    public boolean onSubMenuSelected(SubMenuC2267u0 subMenuC2267u0) {
        return false;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    @Override // p000.InterfaceC2165p0
    public void setCallback(InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
    }

    public void setId(int i) {
        this.f3870id = i;
    }

    public void setUpdateSuspended(boolean z) {
        this.updateSuspended = z;
    }

    @Override // p000.InterfaceC2165p0
    public void updateMenuView(boolean z) {
        if (this.updateSuspended) {
            return;
        }
        if (z) {
            this.menuView.buildMenuView();
        } else {
            this.menuView.updateMenuView();
        }
    }
}
