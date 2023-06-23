package com.rutkowski.gisspatialdatamanager.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rutkowski.gisspatialdatamanager.entities.POIFeatureEntity;
import com.rutkowski.gisspatialdatamanager.repositories.POIFeatureRepository;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

@ExtendWith(SpringExtension.class)
public class POIFeaturesServiceTest {

  private ESRIGeocodingService mockEsriGeocodingService;
  private POIFeatureRepository mockPoiFeatureRepository;

  private POIFeaturesService poiFeaturesService;
  private POIFeatureEntity testPoiFeatureEntity;

  @BeforeEach
  public void setup() {
    // Set up mock POIFeaturesService dependencies
    this.mockEsriGeocodingService = Mockito.mock(ESRIGeocodingService.class);
    this.mockPoiFeatureRepository = Mockito.mock(POIFeatureRepository.class);
    Mockito.when(this.mockEsriGeocodingService.geocodeAddress(any())).thenReturn(new PointGeometry(-80.0473832, 40.1732946));
    Mockito.when(this.mockPoiFeatureRepository.save(any())).thenReturn(null);

    this.poiFeaturesService = new POIFeaturesService(this.mockEsriGeocodingService, this.mockPoiFeatureRepository);

    this.testPoiFeatureEntity = new POIFeatureEntity();
    this.testPoiFeatureEntity.setId("1");
    this.testPoiFeatureEntity.setCategory("Colleges & Universities");
    this.testPoiFeatureEntity.setName("Gannon University");
    this.testPoiFeatureEntity.setAddress("109 University Square, Erie, PA 16541");
  }

  @Test
  public void createPOIFeature_AddressGeocodedAndRepositoryCalled_Success() {
    POIFeatureEntity poiFeatureEntity = poiFeaturesService.createPOIFeature(this.testPoiFeatureEntity);
    assertEquals(40.1732946, poiFeatureEntity.getLatitude());
    assertEquals(-80.0473832, poiFeatureEntity.getLongitude());
  }
  
}
