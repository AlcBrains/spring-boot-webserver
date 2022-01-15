package org.alcbrains.abstractionsbackend.controller;


import org.alcbrains.abstractionsbackend.domain.entity.Title;
import org.alcbrains.abstractionsbackend.domain.entity.TitleId;
import org.alcbrains.abstractionsbackend.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController(value = "titles/")
public class TitleController {

    private final TitleService titleService;

    public TitleController(@Autowired TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("")
    public List<Title> getAllTitles() {
        return titleService.findAllTitles();
    }

    @GetMapping("title")
    public Title getTitle(@RequestParam int empNo, @RequestParam String title, @RequestParam String fromDate) {
        return titleService.getTitleById(new TitleId(empNo, title, LocalDate.parse(fromDate)))
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("title")
    @ResponseStatus(HttpStatus.CREATED)
    public String createTitle(@RequestBody TitleId stringTitle) {
        titleService.createTitle(new Title(stringTitle));
        return "Title Created Successfully";
    }

    @DeleteMapping("title/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteTitle(@RequestBody Title title) {
        titleService.deleteTitle(title);
        return "Title Deleted Successfully";
    }
}
