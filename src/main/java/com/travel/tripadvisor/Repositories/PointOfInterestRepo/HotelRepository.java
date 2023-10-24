package com.travel.tripadvisor.Repositories.PointOfInterestRepo;

import com.travel.tripadvisor.Entities.PointOfInterest.HotelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HotelRepository extends MongoRepository<HotelEntity, UUID> {

    @Query("{hotelName: {$regex: ?0}}")
    List<HotelEntity> findByPlaceNameIgnoreCases(String searchText);
}
