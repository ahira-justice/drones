package com.ahirajustice.drones.modules.drone.controllers;

import com.ahirajustice.drones.modules.drone.requests.RegisterDroneRequest;
import com.ahirajustice.drones.modules.drone.services.DroneService;
import com.ahirajustice.drones.modules.drone.viewmodels.DroneViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/drones")
@RequiredArgsConstructor
public class DroneController {

    private final DroneService droneService;


    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public DroneViewModel registerDrone(@Valid @RequestBody RegisterDroneRequest request) {
        return droneService.registerDrone(request);
    }

}
