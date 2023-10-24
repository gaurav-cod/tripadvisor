package com.travel.tripadvisor.Services.UserFeedbacksService;

import com.travel.tripadvisor.Repositories.UserRepo.RatingReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingReviewService {

    @Autowired
    private RatingReviewRepository ratingReviewRepository;


}
