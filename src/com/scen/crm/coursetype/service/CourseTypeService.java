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
}
