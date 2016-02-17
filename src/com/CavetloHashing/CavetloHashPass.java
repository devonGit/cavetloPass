package com.CavetloHashing;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CavetloHashPass {
	
	
	//private  final static Logger logger=LoggerFactory.getLogger(CavetloHashPass.class);

	
	public static String stringToHash(String strPass) throws HashGenerationException{
		String sha1Hash =generateSHA1(strPass);
	//	logger.info("This is loger infor.....");
		return sha1Hash;
	}
	
	private static String generateSHA1(String message) throws HashGenerationException {
//		logger.info("it  is in generateSHA1() .....");
        return hashString(message, "SHA-2");
    }
	
	 private static String hashString(String message, String algorithm)throws HashGenerationException {
	 
	        try {
	            MessageDigest digest = MessageDigest.getInstance(algorithm);
	            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
//	            logger.info("it  is in hashString() .....");
	            return convertByteArrayToHexString(hashedBytes);
	        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
	            throw new HashGenerationException("Could not generate hash from String", ex);
	        }
	    }
	 private static String convertByteArrayToHexString(byte[] arrayBytes) {
	        StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < arrayBytes.length; i++) {
	            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return stringBuffer.toString();
	    }
	
}
