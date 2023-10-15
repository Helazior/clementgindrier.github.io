package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Util {
    private Util() {
    }

    public static Collection<Integer> processDeletions(Collection<Integer> collection, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return processDeletions(collection, arrayList);
    }

    public static Collection<Integer> processDeletions(Collection<Integer> collection, List<Integer> list) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(list, Collections.reverseOrder());
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : list) {
            int intValue = num.intValue();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (intValue2 > intValue) {
                    it.remove();
                    arrayList2.add(Integer.valueOf(intValue2 - 1));
                } else if (intValue2 == intValue) {
                    it.remove();
                } else {
                    arrayList2.add(Integer.valueOf(intValue2));
                }
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
            arrayList2.clear();
        }
        return arrayList;
    }
}
