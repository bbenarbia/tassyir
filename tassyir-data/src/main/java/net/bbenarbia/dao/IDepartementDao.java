package net.bbenarbia.dao;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Departement;

public interface IDepartementDao extends IGenericDao<Departement> {
	
	List<Departement> getDepartementByReference(String reference);
}
