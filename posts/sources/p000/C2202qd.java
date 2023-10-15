package p000;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.load.Key;
import com.google.android.material.datepicker.UtcDates;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: qd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2202qd extends AbstractC0044B8<AbstractC0024A9> {

    /* renamed from: j */
    public C0065C8 f6306j;

    /* renamed from: k */
    public String uuid;

    /* renamed from: l */
    public String f6308l;

    /* renamed from: m */
    public final String utcDatesUTC = UtcDates.UTC;

    @Override // p000.AbstractC0044B8
    /* renamed from: m */
    public int mo239m() {
        return 2131492899;
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        C0296Md.C0297a c0297a = C0296Md.f999a;
        AppCompatActivity appCompatActivity = this.f200g;
        C0581Yd.m1770d(appCompatActivity, "mActivity");
        String string = getString(2131689570);
        C0581Yd.m1770d(string, "getString(R.string.bottom_nav_bar_icon_pay)");
        String upperCase = string.toUpperCase();
        C0581Yd.m1770d(upperCase, "(this as java.lang.String).toUpperCase()");
        c0297a.m2197a(appCompatActivity, upperCase, 2131230937, null, EnumC1687fd.f4191b, EnumC0161Gd.f514f, false, (r19 & 128) != 0 ? false : false);
        super.onActivityCreated(bundle);
    }

    @Override // p000.AbstractC0044B8, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        StringBuilder sb;
        String uuid;
        C0581Yd.m1769e(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        new C2409zc(this.f200g);
        SharedPreferences sharedPreferences = this.f200g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0);
        C0581Yd.m1770d(sharedPreferences, "mActivity.getSharedPrefe…ME, Context.MODE_PRIVATE)");
        C0065C8 c0065c8 = new C0065C8(this.f200g);
        this.f6306j = c0065c8;
        String user_id = c0065c8.user_id();
        C0581Yd.m1770d(user_id, "oauth.userId");
        this.uuid = user_id;
        String str = "";
        this.f6308l = String.valueOf(sharedPreferences.getString("sharedPrefNsse", ""));
        ShapeableImageView shapeableImageView = ((AbstractC0024A9) this.f201h).f141d;
        C0581Yd.m1770d(shapeableImageView, "mDataBinding.qrImage");
        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
        int i = (int) (((6 * this.f196a) / 16) * 2);
        layoutParams.width = i;
        layoutParams.height = i;
        ShapeableImageView shapeableImageView2 = ((AbstractC0024A9) this.f201h).f141d;
        C0581Yd.m1770d(shapeableImageView2, "mDataBinding.qrImage");
        shapeableImageView2.setLayoutParams(layoutParams);
        C0065C8 c0065c82 = this.f6306j;
        if (c0065c82 == null) {
            C0581Yd.m1764j("oauth");
            throw null;
        }
        String uuid2 = this.uuid;
        if (uuid2 != null) {
            String m2507e = c0065c82.m2507e(uuid2);
            String substring = (m2507e == null || m2507e.length() <= 0) ? null : m2507e.substring(0, m2507e.length() - 1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(this.utcDatesUTC));
            String date_hour = simpleDateFormat.format(new Date());
            try {
                sb = new StringBuilder();
                sb.append("AIZ");
                sb.append(";");
                uuid = this.uuid;
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (SignatureException e3) {
                e3.printStackTrace();
            }
            if (uuid != null) {
                sb.append(uuid);
                sb.append(";");
                sb.append(date_hour);
                sb.append(";");
                sb.append(3); // type of the QR Code
                String sb_first_part = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sb_first_part);
                sb2.append(";");
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb_first_part);
                sb3.append('+');
                String str2 = this.f6308l;
                if (str2 == null) {
                    C0581Yd.m1764j("nsse");
                    throw null;
                }
                sb3.append(str2);
                sb2.append(C0374Q7.m2096b(sb3.toString(), substring));
                str = sb2.toString();
                try {
                    ((AbstractC0024A9) this.f201h).f141d.setImageBitmap(m426w(str));
                } catch (WriterException e4) {
                    e4.printStackTrace();
                }
                AppCompatActivity appCompatActivity = this.f200g;
                C0581Yd.m1770d(appCompatActivity, "mActivity");
                Window window = appCompatActivity.getWindow();
                C0581Yd.m1770d(window, "mActivity.window");
                WindowManager.LayoutParams attributes = window.getAttributes();
                C0581Yd.m1770d(attributes, "mActivity.window.attributes");
                attributes.screenBrightness = 1.0f;
                AppCompatActivity appCompatActivity2 = this.f200g;
                C0581Yd.m1770d(appCompatActivity2, "mActivity");
                Window window2 = appCompatActivity2.getWindow();
                C0581Yd.m1770d(window2, "mActivity.window");
                window2.setAttributes(attributes);
                m2558t(2.6d, ((AbstractC0024A9) this.f201h).f140c);
                m2558t(3.4d, ((AbstractC0024A9) this.f201h).f139b);
                Object obj = this.f201h;
                C0581Yd.m1770d(obj, "mDataBinding");
                return ((AbstractC0024A9) obj).getRoot();
            }
            C0581Yd.m1764j("userId");
            throw null;
        }
        C0581Yd.m1764j("userId");
        throw null;
    }

    /* renamed from: w */
    public final Bitmap m426w(String str) {
        String str2;
        C0048Bc c0048Bc = new C0048Bc(str, null, "TEXT_TYPE", BarcodeFormat.QR_CODE.toString(), (int) (this.f196a * 0.6375d));
        EnumMap enumMap = null;
        if (c0048Bc.f217d) {
            String str3 = c0048Bc.f215b;
            int i = 0;
            while (true) {
                if (i >= str3.length()) {
                    str2 = null;
                    break;
                } else if (str3.charAt(i) > 255) {
                    str2 = Key.STRING_CHARSET_NAME;
                    break;
                } else {
                    i++;
                }
            }
            if (str2 != null) {
                enumMap = new EnumMap(EncodeHintType.class);
                enumMap.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) str2);
            }
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            String str4 = c0048Bc.f215b;
            BarcodeFormat barcodeFormat = c0048Bc.f216c;
            int i2 = c0048Bc.f214a;
            BitMatrix encode = multiFormatWriter.encode(str4, barcodeFormat, i2, i2, enumMap);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[width * height];
            for (int i3 = 0; i3 < height; i3++) {
                int i4 = i3 * width;
                for (int i5 = 0; i5 < width; i5++) {
                    iArr[i4 + i5] = encode.get(i5, i3) ? -12632257 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        }
        return null;
    }
}
