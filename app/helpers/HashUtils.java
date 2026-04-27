package helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class HashUtils {

    public static String getMd5(String s){
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] digest = m.digest(s.getBytes(StandardCharsets.UTF_8));

            BigInteger bigInt = new BigInteger(1, digest);
            String hashtext = bigInt.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
