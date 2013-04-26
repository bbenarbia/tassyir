package net.bbenarbia.web.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.User;
import net.bbenarbia.service.IUtilisateurService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * A custom service for retrieving users from a custom datasource, such as a
 * database.
 * <p>
 * This custom service must implement Spring's {@link UserDetailsService}
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	private IUtilisateurService userService;

	/**
	 * Retrieves a user record containing the user's credentials and access.
	 */
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException, DataAccessException {

		// Declare a null Spring User
		UserDetails userDetails = null;

		try {

			User dbuser = userService.getUtilisateurByLogin(login);

			userDetails = new org.springframework.security.core.userdetails.User(
					dbuser.getLogin(), dbuser.getPassword(),
					!dbuser.getLocked(), !dbuser.getLocked(),
					!dbuser.getLocked(), !dbuser.getLocked(),
					getAuthorities(dbuser.getRoles()));

		} catch (Exception e) {
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}

		return userDetails;
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(
			Collection<Role> rolesList) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

		for (Role role : rolesList) {
			authList.add(new GrantedAuthorityImpl(role.getName()));
		}

		// Return list of granted authorities
		return authList;
	}
}