package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dateMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dateMaesters.getEmployees().add(stephanieClarckson);
        dateMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dateMaesters);
        lindaKovalsky.getCompanies().add(dateMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dateMaesters);
        int dateMaestersId = dateMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dateMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        //try {
          //  companyDao.deleteById(softwareMachineId);
         //   companyDao.deleteById(dateMaestersId);
         //   companyDao.deleteById(greyMatterId);
       // } catch (Exception e) {
            //do nothing
       // }
    }

    @Test
    public void testNamedQueries() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Company softwareMachine = new Company("Software Machine");
        softwareMachine.getEmployees().add(johnSmith);
        johnSmith.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
        int id = softwareMachine.getId();

        //When
        List<Company> companyName = companyDao.retrieveCompany("Sof%");
        List<Employee> employeesLastname = employeeDao.retrieveByLastname("Smith");

        //Then
        try {
            Assert.assertEquals(1, companyName.size());
            Assert.assertEquals(1, employeesLastname.size());

        } finally {
            //CleanUp
            companyDao.deleteById(id);
        }
    }
}
