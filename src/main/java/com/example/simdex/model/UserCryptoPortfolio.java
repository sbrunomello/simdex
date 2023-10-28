package com.example.simdex.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "user_crypto_portfolio")
public class UserCryptoPortfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cryptoPortfolio", cascade = CascadeType.ALL)
    private List<CryptoCurrencyHoldings> holdings;
}

