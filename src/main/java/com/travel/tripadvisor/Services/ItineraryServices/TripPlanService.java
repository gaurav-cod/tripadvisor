package com.travel.tripadvisor.Services.ItineraryServices;

import com.travel.tripadvisor.Entities.Itineraries.TripPlan;
import com.travel.tripadvisor.HelperEntities.ControllerHelperModels.TripPinnedNotesOverviewList;
import com.travel.tripadvisor.Repositories.ItineraryRepo.TripPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TripPlanService {

    @Autowired
    private TripPlanRepository tripPlanRepository;

    public TripPlan createTrip(TripPlan tripPlanDetails) {
        return this.tripPlanRepository.save(tripPlanDetails);
    }
    public TripPlan fetchTripDetails(UUID tripId) {
        Optional<TripPlan> optionalTripPlan = this.tripPlanRepository.findById(tripId);
        return optionalTripPlan.orElse(null);
    }
    public void deleteTrip(UUID tripId) {
        Optional<TripPlan> optionalTripPlan = this.tripPlanRepository.findById(tripId);
        if (optionalTripPlan.isPresent())
            this.tripPlanRepository.deleteById(tripId);
    }
    public TripPlan pinTodoOnDate(UUID tripId, TripPinnedNotesOverviewList tripPinnedNotesOverviewList) {
        Optional<TripPlan> optionalTripPlan = this.tripPlanRepository.findById(tripId);
        if (optionalTripPlan.isEmpty())
            return null;

        TripPlan tripPlan = optionalTripPlan.get();
        tripPinnedNotesOverviewList.getTripPinnedNotesOverviewsList().forEach((tripDetail)-> {
            tripPlan.getTripPinnedNotes().forEach((notes)-> {
                if (tripDetail.noteId.equals(notes.getNoteId()))
                    notes.setTodoDate(tripDetail.todoDate);
            });
        });

        return this.tripPlanRepository.save(tripPlan);
    }

}
