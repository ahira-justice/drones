package com.ahirajustice.drones.modules.drone.services;

import com.ahirajustice.drones.common.entities.Drone;
import com.ahirajustice.drones.modules.drone.viewmodels.DroneViewModel;

public interface DroneConverterService {

    DroneViewModel convertToViewModel(Drone drone);

}
