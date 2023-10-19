package com.example.mas5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @NotBlank(message = "First and last names are mandatory")
    @NotNull
    @Size(min = 2, max = 255)
    protected String firstName, lastName;

    @Min(0)
    protected double salary;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Branch signsTo;
}