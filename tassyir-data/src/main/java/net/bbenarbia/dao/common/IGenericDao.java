package net.bbenarbia.dao.common;

import java.util.Collection;
import java.util.List;

import net.bbenarbia.domain.base.BaseEntity;


/**
 * IEntityDao
 * @author waleed
 * @param <T>
 */
public interface IGenericDao<T extends BaseEntity> extends IBaseDao {

    T load(Long id);

    T get(Long id);

    List<T> getAll();

    void delete(T entity);

    Long delete(Long id);

    Long executeHQLUpdate(String hql);

    Long save(T entity);

    void save(T... entities);

    void saveOrUpdate(T entity);

    void merge(T entity);

    void evict(T... entities);

    void saveOrUpdateAll(Collection<T> entities);
    
    List<T> getEntityByName(String name) ;
}
