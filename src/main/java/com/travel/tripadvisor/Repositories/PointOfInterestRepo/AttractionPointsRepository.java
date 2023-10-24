package com.travel.tripadvisor.Repositories.PointOfInterestRepo;

import com.travel.tripadvisor.Entities.PointOfInterest.AttractionPointEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AttractionPointsRepository extends MongoRepository<AttractionPointEntity, UUID> {

    @Query("{attractionPointName: {$regex: ?0}}")
    List<AttractionPointEntity> findByPlaceNameIgnoreCases(String searchText);
}
