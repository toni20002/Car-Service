package com.carservice.web.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AssignWorkerModel implements Serializable {
    private Long vehicleId;
    private Long employeeId;
}
