package com.rutkowski.gisspatialdatamanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutkowski.gisspatialdatamanager.services.POIFeaturesService;
import com.rutkowski.gisspatialdatamanager.types.dtos.POIFeatureDto;

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
  public ResponseEntity<POIFeatureDto> createFeature(@RequestBody POIFeatureDto poiFeatureDto) {
    POIFeatureDto augmentedPOIFeatureDto = poiFeaturesService.createPOIFeature(poiFeatureDto);
    return new ResponseEntity<>(augmentedPOIFeatureDto, HttpStatus.OK);
  }

}
