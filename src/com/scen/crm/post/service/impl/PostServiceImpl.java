package com.scen.crm.post.service.impl;

import com.scen.crm.department.domain.CrmDepartment;
import com.scen.crm.post.dao.PostDao;
import com.scen.crm.post.domain.CrmPost;
import com.scen.crm.post.service.PostService;

import java.util.List;

/**
 * 职务业务层实现类
 *
 * @author Scen
 * @date 2018/2/15
 */
public class PostServiceImpl implements PostService {

    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<CrmPost> findAll(CrmDepartment crmDepartment) {
        return postDao.findAll(crmDepartment);
    }
}
