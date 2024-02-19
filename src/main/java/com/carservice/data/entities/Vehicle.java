package com.carservice.data.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;
    @Column(nullable = false, unique = true)
    private String licensePlateNumber;
    @Column(nullable = false)
    private String vehicleBrand;
    @Column(nullable = false)
    private String vehicleModel;
    @Column(nullable = false)
    private Year yearOfManufacture;
    @Column(nullable = false)
    private LocalDateTime selectedTimeForRepair;
    @ManyToOne
    private User owner;
    @ManyToOne
    private User employee;

    //! A vehicle could have many repairments but may be registered only once
    @OneToMany(mappedBy = "vehicle")
    private List<Repairment> repairments;
}
