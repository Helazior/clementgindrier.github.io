package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/* renamed from: C6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0062C6 {

    /* renamed from: a */
    public static final Set<File> f286a = new HashSet();

    /* renamed from: b */
    public static final boolean f287b;

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ".");
            String nextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (nextToken != null && nextToken2 != null) {
                try {
                    int parseInt = Integer.parseInt(nextToken);
                    int parseInt2 = Integer.parseInt(nextToken2);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder m252s = outline.m252s("VM with version ", property);
        m252s.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", m252s.toString());
        f287b = z;
    }

    /* renamed from: a */
    public static void m2516a(Object obj, String str, Object[] objArr) {
        Field m2513d = m2513d(obj, str);
        Object[] objArr2 = (Object[]) m2513d.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        m2513d.set(obj, objArr3);
    }

    /* renamed from: b */
    public static void m2515b(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder m253r = outline.m253r("Clearing old secondary dex dir (");
            m253r.append(file.getPath());
            m253r.append(").");
            Log.i("MultiDex", m253r.toString());
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                StringBuilder m253r2 = outline.m253r("Failed to list secondary dex dir content (");
                m253r2.append(file.getPath());
                m253r2.append(").");
                Log.w("MultiDex", m253r2.toString());
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder m253r3 = outline.m253r("Trying to delete old file ");
                m253r3.append(file2.getPath());
                m253r3.append(" of size ");
                m253r3.append(file2.length());
                Log.i("MultiDex", m253r3.toString());
                if (!file2.delete()) {
                    StringBuilder m253r4 = outline.m253r("Failed to delete old file ");
                    m253r4.append(file2.getPath());
                    Log.w("MultiDex", m253r4.toString());
                } else {
                    StringBuilder m253r5 = outline.m253r("Deleted old file ");
                    m253r5.append(file2.getPath());
                    Log.i("MultiDex", m253r5.toString());
                }
            }
            if (!file.delete()) {
                StringBuilder m253r6 = outline.m253r("Failed to delete secondary dex dir ");
                m253r6.append(file.getPath());
                Log.w("MultiDex", m253r6.toString());
                return;
            }
            StringBuilder m253r7 = outline.m253r("Deleted old secondary dex dir ");
            m253r7.append(file.getPath());
            Log.i("MultiDex", m253r7.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[Catch: all -> 0x00c5, DONT_GENERATE, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000b, B:10:0x0050, B:11:0x0054, B:19:0x0068, B:25:0x0076, B:26:0x007d, B:29:0x008d, B:37:0x00b5, B:41:0x00bc, B:43:0x00be, B:28:0x0081, B:14:0x0059, B:16:0x0060, B:31:0x009b, B:32:0x009f, B:36:0x00a6, B:44:0x00bf, B:21:0x006a), top: B:60:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x006e, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x000b, B:10:0x0050, B:11:0x0054, B:19:0x0068, B:25:0x0076, B:26:0x007d, B:29:0x008d, B:37:0x00b5, B:41:0x00bc, B:43:0x00be, B:28:0x0081, B:14:0x0059, B:16:0x0060, B:31:0x009b, B:32:0x009f, B:36:0x00a6, B:44:0x00bf, B:21:0x006a), top: B:60:0x0003 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2514c(android.content.Context r6, java.io.File r7, java.io.File r8, java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
            java.util.Set<java.io.File> r0 = p000.C0062C6.f286a
            monitor-enter(r0)
            boolean r1 = r0.contains(r7)     // Catch: java.lang.Throwable -> Lc5
            if (r1 == 0) goto Lb
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc5
            return
        Lb:
            r0.add(r7)     // Catch: java.lang.Throwable -> Lc5
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc5
            r3.<init>()     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lc5
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = ": SDK version higher than "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            r1 = 20
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = " should be backed by "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = "case here: java.vm.version=\""
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch: java.lang.Throwable -> Lc5
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = "\""
            r3.append(r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lc5
            android.util.Log.w(r2, r1)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r1 = "MultiDex"
            r2 = 0
            java.lang.ClassLoader r3 = r6.getClassLoader()     // Catch: java.lang.RuntimeException -> L5f java.lang.Throwable -> Lc5
            boolean r4 = r3 instanceof dalvik.system.BaseDexClassLoader     // Catch: java.lang.Throwable -> Lc5
            if (r4 == 0) goto L59
            goto L66
        L59:
            java.lang.String r3 = "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching."
            android.util.Log.e(r1, r3)     // Catch: java.lang.Throwable -> Lc5
            goto L65
        L5f:
            r3 = move-exception
            java.lang.String r4 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching."
            android.util.Log.w(r1, r4, r3)     // Catch: java.lang.Throwable -> Lc5
        L65:
            r3 = r2
        L66:
            if (r3 != 0) goto L6a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc5
            return
        L6a:
            m2515b(r6)     // Catch: java.lang.Throwable -> L6e
            goto L76
        L6e:
            r1 = move-exception
            java.lang.String r4 = "MultiDex"
            java.lang.String r5 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> Lc5
        L76:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r4 = "code_cache"
            r1.<init>(r8, r4)     // Catch: java.lang.Throwable -> Lc5
            m2510g(r1)     // Catch: java.io.IOException -> L81 java.lang.Throwable -> Lc5
            goto L8d
        L81:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lc5
            java.io.File r8 = r6.getFilesDir()     // Catch: java.lang.Throwable -> Lc5
            r1.<init>(r8, r4)     // Catch: java.lang.Throwable -> Lc5
            m2510g(r1)     // Catch: java.lang.Throwable -> Lc5
        L8d:
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> Lc5
            r8.<init>(r1, r9)     // Catch: java.lang.Throwable -> Lc5
            m2510g(r8)     // Catch: java.lang.Throwable -> Lc5
            E6 r9 = new E6     // Catch: java.lang.Throwable -> Lc5
            r9.<init>(r7, r8)     // Catch: java.lang.Throwable -> Lc5
            r7 = 0
            java.util.List r7 = r9.m2462I(r6, r10, r7)     // Catch: java.lang.Throwable -> Lc0
            m2511f(r3, r8, r7)     // Catch: java.io.IOException -> La3 java.lang.Throwable -> Lc0
            goto Lb5
        La3:
            r7 = move-exception
            if (r11 == 0) goto Lbf
            java.lang.String r11 = "MultiDex"
            java.lang.String r1 = "Failed to install extracted secondary dex files, retrying with forced extraction"
            android.util.Log.w(r11, r1, r7)     // Catch: java.lang.Throwable -> Lc0
            r7 = 1
            java.util.List r6 = r9.m2462I(r6, r10, r7)     // Catch: java.lang.Throwable -> Lc0
            m2511f(r3, r8, r6)     // Catch: java.lang.Throwable -> Lc0
        Lb5:
            r9.close()     // Catch: java.io.IOException -> Lb9 java.lang.Throwable -> Lc5
            goto Lba
        Lb9:
            r2 = move-exception
        Lba:
            if (r2 != 0) goto Lbe
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc5
            return
        Lbe:
            throw r2     // Catch: java.lang.Throwable -> Lc5
        Lbf:
            throw r7     // Catch: java.lang.Throwable -> Lc0
        Lc0:
            r6 = move-exception
            r9.close()     // Catch: java.io.IOException -> Lc4 java.lang.Throwable -> Lc5
        Lc4:
            throw r6     // Catch: java.lang.Throwable -> Lc5
        Lc5:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc5
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0062C6.m2514c(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    /* renamed from: d */
    public static Field m2513d(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        StringBuilder m251t = outline.m251t("Field ", str, " not found in ");
        m251t.append(obj.getClass());
        throw new NoSuchFieldException(m251t.toString());
    }

    /* renamed from: e */
    public static void m2512e(Context context) {
        ApplicationInfo applicationInfo;
        Log.i("MultiDex", "Installing application");
        if (f287b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            try {
                applicationInfo = context.getApplicationInfo();
            } catch (RuntimeException e) {
                Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            m2514c(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
            Log.i("MultiDex", "install done");
        } catch (Exception e2) {
            Log.e("MultiDex", "MultiDex installation failure", e2);
            StringBuilder m253r = outline.m253r("MultiDex installation failed (");
            m253r.append(e2.getMessage());
            m253r.append(").");
            throw new RuntimeException(m253r.toString());
        }
    }

    /* renamed from: f */
    public static void m2511f(ClassLoader classLoader, File file, List<? extends File> list) {
        IOException[] iOExceptionArr;
        if (list.isEmpty()) {
            return;
        }
        Object obj = m2513d(classLoader, "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        Class<?>[] clsArr = {ArrayList.class, File.class, ArrayList.class};
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("makeDexElements", clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                m2516a(obj, "dexElements", (Object[]) declaredMethod.invoke(obj, arrayList2, file, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                    }
                    Field m2513d = m2513d(obj, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr2 = (IOException[]) m2513d.get(obj);
                    if (iOExceptionArr2 == null) {
                        iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                    } else {
                        IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                        arrayList.toArray(iOExceptionArr3);
                        System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                        iOExceptionArr = iOExceptionArr3;
                    }
                    m2513d.set(obj, iOExceptionArr);
                    IOException iOException = new IOException("I/O exception during makeDexElement");
                    iOException.initCause((Throwable) arrayList.get(0));
                    throw iOException;
                }
                return;
            } catch (NoSuchMethodException unused) {
            }
        }
        StringBuilder m251t = outline.m251t("Method ", "makeDexElements", " with parameters ");
        m251t.append(Arrays.asList(clsArr));
        m251t.append(" not found in ");
        m251t.append(obj.getClass());
        throw new NoSuchMethodException(m251t.toString());
    }

    /* renamed from: g */
    public static void m2510g(File file) {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            StringBuilder m253r = outline.m253r("Failed to create dir ");
            m253r.append(file.getPath());
            m253r.append(". Parent file is null.");
            Log.e("MultiDex", m253r.toString());
        } else {
            StringBuilder m253r2 = outline.m253r("Failed to create dir ");
            m253r2.append(file.getPath());
            m253r2.append(". parent file is a dir ");
            m253r2.append(parentFile.isDirectory());
            m253r2.append(", a file ");
            m253r2.append(parentFile.isFile());
            m253r2.append(", exists ");
            m253r2.append(parentFile.exists());
            m253r2.append(", readable ");
            m253r2.append(parentFile.canRead());
            m253r2.append(", writable ");
            m253r2.append(parentFile.canWrite());
            Log.e("MultiDex", m253r2.toString());
        }
        StringBuilder m253r3 = outline.m253r("Failed to create directory ");
        m253r3.append(file.getPath());
        throw new IOException(m253r3.toString());
    }
}
