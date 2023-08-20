package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Employee_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
    List<Employee> findEmployeeByStatus(Employee_Status status);
    @Query(
            value = "SELECT * FROM Employee e WHERE e.status = 0 ORDER BY performance ASC",
            nativeQuery = true)
    List<Employee> findFreeEmployee();

}
