package org.spongycastle.ocsp;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERGeneralizedTime;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.ocsp.BasicOCSPResponse;
import org.spongycastle.asn1.ocsp.CertStatus;
import org.spongycastle.asn1.ocsp.ResponseData;
import org.spongycastle.asn1.ocsp.RevokedInfo;
import org.spongycastle.asn1.ocsp.SingleResponse;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.CRLReason;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.asn1.x509.X509Extensions;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BasicOCSPRespGenerator {
    private RespID responderID;
    private List list = new ArrayList();
    private X509Extensions responseExtensions = null;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ResponseObject {
        public CertificateID certId;
        public CertStatus certStatus;
        public X509Extensions extensions;
        public DERGeneralizedTime nextUpdate;
        public DERGeneralizedTime thisUpdate;

        public ResponseObject(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, X509Extensions x509Extensions) {
            this.certId = certificateID;
            if (certificateStatus == null) {
                this.certStatus = new CertStatus();
            } else if (certificateStatus instanceof UnknownStatus) {
                this.certStatus = new CertStatus(2, new DERNull());
            } else {
                RevokedStatus revokedStatus = (RevokedStatus) certificateStatus;
                if (revokedStatus.hasRevocationReason()) {
                    this.certStatus = new CertStatus(new RevokedInfo(new DERGeneralizedTime(revokedStatus.getRevocationTime()), CRLReason.lookup(revokedStatus.getRevocationReason())));
                } else {
                    this.certStatus = new CertStatus(new RevokedInfo(new DERGeneralizedTime(revokedStatus.getRevocationTime()), null));
                }
            }
            this.thisUpdate = new DERGeneralizedTime(date);
            if (date2 != null) {
                this.nextUpdate = new DERGeneralizedTime(date2);
            } else {
                this.nextUpdate = null;
            }
            this.extensions = x509Extensions;
        }

        public SingleResponse toResponse() {
            return new SingleResponse(this.certId.toASN1Object(), this.certStatus, this.thisUpdate, this.nextUpdate, this.extensions);
        }
    }

    public BasicOCSPRespGenerator(RespID respID) {
        this.responderID = respID;
    }

    private BasicOCSPResp generateResponse(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr, Date date, String str2, SecureRandom secureRandom) {
        try {
            DERObjectIdentifier algorithmOID = OCSPUtil.getAlgorithmOID(str);
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (ResponseObject responseObject : this.list) {
                try {
                    aSN1EncodableVector.add(responseObject.toResponse());
                } catch (Exception e) {
                    throw new OCSPException("exception creating Request", e);
                }
            }
            ResponseData responseData = new ResponseData(this.responderID.toASN1Object(), new DERGeneralizedTime(date), new DERSequence(aSN1EncodableVector), this.responseExtensions);
            try {
                Signature createSignatureInstance = OCSPUtil.createSignatureInstance(str, str2);
                if (secureRandom != null) {
                    createSignatureInstance.initSign(privateKey, secureRandom);
                } else {
                    createSignatureInstance.initSign(privateKey);
                }
                try {
                    createSignatureInstance.update(responseData.getEncoded(ASN1Encoding.DER));
                    DERBitString dERBitString = new DERBitString(createSignatureInstance.sign());
                    AlgorithmIdentifier sigAlgID = OCSPUtil.getSigAlgID(algorithmOID);
                    DERSequence dERSequence = null;
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                        for (int i = 0; i != x509CertificateArr.length; i++) {
                            try {
                                aSN1EncodableVector2.add(new X509CertificateStructure((ASN1Sequence) ASN1Primitive.fromByteArray(x509CertificateArr[i].getEncoded())));
                            } catch (IOException e2) {
                                throw new OCSPException("error processing certs", e2);
                            } catch (CertificateEncodingException e3) {
                                throw new OCSPException("error encoding certs", e3);
                            }
                        }
                        dERSequence = new DERSequence(aSN1EncodableVector2);
                    }
                    return new BasicOCSPResp(new BasicOCSPResponse(responseData, sigAlgID, dERBitString, dERSequence));
                } catch (Exception e4) {
                    throw new OCSPException("exception processing TBSRequest: " + e4, e4);
                }
            } catch (NoSuchProviderException e5) {
                throw e5;
            } catch (GeneralSecurityException e6) {
                throw new OCSPException("exception creating signature: " + e6, e6);
            }
        } catch (Exception unused) {
            throw new IllegalArgumentException("unknown signing algorithm specified");
        }
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), null, null));
    }

    public BasicOCSPResp generate(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr, Date date, String str2) {
        return generate(str, privateKey, x509CertificateArr, date, str2, null);
    }

    public Iterator getSignatureAlgNames() {
        return OCSPUtil.getAlgNames();
    }

    public void setResponseExtensions(X509Extensions x509Extensions) {
        this.responseExtensions = x509Extensions;
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), null, x509Extensions));
    }

    public BasicOCSPResp generate(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr, Date date, String str2, SecureRandom secureRandom) {
        if (str != null) {
            return generateResponse(str, privateKey, x509CertificateArr, date, str2, secureRandom);
        }
        throw new IllegalArgumentException("no signing algorithm specified");
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, new Date(), date, x509Extensions));
    }

    public void addResponse(CertificateID certificateID, CertificateStatus certificateStatus, Date date, Date date2, X509Extensions x509Extensions) {
        this.list.add(new ResponseObject(certificateID, certificateStatus, date, date2, x509Extensions));
    }

    public BasicOCSPRespGenerator(PublicKey publicKey) {
        this.responderID = new RespID(publicKey);
    }
}
