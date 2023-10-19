package com.example.mas5demo.repository;

import com.example.mas5demo.model.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// second parameter represent type, we set the id as long that's why it's Long
public interface BranchRepository extends CrudRepository<Branch, Long> {

    public List<Branch> findByName(String name);
    public List<Branch> findByFacilities(String facilities);


    @Query("from Branch as l left join fetch l.employees where l.id = :id")
    public Optional<Branch> findById(@Param("id") Long id);

}