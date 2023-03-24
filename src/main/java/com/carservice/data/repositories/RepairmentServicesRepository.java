package com.carservice.data.repositories;

import com.carservice.data.entities.RepairmentServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairmentServicesRepository extends JpaRepository<RepairmentServices, Long> {

    @Override
    List<RepairmentServices> findAll();
}
