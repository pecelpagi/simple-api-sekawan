package com.example.simpleapisekawan.model.contact;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateContactRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String province;

    @NotBlank
    private String occupation;

    @NotBlank
    private String lastEducation;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    private MultipartFile image;

    private MultipartFile video;

    private MultipartFile document;
}
