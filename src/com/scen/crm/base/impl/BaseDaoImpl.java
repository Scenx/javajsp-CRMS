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
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        beanClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);

    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);

    }

    @Override
    public void saveOrUpdate(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);

    }

    @Override
    public T findById(Serializable id) {
        return (T) this.getHibernateTemplate().get(beanClass, id);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from " + beanClass.getName());
    }



    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from "+beanClass.getName()+" c where 1=1" + condition;
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, params);
        return list.get(0).intValue();
    }

    @Override
    public List<T> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from "+beanClass.getName()+" where 1=1 " + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql, params, startIndex, pageSize));
    }

    @Override
    public List<T> findAll(DetachedCriteria criteria) {
        return (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public List<T> findAll(DetachedCriteria criteria, int startIndex, int pageSize) {
        return (List<T>) this.getHibernateTemplate().findByCriteria(criteria,startIndex,pageSize);
    }
}
