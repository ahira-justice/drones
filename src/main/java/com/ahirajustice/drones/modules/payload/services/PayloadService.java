package com.ahirajustice.drones.modules.payload.services;

import com.ahirajustice.drones.modules.payload.requests.CreatePayloadRequest;
import com.ahirajustice.drones.modules.payload.viewmodels.PayloadViewModel;

public interface PayloadService {

    PayloadViewModel createPayload(CreatePayloadRequest request);

}
