package com.scen.crm.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 登录拦截器
 * @author Scen
 * @date 2018/2/14
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    public String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Object o = ActionContext.getContext().getSession().get("loginStaff");
        if (o == null) {
            Object action = actionInvocation.getAction();
            if (action instanceof ActionSupport) {
                ActionSupport actionSupport = (ActionSupport) action;
                actionSupport.addFieldError("","请登录");
            }
            return "login";
        } else {
            return actionInvocation.invoke();
        }
    }
}
