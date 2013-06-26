package net.bbenarbia.dao;

import java.util.Set;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumTypeUniteMesure;

public interface IUniteMesureDao extends IGenericDao<UniteMesure> {
		
		Set<UniteMesure> getUniteByType(EnumTypeUniteMesure type);
		
}
