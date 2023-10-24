package com.travel.tripadvisor.Entities.PointOfInterest;

import com.travel.tripadvisor.Entities.PointOfInterest.Interfaces.PlaceEntity;
import com.travel.tripadvisor.HelperEntities.UserFeedbacks.RatingReviewsOverview;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "AttractionPoint")
@Getter
@Setter
public class AttractionPointEntity implements PlaceEntity {
    @Id()
    private UUID attractionPointId;
    private String attractionPointName;

    AttractionPointEntity() {
        this.attractionPointId = UUID.randomUUID();
    }

    @Override
    public RatingReviewsOverview getPlaceRatingReviewOverview() {
        return this.placeRatingReviews;
    }
}
