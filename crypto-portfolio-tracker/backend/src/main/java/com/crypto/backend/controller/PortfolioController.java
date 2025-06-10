package com.crypto.backend.controller;

import com.crypto.backend.entity.Portfolio;
import com.crypto.backend.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public List<Portfolio> getMyPortfolio(@AuthenticationPrincipal UserDetails user) {
        return portfolioService.getPortfolio(user);
    }

    @PostMapping
    public Portfolio addCoin(@AuthenticationPrincipal UserDetails user,
                             @RequestBody Portfolio coin) {
        return portfolioService.addCoin(user, coin);
    }

    @DeleteMapping("/{id}")
    public void deleteCoin(@PathVariable Long id,
                           @AuthenticationPrincipal UserDetails user) {
        portfolioService.deleteCoin(id, user);
    }
}
