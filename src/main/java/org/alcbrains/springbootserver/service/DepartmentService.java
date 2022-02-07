package org.alcbrains.springbootserver.service;

import org.alcbrains.springbootserver.domain.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Optional<Department> findById(String departmentNo);

    void updateDepartment(String departmentNo, String departmentName);

    void deleteDepartment(String departmentNo);

    void addEmployeesTodepartment(List<Integer> employeeList, String departmentNo);

    void removeEmployeesFromDepartment(List<Integer> employeeList, String departmentNo);

}
