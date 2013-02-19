package net.bbenarbia.dao.common;


import java.util.Collections;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.hibernate.hql.ast.ASTQueryTranslatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// We don't want to rollback at this point, but we want to check there is a transaction
@Transactional(propagation = Propagation.MANDATORY, noRollbackFor = {Throwable.class})
public class BaseDao implements IBaseDao {

    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;

    @Required
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected HibernateTemplate getHibernateTemplate() {
    	return hibernateTemplate;
    }
    
    /**
     * Permet de convertir une requete HQL en requete SQL
     * @param requeteHQL la requete HQL
     * @return la requete SQL
     */
    public String convertHQLToSQL(final StringBuilder requeteHQL)
    {
    	return convertHQLToSQL(requeteHQL.toString());
    }
    
    /**
     * Permet de convertir une requete HQL en requete SQL
     * @param requeteHQL la requete HQL
     * @return la requete SQL
     */
    public String convertHQLToSQL(final String requeteHQL)
    {
        final QueryTranslatorFactory translatorFactory = new ASTQueryTranslatorFactory();
        final SessionFactoryImplementor factory = (SessionFactoryImplementor) sessionFactory;
        final QueryTranslator translator = translatorFactory.createQueryTranslator(requeteHQL, requeteHQL, Collections.EMPTY_MAP, factory);
        translator.compile(Collections.EMPTY_MAP, false);
        
        final String requeteSQL = translator.getSQLString();
        
        return requeteSQL;
    }
    

	/*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IBaseDao#flush()
     */
    public void flush() {
        getSession().flush();
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IBaseDao#clear()
     */
    public void clear() {
        getSession().clear();
    }
    
    public Dialect getDialect() {
        return ((SessionFactoryImplementor)this.sessionFactory).getDialect();
    }
}

