package com.ahirajustice.drones.modules.file.services;

import com.ahirajustice.drones.modules.file.viewmodels.FileViewModel;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    FileViewModel uploadFile(MultipartFile fileUpload);

}
