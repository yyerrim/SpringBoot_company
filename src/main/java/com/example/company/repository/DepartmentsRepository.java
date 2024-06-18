package com.example.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.company.model.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer>{
    public Departments findByDepartmentName(String departmentName);
}
