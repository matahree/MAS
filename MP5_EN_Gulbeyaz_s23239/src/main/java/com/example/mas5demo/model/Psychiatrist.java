package com.example.mas5demo.model;


import jakarta.persistence.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Psychiatrist extends Employee {

    @NotBlank(message = "Certificate  is mandatory!" )
    @Size(min = 2, max = 255)
    private String certificate;
}
