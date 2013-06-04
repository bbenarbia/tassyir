package net.bbenarbia.dao;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Town;

public interface ITownDao extends IGenericDao<Town> {
	
	List<Town> getTownByReference(String reference);
}
