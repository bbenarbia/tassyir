package net.bbenarbia.dao;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.enums.EnumTypeVille;

public interface ITownDao extends IGenericDao<Town> {
	
	List<Town> getTownByReference(String reference);
	
	List<Town> getTownByType(EnumTypeVille type);
	
	List<Town> getCommunesByState(String state) ;
}
