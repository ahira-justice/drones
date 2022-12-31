package com.ahirajustice.drones.modules.payload.services.impl;

import com.ahirajustice.drones.common.entities.Payload;
import com.ahirajustice.drones.modules.file.services.FileConverterService;
import com.ahirajustice.drones.modules.payload.services.PayloadConverterService;
import com.ahirajustice.drones.modules.payload.viewmodels.PayloadViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayloadConverterServiceImpl implements PayloadConverterService {

    private final FileConverterService fileConverterService;

    @Override
    public PayloadViewModel convertToViewModel(Payload payload) {
        PayloadViewModel response = new PayloadViewModel();

        BeanUtils.copyProperties(payload, response);
        response.setImage(fileConverterService.convertToViewModel(payload.getImage()));

        return response;
    }

}
