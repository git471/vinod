package com.example.demo.repository;

import com.example.demo.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,Integer> {
    @Query(
            value = "SELECT * FROM Tasks u WHERE u.status = 0 order by priority ASC",
            nativeQuery = true)
    List<Tasks> getTasksByproprity();
}
