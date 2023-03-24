package com.carservice.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "car_service")
@Getter
@Setter
public class CarService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String location;
    private String dedicatedBrand;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "car_service_repairment_services",
            joinColumns = @JoinColumn(name = "carServices_id"),
            inverseJoinColumns = @JoinColumn(name = "repairmentServices_id")
    )
    private Set<RepairmentServices> repairmentServices;
}
