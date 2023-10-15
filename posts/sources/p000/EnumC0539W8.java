package p000;

import android.util.SparseArray;
import java.util.EnumSet;
import java.util.Iterator;

/* renamed from: W8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public enum EnumC0539W8 {
    France(2131689708, 1),
    Allemagne(2131689699, 2),
    Autriche(2131689700, 3),
    Belgique(2131689701, 4),
    Bulgarie(2131689702, 5),
    Chypre(2131689703, 6),
    Danemark(2131689704, 7),
    Espagne(2131689705, 8),
    Estonie(2131689706, 9),
    Finlande(2131689707, 10),
    Grece(2131689709, 11),
    Hongrie(2131689710, 12),
    Irlande(2131689711, 13),
    Islande(2131689712, 14),
    Italie(2131689713, 15),
    Lettonie(2131689714, 16),
    Liechtenstein(2131689715, 17),
    Lituanie(2131689716, 18),
    Luxembourg(2131689717, 19),
    Malte(2131689718, 20),
    Norvege(2131689719, 21),
    PaysBas(2131689721, 22),
    Pologne(2131689732, 23),
    Portugal(2131689733, 24),
    RepubliqueTcheque(2131689734, 25),
    Roumanie(2131689735, 26),
    RoyaumeUni(2131689736, 27),
    Slovaquie(2131689737, 28),
    Slovenie(2131689738, 29),
    Suede(2131689739, 30);
    

    /* renamed from: H */
    public static final SparseArray<EnumC0539W8> f1912H = new SparseArray<>();

    /* renamed from: a */
    public int f1937a;

    /* renamed from: b */
    public int f1938b;

    static {
        Iterator it = EnumSet.allOf(EnumC0539W8.class).iterator();
        while (it.hasNext()) {
            EnumC0539W8 enumC0539W8 = (EnumC0539W8) it.next();
            f1912H.put(enumC0539W8.f1937a, enumC0539W8);
        }
    }

    EnumC0539W8(int i, int i2) {
        this.f1937a = i2;
        this.f1938b = i;
    }
}
