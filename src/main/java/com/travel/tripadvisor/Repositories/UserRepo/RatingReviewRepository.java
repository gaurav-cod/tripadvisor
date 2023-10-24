package com.travel.tripadvisor.Repositories.UserRepo;

import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RatingReviewRepository extends MongoRepository<RatingReview, UUID> {
}
