package com.rutkowski.gisspatialdatamanager.controllers;

import org.apache.tomcat.util.json.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutkowski.gisspatialdatamanager.dtos.POIFeatureDto;
import com.rutkowski.gisspatialdatamanager.entities.POIFeatureEntity;
import com.rutkowski.gisspatialdatamanager.services.POIFeaturesService;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

/**
 * Controller for handling management of Point of Interest (POI) Features
 */
@RestController
@RequestMapping("/features/poi")
public class POIFeaturesController {

  private final POIFeaturesService poiFeaturesService;
  private final ModelMapper modelMapper;

	@Autowired
  public POIFeaturesController(POIFeaturesService poiFeaturesService, ModelMapper modelMapper) {
    this.poiFeaturesService = poiFeaturesService;
    this.modelMapper = modelMapper;
  }

  /*
   * TODO: Handle this exception better
   */
  @PutMapping
  public ResponseEntity<POIFeatureDto> createFeature(@RequestBody POIFeatureDto poiFeatureDto) throws Exception {
    POIFeatureEntity poiFeatureEntity =
      poiFeaturesService.createPOIFeature(convertToEntity(poiFeatureDto));
    
    return new ResponseEntity<>(convertToDto(poiFeatureEntity), HttpStatus.OK);
  }

  private POIFeatureEntity convertToEntity(POIFeatureDto poiFeatureDto) throws ParseException {
    POIFeatureEntity poiFeatureEntity = this.modelMapper.map(poiFeatureDto, POIFeatureEntity.class);

    return poiFeatureEntity;
  }

  private POIFeatureDto convertToDto(POIFeatureEntity poiFeatureEntity) throws ParseException {
    POIFeatureDto poiFeatureDto = this.modelMapper.map(poiFeatureEntity, POIFeatureDto.class);
    poiFeatureDto.setGeometry(new PointGeometry(poiFeatureEntity.getLongitude(), poiFeatureEntity.getLatitude()));

    return poiFeatureDto;
  }

}
