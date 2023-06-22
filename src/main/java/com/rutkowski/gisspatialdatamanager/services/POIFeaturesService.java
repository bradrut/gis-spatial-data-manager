package com.rutkowski.gisspatialdatamanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutkowski.gisspatialdatamanager.types.dtos.POIFeatureDto;

@Service
public class POIFeaturesService {

  private final ESRIGeocodingService geocodingService;

  @Autowired
  public POIFeaturesService(ESRIGeocodingService geocodingService) {
    this.geocodingService = geocodingService;
  }

  public void createPOIFeature(POIFeatureDto poiFeature) {
    // TODO: Call out to ESRIGeocodingService to reverse geocode the provided geocoordinates
    // TODO: Save poiFeature to DB
  }

}
