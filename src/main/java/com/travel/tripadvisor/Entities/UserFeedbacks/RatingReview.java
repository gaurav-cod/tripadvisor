package com.travel.tripadvisor.Entities.UserFeedbacks;

import com.travel.tripadvisor.HelperEntities.User.UserDetailsOverview;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "PlaceRatingReview")
@Getter
@Setter
public class RatingReview {

    public enum TravelType {
        SOLO, FAMILY, FRIENDS
    }

    @Id()
    private UUID ratingReviewId;
    private UUID placeId;
    private UserDetailsOverview userDetailsOverview;
    private String reviewTitle;
    private String reviewDetails;
    private Integer ratings;
    private Date createTimeStamp;
    private Date travelDate;
    private TravelType travelType;
    private Integer likesOnReview;

    RatingReview() {
        this.ratingReviewId = UUID.randomUUID();
        this.createTimeStamp = new Date();
    }
}

