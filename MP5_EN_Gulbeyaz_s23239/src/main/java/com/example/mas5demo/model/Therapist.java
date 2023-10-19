package com.example.mas5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Therapist extends Employee {

    @NotBlank
    private String specialisation;
    @ElementCollection
    @CollectionTable(name = "therapy_type", joinColumns = @JoinColumn(name = "therapist_id"))
    private Set<String> therapyType;

    @OneToMany(mappedBy = "therapist", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TherapySession> therapySessions;
}
