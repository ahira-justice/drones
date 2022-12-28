package com.ahirajustice.drones.common.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AppProperties {

    @Value("${app.config.max-drones-in-fleet}")
    private int maxDronesInFleet;

}
