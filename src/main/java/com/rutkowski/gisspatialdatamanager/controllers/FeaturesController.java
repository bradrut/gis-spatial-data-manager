package com.rutkowski.gisspatialdatamanager.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutkowski.gisspatialdatamanager.types.FeatureDto;

@RestController
public class FeaturesController {

	@GetMapping("/features")
	public FeatureDto getFeature() {
		return new FeatureDto("1", "Point", null, null);
	}
}
