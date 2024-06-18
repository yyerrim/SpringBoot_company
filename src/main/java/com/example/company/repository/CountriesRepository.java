package com.example.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.company.model.Countries;
import com.example.company.model.Regions;

public interface CountriesRepository extends JpaRepository<Countries, String>{
    public List<Countries> findByRegions(Regions regions);
}
