package androidx.databinding;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DataBinderMapperImpl extends MergedDataBinderMapper {
    public static DataBinderMapper sTestOverride;

    static {
        try {
            sTestOverride = (DataBinderMapper) DataBinderMapper.class.getClassLoader().loadClass("androidx.databinding.TestDataBinderMapperImpl").newInstance();
        } catch (Throwable unused) {
            sTestOverride = null;
        }
    }

    public DataBinderMapperImpl() {
        addMapper(new fr.smoney.android.izly.DataBinderMapperImpl());
        DataBinderMapper dataBinderMapper = sTestOverride;
        if (dataBinderMapper != null) {
            addMapper(dataBinderMapper);
        }
    }
}
