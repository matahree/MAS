package com.example.mas5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory!")
    @Size(min = 2, max = 255)
    private String name;

    @NotBlank(message = "Address is mandatory!")
    @Size(min = 2, max = 255)
    private String address;

    @NotBlank(message = "Facilities is mandatory")
    @Size(min = 2, max = 255)
    private String facilities;


    @OneToMany(mappedBy = "signsTo", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees = new HashSet<>();
}
