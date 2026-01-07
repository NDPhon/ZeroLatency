package com.zerolatency.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String password;

    private String role;
    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
}
