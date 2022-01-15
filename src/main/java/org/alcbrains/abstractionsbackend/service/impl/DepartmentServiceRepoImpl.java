package org.alcbrains.abstractionsbackend.service.impl;

import org.alcbrains.abstractionsbackend.domain.entity.Department;
import org.alcbrains.abstractionsbackend.domain.entity.DeptEmp;
import org.alcbrains.abstractionsbackend.domain.entity.DeptEmpId;
import org.alcbrains.abstractionsbackend.domain.repo.DepartmentRepository;
import org.alcbrains.abstractionsbackend.domain.repo.DeptEmpRepository;
import org.alcbrains.abstractionsbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceRepoImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DeptEmpRepository deptEmpRepository;

    public DepartmentServiceRepoImpl(@Autowired DepartmentRepository departmentRepository,
                                     @Autowired DeptEmpRepository deptEmpRepository) {
        this.departmentRepository = departmentRepository;
        this.deptEmpRepository = deptEmpRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(String departmentNo) {
        return departmentRepository.findById(departmentNo);
    }

    @Override
    public void updateDepartment(String departmentNo, String departmentName) {

        Department dpt = departmentRepository.findById(departmentNo).orElseThrow(EntityNotFoundException::new);
        dpt.setDeptName(departmentName);
        departmentRepository.save(dpt);
    }

    @Override
    public void deleteDepartment(String departmentNo) {
        Department dpt = departmentRepository.findById(departmentNo).orElseThrow(EntityNotFoundException::new);
        departmentRepository.delete(dpt);
    }

    @Override
    public void addEmployeesTodepartment(List<Integer> employeeList, String departmentNo) {

        List<DeptEmp> deptEmps = new ArrayList<>();
        for (Integer employee : employeeList) {
            deptEmps.add(new DeptEmp(new DeptEmpId(employee, departmentNo)));
        }
        deptEmpRepository.saveAll(deptEmps);
    }

    @Override
    public void removeEmployeesFromDepartment(List<Integer> employeeList, String departmentNo) {
        List<DeptEmp> deptEmps = deptEmpRepository.findById_DeptNo(departmentNo);
        for (DeptEmp deptEmp : deptEmps) {
            deptEmp.setToDate(LocalDate.now());
        }
        deptEmpRepository.saveAll(deptEmps);
    }
}
