package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompaniesByNameFragment() {
        // Given
        Company c1 = new Company("Software Machine");
        Company c2 = new Company("DataSoft");
        Company c3 = new Company("Grey Matter");

        companyDao.save(c1);
        companyDao.save(c2);
        companyDao.save(c3);

        // When
        List<Company> results = companyFacade.findCompaniesByNameFragment("Soft");

        // Then
        assertEquals(2, results.size());
    }

    @Test
    void testFindEmployeesByLastnameFragment() {
        // Given
        Employee e1 = new Employee("John", "Smith");
        Employee e2 = new Employee("Anna", "Smithee");
        Employee e3 = new Employee("Mark", "Johnson");

        employeeDao.save(e1);
        employeeDao.save(e2);
        employeeDao.save(e3);

        // When
        List<Employee> results = companyFacade.findEmployeesByLastnameFragment("Smit");

        // Then
        assertEquals(2, results.size());
    }
}
