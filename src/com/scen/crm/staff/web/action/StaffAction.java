package com.scen.crm.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scen.crm.staff.domain.CrmStaff;
import com.scen.crm.staff.service.StaffService;

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
        CrmStaff findStaff = staffService.login(crmStaff);
        if (findStaff != null) {
            ActionContext.getContext().getSession().put("loginStaff", findStaff);
            return "success";
        } else {
            this.addFieldError("","用户名与密码不匹配");
            return "login";
        }
    }

    /**
     * 显示首页
     * @return 返回到首页
     */
    public String home() {
        return "home";
    }
}
