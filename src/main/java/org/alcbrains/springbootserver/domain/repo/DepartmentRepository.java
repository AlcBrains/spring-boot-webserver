package org.alcbrains.springbootserver.domain.repo;

import org.alcbrains.springbootserver.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
