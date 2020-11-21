package com.example.universityapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;

    private Degree (String role) {
        this.role = Role.valueOf(role.toUpperCase());
    }

    public static Degree of(String role) {
        return new Degree(role);
    }
}
