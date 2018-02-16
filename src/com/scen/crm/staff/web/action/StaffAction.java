package com.scen.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scen.crm.department.domain.CrmDepartment;
import com.scen.crm.department.service.DepartmentService;
import com.scen.crm.staff.domain.CrmStaff;
import com.scen.crm.staff.service.StaffService;
import java.util.List;

/**
 * 员工表现层
 * @author Scen
 * @date 2018/2/14
 */
public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {
    /**
     * 生成set方法
     * spring自动注入
     */
    private CrmStaff crmStaff;
    private StaffService staffService;
    @Override
    public CrmStaff getModel() {
        return crmStaff;
    }

    public CrmStaff getCrmStaff() {
        return crmStaff;
    }

    public void setCrmStaff(CrmStaff crmStaff) {
        this.crmStaff = crmStaff;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    /////////////////////////////////////////

    /**
     * 登录方法
     * @return 成功或者回显错误信息
     */
    public String login(){
        crmStaff= staffService.login(crmStaff);
        if (crmStaff != null) {
            ActionContext.getContext().getSession().put("loginStaff", crmStaff);
            return "success";
        } else {
            this.addFieldError("","用户名与密码不匹配");
            return "login";
        }
    }

    ////////////////////////////////////////

    /**
     * 显示首页
     * @return 返回到首页
     */
    public String home() {
        return "home";
    }


//////////////////////////////////////////////////////////

    private List<CrmStaff> crmStaffs;

    public List<CrmStaff> getCrmStaffs() {
        return crmStaffs;
    }

    /**
     * 查询所有员工
     * @return 回显所有员工数据到页面
     */
    public String findAll() {
        crmStaffs = staffService.findAllStaff();
        return "findAll";
    }
    /////////////////////////////////////////////

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    List<CrmDepartment> crmDepartments;

    public List<CrmDepartment> getCrmDepartments() {
        return crmDepartments;
    }

    /**
     * 通过id查询员工
     * @return 回显查询到的员工对象的信息到编辑表单
     */
    public String editUI() {
//        通过id查询员工
        crmStaff = staffService.findById(crmStaff.getStaffId());
        ActionContext.getContext().getValueStack().push(crmStaff);

//        查询所有部门
        crmDepartments = departmentService.findAll();

        return "editUI";
    }


    ////////////////////////////////////////////////

    /**
     * 编辑员工信息
     * @return 回显到查询所有员工页面
     */
    public String edit() {
        staffService.updateStaff(crmStaff);
        return "edit";
    }
}
