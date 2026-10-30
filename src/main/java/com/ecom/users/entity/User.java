package com.ecom.users.entity;

import com.ecom.users.enums.Role;
import com.ecom.users.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.id.IdentityGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="password_hash",nullable = false)
    private String passwordHash;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="phone_number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false)
    private Status status;
    @Column(name="created_time",nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_time",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address address;
}
