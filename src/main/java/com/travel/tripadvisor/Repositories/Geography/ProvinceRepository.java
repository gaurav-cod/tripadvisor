package com.travel.tripadvisor.Repositories.Geography;

import com.travel.tripadvisor.Entities.Geography.ProvinceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProvinceRepository extends MongoRepository<ProvinceEntity, UUID> {
}
