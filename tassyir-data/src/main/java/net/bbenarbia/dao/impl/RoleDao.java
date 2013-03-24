package net.bbenarbia.dao.impl;

import net.bbenarbia.dao.IRoleDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Role;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends GenericDao<Role> implements IRoleDao {

}
