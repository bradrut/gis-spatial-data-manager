package com.rutkowski.gisspatialdatamanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutkowski.gisspatialdatamanager.types.dtos.POIFeatureDto;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

@Service
public class POIFeaturesService {

  private final ESRIGeocodingService geocodingService;

  @Autowired
  public POIFeaturesService(ESRIGeocodingService geocodingService) {
    this.geocodingService = geocodingService;
  }

  public POIFeatureDto createPOIFeature(POIFeatureDto poiFeature) {
    PointGeometry pointGeometryFromAddress = geocodingService.geocodeAddress(poiFeature.getAddress());
    poiFeature.setGeometry(pointGeometryFromAddress);
    // TODO: Save poiFeature to DB
    return poiFeature;
  }

}
