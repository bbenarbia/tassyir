package net.bbenarbia.utils;

import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;

public class Utils {

	public static String getRandomString(){
		String uuid = UUID.randomUUID().toString();
		return  uuid;
	}
	
	
	public static String getRandomString(int size){
		String s = RandomStringUtils.randomAlphanumeric(size);
		 
		return  s;
	}
}
