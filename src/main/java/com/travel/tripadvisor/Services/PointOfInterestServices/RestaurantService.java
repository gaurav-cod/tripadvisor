package com.travel.tripadvisor.Services.PointOfInterestServices;

import com.travel.tripadvisor.Entities.PointOfInterest.HotelEntity;
import com.travel.tripadvisor.Entities.PointOfInterest.RestaurantEntity;
import com.travel.tripadvisor.Entities.User.UserEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.HotelRepository;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.RestaurantRepository;
import com.travel.tripadvisor.Repositories.UserRepo.RatingReviewRepository;
import com.travel.tripadvisor.Repositories.UserFeedbacksRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Autowired
    private UserRepository userRepository;

    public RestaurantEntity registerRestaurant(RestaurantEntity restaurantDetail) {
        return this.restaurantRepository.save(restaurantDetail);
    }
    public void deleteRestaurant(UUID restaurantId) {
        Optional<RestaurantEntity> optionalRestaurantDetail = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurantDetail.isPresent())
            this.restaurantRepository.deleteById(restaurantId);
    }
    public RestaurantEntity updateRestaurant(UUID restaurantId, RestaurantEntity restaurantEntity) {
        return null;
    }

    public List<RestaurantEntity> getAllRestaurants() {
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity getRestaurantById(UUID restaurantId) {
        Optional<RestaurantEntity> optionalRestaurantEntity = this.restaurantRepository.findById(restaurantId);
        return optionalRestaurantEntity.orElse(null);
    }

    public List<RestaurantEntity> searchRestaurant(String searchText) {
        return this.restaurantRepository.findByRestaurantNameIgnoreCases(searchText);
    }


    public List<RatingReview> fetchAllRatingReviews(UUID restaurantId) {
        Optional<RestaurantEntity> optionalRestaurantEntity = this.restaurantRepository.findById(restaurantId);
        if (optionalRestaurantEntity.isPresent()) {
            ArrayList<RatingReview> ratingReview = new ArrayList<RatingReview>();

            ArrayList<UUID> placeRatingReviewIds = optionalRestaurantEntity.get().getPlaceRatingReviewOverview().getRatingReviewIds();
            placeRatingReviewIds.forEach((ratingReviewId)-> {
                Optional<RatingReview> optionalPlaceRatingReview = this.ratingReviewRepository.findById(ratingReviewId);
                if(optionalPlaceRatingReview.isPresent())
                    ratingReview.add(optionalPlaceRatingReview.get());
            });
            return ratingReview;
        }
        return null;
    }

    public RatingReview giveRestaurantRatingReview(UUID restaurantId, RatingReview ratingReview) {

        UUID userId = ratingReview.getUserDetailsOverview().getUserId();

        if (userId == null) {
            return null;
        }

        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        Optional<RestaurantEntity> optionalRestaurantDetails = this.restaurantRepository.findById(restaurantId);

        if (optionalUserDetails.isPresent() && optionalRestaurantDetails.isPresent()) {

            UserEntity userDetails = optionalUserDetails.get();
            RestaurantEntity restaurantDetails = optionalRestaurantDetails.get();

            RatingReview response = this.ratingReviewRepository.save(ratingReview);
            userDetails.pushRatingReviewId(response.getRatingReviewId());
            restaurantDetails.getPlaceRatingReviewOverview().pushRatingReviewId(response.getRatingReviewId());

            this.userRepository.save(userDetails);
            this.restaurantRepository.save(restaurantDetails);

            return response;
        }
        return null;
    }
}
