package com.vishnevsky.salon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "main";
    }
    @GetMapping("/help")
    public String help(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "help";
    }
}
