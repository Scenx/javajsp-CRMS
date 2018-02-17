package com.scen.crm.post.domain;

import com.scen.crm.department.domain.CrmDepartment;
import com.scen.crm.staff.domain.CrmStaff;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 职位数据模型
 *
 * @author Scen
 * @date 2018/2/12
 */
@Entity
@GenericGenerator(name = "uuid", strategy = "uuid")
@Table(name = "crm_post")
public class CrmPost {
    /**
     * 职务表主键id
     */
    private String postId;

    /**
     * 职务名称
     */
    private String postName;

    /**
     * 多对一，多个职务对应一个部门
     */
    private CrmDepartment crmDepartment;

    /**
     * 一对多，一个职务对应多个员工
     */
    private Set<CrmStaff> staffSet = new HashSet<CrmStaff>();

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "postId", nullable = false, length = 255)
    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "postName", nullable = true, length = 100)
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @ManyToOne
    @JoinColumn(name = "depId")
    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    @OneToMany
    @JoinColumn(name = "postId")
    public Set<CrmStaff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<CrmStaff> staffSet) {
        this.staffSet = staffSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrmPost crmPost = (CrmPost) o;
        return Objects.equals(postId, crmPost.postId) &&
                Objects.equals(postName, crmPost.postName) &&
                Objects.equals(crmDepartment, crmPost.crmDepartment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(postId, postName, crmDepartment);
    }
}
