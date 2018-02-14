package com.scen.crm.staff.service;

import com.scen.crm.staff.domain.CrmStaff;

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
}
