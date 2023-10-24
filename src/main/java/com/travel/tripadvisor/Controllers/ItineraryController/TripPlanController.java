package com.travel.tripadvisor.Controllers.ItineraryController;

import com.travel.tripadvisor.Entities.Itineraries.TripPlan;
import com.travel.tripadvisor.HelperEntities.ControllerHelperModels.BasicUserDetail;
import com.travel.tripadvisor.HelperEntities.ControllerHelperModels.TripPinnedNotesOverviewList;
import com.travel.tripadvisor.Services.ItineraryServices.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/plan-trip")
public class TripPlanController {

    @Autowired
    private TripPlanService tripPlanService;

    @PostMapping("/create")
    public TripPlan createTrip(@RequestBody() TripPlan tripPlanDetails) {
        return this.tripPlanService.createTrip(tripPlanDetails);
    }
    @GetMapping("/{tripId}/get")
    public TripPlan getTripDetails(@PathVariable()UUID tripId) {
        return this.tripPlanService.fetchTripDetails(tripId);
    }

    @DeleteMapping("/{tripId}/delete")
    public void deleteTrip(@PathVariable()UUID tripId) {
    this.tripPlanService.deleteTrip(tripId);
    }

    @PutMapping("/{tripId}/pinTodoOnDate")
    public TripPlan pinTODOToDate(@PathVariable() UUID tripId, @RequestBody() TripPinnedNotesOverviewList tripPinnedNotesOverviewList) {
        return this.tripPlanService.pinTodoOnDate(tripId, tripPinnedNotesOverviewList);
    }

    @PutMapping("/{tripId}/share")
    public TripPlan shareTripPlan(@PathVariable()UUID tripId, @RequestBody()BasicUserDetail sendingUsers) {
        return null;
    }

    @PutMapping("/{tripId}/edit")
    public TripPlan editTrip(@PathVariable() UUID tripId, @RequestBody() TripPlan tripPlanDetails) {
        return null;
    }
}
