package com.ke.adc.chief_experience_officer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "hello";
    }
}
