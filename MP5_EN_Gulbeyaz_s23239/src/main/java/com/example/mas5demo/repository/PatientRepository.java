package com.example.mas5demo.repository;


import com.example.mas5demo.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}