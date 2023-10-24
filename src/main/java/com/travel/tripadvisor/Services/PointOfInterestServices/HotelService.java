package com.travel.tripadvisor.Services.PointOfInterestServices;

import com.travel.tripadvisor.Entities.PointOfInterest.HotelEntity;
import com.travel.tripadvisor.Entities.User.UserEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.HotelRepository;
import com.travel.tripadvisor.Repositories.UserRepo.RatingReviewRepository;
import com.travel.tripadvisor.Repositories.UserFeedbacksRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Autowired
    private UserRepository userRepository;

    public HotelEntity registerHotel(HotelEntity hotelEntity) {
        return this.hotelRepository.save(hotelEntity);
    }
    public List<HotelEntity> getAllHotels() {
        return this.hotelRepository.findAll();
    }

    public HotelEntity getHotelById(UUID hotelId) {
        Optional<HotelEntity> hotelDetails = this.hotelRepository.findById(hotelId);
        return hotelDetails.orElse(null);
    }

    public List<HotelEntity> searchHotel(String searchText) {
        return this.hotelRepository.findByPlaceNameIgnoreCases(searchText);
    }

    public List<RatingReview> fetchAllRatingReviews(UUID hotelId) {
        Optional<HotelEntity> optionalHotelEntity = this.hotelRepository.findById(hotelId);
        if (optionalHotelEntity.isPresent()) {
            ArrayList<RatingReview> ratingReview = new ArrayList<RatingReview>();

            ArrayList<UUID> placeRatingReviewIds = optionalHotelEntity.get().getPlaceRatingReviewOverview().getRatingReviewIds();
            placeRatingReviewIds.forEach((ratingReviewId)-> {
                Optional<RatingReview> optionalPlaceRatingReview = this.ratingReviewRepository.findById(ratingReviewId);
                if(optionalPlaceRatingReview.isPresent())
                    ratingReview.add(optionalPlaceRatingReview.get());
            });
            return ratingReview;
        }
        return null;
    }


    public RatingReview giveHotelRatingReview(UUID hotelId, RatingReview ratingReview) {

        UUID userId = ratingReview.getUserDetailsOverview().getUserId();

        if (userId == null) {
            return null;
        }

        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        Optional<HotelEntity> optionalHotelDetails = this.hotelRepository.findById(hotelId);

        if (optionalUserDetails.isPresent() && optionalHotelDetails.isPresent()) {

            UserEntity userDetails = optionalUserDetails.get();
            HotelEntity hotelDetails = optionalHotelDetails.get();

            RatingReview response = this.ratingReviewRepository.save(ratingReview);
            userDetails.pushRatingReviewId(response.getRatingReviewId());
            hotelDetails.getPlaceRatingReviewOverview().pushRatingReviewId(response.getRatingReviewId());

            this.userRepository.save(userDetails);
            this.hotelRepository.save(hotelDetails);

            return response;
        }
        return null;
    }
}
