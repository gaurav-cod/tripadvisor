package com.travel.tripadvisor.Controllers.UserFeedbacksControllers;

import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Entities.User.UserEntity;
import com.travel.tripadvisor.Services.UserFeedbacksService.RatingReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/rating-review")
public class PlaceRatingReviewController {

    @Autowired
    private RatingReviewService ratingReviewService;





}
