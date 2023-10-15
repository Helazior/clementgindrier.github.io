package p000;

import android.os.CountDownTimer;
import fr.smoney.android.izly.SmoneyApplication;

/* renamed from: A8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CountDownTimerC0023A8 extends CountDownTimer {
    public CountDownTimerC0023A8(AbstractC0044B8 abstractC0044B8, long j, long j2) {
        super(j, j2);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        C0479U8 c0479u8 = SmoneyApplication.f4205d;
        c0479u8.f1685D0 = true;
        c0479u8.f1683C0 = true;
        c0479u8.f1681B0 = true;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
