package com.project.e_pharmacie_spring_client;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return null;
    }

    @RequestMapping("/error")
    public String handleError() {
        return "redirect:/login";
    }

}