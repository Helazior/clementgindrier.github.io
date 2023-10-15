package okhttp3.internal;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class NamedRunnable implements Runnable {
    public final String name;

    public NamedRunnable(String str, Object... objArr) {
        this.name = Util.format(str, objArr);
    }

    public abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
