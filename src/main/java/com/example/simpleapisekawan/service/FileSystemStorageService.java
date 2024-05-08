package com.example.simpleapisekawan.service;

import com.example.simpleapisekawan.enums.FileUploadType;
import com.example.simpleapisekawan.storage.StorageProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@Service
public class FileSystemStorageService {

    private final Path rootLocation;

    public FileSystemStorageService(StorageProperties properties) {
        if(properties.getLocation().trim().length() == 0){
            throw new RuntimeException("File upload location can not be Empty.");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    public void store(MultipartFile file, FileUploadType fileUploadType) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }

            var contentType = file.getContentType();

            String[] supportedImages = { "image/png", "image/jpeg", "image/gif" };
            String[] supportedVideos = { "video/mp4", "video/x-msvideo" };
            String[] supportedDocuments = { "application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document" };

            if (fileUploadType.equals(FileUploadType.IMAGE) && !Arrays.asList(supportedImages).contains(contentType)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Images supported are: .png, .jpg, .jpeg, .gif");
            } else if (fileUploadType.equals(FileUploadType.VIDEO) && !Arrays.asList(supportedVideos).contains(contentType)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Videos supported are: .mp4, .avi");
            } else if (fileUploadType.equals(FileUploadType.DOCUMENT) && !Arrays.asList(supportedDocuments).contains(contentType)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Document supported are: .pdf, .doc, .docx");
            }

            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new RuntimeException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

}
