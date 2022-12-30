package com.ahirajustice.drones.common.properties;

import com.ahirajustice.drones.common.enums.WeightUnit;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AppProperties {

    @Value("${app.config.max-drones-in-fleet}")
    private int maxDronesInFleet;

    @Value("${app.config.lightweight-drone-max-weight}")
    private int lightweightDroneMaxWeight;

    @Value("${app.config.lightweight-drone-max-weight-unit}")
    private WeightUnit lightweightDroneMaxWeightUnit;

    @Value("${app.config.middleweight-drone-max-weight}")
    private int middleweightDroneMaxWeight;

    @Value("${app.config.middleweight-drone-max-weight-unit}")
    private WeightUnit middleweightDroneMaxWeightUnit;

    @Value("${app.config.cruiserweight-drone-max-weight}")
    private int cruiserweightDroneMaxWeight;

    @Value("${app.config.cruiserweight-drone-max-weight-unit}")
    private WeightUnit cruiserweightDroneMaxWeightUnit;

    @Value("${app.config.heavyweight-drone-max-weight}")
    private int heavyweightDroneMaxWeight;

    @Value("${app.config.heavyweight-drone-max-weight-unit}")
    private WeightUnit heavyweightDroneMaxWeightUnit;

}
