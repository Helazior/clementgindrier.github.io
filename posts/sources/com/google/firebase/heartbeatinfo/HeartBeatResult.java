package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;

@AutoValue
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class HeartBeatResult {
    public static HeartBeatResult create(String str, long j, HeartBeatInfo.HeartBeat heartBeat) {
        return new AutoValue_HeartBeatResult(str, j, heartBeat);
    }

    public abstract HeartBeatInfo.HeartBeat getHeartBeat();

    public abstract long getMillis();

    public abstract String getSdkName();
}
