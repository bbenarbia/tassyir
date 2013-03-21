package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.Parameter;
import net.bbenarbia.service.generic.IGenericService;

public interface IParameterService  extends IGenericService<Parameter>{

	List<Parameter> getParameterName(String name);
}
