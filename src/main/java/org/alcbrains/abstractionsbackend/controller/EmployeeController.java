package org.alcbrains.abstractionsbackend.controller;

import org.alcbrains.abstractionsbackend.domain.entity.Employee;
import org.alcbrains.abstractionsbackend.domain.entity.dto.EmployeeDTO;
import org.alcbrains.abstractionsbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController("employees/")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.findEmployeeById(employeeId).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("employee")
    @ResponseStatus(HttpStatus.CREATED)
    public String createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return "Employee created successfully";
    }

    @PatchMapping("employee/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateEmployee(@RequestBody EmployeeDTO employeeDto, @PathVariable int employeeId) {
        employeeService.updateEmployee(employeeDto, employeeId);
        return "Employee updated Successfully";
    }

    @DeleteMapping("employee/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmployee(@PathVariable int employeeId){
        employeeService.deleteEmployee(employeeId);
        return "Employee Successfully deleted";
    }

}
