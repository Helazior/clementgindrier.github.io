package fr.smoney.android.izly.p005ui.privateview.plus.about.supportinformation;

import android.os.Build;
import android.os.Bundle;
import android.text.format.Time;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.SmoneyABSActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.about.supportinformation.SupportInformationActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class SupportInformationActivity extends SmoneyABSActivity<AbstractC0066C9> {
    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492900;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689502), "getString(R.string.about…_information_label_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230988, null, EnumC1687fd.LONG_APPBAR_NO_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, true);
        RecyclerView recyclerView = ((AbstractC0066C9) this.f4202w).f296a;
        C0581Yd.m1767d(recyclerView, "this");
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView, recyclerView.getContext()) { // from class: fr.smoney.android.izly.ui.privateview.plus.about.supportinformation.SupportInformationActivity$populateReciclerView$1$mLayoutManager$1
            {
                super(r2);
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
            public boolean canScrollVertically() {
                return false;
            }
        });
        ArrayList arrayList = new ArrayList();
        EnumC2262td[] values = EnumC2262td.values();
        for (int i = 0; i < 5; i++) {
            String name = values[i].name();
            EnumC2262td enumC2262td = EnumC2262td.DATE;
            if (C0581Yd.m1770a(name, enumC2262td.name())) {
                String string = getString(enumC2262td.m340a());
                Calendar calendar = Calendar.getInstance();
                C0581Yd.m1767d(calendar, "Calendar.getInstance()");
                long timeInMillis = calendar.getTimeInMillis();
                Time time = C0278Ld.f920a;
                Date date = new Date();
                date.setTime(timeInMillis);
                arrayList.add(new C0383Qd(string, new SimpleDateFormat(getString(2131689751)).format(date)));
            } else {
                EnumC2262td enumC2262td2 = EnumC2262td.EMAIL;
                if (C0581Yd.m1770a(name, enumC2262td2.name())) {
                    arrayList.add(new C0383Qd(getString(enumC2262td2.m340a()), this.f4197r.f6816a.f1712b.f4379s));
                } else {
                    EnumC2262td enumC2262td3 = EnumC2262td.APPVERSION;
                    if (C0581Yd.m1770a(name, enumC2262td3.name())) {
                        arrayList.add(new C0383Qd(getString(enumC2262td3.m340a()), "4.3_(2032102003)"));
                    } else {
                        EnumC2262td enumC2262td4 = EnumC2262td.DEVICE;
                        if (C0581Yd.m1770a(name, enumC2262td4.name())) {
                            String string2 = getString(enumC2262td4.m340a());
                            arrayList.add(new C0383Qd(string2, Build.MANUFACTURER + " " + Build.MODEL));
                        } else {
                            EnumC2262td enumC2262td5 = EnumC2262td.OS;
                            if (C0581Yd.m1770a(name, enumC2262td5.name())) {
                                String string3 = getString(enumC2262td5.m340a());
                                StringBuilder m253r = outline.m253r("Android SDK: ");
                                m253r.append(Build.VERSION.RELEASE);
                                m253r.append(" (");
                                arrayList.add(new C0383Qd(string3, outline.m263h(m253r, Build.VERSION.SDK_INT, ")")));
                            }
                        }
                    }
                }
            }
        }
        C2240sd c2240sd = new C2240sd(arrayList);
        RecyclerView recyclerView2 = ((AbstractC0066C9) this.f4202w).f296a;
        C0581Yd.m1767d(recyclerView2, "mDataBinding.rvInfosSupport");
        recyclerView2.setAdapter(c2240sd);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }
}
