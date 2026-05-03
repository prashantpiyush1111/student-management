package com.student.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {

        if(session.getAttribute("admin") == null) {
            return "redirect:/login.html";
        }

        return "forward:/dashboard.html";
    }

    @GetMapping("/getRole")
    @ResponseBody
    public String getRole(HttpSession session) {
        return (String) session.getAttribute("role");
    }
}