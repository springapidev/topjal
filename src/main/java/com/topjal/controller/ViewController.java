package com.topjal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/page1")
     public String page1() {
        return "page";
    }
    @GetMapping("/page2")
    public String page2() {
        return "page2";
    }

}