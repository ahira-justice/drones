package com.ahirajustice.drones.modules.file.services.impl;

import com.ahirajustice.drones.common.entities.File;
import com.ahirajustice.drones.common.exceptions.ValidationException;
import com.ahirajustice.drones.common.repositories.FileRepository;
import com.ahirajustice.drones.modules.file.services.FileConverterService;
import com.ahirajustice.drones.modules.file.services.FileService;
import com.ahirajustice.drones.modules.file.viewmodels.FileViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final FileConverterService fileConverterService;

    @Override
    public FileViewModel uploadFile(MultipartFile fileUpload) {
        String reference = UUID.randomUUID().toString();
        String url = uploadFileToBucket(reference, fileUpload);
        File file = createFile(reference, url);

        return fileConverterService.convertToViewModel(file);
    }

    private String uploadFileToBucket(String reference, MultipartFile fileUpload) {
        //TODO: Upload file to object storage
        return "https://example.com/3060c25a-2f8a-4e7d-a25e-eb815e79076c";
    }

    private File createFile(String reference, String url) {
        File file = File.builder()
                .reference(reference)
                .url(url)
                .build();

        return fileRepository.save(file);
    }

    @Override
    public File validateFileReference(String reference) {
        File file = fileRepository.findByReference(reference).orElse(null);

        if (file == null)
            throw new ValidationException(String.format("File with reference: %s not found", reference));

        return file;
    }

}
