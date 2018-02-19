package com.scen.crm.classes.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.scen.crm.classes.domain.CrmClass;
import com.scen.crm.classes.service.ClassesService;
import com.scen.crm.utils.MyStringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 班级表现层
 *
 * @author Scen
 * @date 2018/2/19
 */
public class ClassesAction extends ActionSupport implements ModelDriven<CrmClass> {
    private CrmClass crmClass;

    public CrmClass getCrmClass() {
        return crmClass;
    }

    public void setCrmClass(CrmClass crmClass) {
        this.crmClass = crmClass;
    }

    @Override
    public CrmClass getModel() {
        return crmClass;
    }

    private ClassesService classesService;

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    /////////////////////////////////////////////////////////////////////////

    List<CrmClass> crmClasses;

    public List<CrmClass> getCrmClasses() {
        return crmClasses;
    }

    /**
     * 查询所有班级
     *
     * @return
     */
    public String findAll() {
        crmClasses = classesService.findAll();
        return "findAll";
    }

    ////////////////////////////////////////////////////////////////////////////////


    /**
     * 显示上传表单
     *
     * @return
     */
    public String uploadUI() {
        BeanUtils.copyProperties(classesService.findById(crmClass.getClassId()), crmClass);
        return "uploadUI";
    }


    /////////////////////////////////////////////////////////////////////////


    private File schedule;
    private String scheduleFileName;

    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }

    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }

    /**
     * 课表上传
     *
     * @return
     */
    @InputConfig(resultName = "uploadInput")
    public String upload() throws IOException {
        String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
        String fileName = MyStringUtils.getUUID();
        FileUtils.copyFile(schedule, new File(parentDir, fileName));
        crmClass.setUploadTime(new Date());
        crmClass.setUploadPath("/WEB-INF/upload/"+fileName);
        crmClass.setUploadFilename(scheduleFileName);
        classesService.updateUpload(crmClass);
        return "upload";
    }


}
