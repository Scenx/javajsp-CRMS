package com.scen.crm.classes.service.impl;

import com.scen.crm.classes.dao.ClassesDao;
import com.scen.crm.classes.domain.CrmClass;
import com.scen.crm.classes.service.ClassesService;

import java.util.List;

/**
 * @author Scen
 * @date 2018/2/19
 */
public class ClassesServiceImpl implements ClassesService {

    private ClassesDao classesDao;

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public List<CrmClass> findAll() {
        return classesDao.findAll();
    }

    @Override
    public CrmClass findById(String classesId) {
        return classesDao.findById(classesId);
    }

    @Override
    public void updateUpload(CrmClass crmClass) {
        CrmClass findClass = classesDao.findById(crmClass.getClassId());
        findClass.setUploadFilename(crmClass.getUploadFilename());
        findClass.setUploadPath(crmClass.getUploadPath());
        findClass.setUploadTime(crmClass.getUploadTime());
    }
}
