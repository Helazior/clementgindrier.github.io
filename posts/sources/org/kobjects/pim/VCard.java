package org.kobjects.pim;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class VCard extends PimItem {
    public VCard() {
    }

    @Override // org.kobjects.pim.PimItem
    public int getArraySize(String str) {
        if (str.equals(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION)) {
            return 5;
        }
        return str.equals("adr") ? 6 : -1;
    }

    @Override // org.kobjects.pim.PimItem
    public String getType() {
        return "vcard";
    }

    public VCard(VCard vCard) {
        super(vCard);
    }
}
