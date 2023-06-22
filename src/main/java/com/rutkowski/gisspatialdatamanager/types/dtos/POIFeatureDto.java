package com.rutkowski.gisspatialdatamanager.types.dtos;

import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

import lombok.Data;

/**
 * DTO for point-of-interest features
 */
@Data
public class POIFeatureDto {

  private final String id;                    // Unique identifier
  private final String category;              // e.g. Landmark, school, city, etc.
  private final String name;                  // The name of the specific point of interest feature
  private final String address;
  private String rawGeocodedAddress;
  private final Object additionalProperties;  // Additional properties associated with the feature
  private final PointGeometry geometry;       // Geometric representation of the feature
  
}
