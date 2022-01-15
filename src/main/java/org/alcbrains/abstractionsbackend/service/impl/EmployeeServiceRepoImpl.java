package org.alcbrains.abstractionsbackend.service.impl;

import org.alcbrains.abstractionsbackend.domain.entity.Employee;
import org.alcbrains.abstractionsbackend.domain.entity.dto.EmployeeDTO;
import org.alcbrains.abstractionsbackend.domain.repo.EmployeeRepository;
import org.alcbrains.abstractionsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceRepoImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceRepoImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO, int employeeId) {

        Employee employee = findEmployeeById(employeeId).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setBirthDate(employeeDTO.getBirthDate());

        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);

    }
}
