package net.bbenarbia.dao.common;

import org.hibernate.dialect.Dialect;


/**
 * IBaseDao
 * @author waleed
 * @date 19 mars 2010
 * @version 1.0
 */
public interface IBaseDao {

    void flush();

    void clear();

    Dialect getDialect();

}