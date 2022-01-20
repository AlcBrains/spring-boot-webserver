package org.alcbrains.abstractionsbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.alcbrains.abstractionsbackend.domain.entity.Department;
import org.alcbrains.abstractionsbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final ObjectMapper objectMapper;

    public DepartmentController(@Autowired DepartmentService departmentService) {
        this.departmentService = departmentService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/department/{departmentNo}")
    public Department getDepartmentById(@PathVariable String departmentNo) {
        return departmentService.findById(departmentNo).orElseThrow(EntityNotFoundException::new);
    }

    @PatchMapping("/department/{departmentNo}")
    public String updateDepartmentName(@PathVariable String departmentNo, @RequestBody String deptName) {
        departmentService.updateDepartment(departmentNo, deptName);
        return "Successfully Patched Department Name";
    }

    @DeleteMapping("/department/{departmentNo}")
    public String deleteDepartment(@PathVariable String departmentNo) {
        departmentService.deleteDepartment(departmentNo);
        return "Successfully Deleted Department";
    }

    @PostMapping("/department/{departmentId}/employees/add")
    public String addEmployeesToDepartment(@PathVariable String departmentId, @RequestBody String employees) throws JsonProcessingException {
        ArrayList<Integer> employeeIds = objectMapper.readValue(employees, ArrayList.class);
        departmentService.addEmployeesTodepartment(employeeIds, departmentId);
        return "Successfully Updated Employee List of Department";
    }

    @PostMapping("/department/{departmentId}/employees/remove")
    public String removeEmployeesFromDepartment(@PathVariable String departmentId, @RequestBody String employees) throws JsonProcessingException {
        ArrayList<Integer> employeeIds = objectMapper.readValue(employees, ArrayList.class);
        departmentService.removeEmployeesFromDepartment(employeeIds, departmentId);
        return "Successfully Updated Employee List of Department";
    }
}
