package com.zerolatency.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zerolatency.backend.dto.authResponse;
import com.zerolatency.backend.dto.loginRequest;
import com.zerolatency.backend.dto.usernameRequest;
import com.zerolatency.backend.model.Users;
import com.zerolatency.backend.service.usersService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class usersController {
    @Autowired
    private usersService userService;

    @GetMapping
    public Users findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public Users findByUsernameFromBody(@RequestBody usernameRequest user) {
        return userService.findByUsername(user.getUsername());
    }

    @GetMapping("/dashboard")
    public List<Users> getDashboard() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody loginRequest request) {
        Users user = userService.login(request.getUsername(), request.getPassword());
        if (user != null) {
            // Generate a simple token (in production, use JWT)
            String token = UUID.randomUUID().toString();
            authResponse response = new authResponse(token, user);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
