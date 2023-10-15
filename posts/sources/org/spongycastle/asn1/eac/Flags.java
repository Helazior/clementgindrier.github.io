package org.spongycastle.asn1.eac;

import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Flags {
    public int value;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class StringJoiner {
        public boolean First = true;

        /* renamed from: b */
        public StringBuffer f5663b = new StringBuffer();
        public String mSeparator;

        public StringJoiner(String str) {
            this.mSeparator = str;
        }

        public void add(String str) {
            if (this.First) {
                this.First = false;
            } else {
                this.f5663b.append(this.mSeparator);
            }
            this.f5663b.append(str);
        }

        public String toString() {
            return this.f5663b.toString();
        }
    }

    public Flags() {
        this.value = 0;
    }

    public String decode(Hashtable hashtable) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            if (isSet(num.intValue())) {
                stringJoiner.add((String) hashtable.get(num));
            }
        }
        return stringJoiner.toString();
    }

    public int getFlags() {
        return this.value;
    }

    public boolean isSet(int i) {
        return (i & this.value) != 0;
    }

    public void set(int i) {
        this.value = i | this.value;
    }

    public Flags(int i) {
        this.value = 0;
        this.value = i;
    }
}
