package net.bbenarbia.dao.impl;

import net.bbenarbia.dao.IPhotoDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.immobilier.Photo;

import org.springframework.stereotype.Repository;

@Repository
public class PhotoDao extends GenericDao<Photo> implements IPhotoDao {

}
