package net.bbenarbia.web.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.User;
import net.bbenarbia.service.IUtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("tassyirAuthenticationProvider")
public class TassyirAuthenticationProvider implements AuthenticationProvider {
	 
	
		@Autowired
		private IUtilisateurService userService;
	
	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        String login = authentication.getName();
	        String password = authentication.getCredentials().toString();
	        
	        
	        User user = userService.getUtilisateurByLogin(login);
	        if(user!= null){
	        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			if(user != null){
				List<Role> userRoles = new ArrayList<Role>();
				userRoles.addAll(user.getGroupsAuthorities());
				userRoles.addAll(user.getRoles());
				authList =(List<GrantedAuthority>) getAuthorities(userRoles);
			}
			
			if(password.equals(user.getPassword())){
				if(!user.getLocked()){
					  Authentication auth = new UsernamePasswordAuthenticationToken(login, password, authList);
			            return auth;
				}else throw new UsernameNotFoundException("Your account is locked");
			}else throw new BadCredentialsException("Error password");
			
	        }
	        else throw new UsernameNotFoundException("User not found");
	    }
	    
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
	 
	    @Override
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }
	}
