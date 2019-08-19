package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class QueryFacade {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryFacade.class);

    public List<Company> findCompany(String query) throws QueryResultException {
        List<Company> result = companyRepository.findByCompany("%" + query + "%");
        if (result.isEmpty()) {
            LOGGER.error(QueryResultException.ERR_COMPANY_NOT_FOUND);
            throw new QueryResultException(QueryResultException.ERR_COMPANY_NOT_FOUND);
        }
        return result;
    }

    public List<Employee> findByLastname(String query) throws QueryResultException {
        List<Employee> result = employeeRepository.findByLastname("%" + query + "%");
        if (result.isEmpty()) {
            LOGGER.error(QueryResultException.ERR_EMPLOYEE_NOT_FOUND);
            throw new QueryResultException(QueryResultException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return result;
    }
}
