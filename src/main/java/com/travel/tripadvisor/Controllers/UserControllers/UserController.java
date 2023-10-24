package com.travel.tripadvisor.Controllers.UserControllers;

import com.travel.tripadvisor.Entities.UserFeedbacks.RatingReview;
import com.travel.tripadvisor.Entities.User.UserEntity;
import com.travel.tripadvisor.Services.PointOfInterestServices.AttractionPointService;
import com.travel.tripadvisor.Services.PointOfInterestServices.HotelService;
import com.travel.tripadvisor.Services.PointOfInterestServices.RestaurantService;
import com.travel.tripadvisor.Services.UserServices.UserService;
import com.travel.tripadvisor.enums.LocationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private AttractionPointService attractionPointService;

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody()UserEntity userEntity) {
        return this.userService.createUser(userEntity);
    }

    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable()UUID userId) {
        this.userService.deleteUser(userId);
    }

    @PutMapping("/{userId}/update")
    public UserEntity updateUser(@PathVariable()UUID userId, @RequestBody() UserEntity userEntity) {
        return this.userService.updateUserDetails(userId, userEntity);
    }

    @GetMapping("/{userId}/details")
    public UserEntity getUserDetails(@PathVariable()UUID userId) {
        return this.userService.getUserDetails(userId);
    }

    @GetMapping("/search")
    public List<UserEntity> searchUserByName(@RequestParam()String searchText) {
        return this.userService.searchUserByName(searchText);
    }

    @GetMapping("/{userId}/rating-review-all")
    public List<RatingReview> getAllRatingReview(@PathVariable() UUID userId) {
        return this.userService.getAllRatingsOfUser(userId);
    }


}
