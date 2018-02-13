package com.scen.crm.classes.domain;

import com.scen.crm.coursetype.domain.CrmCourseType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 班级数据模型
 * @author Scen
 * @date 2018/2/13
 */
@Entity
@GenericGenerator(name = "uuid", strategy = "uuid")
@Table(name = "crm_class")
public class CrmClass {
    /**
     * 班级表主键id
     */
    private String classId;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 开班时间
     */
    private Date beginTime;

    /**
     * 毕业时间
     */
    private Date endTime;

    /**
     * 状态（未开课/已开课/已结束）
     */
    private String status;

    /**
     * 学生总数
     */
    private Integer totalCount;

    /**
     * 升学数
     */
    private Integer upgradeCount;

    /**
     * 转班数（转来）
     */
    private Integer changeCount;

    /**
     * 退费数（流失）
     */
    private Integer runoffCount;

    /**
     * 其他说明
     */
    private String remark;

    /**
     * 上传时间
     */
    private Date uploadTime;

    /**
     * 课表路径
     */
    private String uploadPath;

    /**
     * 上传的课表名称
     */
    private String uploadFilename;

    /**
     * 多对一，多个班级对应一个课程类别
     */
    private CrmCourseType crmCourseType;

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "classId", nullable = false, length = 50)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "beginTime", nullable = true)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "endTime", nullable = true)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "totalCount", nullable = true)
    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Basic
    @Column(name = "upgradeCount", nullable = true)
    public Integer getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(Integer upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    @Basic
    @Column(name = "changeCount", nullable = true)
    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    @Basic
    @Column(name = "runoffCount", nullable = true)
    public Integer getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(Integer runoffCount) {
        this.runoffCount = runoffCount;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "uploadTime", nullable = true)
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "uploadPath", nullable = true, length = 200)
    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Basic
    @Column(name = "uploadFilename", nullable = true, length = 100)
    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }


    @ManyToOne
    @JoinColumn(name = "courseTypeId")
    public CrmCourseType getCrmCourseType() {
        return crmCourseType;
    }

    public void setCrmCourseType(CrmCourseType crmCourseType) {
        this.crmCourseType = crmCourseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrmClass crmClass = (CrmClass) o;
        return Objects.equals(classId, crmClass.classId) &&
                Objects.equals(name, crmClass.name) &&
                Objects.equals(beginTime, crmClass.beginTime) &&
                Objects.equals(endTime, crmClass.endTime) &&
                Objects.equals(status, crmClass.status) &&
                Objects.equals(totalCount, crmClass.totalCount) &&
                Objects.equals(upgradeCount, crmClass.upgradeCount) &&
                Objects.equals(changeCount, crmClass.changeCount) &&
                Objects.equals(runoffCount, crmClass.runoffCount) &&
                Objects.equals(remark, crmClass.remark) &&
                Objects.equals(uploadTime, crmClass.uploadTime) &&
                Objects.equals(uploadPath, crmClass.uploadPath) &&
                Objects.equals(uploadFilename, crmClass.uploadFilename) &&
                Objects.equals(crmCourseType, crmClass.crmCourseType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId, name, beginTime, endTime, status, totalCount, upgradeCount, changeCount, runoffCount, remark, uploadTime, uploadPath, uploadFilename,crmCourseType);
    }
}
