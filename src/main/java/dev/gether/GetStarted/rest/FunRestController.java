package dev.gether.GetStarted.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    @Value("${author.name}")
    private String authorName;
    @Value("${author.website}")
    private String authorWebiste;

    @GetMapping("/")
    public String funHome()
    {
        return "Home";
    }
    @GetMapping("/author")
    public String getAuthorName()
    {
        return "Author: " + authorName + ", Website: " + authorWebiste;
    }



}
