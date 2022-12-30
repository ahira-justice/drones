package com.ahirajustice.drones.modules.drone.services.impl;

import com.ahirajustice.drones.common.enums.DroneModel;
import com.ahirajustice.drones.common.models.Weight;
import com.ahirajustice.drones.common.properties.AppProperties;
import com.ahirajustice.drones.modules.drone.services.DroneMaxWeightResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MiddleweightDroneMaxWeightResolverImpl implements DroneMaxWeightResolver {

    private final AppProperties appProperties;

    @Override
    public boolean canResolve(DroneModel droneModel) {
        return DroneModel.MIDDLEWEIGHT.equals(droneModel);
    }

    @Override
    public Weight resolve() {
        return Weight.builder()
                .weight(appProperties.getMiddleweightDroneMaxWeight())
                .weightUnit(appProperties.getMiddleweightDroneMaxWeightUnit())
                .build();
    }

}
