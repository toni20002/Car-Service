package com.carservice.data.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;
    @Column(nullable = false, unique = true)
    private String licensePlateNumber;
    @Column(nullable = false, unique = true)
    private String vehicleBrand;
    @Column(nullable = false, unique = true)
    private String vehicleModel;
    @Column(nullable = false, unique = true)
    private Year yearOfManufacture;
    @ManyToOne
    private User owner;
}
