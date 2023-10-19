package com.example.mas5demo;

import com.example.mas5demo.model.Branch;
import com.example.mas5demo.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final BranchRepository branchRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent event) {
        System.out.println("context refreshed");
        Iterable<Branch> all = branchRepository.findAll();
        System.out.println(all);
    }
}
