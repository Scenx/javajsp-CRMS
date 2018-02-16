package com.scen.crm.coursetype.dao;

import com.scen.crm.coursetype.domain.CrmCourseType;

import java.util.List;

/**
 * 课程类别持久层接口
 * @author Scen
 * @date 2018/2/16
 */
public interface CourseTypeDao {
    /**
     * 查询所有课程类别
     * @return 所有课程类别对象
     * @param condition
     * @param params
     */
    List<CrmCourseType> findAll(String condition, Object[] params);
}
