package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: E6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0112E6 implements Closeable {

    /* renamed from: a */
    public final File f388a;

    /* renamed from: b */
    public final long f389b;

    /* renamed from: c */
    public final File f390c;

    /* renamed from: d */
    public final RandomAccessFile f391d;

    /* renamed from: f */
    public final FileChannel f392f;

    /* renamed from: g */
    public final FileLock f393g;

    /* renamed from: E6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0113a extends File {

        /* renamed from: a */
        public long f394a;

        public C0113a(File file, String str) {
            super(file, str);
            this.f394a = -1L;
        }
    }

    public C0112E6(File file, File file2) {
        StringBuilder m253r = outline.m253r("MultiDexExtractor(");
        m253r.append(file.getPath());
        m253r.append(", ");
        m253r.append(file2.getPath());
        m253r.append(")");
        Log.i("MultiDex", m253r.toString());
        this.f388a = file;
        this.f390c = file2;
        this.f389b = m2463H(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f391d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f392f = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f393g = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                m2466E(this.f392f);
                throw e;
            } catch (Error e2) {
                e = e2;
                m2466E(this.f392f);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                m2466E(this.f392f);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            m2466E(this.f391d);
            throw e4;
        }
    }

    /* renamed from: E */
    public static void m2466E(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    /* renamed from: F */
    public static void m2465F(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(outline.m266e("tmp-", str), ".zip", file.getParentFile());
        StringBuilder m253r = outline.m253r("Extracting ");
        m253r.append(createTempFile.getPath());
        Log.i("MultiDex", m253r.toString());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } finally {
            m2466E(inputStream);
            createTempFile.delete();
        }
    }

    /* renamed from: G */
    public static long m2464G(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* renamed from: H */
    public static long m2463H(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            C0133F6 m2607w = LayoutInflater$Factory2C0000A.C0010h.m2607w(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j = m2607w.f442b;
            randomAccessFile.seek(m2607w.f441a);
            byte[] bArr = new byte[16384];
            int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
            while (read != -1) {
                crc32.update(bArr, 0, read);
                j -= read;
                if (j == 0) {
                    break;
                }
                read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j));
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    /* renamed from: L */
    public static void m2459L(Context context, String str, long j, long j2, List<C0113a> list) {
        SharedPreferences.Editor edit = context.getSharedPreferences("multidex.version", 4).edit();
        edit.putLong(str + CrashlyticsController.FIREBASE_TIMESTAMP, j);
        edit.putLong(outline.m262i(new StringBuilder(), str, "crc"), j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (C0113a c0113a : list) {
            edit.putLong(str + "dex.crc." + i, c0113a.f394a);
            edit.putLong(str + "dex.time." + i, c0113a.lastModified());
            i++;
        }
        edit.commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<? extends java.io.File> m2462I(android.content.Context r13, java.lang.String r14, boolean r15) {
        /*
            r12 = this;
            java.lang.String r0 = "MultiDexExtractor.load("
            java.lang.StringBuilder r0 = p000.outline.m253r(r0)
            java.io.File r1 = r12.f388a
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r15)
            r0.append(r1)
            r0.append(r14)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "MultiDex"
            android.util.Log.i(r1, r0)
            java.nio.channels.FileLock r0 = r12.f393g
            boolean r0 = r0.isValid()
            if (r0 == 0) goto Ld6
            if (r15 != 0) goto L9c
            java.io.File r0 = r12.f388a
            long r2 = r12.f389b
            r4 = 4
            java.lang.String r5 = "multidex.version"
            android.content.SharedPreferences r4 = r13.getSharedPreferences(r5, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r14)
            java.lang.String r6 = "timestamp"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = -1
            long r8 = r4.getLong(r5, r6)
            long r10 = m2464G(r0)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 != 0) goto L7b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            java.lang.String r5 = "crc"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            long r4 = r4.getLong(r0, r6)
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L79
            goto L7b
        L79:
            r0 = 0
            goto L7c
        L7b:
            r0 = 1
        L7c:
            if (r0 != 0) goto L9c
            java.util.List r13 = r12.m2461J(r13, r14)     // Catch: java.io.IOException -> L83
            goto Lbc
        L83:
            r15 = move-exception
            java.lang.String r0 = "Failed to reload existing extracted secondary dex files, falling back to fresh extraction"
            android.util.Log.w(r1, r0, r15)
            java.util.List r15 = r12.m2460K()
            java.io.File r0 = r12.f388a
            long r4 = m2464G(r0)
            long r6 = r12.f389b
            r2 = r13
            r3 = r14
            r8 = r15
            m2459L(r2, r3, r4, r6, r8)
            goto Lbb
        L9c:
            if (r15 == 0) goto La4
            java.lang.String r15 = "Forced extraction must be performed."
            android.util.Log.i(r1, r15)
            goto La9
        La4:
            java.lang.String r15 = "Detected that extraction must be performed."
            android.util.Log.i(r1, r15)
        La9:
            java.util.List r15 = r12.m2460K()
            java.io.File r0 = r12.f388a
            long r4 = m2464G(r0)
            long r6 = r12.f389b
            r2 = r13
            r3 = r14
            r8 = r15
            m2459L(r2, r3, r4, r6, r8)
        Lbb:
            r13 = r15
        Lbc:
            java.lang.String r14 = "load found "
            java.lang.StringBuilder r14 = p000.outline.m253r(r14)
            int r15 = r13.size()
            r14.append(r15)
            java.lang.String r15 = " secondary dex files"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            android.util.Log.i(r1, r14)
            return r13
        Ld6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "MultiDexExtractor was closed"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0112E6.m2462I(android.content.Context, java.lang.String, boolean):java.util.List");
    }

    /* renamed from: J */
    public final List<C0113a> m2461J(Context context, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f388a.getName() + ".classes";
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
        int i = sharedPreferences.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + (-1));
        int i2 = 2;
        while (i2 <= i) {
            C0113a c0113a = new C0113a(this.f390c, str2 + i2 + ".zip");
            if (c0113a.isFile()) {
                c0113a.f394a = m2463H(c0113a);
                long j = sharedPreferences.getLong(str + "dex.crc." + i2, -1L);
                long j2 = sharedPreferences.getLong(str + "dex.time." + i2, -1L);
                long lastModified = c0113a.lastModified();
                if (j2 == lastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences2 = sharedPreferences;
                    if (j == c0113a.f394a) {
                        arrayList.add(c0113a);
                        i2++;
                        sharedPreferences = sharedPreferences2;
                        str2 = str3;
                    }
                }
                throw new IOException("Invalid extracted dex: " + c0113a + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + c0113a.f394a);
            }
            StringBuilder m253r = outline.m253r("Missing extracted secondary dex file '");
            m253r.append(c0113a.getPath());
            m253r.append("'");
            throw new IOException(m253r.toString());
        }
        return arrayList;
    }

    /* renamed from: K */
    public final List<C0113a> m2460K() {
        String str = this.f388a.getName() + ".classes";
        File[] listFiles = this.f390c.listFiles(new C0089D6(this));
        if (listFiles == null) {
            StringBuilder m253r = outline.m253r("Failed to list secondary dex dir content (");
            m253r.append(this.f390c.getPath());
            m253r.append(").");
            Log.w("MultiDex", m253r.toString());
        } else {
            for (File file : listFiles) {
                StringBuilder m253r2 = outline.m253r("Trying to delete old file ");
                m253r2.append(file.getPath());
                m253r2.append(" of size ");
                m253r2.append(file.length());
                Log.i("MultiDex", m253r2.toString());
                if (!file.delete()) {
                    StringBuilder m253r3 = outline.m253r("Failed to delete old file ");
                    m253r3.append(file.getPath());
                    Log.w("MultiDex", m253r3.toString());
                } else {
                    StringBuilder m253r4 = outline.m253r("Deleted old file ");
                    m253r4.append(file.getPath());
                    Log.i("MultiDex", m253r4.toString());
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f388a);
        int i = 2;
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            while (entry != null) {
                C0113a c0113a = new C0113a(this.f390c, str + i + ".zip");
                arrayList.add(c0113a);
                Log.i("MultiDex", "Extraction is needed for file " + c0113a);
                int i2 = 0;
                boolean z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    m2465F(zipFile, entry, c0113a, str);
                    try {
                        c0113a.f394a = m2463H(c0113a);
                        z = true;
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to read crc from " + c0113a.getAbsolutePath(), e);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(c0113a.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0113a.length());
                    sb.append(" - crc: ");
                    sb.append(c0113a.f394a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        c0113a.delete();
                        if (c0113a.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0113a.getPath() + "'");
                        }
                    }
                }
                if (!z) {
                    throw new IOException("Could not create zip file " + c0113a.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                i++;
                entry = zipFile.getEntry("classes" + i + ".dex");
            }
            return arrayList;
        } finally {
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f393g.release();
        this.f392f.close();
        this.f391d.close();
    }
}
