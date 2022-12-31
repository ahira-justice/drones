package com.ahirajustice.drones.modules.payload.services;

import com.ahirajustice.drones.common.entities.Payload;
import com.ahirajustice.drones.modules.payload.viewmodels.PayloadViewModel;

public interface PayloadConverterService {

    PayloadViewModel convertToViewModel(Payload payload);

}
