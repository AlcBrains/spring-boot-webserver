package org.alcbrains.abstractionsbackend.domain.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class SalaryId implements Serializable {

    public SalaryId() {

    }

    public SalaryId(Integer empNo, LocalDate fromDate) {
        this.empNo = empNo;
        this.fromDate = fromDate;
    }

    private static final long serialVersionUID = 787879606512109183L;

    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromDate, empNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SalaryId entity = (SalaryId) o;
        return Objects.equals(this.fromDate, entity.fromDate) &&
                Objects.equals(this.empNo, entity.empNo);
    }
}
