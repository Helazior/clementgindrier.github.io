package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Utils {
    private static final int KEY_PADDING = 50;
    public static final char KEY_SEPARATOR = '\n';
    private static final int MAX_DISK_CACHE_SIZE = 52428800;
    private static final int MIN_DISK_CACHE_SIZE = 5242880;
    public static final String OWNER_DISPATCHER = "Dispatcher";
    public static final String OWNER_HUNTER = "Hunter";
    public static final String OWNER_MAIN = "Main";
    private static final String PICASSO_CACHE = "picasso-cache";
    public static final String THREAD_IDLE_NAME = "Picasso-Idle";
    public static final int THREAD_LEAK_CLEANING_MS = 1000;
    public static final String THREAD_PREFIX = "Picasso-";
    public static final String VERB_BATCHED = "batched";
    public static final String VERB_CANCELED = "canceled";
    public static final String VERB_CHANGED = "changed";
    public static final String VERB_COMPLETED = "completed";
    public static final String VERB_CREATED = "created";
    public static final String VERB_DECODED = "decoded";
    public static final String VERB_DELIVERED = "delivered";
    public static final String VERB_ENQUEUED = "enqueued";
    public static final String VERB_ERRORED = "errored";
    public static final String VERB_EXECUTING = "executing";
    public static final String VERB_IGNORED = "ignored";
    public static final String VERB_JOINED = "joined";
    public static final String VERB_PAUSED = "paused";
    public static final String VERB_REMOVED = "removed";
    public static final String VERB_REPLAYING = "replaying";
    public static final String VERB_RESUMED = "resumed";
    public static final String VERB_RETRYING = "retrying";
    public static final String VERB_TRANSFORMED = "transformed";
    public static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();
    private static final C2011ne WEBP_FILE_HEADER_RIFF = C2011ne.m557f("RIFF");
    private static final C2011ne WEBP_FILE_HEADER_WEBP = C2011ne.m557f("WEBP");

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class PicassoThread extends Thread {
        public PicassoThread(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class PicassoThreadFactory implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new PicassoThread(runnable);
        }
    }

    private Utils() {
    }

    @TargetApi(18)
    public static long calculateDiskCacheSize(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800L), 5242880L);
    }

    public static int calculateMemoryCacheSize(Context context) {
        ActivityManager activityManager = (ActivityManager) getService(context, "activity");
        return (int) ((((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * 1048576) / 7);
    }

    public static void checkMain() {
        if (!isMain()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static void checkNotMain() {
        if (isMain()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static File createDefaultCacheDir(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String createKey(Request request) {
        StringBuilder sb = MAIN_THREAD_KEY_BUILDER;
        String createKey = createKey(request, sb);
        sb.setLength(0);
        return createKey;
    }

    public static void flushStackLocalLeaks(Looper looper) {
        Handler handler = new Handler(looper) { // from class: com.squareup.picasso.Utils.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000L);
            }
        };
        handler.sendMessageDelayed(handler.obtainMessage(), 1000L);
    }

    public static int getBitmapBytes(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String getLogIdsForHunter(BitmapHunter bitmapHunter) {
        return getLogIdsForHunter(bitmapHunter, "");
    }

    public static int getResourceId(Resources resources, Request request) {
        Uri uri;
        int i = request.resourceId;
        if (i != 0 || (uri = request.uri) == null) {
            return i;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = request.uri.getPathSegments();
            if (pathSegments != null && !pathSegments.isEmpty()) {
                if (pathSegments.size() == 1) {
                    try {
                        return Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                        StringBuilder m253r = outline.m253r("Last path segment is not a resource ID: ");
                        m253r.append(request.uri);
                        throw new FileNotFoundException(m253r.toString());
                    }
                } else if (pathSegments.size() == 2) {
                    return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                } else {
                    StringBuilder m253r2 = outline.m253r("More than two path segments: ");
                    m253r2.append(request.uri);
                    throw new FileNotFoundException(m253r2.toString());
                }
            }
            StringBuilder m253r3 = outline.m253r("No path segments: ");
            m253r3.append(request.uri);
            throw new FileNotFoundException(m253r3.toString());
        }
        StringBuilder m253r4 = outline.m253r("No package provided: ");
        m253r4.append(request.uri);
        throw new FileNotFoundException(m253r4.toString());
    }

    public static Resources getResources(Context context, Request request) {
        Uri uri;
        if (request.resourceId == 0 && (uri = request.uri) != null) {
            String authority = uri.getAuthority();
            if (authority != null) {
                try {
                    return context.getPackageManager().getResourcesForApplication(authority);
                } catch (PackageManager.NameNotFoundException unused) {
                    StringBuilder m253r = outline.m253r("Unable to obtain resources for package: ");
                    m253r.append(request.uri);
                    throw new FileNotFoundException(m253r.toString());
                }
            }
            StringBuilder m253r2 = outline.m253r("No package provided: ");
            m253r2.append(request.uri);
            throw new FileNotFoundException(m253r2.toString());
        }
        return context.getResources();
    }

    public static <T> T getService(Context context, String str) {
        return (T) context.getSystemService(str);
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean isAirplaneModeOn(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (NullPointerException | SecurityException unused) {
            return false;
        }
    }

    public static boolean isMain() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isWebPFile(InterfaceC1987me interfaceC1987me) {
        return interfaceC1987me.mo96A(0L, WEBP_FILE_HEADER_RIFF) && interfaceC1987me.mo96A(8L, WEBP_FILE_HEADER_WEBP);
    }

    public static void log(String str, String str2, String str3) {
        log(str, str2, str3, "");
    }

    public static String getLogIdsForHunter(BitmapHunter bitmapHunter, String str) {
        StringBuilder sb = new StringBuilder(str);
        Action action = bitmapHunter.getAction();
        if (action != null) {
            sb.append(action.request.logId());
        }
        List<Action> actions = bitmapHunter.getActions();
        if (actions != null) {
            int size = actions.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || action != null) {
                    sb.append(", ");
                }
                sb.append(actions.get(i).request.logId());
            }
        }
        return sb.toString();
    }

    public static void log(String str, String str2, String str3, String str4) {
        Log.d(Picasso.TAG, String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4));
    }

    public static String createKey(Request request, StringBuilder sb) {
        String str = request.stableKey;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(request.stableKey);
        } else {
            Uri uri = request.uri;
            if (uri != null) {
                String uri2 = uri.toString();
                sb.ensureCapacity(uri2.length() + 50);
                sb.append(uri2);
            } else {
                sb.ensureCapacity(50);
                sb.append(request.resourceId);
            }
        }
        sb.append('\n');
        if (request.rotationDegrees != 0.0f) {
            sb.append("rotation:");
            sb.append(request.rotationDegrees);
            if (request.hasRotationPivot) {
                sb.append('@');
                sb.append(request.rotationPivotX);
                sb.append('x');
                sb.append(request.rotationPivotY);
            }
            sb.append('\n');
        }
        if (request.hasSize()) {
            sb.append("resize:");
            sb.append(request.targetWidth);
            sb.append('x');
            sb.append(request.targetHeight);
            sb.append('\n');
        }
        if (request.centerCrop) {
            sb.append("centerCrop:");
            sb.append(request.centerCropGravity);
            sb.append('\n');
        } else if (request.centerInside) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<Transformation> list = request.transformations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(request.transformations.get(i).key());
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
