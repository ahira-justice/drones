package com.ahirajustice.drones.common.models;

import com.ahirajustice.drones.common.enums.WeightUnit;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Weight {

    private int weight;
    private WeightUnit weightUnit;

}
