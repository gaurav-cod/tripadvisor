package com.travel.tripadvisor.Entities.PointOfInterest.Interfaces;

import com.travel.tripadvisor.HelperEntities.Images.UploadedImages;
import com.travel.tripadvisor.HelperEntities.Address.LocationModel;
import com.travel.tripadvisor.HelperEntities.UserFeedbacks.RatingReviewsOverview;
import com.travel.tripadvisor.enums.PlaceRegistrationProcess;

import java.util.ArrayList;
import java.util.Date;

public interface PlaceEntity {

    ArrayList<UploadedImages> uploadedImages = null;
    LocationModel locationModel = null;
    RatingReviewsOverview placeRatingReviews = null;
    String aboutPlace = null;
    Boolean isTripAdvisorRecommendation = false;
    PlaceRegistrationProcess registrationStatus = PlaceRegistrationProcess.NEW;

    Date createdTimeStamp = new Date();
    Date updatedTimeStamp = new Date();

    RatingReviewsOverview getPlaceRatingReviewOverview();

//    TODO: Need to add Timing Parameter and Awards

}
