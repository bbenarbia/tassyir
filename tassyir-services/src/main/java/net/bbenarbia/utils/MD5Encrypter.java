package net.bbenarbia.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypter {

	public static String encryptToMD5(String password) {
		String md5val = "";
		MessageDigest algorithm = null;

		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("Cannot find digest algorithm");
			System.exit(1);
		}

		byte[] defaultBytes = password.getBytes();
		algorithm.reset();
		algorithm.update(defaultBytes);
		byte messageDigest[] = algorithm.digest();
		StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < messageDigest.length; i++) {
			String hex = Integer.toHexString(0xFF & messageDigest[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		md5val = hexString.toString();

		return md5val;
	}

	public static String encryptToMD5(byte[] data) {
		String md5val = "";
		MessageDigest algorithm = null;

		try {
			algorithm = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("Cannot find digest algorithm");
			System.exit(1);
		}

		algorithm.reset();
		algorithm.update(data);
		byte messageDigest[] = algorithm.digest();
		StringBuffer hexString = new StringBuffer();

		for (int i = 0; i < messageDigest.length; i++) {
			String hex = Integer.toHexString(0xFF & messageDigest[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		md5val = hexString.toString();

		return md5val;
	}

	public static String getMd5File(File file) throws IOException {
		byte[] byteFile = new byte[(int) file.length()];
		InputStream stream = new FileInputStream(file);
		stream.read(byteFile);
		stream.close();
		return MD5Encrypter.encryptToMD5(byteFile);
	}

	public static boolean compare(String clearPassword,
			String encryptedActualPassword) {
		String encryptedTestPassword = encryptToMD5(clearPassword);
		return (encryptedTestPassword.equals(encryptedActualPassword));
	}
}