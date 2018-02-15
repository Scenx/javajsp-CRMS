package com.scen.crm.department.dao.impl;

import com.scen.crm.department.dao.DepartmentDao;
import com.scen.crm.department.domain.CrmDepartment;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 部门持久层实现类
 * @author Scen
 * @date 2018/2/15
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    @Override
    public List<CrmDepartment> findAll() {

        return (List<CrmDepartment>) this.getHibernateTemplate().find("from CrmDepartment ");
    }
}
