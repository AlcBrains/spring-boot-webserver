package org.alcbrains.abstractionsbackend.controller;

import org.alcbrains.abstractionsbackend.domain.entity.Salary;
import org.alcbrains.abstractionsbackend.domain.entity.SalaryId;
import org.alcbrains.abstractionsbackend.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController(value = "salaries/")
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(@Autowired SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("")
    public List<Salary> getAllSalaries() {
        return salaryService.findAllSalaries();
    }

    @GetMapping("salary/{salaryId}")
    public Salary getSalaryById(@PathVariable int salaryId, @RequestParam String fromDate) throws EntityNotFoundException {
        return salaryService.findSalaryById(salaryId, fromDate).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("salary/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createSalary(@RequestBody Salary salary) {

        salaryService.createSalary(salary);
        return "Successfully created Salary";
    }

    @DeleteMapping("salary/${salaryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteSalary(@RequestParam SalaryId salaryId) {
        salaryService.deleteSalaryById(salaryId);
        return "Successfully Deleted salary with Id " + salaryId;
    }


}
