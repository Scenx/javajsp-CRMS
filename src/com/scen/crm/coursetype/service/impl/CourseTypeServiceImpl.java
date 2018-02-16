package com.scen.crm.coursetype.service.impl;

import com.scen.crm.coursetype.dao.CourseTypeDao;
import com.scen.crm.coursetype.domain.CrmCourseType;
import com.scen.crm.coursetype.service.CourseTypeService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * 课程类别业务层实现类
 *
 * @author Scen
 * @date 2018/2/16
 */
public class CourseTypeServiceImpl implements CourseTypeService {

    private CourseTypeDao courseTypeDao;

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CrmCourseType> findAll(CrmCourseType crmCourseType) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Object> paramses = new ArrayList<Object>();

            if (StringUtils.isNotBlank(crmCourseType.getCourseName())) {
                stringBuilder.append(" and courseName like ?");
                paramses.add("%" + crmCourseType.getCourseName() + "%");
            }


            if (StringUtils.isNotBlank(crmCourseType.getRemark())) {
                stringBuilder.append(" and remark like ?");
                paramses.add("%" + crmCourseType.getRemark() + "%");
            }


            if (StringUtils.isNotBlank(crmCourseType.getTotalStart())) {
                stringBuilder.append(" and total >= ?");
                paramses.add(Integer.parseInt(crmCourseType.getTotalStart()));
            }

            if (StringUtils.isNotBlank(crmCourseType.getTotalEnd())) {
                stringBuilder.append(" and total <= ?");
                paramses.add(Integer.parseInt(crmCourseType.getTotalEnd()));
            }


            if (StringUtils.isNotBlank(crmCourseType.getCourseCostStart())) {
                stringBuilder.append(" and courseCost >= ?");
                paramses.add(Double.parseDouble(crmCourseType.getCourseCostStart()));
            }

            if (StringUtils.isNotBlank(crmCourseType.getCourseCostEnd())) {
                stringBuilder.append(" and courseCost <= ?");
                paramses.add(Double.parseDouble(crmCourseType.getCourseCostEnd()));
            }


        String condition = stringBuilder.toString();
        Object[] params =paramses.toArray();
        return courseTypeDao.findAll(condition, params);
    }
}
