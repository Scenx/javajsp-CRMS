package com.scen.crm.post.service;

import com.scen.crm.department.domain.CrmDepartment;
import com.scen.crm.post.domain.CrmPost;

import java.util.List;

/**
 * 职务业务层接口
 *
 * @author Scen
 * @date 2018/2/15
 */
public interface PostService {
    /**
     * 查询指定部门的所有职务
     *
     * @param crmDepartment 指定部门
     * @return 指定部门的所有职务
     */
    List<CrmPost> findAll(CrmDepartment crmDepartment);
}
