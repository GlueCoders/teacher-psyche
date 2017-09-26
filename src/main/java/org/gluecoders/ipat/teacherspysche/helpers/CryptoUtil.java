package org.gluecoders.ipat.teacherspysche.helpers;

import com.google.appengine.repackaged.org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.logging.Logger;

/**
 * Created by Anand Rajneesh on 9/27/2017.
 */
public class CryptoUtil {

    private static final Logger log = Logger.getLogger(CryptoUtil.class.getName());
    private static final String key = "SArUNoKAoEDdSlAn";

    public static String encrypt(String text) {
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            log.severe("encrypt exception "+e.getMessage());
        }
        return null;
    }

    public static String decrypt(String encryptedText) {
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return new String(cipher.doFinal(Base64.decodeBase64(encryptedText)));
        } catch (Exception e) {
            log.severe("decrypt exception "+e.getMessage());
        }
        return null;
    }

}
