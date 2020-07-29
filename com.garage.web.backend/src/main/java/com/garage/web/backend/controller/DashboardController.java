package com.garage.web.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController extends AbstractController {

    @GetMapping("/")
    public String home(Model model) {
        return "dashboard/index";
    }
}
