package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zad implements zai<Double> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* synthetic */ Double zaa(FastParser fastParser, BufferedReader bufferedReader) {
        double zaj;
        zaj = fastParser.zaj(bufferedReader);
        return Double.valueOf(zaj);
    }
}
