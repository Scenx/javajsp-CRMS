package com.scen.crm.coursetype.service.impl;

import com.scen.crm.coursetype.dao.CourseTypeDao;
import com.scen.crm.coursetype.domain.CrmCourseType;
import com.scen.crm.coursetype.service.CourseTypeService;
import com.scen.crm.page.PageBean;
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
    public CrmCourseType findById(String courseTypeId) {
        return courseTypeDao.findById(courseTypeId);
    }

    @Override
    public void addOrEdit(CrmCourseType crmCourseType) {
        courseTypeDao.saveOrUpdate(crmCourseType);
    }

    @Override
    public PageBean<CrmCourseType> findAll(CrmCourseType crmCourseType, int pageNum, int pageSize) {

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
        Object[] params = paramses.toArray();

        int totalRecord = courseTypeDao.getTotalRecord(condition, params);

        PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);

        List<CrmCourseType> data = courseTypeDao.findAll(condition, params, pageBean.getStartIndex(), pageBean.getPageSize());

        pageBean.setData(data);

        return pageBean;
    }

}
