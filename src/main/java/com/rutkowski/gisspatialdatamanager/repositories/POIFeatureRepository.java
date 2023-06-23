package com.rutkowski.gisspatialdatamanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutkowski.gisspatialdatamanager.entities.POIFeatureEntity;

@Repository
public interface POIFeatureRepository extends JpaRepository<POIFeatureEntity, Long> {
}
