package com.api.lores.dto;

import com.api.lores.entity.embedded.Person;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class DentistDto {

    @NotBlank
    @Size(max = 11)
    private String croNumber;

    @Valid
    Person person;

}