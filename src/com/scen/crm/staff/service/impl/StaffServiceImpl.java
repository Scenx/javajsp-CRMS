package com.scen.crm.staff.service.impl;

import com.scen.crm.staff.dao.StaffDao;
import com.scen.crm.staff.domain.CrmStaff;
import com.scen.crm.staff.service.StaffService;
import com.scen.crm.utils.MyStringUtils;

import java.util.List;

/**
 * 员工业务层实现类
 *
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
        //md5加密
        String loginPwd = MyStringUtils.getMD5Value(crmStaff.getLoginPwd());
        return staffDao.find(crmStaff.getLoginName(), loginPwd);
    }

    @Override
    public List<CrmStaff> findAllStaff() {
        return staffDao.findAll();
    }

    @Override
    public CrmStaff findById(String staffId) {
        return staffDao.findById(staffId);
    }

    @Override
    public void updateStaff(CrmStaff crmStaff) {
        CrmStaff findStaff = staffDao.findById(crmStaff.getStaffId());
        if (!findStaff.getLoginPwd().equals(crmStaff.getLoginPwd())) {
            findStaff.setLoginPwd(MyStringUtils.getMD5Value(crmStaff.getLoginPwd()));
        }
        findStaff.setLoginName(crmStaff.getLoginName());
        findStaff.setGender(crmStaff.getGender());
        findStaff.setCrmPost(crmStaff.getCrmPost());
        findStaff.setOnDutyDate(crmStaff.getOnDutyDate());
        findStaff.setStaffName(crmStaff.getStaffName());
    }

}
