package com.testvaadin.crowd.repo;

import com.testvaadin.crowd.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query("from Employee e " +
    "where concat(e.lastname, ' ', e.lastname, ' ', e.patronymic ) " +
    " like concat('%', :name, '%') ")
    List<Employee> findByName(@Param("name") String name);
}
