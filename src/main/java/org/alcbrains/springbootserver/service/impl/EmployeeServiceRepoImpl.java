package org.alcbrains.springbootserver.service.impl;

import org.alcbrains.springbootserver.domain.entity.Employee;
import org.alcbrains.springbootserver.domain.entity.dto.EmployeeDTO;
import org.alcbrains.springbootserver.domain.repo.EmployeeRepository;
import org.alcbrains.springbootserver.service.EmployeeService;
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
