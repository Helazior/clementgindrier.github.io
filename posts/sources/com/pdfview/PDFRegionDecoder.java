package com.pdfview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.pdfview.subsamplincscaleimageview.decoder.ImageRegionDecoder;
import java.io.File;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PDFRegionDecoder implements ImageRegionDecoder {
    private final int backgroundColorPdf;
    private ParcelFileDescriptor descriptor;
    private final File file;
    private int pageHeight;
    private int pageWidth;
    private PdfRenderer renderer;
    private final float scale;
    private final PDFView view;

    public PDFRegionDecoder(@NotNull PDFView pDFView, @NotNull File file, float f, int i) {
        C0581Yd.m1765f(pDFView, "view");
        C0581Yd.m1765f(file, "file");
        this.view = pDFView;
        this.file = file;
        this.scale = f;
        this.backgroundColorPdf = i;
    }

    @Override // com.pdfview.subsamplincscaleimageview.decoder.ImageRegionDecoder
    @NotNull
    public Bitmap decodeRegion(@NotNull Rect rect, int i) {
        int i2;
        C0581Yd.m1765f(rect, "rect");
        int floor = (int) Math.floor(rect.top / this.pageHeight);
        Bitmap createBitmap = Bitmap.createBitmap(rect.width() / i, rect.height() / i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(this.backgroundColorPdf);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        Iterator<Integer> it = new C0978be(floor, ((int) Math.ceil(rect.bottom / this.pageHeight)) - 1).iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int mo1723a = ((AbstractC0528Vd) it).mo1723a();
            PdfRenderer pdfRenderer = this.renderer;
            if (pdfRenderer == null) {
                C0581Yd.m1761j("renderer");
                throw null;
            }
            synchronized (pdfRenderer) {
                PdfRenderer pdfRenderer2 = this.renderer;
                if (pdfRenderer2 != null) {
                    PdfRenderer.Page openPage = pdfRenderer2.openPage(mo1723a);
                    Matrix matrix = new Matrix();
                    float f = this.scale;
                    float f2 = i;
                    matrix.setScale(f / f2, f / f2);
                    int i4 = rect.top;
                    matrix.postTranslate((-rect.left) / i, ((this.pageHeight / f2) * i3) + (-((i4 - (i2 * floor)) / i)));
                    openPage.render(createBitmap, null, matrix, 1);
                    openPage.close();
                } else {
                    C0581Yd.m1761j("renderer");
                    throw null;
                }
            }
            i3++;
        }
        C0581Yd.m1769b(createBitmap, "bitmap");
        return createBitmap;
    }

    @Override // com.pdfview.subsamplincscaleimageview.decoder.ImageRegionDecoder
    @NotNull
    public Point init(@NotNull Context context, @NotNull Uri uri) {
        C0581Yd.m1765f(context, "context");
        C0581Yd.m1765f(uri, "uri");
        ParcelFileDescriptor open = ParcelFileDescriptor.open(this.file, 268435456);
        C0581Yd.m1769b(open, "ParcelFileDescriptor.ope…escriptor.MODE_READ_ONLY)");
        this.descriptor = open;
        ParcelFileDescriptor parcelFileDescriptor = this.descriptor;
        if (parcelFileDescriptor != null) {
            PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptor);
            this.renderer = pdfRenderer;
            PdfRenderer.Page openPage = pdfRenderer.openPage(0);
            C0581Yd.m1769b(openPage, "page");
            this.pageWidth = (int) (openPage.getWidth() * this.scale);
            this.pageHeight = (int) (openPage.getHeight() * this.scale);
            PdfRenderer pdfRenderer2 = this.renderer;
            if (pdfRenderer2 != null) {
                if (pdfRenderer2.getPageCount() > 15) {
                    this.view.setHasBaseLayerTiles(false);
                } else {
                    PdfRenderer pdfRenderer3 = this.renderer;
                    if (pdfRenderer3 == null) {
                        C0581Yd.m1761j("renderer");
                        throw null;
                    } else if (pdfRenderer3.getPageCount() == 1) {
                        this.view.setMinimumScaleType(1);
                    }
                }
                openPage.close();
                int i = this.pageWidth;
                int i2 = this.pageHeight;
                PdfRenderer pdfRenderer4 = this.renderer;
                if (pdfRenderer4 != null) {
                    return new Point(i, pdfRenderer4.getPageCount() * i2);
                }
                C0581Yd.m1761j("renderer");
                throw null;
            }
            C0581Yd.m1761j("renderer");
            throw null;
        }
        C0581Yd.m1761j("descriptor");
        throw null;
    }

    @Override // com.pdfview.subsamplincscaleimageview.decoder.ImageRegionDecoder
    public boolean isReady() {
        return this.pageWidth > 0 && this.pageHeight > 0;
    }

    @Override // com.pdfview.subsamplincscaleimageview.decoder.ImageRegionDecoder
    public void recycle() {
        PdfRenderer pdfRenderer = this.renderer;
        if (pdfRenderer != null) {
            pdfRenderer.close();
            ParcelFileDescriptor parcelFileDescriptor = this.descriptor;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
                this.pageWidth = 0;
                this.pageHeight = 0;
                return;
            }
            C0581Yd.m1761j("descriptor");
            throw null;
        }
        C0581Yd.m1761j("renderer");
        throw null;
    }

    public /* synthetic */ PDFRegionDecoder(PDFView pDFView, File file, float f, int i, int i2, C0565Xd c0565Xd) {
        this(pDFView, file, f, (i2 & 8) != 0 ? -1 : i);
    }
}
