package com.crypto.backend.controller;

import com.crypto.backend.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    @Autowired
    private AiService aiService;

    @GetMapping("/insight")
    public String getInsight(@AuthenticationPrincipal UserDetails user) {
        return aiService.generateInsight(user);
    }
}
