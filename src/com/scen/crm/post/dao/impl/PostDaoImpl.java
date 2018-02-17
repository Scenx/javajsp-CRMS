package com.scen.crm.post.dao.impl;

import com.scen.crm.department.domain.CrmDepartment;
import com.scen.crm.post.dao.PostDao;
import com.scen.crm.post.domain.CrmPost;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * 职务持久层实现类
 *
 * @author Scen
 * @date 2018/2/15
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<CrmPost> findAll(CrmDepartment crmDepartment) {
        return (List<CrmPost>) this.getHibernateTemplate().find("from CrmPost where crmDepartment=?", crmDepartment);
    }
}
