package com.ahirajustice.drones.modules.drone.services;

import com.ahirajustice.drones.common.enums.DroneModel;
import com.ahirajustice.drones.common.models.Weight;

public interface DroneMaxWeightResolver {

    boolean canResolve(DroneModel droneModel);

    Weight resolve();

}
