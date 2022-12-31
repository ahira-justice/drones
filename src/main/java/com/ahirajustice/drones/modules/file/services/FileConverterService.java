package com.ahirajustice.drones.modules.file.services;

import com.ahirajustice.drones.common.entities.File;
import com.ahirajustice.drones.modules.file.viewmodels.FileViewModel;

public interface FileConverterService {

    FileViewModel convertToViewModel(File file);

}
