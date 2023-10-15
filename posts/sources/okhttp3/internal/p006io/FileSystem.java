package okhttp3.internal.p006io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

/* renamed from: okhttp3.internal.io.FileSystem */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.p006io.FileSystem
        public InterfaceC0050Be appendingSink(File file) {
            try {
                return C2263te.m339a(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C2263te.m339a(file);
            }
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public void delete(File file) {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public void deleteContents(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public boolean exists(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public void rename(File file, File file2) {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public InterfaceC0050Be sink(File file) {
            try {
                return C2263te.m337c(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return C2263te.m337c(file);
            }
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.p006io.FileSystem
        public InterfaceC0073Ce source(File file) {
            Logger logger = C2263te.f6595a;
            if (file != null) {
                return C2263te.m334f(new FileInputStream(file));
            }
            throw new IllegalArgumentException("file == null");
        }
    };

    InterfaceC0050Be appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    InterfaceC0050Be sink(File file);

    long size(File file);

    InterfaceC0073Ce source(File file);
}
