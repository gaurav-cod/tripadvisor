package com.travel.tripadvisor.Repositories.PointOfInterestRepo;

import com.travel.tripadvisor.Entities.PointOfInterest.RestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RestaurantRepository extends MongoRepository<RestaurantEntity, UUID> {

    @Query("{restaurantName: {$regex: ?0}}")
    List<RestaurantEntity> findByRestaurantNameIgnoreCases(String searchText);
}
