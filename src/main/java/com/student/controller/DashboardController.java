package com.student.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {
	
    @GetMapping("/")
    public String root() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() ||
            auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/login.html";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            return "redirect:/login.html";
        }
        return "forward:/dashboard.html";
    }

    @GetMapping("/getRole")
    @ResponseBody
    public String getRole() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities() != null) {
            return auth.getAuthorities().stream()
                    .findFirst()
                    .map(a -> a.getAuthority().replace("ROLE_", ""))
                    .orElse("USER");
        }
        return "USER";
    }
}