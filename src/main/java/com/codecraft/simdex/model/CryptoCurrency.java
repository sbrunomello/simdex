package com.codecraft.simdex.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "crypto_currencies")
public class CryptoCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String symbol; // Símbolo da criptomoeda (por exemplo, BTC)

    @Column(nullable = false)
    private String name; // Nome da criptomoeda (por exemplo, Bitcoin)

    public CryptoCurrency() {
        // Construtor vazio
    }

    public CryptoCurrency(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
}

