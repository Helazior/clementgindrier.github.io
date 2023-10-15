package p000;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import p000.AbstractC1668ed;

/* renamed from: ad */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0617ad extends AbstractC1668ed {

    /* renamed from: h */
    public static final EnumC1631dd f2181h = EnumC1631dd.InputPasswordType;

    /* renamed from: d */
    public AbstractC0339Oa f2182d;

    /* renamed from: f */
    public String f2183f;

    /* renamed from: g */
    public String f2184g;

    /* renamed from: ad$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0618a implements View.OnClickListener {
        public View$OnClickListenerC0618a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C0617ad.this.m1724t();
        }
    }

    /* renamed from: ad$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnFocusChangeListenerC0619b implements View.OnFocusChangeListener {

        /* renamed from: ad$b$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class RunnableC0620a implements Runnable {
            public RunnableC0620a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity = C0617ad.this.getActivity();
                CustomBorderSimpleEditText customBorderSimpleEditText = C0617ad.this.f2182d.f1148b;
                if (activity != null) {
                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(customBorderSimpleEditText, 1);
                }
            }
        }

        public View$OnFocusChangeListenerC0619b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                C0617ad.this.f2182d.f1148b.post(new RunnableC0620a());
                C0617ad.this.f2182d.f1148b.setOnFocusChangeListener(null);
            }
        }
    }

    /* renamed from: ad$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0621c implements TextView.OnEditorActionListener {
        public C0621c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            C0617ad.this.m1724t();
            return false;
        }
    }

    /* renamed from: s */
    public static C0617ad m1725s(Context context, AbstractC1668ed.InterfaceC1669a interfaceC1669a) {
        C0617ad c0617ad = new C0617ad();
        Bundle m991m = c0617ad.m991m(interfaceC1669a, f2181h);
        m991m.putString("Argument.DialogTitle", context.getString(2131689790));
        m991m.putString("Argument.DialogMsg", context.getString(2131689789));
        m991m.putString("Argument.DialogBtnText", context.getString(2131689788));
        c0617ad.setArguments(m991m);
        return c0617ad;
    }

    @Override // p000.AbstractC1668ed, p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f2183f = arguments.getString("Argument.DialogTitle");
        this.f2184g = arguments.getString("Argument.DialogMsg");
        arguments.getString("Argument.DialogBtnText");
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5
    public Dialog onCreateDialog(Bundle bundle) {
        AbstractC0339Oa abstractC0339Oa = (AbstractC0339Oa) DataBindingUtil.inflate(getActivity().getLayoutInflater(), 2131492953, null, false);
        this.f2182d = abstractC0339Oa;
        abstractC0339Oa.f1148b.setLabel(this.f2184g);
        this.f2182d.f1148b.f4966a.f6403a.setInputType(18);
        this.f2182d.f1148b.setOnFocusChangeListener(new View$OnFocusChangeListenerC0619b());
        this.f2182d.f1148b.f4966a.f6403a.setOnEditorActionListener(new C0621c());
        this.f2182d.f1147a.setOnClickListener(new View.OnClickListener() { // from class: Uc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C0617ad.this.m1724t();
            }
        });
        return new AlertDialog.Builder(getActivity()).setTitle(this.f2183f).setView(this.f2182d.getRoot()).create();
    }

    @Override // p000.DialogInterface$OnCancelListenerC0110E5, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((AlertDialog) getDialog()).getButton(-1).setOnClickListener(new View$OnClickListenerC0618a());
        this.f2182d.f1148b.requestFocus();
    }

    /* renamed from: t */
    public final void m1724t() {
        AbstractC1668ed.InterfaceC1669a interfaceC1669a;
        String m824b = this.f2182d.f1148b.m824b();
        if (!TextUtils.isEmpty(m824b) && m824b.length() == 6) {
            Bundle bundle = new Bundle();
            bundle.putString("Data.Password", m824b);
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f2182d.f1148b.getWindowToken(), 0);
            if (this.f4165c && (interfaceC1669a = this.f4164b) != null) {
                interfaceC1669a.mo238k(this.f4163a, bundle);
            }
            dismiss();
            return;
        }
        FragmentActivity activity = getActivity();
        Toast.makeText(activity, activity.getString(2131689777, String.valueOf(6)), 0).show();
    }
}
