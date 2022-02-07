package org.alcbrains.springbootserver.domain.repo;

import org.alcbrains.springbootserver.domain.entity.DepartmentManager;
import org.alcbrains.springbootserver.domain.entity.DepartmentManagerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, DepartmentManagerId> {
}
