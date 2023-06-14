package com.example.demo.controllers;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

@RequestMapping("/ad")
    public String getAdd( Model model){
        return "redirect:/add.html";
    }

    @RequestMapping("/save")
    public String saveAdd(Model model, @ModelAttribute("user") User user){
        userrepo.save(user);
        List<User> users = userrepo.findAll();
        model.addAttribute("us", users);
        return "users/showAll";
    }


    @PostMapping("users/add")
    public String addUser(@RequestParam Map<String, String> newuser, HttpServletResponse response){
        String newName = newuser.get("name");
        String newpass = newuser.get("haircolor");
        int newheight = Integer.parseInt(newuser.get("height"));
        int newweight = Integer.parseInt(newuser.get("weight"));
        float newgpa = Float.parseFloat(newuser.get("gpa"));
        userrepo.save(new User(newName,newpass,newheight, newweight,newgpa));
        response.setStatus(201);
        return "users/addedUser";
    }

    
    @GetMapping("users/edit/{uid}")
    public String addeditUser(Model model, @PathVariable String uid, RedirectAttributes ra){
  
         
        try {
            int id = Integer.parseInt(uid);
            List<User> us = new ArrayList<>();
            User u = userrepo.findById(id).get();
            model.addAttribute("u", u);
            us.add(u);
            model.addAttribute("us", us);
            userrepo.delete(u);
            return "users/edit";
          
        } catch (Exception e) {
        e.printStackTrace();
        return "users/showAll";
        }

        
    
    }

    @RequestMapping("/edit/{uid}")
    public String gottoedit( Model model, @PathVariable String uid){
        int id = Integer.parseInt(uid);
        User u = userrepo.findById(id).get();
        model.addAttribute("us", u);
        return "redirect:/edit.html/{uid}";
    }


    @GetMapping("/users/delete/{uid}")
    public String getUser(Model model, @PathVariable String uid){
        if(uid != null){
       int id = Integer.parseInt(uid);
       User u = userrepo.findById(id).get();
        userrepo.delete(u);
        model.addAttribute("user");
        List<User> users = userrepo.findAll();
        model.addAttribute("us", users);
    }
    return "users/showAll";}


}
