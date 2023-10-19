package com.example.mas5demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.mas5demo.model.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
class BranchRepositoryTest {

    @Autowired
    private BranchRepository branchRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Branch branch_1;

    @BeforeEach
    public void init() {
        branch_1 = Branch.builder()
                .name("Branch1")
                .address("Warsaw")
                .facilities("Meeting rooms")
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(branchRepository);
    }

    @Test
    public void testFetchLabels() {
        Iterable<Branch> all = branchRepository.findAll();
        for (Branch d : all) {
            System.out.println(d);
        }
    }

    @Test
    public void testSaveLabel() {
        branchRepository.save(branch_1);
        entityManager.flush();
        long count = branchRepository.count();
        assertEquals(3, count);
    }


    @Test
    public void testFindByName() {
        List<Branch> branch = branchRepository.findByName("branch");
        System.out.println(branch);
        assertEquals(0, branch.size());
    }

    @Test
    public void testFindByFacilities() {
        List<Branch> branches = branchRepository.findByFacilities("Meeting rooms");
        System.out.println(branches);
        assertEquals(0, branches.size());
    }


}