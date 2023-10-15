package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Set;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface EncodedDestination extends Destination {
    Set<Encoding> getSupportedEncodings();
}
