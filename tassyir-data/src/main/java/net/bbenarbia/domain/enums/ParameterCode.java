package net.bbenarbia.domain.enums;

/**
 * Une énumération des parametres de l'application
 * 
 * @author benaissa
 * 
 */

public enum ParameterCode {

	/**
	 * La taille max du username
	 */
	USERNAME_MAX_SIZE("USERNAME_MAX_SIZE"),
	/**
	 * la taille min d'un username
	 */
	USERNAME_MIN_SIZE("USERNAME_MIN_SIZE"),
	/**
	 * la taille max d'un mot de passe
	 */
	PASSWORD_MAX_SIZE("PASSWORD_MAX_SIZE"),
	/**
	 * la taille min d'un mot de passe
	 */
	PASSWORD_MIN_SIZE("PASSWORD_MIN_SIZE"),

	/**
	 * le mail de l'administrateur ( a utiliser comme le sender)
	 */
	MAIL_ADMIN("MAIL_ADMIN"),
	/**
	 * le mot de passe par défaut
	 */
	DEFAULT_PASSWORD("DEFAULT_PASSWORD"),
	/**
	 * Parametre pour activer ou désactiver l'envoie des mails aux utilisateurs
	 */
	ETAT_SERVICE_MAIL("ETAT_SERVICE_MAIL"),
	/**
	 * Parametre pour specifier le chemin du repertoire temp pour transferer les fichiers à traiter
	 * il faut que le chemin se termine par / exemple (/home/user/tempfile/)
	 */
	TEMP_DIRECTORY("TEMP_DIRECTORY");

	/**
	 * le nom du parametres
	 */
	private final String debugName;

	private ParameterCode(String debugName) {
		this.debugName = debugName;
	}

	/**
	 * convertir le parametre en string
	 */
	public String toString() {
		return debugName;
	}
}
