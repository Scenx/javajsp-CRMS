package com.scen.crm.coursetype.dao;

import com.scen.crm.coursetype.domain.CrmCourseType;

import java.util.List;

/**
 * 课程类别持久层接口
 *
 * @author Scen
 * @date 2018/2/16
 */
public interface CourseTypeDao {
    /**
     * 查询所有课程类别
     *
     * @param condition
     * @param params
     * @return 所有课程类别对象
     */
    List<CrmCourseType> findAll(String condition, Object[] params);

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
    void saveOrUpdate(CrmCourseType crmCourseType);
}
