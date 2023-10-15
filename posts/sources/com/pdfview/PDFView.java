package com.pdfview;

import android.content.Context;
import android.util.AttributeSet;
import com.pdfview.subsamplincscaleimageview.ImageSource;
import com.pdfview.subsamplincscaleimageview.SubsamplingScaleImageView;
import com.pdfview.subsamplincscaleimageview.decoder.DecoderFactory;
import com.pdfview.subsamplincscaleimageview.decoder.ImageRegionDecoder;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PDFView extends SubsamplingScaleImageView {
    private float mScale;
    private File mfile;

    public PDFView(@NotNull Context context) {
        this(context, null, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PDFView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        C0581Yd.m1765f(context, "context");
        this.mScale = 8.0f;
        setMinimumTileDpi(120);
        setMinimumScaleType(4);
    }

    @NotNull
    public final PDFView fromAsset(@NotNull String str) {
        C0581Yd.m1765f(str, "assetFileName");
        FileUtils fileUtils = FileUtils.INSTANCE;
        Context context = getContext();
        C0581Yd.m1769b(context, "context");
        this.mfile = fileUtils.fileFromAsset(context, str);
        return this;
    }

    @NotNull
    public final PDFView fromFile(@NotNull File file) {
        C0581Yd.m1765f(file, "file");
        this.mfile = file;
        return this;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        recycle();
    }

    @NotNull
    public final PDFView scale(float f) {
        this.mScale = f;
        return this;
    }

    public final void show() {
        File file = this.mfile;
        if (file != null) {
            ImageSource uri = ImageSource.uri(file.getPath());
            C0581Yd.m1769b(uri, "ImageSource.uri(mfile!!.path)");
            setRegionDecoderFactory(new DecoderFactory<ImageRegionDecoder>() { // from class: com.pdfview.PDFView$show$1
                @Override // com.pdfview.subsamplincscaleimageview.decoder.DecoderFactory
                @NotNull
                /* renamed from: make */
                public final ImageRegionDecoder make2() {
                    File file2;
                    float f;
                    PDFView pDFView = PDFView.this;
                    file2 = pDFView.mfile;
                    if (file2 != null) {
                        f = PDFView.this.mScale;
                        return new PDFRegionDecoder(pDFView, file2, f, 0, 8, null);
                    }
                    C0581Yd.m1762i();
                    throw null;
                }
            });
            setImage(uri);
            return;
        }
        C0581Yd.m1762i();
        throw null;
    }

    @NotNull
    public final PDFView fromFile(@NotNull String str) {
        C0581Yd.m1765f(str, "filePath");
        this.mfile = new File(str);
        return this;
    }

    public /* synthetic */ PDFView(Context context, AttributeSet attributeSet, int i, C0565Xd c0565Xd) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
