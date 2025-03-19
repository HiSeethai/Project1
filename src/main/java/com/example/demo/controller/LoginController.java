package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    
    @GetMapping("/")
    public String showForm() {
        return "register";  // Loads form.html
    }

    
    @PostMapping("/submit")
    public String submitForm(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
    	System.out.println(" Received Data: Username = " + username + ", Password = " + password); 
        userService.saveUser(username, password);
        redirectAttributes.addFlashAttribute("success", "User added successfully!");
        return "redirect:/";  
    }
}
