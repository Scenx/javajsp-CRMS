package com.scen.crm.staff.dao;

import com.scen.crm.staff.domain.CrmStaff;

/**
 * 员工持久层接口
 * @author Scen
 * @date 2018/2/14
 */
public interface StaffDao {
    /**
     * 通过用户名和密码查询
     * @param loginName
     * @param loginPwd
     * @return 结果返回唯一的一个员工对象
     */
    CrmStaff find(String loginName,String loginPwd);
}
