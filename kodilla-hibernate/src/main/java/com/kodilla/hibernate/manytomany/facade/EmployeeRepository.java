package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query (
            value = "SELECT * FROM EMPLOYEES WHERE LASTNAME LIKE :query",
            nativeQuery = true
    )
    List<Employee> findByLastname(@Param("query") String query);
}
