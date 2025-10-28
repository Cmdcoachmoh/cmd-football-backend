package com.cmdfootball.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServerController {

    @GetMapping("/ping")
    public String ping() {
        return "CMD Football backend is alive!";
    }
}