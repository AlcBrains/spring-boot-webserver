package org.alcbrains.springbootserver.domain.repo;

import org.alcbrains.springbootserver.domain.entity.Salary;
import org.alcbrains.springbootserver.domain.entity.SalaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryId> {

    @Override
    Optional<Salary> findById(SalaryId salaryId);

}
