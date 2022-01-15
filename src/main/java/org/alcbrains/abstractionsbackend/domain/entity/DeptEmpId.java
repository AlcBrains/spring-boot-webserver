package org.alcbrains.abstractionsbackend.domain.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DeptEmpId implements Serializable {

    private static final long serialVersionUID = -2905129501001678822L;

    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DeptEmpId entity = (DeptEmpId) o;
        return Objects.equals(this.empNo, entity.empNo) &&
                Objects.equals(this.deptNo, entity.deptNo);
    }
}
