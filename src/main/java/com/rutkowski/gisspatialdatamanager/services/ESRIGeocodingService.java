package com.rutkowski.gisspatialdatamanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.rutkowski.gisspatialdatamanager.types.esri.GeocodeResponse;
import com.rutkowski.gisspatialdatamanager.types.geometries.PointGeometry;

@Service
public class ESRIGeocodingService {

  private final Environment environment;
  private final String esriGeocodingURI;
  private final RestTemplate restTemplate;

  @Autowired
  public ESRIGeocodingService(Environment environment) {
    this.environment = environment;
    this.esriGeocodingURI = this.environment.getProperty("esri.api.geocoding.uri");
    this.restTemplate = new RestTemplate();
  }

  public PointGeometry geocodeAddress(String address) {
    String uri = UriComponentsBuilder.fromHttpUrl(this.esriGeocodingURI)
      .queryParam("f", "json")
      .queryParam("singleLine", address)
      .queryParam("token", this.environment.getProperty("esri.api.key"))
      .encode()
      .toUriString();

    ResponseEntity<GeocodeResponse> response = restTemplate.getForEntity(uri, GeocodeResponse.class);

    return response.getBody().getCandidates()[0].getLocation();
  }
  
}
