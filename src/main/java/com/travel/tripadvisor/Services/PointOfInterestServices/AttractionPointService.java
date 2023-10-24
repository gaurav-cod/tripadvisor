package com.travel.tripadvisor.Services.PointOfInterestServices;

import com.travel.tripadvisor.Entities.PointOfInterest.AttractionPointEntity;
import com.travel.tripadvisor.Entities.User.UserEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Repositories.PointOfInterestRepo.AttractionPointsRepository;
import com.travel.tripadvisor.Repositories.UserRepo.RatingReviewRepository;
import com.travel.tripadvisor.Repositories.UserFeedbacksRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttractionPointService {
    @Autowired
    private AttractionPointsRepository attractionPointsRepository;

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Autowired
    private UserRepository userRepository;

    public AttractionPointEntity registerAttractionPoint(AttractionPointEntity attractionPointEntity) {
        return this.attractionPointsRepository.save(attractionPointEntity);
    }
    public List<AttractionPointEntity> getAllAttractionPoints() {
        return this.attractionPointsRepository.findAll();
    }

    public AttractionPointEntity getAttractionPointById(UUID pointId) {
        Optional<AttractionPointEntity> attractionPointDetails = this.attractionPointsRepository.findById(pointId);
        return attractionPointDetails.orElse(null);
    }

    public List<AttractionPointEntity> searchAttractionPoint(String searchText) {
        return this.attractionPointsRepository.findByPlaceNameIgnoreCases(searchText);
    }

    public List<RatingReview> fetAllRatingReview(UUID pointId) {
        Optional<AttractionPointEntity> optionalAttractionPointEntity = this.attractionPointsRepository.findById(pointId);
        if (optionalAttractionPointEntity.isPresent()) {
            ArrayList<RatingReview> ratingReview = new ArrayList<RatingReview>();

            ArrayList<UUID> attractionPointRatingReviewIds = optionalAttractionPointEntity.get().getPlaceRatingReviewOverview().getRatingReviewIds();
            attractionPointRatingReviewIds.forEach((ratingReviewId)-> {
                Optional<RatingReview> optionalPlaceRatingReview = this.ratingReviewRepository.findById(ratingReviewId);
                if(optionalPlaceRatingReview.isPresent())
                    ratingReview.add(optionalPlaceRatingReview.get());
            });
            return ratingReview;
        }
        return null;
    }


    public RatingReview giveAttractionPointRatingReview(UUID pointId, RatingReview ratingReview) {


        UUID userId = ratingReview.getUserDetailsOverview().getUserId();

        if (userId == null) {
            return null;
        }

        Optional<UserEntity> optionalUserDetails = this.userRepository.findById(userId);
        Optional<AttractionPointEntity> optionalAttractionPointDetails = this.attractionPointsRepository.findById(pointId);

        if (optionalUserDetails.isPresent() && optionalAttractionPointDetails.isPresent()) {

            UserEntity userDetails = optionalUserDetails.get();
            AttractionPointEntity attractionPointDetails = optionalAttractionPointDetails.get();

            RatingReview response = this.ratingReviewRepository.save(ratingReview);
            userDetails.pushRatingReviewId(response.getRatingReviewId());
            attractionPointDetails.getPlaceRatingReviewOverview().pushRatingReviewId(response.getRatingReviewId());

            this.userRepository.save(userDetails);
            this.attractionPointsRepository.save(attractionPointDetails);

            return response;
        }
        return null;
    }
}
