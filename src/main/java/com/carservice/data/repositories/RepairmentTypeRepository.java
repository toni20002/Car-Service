package com.carservice.data.repositories;

import com.carservice.data.entities.RepairmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairmentTypeRepository extends JpaRepository<RepairmentType, Long> {
    RepairmentType findRepairmentTypeByTypeOfRepairment(String typeOfRepairment);
    @Override
    List<RepairmentType> findAll();
}
