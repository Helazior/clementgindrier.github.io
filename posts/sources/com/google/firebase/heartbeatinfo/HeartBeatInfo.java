package com.google.firebase.heartbeatinfo;

import com.google.android.gms.tasks.Task;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface HeartBeatInfo {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        HeartBeat(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    Task<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo();

    HeartBeat getHeartBeatCode(String str);

    Task<Void> storeHeartBeatInfo(String str);
}
