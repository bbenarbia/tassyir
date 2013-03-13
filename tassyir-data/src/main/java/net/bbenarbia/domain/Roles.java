package net.bbenarbia.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Roles {

	private List<Role> roles;

	@XmlElement
	public List<Role> getVetList() {
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		return roles;
	}

}
