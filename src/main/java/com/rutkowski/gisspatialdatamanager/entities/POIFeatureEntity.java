package com.rutkowski.gisspatialdatamanager.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class POIFeatureEntity {

  @Id
  private String id;                    // Unique identifier
  private String category;              // e.g. Landmark, school, city, etc.
  private String name;                  // The name of the specific point of interest feature
  private String address;
  // TODO: When additionalProperties starts being used, uncomment this and fix the hibernate error
  // private final Object additionalProperties;  // Additional properties associated with the feature
  private double latitude;
  private double longitude;
  
}
