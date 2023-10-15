package org.spongycastle.crypto.tls;

import java.io.OutputStream;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsRSAUtils {
    public static byte[] generateEncryptedPreMasterSecret(TlsClientContext tlsClientContext, RSAKeyParameters rSAKeyParameters, OutputStream outputStream) {
        byte[] bArr = new byte[48];
        tlsClientContext.getSecureRandom().nextBytes(bArr);
        TlsUtils.writeVersion(tlsClientContext.getClientVersion(), bArr, 0);
        PKCS1Encoding pKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(rSAKeyParameters, tlsClientContext.getSecureRandom());
        boolean z = true;
        pKCS1Encoding.init(true, parametersWithRandom);
        try {
            if (tlsClientContext.getServerVersion().getFullVersion() < ProtocolVersion.TLSv10.getFullVersion()) {
                z = false;
            }
            byte[] processBlock = pKCS1Encoding.processBlock(bArr, 0, 48);
            if (z) {
                TlsUtils.writeOpaque16(processBlock, outputStream);
            } else {
                outputStream.write(processBlock);
            }
            return bArr;
        } catch (InvalidCipherTextException unused) {
            throw new TlsFatalAlert((short) 80);
        }
    }
}
