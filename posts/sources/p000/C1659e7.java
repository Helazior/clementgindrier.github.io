package p000;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: e7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1659e7 extends C0130F4 {
    private final C1660a mItemDelegate;
    public final RecyclerView mRecyclerView;

    /* renamed from: e7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1660a extends C0130F4 {

        /* renamed from: a */
        public final C1659e7 f4141a;

        /* renamed from: b */
        public Map<View, C0130F4> f4142b = new WeakHashMap();

        public C1660a(C1659e7 c1659e7) {
            this.f4141a = c1659e7;
        }

        @Override // p000.C0130F4
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0130F4 c0130f4 = this.f4142b.get(view);
            if (c0130f4 != null) {
                return c0130f4.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // p000.C0130F4
        public C1654e5 getAccessibilityNodeProvider(View view) {
            C0130F4 c0130f4 = this.f4142b.get(view);
            if (c0130f4 != null) {
                return c0130f4.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0130F4 c0130f4 = this.f4142b.get(view);
            if (c0130f4 != null) {
                c0130f4.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // p000.C0130F4
        public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
            if (!this.f4141a.shouldIgnore() && this.f4141a.mRecyclerView.getLayoutManager() != null) {
                this.f4141a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c1617d5);
                C0130F4 c0130f4 = this.f4142b.get(view);
                if (c0130f4 != null) {
                    c0130f4.onInitializeAccessibilityNodeInfo(view, c1617d5);
                    return;
                } else {
                    super.onInitializeAccessibilityNodeInfo(view, c1617d5);
                    return;
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, c1617d5);
        }

        @Override // p000.C0130F4
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0130F4 c0130f4 = this.f4142b.get(view);
            if (c0130f4 != null) {
                c0130f4.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // p000.C0130F4
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0130F4 c0130f4 = this.f4142b.get(viewGroup);
            if (c0130f4 != null) {
                return c0130f4.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // p000.C0130F4
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (!this.f4141a.shouldIgnore() && this.f4141a.mRecyclerView.getLayoutManager() != null) {
                C0130F4 c0130f4 = this.f4142b.get(view);
                if (c0130f4 != null) {
                    if (c0130f4.performAccessibilityAction(view, i, bundle)) {
                        return true;
                    }
                } else if (super.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
                return this.f4141a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
            }
            return super.performAccessibilityAction(view, i, bundle);
        }

        @Override // p000.C0130F4
        public void sendAccessibilityEvent(View view, int i) {
            C0130F4 c0130f4 = this.f4142b.get(view);
            if (c0130f4 != null) {
                c0130f4.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        @Override // p000.C0130F4
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            C0130F4 c0130f4 = this.f4142b.get(view);
            if (c0130f4 != null) {
                c0130f4.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public C1659e7(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        C0130F4 itemDelegate = getItemDelegate();
        if (itemDelegate != null && (itemDelegate instanceof C1660a)) {
            this.mItemDelegate = (C1660a) itemDelegate;
        } else {
            this.mItemDelegate = new C1660a(this);
        }
    }

    public C0130F4 getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // p000.C0130F4
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // p000.C0130F4
    public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
        super.onInitializeAccessibilityNodeInfo(view, c1617d5);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(c1617d5);
    }

    @Override // p000.C0130F4
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
