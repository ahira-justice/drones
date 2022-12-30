package com.ahirajustice.drones.modules.drone.services.impl;

import com.ahirajustice.drones.common.entities.Drone;
import com.ahirajustice.drones.modules.drone.services.DroneConverterService;
import com.ahirajustice.drones.modules.drone.viewmodels.DroneViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DroneConverterServiceImpl implements DroneConverterService {

    @Override
    public DroneViewModel convertToViewModel(Drone drone) {
        DroneViewModel response = new DroneViewModel();

        BeanUtils.copyProperties(drone, response);

        return response;
    }
}
