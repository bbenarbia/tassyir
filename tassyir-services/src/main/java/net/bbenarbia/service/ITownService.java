package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.enums.EnumTypeVille;
import net.bbenarbia.service.generic.IGenericService;

public interface ITownService extends IGenericService<Town>{
	
	List<Town> getTownByReference(String reference);
	
	List<Town> getTownByType(EnumTypeVille type);
	
	List<Town> getCommunesByState(String state) ;
}
