package net.bbenarbia.service.impl;

import net.bbenarbia.dao.IPhotoDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.immobilier.Photo;
import net.bbenarbia.service.IPhotoService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("photoService")
@Transactional
public class PhotoService extends GenericService<Photo> implements
		IPhotoService {

	@Autowired
	private IPhotoDao photoDao;

	@Override
	@Autowired
	@Qualifier("photoDao")
	public void setGenericDao(IGenericDao<Photo> genericDao) {
		this.genericDao = genericDao;
	}
}