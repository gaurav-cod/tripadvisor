package com.travel.tripadvisor.Controllers.PointOfInterestControllers;

import com.travel.tripadvisor.Entities.PointOfInterest.AttractionPointEntity;
import com.travel.tripadvisor.Entities.PointOfInterest.HotelEntity;
import com.travel.tripadvisor.Entities.PointOfInterest.Interfaces.PlaceEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Services.PointOfInterestServices.AttractionPointService;
import com.travel.tripadvisor.Services.PointOfInterestServices.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/attraction-points")
public class AttractionPointController {
    @Autowired
    private AttractionPointService attractionPointService;

    @PostMapping("/create")
    public AttractionPointEntity registerAttractionPoint(@RequestBody() AttractionPointEntity attractionPointDetails) {
        return this.attractionPointService.registerAttractionPoint(attractionPointDetails);
    }

    @GetMapping("/{hotelId}")
    public AttractionPointEntity fetchAttractionPointDetails(@PathVariable() UUID pointId) {
        return this.attractionPointService.getAttractionPointById(pointId);
    }

    @GetMapping("/search")
    public List<AttractionPointEntity> searchPointByText(@RequestParam() String searchText) {
        return this.attractionPointService.searchAttractionPoint(searchText);
    }

    @GetMapping("/all")
    public List<AttractionPointEntity> fetchAllHotelDetails() {
        return this.attractionPointService.getAllAttractionPoints();
    }

    @PostMapping("/{pointId}/rating-review")
    public RatingReview giveRatingReviewToHotel(@PathVariable()UUID pointId, @RequestBody()RatingReview ratingReview) {
        return this.attractionPointService.giveAttractionPointRatingReview(pointId, ratingReview);
    }

    @GetMapping("/{pointId}/rating-review")
    public List<RatingReview> fetchAllRatingReviewOfHotel(@PathVariable() UUID pointId) {
        return this.attractionPointService.fetAllRatingReview(pointId);
    }
}
