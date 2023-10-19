package com.example.mas5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First name is mandatory!" )
    @Size(min = 2, max = 255)
    private String firstName;

    @NotBlank(message = "Last name is mandatory!" )
    @Size(min = 2, max = 255)
    private String lastName;

    @NotBlank(message = "Address  is mandatory!" )
    @Size(min = 2, max = 255)
    private String address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TherapySession> sessions;

    @OneToMany(mappedBy = "history", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<MedicalHistory> histories = new HashSet<>();
}
