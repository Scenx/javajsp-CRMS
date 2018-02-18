package com.scen.crm.page;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import java.util.List;

/**
 * @author Scen
 * @date 2018/2/17
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
    private String hql;
    private Object[] params;
    private int startIndex;
    private int pageSize;

    public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize) {
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query queryObject = session.createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            queryObject.setParameter(i, params[i]);
        }

        queryObject.setFirstResult(startIndex);
        queryObject.setMaxResults(pageSize);

        return queryObject.list();
    }
}
