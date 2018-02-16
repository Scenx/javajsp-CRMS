package com.scen.crm.staff.service;

import com.scen.crm.staff.domain.CrmStaff;

import java.util.List;

/**
 * 员工业务层接口
 * @author Scen
 * @date 2018/2/14
 */
public interface StaffService {

    /**
     * 员工登录
     * @param crmStaff 员工对象
     * @return 返回一个唯一的员工对象
     */
    CrmStaff login(CrmStaff crmStaff);

    /**
     * 查询所有员工
     * @return 所有员工
     */
    List<CrmStaff> findAllStaff();

    /**
     * 通过id查询员工
     * @param staffId 员工id
     * @return 员工对象
     */
    CrmStaff findById(String staffId);

    /**
     * 更新员工信息
     * @param crmStaff 员工对象
     */
    void updateStaff(CrmStaff crmStaff);
}
