package com.scen.crm.base.impl;

import com.scen.crm.base.BaseDao;
import com.scen.crm.page.PageHibernateCallback;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基础持久层通用实现类
 * @author Scen
 * @date 2018/2/18
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class<?> beanClass;

    public BaseDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        beanClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);

    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);

    }

    @Override
    public void saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);

    }

    @Override
    public T findById(Serializable id) {
        return (T) getHibernateTemplate().get(beanClass, id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getHibernateTemplate().find("from " + beanClass.getName());
    }



    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from "+beanClass.getName()+" c where 1=1" + condition;
        List<Long> list = (List<Long>) getHibernateTemplate().find(hql, params);
        return list.get(0).intValue();
    }

    @Override
    public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from "+beanClass.getName()+" where 1=1 " + condition;
        return getHibernateTemplate().execute(new PageHibernateCallback<T>(hql, params, startIndex, pageSize));
    }

    @Override
    public List<T> findAll(DetachedCriteria criteria) {
        return (List<T>) getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
        return (List<T>) getHibernateTemplate().findByCriteria(criteria,startIndex,pageSize);
    }
}
