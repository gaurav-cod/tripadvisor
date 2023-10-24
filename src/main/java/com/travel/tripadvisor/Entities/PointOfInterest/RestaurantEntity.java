package com.travel.tripadvisor.Entities.PointOfInterest;

import com.travel.tripadvisor.Entities.PointOfInterest.Interfaces.PlaceEntity;
import com.travel.tripadvisor.HelperEntities.Amenities.AmenitiesCategory;
import com.travel.tripadvisor.HelperEntities.Food.Cuisines;
import com.travel.tripadvisor.HelperEntities.Food.DietaryOptions;
import com.travel.tripadvisor.HelperEntities.UserFeedbacks.RatingReviewsOverview;
import com.travel.tripadvisor.enums.ServingType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document(collection = "Restaurant")
@Getter
@Setter
public class RestaurantEntity implements PlaceEntity {

    @Id()
    private UUID restaurantId;
    private String restaurantName;
    private String restaurantWebsiteUrl;
    private String restaurantMobile;
    private Boolean restaurantIsVerified;
    private ArrayList<DietaryOptions> dietaryOptions;
    private ArrayList<Cuisines> servedCuisines;
    private ArrayList<ServingType> offeredFoodServings;
    private ArrayList<AmenitiesCategory> amenities;

    RestaurantEntity() {
        this.restaurantId = UUID.randomUUID();
    }


    @Override
    public RatingReviewsOverview getPlaceRatingReviewOverview() {
        return this.placeRatingReviews;
    }
}
