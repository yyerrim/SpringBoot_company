package com.example.company.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Regions {
  @Id
  int regionId;

  String regionName;
 
}
