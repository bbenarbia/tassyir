package net.bbenarbia.utils;

import java.util.UUID;

public class Utils {

	public static String getRandomString(){
		
		String uuid = UUID.randomUUID().toString();
		return  uuid;
	}
}
