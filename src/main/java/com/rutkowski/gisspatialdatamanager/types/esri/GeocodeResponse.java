package com.rutkowski.gisspatialdatamanager.types.esri;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GeocodeResponse {

  private Object spatialReference;
  private GeocodeResponseCandidate[] candidates;

  @JsonCreator
  public GeocodeResponse(@JsonProperty("spatialReference") Object spatialReference,
                         @JsonProperty("candidates") GeocodeResponseCandidate[] candidates) {
    this.spatialReference = spatialReference;
    this.candidates = candidates;
  }

}
