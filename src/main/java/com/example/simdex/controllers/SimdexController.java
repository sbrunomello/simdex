package com.example.simdex.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SimdexController {

    @GetMapping("/teste")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("ok");
    }
}
