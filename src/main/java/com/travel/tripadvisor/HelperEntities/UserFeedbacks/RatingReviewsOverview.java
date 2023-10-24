package com.travel.tripadvisor.HelperEntities.UserFeedbacks;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class RatingReviewsOverview {
    public Integer ratings = null;
    public Integer ratingCount = null;
    public Integer reviewCount = null;
    public ArrayList<UUID>ratingReviewIds = null;

    RatingReviewsOverview() {
        this.ratingReviewIds = new ArrayList<>();
    }

    public void pushRatingReviewId(UUID id) {
        this.ratingReviewIds.add(id);
    }
}
