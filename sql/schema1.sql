-- Tabela para armazenar informações dos usuários
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    account_balance DECIMAL(10, 2) NOT NULL
);

-- Tabela para armazenar informações das criptomoedas
CREATE TABLE crypto_currencies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    symbol VARCHAR(10) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL
);

-- Tabela para armazenar informações do portfólio de criptomoedas dos usuários
CREATE TABLE user_crypto_portfolio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Tabela para armazenar informações das holdings (saldo) de criptomoedas dos usuários
CREATE TABLE crypto_currency_holdings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    crypto_portfolio_id INT NOT NULL,
    currency_id INT NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (crypto_portfolio_id) REFERENCES user_crypto_portfolio (id),
    FOREIGN KEY (currency_id) REFERENCES crypto_currencies (id)
);
