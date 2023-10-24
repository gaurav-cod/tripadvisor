package com.travel.tripadvisor.Controllers.PointOfInterestControllers;

import com.travel.tripadvisor.Entities.PointOfInterest.RestaurantEntity;
import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Services.PointOfInterestServices.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public RestaurantEntity registerHotel(@RequestBody() RestaurantEntity restaurantEntity) {
        return this.restaurantService.registerRestaurant(restaurantEntity);
    }

    @GetMapping("/{hotelId}")
    public RestaurantEntity fetchRestaurantDetails(@PathVariable() UUID restaurantId) {
        return this.restaurantService.getRestaurantById(restaurantId);
    }

    @GetMapping("/search")
    public List<RestaurantEntity> searchRestaurantByText(@RequestParam() String searchText) {
        return this.restaurantService.searchRestaurant(searchText);
    }

    @GetMapping("/all")
    public List<RestaurantEntity> fetchAllRestaurants() {
        return this.restaurantService.getAllRestaurants();
    }

    @PostMapping("/{hotelId}/rating-review")
    public RatingReview giveRatingReviewToHotel(@PathVariable()UUID restaurantId, @RequestBody()RatingReview ratingReview) {
        return this.restaurantService.giveRestaurantRatingReview(restaurantId, ratingReview);
    }

    @GetMapping("/{restaurantId}/rating-review")
    public List<RatingReview> fetchAllRatingReviewOfHotel(@PathVariable() UUID restaurantId) {
        return this.restaurantService.fetchAllRatingReviews(restaurantId);
    }
}
