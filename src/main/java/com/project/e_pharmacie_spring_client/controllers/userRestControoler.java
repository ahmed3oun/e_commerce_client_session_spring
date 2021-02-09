package com.project.e_pharmacie_spring_client.controllers;

import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class userRestControoler {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView();
        List<User> userList = userService.listAll();
        model.addObject("users",userList );
        model.setViewName("users");
        return model;
    }
@GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user=userService.getUserById(id);
        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}


}
