package com.ecom.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="addresses")
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "recipient_name", nullable = false)
    private String recipientName;
    @Column(name="line1", nullable = false)
    private String line1;
    @Column(name="line2")
    private String line2;
    @Column(name="city", nullable = false)
    private String city;
    @Column(name="state_or_province", nullable = false)
    private String stateOrProvince;
    @Column(name="postal_code", nullable = false)
    private String postalCode;
    @Column(name="country",nullable = false)
    private String country;
    @Column(name="created_time",nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name="updated_time",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToOne(mappedBy = "address")
    User user;

}
