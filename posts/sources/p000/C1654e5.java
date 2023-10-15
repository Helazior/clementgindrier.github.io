package p000;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
import java.util.Objects;

/* renamed from: e5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1654e5 {

    /* renamed from: a */
    public final Object f4138a;

    /* renamed from: e5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1655a extends AccessibilityNodeProvider {

        /* renamed from: a */
        public final C1654e5 f4139a;

        public C1655a(C1654e5 c1654e5) {
            this.f4139a = c1654e5;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C1617d5 mo398a = this.f4139a.mo398a(i);
            if (mo398a == null) {
                return null;
            }
            return mo398a.f3986a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            Objects.requireNonNull(this.f4139a);
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f4139a.mo396c(i, i2, bundle);
        }
    }

    /* renamed from: e5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1656b extends C1655a {
        public C1656b(C1654e5 c1654e5) {
            super(c1654e5);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            C1617d5 mo397b = this.f4139a.mo397b(i);
            if (mo397b == null) {
                return null;
            }
            return mo397b.f3986a;
        }
    }

    /* renamed from: e5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1657c extends C1656b {
        public C1657c(C1654e5 c1654e5) {
            super(c1654e5);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            Objects.requireNonNull(this.f4139a);
        }
    }

    public C1654e5() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4138a = new C1657c(this);
        } else {
            this.f4138a = new C1656b(this);
        }
    }

    /* renamed from: a */
    public C1617d5 mo398a(int i) {
        return null;
    }

    /* renamed from: b */
    public C1617d5 mo397b(int i) {
        return null;
    }

    /* renamed from: c */
    public boolean mo396c(int i, int i2, Bundle bundle) {
        return false;
    }

    public C1654e5(Object obj) {
        this.f4138a = obj;
    }
}
