package com.ahirajustice.drones.modules.drone.services;

import com.ahirajustice.drones.modules.drone.requests.RegisterDroneRequest;
import com.ahirajustice.drones.modules.drone.viewmodels.DroneViewModel;

public interface DroneService {

    DroneViewModel registerDrone(RegisterDroneRequest request);

}
