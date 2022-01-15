package org.alcbrains.abstractionsbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.alcbrains.abstractionsbackend.domain.entity.Salary;
import org.alcbrains.abstractionsbackend.domain.entity.SalaryId;
import org.alcbrains.abstractionsbackend.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import java.net.http.HttpResponse;

@Controller(value = "salaries/")
public class SalaryController {

    private final SalaryService salaryService;
    private final ObjectMapper objectMapper;


    public SalaryController(@Autowired SalaryService salaryService) {
        this.salaryService = salaryService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("salary/{salaryId}")
    @ResponseBody
    public Salary getSalaryById(@PathVariable int salaryId, @RequestParam String fromDate) throws EntityNotFoundException {
        return salaryService.findSalaryById(salaryId, fromDate).orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("salary/")
    @ResponseBody
    public String createSalary(@RequestBody String salaryObject) throws JsonProcessingException {

        //Extract from object Employee Id and fromDate
        Salary salary = objectMapper.readValue(salaryObject, Salary.class);
        salaryService.createSalary(salary);
        return "Successfully created Salary";
    }

    @DeleteMapping("salary/${salaryId}")
    @ResponseBody
    public String deleteSalary(@RequestParam SalaryId salaryId) {

        salaryService.deleteSalaryById(salaryId);

        return "Successfully Deleted salary with Id " + salaryId;
    }


}
