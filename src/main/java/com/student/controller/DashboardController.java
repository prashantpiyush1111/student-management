package com.student.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login.html";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login.html";
        }
        return "forward:/dashboard.html";
    }

    @GetMapping("/getRole")
    @ResponseBody
    public String getRole(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "USER";
        }

        return authentication.getAuthorities().stream()
                .findFirst()
                .map(authority -> authority.getAuthority().replace("ROLE_", ""))
                .orElse("USER");
    }

    @GetMapping("/csrf")
    @ResponseBody
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
