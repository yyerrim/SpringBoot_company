package com.example.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.company.model.Departments;
import com.example.company.model.Locations;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
    public Departments findByDepartmentName(String departmentName);

    public List<Departments> findByLocations(Locations locations);
}
