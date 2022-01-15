package org.alcbrains.abstractionsbackend.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "dept_no", nullable = false, length = 4)
    private String id;

    @Column(name = "dept_name", nullable = false, length = 40)
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
