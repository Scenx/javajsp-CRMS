package com.scen.crm.department.dao;

import com.scen.crm.department.domain.CrmDepartment;

import java.util.List;

/**
 * 部门持久层接口
 *
 * @author Scen
 * @date 2018/2/15
 */
public interface DepartmentDao {

    /**
     * 查询所有的部门
     *
     * @return 所有部门
     */
    List<CrmDepartment> findAll();
}
