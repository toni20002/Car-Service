package com.carservice.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "repairment_services")
@Getter
@Setter
public class RepairmentServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ENGINE_REPAIRMENT, BRAKES_REPAIRMENT, REPLACE_CONSUMABLES, CHANGE_OIL;
    @Column(nullable = false, unique = true)
    private String typeOfRepairment;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "repairmentServices")
    private Set<CarService> carServices;
}
