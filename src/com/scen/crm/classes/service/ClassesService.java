package com.scen.crm.classes.service;

import com.scen.crm.classes.domain.CrmClass;

import java.util.List;

/**
 * 班级业务层接口
 * @author Scen
 * @date 2018/2/19
 */
public interface ClassesService {

    /**
     * 查询所有班级
     * @return 所有班级对象
     */
    List<CrmClass> findAll();

    /**
     * 通过id查询班级详情
     * @param classesId
     * @return 一个班级对象
     */
    CrmClass findById(String classesId);

    /**
     * 更新上传
     * @param crmClass
     */
    void updateUpload(CrmClass crmClass);
}
