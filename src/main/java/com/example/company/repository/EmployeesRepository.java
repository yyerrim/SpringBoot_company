package com.example.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.company.model.Departments;
import com.example.company.model.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    public List<Employees> findByDepartments(Departments departments);
}
