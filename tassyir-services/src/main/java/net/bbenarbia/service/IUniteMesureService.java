package net.bbenarbia.service;

import java.util.Set;

import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumTypeUniteMesure;
import net.bbenarbia.service.generic.IGenericService;

public interface IUniteMesureService extends IGenericService<UniteMesure> {

	Set<UniteMesure> getUniteByType(EnumTypeUniteMesure type);

}
