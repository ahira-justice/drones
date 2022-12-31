package com.ahirajustice.drones.modules.payload.controllers;

import com.ahirajustice.drones.modules.payload.requests.CreatePayloadRequest;
import com.ahirajustice.drones.modules.payload.services.PayloadService;
import com.ahirajustice.drones.modules.payload.viewmodels.PayloadViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/payload")
@RequiredArgsConstructor
public class PayloadController {

    private final PayloadService payloadService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public PayloadViewModel createPayload(@Valid @RequestBody CreatePayloadRequest request) {
        return payloadService.createPayload(request);
    }

}
