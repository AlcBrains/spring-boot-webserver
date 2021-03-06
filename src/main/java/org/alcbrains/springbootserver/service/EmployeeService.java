package org.alcbrains.springbootserver.service;

import org.alcbrains.springbootserver.domain.entity.Employee;
import org.alcbrains.springbootserver.domain.entity.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Optional<Employee> findEmployeeById(int employeeId);

    void createEmployee(Employee employee);

    void updateEmployee(EmployeeDTO employeeDTO, int employeeId);

    void deleteEmployee(int employeeId);

}
