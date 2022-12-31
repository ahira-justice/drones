package com.ahirajustice.drones.modules.payload.viewmodels;

import com.ahirajustice.drones.common.enums.PayloadType;
import com.ahirajustice.drones.common.enums.WeightUnit;
import com.ahirajustice.drones.common.viewmodels.BaseViewModel;
import com.ahirajustice.drones.modules.file.viewmodels.FileViewModel;
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
public class PayloadViewModel extends BaseViewModel {

    private String name;
    private int weight;
    private WeightUnit weightUnit;
    private String code;
    private PayloadType payloadType;
    private FileViewModel image;

}
