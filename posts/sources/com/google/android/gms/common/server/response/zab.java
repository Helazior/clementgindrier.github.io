package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zab implements zai<Long> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Long zaa(FastParser fastParser, BufferedReader bufferedReader) {
        long zan;
        zan = fastParser.zan(bufferedReader);
        return Long.valueOf(zan);
    }
}
