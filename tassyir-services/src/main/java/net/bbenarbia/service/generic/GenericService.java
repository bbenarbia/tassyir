package net.bbenarbia.service.generic;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.base.BaseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@SuppressWarnings("unchecked")
@Service
@Transactional
public abstract class GenericService<Entity extends BaseEntity> 
        implements IGenericService<Entity> {

    protected IGenericDao<Entity> genericDao;

    
    public Entity get(Long id) {
        return genericDao.get(id);
    }

    
    public List<Entity> getAll() {
        return genericDao.getAll();
    }

    
    public Long save(Entity item) {
        return genericDao.save(item);
    }

    public void saveOrUpdate(Entity item) {
        genericDao.saveOrUpdate(item);
        genericDao.flush();
    }

    public void delete(Entity item) {
        genericDao.delete(item);
    }

    public void delete(Long id) {
        genericDao.delete(id);
    }

    public void merge(Entity item) {
        genericDao.merge(item);
    }

    @Autowired
    public abstract void setGenericDao(IGenericDao<Entity> genericDao);

}

