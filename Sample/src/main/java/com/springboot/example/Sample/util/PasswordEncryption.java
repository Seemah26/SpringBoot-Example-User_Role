package com.springboot.example.Sample.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {
	public static String PasswordEncoder(String password) {
		String generatedPassword = null;
		try {

			MessageDigest message = MessageDigest.getInstance("MD5");

			message.update(password.getBytes());

			byte[] bytes = message.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedPassword;
	}

}