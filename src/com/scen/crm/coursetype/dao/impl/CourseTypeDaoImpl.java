package com.scen.crm.coursetype.dao.impl;

import com.scen.crm.coursetype.dao.CourseTypeDao;
import com.scen.crm.coursetype.domain.CrmCourseType;
import com.scen.crm.page.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 课程类别持久层接口
 *
 * @author Scen
 * @date 2018/2/16
 */
public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

    @Override
    public CrmCourseType findById(String courseTypeId) {
        return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
    }

    @Override
    public void saveOrUpdate(CrmCourseType crmCourseType) {
        this.getHibernateTemplate().saveOrUpdate(crmCourseType);
    }

    @Override
    public int getTotalRecord(String condition, Object[] params) {
        String hql = "select count(c) from CrmCourseType c where 1=1" + condition;
        List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, params);
        return list.get(0).intValue();
    }

    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from CrmCourseType where 1=1" + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>(hql, params, startIndex, pageSize));
    }
}
