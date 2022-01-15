package org.alcbrains.abstractionsbackend.domain.repo;

import org.alcbrains.abstractionsbackend.domain.entity.DeptEmp;
import org.alcbrains.abstractionsbackend.domain.entity.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {

    @Query("select d from DeptEmp d where d.id.deptNo = ?1")
    List<DeptEmp> findById_DeptNo(String deptNo);
}
