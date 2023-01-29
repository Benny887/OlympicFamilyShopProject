package com.olympicFamily.olympicFamily.FrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainFEController {
    @GetMapping("/FEOFAdmin")
    public String viewHomePage(){
        return "FrontEnd/FEindex";
    }
}
