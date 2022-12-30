package com.ahirajustice.drones.modules.drone.requests;

import com.ahirajustice.drones.common.enums.DroneModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterDroneRequest {

    @NotBlank
    @Size(max = 200)
    private String serialNumber;
    private DroneModel model;

}
