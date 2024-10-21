package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    public enum Role{
        ADMIN, USER
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Column(unique = true)
    private Long passport;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Card> cards;
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;
}