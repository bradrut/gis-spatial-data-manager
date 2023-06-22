package com.rutkowski.gisspatialdatamanager.types;

import lombok.Data;

@Data
public class FeatureDto {

  private final String id;
  private final String type;        // Type of the feature, e.g., "Point," "LineString," "Polygon," etc. TODO: Make enum
  private final Object properties;  // Additional properties associated with the feature
  private final Object geometry;    // Geometric representation of the feature
  
}
