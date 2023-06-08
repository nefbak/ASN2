package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.User;
import com.example.demo.models.UserRepository;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class UsersControllers {

    @Autowired
    private UserRepository userrepo;

    @GetMapping("/users/view")
    public String getAllUsers( Model model){
        List<User> users = userrepo.findAll();
        
        model.addAttribute("us", users);

        return "users/showAll";
    }

    @PostMapping("users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        String newName = newuser.get("name");
        String newpass = newuser.get("password");
        int newweight = Integer.parseInt(newuser.get("size"));
               
        userrepo.save(new User(newName,newpass,newweight));
        response.setStatus(201);
        return "users/addedUser";
    }
}
