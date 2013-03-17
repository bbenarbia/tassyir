package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.service.generic.IGenericService;

public interface IUserCategoryService  extends IGenericService<UserCategory>{

	List<UserCategory> getUserCategroryByName(String name);
}
