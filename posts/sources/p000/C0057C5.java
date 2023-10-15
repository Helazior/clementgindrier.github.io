package p000;

import android.content.res.AssetManager;
import android.util.Log;
import com.google.android.material.datepicker.UtcDates;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.pdfview.subsamplincscaleimageview.SubsamplingScaleImageView;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* renamed from: C5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0057C5 {

    /* renamed from: A */
    public static final C0060c[] f230A;

    /* renamed from: B */
    public static final C0060c[] f231B;

    /* renamed from: C */
    public static final C0060c f232C;

    /* renamed from: D */
    public static final C0060c[] f233D;

    /* renamed from: E */
    public static final C0060c[] f234E;

    /* renamed from: F */
    public static final C0060c[] f235F;

    /* renamed from: G */
    public static final C0060c[] f236G;

    /* renamed from: H */
    public static final C0060c[][] f237H;

    /* renamed from: I */
    public static final C0060c[] f238I;

    /* renamed from: J */
    public static final HashMap<Integer, C0060c>[] f239J;

    /* renamed from: K */
    public static final HashMap<String, C0060c>[] f240K;

    /* renamed from: L */
    public static final HashSet<String> f241L;

    /* renamed from: M */
    public static final HashMap<Integer, Integer> f242M;

    /* renamed from: N */
    public static final Charset f243N;

    /* renamed from: O */
    public static final byte[] f244O;

    /* renamed from: t */
    public static SimpleDateFormat f252t;

    /* renamed from: x */
    public static final C0060c[] f256x;

    /* renamed from: y */
    public static final C0060c[] f257y;

    /* renamed from: z */
    public static final C0060c[] f258z;

    /* renamed from: a */
    public final String f259a;

    /* renamed from: b */
    public final AssetManager.AssetInputStream f260b;

    /* renamed from: c */
    public int f261c;

    /* renamed from: d */
    public final HashMap<String, C0059b>[] f262d;

    /* renamed from: e */
    public Set<Integer> f263e;

    /* renamed from: f */
    public ByteOrder f264f;

    /* renamed from: g */
    public int f265g;

    /* renamed from: h */
    public int f266h;

    /* renamed from: i */
    public int f267i;

    /* renamed from: j */
    public int f268j;

    /* renamed from: k */
    public int f269k;

    /* renamed from: l */
    public int f270l;

    /* renamed from: m */
    public static final List<Integer> f245m = Arrays.asList(1, 6, 3, 8);

    /* renamed from: n */
    public static final List<Integer> f246n = Arrays.asList(2, 7, 4, 5);

    /* renamed from: o */
    public static final int[] f247o = {8, 8, 8};

    /* renamed from: p */
    public static final int[] f248p = {8};

    /* renamed from: q */
    public static final byte[] f249q = {-1, -40, -1};

    /* renamed from: r */
    public static final byte[] f250r = {79, 76, 89, 77, 80, 0};

    /* renamed from: s */
    public static final byte[] f251s = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: u */
    public static final String[] f253u = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: v */
    public static final int[] f254v = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: w */
    public static final byte[] f255w = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: C5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0059b {

        /* renamed from: a */
        public final int f277a;

        /* renamed from: b */
        public final int f278b;

        /* renamed from: c */
        public final byte[] f279c;

        public C0059b(int i, int i2, byte[] bArr) {
            this.f277a = i;
            this.f278b = i2;
            this.f279c = bArr;
        }

        /* renamed from: a */
        public static C0059b m2524a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(C0057C5.f243N);
            return new C0059b(2, bytes.length, bytes);
        }

        /* renamed from: b */
        public static C0059b m2523b(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[C0057C5.f254v[4] * 1]);
            wrap.order(byteOrder);
            for (int i = 0; i < 1; i++) {
                wrap.putInt((int) jArr[i]);
            }
            return new C0059b(4, 1, wrap.array());
        }

        /* renamed from: c */
        public static C0059b m2522c(C0061d c0061d, ByteOrder byteOrder) {
            C0061d[] c0061dArr = {c0061d};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[C0057C5.f254v[5] * 1]);
            wrap.order(byteOrder);
            for (int i = 0; i < 1; i++) {
                C0061d c0061d2 = c0061dArr[i];
                wrap.putInt((int) c0061d2.f284a);
                wrap.putInt((int) c0061d2.f285b);
            }
            return new C0059b(5, 1, wrap.array());
        }

        /* renamed from: d */
        public static C0059b m2521d(int i, ByteOrder byteOrder) {
            int[] iArr = {i};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[C0057C5.f254v[3] * 1]);
            wrap.order(byteOrder);
            for (int i2 = 0; i2 < 1; i2++) {
                wrap.putShort((short) iArr[i2]);
            }
            return new C0059b(3, 1, wrap.array());
        }

        /* renamed from: e */
        public double m2520e(ByteOrder byteOrder) {
            Object m2517h = m2517h(byteOrder);
            if (m2517h != null) {
                if (m2517h instanceof String) {
                    return Double.parseDouble((String) m2517h);
                }
                if (m2517h instanceof long[]) {
                    long[] jArr = (long[]) m2517h;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (m2517h instanceof int[]) {
                    int[] iArr = (int[]) m2517h;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (m2517h instanceof double[]) {
                    double[] dArr = (double[]) m2517h;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (m2517h instanceof C0061d[]) {
                    C0061d[] c0061dArr = (C0061d[]) m2517h;
                    if (c0061dArr.length == 1) {
                        C0061d c0061d = c0061dArr[0];
                        return c0061d.f284a / c0061d.f285b;
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        /* renamed from: f */
        public int m2519f(ByteOrder byteOrder) {
            Object m2517h = m2517h(byteOrder);
            if (m2517h != null) {
                if (m2517h instanceof String) {
                    return Integer.parseInt((String) m2517h);
                }
                if (m2517h instanceof long[]) {
                    long[] jArr = (long[]) m2517h;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (m2517h instanceof int[]) {
                    int[] iArr = (int[]) m2517h;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        /* renamed from: g */
        public String m2518g(ByteOrder byteOrder) {
            Object m2517h = m2517h(byteOrder);
            if (m2517h == null) {
                return null;
            }
            if (m2517h instanceof String) {
                return (String) m2517h;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (m2517h instanceof long[]) {
                long[] jArr = (long[]) m2517h;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (m2517h instanceof int[]) {
                int[] iArr = (int[]) m2517h;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (m2517h instanceof double[]) {
                double[] dArr = (double[]) m2517h;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (m2517h instanceof C0061d[]) {
                C0061d[] c0061dArr = (C0061d[]) m2517h;
                while (i < c0061dArr.length) {
                    sb.append(c0061dArr[i].f284a);
                    sb.append('/');
                    sb.append(c0061dArr[i].f285b);
                    i++;
                    if (i != c0061dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x019f: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:152:0x019f */
        /* JADX WARN: Removed duplicated region for block: B:174:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: h */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object m2517h(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 456
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0057C5.C0059b.m2517h(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("(");
            m253r.append(C0057C5.f253u[this.f277a]);
            m253r.append(", data length:");
            return outline.m263h(m253r, this.f279c.length, ")");
        }
    }

    /* renamed from: C5$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0061d {

        /* renamed from: a */
        public final long f284a;

        /* renamed from: b */
        public final long f285b;

        public C0061d(long j, long j2) {
            if (j2 == 0) {
                this.f284a = 0L;
                this.f285b = 1L;
                return;
            }
            this.f284a = j;
            this.f285b = j2;
        }

        public String toString() {
            return this.f284a + "/" + this.f285b;
        }
    }

    static {
        C0060c[] c0060cArr;
        C0060c[] c0060cArr2 = {new C0060c("NewSubfileType", 254, 4), new C0060c("SubfileType", 255, 4), new C0060c("ImageWidth", 256, 3, 4), new C0060c("ImageLength", 257, 3, 4), new C0060c("BitsPerSample", 258, 3), new C0060c("Compression", 259, 3), new C0060c("PhotometricInterpretation", 262, 3), new C0060c("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new C0060c("Make", 271, 2), new C0060c("Model", 272, 2), new C0060c("StripOffsets", 273, 3, 4), new C0060c("Orientation", 274, 3), new C0060c("SamplesPerPixel", 277, 3), new C0060c("RowsPerStrip", 278, 3, 4), new C0060c("StripByteCounts", 279, 3, 4), new C0060c("XResolution", 282, 5), new C0060c("YResolution", 283, 5), new C0060c("PlanarConfiguration", 284, 3), new C0060c("ResolutionUnit", 296, 3), new C0060c("TransferFunction", 301, 3), new C0060c("Software", 305, 2), new C0060c("DateTime", 306, 2), new C0060c("Artist", 315, 2), new C0060c("WhitePoint", 318, 5), new C0060c("PrimaryChromaticities", 319, 5), new C0060c("SubIFDPointer", 330, 4), new C0060c("JPEGInterchangeFormat", 513, 4), new C0060c("JPEGInterchangeFormatLength", 514, 4), new C0060c("YCbCrCoefficients", 529, 5), new C0060c("YCbCrSubSampling", 530, 3), new C0060c("YCbCrPositioning", 531, 3), new C0060c("ReferenceBlackWhite", 532, 5), new C0060c("Copyright", 33432, 2), new C0060c("ExifIFDPointer", 34665, 4), new C0060c("GPSInfoIFDPointer", 34853, 4), new C0060c("SensorTopBorder", 4, 4), new C0060c("SensorLeftBorder", 5, 4), new C0060c("SensorBottomBorder", 6, 4), new C0060c("SensorRightBorder", 7, 4), new C0060c("ISO", 23, 3), new C0060c("JpgFromRaw", 46, 7)};
        f256x = c0060cArr2;
        C0060c[] c0060cArr3 = {new C0060c("ExposureTime", 33434, 5), new C0060c("FNumber", 33437, 5), new C0060c("ExposureProgram", 34850, 3), new C0060c("SpectralSensitivity", 34852, 2), new C0060c("PhotographicSensitivity", 34855, 3), new C0060c("OECF", 34856, 7), new C0060c("ExifVersion", 36864, 2), new C0060c("DateTimeOriginal", 36867, 2), new C0060c("DateTimeDigitized", 36868, 2), new C0060c("ComponentsConfiguration", 37121, 7), new C0060c("CompressedBitsPerPixel", 37122, 5), new C0060c("ShutterSpeedValue", 37377, 10), new C0060c("ApertureValue", 37378, 5), new C0060c("BrightnessValue", 37379, 10), new C0060c("ExposureBiasValue", 37380, 10), new C0060c("MaxApertureValue", 37381, 5), new C0060c("SubjectDistance", 37382, 5), new C0060c("MeteringMode", 37383, 3), new C0060c("LightSource", 37384, 3), new C0060c("Flash", 37385, 3), new C0060c("FocalLength", 37386, 5), new C0060c("SubjectArea", 37396, 3), new C0060c("MakerNote", 37500, 7), new C0060c("UserComment", 37510, 7), new C0060c("SubSecTime", 37520, 2), new C0060c("SubSecTimeOriginal", 37521, 2), new C0060c("SubSecTimeDigitized", 37522, 2), new C0060c("FlashpixVersion", 40960, 7), new C0060c("ColorSpace", 40961, 3), new C0060c("PixelXDimension", 40962, 3, 4), new C0060c("PixelYDimension", 40963, 3, 4), new C0060c("RelatedSoundFile", 40964, 2), new C0060c("InteroperabilityIFDPointer", 40965, 4), new C0060c("FlashEnergy", 41483, 5), new C0060c("SpatialFrequencyResponse", 41484, 7), new C0060c("FocalPlaneXResolution", 41486, 5), new C0060c("FocalPlaneYResolution", 41487, 5), new C0060c("FocalPlaneResolutionUnit", 41488, 3), new C0060c("SubjectLocation", 41492, 3), new C0060c("ExposureIndex", 41493, 5), new C0060c("SensingMethod", 41495, 3), new C0060c("FileSource", 41728, 7), new C0060c("SceneType", 41729, 7), new C0060c("CFAPattern", 41730, 7), new C0060c("CustomRendered", 41985, 3), new C0060c("ExposureMode", 41986, 3), new C0060c("WhiteBalance", 41987, 3), new C0060c("DigitalZoomRatio", 41988, 5), new C0060c("FocalLengthIn35mmFilm", 41989, 3), new C0060c("SceneCaptureType", 41990, 3), new C0060c("GainControl", 41991, 3), new C0060c("Contrast", 41992, 3), new C0060c("Saturation", 41993, 3), new C0060c("Sharpness", 41994, 3), new C0060c("DeviceSettingDescription", 41995, 7), new C0060c("SubjectDistanceRange", 41996, 3), new C0060c("ImageUniqueID", 42016, 2), new C0060c("DNGVersion", 50706, 1), new C0060c("DefaultCropSize", 50720, 3, 4)};
        f257y = c0060cArr3;
        C0060c[] c0060cArr4 = {new C0060c("GPSVersionID", 0, 1), new C0060c("GPSLatitudeRef", 1, 2), new C0060c("GPSLatitude", 2, 5), new C0060c("GPSLongitudeRef", 3, 2), new C0060c("GPSLongitude", 4, 5), new C0060c("GPSAltitudeRef", 5, 1), new C0060c("GPSAltitude", 6, 5), new C0060c("GPSTimeStamp", 7, 5), new C0060c("GPSSatellites", 8, 2), new C0060c("GPSStatus", 9, 2), new C0060c("GPSMeasureMode", 10, 2), new C0060c("GPSDOP", 11, 5), new C0060c("GPSSpeedRef", 12, 2), new C0060c("GPSSpeed", 13, 5), new C0060c("GPSTrackRef", 14, 2), new C0060c("GPSTrack", 15, 5), new C0060c("GPSImgDirectionRef", 16, 2), new C0060c("GPSImgDirection", 17, 5), new C0060c("GPSMapDatum", 18, 2), new C0060c("GPSDestLatitudeRef", 19, 2), new C0060c("GPSDestLatitude", 20, 5), new C0060c("GPSDestLongitudeRef", 21, 2), new C0060c("GPSDestLongitude", 22, 5), new C0060c("GPSDestBearingRef", 23, 2), new C0060c("GPSDestBearing", 24, 5), new C0060c("GPSDestDistanceRef", 25, 2), new C0060c("GPSDestDistance", 26, 5), new C0060c("GPSProcessingMethod", 27, 7), new C0060c("GPSAreaInformation", 28, 7), new C0060c("GPSDateStamp", 29, 2), new C0060c("GPSDifferential", 30, 3)};
        f258z = c0060cArr4;
        C0060c[] c0060cArr5 = {new C0060c("InteroperabilityIndex", 1, 2)};
        f230A = c0060cArr5;
        C0060c[] c0060cArr6 = {new C0060c("NewSubfileType", 254, 4), new C0060c("SubfileType", 255, 4), new C0060c("ThumbnailImageWidth", 256, 3, 4), new C0060c("ThumbnailImageLength", 257, 3, 4), new C0060c("BitsPerSample", 258, 3), new C0060c("Compression", 259, 3), new C0060c("PhotometricInterpretation", 262, 3), new C0060c("ImageDescription", SubsamplingScaleImageView.ORIENTATION_270, 2), new C0060c("Make", 271, 2), new C0060c("Model", 272, 2), new C0060c("StripOffsets", 273, 3, 4), new C0060c("Orientation", 274, 3), new C0060c("SamplesPerPixel", 277, 3), new C0060c("RowsPerStrip", 278, 3, 4), new C0060c("StripByteCounts", 279, 3, 4), new C0060c("XResolution", 282, 5), new C0060c("YResolution", 283, 5), new C0060c("PlanarConfiguration", 284, 3), new C0060c("ResolutionUnit", 296, 3), new C0060c("TransferFunction", 301, 3), new C0060c("Software", 305, 2), new C0060c("DateTime", 306, 2), new C0060c("Artist", 315, 2), new C0060c("WhitePoint", 318, 5), new C0060c("PrimaryChromaticities", 319, 5), new C0060c("SubIFDPointer", 330, 4), new C0060c("JPEGInterchangeFormat", 513, 4), new C0060c("JPEGInterchangeFormatLength", 514, 4), new C0060c("YCbCrCoefficients", 529, 5), new C0060c("YCbCrSubSampling", 530, 3), new C0060c("YCbCrPositioning", 531, 3), new C0060c("ReferenceBlackWhite", 532, 5), new C0060c("Copyright", 33432, 2), new C0060c("ExifIFDPointer", 34665, 4), new C0060c("GPSInfoIFDPointer", 34853, 4), new C0060c("DNGVersion", 50706, 1), new C0060c("DefaultCropSize", 50720, 3, 4)};
        f231B = c0060cArr6;
        f232C = new C0060c("StripOffsets", 273, 3);
        C0060c[] c0060cArr7 = {new C0060c("ThumbnailImage", 256, 7), new C0060c("CameraSettingsIFDPointer", 8224, 4), new C0060c("ImageProcessingIFDPointer", 8256, 4)};
        f233D = c0060cArr7;
        C0060c[] c0060cArr8 = {new C0060c("PreviewImageStart", 257, 4), new C0060c("PreviewImageLength", 258, 4)};
        f234E = c0060cArr8;
        C0060c[] c0060cArr9 = {new C0060c("AspectFrame", 4371, 3)};
        f235F = c0060cArr9;
        C0060c[] c0060cArr10 = {new C0060c("ColorSpace", 55, 3)};
        f236G = c0060cArr10;
        C0060c[][] c0060cArr11 = {c0060cArr2, c0060cArr3, c0060cArr4, c0060cArr5, c0060cArr6, c0060cArr2, c0060cArr7, c0060cArr8, c0060cArr9, c0060cArr10};
        f237H = c0060cArr11;
        f238I = new C0060c[]{new C0060c("SubIFDPointer", 330, 4), new C0060c("ExifIFDPointer", 34665, 4), new C0060c("GPSInfoIFDPointer", 34853, 4), new C0060c("InteroperabilityIFDPointer", 40965, 4), new C0060c("CameraSettingsIFDPointer", 8224, 1), new C0060c("ImageProcessingIFDPointer", 8256, 1)};
        f239J = new HashMap[c0060cArr11.length];
        f240K = new HashMap[c0060cArr11.length];
        f241L = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f242M = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f243N = forName;
        f244O = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f252t = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        int i = 0;
        while (true) {
            C0060c[][] c0060cArr12 = f237H;
            if (i < c0060cArr12.length) {
                f239J[i] = new HashMap<>();
                f240K[i] = new HashMap<>();
                for (C0060c c0060c : c0060cArr12[i]) {
                    f239J[i].put(Integer.valueOf(c0060c.f280a), c0060c);
                    f240K[i].put(c0060c.f281b, c0060c);
                }
                i++;
            } else {
                HashMap<Integer, Integer> hashMap = f242M;
                C0060c[] c0060cArr13 = f238I;
                hashMap.put(Integer.valueOf(c0060cArr13[0].f280a), 5);
                hashMap.put(Integer.valueOf(c0060cArr13[1].f280a), 1);
                hashMap.put(Integer.valueOf(c0060cArr13[2].f280a), 2);
                hashMap.put(Integer.valueOf(c0060cArr13[3].f280a), 3);
                hashMap.put(Integer.valueOf(c0060cArr13[4].f280a), 7);
                hashMap.put(Integer.valueOf(c0060cArr13[5].f280a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
        }
    }

    public C0057C5(String str) {
        FileInputStream fileInputStream;
        C0060c[][] c0060cArr = f237H;
        this.f262d = new HashMap[c0060cArr.length];
        this.f263e = new HashSet(c0060cArr.length);
        this.f264f = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            FileInputStream fileInputStream2 = null;
            this.f260b = null;
            this.f259a = str;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                m2533m(fileInputStream);
                try {
                    fileInputStream.close();
                    return;
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("filename cannot be null");
    }

    /* renamed from: b */
    public static long[] m2544b(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public final void m2545a() {
        String m2543c = m2543c("DateTimeOriginal");
        if (m2543c != null && m2543c("DateTime") == null) {
            this.f262d[0].put("DateTime", C0059b.m2524a(m2543c));
        }
        if (m2543c("ImageWidth") == null) {
            this.f262d[0].put("ImageWidth", C0059b.m2523b(0L, this.f264f));
        }
        if (m2543c("ImageLength") == null) {
            this.f262d[0].put("ImageLength", C0059b.m2523b(0L, this.f264f));
        }
        if (m2543c("Orientation") == null) {
            this.f262d[0].put("Orientation", C0059b.m2523b(0L, this.f264f));
        }
        if (m2543c("LightSource") == null) {
            this.f262d[1].put("LightSource", C0059b.m2523b(0L, this.f264f));
        }
    }

    /* renamed from: c */
    public String m2543c(String str) {
        C0059b m2542d = m2542d(str);
        if (m2542d != null) {
            if (!f241L.contains(str)) {
                return m2542d.m2518g(this.f264f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = m2542d.f277a;
                if (i != 5 && i != 10) {
                    StringBuilder m253r = outline.m253r("GPS Timestamp format is not rational. format=");
                    m253r.append(m2542d.f277a);
                    Log.w("ExifInterface", m253r.toString());
                    return null;
                }
                C0061d[] c0061dArr = (C0061d[]) m2542d.m2517h(this.f264f);
                if (c0061dArr != null && c0061dArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) c0061dArr[0].f284a) / ((float) c0061dArr[0].f285b))), Integer.valueOf((int) (((float) c0061dArr[1].f284a) / ((float) c0061dArr[1].f285b))), Integer.valueOf((int) (((float) c0061dArr[2].f284a) / ((float) c0061dArr[2].f285b))));
                }
                StringBuilder m253r2 = outline.m253r("Invalid GPS Timestamp array. array=");
                m253r2.append(Arrays.toString(c0061dArr));
                Log.w("ExifInterface", m253r2.toString());
                return null;
            }
            try {
                return Double.toString(m2542d.m2520e(this.f264f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    /* renamed from: d */
    public final C0059b m2542d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < f237H.length; i++) {
            C0059b c0059b = this.f262d[i].get(str);
            if (c0059b != null) {
                return c0059b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x011a, code lost:
        r9.f274b = r8.f264f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011e, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055 A[FALL_THROUGH] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2541e(p000.C0057C5.C0058a r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0057C5.m2541e(C5$a, int, int):void");
    }

    /* renamed from: f */
    public final int m2540f(BufferedInputStream bufferedInputStream) {
        boolean z;
        boolean z2;
        bufferedInputStream.mark(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        byte[] bArr = new byte[BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr2 = f249q;
            if (i >= bArr2.length) {
                z = true;
                break;
            } else if (bArr[i] != bArr2[i]) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i2 = 0;
        while (true) {
            if (i2 >= bytes.length) {
                z2 = true;
                break;
            } else if (bArr[i2] != bytes[i2]) {
                z2 = false;
                break;
            } else {
                i2++;
            }
        }
        if (z2) {
            return 9;
        }
        C0058a c0058a = new C0058a(bArr);
        ByteOrder m2531o = m2531o(c0058a);
        this.f264f = m2531o;
        c0058a.f274b = m2531o;
        short readShort = c0058a.readShort();
        c0058a.close();
        if (readShort == 20306 || readShort == 21330) {
            return 7;
        }
        C0058a c0058a2 = new C0058a(bArr);
        ByteOrder m2531o2 = m2531o(c0058a2);
        this.f264f = m2531o2;
        c0058a2.f274b = m2531o2;
        short readShort2 = c0058a2.readShort();
        c0058a2.close();
        return readShort2 == 85 ? 10 : 0;
    }

    /* renamed from: g */
    public final void m2539g(C0058a c0058a) {
        m2537i(c0058a);
        C0059b c0059b = this.f262d[1].get("MakerNote");
        if (c0059b != null) {
            C0058a c0058a2 = new C0058a(c0059b.f279c);
            c0058a2.f274b = this.f264f;
            byte[] bArr = f250r;
            byte[] bArr2 = new byte[bArr.length];
            c0058a2.readFully(bArr2);
            c0058a2.m2525F(0L);
            byte[] bArr3 = f251s;
            byte[] bArr4 = new byte[bArr3.length];
            c0058a2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                c0058a2.m2525F(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                c0058a2.m2525F(12L);
            }
            m2530p(c0058a2, 6);
            C0059b c0059b2 = this.f262d[7].get("PreviewImageStart");
            C0059b c0059b3 = this.f262d[7].get("PreviewImageLength");
            if (c0059b2 != null && c0059b3 != null) {
                this.f262d[5].put("JPEGInterchangeFormat", c0059b2);
                this.f262d[5].put("JPEGInterchangeFormatLength", c0059b3);
            }
            C0059b c0059b4 = this.f262d[8].get("AspectFrame");
            if (c0059b4 != null) {
                int[] iArr = (int[]) c0059b4.m2517h(this.f264f);
                if (iArr != null && iArr.length == 4) {
                    if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                        return;
                    }
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    C0059b m2521d = C0059b.m2521d(i, this.f264f);
                    C0059b m2521d2 = C0059b.m2521d(i2, this.f264f);
                    this.f262d[0].put("ImageWidth", m2521d);
                    this.f262d[0].put("ImageLength", m2521d2);
                    return;
                }
                StringBuilder m253r = outline.m253r("Invalid aspect frame values. frame=");
                m253r.append(Arrays.toString(iArr));
                Log.w("ExifInterface", m253r.toString());
            }
        }
    }

    /* renamed from: h */
    public final void m2538h(C0058a c0058a) {
        c0058a.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        c0058a.read(bArr);
        c0058a.skipBytes(4);
        c0058a.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        m2541e(c0058a, i, 5);
        c0058a.m2525F(i2);
        c0058a.f274b = ByteOrder.BIG_ENDIAN;
        int readInt = c0058a.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = c0058a.readUnsignedShort();
            int readUnsignedShort2 = c0058a.readUnsignedShort();
            if (readUnsignedShort == f232C.f280a) {
                short readShort = c0058a.readShort();
                short readShort2 = c0058a.readShort();
                C0059b m2521d = C0059b.m2521d(readShort, this.f264f);
                C0059b m2521d2 = C0059b.m2521d(readShort2, this.f264f);
                this.f262d[0].put("ImageLength", m2521d);
                this.f262d[0].put("ImageWidth", m2521d2);
                return;
            }
            c0058a.skipBytes(readUnsignedShort2);
        }
    }

    /* renamed from: i */
    public final void m2537i(C0058a c0058a) {
        C0059b c0059b;
        m2532n(c0058a, c0058a.available());
        m2530p(c0058a, 0);
        m2527s(c0058a, 0);
        m2527s(c0058a, 5);
        m2527s(c0058a, 4);
        m2528r(0, 5);
        m2528r(0, 4);
        m2528r(5, 4);
        C0059b c0059b2 = this.f262d[1].get("PixelXDimension");
        C0059b c0059b3 = this.f262d[1].get("PixelYDimension");
        if (c0059b2 != null && c0059b3 != null) {
            this.f262d[0].put("ImageWidth", c0059b2);
            this.f262d[0].put("ImageLength", c0059b3);
        }
        if (this.f262d[4].isEmpty() && m2534l(this.f262d[5])) {
            HashMap<String, C0059b>[] hashMapArr = this.f262d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!m2534l(this.f262d[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        if (this.f261c != 8 || (c0059b = this.f262d[1].get("MakerNote")) == null) {
            return;
        }
        C0058a c0058a2 = new C0058a(c0059b.f279c);
        c0058a2.f274b = this.f264f;
        c0058a2.m2525F(6L);
        m2530p(c0058a2, 9);
        C0059b c0059b4 = this.f262d[9].get("ColorSpace");
        if (c0059b4 != null) {
            this.f262d[1].put("ColorSpace", c0059b4);
        }
    }

    /* renamed from: j */
    public final void m2536j(C0058a c0058a) {
        m2537i(c0058a);
        if (this.f262d[0].get("JpgFromRaw") != null) {
            m2541e(c0058a, this.f270l, 5);
        }
        C0059b c0059b = this.f262d[0].get("ISO");
        C0059b c0059b2 = this.f262d[1].get("PhotographicSensitivity");
        if (c0059b == null || c0059b2 != null) {
            return;
        }
        this.f262d[1].put("PhotographicSensitivity", c0059b);
    }

    /* renamed from: k */
    public final void m2535k(C0058a c0058a, HashMap hashMap) {
        int i;
        C0059b c0059b = (C0059b) hashMap.get("JPEGInterchangeFormat");
        C0059b c0059b2 = (C0059b) hashMap.get("JPEGInterchangeFormatLength");
        if (c0059b == null || c0059b2 == null) {
            return;
        }
        int m2519f = c0059b.m2519f(this.f264f);
        int min = Math.min(c0059b2.m2519f(this.f264f), c0058a.available() - m2519f);
        int i2 = this.f261c;
        if (i2 == 4 || i2 == 9 || i2 == 10) {
            i = this.f266h;
        } else {
            if (i2 == 7) {
                i = this.f267i;
            }
            if (m2519f > 0 || min <= 0 || this.f259a != null || this.f260b != null) {
                return;
            }
            c0058a.m2525F(m2519f);
            c0058a.readFully(new byte[min]);
            return;
        }
        m2519f += i;
        if (m2519f > 0) {
        }
    }

    /* renamed from: l */
    public final boolean m2534l(HashMap hashMap) {
        C0059b c0059b = (C0059b) hashMap.get("ImageLength");
        C0059b c0059b2 = (C0059b) hashMap.get("ImageWidth");
        if (c0059b == null || c0059b2 == null) {
            return false;
        }
        return c0059b.m2519f(this.f264f) <= 512 && c0059b2.m2519f(this.f264f) <= 512;
    }

    /* renamed from: m */
    public final void m2533m(InputStream inputStream) {
        for (int i = 0; i < f237H.length; i++) {
            try {
                this.f262d[i] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                m2545a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
        this.f261c = m2540f(bufferedInputStream);
        C0058a c0058a = new C0058a(bufferedInputStream);
        switch (this.f261c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                m2537i(c0058a);
                break;
            case 4:
                m2541e(c0058a, 0, 0);
                break;
            case 7:
                m2539g(c0058a);
                break;
            case 9:
                m2538h(c0058a);
                break;
            case 10:
                m2536j(c0058a);
                break;
        }
        m2529q(c0058a);
        m2545a();
    }

    /* renamed from: n */
    public final void m2532n(C0058a c0058a, int i) {
        ByteOrder m2531o = m2531o(c0058a);
        this.f264f = m2531o;
        c0058a.f274b = m2531o;
        int readUnsignedShort = c0058a.readUnsignedShort();
        int i2 = this.f261c;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            StringBuilder m253r = outline.m253r("Invalid start code: ");
            m253r.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(m253r.toString());
        }
        int readInt = c0058a.readInt();
        if (readInt >= 8 && readInt < i) {
            int i3 = readInt - 8;
            if (i3 > 0 && c0058a.skipBytes(i3) != i3) {
                throw new IOException(outline.m273H("Couldn't jump to first Ifd: ", i3));
            }
            return;
        }
        throw new IOException(outline.m273H("Invalid first Ifd offset: ", readInt));
    }

    /* renamed from: o */
    public final ByteOrder m2531o(C0058a c0058a) {
        short readShort = c0058a.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            StringBuilder m253r = outline.m253r("Invalid byte order: ");
            m253r.append(Integer.toHexString(readShort));
            throw new IOException(m253r.toString());
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011a  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2530p(p000.C0057C5.C0058a r24, int r25) {
        /*
            Method dump skipped, instructions count: 840
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0057C5.m2530p(C5$a, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (java.util.Arrays.equals(r1, p000.C0057C5.f248p) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (java.util.Arrays.equals(r1, r5) != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2529q(p000.C0057C5.C0058a r13) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0057C5.m2529q(C5$a):void");
    }

    /* renamed from: r */
    public final void m2528r(int i, int i2) {
        if (this.f262d[i].isEmpty() || this.f262d[i2].isEmpty()) {
            return;
        }
        C0059b c0059b = this.f262d[i].get("ImageLength");
        C0059b c0059b2 = this.f262d[i].get("ImageWidth");
        C0059b c0059b3 = this.f262d[i2].get("ImageLength");
        C0059b c0059b4 = this.f262d[i2].get("ImageWidth");
        if (c0059b == null || c0059b2 == null || c0059b3 == null || c0059b4 == null) {
            return;
        }
        int m2519f = c0059b.m2519f(this.f264f);
        int m2519f2 = c0059b2.m2519f(this.f264f);
        int m2519f3 = c0059b3.m2519f(this.f264f);
        int m2519f4 = c0059b4.m2519f(this.f264f);
        if (m2519f >= m2519f3 || m2519f2 >= m2519f4) {
            return;
        }
        HashMap<String, C0059b>[] hashMapArr = this.f262d;
        HashMap<String, C0059b> hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i2];
        hashMapArr[i2] = hashMap;
    }

    /* renamed from: s */
    public final void m2527s(C0058a c0058a, int i) {
        C0059b c0059b;
        C0059b m2521d;
        C0059b m2521d2;
        C0059b c0059b2 = this.f262d[i].get("DefaultCropSize");
        C0059b c0059b3 = this.f262d[i].get("SensorTopBorder");
        C0059b c0059b4 = this.f262d[i].get("SensorLeftBorder");
        C0059b c0059b5 = this.f262d[i].get("SensorBottomBorder");
        C0059b c0059b6 = this.f262d[i].get("SensorRightBorder");
        if (c0059b2 != null) {
            if (c0059b2.f277a == 5) {
                C0061d[] c0061dArr = (C0061d[]) c0059b2.m2517h(this.f264f);
                if (c0061dArr != null && c0061dArr.length == 2) {
                    m2521d = C0059b.m2522c(c0061dArr[0], this.f264f);
                    m2521d2 = C0059b.m2522c(c0061dArr[1], this.f264f);
                } else {
                    StringBuilder m253r = outline.m253r("Invalid crop size values. cropSize=");
                    m253r.append(Arrays.toString(c0061dArr));
                    Log.w("ExifInterface", m253r.toString());
                    return;
                }
            } else {
                int[] iArr = (int[]) c0059b2.m2517h(this.f264f);
                if (iArr != null && iArr.length == 2) {
                    m2521d = C0059b.m2521d(iArr[0], this.f264f);
                    m2521d2 = C0059b.m2521d(iArr[1], this.f264f);
                } else {
                    StringBuilder m253r2 = outline.m253r("Invalid crop size values. cropSize=");
                    m253r2.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", m253r2.toString());
                    return;
                }
            }
            this.f262d[i].put("ImageWidth", m2521d);
            this.f262d[i].put("ImageLength", m2521d2);
        } else if (c0059b3 != null && c0059b4 != null && c0059b5 != null && c0059b6 != null) {
            int m2519f = c0059b3.m2519f(this.f264f);
            int m2519f2 = c0059b5.m2519f(this.f264f);
            int m2519f3 = c0059b6.m2519f(this.f264f);
            int m2519f4 = c0059b4.m2519f(this.f264f);
            if (m2519f2 <= m2519f || m2519f3 <= m2519f4) {
                return;
            }
            C0059b m2521d3 = C0059b.m2521d(m2519f2 - m2519f, this.f264f);
            C0059b m2521d4 = C0059b.m2521d(m2519f3 - m2519f4, this.f264f);
            this.f262d[i].put("ImageLength", m2521d3);
            this.f262d[i].put("ImageWidth", m2521d4);
        } else {
            C0059b c0059b7 = this.f262d[i].get("ImageLength");
            C0059b c0059b8 = this.f262d[i].get("ImageWidth");
            if ((c0059b7 == null || c0059b8 == null) && (c0059b = this.f262d[i].get("JPEGInterchangeFormat")) != null) {
                m2541e(c0058a, c0059b.m2519f(this.f264f), i);
            }
        }
    }

    /* renamed from: C5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0058a extends InputStream implements DataInput {

        /* renamed from: f */
        public static final ByteOrder f271f = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: g */
        public static final ByteOrder f272g = ByteOrder.BIG_ENDIAN;

        /* renamed from: a */
        public DataInputStream f273a;

        /* renamed from: b */
        public ByteOrder f274b;

        /* renamed from: c */
        public final int f275c;

        /* renamed from: d */
        public int f276d;

        public C0058a(InputStream inputStream) {
            this.f274b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f273a = dataInputStream;
            int available = dataInputStream.available();
            this.f275c = available;
            this.f276d = 0;
            this.f273a.mark(available);
        }

        /* renamed from: E */
        public long m2526E() {
            return readInt() & 4294967295L;
        }

        /* renamed from: F */
        public void m2525F(long j) {
            int i = this.f276d;
            if (i > j) {
                this.f276d = 0;
                this.f273a.reset();
                this.f273a.mark(this.f275c);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f273a.available();
        }

        @Override // java.io.InputStream
        public int read() {
            this.f276d++;
            return this.f273a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f276d++;
            return this.f273a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            int i = this.f276d + 1;
            this.f276d = i;
            if (i <= this.f275c) {
                int read = this.f273a.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f276d += 2;
            return this.f273a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            int i3 = this.f276d + i2;
            this.f276d = i3;
            if (i3 <= this.f275c) {
                if (this.f273a.read(bArr, i, i2) != i2) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() {
            int i = this.f276d + 4;
            this.f276d = i;
            if (i <= this.f275c) {
                int read = this.f273a.read();
                int read2 = this.f273a.read();
                int read3 = this.f273a.read();
                int read4 = this.f273a.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f274b;
                    if (byteOrder == f271f) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f272g) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder m253r = outline.m253r("Invalid byte order: ");
                    m253r.append(this.f274b);
                    throw new IOException(m253r.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            int i = this.f276d + 8;
            this.f276d = i;
            if (i <= this.f275c) {
                int read = this.f273a.read();
                int read2 = this.f273a.read();
                int read3 = this.f273a.read();
                int read4 = this.f273a.read();
                int read5 = this.f273a.read();
                int read6 = this.f273a.read();
                int read7 = this.f273a.read();
                int read8 = this.f273a.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f274b;
                    if (byteOrder == f271f) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f272g) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    StringBuilder m253r = outline.m253r("Invalid byte order: ");
                    m253r.append(this.f274b);
                    throw new IOException(m253r.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            int i = this.f276d + 2;
            this.f276d = i;
            if (i <= this.f275c) {
                int read = this.f273a.read();
                int read2 = this.f273a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f274b;
                    if (byteOrder == f271f) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f272g) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder m253r = outline.m253r("Invalid byte order: ");
                    m253r.append(this.f274b);
                    throw new IOException(m253r.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f276d += 2;
            return this.f273a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f276d++;
            return this.f273a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            int i = this.f276d + 2;
            this.f276d = i;
            if (i <= this.f275c) {
                int read = this.f273a.read();
                int read2 = this.f273a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f274b;
                    if (byteOrder == f271f) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f272g) {
                        return (read << 8) + read2;
                    }
                    StringBuilder m253r = outline.m253r("Invalid byte order: ");
                    m253r.append(this.f274b);
                    throw new IOException(m253r.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int min = Math.min(i, this.f275c - this.f276d);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f273a.skipBytes(min - i2);
            }
            this.f276d += i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = this.f273a.read(bArr, i, i2);
            this.f276d += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            int length = this.f276d + bArr.length;
            this.f276d = length;
            if (length <= this.f275c) {
                if (this.f273a.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public C0058a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* renamed from: C5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0060c {

        /* renamed from: a */
        public final int f280a;

        /* renamed from: b */
        public final String f281b;

        /* renamed from: c */
        public final int f282c;

        /* renamed from: d */
        public final int f283d;

        public C0060c(String str, int i, int i2) {
            this.f281b = str;
            this.f280a = i;
            this.f282c = i2;
            this.f283d = -1;
        }

        public C0060c(String str, int i, int i2, int i3) {
            this.f281b = str;
            this.f280a = i;
            this.f282c = i2;
            this.f283d = i3;
        }
    }

    public C0057C5(InputStream inputStream) {
        C0060c[][] c0060cArr = f237H;
        this.f262d = new HashMap[c0060cArr.length];
        this.f263e = new HashSet(c0060cArr.length);
        this.f264f = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f259a = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f260b = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.f260b = null;
            }
            m2533m(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }
}
