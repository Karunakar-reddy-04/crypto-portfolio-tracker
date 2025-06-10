package com.crypto.backend.service;

import com.crypto.backend.entity.Portfolio;
import com.crypto.backend.entity.User;
import com.crypto.backend.repository.PortfolioRepository;
import com.crypto.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Service
public class AiService {

    @Autowired
    private PortfolioRepository portfolioRepo;

    @Autowired
    private UserRepository userRepo;

    public String generateInsight(UserDetails userDetails) {
        User user = userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        List<Portfolio> portfolio = portfolioRepo.findByUser(user);

        // For now: mock AI message
        if (portfolio.isEmpty()) return "You have no assets yet. Consider diversifying into top coins like BTC or ETH.";

        StringBuilder response = new StringBuilder("AI Suggestion: ");
        for (Portfolio p : portfolio) {
            if (p.getCoinSymbol().equalsIgnoreCase("BTC")) {
                response.append("You're holding BTC — solid choice. ");
            }
            if (p.getQuantity() > 10) {
                response.append("Consider reducing your exposure to ").append(p.getCoinName()).append(". ");
            }
        }
        return response.toString();
    }
}
