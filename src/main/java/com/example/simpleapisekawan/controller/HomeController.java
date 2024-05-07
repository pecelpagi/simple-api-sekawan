package com.example.simpleapisekawan.controller;

import com.example.simpleapisekawan.model.SavedResponse;
import com.example.simpleapisekawan.model.WebResponse;
import com.example.simpleapisekawan.model.contact.CreateContactRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(
            path = "/"
    )
    public WebResponse<String> index() {
        return WebResponse.<String>builder().data("This API is only for technical testing purposes at Sekawan Media").build();
    }

}
