package p000;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: h3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1854h3 extends C2307w3 {

    /* renamed from: c */
    public static final /* synthetic */ int f5137c = 0;

    /* renamed from: h3$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1855a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String[] f5138a;

        /* renamed from: b */
        public final /* synthetic */ Activity f5139b;

        /* renamed from: c */
        public final /* synthetic */ int f5140c;

        public RunnableC1855a(String[] strArr, Activity activity, int i) {
            this.f5138a = strArr;
            this.f5139b = activity;
            this.f5140c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f5138a.length];
            PackageManager packageManager = this.f5139b.getPackageManager();
            String packageName = this.f5139b.getPackageName();
            int length = this.f5138a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f5138a[i], packageName);
            }
            ((InterfaceC1856b) this.f5139b).onRequestPermissionsResult(this.f5140c, this.f5138a, iArr);
        }
    }

    /* renamed from: h3$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1856b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: h3$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1857c {
        /* renamed from: a */
        void mo782a(int i);
    }

    /* renamed from: d */
    public static void m783d(Activity activity, String[] strArr, int i) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(outline.m262i(outline.m253r("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ((InterfaceC1857c) activity).mo782a(i);
            activity.requestPermissions(strArr, i);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new RunnableC1855a(strArr, activity, i));
    }
}
