package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.Role;
import net.bbenarbia.service.generic.IGenericService;

public interface IRoleService extends IGenericService<Role>{

	List<Role> getRolesByName(String roleName);
}
