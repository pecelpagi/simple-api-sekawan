package com.example.simpleapisekawan.model.contact;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateContactRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private String address;

    private String city;

    private String province;

    private String occupation;

    private String lastEducation;

    private String phone;

    private String email;

}
