package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.Departement;
import net.bbenarbia.service.generic.IGenericService;

public interface IDepartementService extends IGenericService<Departement>{
	
	List<Departement> getDepartementByReference(String reference);
}
