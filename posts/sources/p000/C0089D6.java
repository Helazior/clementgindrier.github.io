package p000;

import java.io.File;
import java.io.FileFilter;

/* renamed from: D6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0089D6 implements FileFilter {
    public C0089D6(C0112E6 c0112e6) {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
