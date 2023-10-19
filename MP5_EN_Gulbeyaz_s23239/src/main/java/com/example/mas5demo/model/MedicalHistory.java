package com.example.mas5demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne(optional = false)  // we can not have it without other class that's why false
    @JoinColumn(name = "history_id", nullable = false, updatable = false)   // can not update it
    private Patient history;

    @NotBlank(message = "Notes is mandatory!" )
    @Size(min = 2, max = 255)
    private String notes;

    @NotBlank(message = "Allergies is mandatory!" )
    @Size(min = 2, max = 255)
    private String allergies;

    @NotBlank(message = "Chronic condition is mandatory!" )
    @Size(min = 2, max = 255)
    private String chronicConditions;

}
