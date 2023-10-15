package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class MultipartBody extends RequestBody {
    private final C2011ne boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {13, 10};
    private static final byte[] DASHDASH = {45, 45};

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Builder {
        private final C2011ne boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, this.parts);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public Builder setType(MediaType mediaType) {
            Objects.requireNonNull(mediaType, "type == null");
            if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + mediaType);
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = C2011ne.m557f(str);
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            Objects.requireNonNull(part, "part == null");
            this.parts.add(part);
            return this;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class Part {
        public final RequestBody body;
        @Nullable
        public final Headers headers;

        private Part(@Nullable Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public RequestBody body() {
            return this.body;
        }

        @Nullable
        public Headers headers() {
            return this.headers;
        }

        public static Part create(@Nullable Headers headers, RequestBody requestBody) {
            Objects.requireNonNull(requestBody, "body == null");
            if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers != null && headers.get("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new Part(headers, requestBody);
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                MultipartBody.appendQuotedString(sb, str2);
            }
            return create(Headers.m530of("Content-Disposition", sb.toString()), requestBody);
        }
    }

    public MultipartBody(C2011ne c2011ne, MediaType mediaType, List<Part> list) {
        this.boundary = c2011ne;
        this.originalType = mediaType;
        this.contentType = MediaType.parse(mediaType + "; boundary=" + c2011ne.mo546q());
        this.parts = Util.immutableList(list);
    }

    public static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long writeOrCountBytes(@Nullable InterfaceC1966le interfaceC1966le, boolean z) {
        C1946ke c1946ke;
        if (z) {
            interfaceC1966le = new C1946ke();
            c1946ke = interfaceC1966le;
        } else {
            c1946ke = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.parts.get(i);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            interfaceC1966le.mo141p(DASHDASH);
            interfaceC1966le.mo140q(this.boundary);
            interfaceC1966le.mo141p(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    interfaceC1966le.mo138x(headers.name(i2)).mo141p(COLONSPACE).mo138x(headers.value(i2)).mo141p(CRLF);
                }
            }
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                interfaceC1966le.mo138x("Content-Type: ").mo138x(contentType.toString()).mo141p(CRLF);
            }
            long contentLength = requestBody.contentLength();
            if (contentLength != -1) {
                interfaceC1966le.mo138x("Content-Length: ").mo137y(contentLength).mo141p(CRLF);
            } else if (z) {
                c1946ke.m676E();
                return -1L;
            }
            byte[] bArr = CRLF;
            interfaceC1966le.mo141p(bArr);
            if (z) {
                j += contentLength;
            } else {
                requestBody.writeTo(interfaceC1966le);
            }
            interfaceC1966le.mo141p(bArr);
        }
        byte[] bArr2 = DASHDASH;
        interfaceC1966le.mo141p(bArr2);
        interfaceC1966le.mo140q(this.boundary);
        interfaceC1966le.mo141p(bArr2);
        interfaceC1966le.mo141p(CRLF);
        if (z) {
            long j2 = j + c1946ke.f5398b;
            c1946ke.m676E();
            return j2;
        }
        return j;
    }

    public String boundary() {
        return this.boundary.mo546q();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long writeOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = writeOrCountBytes;
        return writeOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public Part part(int i) {
        return this.parts.get(i);
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(InterfaceC1966le interfaceC1966le) {
        writeOrCountBytes(interfaceC1966le, false);
    }
}
