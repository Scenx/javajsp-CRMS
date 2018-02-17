package com.scen.crm.department.domain;

import com.scen.crm.post.domain.CrmPost;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 部门数据模型
 *
 * @author Scen
 * @date 2018/2/12
 */
@Entity
@GenericGenerator(name = "uuid", strategy = "uuid")
@Table(name = "crm_department")
public class CrmDepartment {
    /**
     * 部门表主键id
     */
    private String depId;

    /**
     * 部门名称
     */
    private String depName;

    /**
     * 一对多，一个部门对应多个职务
     */
    private Set<CrmPost> postSet = new HashSet<CrmPost>();

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "depId", nullable = false, length = 255)
    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "depName", nullable = true, length = 50)
    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @OneToMany
    @JoinColumn(name = "depId")
    public Set<CrmPost> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<CrmPost> postSet) {
        this.postSet = postSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrmDepartment that = (CrmDepartment) o;
        return Objects.equals(depId, that.depId) &&
                Objects.equals(depName, that.depName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(depId, depName);
    }
}
