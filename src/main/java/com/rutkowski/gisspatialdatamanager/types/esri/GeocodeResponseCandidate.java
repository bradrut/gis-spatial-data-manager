package com.rutkowski.gisspatialdatamanager.types.esri;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

import lombok.Data;

@Data
public class GeocodeResponseCandidate {

  private String address;
  private PointGeometry location;
  private int score;
  private Object attributes;
  private Object extent;

  @JsonCreator
  public GeocodeResponseCandidate(@JsonProperty("address") String address,
                                  @JsonProperty("location") PointGeometry location,
                                  @JsonProperty("score") int score) {
    this.address = address;
    this.location = location;
    this.score = score;
  }

}
