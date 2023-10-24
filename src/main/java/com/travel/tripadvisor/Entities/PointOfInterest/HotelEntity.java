package com.travel.tripadvisor.Entities.PointOfInterest;

import com.travel.tripadvisor.Entities.PointOfInterest.Interfaces.PlaceEntity;
import com.travel.tripadvisor.HelperEntities.Amenities.AmenitiesCategory;
import com.travel.tripadvisor.HelperEntities.UserFeedbacks.RatingReviewsOverview;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "Hotel")
@Getter
@Setter
public class HotelEntity implements PlaceEntity {
    @Id()
    private UUID hotelId;
    private String hotelName;
    private String hotelWebsiteUrl;
    private String hotelMobile;
    private Boolean hotelIsVerified;
    private List<AmenitiesCategory> amenitiesList;

    HotelEntity() {
        this.hotelId = UUID.randomUUID();
    }


    @Override
    public RatingReviewsOverview getPlaceRatingReviewOverview() {
        return this.placeRatingReviews;
    }
}
