package com.example.simdex.domain.crypto;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "crypto_currency_holdings")
public class CryptoCurrencyHoldings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crypto_portfolio_id")
    private UserCryptoPortfolio cryptoPortfolio;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private CryptoCurrency currency;

    @Column(nullable = false)
    private double balance;

    public CryptoCurrencyHoldings() {
        // Construtor vazio
    }

    public CryptoCurrencyHoldings(UserCryptoPortfolio cryptoPortfolio, CryptoCurrency currency, double balance) {
        this.cryptoPortfolio = cryptoPortfolio;
        this.currency = currency;
        this.balance = balance;
    }

}

