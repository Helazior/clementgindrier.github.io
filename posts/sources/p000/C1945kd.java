package p000;

import android.view.MenuItem;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import fr.smoney.android.izly.p005ui.privateview.HomeActivity;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* renamed from: kd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1945kd implements BottomNavigationView.OnNavigationItemSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ HomeActivity f5394a;

    /* renamed from: b */
    public final /* synthetic */ BottomNavigationView f5395b;

    public C1945kd(HomeActivity homeActivity, BottomNavigationView bottomNavigationView) {
        this.f5394a = homeActivity;
        this.f5395b = bottomNavigationView;
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
    public final boolean onNavigationItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() != this.f5395b.getSelectedItemId()) {
            HomeActivity homeActivity = this.f5394a;
            int i = HomeActivity.f4714E;
            if (homeActivity.f4200u) {
                C1965ld c1965ld = null;
                switch (menuItem.getItemId()) {
                    case 2131296386:
                        HomeActivity homeActivity2 = this.f5394a;
                        Objects.requireNonNull(homeActivity2);
                        try {
                            c1965ld = (C2182pd) C2182pd.class.newInstance();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e2) {
                            e2.printStackTrace();
                        }
                        ConstraintLayout constraintLayout = ((AbstractC2238sb) homeActivity2.f4202w).f6408b;
                        C0581Yd.m1767d(constraintLayout, "mDataBinding.contentFragment");
                        homeActivity2.f4197r.m116g(constraintLayout.getId(), c1965ld);
                        return true;
                    case 2131296387:
                        this.f5394a.m931R();
                        return true;
                    case 2131296388:
                        HomeActivity.m935N(this.f5394a);
                        return true;
                    case 2131296389:
                        HomeActivity homeActivity3 = this.f5394a;
                        Objects.requireNonNull(homeActivity3);
                        try {
                            c1965ld = (C2219rd) C2219rd.class.newInstance();
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                        } catch (InstantiationException e4) {
                            e4.printStackTrace();
                        }
                        ConstraintLayout constraintLayout2 = ((AbstractC2238sb) homeActivity3.f4202w).f6408b;
                        C0581Yd.m1767d(constraintLayout2, "mDataBinding.contentFragment");
                        homeActivity3.f4197r.m116g(constraintLayout2.getId(), c1965ld);
                        return true;
                    case 2131296390:
                        HomeActivity homeActivity4 = this.f5394a;
                        Objects.requireNonNull(homeActivity4);
                        try {
                            c1965ld = (C1965ld) C1965ld.class.newInstance();
                        } catch (IllegalAccessException e5) {
                            e5.printStackTrace();
                        } catch (InstantiationException e6) {
                            e6.printStackTrace();
                        }
                        ConstraintLayout constraintLayout3 = ((AbstractC2238sb) homeActivity4.f4202w).f6408b;
                        C0581Yd.m1767d(constraintLayout3, "mDataBinding.contentFragment");
                        homeActivity4.f4197r.m116g(constraintLayout3.getId(), c1965ld);
                        return true;
                    default:
                        return false;
                }
            }
            switch (menuItem.getItemId()) {
                case 2131296387:
                    this.f5394a.m931R();
                    return true;
                case 2131296388:
                    HomeActivity.m935N(this.f5394a);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
