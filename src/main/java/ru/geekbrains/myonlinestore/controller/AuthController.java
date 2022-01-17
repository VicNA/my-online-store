package ru.geekbrains.myonlinestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    public String showAuthPage() {
        return "auth";
    }
}
