# Esquema do Banco de Dados do Simdex

Este arquivo fornece um resumo das tabelas e relacionamentos do banco de dados do projeto "Simdex".

## Tabela `users`

- Armazena informações dos usuários registrados na plataforma.
- Campos: `id`, `username`, `password`, `first_name`, `last_name`, `email`, `account_balance`.
- A coluna `id` é uma chave primária autoincremental.
- A coluna `username` é única e usada como identificador do usuário.
- A coluna `email` também é única e usada para identificação.

## Tabela `crypto_currencies`

- Armazena informações sobre as criptomoedas disponíveis.
- Campos: `id`, `symbol`, `name`.
- A coluna `id` é uma chave primária autoincremental.
- A coluna `symbol` contém o símbolo da criptomoeda (por exemplo, BTC).
- A coluna `name` contém o nome completo da criptomoeda (por exemplo, Bitcoin).

## Tabela `user_crypto_portfolio`

- Armazena informações do portfólio de criptomoedas dos usuários.
- Campos: `id`, `user_id`.
- A coluna `id` é uma chave primária autoincremental.
- A coluna `user_id` é uma chave estrangeira que se relaciona com a tabela `users`.

## Tabela `crypto_currency_holdings`

- Armazena informações das holdings (saldos) de criptomoedas dos usuários.
- Campos: `id`, `crypto_portfolio_id`, `currency_id`, `balance`.
- A coluna `id` é uma chave primária autoincremental.
- A coluna `crypto_portfolio_id` é uma chave estrangeira que se relaciona com a tabela `user_crypto_portfolio`.
- A coluna `currency_id` é uma chave estrangeira que se relaciona com a tabela `crypto_currencies`.
- A coluna `balance` armazena o saldo da criptomoeda no portfólio do usuário.
