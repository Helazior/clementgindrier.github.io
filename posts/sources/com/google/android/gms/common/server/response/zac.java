package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zac implements zai<Float> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Float zaa(FastParser fastParser, BufferedReader bufferedReader) {
        float zak;
        zak = fastParser.zak(bufferedReader);
        return Float.valueOf(zak);
    }
}
