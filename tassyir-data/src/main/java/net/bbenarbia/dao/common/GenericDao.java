package net.bbenarbia.dao.common;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import net.bbenarbia.domain.base.BaseEntity;

import org.hibernate.Query;


public class GenericDao<T extends BaseEntity> extends BaseDao implements IGenericDao<T> {

    /* 
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IGenericDao#load(Long)
     */
    @SuppressWarnings("unchecked")
    public T load(Long id) {
        return (T) getSession().load(getEntityClass(), id);
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IGenericDao#get(Long)
     */
    @SuppressWarnings("unchecked")
    public T get(Long id) {
        return (T) getSession().get(getEntityClass(), id);
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IGenericDao#getAll()
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Query query = getSession().createQuery("FROM " + getEntityClass().getName());
        return query.list();
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IGenericDao#save(T)
     */
    public Long save(T entity) {
        return (Long) getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void merge(T entity) {
        getSession().merge(entity);
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IGenericDao#delete(T)
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }

    public Long delete(Long id) {
        String queryString = " DELETE FROM " + getEntityClass().getName() + " WHERE id = :id ";

        Query query = getSession().createQuery(queryString);
        query.setParameter("id", id);

        return Long.valueOf(query.executeUpdate());
    }

    @Override
    public Long executeHQLUpdate(String hql) {
        return Long.valueOf(getSession().createQuery(hql).executeUpdate());
    }

    @Override
    public void save(T... entities) {
        for (T entity : entities) {
            save(entity);
        }
    }

    @Override
    public void evict(T... entities) {
        for (T entity : entities) {
            getSession().evict(entity);
        }
    }

    @Override
    public void saveOrUpdateAll(Collection<T> entities) {
        getHibernateTemplate().saveOrUpdateAll(entities);
    }
}
