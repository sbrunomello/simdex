package com.example.simdex.domain.user;

public record RegisterDTO(String login, String password, String email, String firstName, String lastName) {
}
