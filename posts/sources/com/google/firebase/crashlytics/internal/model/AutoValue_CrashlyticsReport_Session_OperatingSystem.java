package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {
    private final String buildVersion;
    private final boolean jailbroken;
    private final int platform;
    private final String version;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {
        private String buildVersion;
        private Boolean jailbroken;
        private Integer platform;
        private String version;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem build() {
            String str = this.platform == null ? " platform" : "";
            if (this.version == null) {
                str = outline.m266e(str, " version");
            }
            if (this.buildVersion == null) {
                str = outline.m266e(str, " buildVersion");
            }
            if (this.jailbroken == null) {
                str = outline.m266e(str, " jailbroken");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue());
            }
            throw new IllegalStateException(outline.m266e("Missing required properties:", str));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.buildVersion = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z) {
            this.jailbroken = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder
        public CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            Objects.requireNonNull(str, "Null version");
            this.version = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.OperatingSystem) {
            CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
            return this.platform == operatingSystem.getPlatform() && this.version.equals(operatingSystem.getVersion()) && this.buildVersion.equals(operatingSystem.getBuildVersion()) && this.jailbroken == operatingSystem.isJailbroken();
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return ((((((this.platform ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ (this.jailbroken ? 1231 : 1237);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public boolean isJailbroken() {
        return this.jailbroken;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("OperatingSystem{platform=");
        m253r.append(this.platform);
        m253r.append(", version=");
        m253r.append(this.version);
        m253r.append(", buildVersion=");
        m253r.append(this.buildVersion);
        m253r.append(", jailbroken=");
        m253r.append(this.jailbroken);
        m253r.append("}");
        return m253r.toString();
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i, String str, String str2, boolean z) {
        this.platform = i;
        this.version = str;
        this.buildVersion = str2;
        this.jailbroken = z;
    }
}
