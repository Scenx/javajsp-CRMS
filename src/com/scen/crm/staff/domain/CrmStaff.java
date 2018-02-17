package com.scen.crm.staff.domain;

import com.scen.crm.post.domain.CrmPost;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 员工数据模型
 *
 * @author Scen
 * @date 2018/2/12
 */
@Entity
@GenericGenerator(name = "uuid", strategy = "uuid")
@Table(name = "crm_staff")
public class CrmStaff {
    /**
     * 员工表主键id
     */
    private String staffId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工性别
     */
    private String gender;

    /**
     * 员工入职日期
     */
    private Date onDutyDate;

    /**
     * 多对一，多个员工对应一个职务
     */
    private CrmPost crmPost;


    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "staffId", nullable = false, length = 255)
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "loginName", nullable = true, length = 100)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "loginPwd", nullable = true, length = 100)
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Basic
    @Column(name = "staffName", nullable = true, length = 100)
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 20)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "onDutyDate", nullable = true)
    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }


    @ManyToOne
    @JoinColumn(name = "postId")
    public CrmPost getCrmPost() {
        return crmPost;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrmStaff crmStaff = (CrmStaff) o;
        return Objects.equals(staffId, crmStaff.staffId) &&
                Objects.equals(loginName, crmStaff.loginName) &&
                Objects.equals(loginPwd, crmStaff.loginPwd) &&
                Objects.equals(staffName, crmStaff.staffName) &&
                Objects.equals(gender, crmStaff.gender) &&
                Objects.equals(onDutyDate, crmStaff.onDutyDate) &&
                Objects.equals(crmPost, crmStaff.crmPost);
    }

    @Override
    public int hashCode() {

        return Objects.hash(staffId, loginName, loginPwd, staffName, gender, onDutyDate, crmPost);
    }
}
