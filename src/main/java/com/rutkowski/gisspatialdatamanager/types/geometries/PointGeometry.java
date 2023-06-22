package com.rutkowski.gisspatialdatamanager.types.geometries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PointGeometry {
 
  private final double x;   // Latitude
  private final double y;   // Longitude

  @JsonCreator
  public PointGeometry(@JsonProperty("x") double x, @JsonProperty("y") double y) {
    this.x = x;
    this.y = y;
  }

}
