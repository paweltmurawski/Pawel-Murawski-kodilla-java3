package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryFacadeTest {
    @Autowired
    private QueryFacade queryFacade;

    @Test
    public void testFindCompany() {
        //When
        List<Company> result = queryFacade.findCompany("a");
        //Then
        try {
            assertEquals("abc", result.get(0).getName());
        } catch (QueryResultException e) {
           //business logic
        }
    }


    @Test
    public void testFindByLastname() {
        //When
        List<Employee> result = queryFacade.findByLastname("o");
        //Then
            try {
                assertEquals("Kovalsky", result.get(0).getLastname());
            } finally {
                //businness logic
            }
        }
    }

}
