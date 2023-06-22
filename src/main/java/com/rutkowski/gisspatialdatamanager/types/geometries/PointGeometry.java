package com.rutkowski.gisspatialdatamanager.types.geometries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PointGeometry {
 
  private final double latitude;
  private final double longitude;

  /*
   * These @JsonProprty() annotations were put in place to fix an issue with mapping ESRI's response
   * back to our custom object. An unintended side effect is that the names "x" and "y" (which can be
   * confusing) are sent back to our client.
   * TODO: Update this so that "x" and "y" are returned to our client as "longitude" and "latitude", respectively
   */
  @JsonCreator
  public PointGeometry(@JsonProperty("x") double longitude, @JsonProperty("y") double latitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

}
