package com.rutkowski.gisspatialdatamanager.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutkowski.gisspatialdatamanager.services.POIFeaturesService;
import com.rutkowski.gisspatialdatamanager.types.dtos.POIFeatureDto;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

/**
 * Controller for handling management of Point of Interest (POI) Features
 */
@RestController
@RequestMapping("/features/poi")
public class POIFeaturesController {

  private final POIFeaturesService poiFeaturesService;

	@Autowired
  public POIFeaturesController(POIFeaturesService poiFeaturesService) {
    this.poiFeaturesService = poiFeaturesService;
  }

  @PutMapping
  public POIFeatureDto createFeature(@RequestBody POIFeatureDto poiFeatureDto) {
    poiFeaturesService.createPOIFeature(poiFeatureDto);
    return new POIFeatureDto("1", "landmark", "Perry Monument", null, new PointGeometry(new BigDecimal(42.15517322181269), new BigDecimal(-80.08945024790742)));
  }

}
