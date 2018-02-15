package com.scen.crm.department.service.impl;

import com.scen.crm.department.dao.DepartmentDao;
import com.scen.crm.department.domain.CrmDepartment;
import com.scen.crm.department.service.DepartmentService;

import java.util.List;

/**
 * 部门业务层实现类
 * @author Scen
 * @date 2018/2/15
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<CrmDepartment> findAll() {
        return departmentDao.findAll();
    }
}
