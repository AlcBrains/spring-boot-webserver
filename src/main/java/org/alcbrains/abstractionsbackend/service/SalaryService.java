package org.alcbrains.abstractionsbackend.service;

import org.alcbrains.abstractionsbackend.domain.entity.Salary;
import org.alcbrains.abstractionsbackend.domain.entity.SalaryId;

import java.util.List;
import java.util.Optional;

public interface SalaryService {

    List<Salary> findAllSalaries();

    Optional<Salary> findSalaryById(int employeeId, String fromDate);

    void createSalary(Salary salary) throws IllegalArgumentException;

    void deleteSalaryById(SalaryId salaryId);

}
