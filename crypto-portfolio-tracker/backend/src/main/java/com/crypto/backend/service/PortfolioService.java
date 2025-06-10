package com.crypto.backend.service;

import com.crypto.backend.entity.Portfolio;
import com.crypto.backend.entity.User;
import com.crypto.backend.repository.PortfolioRepository;
import com.crypto.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Portfolio> getPortfolio(UserDetails userDetails) {
        User user = userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        return portfolioRepo.findByUser(user);
    }

    public Portfolio addCoin(UserDetails userDetails, Portfolio portfolio) {
        User user = userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        portfolio.setUser(user);
        return portfolioRepo.save(portfolio);
    }

    public void deleteCoin(Long id, UserDetails userDetails) {
        Portfolio p = portfolioRepo.findById(id).orElseThrow();
        if (!p.getUser().getUsername().equals(userDetails.getUsername())) {
            throw new RuntimeException("Unauthorized");
        }
        portfolioRepo.deleteById(id);
    }
}
