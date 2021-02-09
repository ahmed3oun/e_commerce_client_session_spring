package com.project.e_pharmacie_spring_client.controllers;

import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserController {

    @Autowired
    private UserService userService;

    

    @RequestMapping("/users")
    public String getAllUser(Model model) {
        List<User> users = userService.listAll();
        model.addAttribute("users", userService.listAll());
        return "users";
    }


    @RequestMapping("/login")
    public String showlogin() {
        return "login";
    }

   /* @PostMapping("/checklogin")
    public String checklogin(ModelMap model, @RequestParam("mail") String mail,
            @RequestParam("password") String password, HttpSession Httpsession) {
        if (userService.getUserBymail(mail).getMail().equals(mail)
                && userService.getUserBymail(mail).getPassword().equals(password)) {
            Httpsession.setAttribute("mail", userService.getUserBymail(mail).getName());
            return "redirect:/index";
        } else {

            return "login";
        }

    }*/

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

}