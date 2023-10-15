package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.squareup.picasso.Action;
import com.squareup.picasso.RemoteViewsAction;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Picasso {
    public static final String TAG = "Picasso";
    public final Cache cache;
    private final CleanupThread cleanupThread;
    public final Context context;
    public final Bitmap.Config defaultBitmapConfig;
    public final Dispatcher dispatcher;
    public boolean indicatorsEnabled;
    private final Listener listener;
    public volatile boolean loggingEnabled;
    public final ReferenceQueue<Object> referenceQueue;
    private final List<RequestHandler> requestHandlers;
    private final RequestTransformer requestTransformer;
    public boolean shutdown;
    public final Stats stats;
    public final Map<Object, Action> targetToAction;
    public final Map<ImageView, DeferredRequestCreator> targetToDeferredRequestCreator;
    public static final Handler HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.squareup.picasso.Picasso.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                Action action = (Action) message.obj;
                if (action.getPicasso().loggingEnabled) {
                    Utils.log(Utils.OWNER_MAIN, Utils.VERB_CANCELED, action.request.logId(), "target got garbage collected");
                }
                action.picasso.cancelExistingRequest(action.getTarget());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    BitmapHunter bitmapHunter = (BitmapHunter) list.get(i2);
                    bitmapHunter.picasso.complete(bitmapHunter);
                    i2++;
                }
            } else if (i == 13) {
                List list2 = (List) message.obj;
                int size2 = list2.size();
                while (i2 < size2) {
                    Action action2 = (Action) list2.get(i2);
                    action2.picasso.resumeAction(action2);
                    i2++;
                }
            } else {
                StringBuilder m253r = outline.m253r("Unknown handler message received: ");
                m253r.append(message.what);
                throw new AssertionError(m253r.toString());
            }
        }
    };
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Picasso singleton = null;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Builder {
        private Cache cache;
        private final Context context;
        private Bitmap.Config defaultBitmapConfig;
        private Downloader downloader;
        private boolean indicatorsEnabled;
        private Listener listener;
        private boolean loggingEnabled;
        private List<RequestHandler> requestHandlers;
        private ExecutorService service;
        private RequestTransformer transformer;

        public Builder(Context context) {
            if (context != null) {
                this.context = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public Builder addRequestHandler(RequestHandler requestHandler) {
            if (requestHandler != null) {
                if (this.requestHandlers == null) {
                    this.requestHandlers = new ArrayList();
                }
                if (!this.requestHandlers.contains(requestHandler)) {
                    this.requestHandlers.add(requestHandler);
                    return this;
                }
                throw new IllegalStateException("RequestHandler already registered.");
            }
            throw new IllegalArgumentException("RequestHandler must not be null.");
        }

        public Picasso build() {
            Context context = this.context;
            if (this.downloader == null) {
                this.downloader = new OkHttp3Downloader(context);
            }
            if (this.cache == null) {
                this.cache = new LruCache(context);
            }
            if (this.service == null) {
                this.service = new PicassoExecutorService();
            }
            if (this.transformer == null) {
                this.transformer = RequestTransformer.IDENTITY;
            }
            Stats stats = new Stats(this.cache);
            return new Picasso(context, new Dispatcher(context, this.service, Picasso.HANDLER, this.downloader, this.cache, stats), this.cache, this.listener, this.transformer, this.requestHandlers, stats, this.defaultBitmapConfig, this.indicatorsEnabled, this.loggingEnabled);
        }

        public Builder defaultBitmapConfig(Bitmap.Config config) {
            if (config != null) {
                this.defaultBitmapConfig = config;
                return this;
            }
            throw new IllegalArgumentException("Bitmap config must not be null.");
        }

        public Builder downloader(Downloader downloader) {
            if (downloader != null) {
                if (this.downloader == null) {
                    this.downloader = downloader;
                    return this;
                }
                throw new IllegalStateException("Downloader already set.");
            }
            throw new IllegalArgumentException("Downloader must not be null.");
        }

        public Builder executor(ExecutorService executorService) {
            if (executorService != null) {
                if (this.service == null) {
                    this.service = executorService;
                    return this;
                }
                throw new IllegalStateException("Executor service already set.");
            }
            throw new IllegalArgumentException("Executor service must not be null.");
        }

        public Builder indicatorsEnabled(boolean z) {
            this.indicatorsEnabled = z;
            return this;
        }

        public Builder listener(Listener listener) {
            if (listener != null) {
                if (this.listener == null) {
                    this.listener = listener;
                    return this;
                }
                throw new IllegalStateException("Listener already set.");
            }
            throw new IllegalArgumentException("Listener must not be null.");
        }

        public Builder loggingEnabled(boolean z) {
            this.loggingEnabled = z;
            return this;
        }

        public Builder memoryCache(Cache cache) {
            if (cache != null) {
                if (this.cache == null) {
                    this.cache = cache;
                    return this;
                }
                throw new IllegalStateException("Memory cache already set.");
            }
            throw new IllegalArgumentException("Memory cache must not be null.");
        }

        public Builder requestTransformer(RequestTransformer requestTransformer) {
            if (requestTransformer != null) {
                if (this.transformer == null) {
                    this.transformer = requestTransformer;
                    return this;
                }
                throw new IllegalStateException("Transformer already set.");
            }
            throw new IllegalArgumentException("Transformer must not be null.");
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CleanupThread extends Thread {
        private final Handler handler;
        private final ReferenceQueue<Object> referenceQueue;

        public CleanupThread(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.referenceQueue = referenceQueue;
            this.handler = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    Action.RequestWeakReference requestWeakReference = (Action.RequestWeakReference) this.referenceQueue.remove(1000L);
                    Message obtainMessage = this.handler.obtainMessage();
                    if (requestWeakReference != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = requestWeakReference.action;
                        this.handler.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.handler.post(new Runnable() { // from class: com.squareup.picasso.Picasso.CleanupThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                    return;
                }
            }
        }

        public void shutdown() {
            interrupt();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface Listener {
        void onImageLoadFailed(Picasso picasso, Uri uri, Exception exc);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        public final int debugColor;

        LoadedFrom(int i) {
            this.debugColor = i;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface RequestTransformer {
        public static final RequestTransformer IDENTITY = new RequestTransformer() { // from class: com.squareup.picasso.Picasso.RequestTransformer.1
            @Override // com.squareup.picasso.Picasso.RequestTransformer
            public Request transformRequest(Request request) {
                return request;
            }
        };

        Request transformRequest(Request request);
    }

    public Picasso(Context context, Dispatcher dispatcher, Cache cache, Listener listener, RequestTransformer requestTransformer, List<RequestHandler> list, Stats stats, Bitmap.Config config, boolean z, boolean z2) {
        this.context = context;
        this.dispatcher = dispatcher;
        this.cache = cache;
        this.listener = listener;
        this.requestTransformer = requestTransformer;
        this.defaultBitmapConfig = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new ResourceRequestHandler(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new ContactsPhotoRequestHandler(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new ContentStreamRequestHandler(context));
        arrayList.add(new AssetRequestHandler(context));
        arrayList.add(new FileRequestHandler(context));
        arrayList.add(new NetworkRequestHandler(dispatcher.downloader, stats));
        this.requestHandlers = Collections.unmodifiableList(arrayList);
        this.stats = stats;
        this.targetToAction = new WeakHashMap();
        this.targetToDeferredRequestCreator = new WeakHashMap();
        this.indicatorsEnabled = z;
        this.loggingEnabled = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.referenceQueue = referenceQueue;
        CleanupThread cleanupThread = new CleanupThread(referenceQueue, HANDLER);
        this.cleanupThread = cleanupThread;
        cleanupThread.start();
    }

    private void deliverAction(Bitmap bitmap, LoadedFrom loadedFrom, Action action, Exception exc) {
        if (action.isCancelled()) {
            return;
        }
        if (!action.willReplay()) {
            this.targetToAction.remove(action.getTarget());
        }
        if (bitmap == null) {
            action.error(exc);
            if (this.loggingEnabled) {
                Utils.log(Utils.OWNER_MAIN, Utils.VERB_ERRORED, action.request.logId(), exc.getMessage());
            }
        } else if (loadedFrom != null) {
            action.complete(bitmap, loadedFrom);
            if (this.loggingEnabled) {
                String logId = action.request.logId();
                Utils.log(Utils.OWNER_MAIN, Utils.VERB_COMPLETED, logId, "from " + loadedFrom);
            }
        } else {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
    }

    public static Picasso get() {
        if (singleton == null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    Context context = PicassoProvider.context;
                    if (context != null) {
                        singleton = new Builder(context).build();
                    } else {
                        throw new IllegalStateException("context == null");
                    }
                }
            }
        }
        return singleton;
    }

    public static void setSingletonInstance(Picasso picasso) {
        if (picasso != null) {
            synchronized (Picasso.class) {
                if (singleton == null) {
                    singleton = picasso;
                } else {
                    throw new IllegalStateException("Singleton instance already exists.");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Picasso must not be null.");
    }

    public boolean areIndicatorsEnabled() {
        return this.indicatorsEnabled;
    }

    public void cancelExistingRequest(Object obj) {
        Utils.checkMain();
        Action remove = this.targetToAction.remove(obj);
        if (remove != null) {
            remove.cancel();
            this.dispatcher.dispatchCancel(remove);
        }
        if (obj instanceof ImageView) {
            DeferredRequestCreator remove2 = this.targetToDeferredRequestCreator.remove((ImageView) obj);
            if (remove2 != null) {
                remove2.cancel();
            }
        }
    }

    public void cancelRequest(ImageView imageView) {
        if (imageView != null) {
            cancelExistingRequest(imageView);
            return;
        }
        throw new IllegalArgumentException("view cannot be null.");
    }

    public void cancelTag(Object obj) {
        Utils.checkMain();
        if (obj != null) {
            ArrayList arrayList = new ArrayList(this.targetToAction.values());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Action action = (Action) arrayList.get(i);
                if (obj.equals(action.getTag())) {
                    cancelExistingRequest(action.getTarget());
                }
            }
            ArrayList arrayList2 = new ArrayList(this.targetToDeferredRequestCreator.values());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                DeferredRequestCreator deferredRequestCreator = (DeferredRequestCreator) arrayList2.get(i2);
                if (obj.equals(deferredRequestCreator.getTag())) {
                    deferredRequestCreator.cancel();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Cannot cancel requests with null tag.");
    }

    public void complete(BitmapHunter bitmapHunter) {
        Action action = bitmapHunter.getAction();
        List<Action> actions = bitmapHunter.getActions();
        boolean z = true;
        boolean z2 = (actions == null || actions.isEmpty()) ? false : true;
        if (action == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = bitmapHunter.getData().uri;
            Exception exception = bitmapHunter.getException();
            Bitmap result = bitmapHunter.getResult();
            LoadedFrom loadedFrom = bitmapHunter.getLoadedFrom();
            if (action != null) {
                deliverAction(result, loadedFrom, action, exception);
            }
            if (z2) {
                int size = actions.size();
                for (int i = 0; i < size; i++) {
                    deliverAction(result, loadedFrom, actions.get(i), exception);
                }
            }
            Listener listener = this.listener;
            if (listener == null || exception == null) {
                return;
            }
            listener.onImageLoadFailed(this, uri, exception);
        }
    }

    public void defer(ImageView imageView, DeferredRequestCreator deferredRequestCreator) {
        if (this.targetToDeferredRequestCreator.containsKey(imageView)) {
            cancelExistingRequest(imageView);
        }
        this.targetToDeferredRequestCreator.put(imageView, deferredRequestCreator);
    }

    public void enqueueAndSubmit(Action action) {
        Object target = action.getTarget();
        if (target != null && this.targetToAction.get(target) != action) {
            cancelExistingRequest(target);
            this.targetToAction.put(target, action);
        }
        submit(action);
    }

    public List<RequestHandler> getRequestHandlers() {
        return this.requestHandlers;
    }

    public StatsSnapshot getSnapshot() {
        return this.stats.createSnapshot();
    }

    public void invalidate(Uri uri) {
        if (uri != null) {
            this.cache.clearKeyUri(uri.toString());
        }
    }

    public boolean isLoggingEnabled() {
        return this.loggingEnabled;
    }

    public RequestCreator load(Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public void pauseTag(Object obj) {
        if (obj != null) {
            this.dispatcher.dispatchPauseTag(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public Bitmap quickMemoryCacheCheck(String str) {
        Bitmap bitmap = this.cache.get(str);
        if (bitmap != null) {
            this.stats.dispatchCacheHit();
        } else {
            this.stats.dispatchCacheMiss();
        }
        return bitmap;
    }

    public void resumeAction(Action action) {
        Bitmap quickMemoryCacheCheck = MemoryPolicy.shouldReadFromMemoryCache(action.memoryPolicy) ? quickMemoryCacheCheck(action.getKey()) : null;
        if (quickMemoryCacheCheck != null) {
            LoadedFrom loadedFrom = LoadedFrom.MEMORY;
            deliverAction(quickMemoryCacheCheck, loadedFrom, action, null);
            if (this.loggingEnabled) {
                String logId = action.request.logId();
                Utils.log(Utils.OWNER_MAIN, Utils.VERB_COMPLETED, logId, "from " + loadedFrom);
                return;
            }
            return;
        }
        enqueueAndSubmit(action);
        if (this.loggingEnabled) {
            Utils.log(Utils.OWNER_MAIN, Utils.VERB_RESUMED, action.request.logId());
        }
    }

    public void resumeTag(Object obj) {
        if (obj != null) {
            this.dispatcher.dispatchResumeTag(obj);
            return;
        }
        throw new IllegalArgumentException("tag == null");
    }

    public void setIndicatorsEnabled(boolean z) {
        this.indicatorsEnabled = z;
    }

    public void setLoggingEnabled(boolean z) {
        this.loggingEnabled = z;
    }

    public void shutdown() {
        if (this != singleton) {
            if (this.shutdown) {
                return;
            }
            this.cache.clear();
            this.cleanupThread.shutdown();
            this.stats.shutdown();
            this.dispatcher.shutdown();
            for (DeferredRequestCreator deferredRequestCreator : this.targetToDeferredRequestCreator.values()) {
                deferredRequestCreator.cancel();
            }
            this.targetToDeferredRequestCreator.clear();
            this.shutdown = true;
            return;
        }
        throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
    }

    public void submit(Action action) {
        this.dispatcher.dispatchSubmit(action);
    }

    public Request transformRequest(Request request) {
        Request transformRequest = this.requestTransformer.transformRequest(request);
        if (transformRequest != null) {
            return transformRequest;
        }
        StringBuilder m253r = outline.m253r("Request transformer ");
        m253r.append(this.requestTransformer.getClass().getCanonicalName());
        m253r.append(" returned null for ");
        m253r.append(request);
        throw new IllegalStateException(m253r.toString());
    }

    public void invalidate(String str) {
        if (str != null) {
            invalidate(Uri.parse(str));
        }
    }

    public RequestCreator load(String str) {
        if (str == null) {
            return new RequestCreator(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return load(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public void cancelRequest(Target target) {
        if (target != null) {
            cancelExistingRequest(target);
            return;
        }
        throw new IllegalArgumentException("target cannot be null.");
    }

    public void invalidate(File file) {
        if (file != null) {
            invalidate(Uri.fromFile(file));
            return;
        }
        throw new IllegalArgumentException("file == null");
    }

    public void cancelRequest(RemoteViews remoteViews, int i) {
        if (remoteViews != null) {
            cancelExistingRequest(new RemoteViewsAction.RemoteViewsTarget(remoteViews, i));
            return;
        }
        throw new IllegalArgumentException("remoteViews cannot be null.");
    }

    public RequestCreator load(File file) {
        if (file == null) {
            return new RequestCreator(this, null, 0);
        }
        return load(Uri.fromFile(file));
    }

    public RequestCreator load(int i) {
        if (i != 0) {
            return new RequestCreator(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }
}
