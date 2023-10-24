package com.travel.tripadvisor.Controllers.PointOfInterestControllers;

import com.travel.tripadvisor.Entities.PointOfInterest.HotelEntity;
import com.travel.tripadvisor.Entities.PointOfInterest.Interfaces.PlaceEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Services.PointOfInterestServices.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public HotelEntity registerHotel(@RequestBody() HotelEntity hotelDetails) {
        return this.hotelService.registerHotel(hotelDetails);
    }

    @GetMapping("/{hotelId}")
    public PlaceEntity fetchHotelDetails(@PathVariable()UUID hotelId) {
        return this.hotelService.getHotelById(hotelId);
    }

    @GetMapping("/search")
    public List<HotelEntity> searchHotelByText(@RequestParam() String searchText) {
        return this.hotelService.searchHotel(searchText);
    }

    @GetMapping("/all")
    public List<HotelEntity> fetchAllHotelDetails() {
        return this.hotelService.getAllHotels();
    }

    @PostMapping("/{hotelId}/rating-review")
    public RatingReview giveRatingReviewToHotel(@PathVariable()UUID hotelId, @RequestBody()RatingReview ratingReview) {
        return this.hotelService.giveHotelRatingReview(hotelId, ratingReview);
    }

    @GetMapping("/{hotelId}/rating-review")
    public List<RatingReview> fetchAllRatingReviewOfHotel(@PathVariable() UUID hotelId) {
        return this.hotelService.fetchAllRatingReviews(hotelId);
    }

}
