package org.alcbrains.springbootserver.service;

import org.alcbrains.springbootserver.domain.entity.Salary;
import org.alcbrains.springbootserver.domain.entity.SalaryId;

import java.util.List;
import java.util.Optional;

public interface SalaryService {

    List<Salary> findAllSalaries();

    Optional<Salary> findSalaryById(int employeeId, String fromDate);

    void createSalary(Salary salary) throws IllegalArgumentException;

    void deleteSalaryById(SalaryId salaryId);

}
