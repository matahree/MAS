package com.example.mas5demo.repository;


import com.example.mas5demo.model.Psychiatrist;
import org.springframework.data.repository.CrudRepository;

public interface PsychiatristRepository extends CrudRepository<Psychiatrist, Long> {
}