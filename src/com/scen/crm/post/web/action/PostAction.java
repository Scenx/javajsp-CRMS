package com.scen.crm.post.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scen.crm.post.domain.CrmPost;
import com.scen.crm.post.service.PostService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

/**
 * 职务表现层
 * @author Scen
 * @date 2018/2/15
 */
public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {
    private CrmPost crmPost;

    private PostService postService;

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Override
    public CrmPost getModel() {
        return crmPost;
    }

    public CrmPost getCrmPost() {
        return crmPost;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }

    /////////////////////////////////////////////////////////

    private List<CrmPost> crmPosts;

    public List<CrmPost> getCrmPosts() {
        return crmPosts;
    }

    /**
     * ajax通过部门，查询所有的职务
     * @return
     */
    public String findAllWithDepartment() throws IOException {
        crmPosts = postService.findAll(crmPost.getCrmDepartment());

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"crmDepartment","staffSet"});

        String jsonData = JSONArray.fromObject(crmPosts,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().print(jsonData);
        return "none";
    }
}
