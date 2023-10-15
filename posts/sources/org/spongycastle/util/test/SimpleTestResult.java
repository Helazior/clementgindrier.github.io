package org.spongycastle.util.test;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SimpleTestResult implements TestResult {
    private static final String SEPARATOR = System.getProperty("line.separator");
    private Throwable exception;
    private String message;
    private boolean success;

    public SimpleTestResult(boolean z, String str) {
        this.success = z;
        this.message = str;
    }

    public static TestResult failed(Test test, String str) {
        return new SimpleTestResult(false, test.getName() + ": " + str);
    }

    public static String failedMessage(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(" failing ");
        stringBuffer.append(str2);
        String str5 = SEPARATOR;
        stringBuffer.append(str5);
        stringBuffer.append("    expected: ");
        stringBuffer.append(str3);
        stringBuffer.append(str5);
        stringBuffer.append("    got     : ");
        stringBuffer.append(str4);
        return stringBuffer.toString();
    }

    public static TestResult successful(Test test, String str) {
        return new SimpleTestResult(true, test.getName() + ": " + str);
    }

    @Override // org.spongycastle.util.test.TestResult
    public Throwable getException() {
        return this.exception;
    }

    @Override // org.spongycastle.util.test.TestResult
    public boolean isSuccessful() {
        return this.success;
    }

    @Override // org.spongycastle.util.test.TestResult
    public String toString() {
        return this.message;
    }

    public static TestResult failed(Test test, String str, Throwable th) {
        return new SimpleTestResult(false, test.getName() + ": " + str, th);
    }

    public static TestResult failed(Test test, String str, Object obj, Object obj2) {
        StringBuilder m253r = outline.m253r(str);
        String str2 = SEPARATOR;
        m253r.append(str2);
        m253r.append("Expected: ");
        m253r.append(obj);
        m253r.append(str2);
        m253r.append("Found   : ");
        m253r.append(obj2);
        return failed(test, m253r.toString());
    }

    public SimpleTestResult(boolean z, String str, Throwable th) {
        this.success = z;
        this.message = str;
        this.exception = th;
    }
}
