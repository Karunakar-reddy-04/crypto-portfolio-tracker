package com.crypto.backend.repository;

import com.crypto.backend.entity.Portfolio;
import com.crypto.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByUser(User user);
}
