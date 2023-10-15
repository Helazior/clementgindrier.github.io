package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import fr.smoney.android.izly.data.model.AccountStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Gc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0158Gc extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {

    /* renamed from: a */
    public AbstractC0376Q9 f505a;
    @NotNull

    /* renamed from: b */
    public final InterfaceC0159a f506b;

    /* renamed from: c */
    public final ArrayList<AccountStatement> f507c;
    @NotNull

    /* renamed from: d */
    public LayoutInflater f508d;

    /* renamed from: Gc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0159a {
        /* renamed from: c */
        void mo853c(@Nullable AccountStatement accountStatement, @NotNull View view);
    }

    /* renamed from: Gc$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0160b extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC0376Q9 f509a;

        /* renamed from: b */
        public final /* synthetic */ C0158Gc f510b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0160b(@NotNull C0158Gc c0158Gc, AbstractC0376Q9 abstractC0376Q9) {
            super(abstractC0376Q9.getRoot());
            C0581Yd.m1766e(abstractC0376Q9, "v");
            this.f510b = c0158Gc;
            this.f509a = abstractC0376Q9;
        }
    }

    public C0158Gc(@NotNull Context context, @NotNull InterfaceC0159a interfaceC0159a) {
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1766e(interfaceC0159a, "mListener");
        this.f506b = interfaceC0159a;
        this.f507c = new ArrayList<>();
        LayoutInflater from = LayoutInflater.from(context);
        C0581Yd.m1767d(from, "LayoutInflater.from(context)");
        this.f508d = from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f507c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        String format;
        C0581Yd.m1766e(abstractC0824B, "holder");
        AccountStatement accountStatement = this.f507c.get(i);
        C0581Yd.m1767d(accountStatement, "mEventList[position]");
        AccountStatement accountStatement2 = accountStatement;
        C0160b c0160b = (C0160b) abstractC0824B;
        C0581Yd.m1766e(accountStatement2, "item");
        Calendar calendar = Calendar.getInstance();
        StringBuilder m253r = outline.m253r(CrashlyticsReportDataCapture.SIGNAL_DEFAULT);
        m253r.append(accountStatement2.f4215a);
        m253r.append("-");
        m253r.append(accountStatement2.f4216b);
        String sb = m253r.toString();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-yyyy", Locale.getDefault());
            C0581Yd.m1767d(calendar, "calendar");
            Date parse = simpleDateFormat.parse(sb);
            C0581Yd.m1768c(parse);
            calendar.setTime(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!C0581Yd.m1770a(Locale.getDefault(), Locale.FRANCE)) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            C0581Yd.m1767d(calendar, "calendar");
            format = simpleDateFormat2.format(calendar.getTime());
            C0581Yd.m1767d(format, "SimpleDateFormat(\"MMMM\",…SH).format(calendar.time)");
        } else {
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("MMMM", Locale.getDefault());
            C0581Yd.m1767d(calendar, "calendar");
            format = simpleDateFormat3.format(calendar.getTime());
            C0581Yd.m1767d(format, "SimpleDateFormat(\"MMMM\",…()).format(calendar.time)");
            C0581Yd.m1766e(format, "$this$capitalize");
            Locale locale = Locale.getDefault();
            C0581Yd.m1767d(locale, "Locale.getDefault()");
            C0581Yd.m1766e(format, "$this$capitalize");
            C0581Yd.m1766e(locale, "locale");
            if (format.length() > 0) {
                char charAt = format.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    StringBuilder sb2 = new StringBuilder();
                    char titleCase = Character.toTitleCase(charAt);
                    if (titleCase != Character.toUpperCase(charAt)) {
                        sb2.append(titleCase);
                    } else {
                        String substring = format.substring(0, 1);
                        C0581Yd.m1767d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String upperCase = substring.toUpperCase(locale);
                        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                        sb2.append(upperCase);
                    }
                    String substring2 = format.substring(1);
                    C0581Yd.m1767d(substring2, "(this as java.lang.String).substring(startIndex)");
                    sb2.append(substring2);
                    format = sb2.toString();
                    C0581Yd.m1767d(format, "StringBuilder().apply(builderAction).toString()");
                }
            }
        }
        TextView textView = c0160b.f509a.f1278d;
        C0581Yd.m1767d(textView, "v.tvStatementMonth");
        textView.setText(format);
        TextView textView2 = c0160b.f509a.f1279f;
        C0581Yd.m1767d(textView2, "v.tvStatementYear");
        textView2.setText(accountStatement2.f4216b);
        c0160b.f509a.f1276b.setOnClickListener(new View$OnClickListenerC0951b(0, c0160b, accountStatement2));
        c0160b.f509a.f1277c.setOnClickListener(new View$OnClickListenerC0951b(1, c0160b, accountStatement2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.f508d, 2131492907, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…ents_item, parent, false)");
        this.f505a = (AbstractC0376Q9) inflate;
        AbstractC0376Q9 abstractC0376Q9 = this.f505a;
        if (abstractC0376Q9 != null) {
            return new C0160b(this, abstractC0376Q9);
        }
        C0581Yd.m1761j("mDataBinding");
        throw null;
    }
}
