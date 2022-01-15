package org.alcbrains.abstractionsbackend.domain.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class TitleId implements Serializable {

    private static final long serialVersionUID = 2636532200630659629L;

    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "from_date", nullable = false)
    private LocalDate fromDate;

    public TitleId() {
    }

    public TitleId(Integer empNo, String title, LocalDate fromDate) {
        this.empNo = empNo;
        this.title = title;
        this.fromDate = fromDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromDate, empNo, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TitleId entity = (TitleId) o;
        return Objects.equals(this.fromDate, entity.fromDate) &&
                Objects.equals(this.empNo, entity.empNo) &&
                Objects.equals(this.title, entity.title);
    }
}
