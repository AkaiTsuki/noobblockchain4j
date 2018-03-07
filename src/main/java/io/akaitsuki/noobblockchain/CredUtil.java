package io.akaitsuki.noobblockchain;


import java.security.*;
import java.util.Base64;

/**
 * Created by jiachiliu on 3/6/18.
 * <p>
 * Utility to generate hash signature
 */
public class CredUtil {
    public static String applySha256(String src) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(src.getBytes());
            StringBuilder hexStr = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexStr.append(0);
                hexStr.append(hex);
            }

            return hexStr.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getKeyString(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static byte[] applyECDSASig(PrivateKey key, String data) {
        try {
            Signature dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(key);
            dsa.update(data.getBytes());
            return dsa.sign();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyECDSASig(PublicKey key, String data, byte[] signature) {
        try {
            Signature dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initVerify(key);
            dsa.update(data.getBytes());
            return dsa.verify(signature);
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
