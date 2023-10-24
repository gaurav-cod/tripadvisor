package com.travel.tripadvisor.Repositories.UserFeedbacksRepo;

import com.travel.tripadvisor.Entities.User.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends MongoRepository<UserEntity, UUID> {

    @Query("{userName: {$regex: ?0}}")
    List<UserEntity> findByUserNameIgnoreCases(String searchString);
}
