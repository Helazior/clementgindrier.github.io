package p000;

import android.text.TextUtils;
import fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText;
import java.util.Iterator;

/* renamed from: Bd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0049Bd extends AbstractC0096Dd {

    /* renamed from: b */
    public String f218b;

    /* renamed from: c */
    public CustomBorderSimpleEditText f219c;

    /* renamed from: d */
    public boolean f220d;

    public C0049Bd(CustomBorderSimpleEditText customBorderSimpleEditText, String str, String str2, boolean z) {
        super(str);
        this.f219c = customBorderSimpleEditText;
        this.f218b = str2;
        this.f220d = z;
    }

    @Override // p000.AbstractC0096Dd
    /* renamed from: a */
    public boolean mo2475a(String str) {
        return this.f220d ? !str.equalsIgnoreCase(this.f218b) : str.equalsIgnoreCase(this.f218b);
    }

    /* renamed from: b */
    public void m2551b(String str) {
        this.f218b = str;
        CustomBorderSimpleEditText customBorderSimpleEditText = this.f219c;
        if (TextUtils.isEmpty(customBorderSimpleEditText.m824b())) {
            customBorderSimpleEditText.setValid();
            return;
        }
        Iterator<AbstractC0096Dd> it = customBorderSimpleEditText.f4970f.iterator();
        while (it.hasNext()) {
            AbstractC0096Dd next = it.next();
            if (!next.mo2475a(customBorderSimpleEditText.m824b())) {
                String str2 = next.f365a;
                if (str2 != null) {
                    customBorderSimpleEditText.setError(str2);
                    return;
                } else {
                    customBorderSimpleEditText.setError(customBorderSimpleEditText.f4967b.getString(2131689815));
                    return;
                }
            }
        }
        customBorderSimpleEditText.setValid();
    }
}
