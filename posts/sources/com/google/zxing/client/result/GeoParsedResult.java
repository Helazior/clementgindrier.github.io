package com.google.zxing.client.result;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class GeoParsedResult extends ParsedResult {
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final String query;

    public GeoParsedResult(double d, double d2, double d3, String str) {
        super(ParsedResultType.GEO);
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.query = str;
    }

    public double getAltitude() {
        return this.altitude;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.latitude);
        sb.append(", ");
        sb.append(this.longitude);
        if (this.altitude > ShadowDrawableWrapper.COS_45) {
            sb.append(", ");
            sb.append(this.altitude);
            sb.append('m');
        }
        if (this.query != null) {
            sb.append(" (");
            sb.append(this.query);
            sb.append(')');
        }
        return sb.toString();
    }

    public String getGeoURI() {
        StringBuilder m253r = outline.m253r("geo:");
        m253r.append(this.latitude);
        m253r.append(',');
        m253r.append(this.longitude);
        if (this.altitude > ShadowDrawableWrapper.COS_45) {
            m253r.append(',');
            m253r.append(this.altitude);
        }
        if (this.query != null) {
            m253r.append('?');
            m253r.append(this.query);
        }
        return m253r.toString();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getQuery() {
        return this.query;
    }
}
