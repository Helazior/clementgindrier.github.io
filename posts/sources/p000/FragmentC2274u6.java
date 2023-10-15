package p000;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import p000.AbstractC1917j6;

/* renamed from: u6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FragmentC2274u6 extends Fragment {
    /* renamed from: b */
    public static void m300b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new FragmentC2274u6(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: a */
    public final void m301a(AbstractC1917j6.EnumC1918a enumC1918a) {
        Activity activity = getActivity();
        if (activity instanceof InterfaceC2022o6) {
            ((InterfaceC2022o6) activity).getLifecycle().m572d(enumC1918a);
        } else if (activity instanceof InterfaceC1979m6) {
            AbstractC1917j6 lifecycle = ((InterfaceC1979m6) activity).getLifecycle();
            if (lifecycle instanceof C2002n6) {
                ((C2002n6) lifecycle).m572d(enumC1918a);
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m301a(AbstractC1917j6.EnumC1918a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m301a(AbstractC1917j6.EnumC1918a.ON_DESTROY);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m301a(AbstractC1917j6.EnumC1918a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m301a(AbstractC1917j6.EnumC1918a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m301a(AbstractC1917j6.EnumC1918a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m301a(AbstractC1917j6.EnumC1918a.ON_STOP);
    }
}
