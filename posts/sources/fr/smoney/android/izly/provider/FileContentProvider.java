package fr.smoney.android.izly.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FileContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete:Not supported by this provider");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (uri != null) {
            uri.getQuery();
            uri.toString();
        }
        throw new UnsupportedOperationException("GetType:Not supported by this provider");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert:Not supported by this provider");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.ParcelFileDescriptor openFile(android.net.Uri r5, java.lang.String r6) {
        /*
            r4 = this;
            r6 = 0
            if (r5 != 0) goto L4
            return r6
        L4:
            java.lang.String r0 = "content://fr.smoney.android.izly.provider.FileContentProvider/"
            java.lang.StringBuilder r0 = p000.outline.m253r(r0)
            android.content.Context r1 = r4.getContext()
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r1 = r1.getAbsolutePath()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r5.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r3 = "/attachment.jpg"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L71
            java.lang.String r1 = r5.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r3 = "/attachment.png"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L71
            java.lang.String r1 = r5.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "/attachment.tiff"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6f
            goto L71
        L6f:
            r0 = 1
            goto L72
        L71:
            r0 = 0
        L72:
            if (r0 == 0) goto L75
            return r6
        L75:
            java.io.File r6 = new java.io.File
            java.lang.String r5 = r5.getPath()
            r6.<init>(r5)
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r5 = android.os.ParcelFileDescriptor.open(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.provider.FileContentProvider.openFile(android.net.Uri, java.lang.String):android.os.ParcelFileDescriptor");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uri != null) {
            uri.getQuery();
            uri.toString();
            return null;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Update:Not supported by this provider");
    }
}
