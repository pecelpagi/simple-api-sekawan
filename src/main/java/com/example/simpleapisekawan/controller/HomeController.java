package com.example.simpleapisekawan.controller;

import com.example.simpleapisekawan.model.WebResponse;
import com.example.simpleapisekawan.service.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HomeController {

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @GetMapping(
            path = "/"
    )
    public WebResponse<String> index() {
        return WebResponse.<String>builder().data("This API is only for technical testing purposes at Sekawan Media").build();
    }

}
