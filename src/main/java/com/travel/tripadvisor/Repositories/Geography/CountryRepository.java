package com.travel.tripadvisor.Repositories.Geography;

import com.travel.tripadvisor.Entities.Geography.CountryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CountryRepository extends MongoRepository<CountryEntity, UUID> {
}
