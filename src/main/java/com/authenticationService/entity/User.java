package com.authenticationService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
