package org.alcbrains.springbootserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.alcbrains.springbootserver.domain.entity.Salary;
import org.alcbrains.springbootserver.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("salaries")
public class SalaryController {

    private final SalaryService salaryService;
    private final ObjectMapper objectMapper;

    public SalaryController(@Autowired SalaryService salaryService) {
        this.salaryService = salaryService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("")
    public List<Salary> getAllSalaries() {
        return salaryService.findAllSalaries();
    }

    @GetMapping("/salary/{employeeId}")
    public Salary getSalaryOfEmployee(@PathVariable int employeeId, @RequestParam String fromDate) throws EntityNotFoundException {
        return salaryService.findSalaryById(employeeId, fromDate).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("/salary")
    @ResponseStatus(HttpStatus.CREATED)
    public String createSalary(@RequestBody String salary) throws JsonProcessingException {
        Salary salary1 = objectMapper.readValue(salary, Salary.class);
        salaryService.createSalary(salary1);
        return "Successfully created Salary";
    }

}
