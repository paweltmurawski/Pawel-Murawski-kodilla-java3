
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
    public void testFindCompany() throws QueryResultException {
        //When
        List<Company> result = queryFacade.findCompany("b");
        //Then
        assertEquals("abc", result.get(0).getName());
    }

    @Test
    public void testFindByLastname() throws QueryResultException {
        //When
        List<Employee> result = queryFacade.findByLastname("o");
        //Then
        assertEquals("Kovalsky", result.get(0).getLastname());
    }
}

