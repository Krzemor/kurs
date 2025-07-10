package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyFacade {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> findCompaniesByNameFragment(String fragment) {
        return entityManager
                .createNamedQuery("Company.retrieveByNameFragment", Company.class)
                .setParameter("NAME_FRAGMENT", "%" + fragment + "%")
                .getResultList();
    }

    public List<Employee> findEmployeesByLastnameFragment(String fragment) {
        return entityManager
                .createNamedQuery("Employee.retrieveByLastnameFragment", Employee.class)
                .setParameter("LASTNAME_FRAGMENT", "%" + fragment + "%")
                .getResultList();
    }
}
