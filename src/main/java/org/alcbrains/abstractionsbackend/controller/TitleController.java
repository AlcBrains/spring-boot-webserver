package org.alcbrains.abstractionsbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller(value = "titles/")
public class TitleController {

    @GetMapping("")
    @ResponseBody
    public String getTitles() {
        return null;
    }
}
