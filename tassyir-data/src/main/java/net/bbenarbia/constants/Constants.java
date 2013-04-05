package net.bbenarbia.constants;


public class Constants {

	public final static String APPARTEMENT = "APPARTEMENT";
	public final static String STUDIO = "STUDIO";
	public final static String TERRAIN = "TERRAIN";
	public final static String COMMERCE = "COMMERCE";
	public final static String MAISON = "MAISON";
	public final static String ENTREPOT = "ENTREPOT";
	/**
	 * La longueur maximal des users name
	 */
	public static final int USERNAME_MAX_SIZE1 = 30;
	/**
	 * La longueur minimal des users name
	 */
	public static final int USERNAME_MIN_SIZE1 = 4;
	/**
	 * La longueur maximal des mots de passe
	 */
	public static final int PASSWORD_MAX_SIZE1 = 30;
	/**
	 * La longueur minimal des mots de passe
	 */
	public static final int PASSWORD_MIN_SIZE1 = 4;
	
	public static final String mailAdmin1="benaissa.benarbia@nemailxtep.net";
	
	public static final String defaultPassword1="benaissa";
	
	public static final boolean mailServiceEnable1 =true;
	
	
	public static String getTemplateText(String userName, String password){
		return("Bonjour "
				+ userName
				+ ",  vous venez de changer votre mot de passe dans la nouvelle application amundsen"
				+ ", le nouveau mot de passe est:"
				+ password);
		
	}
}
