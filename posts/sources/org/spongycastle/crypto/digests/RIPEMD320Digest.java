package org.spongycastle.crypto.digests;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RIPEMD320Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 40;

    /* renamed from: H0 */
    private int f5797H0;

    /* renamed from: H1 */
    private int f5798H1;

    /* renamed from: H2 */
    private int f5799H2;

    /* renamed from: H3 */
    private int f5800H3;

    /* renamed from: H4 */
    private int f5801H4;

    /* renamed from: H5 */
    private int f5802H5;

    /* renamed from: H6 */
    private int f5803H6;

    /* renamed from: H7 */
    private int f5804H7;

    /* renamed from: H8 */
    private int f5805H8;

    /* renamed from: H9 */
    private int f5806H9;

    /* renamed from: X */
    private int[] f5807X;
    private int xOff;

    public RIPEMD320Digest() {
        this.f5807X = new int[16];
        reset();
    }

    /* renamed from: RL */
    private int m491RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: f1 */
    private int m490f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m489f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m488f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m487f4(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: f5 */
    private int m486f5(int i, int i2, int i3) {
        return i ^ (i2 | (~i3));
    }

    private void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.f5797H0, bArr, i);
        unpackWord(this.f5798H1, bArr, i + 4);
        unpackWord(this.f5799H2, bArr, i + 8);
        unpackWord(this.f5800H3, bArr, i + 12);
        unpackWord(this.f5801H4, bArr, i + 16);
        unpackWord(this.f5802H5, bArr, i + 20);
        unpackWord(this.f5803H6, bArr, i + 24);
        unpackWord(this.f5804H7, bArr, i + 28);
        unpackWord(this.f5805H8, bArr, i + 32);
        unpackWord(this.f5806H9, bArr, i + 36);
        reset();
        return 40;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD320";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 40;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i = this.f5797H0;
        int i2 = this.f5798H1;
        int i3 = this.f5799H2;
        int i4 = this.f5800H3;
        int i5 = this.f5801H4;
        int i6 = this.f5802H5;
        int i7 = this.f5803H6;
        int i8 = this.f5804H7;
        int i9 = this.f5805H8;
        int i10 = this.f5806H9;
        int m491RL = m491RL(i + m490f1(i2, i3, i4) + this.f5807X[0], 11) + i5;
        int m491RL2 = m491RL(i3, 10);
        int m491RL3 = m491RL(i5 + m490f1(m491RL, i2, m491RL2) + this.f5807X[1], 14) + i4;
        int m491RL4 = m491RL(i2, 10);
        int m491RL5 = m491RL(i4 + m490f1(m491RL3, m491RL, m491RL4) + this.f5807X[2], 15) + m491RL2;
        int m491RL6 = m491RL(m491RL, 10);
        int m491RL7 = m491RL(m491RL2 + m490f1(m491RL5, m491RL3, m491RL6) + this.f5807X[3], 12) + m491RL4;
        int m491RL8 = m491RL(m491RL3, 10);
        int m491RL9 = m491RL(m491RL4 + m490f1(m491RL7, m491RL5, m491RL8) + this.f5807X[4], 5) + m491RL6;
        int m491RL10 = m491RL(m491RL5, 10);
        int m491RL11 = m491RL(m491RL6 + m490f1(m491RL9, m491RL7, m491RL10) + this.f5807X[5], 8) + m491RL8;
        int m491RL12 = m491RL(m491RL7, 10);
        int m491RL13 = m491RL(m491RL8 + m490f1(m491RL11, m491RL9, m491RL12) + this.f5807X[6], 7) + m491RL10;
        int m491RL14 = m491RL(m491RL9, 10);
        int m491RL15 = m491RL(m491RL10 + m490f1(m491RL13, m491RL11, m491RL14) + this.f5807X[7], 9) + m491RL12;
        int m491RL16 = m491RL(m491RL11, 10);
        int m491RL17 = m491RL(m491RL12 + m490f1(m491RL15, m491RL13, m491RL16) + this.f5807X[8], 11) + m491RL14;
        int m491RL18 = m491RL(m491RL13, 10);
        int m491RL19 = m491RL(m491RL14 + m490f1(m491RL17, m491RL15, m491RL18) + this.f5807X[9], 13) + m491RL16;
        int m491RL20 = m491RL(m491RL15, 10);
        int m491RL21 = m491RL(m491RL16 + m490f1(m491RL19, m491RL17, m491RL20) + this.f5807X[10], 14) + m491RL18;
        int m491RL22 = m491RL(m491RL17, 10);
        int m491RL23 = m491RL(m491RL18 + m490f1(m491RL21, m491RL19, m491RL22) + this.f5807X[11], 15) + m491RL20;
        int m491RL24 = m491RL(m491RL19, 10);
        int m491RL25 = m491RL(m491RL20 + m490f1(m491RL23, m491RL21, m491RL24) + this.f5807X[12], 6) + m491RL22;
        int m491RL26 = m491RL(m491RL21, 10);
        int m491RL27 = m491RL(m491RL22 + m490f1(m491RL25, m491RL23, m491RL26) + this.f5807X[13], 7) + m491RL24;
        int m491RL28 = m491RL(m491RL23, 10);
        int m491RL29 = m491RL(m491RL24 + m490f1(m491RL27, m491RL25, m491RL28) + this.f5807X[14], 9) + m491RL26;
        int m491RL30 = m491RL(m491RL25, 10);
        int m491RL31 = m491RL(m491RL26 + m490f1(m491RL29, m491RL27, m491RL30) + this.f5807X[15], 8) + m491RL28;
        int m491RL32 = m491RL(m491RL27, 10);
        int m491RL33 = m491RL(i6 + m486f5(i7, i8, i9) + this.f5807X[5] + 1352829926, 8) + i10;
        int m491RL34 = m491RL(i8, 10);
        int m491RL35 = m491RL(i10 + m486f5(m491RL33, i7, m491RL34) + this.f5807X[14] + 1352829926, 9) + i9;
        int m491RL36 = m491RL(i7, 10);
        int m491RL37 = m491RL(i9 + m486f5(m491RL35, m491RL33, m491RL36) + this.f5807X[7] + 1352829926, 9) + m491RL34;
        int m491RL38 = m491RL(m491RL33, 10);
        int m491RL39 = m491RL(m491RL34 + m486f5(m491RL37, m491RL35, m491RL38) + this.f5807X[0] + 1352829926, 11) + m491RL36;
        int m491RL40 = m491RL(m491RL35, 10);
        int m491RL41 = m491RL(m491RL36 + m486f5(m491RL39, m491RL37, m491RL40) + this.f5807X[9] + 1352829926, 13) + m491RL38;
        int m491RL42 = m491RL(m491RL37, 10);
        int m491RL43 = m491RL(m491RL38 + m486f5(m491RL41, m491RL39, m491RL42) + this.f5807X[2] + 1352829926, 15) + m491RL40;
        int m491RL44 = m491RL(m491RL39, 10);
        int m491RL45 = m491RL(m491RL40 + m486f5(m491RL43, m491RL41, m491RL44) + this.f5807X[11] + 1352829926, 15) + m491RL42;
        int m491RL46 = m491RL(m491RL41, 10);
        int m491RL47 = m491RL(m491RL42 + m486f5(m491RL45, m491RL43, m491RL46) + this.f5807X[4] + 1352829926, 5) + m491RL44;
        int m491RL48 = m491RL(m491RL43, 10);
        int m491RL49 = m491RL(m491RL44 + m486f5(m491RL47, m491RL45, m491RL48) + this.f5807X[13] + 1352829926, 7) + m491RL46;
        int m491RL50 = m491RL(m491RL45, 10);
        int m491RL51 = m491RL(m491RL46 + m486f5(m491RL49, m491RL47, m491RL50) + this.f5807X[6] + 1352829926, 7) + m491RL48;
        int m491RL52 = m491RL(m491RL47, 10);
        int m491RL53 = m491RL(m491RL48 + m486f5(m491RL51, m491RL49, m491RL52) + this.f5807X[15] + 1352829926, 8) + m491RL50;
        int m491RL54 = m491RL(m491RL49, 10);
        int m491RL55 = m491RL(m491RL50 + m486f5(m491RL53, m491RL51, m491RL54) + this.f5807X[8] + 1352829926, 11) + m491RL52;
        int m491RL56 = m491RL(m491RL51, 10);
        int m491RL57 = m491RL(m491RL52 + m486f5(m491RL55, m491RL53, m491RL56) + this.f5807X[1] + 1352829926, 14) + m491RL54;
        int m491RL58 = m491RL(m491RL53, 10);
        int m491RL59 = m491RL(m491RL54 + m486f5(m491RL57, m491RL55, m491RL58) + this.f5807X[10] + 1352829926, 14) + m491RL56;
        int m491RL60 = m491RL(m491RL55, 10);
        int m491RL61 = m491RL(m491RL56 + m486f5(m491RL59, m491RL57, m491RL60) + this.f5807X[3] + 1352829926, 12) + m491RL58;
        int m491RL62 = m491RL(m491RL57, 10);
        int m491RL63 = m491RL(m491RL58 + m486f5(m491RL61, m491RL59, m491RL62) + this.f5807X[12] + 1352829926, 6) + m491RL60;
        int m491RL64 = m491RL(m491RL59, 10);
        int m491RL65 = m491RL(m491RL28 + m489f2(m491RL63, m491RL29, m491RL32) + this.f5807X[7] + 1518500249, 7) + m491RL30;
        int m491RL66 = m491RL(m491RL29, 10);
        int m491RL67 = m491RL(m491RL30 + m489f2(m491RL65, m491RL63, m491RL66) + this.f5807X[4] + 1518500249, 6) + m491RL32;
        int m491RL68 = m491RL(m491RL63, 10);
        int m491RL69 = m491RL(m491RL32 + m489f2(m491RL67, m491RL65, m491RL68) + this.f5807X[13] + 1518500249, 8) + m491RL66;
        int m491RL70 = m491RL(m491RL65, 10);
        int m491RL71 = m491RL(m491RL66 + m489f2(m491RL69, m491RL67, m491RL70) + this.f5807X[1] + 1518500249, 13) + m491RL68;
        int m491RL72 = m491RL(m491RL67, 10);
        int m491RL73 = m491RL(m491RL68 + m489f2(m491RL71, m491RL69, m491RL72) + this.f5807X[10] + 1518500249, 11) + m491RL70;
        int m491RL74 = m491RL(m491RL69, 10);
        int m491RL75 = m491RL(m491RL70 + m489f2(m491RL73, m491RL71, m491RL74) + this.f5807X[6] + 1518500249, 9) + m491RL72;
        int m491RL76 = m491RL(m491RL71, 10);
        int m491RL77 = m491RL(m491RL72 + m489f2(m491RL75, m491RL73, m491RL76) + this.f5807X[15] + 1518500249, 7) + m491RL74;
        int m491RL78 = m491RL(m491RL73, 10);
        int m491RL79 = m491RL(m491RL74 + m489f2(m491RL77, m491RL75, m491RL78) + this.f5807X[3] + 1518500249, 15) + m491RL76;
        int m491RL80 = m491RL(m491RL75, 10);
        int m491RL81 = m491RL(m491RL76 + m489f2(m491RL79, m491RL77, m491RL80) + this.f5807X[12] + 1518500249, 7) + m491RL78;
        int m491RL82 = m491RL(m491RL77, 10);
        int m491RL83 = m491RL(m491RL78 + m489f2(m491RL81, m491RL79, m491RL82) + this.f5807X[0] + 1518500249, 12) + m491RL80;
        int m491RL84 = m491RL(m491RL79, 10);
        int m491RL85 = m491RL(m491RL80 + m489f2(m491RL83, m491RL81, m491RL84) + this.f5807X[9] + 1518500249, 15) + m491RL82;
        int m491RL86 = m491RL(m491RL81, 10);
        int m491RL87 = m491RL(m491RL82 + m489f2(m491RL85, m491RL83, m491RL86) + this.f5807X[5] + 1518500249, 9) + m491RL84;
        int m491RL88 = m491RL(m491RL83, 10);
        int m491RL89 = m491RL(m491RL84 + m489f2(m491RL87, m491RL85, m491RL88) + this.f5807X[2] + 1518500249, 11) + m491RL86;
        int m491RL90 = m491RL(m491RL85, 10);
        int m491RL91 = m491RL(m491RL86 + m489f2(m491RL89, m491RL87, m491RL90) + this.f5807X[14] + 1518500249, 7) + m491RL88;
        int m491RL92 = m491RL(m491RL87, 10);
        int m491RL93 = m491RL(m491RL88 + m489f2(m491RL91, m491RL89, m491RL92) + this.f5807X[11] + 1518500249, 13) + m491RL90;
        int m491RL94 = m491RL(m491RL89, 10);
        int m491RL95 = m491RL(m491RL90 + m489f2(m491RL93, m491RL91, m491RL94) + this.f5807X[8] + 1518500249, 12) + m491RL92;
        int m491RL96 = m491RL(m491RL91, 10);
        int m491RL97 = m491RL(m491RL60 + m487f4(m491RL31, m491RL61, m491RL64) + this.f5807X[6] + 1548603684, 9) + m491RL62;
        int m491RL98 = m491RL(m491RL61, 10);
        int m491RL99 = m491RL(m491RL62 + m487f4(m491RL97, m491RL31, m491RL98) + this.f5807X[11] + 1548603684, 13) + m491RL64;
        int m491RL100 = m491RL(m491RL31, 10);
        int m491RL101 = m491RL(m491RL64 + m487f4(m491RL99, m491RL97, m491RL100) + this.f5807X[3] + 1548603684, 15) + m491RL98;
        int m491RL102 = m491RL(m491RL97, 10);
        int m491RL103 = m491RL(m491RL98 + m487f4(m491RL101, m491RL99, m491RL102) + this.f5807X[7] + 1548603684, 7) + m491RL100;
        int m491RL104 = m491RL(m491RL99, 10);
        int m491RL105 = m491RL(m491RL100 + m487f4(m491RL103, m491RL101, m491RL104) + this.f5807X[0] + 1548603684, 12) + m491RL102;
        int m491RL106 = m491RL(m491RL101, 10);
        int m491RL107 = m491RL(m491RL102 + m487f4(m491RL105, m491RL103, m491RL106) + this.f5807X[13] + 1548603684, 8) + m491RL104;
        int m491RL108 = m491RL(m491RL103, 10);
        int m491RL109 = m491RL(m491RL104 + m487f4(m491RL107, m491RL105, m491RL108) + this.f5807X[5] + 1548603684, 9) + m491RL106;
        int m491RL110 = m491RL(m491RL105, 10);
        int m491RL111 = m491RL(m491RL106 + m487f4(m491RL109, m491RL107, m491RL110) + this.f5807X[10] + 1548603684, 11) + m491RL108;
        int m491RL112 = m491RL(m491RL107, 10);
        int m491RL113 = m491RL(m491RL108 + m487f4(m491RL111, m491RL109, m491RL112) + this.f5807X[14] + 1548603684, 7) + m491RL110;
        int m491RL114 = m491RL(m491RL109, 10);
        int m491RL115 = m491RL(m491RL110 + m487f4(m491RL113, m491RL111, m491RL114) + this.f5807X[15] + 1548603684, 7) + m491RL112;
        int m491RL116 = m491RL(m491RL111, 10);
        int m491RL117 = m491RL(m491RL112 + m487f4(m491RL115, m491RL113, m491RL116) + this.f5807X[8] + 1548603684, 12) + m491RL114;
        int m491RL118 = m491RL(m491RL113, 10);
        int m491RL119 = m491RL(m491RL114 + m487f4(m491RL117, m491RL115, m491RL118) + this.f5807X[12] + 1548603684, 7) + m491RL116;
        int m491RL120 = m491RL(m491RL115, 10);
        int m491RL121 = m491RL(m491RL116 + m487f4(m491RL119, m491RL117, m491RL120) + this.f5807X[4] + 1548603684, 6) + m491RL118;
        int m491RL122 = m491RL(m491RL117, 10);
        int m491RL123 = m491RL(m491RL118 + m487f4(m491RL121, m491RL119, m491RL122) + this.f5807X[9] + 1548603684, 15) + m491RL120;
        int m491RL124 = m491RL(m491RL119, 10);
        int m491RL125 = m491RL(m491RL120 + m487f4(m491RL123, m491RL121, m491RL124) + this.f5807X[1] + 1548603684, 13) + m491RL122;
        int m491RL126 = m491RL(m491RL121, 10);
        int m491RL127 = m491RL(m491RL122 + m487f4(m491RL125, m491RL123, m491RL126) + this.f5807X[2] + 1548603684, 11) + m491RL124;
        int m491RL128 = m491RL(m491RL123, 10);
        int m491RL129 = m491RL(m491RL92 + m488f3(m491RL95, m491RL93, m491RL128) + this.f5807X[3] + 1859775393, 11) + m491RL94;
        int m491RL130 = m491RL(m491RL93, 10);
        int m491RL131 = m491RL(m491RL94 + m488f3(m491RL129, m491RL95, m491RL130) + this.f5807X[10] + 1859775393, 13) + m491RL128;
        int m491RL132 = m491RL(m491RL95, 10);
        int m491RL133 = m491RL(m491RL128 + m488f3(m491RL131, m491RL129, m491RL132) + this.f5807X[14] + 1859775393, 6) + m491RL130;
        int m491RL134 = m491RL(m491RL129, 10);
        int m491RL135 = m491RL(m491RL130 + m488f3(m491RL133, m491RL131, m491RL134) + this.f5807X[4] + 1859775393, 7) + m491RL132;
        int m491RL136 = m491RL(m491RL131, 10);
        int m491RL137 = m491RL(m491RL132 + m488f3(m491RL135, m491RL133, m491RL136) + this.f5807X[9] + 1859775393, 14) + m491RL134;
        int m491RL138 = m491RL(m491RL133, 10);
        int m491RL139 = m491RL(m491RL134 + m488f3(m491RL137, m491RL135, m491RL138) + this.f5807X[15] + 1859775393, 9) + m491RL136;
        int m491RL140 = m491RL(m491RL135, 10);
        int m491RL141 = m491RL(m491RL136 + m488f3(m491RL139, m491RL137, m491RL140) + this.f5807X[8] + 1859775393, 13) + m491RL138;
        int m491RL142 = m491RL(m491RL137, 10);
        int m491RL143 = m491RL(m491RL138 + m488f3(m491RL141, m491RL139, m491RL142) + this.f5807X[1] + 1859775393, 15) + m491RL140;
        int m491RL144 = m491RL(m491RL139, 10);
        int m491RL145 = m491RL(m491RL140 + m488f3(m491RL143, m491RL141, m491RL144) + this.f5807X[2] + 1859775393, 14) + m491RL142;
        int m491RL146 = m491RL(m491RL141, 10);
        int m491RL147 = m491RL(m491RL142 + m488f3(m491RL145, m491RL143, m491RL146) + this.f5807X[7] + 1859775393, 8) + m491RL144;
        int m491RL148 = m491RL(m491RL143, 10);
        int m491RL149 = m491RL(m491RL144 + m488f3(m491RL147, m491RL145, m491RL148) + this.f5807X[0] + 1859775393, 13) + m491RL146;
        int m491RL150 = m491RL(m491RL145, 10);
        int m491RL151 = m491RL(m491RL146 + m488f3(m491RL149, m491RL147, m491RL150) + this.f5807X[6] + 1859775393, 6) + m491RL148;
        int m491RL152 = m491RL(m491RL147, 10);
        int m491RL153 = m491RL(m491RL148 + m488f3(m491RL151, m491RL149, m491RL152) + this.f5807X[13] + 1859775393, 5) + m491RL150;
        int m491RL154 = m491RL(m491RL149, 10);
        int m491RL155 = m491RL(m491RL150 + m488f3(m491RL153, m491RL151, m491RL154) + this.f5807X[11] + 1859775393, 12) + m491RL152;
        int m491RL156 = m491RL(m491RL151, 10);
        int m491RL157 = m491RL(m491RL152 + m488f3(m491RL155, m491RL153, m491RL156) + this.f5807X[5] + 1859775393, 7) + m491RL154;
        int m491RL158 = m491RL(m491RL153, 10);
        int m491RL159 = m491RL(m491RL154 + m488f3(m491RL157, m491RL155, m491RL158) + this.f5807X[12] + 1859775393, 5) + m491RL156;
        int m491RL160 = m491RL(m491RL155, 10);
        int m491RL161 = m491RL(m491RL124 + m488f3(m491RL127, m491RL125, m491RL96) + this.f5807X[15] + 1836072691, 9) + m491RL126;
        int m491RL162 = m491RL(m491RL125, 10);
        int m491RL163 = m491RL(m491RL126 + m488f3(m491RL161, m491RL127, m491RL162) + this.f5807X[5] + 1836072691, 7) + m491RL96;
        int m491RL164 = m491RL(m491RL127, 10);
        int m491RL165 = m491RL(m491RL96 + m488f3(m491RL163, m491RL161, m491RL164) + this.f5807X[1] + 1836072691, 15) + m491RL162;
        int m491RL166 = m491RL(m491RL161, 10);
        int m491RL167 = m491RL(m491RL162 + m488f3(m491RL165, m491RL163, m491RL166) + this.f5807X[3] + 1836072691, 11) + m491RL164;
        int m491RL168 = m491RL(m491RL163, 10);
        int m491RL169 = m491RL(m491RL164 + m488f3(m491RL167, m491RL165, m491RL168) + this.f5807X[7] + 1836072691, 8) + m491RL166;
        int m491RL170 = m491RL(m491RL165, 10);
        int m491RL171 = m491RL(m491RL166 + m488f3(m491RL169, m491RL167, m491RL170) + this.f5807X[14] + 1836072691, 6) + m491RL168;
        int m491RL172 = m491RL(m491RL167, 10);
        int m491RL173 = m491RL(m491RL168 + m488f3(m491RL171, m491RL169, m491RL172) + this.f5807X[6] + 1836072691, 6) + m491RL170;
        int m491RL174 = m491RL(m491RL169, 10);
        int m491RL175 = m491RL(m491RL170 + m488f3(m491RL173, m491RL171, m491RL174) + this.f5807X[9] + 1836072691, 14) + m491RL172;
        int m491RL176 = m491RL(m491RL171, 10);
        int m491RL177 = m491RL(m491RL172 + m488f3(m491RL175, m491RL173, m491RL176) + this.f5807X[11] + 1836072691, 12) + m491RL174;
        int m491RL178 = m491RL(m491RL173, 10);
        int m491RL179 = m491RL(m491RL174 + m488f3(m491RL177, m491RL175, m491RL178) + this.f5807X[8] + 1836072691, 13) + m491RL176;
        int m491RL180 = m491RL(m491RL175, 10);
        int m491RL181 = m491RL(m491RL176 + m488f3(m491RL179, m491RL177, m491RL180) + this.f5807X[12] + 1836072691, 5) + m491RL178;
        int m491RL182 = m491RL(m491RL177, 10);
        int m491RL183 = m491RL(m491RL178 + m488f3(m491RL181, m491RL179, m491RL182) + this.f5807X[2] + 1836072691, 14) + m491RL180;
        int m491RL184 = m491RL(m491RL179, 10);
        int m491RL185 = m491RL(m491RL180 + m488f3(m491RL183, m491RL181, m491RL184) + this.f5807X[10] + 1836072691, 13) + m491RL182;
        int m491RL186 = m491RL(m491RL181, 10);
        int m491RL187 = m491RL(m491RL182 + m488f3(m491RL185, m491RL183, m491RL186) + this.f5807X[0] + 1836072691, 13) + m491RL184;
        int m491RL188 = m491RL(m491RL183, 10);
        int m491RL189 = m491RL(m491RL184 + m488f3(m491RL187, m491RL185, m491RL188) + this.f5807X[4] + 1836072691, 7) + m491RL186;
        int m491RL190 = m491RL(m491RL185, 10);
        int m491RL191 = m491RL(m491RL186 + m488f3(m491RL189, m491RL187, m491RL190) + this.f5807X[13] + 1836072691, 5) + m491RL188;
        int m491RL192 = m491RL(m491RL187, 10);
        int m491RL193 = m491RL(((m491RL188 + m487f4(m491RL159, m491RL157, m491RL160)) + this.f5807X[1]) - 1894007588, 11) + m491RL158;
        int m491RL194 = m491RL(m491RL157, 10);
        int m491RL195 = m491RL(((m491RL158 + m487f4(m491RL193, m491RL159, m491RL194)) + this.f5807X[9]) - 1894007588, 12) + m491RL160;
        int m491RL196 = m491RL(m491RL159, 10);
        int m491RL197 = m491RL(((m491RL160 + m487f4(m491RL195, m491RL193, m491RL196)) + this.f5807X[11]) - 1894007588, 14) + m491RL194;
        int m491RL198 = m491RL(m491RL193, 10);
        int m491RL199 = m491RL(((m491RL194 + m487f4(m491RL197, m491RL195, m491RL198)) + this.f5807X[10]) - 1894007588, 15) + m491RL196;
        int m491RL200 = m491RL(m491RL195, 10);
        int m491RL201 = m491RL(((m491RL196 + m487f4(m491RL199, m491RL197, m491RL200)) + this.f5807X[0]) - 1894007588, 14) + m491RL198;
        int m491RL202 = m491RL(m491RL197, 10);
        int m491RL203 = m491RL(((m491RL198 + m487f4(m491RL201, m491RL199, m491RL202)) + this.f5807X[8]) - 1894007588, 15) + m491RL200;
        int m491RL204 = m491RL(m491RL199, 10);
        int m491RL205 = m491RL(((m491RL200 + m487f4(m491RL203, m491RL201, m491RL204)) + this.f5807X[12]) - 1894007588, 9) + m491RL202;
        int m491RL206 = m491RL(m491RL201, 10);
        int m491RL207 = m491RL(((m491RL202 + m487f4(m491RL205, m491RL203, m491RL206)) + this.f5807X[4]) - 1894007588, 8) + m491RL204;
        int m491RL208 = m491RL(m491RL203, 10);
        int m491RL209 = m491RL(((m491RL204 + m487f4(m491RL207, m491RL205, m491RL208)) + this.f5807X[13]) - 1894007588, 9) + m491RL206;
        int m491RL210 = m491RL(m491RL205, 10);
        int m491RL211 = m491RL(((m491RL206 + m487f4(m491RL209, m491RL207, m491RL210)) + this.f5807X[3]) - 1894007588, 14) + m491RL208;
        int m491RL212 = m491RL(m491RL207, 10);
        int m491RL213 = m491RL(((m491RL208 + m487f4(m491RL211, m491RL209, m491RL212)) + this.f5807X[7]) - 1894007588, 5) + m491RL210;
        int m491RL214 = m491RL(m491RL209, 10);
        int m491RL215 = m491RL(((m491RL210 + m487f4(m491RL213, m491RL211, m491RL214)) + this.f5807X[15]) - 1894007588, 6) + m491RL212;
        int m491RL216 = m491RL(m491RL211, 10);
        int m491RL217 = m491RL(((m491RL212 + m487f4(m491RL215, m491RL213, m491RL216)) + this.f5807X[14]) - 1894007588, 8) + m491RL214;
        int m491RL218 = m491RL(m491RL213, 10);
        int m491RL219 = m491RL(((m491RL214 + m487f4(m491RL217, m491RL215, m491RL218)) + this.f5807X[5]) - 1894007588, 6) + m491RL216;
        int m491RL220 = m491RL(m491RL215, 10);
        int m491RL221 = m491RL(((m491RL216 + m487f4(m491RL219, m491RL217, m491RL220)) + this.f5807X[6]) - 1894007588, 5) + m491RL218;
        int m491RL222 = m491RL(m491RL217, 10);
        int m491RL223 = m491RL(((m491RL218 + m487f4(m491RL221, m491RL219, m491RL222)) + this.f5807X[2]) - 1894007588, 12) + m491RL220;
        int m491RL224 = m491RL(m491RL219, 10);
        int m491RL225 = m491RL(m491RL156 + m489f2(m491RL191, m491RL189, m491RL192) + this.f5807X[8] + 2053994217, 15) + m491RL190;
        int m491RL226 = m491RL(m491RL189, 10);
        int m491RL227 = m491RL(m491RL190 + m489f2(m491RL225, m491RL191, m491RL226) + this.f5807X[6] + 2053994217, 5) + m491RL192;
        int m491RL228 = m491RL(m491RL191, 10);
        int m491RL229 = m491RL(m491RL192 + m489f2(m491RL227, m491RL225, m491RL228) + this.f5807X[4] + 2053994217, 8) + m491RL226;
        int m491RL230 = m491RL(m491RL225, 10);
        int m491RL231 = m491RL(m491RL226 + m489f2(m491RL229, m491RL227, m491RL230) + this.f5807X[1] + 2053994217, 11) + m491RL228;
        int m491RL232 = m491RL(m491RL227, 10);
        int m491RL233 = m491RL(m491RL228 + m489f2(m491RL231, m491RL229, m491RL232) + this.f5807X[3] + 2053994217, 14) + m491RL230;
        int m491RL234 = m491RL(m491RL229, 10);
        int m491RL235 = m491RL(m491RL230 + m489f2(m491RL233, m491RL231, m491RL234) + this.f5807X[11] + 2053994217, 14) + m491RL232;
        int m491RL236 = m491RL(m491RL231, 10);
        int m491RL237 = m491RL(m491RL232 + m489f2(m491RL235, m491RL233, m491RL236) + this.f5807X[15] + 2053994217, 6) + m491RL234;
        int m491RL238 = m491RL(m491RL233, 10);
        int m491RL239 = m491RL(m491RL234 + m489f2(m491RL237, m491RL235, m491RL238) + this.f5807X[0] + 2053994217, 14) + m491RL236;
        int m491RL240 = m491RL(m491RL235, 10);
        int m491RL241 = m491RL(m491RL236 + m489f2(m491RL239, m491RL237, m491RL240) + this.f5807X[5] + 2053994217, 6) + m491RL238;
        int m491RL242 = m491RL(m491RL237, 10);
        int m491RL243 = m491RL(m491RL238 + m489f2(m491RL241, m491RL239, m491RL242) + this.f5807X[12] + 2053994217, 9) + m491RL240;
        int m491RL244 = m491RL(m491RL239, 10);
        int m491RL245 = m491RL(m491RL240 + m489f2(m491RL243, m491RL241, m491RL244) + this.f5807X[2] + 2053994217, 12) + m491RL242;
        int m491RL246 = m491RL(m491RL241, 10);
        int m491RL247 = m491RL(m491RL242 + m489f2(m491RL245, m491RL243, m491RL246) + this.f5807X[13] + 2053994217, 9) + m491RL244;
        int m491RL248 = m491RL(m491RL243, 10);
        int m491RL249 = m491RL(m491RL244 + m489f2(m491RL247, m491RL245, m491RL248) + this.f5807X[9] + 2053994217, 12) + m491RL246;
        int m491RL250 = m491RL(m491RL245, 10);
        int m491RL251 = m491RL(m491RL246 + m489f2(m491RL249, m491RL247, m491RL250) + this.f5807X[7] + 2053994217, 5) + m491RL248;
        int m491RL252 = m491RL(m491RL247, 10);
        int m491RL253 = m491RL(m491RL248 + m489f2(m491RL251, m491RL249, m491RL252) + this.f5807X[10] + 2053994217, 15) + m491RL250;
        int m491RL254 = m491RL(m491RL249, 10);
        int m491RL255 = m491RL(m491RL250 + m489f2(m491RL253, m491RL251, m491RL254) + this.f5807X[14] + 2053994217, 8) + m491RL252;
        int m491RL256 = m491RL(m491RL251, 10);
        int m491RL257 = m491RL(((m491RL220 + m486f5(m491RL223, m491RL253, m491RL224)) + this.f5807X[4]) - 1454113458, 9) + m491RL222;
        int m491RL258 = m491RL(m491RL253, 10);
        int m491RL259 = m491RL(((m491RL222 + m486f5(m491RL257, m491RL223, m491RL258)) + this.f5807X[0]) - 1454113458, 15) + m491RL224;
        int m491RL260 = m491RL(m491RL223, 10);
        int m491RL261 = m491RL(((m491RL224 + m486f5(m491RL259, m491RL257, m491RL260)) + this.f5807X[5]) - 1454113458, 5) + m491RL258;
        int m491RL262 = m491RL(m491RL257, 10);
        int m491RL263 = m491RL(((m491RL258 + m486f5(m491RL261, m491RL259, m491RL262)) + this.f5807X[9]) - 1454113458, 11) + m491RL260;
        int m491RL264 = m491RL(m491RL259, 10);
        int m491RL265 = m491RL(((m491RL260 + m486f5(m491RL263, m491RL261, m491RL264)) + this.f5807X[7]) - 1454113458, 6) + m491RL262;
        int m491RL266 = m491RL(m491RL261, 10);
        int m491RL267 = m491RL(((m491RL262 + m486f5(m491RL265, m491RL263, m491RL266)) + this.f5807X[12]) - 1454113458, 8) + m491RL264;
        int m491RL268 = m491RL(m491RL263, 10);
        int m491RL269 = m491RL(((m491RL264 + m486f5(m491RL267, m491RL265, m491RL268)) + this.f5807X[2]) - 1454113458, 13) + m491RL266;
        int m491RL270 = m491RL(m491RL265, 10);
        int m491RL271 = m491RL(((m491RL266 + m486f5(m491RL269, m491RL267, m491RL270)) + this.f5807X[10]) - 1454113458, 12) + m491RL268;
        int m491RL272 = m491RL(m491RL267, 10);
        int m491RL273 = m491RL(((m491RL268 + m486f5(m491RL271, m491RL269, m491RL272)) + this.f5807X[14]) - 1454113458, 5) + m491RL270;
        int m491RL274 = m491RL(m491RL269, 10);
        int m491RL275 = m491RL(((m491RL270 + m486f5(m491RL273, m491RL271, m491RL274)) + this.f5807X[1]) - 1454113458, 12) + m491RL272;
        int m491RL276 = m491RL(m491RL271, 10);
        int m491RL277 = m491RL(((m491RL272 + m486f5(m491RL275, m491RL273, m491RL276)) + this.f5807X[3]) - 1454113458, 13) + m491RL274;
        int m491RL278 = m491RL(m491RL273, 10);
        int m491RL279 = m491RL(((m491RL274 + m486f5(m491RL277, m491RL275, m491RL278)) + this.f5807X[8]) - 1454113458, 14) + m491RL276;
        int m491RL280 = m491RL(m491RL275, 10);
        int m491RL281 = m491RL(((m491RL276 + m486f5(m491RL279, m491RL277, m491RL280)) + this.f5807X[11]) - 1454113458, 11) + m491RL278;
        int m491RL282 = m491RL(m491RL277, 10);
        int m491RL283 = m491RL(((m491RL278 + m486f5(m491RL281, m491RL279, m491RL282)) + this.f5807X[6]) - 1454113458, 8) + m491RL280;
        int m491RL284 = m491RL(m491RL279, 10);
        int m491RL285 = m491RL(((m491RL280 + m486f5(m491RL283, m491RL281, m491RL284)) + this.f5807X[15]) - 1454113458, 5) + m491RL282;
        int m491RL286 = m491RL(m491RL281, 10);
        int m491RL287 = m491RL(((m491RL282 + m486f5(m491RL285, m491RL283, m491RL286)) + this.f5807X[13]) - 1454113458, 6) + m491RL284;
        int m491RL288 = m491RL(m491RL283, 10);
        int m491RL289 = m491RL(m491RL252 + m490f1(m491RL255, m491RL221, m491RL256) + this.f5807X[12], 8) + m491RL254;
        int m491RL290 = m491RL(m491RL221, 10);
        int m491RL291 = m491RL(m491RL254 + m490f1(m491RL289, m491RL255, m491RL290) + this.f5807X[15], 5) + m491RL256;
        int m491RL292 = m491RL(m491RL255, 10);
        int m491RL293 = m491RL(m491RL256 + m490f1(m491RL291, m491RL289, m491RL292) + this.f5807X[10], 12) + m491RL290;
        int m491RL294 = m491RL(m491RL289, 10);
        int m491RL295 = m491RL(m491RL290 + m490f1(m491RL293, m491RL291, m491RL294) + this.f5807X[4], 9) + m491RL292;
        int m491RL296 = m491RL(m491RL291, 10);
        int m491RL297 = m491RL(m491RL292 + m490f1(m491RL295, m491RL293, m491RL296) + this.f5807X[1], 12) + m491RL294;
        int m491RL298 = m491RL(m491RL293, 10);
        int m491RL299 = m491RL(m491RL294 + m490f1(m491RL297, m491RL295, m491RL298) + this.f5807X[5], 5) + m491RL296;
        int m491RL300 = m491RL(m491RL295, 10);
        int m491RL301 = m491RL(m491RL296 + m490f1(m491RL299, m491RL297, m491RL300) + this.f5807X[8], 14) + m491RL298;
        int m491RL302 = m491RL(m491RL297, 10);
        int m491RL303 = m491RL(m491RL298 + m490f1(m491RL301, m491RL299, m491RL302) + this.f5807X[7], 6) + m491RL300;
        int m491RL304 = m491RL(m491RL299, 10);
        int m491RL305 = m491RL(m491RL300 + m490f1(m491RL303, m491RL301, m491RL304) + this.f5807X[6], 8) + m491RL302;
        int m491RL306 = m491RL(m491RL301, 10);
        int m491RL307 = m491RL(m491RL302 + m490f1(m491RL305, m491RL303, m491RL306) + this.f5807X[2], 13) + m491RL304;
        int m491RL308 = m491RL(m491RL303, 10);
        int m491RL309 = m491RL(m491RL304 + m490f1(m491RL307, m491RL305, m491RL308) + this.f5807X[13], 6) + m491RL306;
        int m491RL310 = m491RL(m491RL305, 10);
        int m491RL311 = m491RL(m491RL306 + m490f1(m491RL309, m491RL307, m491RL310) + this.f5807X[14], 5) + m491RL308;
        int m491RL312 = m491RL(m491RL307, 10);
        int m491RL313 = m491RL(m491RL308 + m490f1(m491RL311, m491RL309, m491RL312) + this.f5807X[0], 15) + m491RL310;
        int m491RL314 = m491RL(m491RL309, 10);
        int m491RL315 = m491RL(m491RL310 + m490f1(m491RL313, m491RL311, m491RL314) + this.f5807X[3], 13) + m491RL312;
        int m491RL316 = m491RL(m491RL311, 10);
        int m491RL317 = m491RL(m491RL312 + m490f1(m491RL315, m491RL313, m491RL316) + this.f5807X[9], 11) + m491RL314;
        int m491RL318 = m491RL(m491RL313, 10);
        int m491RL319 = m491RL(m491RL314 + m490f1(m491RL317, m491RL315, m491RL318) + this.f5807X[11], 11) + m491RL316;
        int m491RL320 = m491RL(m491RL315, 10);
        this.f5797H0 += m491RL284;
        this.f5798H1 += m491RL287;
        this.f5799H2 += m491RL285;
        this.f5800H3 += m491RL288;
        this.f5801H4 += m491RL318;
        this.f5802H5 += m491RL316;
        this.f5803H6 += m491RL319;
        this.f5804H7 += m491RL317;
        this.f5805H8 += m491RL320;
        this.f5806H9 += m491RL286;
        this.xOff = 0;
        int i11 = 0;
        while (true) {
            int[] iArr = this.f5807X;
            if (i11 == iArr.length) {
                return;
            }
            iArr[i11] = 0;
            i11++;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5807X;
        iArr[14] = (int) ((-1) & j);
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f5807X;
        int i2 = this.xOff;
        int i3 = i2 + 1;
        this.xOff = i3;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        if (i3 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.f5797H0 = 1732584193;
        this.f5798H1 = -271733879;
        this.f5799H2 = -1732584194;
        this.f5800H3 = 271733878;
        this.f5801H4 = -1009589776;
        this.f5802H5 = 1985229328;
        this.f5803H6 = -19088744;
        this.f5804H7 = -1985229329;
        this.f5805H8 = 19088743;
        this.f5806H9 = 1009589775;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5807X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public RIPEMD320Digest(RIPEMD320Digest rIPEMD320Digest) {
        super(rIPEMD320Digest);
        int[] iArr = new int[16];
        this.f5807X = iArr;
        this.f5797H0 = rIPEMD320Digest.f5797H0;
        this.f5798H1 = rIPEMD320Digest.f5798H1;
        this.f5799H2 = rIPEMD320Digest.f5799H2;
        this.f5800H3 = rIPEMD320Digest.f5800H3;
        this.f5801H4 = rIPEMD320Digest.f5801H4;
        this.f5802H5 = rIPEMD320Digest.f5802H5;
        this.f5803H6 = rIPEMD320Digest.f5803H6;
        this.f5804H7 = rIPEMD320Digest.f5804H7;
        this.f5805H8 = rIPEMD320Digest.f5805H8;
        this.f5806H9 = rIPEMD320Digest.f5806H9;
        int[] iArr2 = rIPEMD320Digest.f5807X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.xOff = rIPEMD320Digest.xOff;
    }
}
