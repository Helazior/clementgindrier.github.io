package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zae implements zai<Boolean> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* bridge */ /* synthetic */ Boolean zaa(FastParser fastParser, BufferedReader bufferedReader) {
        boolean zay;
        zay = fastParser.zay(bufferedReader, false);
        return Boolean.valueOf(zay);
    }
}
