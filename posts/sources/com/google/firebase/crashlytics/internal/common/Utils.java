package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Utils {
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    private Utils() {
    }

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, Utils$$Lambda$1.lambdaFactory$(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (!task.isCanceled()) {
            if (task.isComplete()) {
                throw new IllegalStateException(task.getException());
            }
            throw new TimeoutException();
        }
        throw new CancellationException("Task is already canceled");
    }

    public static <T> Task<T> callTask(Executor executor, final Callable<Task<T>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.Utils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((Task) callable.call()).continueWith(new Continuation<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.Utils.2.1
                        @Override // com.google.android.gms.tasks.Continuation
                        public Void then(Task<T> task) {
                            if (task.isSuccessful()) {
                                taskCompletionSource.setResult(task.getResult());
                                return null;
                            }
                            taskCompletionSource.setException(task.getException());
                            return null;
                        }
                    });
                } catch (Exception e) {
                    taskCompletionSource.setException(e);
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Continuation continuation = (Continuation<T, Void>) new Continuation<T, Void>() { // from class: com.google.firebase.crashlytics.internal.common.Utils.1
            @Override // com.google.android.gms.tasks.Continuation
            public Void then(Task<T> task3) {
                if (task3.isSuccessful()) {
                    TaskCompletionSource.this.trySetResult(task3.getResult());
                    return null;
                }
                TaskCompletionSource.this.trySetException(task3.getException());
                return null;
            }
        };
        task.continueWith(continuation);
        task2.continueWith(continuation);
        return taskCompletionSource.getTask();
    }
}
