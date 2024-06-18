package com.example.company.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data

@ToString(exclude = "regions")

public class Countries {
  @Id
  String countryId;

  String countryName;
 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id")
  Regions regions;
}
