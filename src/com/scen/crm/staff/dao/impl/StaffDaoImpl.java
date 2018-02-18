package com.scen.crm.staff.dao.impl;

import com.scen.crm.staff.dao.StaffDao;
import com.scen.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 员工持久层实现类
 *
 * @author Scen
 * @date 2018/2/14
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    @Override
    public CrmStaff find(String loginName, String loginPwd) {
        List<CrmStaff> crmStaffList = (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd=?", loginName, loginPwd);
        if (crmStaffList.size() == 1) {
            return crmStaffList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<CrmStaff> findAll() {
        return (List<CrmStaff>) this.getHibernateTemplate().find("from CrmStaff");
    }

    @Override
    public CrmStaff findById(String staffId) {
        return this.getHibernateTemplate().get(CrmStaff.class, staffId);
    }

}
