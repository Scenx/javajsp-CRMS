package com.scen.crm.staff.dao;

import com.scen.crm.base.BaseDao;
import com.scen.crm.staff.domain.CrmStaff;


/**
 * 员工持久层接口
 *
 * @author Scen
 * @date 2018/2/14
 */
public interface StaffDao extends BaseDao<CrmStaff>{
    /**
     * 通过用户名和密码查询
     *
     * @param loginName 登录名
     * @param loginPwd  登录密码
     * @return 结果返回唯一的一个员工对象
     */
    CrmStaff find(String loginName, String loginPwd);
}
