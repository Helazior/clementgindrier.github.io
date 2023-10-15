package org.spongycastle.crypto.digests;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RIPEMD160Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;

    /* renamed from: H0 */
    private int f5782H0;

    /* renamed from: H1 */
    private int f5783H1;

    /* renamed from: H2 */
    private int f5784H2;

    /* renamed from: H3 */
    private int f5785H3;

    /* renamed from: H4 */
    private int f5786H4;

    /* renamed from: X */
    private int[] f5787X;
    private int xOff;

    public RIPEMD160Digest() {
        this.f5787X = new int[16];
        reset();
    }

    /* renamed from: RL */
    private int m506RL(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: f1 */
    private int m505f1(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    /* renamed from: f2 */
    private int m504f2(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: f3 */
    private int m503f3(int i, int i2, int i3) {
        return (i | (~i2)) ^ i3;
    }

    /* renamed from: f4 */
    private int m502f4(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    /* renamed from: f5 */
    private int m501f5(int i, int i2, int i3) {
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
        unpackWord(this.f5782H0, bArr, i);
        unpackWord(this.f5783H1, bArr, i + 4);
        unpackWord(this.f5784H2, bArr, i + 8);
        unpackWord(this.f5785H3, bArr, i + 12);
        unpackWord(this.f5786H4, bArr, i + 16);
        reset();
        return 20;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD160";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i = this.f5782H0;
        int i2 = this.f5783H1;
        int i3 = this.f5784H2;
        int i4 = this.f5785H3;
        int i5 = this.f5786H4;
        int m506RL = m506RL(m505f1(i2, i3, i4) + i + this.f5787X[0], 11) + i5;
        int m506RL2 = m506RL(i3, 10);
        int m506RL3 = m506RL(m505f1(m506RL, i2, m506RL2) + i5 + this.f5787X[1], 14) + i4;
        int m506RL4 = m506RL(i2, 10);
        int m506RL5 = m506RL(m505f1(m506RL3, m506RL, m506RL4) + i4 + this.f5787X[2], 15) + m506RL2;
        int m506RL6 = m506RL(m506RL, 10);
        int m506RL7 = m506RL(m506RL2 + m505f1(m506RL5, m506RL3, m506RL6) + this.f5787X[3], 12) + m506RL4;
        int m506RL8 = m506RL(m506RL3, 10);
        int m506RL9 = m506RL(m506RL4 + m505f1(m506RL7, m506RL5, m506RL8) + this.f5787X[4], 5) + m506RL6;
        int m506RL10 = m506RL(m506RL5, 10);
        int m506RL11 = m506RL(m506RL6 + m505f1(m506RL9, m506RL7, m506RL10) + this.f5787X[5], 8) + m506RL8;
        int m506RL12 = m506RL(m506RL7, 10);
        int m506RL13 = m506RL(m506RL8 + m505f1(m506RL11, m506RL9, m506RL12) + this.f5787X[6], 7) + m506RL10;
        int m506RL14 = m506RL(m506RL9, 10);
        int m506RL15 = m506RL(m506RL10 + m505f1(m506RL13, m506RL11, m506RL14) + this.f5787X[7], 9) + m506RL12;
        int m506RL16 = m506RL(m506RL11, 10);
        int m506RL17 = m506RL(m506RL12 + m505f1(m506RL15, m506RL13, m506RL16) + this.f5787X[8], 11) + m506RL14;
        int m506RL18 = m506RL(m506RL13, 10);
        int m506RL19 = m506RL(m506RL14 + m505f1(m506RL17, m506RL15, m506RL18) + this.f5787X[9], 13) + m506RL16;
        int m506RL20 = m506RL(m506RL15, 10);
        int m506RL21 = m506RL(m506RL16 + m505f1(m506RL19, m506RL17, m506RL20) + this.f5787X[10], 14) + m506RL18;
        int m506RL22 = m506RL(m506RL17, 10);
        int m506RL23 = m506RL(m506RL18 + m505f1(m506RL21, m506RL19, m506RL22) + this.f5787X[11], 15) + m506RL20;
        int m506RL24 = m506RL(m506RL19, 10);
        int m506RL25 = m506RL(m506RL20 + m505f1(m506RL23, m506RL21, m506RL24) + this.f5787X[12], 6) + m506RL22;
        int m506RL26 = m506RL(m506RL21, 10);
        int m506RL27 = m506RL(m506RL22 + m505f1(m506RL25, m506RL23, m506RL26) + this.f5787X[13], 7) + m506RL24;
        int m506RL28 = m506RL(m506RL23, 10);
        int m506RL29 = m506RL(m506RL24 + m505f1(m506RL27, m506RL25, m506RL28) + this.f5787X[14], 9) + m506RL26;
        int m506RL30 = m506RL(m506RL25, 10);
        int m506RL31 = m506RL(m506RL26 + m505f1(m506RL29, m506RL27, m506RL30) + this.f5787X[15], 8) + m506RL28;
        int m506RL32 = m506RL(m506RL27, 10);
        int m506RL33 = m506RL(i + m501f5(i2, i3, i4) + this.f5787X[5] + 1352829926, 8) + i5;
        int m506RL34 = m506RL(i3, 10);
        int m506RL35 = m506RL(i5 + m501f5(m506RL33, i2, m506RL34) + this.f5787X[14] + 1352829926, 9) + i4;
        int m506RL36 = m506RL(i2, 10);
        int m506RL37 = m506RL(i4 + m501f5(m506RL35, m506RL33, m506RL36) + this.f5787X[7] + 1352829926, 9) + m506RL34;
        int m506RL38 = m506RL(m506RL33, 10);
        int m506RL39 = m506RL(m506RL34 + m501f5(m506RL37, m506RL35, m506RL38) + this.f5787X[0] + 1352829926, 11) + m506RL36;
        int m506RL40 = m506RL(m506RL35, 10);
        int m506RL41 = m506RL(m506RL36 + m501f5(m506RL39, m506RL37, m506RL40) + this.f5787X[9] + 1352829926, 13) + m506RL38;
        int m506RL42 = m506RL(m506RL37, 10);
        int m506RL43 = m506RL(m506RL38 + m501f5(m506RL41, m506RL39, m506RL42) + this.f5787X[2] + 1352829926, 15) + m506RL40;
        int m506RL44 = m506RL(m506RL39, 10);
        int m506RL45 = m506RL(m506RL40 + m501f5(m506RL43, m506RL41, m506RL44) + this.f5787X[11] + 1352829926, 15) + m506RL42;
        int m506RL46 = m506RL(m506RL41, 10);
        int m506RL47 = m506RL(m506RL42 + m501f5(m506RL45, m506RL43, m506RL46) + this.f5787X[4] + 1352829926, 5) + m506RL44;
        int m506RL48 = m506RL(m506RL43, 10);
        int m506RL49 = m506RL(m506RL44 + m501f5(m506RL47, m506RL45, m506RL48) + this.f5787X[13] + 1352829926, 7) + m506RL46;
        int m506RL50 = m506RL(m506RL45, 10);
        int m506RL51 = m506RL(m506RL46 + m501f5(m506RL49, m506RL47, m506RL50) + this.f5787X[6] + 1352829926, 7) + m506RL48;
        int m506RL52 = m506RL(m506RL47, 10);
        int m506RL53 = m506RL(m506RL48 + m501f5(m506RL51, m506RL49, m506RL52) + this.f5787X[15] + 1352829926, 8) + m506RL50;
        int m506RL54 = m506RL(m506RL49, 10);
        int m506RL55 = m506RL(m506RL50 + m501f5(m506RL53, m506RL51, m506RL54) + this.f5787X[8] + 1352829926, 11) + m506RL52;
        int m506RL56 = m506RL(m506RL51, 10);
        int m506RL57 = m506RL(m506RL52 + m501f5(m506RL55, m506RL53, m506RL56) + this.f5787X[1] + 1352829926, 14) + m506RL54;
        int m506RL58 = m506RL(m506RL53, 10);
        int m506RL59 = m506RL(m506RL54 + m501f5(m506RL57, m506RL55, m506RL58) + this.f5787X[10] + 1352829926, 14) + m506RL56;
        int m506RL60 = m506RL(m506RL55, 10);
        int m506RL61 = m506RL(m506RL56 + m501f5(m506RL59, m506RL57, m506RL60) + this.f5787X[3] + 1352829926, 12) + m506RL58;
        int m506RL62 = m506RL(m506RL57, 10);
        int m506RL63 = m506RL(m506RL58 + m501f5(m506RL61, m506RL59, m506RL62) + this.f5787X[12] + 1352829926, 6) + m506RL60;
        int m506RL64 = m506RL(m506RL59, 10);
        int m506RL65 = m506RL(m506RL28 + m504f2(m506RL31, m506RL29, m506RL32) + this.f5787X[7] + 1518500249, 7) + m506RL30;
        int m506RL66 = m506RL(m506RL29, 10);
        int m506RL67 = m506RL(m506RL30 + m504f2(m506RL65, m506RL31, m506RL66) + this.f5787X[4] + 1518500249, 6) + m506RL32;
        int m506RL68 = m506RL(m506RL31, 10);
        int m506RL69 = m506RL(m506RL32 + m504f2(m506RL67, m506RL65, m506RL68) + this.f5787X[13] + 1518500249, 8) + m506RL66;
        int m506RL70 = m506RL(m506RL65, 10);
        int m506RL71 = m506RL(m506RL66 + m504f2(m506RL69, m506RL67, m506RL70) + this.f5787X[1] + 1518500249, 13) + m506RL68;
        int m506RL72 = m506RL(m506RL67, 10);
        int m506RL73 = m506RL(m506RL68 + m504f2(m506RL71, m506RL69, m506RL72) + this.f5787X[10] + 1518500249, 11) + m506RL70;
        int m506RL74 = m506RL(m506RL69, 10);
        int m506RL75 = m506RL(m506RL70 + m504f2(m506RL73, m506RL71, m506RL74) + this.f5787X[6] + 1518500249, 9) + m506RL72;
        int m506RL76 = m506RL(m506RL71, 10);
        int m506RL77 = m506RL(m506RL72 + m504f2(m506RL75, m506RL73, m506RL76) + this.f5787X[15] + 1518500249, 7) + m506RL74;
        int m506RL78 = m506RL(m506RL73, 10);
        int m506RL79 = m506RL(m506RL74 + m504f2(m506RL77, m506RL75, m506RL78) + this.f5787X[3] + 1518500249, 15) + m506RL76;
        int m506RL80 = m506RL(m506RL75, 10);
        int m506RL81 = m506RL(m506RL76 + m504f2(m506RL79, m506RL77, m506RL80) + this.f5787X[12] + 1518500249, 7) + m506RL78;
        int m506RL82 = m506RL(m506RL77, 10);
        int m506RL83 = m506RL(m506RL78 + m504f2(m506RL81, m506RL79, m506RL82) + this.f5787X[0] + 1518500249, 12) + m506RL80;
        int m506RL84 = m506RL(m506RL79, 10);
        int m506RL85 = m506RL(m506RL80 + m504f2(m506RL83, m506RL81, m506RL84) + this.f5787X[9] + 1518500249, 15) + m506RL82;
        int m506RL86 = m506RL(m506RL81, 10);
        int m506RL87 = m506RL(m506RL82 + m504f2(m506RL85, m506RL83, m506RL86) + this.f5787X[5] + 1518500249, 9) + m506RL84;
        int m506RL88 = m506RL(m506RL83, 10);
        int m506RL89 = m506RL(m506RL84 + m504f2(m506RL87, m506RL85, m506RL88) + this.f5787X[2] + 1518500249, 11) + m506RL86;
        int m506RL90 = m506RL(m506RL85, 10);
        int m506RL91 = m506RL(m506RL86 + m504f2(m506RL89, m506RL87, m506RL90) + this.f5787X[14] + 1518500249, 7) + m506RL88;
        int m506RL92 = m506RL(m506RL87, 10);
        int m506RL93 = m506RL(m506RL88 + m504f2(m506RL91, m506RL89, m506RL92) + this.f5787X[11] + 1518500249, 13) + m506RL90;
        int m506RL94 = m506RL(m506RL89, 10);
        int m506RL95 = m506RL(m506RL90 + m504f2(m506RL93, m506RL91, m506RL94) + this.f5787X[8] + 1518500249, 12) + m506RL92;
        int m506RL96 = m506RL(m506RL91, 10);
        int m506RL97 = m506RL(m506RL60 + m502f4(m506RL63, m506RL61, m506RL64) + this.f5787X[6] + 1548603684, 9) + m506RL62;
        int m506RL98 = m506RL(m506RL61, 10);
        int m506RL99 = m506RL(m506RL62 + m502f4(m506RL97, m506RL63, m506RL98) + this.f5787X[11] + 1548603684, 13) + m506RL64;
        int m506RL100 = m506RL(m506RL63, 10);
        int m506RL101 = m506RL(m506RL64 + m502f4(m506RL99, m506RL97, m506RL100) + this.f5787X[3] + 1548603684, 15) + m506RL98;
        int m506RL102 = m506RL(m506RL97, 10);
        int m506RL103 = m506RL(m506RL98 + m502f4(m506RL101, m506RL99, m506RL102) + this.f5787X[7] + 1548603684, 7) + m506RL100;
        int m506RL104 = m506RL(m506RL99, 10);
        int m506RL105 = m506RL(m506RL100 + m502f4(m506RL103, m506RL101, m506RL104) + this.f5787X[0] + 1548603684, 12) + m506RL102;
        int m506RL106 = m506RL(m506RL101, 10);
        int m506RL107 = m506RL(m506RL102 + m502f4(m506RL105, m506RL103, m506RL106) + this.f5787X[13] + 1548603684, 8) + m506RL104;
        int m506RL108 = m506RL(m506RL103, 10);
        int m506RL109 = m506RL(m506RL104 + m502f4(m506RL107, m506RL105, m506RL108) + this.f5787X[5] + 1548603684, 9) + m506RL106;
        int m506RL110 = m506RL(m506RL105, 10);
        int m506RL111 = m506RL(m506RL106 + m502f4(m506RL109, m506RL107, m506RL110) + this.f5787X[10] + 1548603684, 11) + m506RL108;
        int m506RL112 = m506RL(m506RL107, 10);
        int m506RL113 = m506RL(m506RL108 + m502f4(m506RL111, m506RL109, m506RL112) + this.f5787X[14] + 1548603684, 7) + m506RL110;
        int m506RL114 = m506RL(m506RL109, 10);
        int m506RL115 = m506RL(m506RL110 + m502f4(m506RL113, m506RL111, m506RL114) + this.f5787X[15] + 1548603684, 7) + m506RL112;
        int m506RL116 = m506RL(m506RL111, 10);
        int m506RL117 = m506RL(m506RL112 + m502f4(m506RL115, m506RL113, m506RL116) + this.f5787X[8] + 1548603684, 12) + m506RL114;
        int m506RL118 = m506RL(m506RL113, 10);
        int m506RL119 = m506RL(m506RL114 + m502f4(m506RL117, m506RL115, m506RL118) + this.f5787X[12] + 1548603684, 7) + m506RL116;
        int m506RL120 = m506RL(m506RL115, 10);
        int m506RL121 = m506RL(m506RL116 + m502f4(m506RL119, m506RL117, m506RL120) + this.f5787X[4] + 1548603684, 6) + m506RL118;
        int m506RL122 = m506RL(m506RL117, 10);
        int m506RL123 = m506RL(m506RL118 + m502f4(m506RL121, m506RL119, m506RL122) + this.f5787X[9] + 1548603684, 15) + m506RL120;
        int m506RL124 = m506RL(m506RL119, 10);
        int m506RL125 = m506RL(m506RL120 + m502f4(m506RL123, m506RL121, m506RL124) + this.f5787X[1] + 1548603684, 13) + m506RL122;
        int m506RL126 = m506RL(m506RL121, 10);
        int m506RL127 = m506RL(m506RL122 + m502f4(m506RL125, m506RL123, m506RL126) + this.f5787X[2] + 1548603684, 11) + m506RL124;
        int m506RL128 = m506RL(m506RL123, 10);
        int m506RL129 = m506RL(m506RL92 + m503f3(m506RL95, m506RL93, m506RL96) + this.f5787X[3] + 1859775393, 11) + m506RL94;
        int m506RL130 = m506RL(m506RL93, 10);
        int m506RL131 = m506RL(m506RL94 + m503f3(m506RL129, m506RL95, m506RL130) + this.f5787X[10] + 1859775393, 13) + m506RL96;
        int m506RL132 = m506RL(m506RL95, 10);
        int m506RL133 = m506RL(m506RL96 + m503f3(m506RL131, m506RL129, m506RL132) + this.f5787X[14] + 1859775393, 6) + m506RL130;
        int m506RL134 = m506RL(m506RL129, 10);
        int m506RL135 = m506RL(m506RL130 + m503f3(m506RL133, m506RL131, m506RL134) + this.f5787X[4] + 1859775393, 7) + m506RL132;
        int m506RL136 = m506RL(m506RL131, 10);
        int m506RL137 = m506RL(m506RL132 + m503f3(m506RL135, m506RL133, m506RL136) + this.f5787X[9] + 1859775393, 14) + m506RL134;
        int m506RL138 = m506RL(m506RL133, 10);
        int m506RL139 = m506RL(m506RL134 + m503f3(m506RL137, m506RL135, m506RL138) + this.f5787X[15] + 1859775393, 9) + m506RL136;
        int m506RL140 = m506RL(m506RL135, 10);
        int m506RL141 = m506RL(m506RL136 + m503f3(m506RL139, m506RL137, m506RL140) + this.f5787X[8] + 1859775393, 13) + m506RL138;
        int m506RL142 = m506RL(m506RL137, 10);
        int m506RL143 = m506RL(m506RL138 + m503f3(m506RL141, m506RL139, m506RL142) + this.f5787X[1] + 1859775393, 15) + m506RL140;
        int m506RL144 = m506RL(m506RL139, 10);
        int m506RL145 = m506RL(m506RL140 + m503f3(m506RL143, m506RL141, m506RL144) + this.f5787X[2] + 1859775393, 14) + m506RL142;
        int m506RL146 = m506RL(m506RL141, 10);
        int m506RL147 = m506RL(m506RL142 + m503f3(m506RL145, m506RL143, m506RL146) + this.f5787X[7] + 1859775393, 8) + m506RL144;
        int m506RL148 = m506RL(m506RL143, 10);
        int m506RL149 = m506RL(m506RL144 + m503f3(m506RL147, m506RL145, m506RL148) + this.f5787X[0] + 1859775393, 13) + m506RL146;
        int m506RL150 = m506RL(m506RL145, 10);
        int m506RL151 = m506RL(m506RL146 + m503f3(m506RL149, m506RL147, m506RL150) + this.f5787X[6] + 1859775393, 6) + m506RL148;
        int m506RL152 = m506RL(m506RL147, 10);
        int m506RL153 = m506RL(m506RL148 + m503f3(m506RL151, m506RL149, m506RL152) + this.f5787X[13] + 1859775393, 5) + m506RL150;
        int m506RL154 = m506RL(m506RL149, 10);
        int m506RL155 = m506RL(m506RL150 + m503f3(m506RL153, m506RL151, m506RL154) + this.f5787X[11] + 1859775393, 12) + m506RL152;
        int m506RL156 = m506RL(m506RL151, 10);
        int m506RL157 = m506RL(m506RL152 + m503f3(m506RL155, m506RL153, m506RL156) + this.f5787X[5] + 1859775393, 7) + m506RL154;
        int m506RL158 = m506RL(m506RL153, 10);
        int m506RL159 = m506RL(m506RL154 + m503f3(m506RL157, m506RL155, m506RL158) + this.f5787X[12] + 1859775393, 5) + m506RL156;
        int m506RL160 = m506RL(m506RL155, 10);
        int m506RL161 = m506RL(m506RL124 + m503f3(m506RL127, m506RL125, m506RL128) + this.f5787X[15] + 1836072691, 9) + m506RL126;
        int m506RL162 = m506RL(m506RL125, 10);
        int m506RL163 = m506RL(m506RL126 + m503f3(m506RL161, m506RL127, m506RL162) + this.f5787X[5] + 1836072691, 7) + m506RL128;
        int m506RL164 = m506RL(m506RL127, 10);
        int m506RL165 = m506RL(m506RL128 + m503f3(m506RL163, m506RL161, m506RL164) + this.f5787X[1] + 1836072691, 15) + m506RL162;
        int m506RL166 = m506RL(m506RL161, 10);
        int m506RL167 = m506RL(m506RL162 + m503f3(m506RL165, m506RL163, m506RL166) + this.f5787X[3] + 1836072691, 11) + m506RL164;
        int m506RL168 = m506RL(m506RL163, 10);
        int m506RL169 = m506RL(m506RL164 + m503f3(m506RL167, m506RL165, m506RL168) + this.f5787X[7] + 1836072691, 8) + m506RL166;
        int m506RL170 = m506RL(m506RL165, 10);
        int m506RL171 = m506RL(m506RL166 + m503f3(m506RL169, m506RL167, m506RL170) + this.f5787X[14] + 1836072691, 6) + m506RL168;
        int m506RL172 = m506RL(m506RL167, 10);
        int m506RL173 = m506RL(m506RL168 + m503f3(m506RL171, m506RL169, m506RL172) + this.f5787X[6] + 1836072691, 6) + m506RL170;
        int m506RL174 = m506RL(m506RL169, 10);
        int m506RL175 = m506RL(m506RL170 + m503f3(m506RL173, m506RL171, m506RL174) + this.f5787X[9] + 1836072691, 14) + m506RL172;
        int m506RL176 = m506RL(m506RL171, 10);
        int m506RL177 = m506RL(m506RL172 + m503f3(m506RL175, m506RL173, m506RL176) + this.f5787X[11] + 1836072691, 12) + m506RL174;
        int m506RL178 = m506RL(m506RL173, 10);
        int m506RL179 = m506RL(m506RL174 + m503f3(m506RL177, m506RL175, m506RL178) + this.f5787X[8] + 1836072691, 13) + m506RL176;
        int m506RL180 = m506RL(m506RL175, 10);
        int m506RL181 = m506RL(m506RL176 + m503f3(m506RL179, m506RL177, m506RL180) + this.f5787X[12] + 1836072691, 5) + m506RL178;
        int m506RL182 = m506RL(m506RL177, 10);
        int m506RL183 = m506RL(m506RL178 + m503f3(m506RL181, m506RL179, m506RL182) + this.f5787X[2] + 1836072691, 14) + m506RL180;
        int m506RL184 = m506RL(m506RL179, 10);
        int m506RL185 = m506RL(m506RL180 + m503f3(m506RL183, m506RL181, m506RL184) + this.f5787X[10] + 1836072691, 13) + m506RL182;
        int m506RL186 = m506RL(m506RL181, 10);
        int m506RL187 = m506RL(m506RL182 + m503f3(m506RL185, m506RL183, m506RL186) + this.f5787X[0] + 1836072691, 13) + m506RL184;
        int m506RL188 = m506RL(m506RL183, 10);
        int m506RL189 = m506RL(m506RL184 + m503f3(m506RL187, m506RL185, m506RL188) + this.f5787X[4] + 1836072691, 7) + m506RL186;
        int m506RL190 = m506RL(m506RL185, 10);
        int m506RL191 = m506RL(m506RL186 + m503f3(m506RL189, m506RL187, m506RL190) + this.f5787X[13] + 1836072691, 5) + m506RL188;
        int m506RL192 = m506RL(m506RL187, 10);
        int m506RL193 = m506RL(((m506RL156 + m502f4(m506RL159, m506RL157, m506RL160)) + this.f5787X[1]) - 1894007588, 11) + m506RL158;
        int m506RL194 = m506RL(m506RL157, 10);
        int m506RL195 = m506RL(((m506RL158 + m502f4(m506RL193, m506RL159, m506RL194)) + this.f5787X[9]) - 1894007588, 12) + m506RL160;
        int m506RL196 = m506RL(m506RL159, 10);
        int m506RL197 = m506RL(((m506RL160 + m502f4(m506RL195, m506RL193, m506RL196)) + this.f5787X[11]) - 1894007588, 14) + m506RL194;
        int m506RL198 = m506RL(m506RL193, 10);
        int m506RL199 = m506RL(((m506RL194 + m502f4(m506RL197, m506RL195, m506RL198)) + this.f5787X[10]) - 1894007588, 15) + m506RL196;
        int m506RL200 = m506RL(m506RL195, 10);
        int m506RL201 = m506RL(((m506RL196 + m502f4(m506RL199, m506RL197, m506RL200)) + this.f5787X[0]) - 1894007588, 14) + m506RL198;
        int m506RL202 = m506RL(m506RL197, 10);
        int m506RL203 = m506RL(((m506RL198 + m502f4(m506RL201, m506RL199, m506RL202)) + this.f5787X[8]) - 1894007588, 15) + m506RL200;
        int m506RL204 = m506RL(m506RL199, 10);
        int m506RL205 = m506RL(((m506RL200 + m502f4(m506RL203, m506RL201, m506RL204)) + this.f5787X[12]) - 1894007588, 9) + m506RL202;
        int m506RL206 = m506RL(m506RL201, 10);
        int m506RL207 = m506RL(((m506RL202 + m502f4(m506RL205, m506RL203, m506RL206)) + this.f5787X[4]) - 1894007588, 8) + m506RL204;
        int m506RL208 = m506RL(m506RL203, 10);
        int m506RL209 = m506RL(((m506RL204 + m502f4(m506RL207, m506RL205, m506RL208)) + this.f5787X[13]) - 1894007588, 9) + m506RL206;
        int m506RL210 = m506RL(m506RL205, 10);
        int m506RL211 = m506RL(((m506RL206 + m502f4(m506RL209, m506RL207, m506RL210)) + this.f5787X[3]) - 1894007588, 14) + m506RL208;
        int m506RL212 = m506RL(m506RL207, 10);
        int m506RL213 = m506RL(((m506RL208 + m502f4(m506RL211, m506RL209, m506RL212)) + this.f5787X[7]) - 1894007588, 5) + m506RL210;
        int m506RL214 = m506RL(m506RL209, 10);
        int m506RL215 = m506RL(((m506RL210 + m502f4(m506RL213, m506RL211, m506RL214)) + this.f5787X[15]) - 1894007588, 6) + m506RL212;
        int m506RL216 = m506RL(m506RL211, 10);
        int m506RL217 = m506RL(((m506RL212 + m502f4(m506RL215, m506RL213, m506RL216)) + this.f5787X[14]) - 1894007588, 8) + m506RL214;
        int m506RL218 = m506RL(m506RL213, 10);
        int m506RL219 = m506RL(((m506RL214 + m502f4(m506RL217, m506RL215, m506RL218)) + this.f5787X[5]) - 1894007588, 6) + m506RL216;
        int m506RL220 = m506RL(m506RL215, 10);
        int m506RL221 = m506RL(((m506RL216 + m502f4(m506RL219, m506RL217, m506RL220)) + this.f5787X[6]) - 1894007588, 5) + m506RL218;
        int m506RL222 = m506RL(m506RL217, 10);
        int m506RL223 = m506RL(((m506RL218 + m502f4(m506RL221, m506RL219, m506RL222)) + this.f5787X[2]) - 1894007588, 12) + m506RL220;
        int m506RL224 = m506RL(m506RL219, 10);
        int m506RL225 = m506RL(m506RL188 + m504f2(m506RL191, m506RL189, m506RL192) + this.f5787X[8] + 2053994217, 15) + m506RL190;
        int m506RL226 = m506RL(m506RL189, 10);
        int m506RL227 = m506RL(m506RL190 + m504f2(m506RL225, m506RL191, m506RL226) + this.f5787X[6] + 2053994217, 5) + m506RL192;
        int m506RL228 = m506RL(m506RL191, 10);
        int m506RL229 = m506RL(m506RL192 + m504f2(m506RL227, m506RL225, m506RL228) + this.f5787X[4] + 2053994217, 8) + m506RL226;
        int m506RL230 = m506RL(m506RL225, 10);
        int m506RL231 = m506RL(m506RL226 + m504f2(m506RL229, m506RL227, m506RL230) + this.f5787X[1] + 2053994217, 11) + m506RL228;
        int m506RL232 = m506RL(m506RL227, 10);
        int m506RL233 = m506RL(m506RL228 + m504f2(m506RL231, m506RL229, m506RL232) + this.f5787X[3] + 2053994217, 14) + m506RL230;
        int m506RL234 = m506RL(m506RL229, 10);
        int m506RL235 = m506RL(m506RL230 + m504f2(m506RL233, m506RL231, m506RL234) + this.f5787X[11] + 2053994217, 14) + m506RL232;
        int m506RL236 = m506RL(m506RL231, 10);
        int m506RL237 = m506RL(m506RL232 + m504f2(m506RL235, m506RL233, m506RL236) + this.f5787X[15] + 2053994217, 6) + m506RL234;
        int m506RL238 = m506RL(m506RL233, 10);
        int m506RL239 = m506RL(m506RL234 + m504f2(m506RL237, m506RL235, m506RL238) + this.f5787X[0] + 2053994217, 14) + m506RL236;
        int m506RL240 = m506RL(m506RL235, 10);
        int m506RL241 = m506RL(m506RL236 + m504f2(m506RL239, m506RL237, m506RL240) + this.f5787X[5] + 2053994217, 6) + m506RL238;
        int m506RL242 = m506RL(m506RL237, 10);
        int m506RL243 = m506RL(m506RL238 + m504f2(m506RL241, m506RL239, m506RL242) + this.f5787X[12] + 2053994217, 9) + m506RL240;
        int m506RL244 = m506RL(m506RL239, 10);
        int m506RL245 = m506RL(m506RL240 + m504f2(m506RL243, m506RL241, m506RL244) + this.f5787X[2] + 2053994217, 12) + m506RL242;
        int m506RL246 = m506RL(m506RL241, 10);
        int m506RL247 = m506RL(m506RL242 + m504f2(m506RL245, m506RL243, m506RL246) + this.f5787X[13] + 2053994217, 9) + m506RL244;
        int m506RL248 = m506RL(m506RL243, 10);
        int m506RL249 = m506RL(m506RL244 + m504f2(m506RL247, m506RL245, m506RL248) + this.f5787X[9] + 2053994217, 12) + m506RL246;
        int m506RL250 = m506RL(m506RL245, 10);
        int m506RL251 = m506RL(m506RL246 + m504f2(m506RL249, m506RL247, m506RL250) + this.f5787X[7] + 2053994217, 5) + m506RL248;
        int m506RL252 = m506RL(m506RL247, 10);
        int m506RL253 = m506RL(m506RL248 + m504f2(m506RL251, m506RL249, m506RL252) + this.f5787X[10] + 2053994217, 15) + m506RL250;
        int m506RL254 = m506RL(m506RL249, 10);
        int m506RL255 = m506RL(m506RL250 + m504f2(m506RL253, m506RL251, m506RL254) + this.f5787X[14] + 2053994217, 8) + m506RL252;
        int m506RL256 = m506RL(m506RL251, 10);
        int m506RL257 = m506RL(((m506RL220 + m501f5(m506RL223, m506RL221, m506RL224)) + this.f5787X[4]) - 1454113458, 9) + m506RL222;
        int m506RL258 = m506RL(m506RL221, 10);
        int m506RL259 = m506RL(((m506RL222 + m501f5(m506RL257, m506RL223, m506RL258)) + this.f5787X[0]) - 1454113458, 15) + m506RL224;
        int m506RL260 = m506RL(m506RL223, 10);
        int m506RL261 = m506RL(((m506RL224 + m501f5(m506RL259, m506RL257, m506RL260)) + this.f5787X[5]) - 1454113458, 5) + m506RL258;
        int m506RL262 = m506RL(m506RL257, 10);
        int m506RL263 = m506RL(((m506RL258 + m501f5(m506RL261, m506RL259, m506RL262)) + this.f5787X[9]) - 1454113458, 11) + m506RL260;
        int m506RL264 = m506RL(m506RL259, 10);
        int m506RL265 = m506RL(((m506RL260 + m501f5(m506RL263, m506RL261, m506RL264)) + this.f5787X[7]) - 1454113458, 6) + m506RL262;
        int m506RL266 = m506RL(m506RL261, 10);
        int m506RL267 = m506RL(((m506RL262 + m501f5(m506RL265, m506RL263, m506RL266)) + this.f5787X[12]) - 1454113458, 8) + m506RL264;
        int m506RL268 = m506RL(m506RL263, 10);
        int m506RL269 = m506RL(((m506RL264 + m501f5(m506RL267, m506RL265, m506RL268)) + this.f5787X[2]) - 1454113458, 13) + m506RL266;
        int m506RL270 = m506RL(m506RL265, 10);
        int m506RL271 = m506RL(((m506RL266 + m501f5(m506RL269, m506RL267, m506RL270)) + this.f5787X[10]) - 1454113458, 12) + m506RL268;
        int m506RL272 = m506RL(m506RL267, 10);
        int m506RL273 = m506RL(((m506RL268 + m501f5(m506RL271, m506RL269, m506RL272)) + this.f5787X[14]) - 1454113458, 5) + m506RL270;
        int m506RL274 = m506RL(m506RL269, 10);
        int m506RL275 = m506RL(((m506RL270 + m501f5(m506RL273, m506RL271, m506RL274)) + this.f5787X[1]) - 1454113458, 12) + m506RL272;
        int m506RL276 = m506RL(m506RL271, 10);
        int m506RL277 = m506RL(((m506RL272 + m501f5(m506RL275, m506RL273, m506RL276)) + this.f5787X[3]) - 1454113458, 13) + m506RL274;
        int m506RL278 = m506RL(m506RL273, 10);
        int m506RL279 = m506RL(((m506RL274 + m501f5(m506RL277, m506RL275, m506RL278)) + this.f5787X[8]) - 1454113458, 14) + m506RL276;
        int m506RL280 = m506RL(m506RL275, 10);
        int m506RL281 = m506RL(((m506RL276 + m501f5(m506RL279, m506RL277, m506RL280)) + this.f5787X[11]) - 1454113458, 11) + m506RL278;
        int m506RL282 = m506RL(m506RL277, 10);
        int m506RL283 = m506RL(((m506RL278 + m501f5(m506RL281, m506RL279, m506RL282)) + this.f5787X[6]) - 1454113458, 8) + m506RL280;
        int m506RL284 = m506RL(m506RL279, 10);
        int m506RL285 = m506RL(((m506RL280 + m501f5(m506RL283, m506RL281, m506RL284)) + this.f5787X[15]) - 1454113458, 5) + m506RL282;
        int m506RL286 = m506RL(m506RL281, 10);
        int m506RL287 = m506RL(m506RL283, 10);
        int m506RL288 = m506RL(m506RL252 + m505f1(m506RL255, m506RL253, m506RL256) + this.f5787X[12], 8) + m506RL254;
        int m506RL289 = m506RL(m506RL253, 10);
        int m506RL290 = m506RL(m506RL254 + m505f1(m506RL288, m506RL255, m506RL289) + this.f5787X[15], 5) + m506RL256;
        int m506RL291 = m506RL(m506RL255, 10);
        int m506RL292 = m506RL(m506RL256 + m505f1(m506RL290, m506RL288, m506RL291) + this.f5787X[10], 12) + m506RL289;
        int m506RL293 = m506RL(m506RL288, 10);
        int m506RL294 = m506RL(m506RL289 + m505f1(m506RL292, m506RL290, m506RL293) + this.f5787X[4], 9) + m506RL291;
        int m506RL295 = m506RL(m506RL290, 10);
        int m506RL296 = m506RL(m506RL291 + m505f1(m506RL294, m506RL292, m506RL295) + this.f5787X[1], 12) + m506RL293;
        int m506RL297 = m506RL(m506RL292, 10);
        int m506RL298 = m506RL(m506RL293 + m505f1(m506RL296, m506RL294, m506RL297) + this.f5787X[5], 5) + m506RL295;
        int m506RL299 = m506RL(m506RL294, 10);
        int m506RL300 = m506RL(m506RL295 + m505f1(m506RL298, m506RL296, m506RL299) + this.f5787X[8], 14) + m506RL297;
        int m506RL301 = m506RL(m506RL296, 10);
        int m506RL302 = m506RL(m506RL297 + m505f1(m506RL300, m506RL298, m506RL301) + this.f5787X[7], 6) + m506RL299;
        int m506RL303 = m506RL(m506RL298, 10);
        int m506RL304 = m506RL(m506RL299 + m505f1(m506RL302, m506RL300, m506RL303) + this.f5787X[6], 8) + m506RL301;
        int m506RL305 = m506RL(m506RL300, 10);
        int m506RL306 = m506RL(m506RL301 + m505f1(m506RL304, m506RL302, m506RL305) + this.f5787X[2], 13) + m506RL303;
        int m506RL307 = m506RL(m506RL302, 10);
        int m506RL308 = m506RL(m506RL303 + m505f1(m506RL306, m506RL304, m506RL307) + this.f5787X[13], 6) + m506RL305;
        int m506RL309 = m506RL(m506RL304, 10);
        int m506RL310 = m506RL(m506RL305 + m505f1(m506RL308, m506RL306, m506RL309) + this.f5787X[14], 5) + m506RL307;
        int m506RL311 = m506RL(m506RL306, 10);
        int m506RL312 = m506RL(m506RL307 + m505f1(m506RL310, m506RL308, m506RL311) + this.f5787X[0], 15) + m506RL309;
        int m506RL313 = m506RL(m506RL308, 10);
        int m506RL314 = m506RL(m506RL309 + m505f1(m506RL312, m506RL310, m506RL313) + this.f5787X[3], 13) + m506RL311;
        int m506RL315 = m506RL(m506RL310, 10);
        int m506RL316 = m506RL(m506RL311 + m505f1(m506RL314, m506RL312, m506RL315) + this.f5787X[9], 11) + m506RL313;
        int m506RL317 = m506RL(m506RL312, 10);
        int m506RL318 = m506RL(m506RL313 + m505f1(m506RL316, m506RL314, m506RL317) + this.f5787X[11], 11) + m506RL315;
        int m506RL319 = m506RL285 + this.f5783H1 + m506RL(m506RL314, 10);
        this.f5783H1 = this.f5784H2 + m506RL287 + m506RL317;
        this.f5784H2 = this.f5785H3 + m506RL286 + m506RL315;
        this.f5785H3 = this.f5786H4 + m506RL284 + m506RL318;
        this.f5786H4 = this.f5782H0 + m506RL(((m506RL282 + m501f5(m506RL285, m506RL283, m506RL286)) + this.f5787X[13]) - 1454113458, 6) + m506RL284 + m506RL316;
        this.f5782H0 = m506RL319;
        this.xOff = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f5787X;
            if (i6 == iArr.length) {
                return;
            }
            iArr[i6] = 0;
            i6++;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f5787X;
        iArr[14] = (int) ((-1) & j);
        iArr[15] = (int) (j >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.f5787X;
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
        this.f5782H0 = 1732584193;
        this.f5783H1 = -271733879;
        this.f5784H2 = -1732584194;
        this.f5785H3 = 271733878;
        this.f5786H4 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5787X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public RIPEMD160Digest(RIPEMD160Digest rIPEMD160Digest) {
        super(rIPEMD160Digest);
        int[] iArr = new int[16];
        this.f5787X = iArr;
        this.f5782H0 = rIPEMD160Digest.f5782H0;
        this.f5783H1 = rIPEMD160Digest.f5783H1;
        this.f5784H2 = rIPEMD160Digest.f5784H2;
        this.f5785H3 = rIPEMD160Digest.f5785H3;
        this.f5786H4 = rIPEMD160Digest.f5786H4;
        int[] iArr2 = rIPEMD160Digest.f5787X;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.xOff = rIPEMD160Digest.xOff;
    }
}
