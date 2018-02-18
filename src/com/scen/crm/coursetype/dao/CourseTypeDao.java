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

    /**
     * 分页查询总记录数
     *
     * @param condition
     * @param params
     * @return 分页查询总记录数
     */
    int getTotalRecord(String condition, Object[] params);

    /**
     * 分页，查询结果
     *
     * @param condition  条件
     * @param params     条件的实际参数
     * @param startIndex 开始索引
     * @param pageSize   每页显示个数
     * @return
     */
    List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize);
}
