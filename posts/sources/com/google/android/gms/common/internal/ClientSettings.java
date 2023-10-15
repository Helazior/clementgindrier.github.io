package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
@KeepForSdk
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ClientSettings {
    @Nullable
    private final Account zaa;
    private final Set<Scope> zab;
    private final Set<Scope> zac;
    private final Map<Api<?>, zab> zad;
    private final int zae;
    @Nullable
    private final View zaf;
    private final String zag;
    private final String zah;
    private final SignInOptions zai;
    private Integer zaj;

    @KeepForSdk
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Builder {
        @Nullable
        private Account zaa;
        private C2396z1<Scope> zab;
        private String zac;
        private String zad;
        private SignInOptions zae = SignInOptions.zaa;

        @KeepForSdk
        public ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, null, 0, null, this.zac, this.zad, this.zae, false);
        }

        @KeepForSdk
        public Builder setRealClientPackageName(String str) {
            this.zac = str;
            return this;
        }

        public final Builder zaa(Collection<Scope> collection) {
            if (this.zab == null) {
                this.zab = new C2396z1<>(0);
            }
            this.zab.addAll(collection);
            return this;
        }

        public final Builder zab(@Nullable Account account) {
            this.zaa = account;
            return this;
        }

        public final Builder zac(String str) {
            this.zad = str;
            return this;
        }
    }

    @KeepForSdk
    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, zab> map, int i, @Nullable View view, String str, String str2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, i, view, str, str2, signInOptions, false);
    }

    @KeepForSdk
    public static ClientSettings createDefault(Context context) {
        return new GoogleApiClient.Builder(context).zaa();
    }

    @KeepForSdk
    public Account getAccount() {
        return this.zaa;
    }

    @KeepForSdk
    @Deprecated
    public String getAccountName() {
        Account account = this.zaa;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @KeepForSdk
    public Account getAccountOrDefault() {
        Account account = this.zaa;
        return account != null ? account : new Account("<<default account>>", AccountType.GOOGLE);
    }

    @KeepForSdk
    public Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    @KeepForSdk
    public Set<Scope> getApplicableScopes(Api<?> api) {
        zab zabVar = this.zad.get(api);
        if (zabVar != null && !zabVar.zaa.isEmpty()) {
            HashSet hashSet = new HashSet(this.zab);
            hashSet.addAll(zabVar.zaa);
            return hashSet;
        }
        return this.zab;
    }

    @KeepForSdk
    public int getGravityForPopups() {
        return this.zae;
    }

    @KeepForSdk
    public String getRealClientPackageName() {
        return this.zag;
    }

    @KeepForSdk
    public Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    @KeepForSdk
    public View getViewForPopups() {
        return this.zaf;
    }

    public final SignInOptions zaa() {
        return this.zai;
    }

    public final Integer zab() {
        return this.zaj;
    }

    public final String zac() {
        return this.zah;
    }

    public final Map<Api<?>, zab> zad() {
        return this.zad;
    }

    public final void zae(Integer num) {
        this.zaj = num;
    }

    public ClientSettings(@Nullable Account account, Set<Scope> set, Map<Api<?>, zab> map, int i, @Nullable View view, String str, String str2, @Nullable SignInOptions signInOptions, boolean z) {
        this.zaa = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zab = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.zad = map;
        this.zaf = view;
        this.zae = i;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(emptySet);
        for (zab zabVar : map.values()) {
            hashSet.addAll(zabVar.zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
