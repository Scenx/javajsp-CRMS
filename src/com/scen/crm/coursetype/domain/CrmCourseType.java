package com.scen.crm.coursetype.domain;

import com.scen.crm.classes.domain.CrmClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 课程类别数据模型
 * @author Scen
 * @date 2018/2/13
 */
@Entity
@GenericGenerator(name = "uuid", strategy = "uuid")
@Table(name = "crm_course_type")
public class CrmCourseType {
    /**
     * 课程类别表主键id
     */
    private String courseTypeId;

    /**
     * 课程费用
     */
    private Double courseCost;

    /**
     * 总课时
     */
    private Integer total;

    /**
     * 课程类别名称
     */
    private String courseName;

    /**
     * 课程介绍模板
     */
    private String remark;


    /**
     * 一对多，一个课程类别对应多个班级
     */
    private Set<CrmClass> crmClassSet = new HashSet<CrmClass>();


    //查询条件 -- 一般查询条件都是字符串
    /**
     * 总学时
     */
    private String totalStart;
    private String totalEnd;
    /**
     * 课程费用
     */

    private String courseCostStart;
    private String courseCostEnd;


    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "courseTypeId", nullable = false, length = 255)
    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    @Basic
    @Column(name = "courseCost", nullable = true, precision = 0)
    public Double getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(Double courseCost) {
        this.courseCost = courseCost;
    }

    @Basic
    @Column(name = "total", nullable = true)
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Basic
    @Column(name = "courseName", nullable = true, length = 500)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 5000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @OneToMany
    @JoinColumn(name = "courseTypeId")
    public Set<CrmClass> getCrmClassSet() {
        return crmClassSet;
    }

    public void setCrmClassSet(Set<CrmClass> crmClassSet) {
        this.crmClassSet = crmClassSet;
    }

    @Transient
    public String getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(String totalStart) {
        this.totalStart = totalStart;
    }

    @Transient
    public String getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(String totalEnd) {
        this.totalEnd = totalEnd;
    }

    @Transient
    public String getCourseCostStart() {
        return courseCostStart;
    }

    public void setCourseCostStart(String courseCostStart) {
        this.courseCostStart = courseCostStart;
    }

    @Transient
    public String getCourseCostEnd() {
        return courseCostEnd;
    }

    public void setCourseCostEnd(String courseCostEnd) {
        this.courseCostEnd = courseCostEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrmCourseType that = (CrmCourseType) o;
        return Objects.equals(courseTypeId, that.courseTypeId) &&
                Objects.equals(courseCost, that.courseCost) &&
                Objects.equals(total, that.total) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseTypeId, courseCost, total, courseName, remark);
    }
}
