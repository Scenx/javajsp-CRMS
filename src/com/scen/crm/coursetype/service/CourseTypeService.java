package com.scen.crm.coursetype.service;

import com.scen.crm.coursetype.domain.CrmCourseType;

import java.util.List;

/**
 * 课程类别业务层接口
 * @author Scen
 * @date 2018/2/16
 */
public interface CourseTypeService {
    /**
     * 查询所有课程类别
     * @return 所有课程类别对象
     * @param crmCourseType
     */
    List<CrmCourseType> findAll(CrmCourseType crmCourseType);



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
}
