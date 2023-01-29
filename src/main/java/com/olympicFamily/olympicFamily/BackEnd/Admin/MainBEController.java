package com.olympicFamily.olympicFamily.BackEnd.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainBEController {

    @GetMapping("/BEOFAdmin")
    public String viewHomePage(){
        return "BackEnd/BEindex";
    }
}
