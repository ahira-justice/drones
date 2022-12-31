package com.ahirajustice.drones.modules.file.controllers;

import com.ahirajustice.drones.modules.file.services.FileService;
import com.ahirajustice.drones.modules.file.viewmodels.FileViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public FileViewModel uploadFile(@RequestParam("file") MultipartFile fileUpload) {
        return fileService.uploadFile(fileUpload);
    }

}
