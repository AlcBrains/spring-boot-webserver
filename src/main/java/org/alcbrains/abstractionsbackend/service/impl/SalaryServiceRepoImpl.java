package org.alcbrains.abstractionsbackend.service.impl;

import org.alcbrains.abstractionsbackend.domain.entity.Salary;
import org.alcbrains.abstractionsbackend.domain.entity.SalaryId;
import org.alcbrains.abstractionsbackend.domain.repo.SalaryRepository;
import org.alcbrains.abstractionsbackend.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class SalaryServiceRepoImpl implements SalaryService {

    private final SalaryRepository salaryRepository;

    public SalaryServiceRepoImpl(@Autowired SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public Optional<Salary> findSalaryById(int salaryId, String fromDate) {
        LocalDate localDate = LocalDate.parse(fromDate);
        return salaryRepository.findById(new SalaryId(salaryId, localDate));
    }

    @Override
    public void createSalary(Salary salary) throws IllegalArgumentException {
        salaryRepository.save(salary);
    }

    @Override
    public void deleteSalaryById(SalaryId salaryId) {
        salaryRepository.deleteById(salaryId);
    }
}
