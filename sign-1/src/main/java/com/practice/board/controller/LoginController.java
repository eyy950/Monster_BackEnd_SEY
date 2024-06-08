package com.practice.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm() {
        // 로그인 페이지를 보여주는 로직 추가
        return "login";
    }
}