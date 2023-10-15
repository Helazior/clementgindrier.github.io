package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: fr.smoney.android.izly.ui.widget.NoDefaultSpinner */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NoDefaultSpinner extends Spinner {

    /* renamed from: fr.smoney.android.izly.ui.widget.NoDefaultSpinner$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1824a implements InvocationHandler {

        /* renamed from: a */
        public SpinnerAdapter f5028a;

        /* renamed from: b */
        public Method f5029b;

        public C1824a(SpinnerAdapter spinnerAdapter) {
            this.f5028a = spinnerAdapter;
            try {
                this.f5029b = SpinnerAdapter.class.getMethod("getView", Integer.TYPE, View.class, ViewGroup.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        /* renamed from: a */
        public View m805a(int i, View view, ViewGroup viewGroup) {
            if (i < 0) {
                TextView textView = (TextView) ((LayoutInflater) NoDefaultSpinner.this.getContext().getSystemService("layout_inflater")).inflate(17367048, viewGroup, false);
                textView.setText(NoDefaultSpinner.this.getPrompt());
                return textView;
            }
            return this.f5028a.getView(i, view, viewGroup);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                return (!method.equals(this.f5029b) || ((Integer) objArr[0]).intValue() >= 0) ? method.invoke(this.f5028a, objArr) : m805a(((Integer) objArr[0]).intValue(), (View) objArr[1], (ViewGroup) objArr[2]);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public NoDefaultSpinner(Context context) {
        super(context);
    }

    public NoDefaultSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        super.setAdapter((SpinnerAdapter) Proxy.newProxyInstance(spinnerAdapter.getClass().getClassLoader(), new Class[]{SpinnerAdapter.class}, new C1824a(spinnerAdapter)));
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, -1);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(this, -1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public NoDefaultSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
