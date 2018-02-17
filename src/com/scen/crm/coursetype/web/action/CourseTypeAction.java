package com.scen.crm.coursetype.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scen.crm.coursetype.domain.CrmCourseType;
import com.scen.crm.coursetype.service.CourseTypeService;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 课程类别表现层
 *
 * @author Scen
 * @date 2018/2/16
 */
public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
    private CrmCourseType crmCourseType;

    public CrmCourseType getCrmCourseType() {
        return crmCourseType;
    }

    public void setCrmCourseType(CrmCourseType crmCourseType) {
        this.crmCourseType = crmCourseType;
    }

    private CourseTypeService courseTypeService;

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }

    @Override
    public CrmCourseType getModel() {
        return crmCourseType;
    }
    ///////////////////////////////////////////////////////////

    List<CrmCourseType> crmCourseTypes;

    public List<CrmCourseType> getCrmCourseTypes() {
        return crmCourseTypes;
    }

    /**
     * 查询所有课程类别并展示到页面
     *
     * @return 回显结果
     */
    public String findAll() {
        crmCourseTypes = courseTypeService.findAll(crmCourseType);
        return "findAll";
    }

    ////////////////////////////////////////////

    /**
     * 编辑时回显课程类别数据
     *
     * @return 显示课程类别的数据到编辑页面
     */
    public String addOrEditUI() {
        BeanUtils.copyProperties(courseTypeService.findById(crmCourseType.getCourseTypeId()), crmCourseType);
        return "addOrEditUI";
    }


    ///////////////////////////////////////////////////

    /**
     * 添加课程类别
     *
     * @return 添加成功后到课程类别list页面
     */
    public String addOrEdit() {
        courseTypeService.addOrEdit(crmCourseType);
        return "addOrEdit";
    }
}
