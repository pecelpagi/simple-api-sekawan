package com.example.simpleapisekawan.controller;

import com.example.simpleapisekawan.model.SavedResponse;
import com.example.simpleapisekawan.model.WebResponse;
import com.example.simpleapisekawan.model.contact.CreateContactRequest;
import com.example.simpleapisekawan.model.contact.UpdateContactRequest;
import com.example.simpleapisekawan.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SavedResponse> create(@RequestBody CreateContactRequest request) {
        SavedResponse savedResponse = contactService.create(request);

        return WebResponse.<SavedResponse>builder().data(savedResponse).build();
    }

    @PutMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SavedResponse> update(@RequestBody UpdateContactRequest request) {
        SavedResponse savedResponse = contactService.update(request);

        return WebResponse.<SavedResponse>builder().data(savedResponse).build();
    }

    @DeleteMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(@PathVariable("contactId") Integer contactId) {
        contactService.delete(contactId);

        return WebResponse.<String>builder().data("OK").build();
    }

}
