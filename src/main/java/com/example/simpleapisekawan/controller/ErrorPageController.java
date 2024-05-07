package com.example.simpleapisekawan.controller;

import com.example.simpleapisekawan.model.WebResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public WebResponse<String> error(HttpServletRequest request) {
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        return WebResponse.<String>builder().errors(message).build();
    }

}
