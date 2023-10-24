package com.travel.tripadvisor.Repositories.Geography;

import com.travel.tripadvisor.Entities.Geography.CityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CityRepository extends MongoRepository<CityEntity, UUID> {
}
