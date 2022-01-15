package org.alcbrains.abstractionsbackend.domain.repo;

import org.alcbrains.abstractionsbackend.domain.entity.DepartmentManager;
import org.alcbrains.abstractionsbackend.domain.entity.DepartmentManagerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, DepartmentManagerId> {
}
