package com.ahirajustice.drones.modules.drone.services.impl;

import com.ahirajustice.drones.common.entities.Drone;
import com.ahirajustice.drones.common.enums.DroneState;
import com.ahirajustice.drones.common.exceptions.BadRequestException;
import com.ahirajustice.drones.common.exceptions.ConfigurationException;
import com.ahirajustice.drones.common.models.Weight;
import com.ahirajustice.drones.common.properties.AppProperties;
import com.ahirajustice.drones.common.repositories.DroneRepository;
import com.ahirajustice.drones.modules.drone.requests.RegisterDroneRequest;
import com.ahirajustice.drones.modules.drone.services.DroneConverterService;
import com.ahirajustice.drones.modules.drone.services.DroneMaxWeightResolver;
import com.ahirajustice.drones.modules.drone.services.DroneService;
import com.ahirajustice.drones.modules.drone.viewmodels.DroneViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    private final DroneConverterService droneConverterService;
    private final List<DroneMaxWeightResolver> droneMaxWeightResolvers;
    private final AppProperties appProperties;

    @Override
    public DroneViewModel registerDrone(RegisterDroneRequest request) {
        validateMaxDroneCount();
        Drone drone = createDrone(request);

        return droneConverterService.convertToViewModel(drone);
    }

    private void validateMaxDroneCount() {
        if (droneRepository.count() >= appProperties.getMaxDronesInFleet())
            throw new BadRequestException("Cannot register drone. Maximum drone count exceeded");
    }

    private Drone createDrone(RegisterDroneRequest request) {
        Weight weight = getWeightLimit(request);

        return Drone.builder()
                .serialNumber(request.getSerialNumber())
                .model(request.getModel())
                .weightLimit(weight.getWeight())
                .weightLimitUnit(weight.getWeightUnit())
                .batteryPercentage(100)
                .state(DroneState.IDLE)
                .build();
    }

    private Weight getWeightLimit(RegisterDroneRequest request) {
        DroneMaxWeightResolver droneMaxWeightResolver = droneMaxWeightResolvers.stream()
                .filter(x -> x.canResolve(request.getModel()))
                .findFirst()
                .orElse(null);

        if (droneMaxWeightResolver == null)
            throw new ConfigurationException(String.format("DroneMaxWeightResolver not found for %s drone model", request.getModel()));

        return droneMaxWeightResolver.resolve();
    }

}
