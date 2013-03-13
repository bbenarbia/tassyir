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

    T load(long id);

    T get(long id);

    List<T> getAll();

    void delete(T entity);

    long delete(Long id);

    long executeHQLUpdate(String hql);

    long save(T entity);

    void save(T... entities);

    void saveOrUpdate(T entity);

    void merge(T entity);

    void evict(T... entities);

    void saveOrUpdateAll(Collection<T> entities);
}
