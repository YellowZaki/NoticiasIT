package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alberto
 */
public class Utils {

    public static String getHashedPassword(String passwordInput) {
        MessageDigest md = null;

        // Static getInstance method is called with hashing MD5 
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // digest() method is called to calculate message digest 
        //  of an input digest() return array of byte 
        byte[] messageDigest = md.digest(passwordInput.getBytes());

        // Convert byte array into signum representation 
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value 
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static boolean isHashedPasswordCorrect(String passwordInput, String passwordFromDB) {
        String hashedPassword = getHashedPassword(passwordInput);
        return hashedPassword.equals(passwordFromDB);
    }
    

}
