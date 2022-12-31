package com.ahirajustice.drones.modules.payload.requests;

import com.ahirajustice.drones.common.enums.PayloadType;
import com.ahirajustice.drones.common.enums.WeightUnit;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreatePayloadRequest {

    @NotBlank
    private String name;
    @Min(1)
    private int weight;
    private WeightUnit weightUnit;
    @NotBlank
    private String code;
    private PayloadType payloadType;
    @NotBlank
    private String imageReference;

}
