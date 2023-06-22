package com.rutkowski.gisspatialdatamanager.types.geometries;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PointGeometry {
 
  private final BigDecimal latitude;
  private final BigDecimal longitude;

}
