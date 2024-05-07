package com.example.simpleapisekawan.controller;

import com.example.simpleapisekawan.entity.Contact;
import com.example.simpleapisekawan.entity.User;
import com.example.simpleapisekawan.model.SavedResponse;
import com.example.simpleapisekawan.model.WebResponse;
import com.example.simpleapisekawan.model.contact.CreateContactRequest;
import com.example.simpleapisekawan.model.contact.UpdateContactRequest;
import com.example.simpleapisekawan.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(
            path = "/api/contacts"
    )
    public WebResponse<List<Contact>> list(User user) {
        List<Contact> contacts = contactService.list();

        return WebResponse.<List<Contact>>builder().data(contacts).build();
    }

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SavedResponse> create(User user, @RequestBody CreateContactRequest request) {
        SavedResponse savedResponse = contactService.create(request);

        return WebResponse.<SavedResponse>builder().data(savedResponse).build();
    }

    @PutMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<SavedResponse> update(User user, @RequestBody UpdateContactRequest request) {
        SavedResponse savedResponse = contactService.update(request);

        return WebResponse.<SavedResponse>builder().data(savedResponse).build();
    }

    @DeleteMapping(
            path = "/api/contacts/{contactId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(User user, @PathVariable("contactId") Integer contactId) {
        contactService.delete(contactId);

        return WebResponse.<String>builder().data("OK").build();
    }

}
