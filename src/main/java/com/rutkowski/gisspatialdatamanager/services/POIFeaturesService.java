package com.rutkowski.gisspatialdatamanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutkowski.gisspatialdatamanager.entities.POIFeatureEntity;
import com.rutkowski.gisspatialdatamanager.repositories.POIFeatureRepository;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

@Service
public class POIFeaturesService {

  private final ESRIGeocodingService geocodingService;
  private final POIFeatureRepository poiFeatureRepository;

  @Autowired
  public POIFeaturesService(ESRIGeocodingService geocodingService, POIFeatureRepository poiFeatureRepository) {
    this.geocodingService = geocodingService;
    this.poiFeatureRepository = poiFeatureRepository;
  }

  public POIFeatureEntity createPOIFeature(POIFeatureEntity poiFeatureEntity) {
    PointGeometry pointGeometryFromAddress = geocodingService.geocodeAddress(poiFeatureEntity.getAddress());

    // TODO: This is redundant
    poiFeatureEntity.setLatitude(pointGeometryFromAddress.getLatitude());
    poiFeatureEntity.setLongitude(pointGeometryFromAddress.getLongitude());

    poiFeatureRepository.save(poiFeatureEntity);
    
    return poiFeatureEntity;
  }

}
