package com.ahirajustice.drones.modules.payload.services.impl;

import com.ahirajustice.drones.common.constants.CharacterConstants;
import com.ahirajustice.drones.common.entities.File;
import com.ahirajustice.drones.common.entities.Payload;
import com.ahirajustice.drones.common.exceptions.ValidationException;
import com.ahirajustice.drones.common.repositories.PayloadRepository;
import com.ahirajustice.drones.common.utils.CommonUtils;
import com.ahirajustice.drones.modules.file.services.FileService;
import com.ahirajustice.drones.modules.payload.requests.CreatePayloadRequest;
import com.ahirajustice.drones.modules.payload.services.PayloadConverterService;
import com.ahirajustice.drones.modules.payload.services.PayloadService;
import com.ahirajustice.drones.modules.payload.viewmodels.PayloadViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayloadServiceImpl implements PayloadService {

    private final PayloadRepository payloadRepository;
    private final PayloadConverterService payloadConverterService;
    private final FileService fileService;

    @Override
    public PayloadViewModel createPayload(CreatePayloadRequest request) {
        validatePayloadName(request.getName());
        validatePayloadCode(request.getCode());
        File image = fileService.validateFileReference(request.getImageReference());

        Payload payload = createPayload(request, image);
        return payloadConverterService.convertToViewModel(payload);
    }

    private void validatePayloadName(String name) {
        if (CommonUtils.containsCharacters(name, CharacterConstants.specialCharacters))
            throw new ValidationException("name contains invalid characters. Only letters, numbers, '-', '_' allowed");

        if (payloadRepository.existsByName(name))
            throw new ValidationException(String.format("Payload with name: %s already exists", name));
    }

    private void validatePayloadCode(String code) {
        if (CommonUtils.containsCharacters(code, CharacterConstants.specialCharactersLowercaseAndDash))
            throw new ValidationException("code contains invalid characters. Only upper case letters, underscore and numbers allowed");

        if (payloadRepository.existsByCode(code))
            throw new ValidationException(String.format("Payload with code: %s already exists", code));
    }

    private Payload createPayload(CreatePayloadRequest request, File image) {
        Payload payload = Payload.builder()
                .name(request.getName())
                .weight(request.getWeight())
                .weightUnit(request.getWeightUnit())
                .code(request.getCode())
                .payloadType(request.getPayloadType())
                .image(image)
                .build();

        return payloadRepository.save(payload);
    }

}
