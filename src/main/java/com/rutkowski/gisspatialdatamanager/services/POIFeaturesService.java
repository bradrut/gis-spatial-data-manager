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

  public POIFeatureDto createPOIFeature(POIFeatureDto poiFeature) {
    String geocodedResponse = geocodingService.geocodeAddress(poiFeature.getAddress());
    poiFeature.setRawGeocodedAddress(geocodedResponse);
    // TODO: Save poiFeature to DB
    return poiFeature;
  }

}
