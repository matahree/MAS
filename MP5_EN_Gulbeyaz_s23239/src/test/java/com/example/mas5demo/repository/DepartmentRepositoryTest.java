//package com.example.mas5demo.repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class DepartmentRepositoryTest {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    Department d1;
//
//    @BeforeEach
//    public void initData(){
//    d1 = Department.builder()
//            .name("Dept 3")
//            .location("Loc 3")
//            .budget(100000)
//            .build();
//    }
//    @Test
//    public void testRequiredDependencies(){
//        assertNotNull(departmentRepository);
//    }
//    @Test
//    public void testFetchDepartments(){
//       Iterable<Department> all = departmentRepository.findAll();
//       for(Department d : all){
//           System.out.println(d);
//       }
//    }
//
//    @Test
//    public void testSaveDepartment(){
//        departmentRepository.save(d1);
//        entityManager.flush();
//        long count = departmentRepository.count();
//        assertEquals(3,count);
//    }
//}
