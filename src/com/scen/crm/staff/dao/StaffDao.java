package com.scen.crm.staff.dao;

import com.scen.crm.staff.domain.CrmStaff;

import java.util.List;

/**
 * 员工持久层接口
 * @author Scen
 * @date 2018/2/14
 */
public interface StaffDao {
    /**
     * 通过用户名和密码查询
     * @param loginName 登录名
     * @param loginPwd 登录密码
     * @return 结果返回唯一的一个员工对象
     */
    CrmStaff find(String loginName,String loginPwd);


    /**
     * 查询所有员工
     * @return 所有员工
     */
    List<CrmStaff> findAll();

    /**
     * 通过id查询员工
     * @param staffId 员工id
     * @return 员工对象
     */
    CrmStaff findById(String staffId);
}
