package com.springboot_tiles.util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.bcrypt.BCrypt;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class ZPassword {
	private static final String CHAR_LEGAL =    "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz!@#$%^&()-+[]";
	private static final String CHAR_PASSWORD = "z!a@b#c$d%e^f&gh(i)j-k+l[m]onprqtsvuwyxA1B2C3D4E5F6G7H8I9J0KLMNOPQRSTUVWXYZ";
	
	private static final String ALGO = "AES";
    private static final byte[] keyValue =  new byte[] 
    		{ 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	
	public static String strGetEncrypt(String strpPwd){
		StringBuffer strResult = new StringBuffer();
		strResult.append("");
		for (int i =0;i<strpPwd.length();i++ ){
			for (int j=0;j<CHAR_LEGAL.length();j++){
				String a = strpPwd.trim().substring(i,i+1) ;
				String b = CHAR_LEGAL.trim().substring(j, j+1);
				if (a.equals(b)){
					strResult.append(CHAR_PASSWORD.substring(j, j+1));
				}
			}
		}
		return strResult.toString() ;
	}
	public static String strGetDecrypt(String strpPwd){
		StringBuffer strResult = new StringBuffer();
		strResult.append("");
		for (int i =0;i<strpPwd.length();i++ ){
			for (int j=0;j<CHAR_PASSWORD.length();j++){
				String a = strpPwd.trim().substring(i,i+1) ;
				String b = CHAR_PASSWORD.trim().substring(j, j+1);
				if ( a.equals(b) ){
					strResult.append(CHAR_LEGAL.trim().substring(j, j+1));
				}
			}
		}
		return strResult.toString() ;
	}
//	public static String encrypt(String Data){
//		String encryptedValue = "";
//		try {
//			Key key = generateKey();
//			Cipher c = Cipher.getInstance(ALGO);
//	        c.init(Cipher.ENCRYPT_MODE, key);
//	        byte[] encVal = c.doFinal(Data.getBytes());
//	        encryptedValue = new BASE64Encoder().encode(encVal);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        return encryptedValue;
//    }
//	public static String decrypt(String encryptedData) {
//		String decryptedValue = "";
//		try {
//			Key key = generateKey();
//			Cipher c = Cipher.getInstance(ALGO);
//	        c.init(Cipher.DECRYPT_MODE, key);
//	        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
//	        byte[] decValue = c.doFinal(decordedValue);
//	        decryptedValue = new String(decValue);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        
//        return decryptedValue;
//    }
	
	public static String ENCRYPT(String strpPWD){
		StringBuffer strResult = new StringBuffer();
		strResult.append("");
		String strPWD = strpPWD.trim();
		int i = 0;
		while (i<strPWD.length()){
			String a = strPWD.trim().substring(i,i+1) ;
			for (int j=0;j<CHAR_LEGAL.length();j++){				
				String b = CHAR_LEGAL.trim().substring(j, j+1);				
				if (a.equals(b)){
					strResult.append(CHAR_PASSWORD.substring(j, j+1));
				}
			}
			i = i + 1 ;
		}
		return strResult.toString() ;
	}
	public static String DECRYPT(String strpPWD){
		StringBuffer strResult = new StringBuffer();
		strResult.append("");
		String strPWD = strpPWD.trim();
		for (int i =0;i<strPWD.length();i++ ){
			for (int j=0;j<CHAR_PASSWORD.length();j++){
				String a = strpPWD.trim().substring(i,i+1) ;
				String b = CHAR_PASSWORD.trim().substring(j, j+1);
				if ( a.equals(b) ){
					strResult.append(CHAR_LEGAL.trim().substring(j, j+1));
				}
			}
		}
		return strResult.toString() ;
	}
	
	public static String vs_GetDecryptPassword(String strpPWD) {
		String strResult ="";
		String strEncJmlPWD = strpPWD.substring(4, 6);
		String strDecJmlPWD = ZPassword.DECRYPT(strEncJmlPWD);
		int intJmlPWD = Integer.valueOf(strDecJmlPWD);
		String strEncPWD = strpPWD.substring(6, 6+intJmlPWD);
		String strDecPWD = DECRYPT(strEncPWD);
		strResult = strDecPWD;
		return strResult;
	}
	public static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
	}
	
	public boolean BcryptHashingExample(String  originalPassword)	{
//        String  originalPassword = "password";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);
         
        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        System.out.println(matched);
		return matched;
	}
	public static String getSecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    //Add salt
    public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException{
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }
}
