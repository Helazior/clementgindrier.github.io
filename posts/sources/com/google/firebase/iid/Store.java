package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C2307w3;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Store {
    public final Context context;
    public final SharedPreferences store;
    private final Map<String, Long> subtypeCreationTimes = new C2339x1();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Token {
        private static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        public final String appVersion;
        public final long timestamp;
        public final String token;

        private Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        public static String encode(String str, String str2, long j) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put(CrashlyticsController.FIREBASE_TIMESTAMP, j);
                return jSONObject.toString();
            } catch (JSONException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 24);
                sb.append("Failed to encode token: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }

        public static String getTokenOrNull(Token token) {
            if (token == null) {
                return null;
            }
            return token.token;
        }

        public static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("{")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new Token(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(CrashlyticsController.FIREBASE_TIMESTAMP));
                } catch (JSONException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 23);
                    sb.append("Failed to parse token: ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return null;
                }
            }
            return new Token(str, null, 0L);
        }

        public boolean needsRefresh(String str) {
            return System.currentTimeMillis() > this.timestamp + REFRESH_PERIOD_MILLIS || !str.equals(this.appVersion);
        }
    }

    public Store(Context context) {
        this.context = context;
        this.store = context.getSharedPreferences("com.google.android.gms.appid", 0);
        checkForRestore("com.google.android.gms.appid-no-backup");
    }

    private void checkForRestore(String str) {
        Context context = this.context;
        Object obj = C2307w3.f6741a;
        File file = new File(C2307w3.C2310c.m201c(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || isEmpty()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            deleteAll();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    public static String createSubtypeInfoKey(String str, String str2) {
        return outline.m262i(new StringBuilder(String.valueOf(str).length() + 6), str, "|S|cre");
    }

    private String createTokenKey(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(outline.m269b(String.valueOf(str).length(), 4, String.valueOf(str2).length(), String.valueOf(str3).length()));
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private long getCreationTimeFromSharedPreferences(String str) {
        String string = this.store.getString(createSubtypeInfoKey(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return 0L;
    }

    private long writeCreationTimeToSharedPreferences(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.store.contains(createSubtypeInfoKey(str, "cre"))) {
            SharedPreferences.Editor edit = this.store.edit();
            edit.putString(createSubtypeInfoKey(str, "cre"), String.valueOf(currentTimeMillis));
            edit.commit();
            return currentTimeMillis;
        }
        return getCreationTimeFromSharedPreferences(str);
    }

    public synchronized void deleteAll() {
        this.subtypeCreationTimes.clear();
        this.store.edit().clear().commit();
    }

    public synchronized void deleteToken(String str, String str2, String str3) {
        String createTokenKey = createTokenKey(str, str2, str3);
        SharedPreferences.Editor edit = this.store.edit();
        edit.remove(createTokenKey);
        edit.commit();
    }

    public synchronized long getCreationTime(String str) {
        Long l = this.subtypeCreationTimes.get(str);
        if (l != null) {
            return l.longValue();
        }
        return getCreationTimeFromSharedPreferences(str);
    }

    public synchronized Token getToken(String str, String str2, String str3) {
        return Token.parse(this.store.getString(createTokenKey(str, str2, str3), null));
    }

    public synchronized boolean isEmpty() {
        return this.store.getAll().isEmpty();
    }

    public synchronized void saveToken(String str, String str2, String str3, String str4, String str5) {
        String encode = Token.encode(str4, str5, System.currentTimeMillis());
        if (encode == null) {
            return;
        }
        SharedPreferences.Editor edit = this.store.edit();
        edit.putString(createTokenKey(str, str2, str3), encode);
        edit.commit();
    }

    public synchronized long setCreationTime(String str) {
        long writeCreationTimeToSharedPreferences;
        writeCreationTimeToSharedPreferences = writeCreationTimeToSharedPreferences(str);
        this.subtypeCreationTimes.put(str, Long.valueOf(writeCreationTimeToSharedPreferences));
        return writeCreationTimeToSharedPreferences;
    }
}
