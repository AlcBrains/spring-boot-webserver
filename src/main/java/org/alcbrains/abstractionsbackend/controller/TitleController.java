package org.alcbrains.abstractionsbackend.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.alcbrains.abstractionsbackend.domain.entity.Title;
import org.alcbrains.abstractionsbackend.domain.entity.TitleId;
import org.alcbrains.abstractionsbackend.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("titles")
public class TitleController {

    private final TitleService titleService;
    private final ObjectMapper objectMapper;

    public TitleController(@Autowired TitleService titleService) {
        this.titleService = titleService;
        this.objectMapper = new ObjectMapper();
    }

    @GetMapping("")
    public List<Title> getAllTitles() {
        return titleService.findAllTitles();
    }

    @GetMapping("/title")
    public Title getTitle(@RequestParam int empNo, @RequestParam String title, @RequestParam String fromDate) {
        return titleService.getTitleById(new TitleId(empNo, title, LocalDate.parse(fromDate)))
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping("/title")
    @ResponseStatus(HttpStatus.CREATED)
    public String createTitle(@RequestBody String stringTitle) throws JsonProcessingException {
        TitleId titleId = objectMapper.readValue(stringTitle, TitleId.class);
        titleService.createTitle(new Title(titleId));
        return "Title Created Successfully";
    }

    @DeleteMapping("title/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteTitle(@RequestBody String stringTitleId) throws JsonProcessingException {
        TitleId titleId = objectMapper.readValue(stringTitleId, TitleId.class);
        titleService.deleteTitle(titleId);
        return "Title Deleted Successfully";
    }
}
