package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import p000.C0057C5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FileRequestHandler extends ContentStreamRequestHandler {
    public FileRequestHandler(Context context) {
        super(context);
    }

    public static int getFileExifRotation(Uri uri) {
        C0057C5 c0057c5 = new C0057C5(uri.getPath());
        C0057C5.C0059b m2542d = c0057c5.m2542d("Orientation");
        if (m2542d != null) {
            try {
                return m2542d.m2519f(c0057c5.f264f);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }
        return 1;
    }

    @Override // com.squareup.picasso.ContentStreamRequestHandler, com.squareup.picasso.RequestHandler
    public boolean canHandleRequest(Request request) {
        return "file".equals(request.uri.getScheme());
    }

    @Override // com.squareup.picasso.ContentStreamRequestHandler, com.squareup.picasso.RequestHandler
    public RequestHandler.Result load(Request request, int i) {
        return new RequestHandler.Result(null, C2263te.m334f(getInputStream(request)), Picasso.LoadedFrom.DISK, getFileExifRotation(request.uri));
    }
}
