package com.ahirajustice.drones.common.entities;

import com.ahirajustice.drones.common.enums.DroneState;
import com.ahirajustice.drones.common.enums.DroneModel;
import com.ahirajustice.drones.common.enums.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "drones")
public class Drone extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    private String serialNumber;

    @Column(nullable = false)
    private DroneModel model;

    @Column(nullable = false)
    private int weightLimit;

    @Column(nullable = false)
    private WeightUnit weightLimitUnit;

    @Column(nullable = false)
    private int batteryPercentage;

    @Column(nullable = false)
    private DroneState state;

}
