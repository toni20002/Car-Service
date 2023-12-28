package com.carservice.web.model;

import com.carservice.data.entities.CarService;
import com.carservice.data.entities.RepairmentType;
import com.carservice.data.entities.User;
import lombok.Data;

import java.time.Year;
import java.util.List;

@Data
public class MyVehiclesModel {

    private Long vehicle_id;
    private String licensePlateNumber;
    private String vehicleBrand;
    private String vehicleModel;
    private Year yearOfManufacture;
    private User owner;
    private List<RepairmentType> repairmentServices;
    private RepairmentType selectedRepairmentType;
    private CarService selectedCarService;
}
