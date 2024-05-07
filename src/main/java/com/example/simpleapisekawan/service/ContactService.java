package com.example.simpleapisekawan.service;

import com.example.simpleapisekawan.entity.Contact;
import com.example.simpleapisekawan.model.SavedResponse;
import com.example.simpleapisekawan.model.contact.CreateContactRequest;
import com.example.simpleapisekawan.model.contact.UpdateContactRequest;
import com.example.simpleapisekawan.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public SavedResponse create(CreateContactRequest request) {
        Contact contact = new Contact();
        contact.setFirstName(request.getFirstName());
        contact.setMiddleName(request.getMiddleName());
        contact.setLastName(request.getLastName());
        contact.setAddress(request.getAddress());
        contact.setCity(request.getCity());
        contact.setProvince(request.getProvince());
        contact.setOccupation(request.getOccupation());
        contact.setLastEducation(request.getLastEducation());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());

        Contact lastSaved = contactRepository.save(contact);
        String fullName = lastSaved.getFirstName() + " " + lastSaved.getMiddleName() + " " + lastSaved.getLastName();

        return SavedResponse.builder().id(lastSaved.getId()).label(fullName).build();
    }

    public SavedResponse update(UpdateContactRequest request) {
        Contact contact = contactRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID is not found"));;
        contact.setFirstName(request.getFirstName());
        contact.setMiddleName(request.getMiddleName());
        contact.setLastName(request.getLastName());
        contact.setAddress(request.getAddress());
        contact.setCity(request.getCity());
        contact.setProvince(request.getProvince());
        contact.setOccupation(request.getOccupation());
        contact.setLastEducation(request.getLastEducation());
        contact.setPhone(request.getPhone());
        contact.setEmail(request.getEmail());

        Contact lastSaved = contactRepository.save(contact);
        String fullName = lastSaved.getFirstName() + " " + lastSaved.getMiddleName() + " " + lastSaved.getLastName();

        return SavedResponse.builder().id(lastSaved.getId()).label(fullName).build();
    }
}
