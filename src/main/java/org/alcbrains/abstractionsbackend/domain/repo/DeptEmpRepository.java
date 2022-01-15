package org.alcbrains.abstractionsbackend.domain.repo;

import org.alcbrains.abstractionsbackend.domain.entity.DeptEmp;
import org.alcbrains.abstractionsbackend.domain.entity.DeptEmpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpId> {
}
