![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)<br>
# Simdex – SIMulated DEXchange (Spring Boot Backend)

**Simdex** is a simulation platform for decentralized crypto exchange logic, built with Spring Boot. It features secure user registration/login, crypto price tracking via CoinMarketCap, and basic portfolio management. Designed as an educational and prototyping project for fullstack blockchain enthusiasts.

> 🧪 This backend powers the [Simdex Frontend](https://github.com/sbrunomello/simdex-web)

---

## 💡 Key Features

- ✅ **User Registration & Login** with Spring Security
- 🔑 **JWT Authentication** with token-based sessions
- 📈 **Live Crypto Price Tracking** using CoinMarketCap API
- 💼 **User Portfolio Structure** for holding simulated assets
- 📦 Modular architecture with clean domain separation
- 🧪 Ready for REST API testing (Postman/Insomnia)

---

## 🔐 Auth System

- `/auth/register` → creates a new user  
- `/auth/login` → returns JWT token  
- Role system via `ERole.ROLE_ADMIN`, extendable

Spring Security is fully configured with:

- AuthenticationManager
- BCrypt password encoding
- TokenService for JWT generation

---

## 📊 Crypto Price Endpoint

- `/api/v2/price` → Returns real-time BTC price from CoinMarketCap API
- Uses native Java 11+ `HttpClient` and `javax.json` to parse the response
- Requires a valid API key from CMC in the controller

```java
JsonObject cryptoData = jsonObject.getJsonObject("data").getJsonObject("BTC");
JsonNumber price = cryptoData.getJsonObject("quote").getJsonObject("USD").getJsonNumber("price");
```

---

## 📂 Project Structure

```
/controllers
    AuthController.java          → login/register endpoints
    CMCIntegrationController.java → price data from CoinMarketCap
    SimdexController.java        → basic health/test routes

/domain
    user/                        → user, roles, DTOs
    crypto/                      → (holdings, portfolio – WIP)

/repositories
    UserRepository.java

/security
    SecurityConfig.java
    TokenService.java

/resources
    application.properties

pom.xml
```

---

## ▶️ How to Run

### Prerequisites

- Java 17+
- Maven
- PostgreSQL (or H2 for dev)
- CoinMarketCap API Key (free plan works)

### Steps

```bash
git clone https://github.com/sbrunomello/simdex.git
cd simdex
mvn spring-boot:run
```

Backend will run on:  
`http://localhost:8080`

---

## 🧪 Example Requests

### Register

```http
POST /auth/register
{
  "username": "mello",
  "password": "123456",
  "email": "mello@example.com",
  "firstName": "Bruno",
  "lastName": "Mello"
}
```

### Get BTC Price

```http
GET /api/v2/price
→ name: Bitcoin | price: 69234.56
```

---

## 🧩 Frontend

Simdex is designed to work with:  
👉 [`simdex-web`](https://github.com/sbrunomello/simdex-web) – Angular app for user interface, wallet, and order management

---

## 🚀 Roadmap

- [ ] Add real-time price updates via WebSocket
- [ ] User portfolio API (add/remove simulated assets)
- [ ] Simulated buy/sell logic
- [ ] Historical chart tracking (via CMC)
- [ ] Admin dashboard

---

## 📬 Contact

- [GitHub](https://github.com/sbrunomello)  
Built with ⚙️ by Mello
