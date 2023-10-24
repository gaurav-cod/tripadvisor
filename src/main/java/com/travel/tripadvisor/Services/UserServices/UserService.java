package com.travel.tripadvisor.Services.UserServices;

import com.travel.tripadvisor.Entities.User.UserEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Exceptions.EntityNotFoundException;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.AttractionPointsRepository;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.HotelRepository;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.RestaurantRepository;
import com.travel.tripadvisor.Repositories.UserFeedbacksRepo.UserRepository;
import com.travel.tripadvisor.Repositories.UserRepo.RatingReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Autowired
    private AttractionPointsRepository attractionPointsRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public UserEntity createUser(UserEntity userDetails) {
        return this.userRepository.save(userDetails);
    }
    public void deleteUser(UUID userId) {
        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        if(optionalUserDetails.isPresent())
            this.userRepository.deleteById(userId);
        else
            throw new EntityNotFoundException("User not Found");
    }
    public UserEntity getUserDetails(UUID userId) {
        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        return optionalUserDetails.orElse(null);
    }
    public UserEntity updateUserDetails(UUID userId, UserEntity userDetails) {
        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        if (optionalUserDetails.isPresent()) {
            UserEntity fetchedUserDetails = optionalUserDetails.get();
            if (!userDetails.getAboutMe().isEmpty()) {
                fetchedUserDetails.setAboutMe(userDetails.getAboutMe());
            }
            if (!userDetails.getProfileImageUrl().isEmpty()) {
                fetchedUserDetails.setProfileImageUrl(userDetails.getProfileImageUrl());
            }
            fetchedUserDetails.setUpdatedTimeStamp(new Date());
            return this.userRepository.save(fetchedUserDetails);
        }
        return null;
    }
    public List<UserEntity> searchUserByName(String searchString) {
        return this.userRepository.findByUserNameIgnoreCases(searchString);
    }


    public List<RatingReview> getAllRatingsOfUser(UUID userId) {
        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        if (optionalUserDetails.isPresent()) {
            ArrayList<UUID> userRatingReviewIds = optionalUserDetails.get().getUserRatingReviewsIds();
            ArrayList<RatingReview> userRatingReviewList = new ArrayList<>();

            userRatingReviewIds.forEach((ratingReviewId)-> {
                Optional<RatingReview> optionalPlaceRatingReview = this.ratingReviewRepository.findById(ratingReviewId);
                optionalPlaceRatingReview.ifPresent(userRatingReviewList::add);
            });
            return userRatingReviewList;
        }
        return null;
    }
}
