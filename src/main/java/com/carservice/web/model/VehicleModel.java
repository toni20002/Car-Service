package com.carservice.web.model;

import com.carservice.data.entities.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.Year;

@Data
public class VehicleModel {
    private Long vehicle_id;
    @Pattern(regexp = "[A-Z]{1,2}[0-9]*[A-Z]{2}",
            message = "Your license plate input doesn't match the standard!")
    private String licensePlateNumber;
    @NotEmpty(message = "Vehicle Brand cannot be empty!")
    private String vehicleBrand;
    @NotEmpty(message = "Vehicle Model cannot be empty!")
    private String vehicleModel;
    private Year yearOfManufacture;
    private User owner;
}
