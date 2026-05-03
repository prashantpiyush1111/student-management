package com.student.controller;

import com.student.model.Admin;
import com.student.repository.AdminRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private AdminRepository repo;
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        Admin admin = repo.findByUsernameAndPassword(username, password);

        if(admin != null) {
            session.setAttribute("admin", admin.getUsername());
            session.setAttribute("role", admin.getRole());
            return "redirect:/dashboard";
        }

        return "redirect:/login.html";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
}