package okhttp3;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Request {
    @Nullable
    public final RequestBody body;
    private volatile CacheControl cacheControl;
    public final Headers headers;
    public final String method;
    public final Object tag;
    public final HttpUrl url;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Builder {
        public RequestBody body;
        public Headers.Builder headers;
        public String method;
        public Object tag;
        public HttpUrl url;

        public Builder() {
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() != 0) {
                if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                    throw new IllegalArgumentException(outline.m265f("method ", str, " must not have a request body."));
                }
                if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                    throw new IllegalArgumentException(outline.m265f("method ", str, " must have a request body."));
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.length() == 0");
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder tag(Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder url(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "url == null");
            this.url = httpUrl;
            return this;
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder url(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                StringBuilder m253r = outline.m253r("http:");
                m253r.append(str.substring(3));
                str = m253r.toString();
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                StringBuilder m253r2 = outline.m253r("https:");
                m253r2.append(str.substring(4));
                str = m253r2.toString();
            }
            HttpUrl parse = HttpUrl.parse(str);
            if (parse != null) {
                return url(parse);
            }
            throw new IllegalArgumentException(outline.m266e("unexpected url: ", str));
        }

        public Builder(Request request) {
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tag = request.tag;
            this.headers = request.headers.newBuilder();
        }

        public Builder url(URL url) {
            Objects.requireNonNull(url, "url == null");
            HttpUrl httpUrl = HttpUrl.get(url);
            if (httpUrl != null) {
                return url(httpUrl);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }
    }

    public Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        Object obj = builder.tag;
        this.tag = obj == null ? this : obj;
    }

    @Nullable
    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.headers);
        this.cacheControl = parse;
        return parse;
    }

    @Nullable
    public String header(String str) {
        return this.headers.get(str);
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Object tag() {
        return this.tag;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("Request{method=");
        m253r.append(this.method);
        m253r.append(", url=");
        m253r.append(this.url);
        m253r.append(", tag=");
        Object obj = this.tag;
        if (obj == this) {
            obj = null;
        }
        m253r.append(obj);
        m253r.append('}');
        return m253r.toString();
    }

    public HttpUrl url() {
        return this.url;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }
}
