package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AutoValue_HeartBeatResult extends HeartBeatResult {
    private final HeartBeatInfo.HeartBeat heartBeat;
    private final long millis;
    private final String sdkName;

    public AutoValue_HeartBeatResult(String str, long j, HeartBeatInfo.HeartBeat heartBeat) {
        Objects.requireNonNull(str, "Null sdkName");
        this.sdkName = str;
        this.millis = j;
        Objects.requireNonNull(heartBeat, "Null heartBeat");
        this.heartBeat = heartBeat;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeartBeatResult) {
            HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
            return this.sdkName.equals(heartBeatResult.getSdkName()) && this.millis == heartBeatResult.getMillis() && this.heartBeat.equals(heartBeatResult.getHeartBeat());
        }
        return false;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public HeartBeatInfo.HeartBeat getHeartBeat() {
        return this.heartBeat;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public long getMillis() {
        return this.millis;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String getSdkName() {
        return this.sdkName;
    }

    public int hashCode() {
        long j = this.millis;
        return ((((this.sdkName.hashCode() ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.heartBeat.hashCode();
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("HeartBeatResult{sdkName=");
        m253r.append(this.sdkName);
        m253r.append(", millis=");
        m253r.append(this.millis);
        m253r.append(", heartBeat=");
        m253r.append(this.heartBeat);
        m253r.append("}");
        return m253r.toString();
    }
}
