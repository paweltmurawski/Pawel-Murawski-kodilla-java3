package com.kodilla.hibernate.manytomany.facade;

public class QueryResultException extends Exception {

    public static final String ERR_COMPANY_NOT_FOUND = "Company not found";
    public static final String ERR_EMPLOYEE_NOT_FOUND = "Employee not found";

    public QueryResultException(String message) {
        super(message);
    }
}
