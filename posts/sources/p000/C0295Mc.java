package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Mc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0295Mc extends ArrayAdapter<EnumC0539W8> {

    /* renamed from: a */
    public LayoutInflater f997a;

    /* renamed from: b */
    public Context f998b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0295Mc(@NotNull Context context) {
        super(context, 2131492932);
        C0581Yd.m1766e(context, "context");
        this.f998b = context;
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.f997a = (LayoutInflater) systemService;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @Nullable
    public View getDropDownView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.f997a;
        C0581Yd.m1768c(layoutInflater);
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131492932, null, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…pinner_item, null, false)");
        AbstractC0156Ga abstractC0156Ga = (AbstractC0156Ga) inflate;
        CheckedTextView checkedTextView = abstractC0156Ga.f502a;
        C0581Yd.m1767d(checkedTextView, "mDataBinding.checktextview");
        Context context = this.f998b;
        C0581Yd.m1768c(context);
        EnumC0539W8 item = getItem(i);
        C0581Yd.m1768c(item);
        checkedTextView.setText(context.getString(item.f1938b));
        return abstractC0156Ga.getRoot();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        C0581Yd.m1766e(viewGroup, "parent");
        LayoutInflater layoutInflater = this.f997a;
        C0581Yd.m1768c(layoutInflater);
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131493050, null, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…pinner_item, null, false)");
        AbstractC1667ec abstractC1667ec = (AbstractC1667ec) inflate;
        EnumC0539W8 item = getItem(i);
        if (item != null) {
            TextView textView = abstractC1667ec.f4162a;
            C0581Yd.m1767d(textView, "binding.text1");
            Context context = this.f998b;
            C0581Yd.m1768c(context);
            textView.setText(context.getString(item.f1938b));
        }
        View root = abstractC1667ec.getRoot();
        C0581Yd.m1767d(root, "binding.root");
        return root;
    }
}
