package com.carservice.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    @Column(unique = true, nullable = false)
    private String authority;
    @OneToMany(mappedBy = "role_id", fetch = FetchType.LAZY)
    private Set<User> users;
}
