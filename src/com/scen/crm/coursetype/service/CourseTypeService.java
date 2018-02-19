package com.scen.crm.coursetype.service;

import com.scen.crm.coursetype.domain.CrmCourseType;
import com.scen.crm.page.PageBean;


/**
 * 课程类别业务层接口
 *
 * @author Scen
 * @date 2018/2/16
 */
public interface CourseTypeService {
    /**
     * 通过id查询课程类别详情
     *
     * @param courseTypeId 课程类别id
     * @return 课程类别对象
     */
    CrmCourseType findById(String courseTypeId);


    /**
     * 保存或者更新课程类别
     *
     * @param crmCourseType 课程类别对象
     */
    void addOrEdit(CrmCourseType crmCourseType);

    /**
     * 分页+条件查询
     *
     * @param crmCourseType
     * @param pageNum
     * @param pageSize
     * @return 当前页数据
     */
    PageBean<CrmCourseType> findAll(CrmCourseType crmCourseType, int pageNum, int pageSize);
}
