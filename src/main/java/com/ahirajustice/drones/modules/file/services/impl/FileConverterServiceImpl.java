package com.ahirajustice.drones.modules.file.services.impl;

import com.ahirajustice.drones.common.entities.File;
import com.ahirajustice.drones.modules.file.services.FileConverterService;
import com.ahirajustice.drones.modules.file.viewmodels.FileViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileConverterServiceImpl implements FileConverterService {

    @Override
    public FileViewModel convertToViewModel(File file) {
        FileViewModel response = new FileViewModel();

        BeanUtils.copyProperties(file, response);

        return response;
    }

}
