package org.alcbrains.abstractionsbackend.service;

import org.alcbrains.abstractionsbackend.domain.entity.Salary;
import org.alcbrains.abstractionsbackend.domain.entity.SalaryId;

import java.util.Optional;

public interface SalaryService {

    Optional<Salary> findSalaryById(int salaryId, String fromDate);

    void createSalary(Salary salary) throws IllegalArgumentException;

    void deleteSalaryById(SalaryId salaryId);

}
