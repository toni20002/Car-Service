package com.carservice.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "repairment_type")
@Getter
@Setter
public class RepairmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ENGINE_REPAIRMENT, BRAKES_REPAIRMENT, REPLACE_CONSUMABLES, CHANGE_OIL;
    @Column(nullable = false, unique = true)
    private String typeOfRepairment;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "repairmentTypes")
    private Set<CarService> carServices;

    @OneToMany(mappedBy = "repairmentType", fetch = FetchType.LAZY)
    private List<Repairment> repairments;
}
