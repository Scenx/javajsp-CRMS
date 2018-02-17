package com.scen.crm.department.service;

import com.scen.crm.department.domain.CrmDepartment;

import java.util.List;

/**
 * 部门业务层接口
 *
 * @author Scen
 * @date 2018/2/15
 */
public interface DepartmentService {
    /**
     * 查询所有部门
     *
     * @return 所有部门
     */
    List<CrmDepartment> findAll();
}
