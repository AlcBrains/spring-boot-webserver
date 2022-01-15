package org.alcbrains.abstractionsbackend.domain.repo;

import org.alcbrains.abstractionsbackend.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
