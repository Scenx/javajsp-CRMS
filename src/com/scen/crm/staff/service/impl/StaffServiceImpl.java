package com.scen.crm.staff.service.impl;

import com.scen.crm.staff.dao.StaffDao;
import com.scen.crm.staff.domain.CrmStaff;
import com.scen.crm.staff.service.StaffService;

/**
 * 员工业务层实现类
 * @author Scen
 * @date 2018/2/14
 */
public class StaffServiceImpl implements StaffService {
    /**
     * 生成set方法
     * spring自动注入
     */
    private StaffDao staffDao;

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public CrmStaff login(CrmStaff crmStaff) {
        return staffDao.find(crmStaff.getLoginName(),crmStaff.getLoginPwd());
    }
}
