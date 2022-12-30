package com.ahirajustice.drones.modules.drone.viewmodels;

import com.ahirajustice.drones.common.enums.DroneModel;
import com.ahirajustice.drones.common.enums.DroneState;
import com.ahirajustice.drones.common.enums.WeightUnit;
import com.ahirajustice.drones.common.viewmodels.BaseViewModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneViewModel extends BaseViewModel {

    private String serialNumber;
    private DroneModel model;
    private int weightLimit;
    private WeightUnit weightLimitUnit;
    private int batteryPercentage;
    private DroneState state;

}
