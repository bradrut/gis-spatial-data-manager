package com.rutkowski.gisspatialdatamanager.dtos;

import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

import lombok.Data;

/**
 * DTO for point-of-interest features
 */
@Data
public class POIFeatureDto {

  private String id;                    // Unique identifier
  private String category;              // e.g. Landmark, school, city, etc.
  private String name;                  // The name of the specific point of interest feature
  private String address;
  private Object additionalProperties;  // Additional properties associated with the feature
  private PointGeometry geometry;             // Geometric representation of the feature
  
}
