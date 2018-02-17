package com.scen.crm.coursetype.dao.impl;

import com.scen.crm.coursetype.dao.CourseTypeDao;
import com.scen.crm.coursetype.domain.CrmCourseType;
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
    public List<CrmCourseType> findAll(String condition, Object[] params) {
        String hql = "from CrmCourseType where 1=1" + condition;
        return (List<CrmCourseType>) this.getHibernateTemplate().find(hql, params);
    }

    @Override
    public CrmCourseType findById(String courseTypeId) {
        return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
    }

    @Override
    public void saveOrUpdate(CrmCourseType crmCourseType) {
        this.getHibernateTemplate().saveOrUpdate(crmCourseType);
    }
}
