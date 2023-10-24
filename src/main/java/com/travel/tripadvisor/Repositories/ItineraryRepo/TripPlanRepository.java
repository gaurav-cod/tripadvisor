package com.travel.tripadvisor.Repositories.ItineraryRepo;

import com.travel.tripadvisor.Entities.Itineraries.TripPlan;
import com.travel.tripadvisor.HelperEntities.TripPlanning.TripPinnedNotes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TripPlanRepository extends MongoRepository<TripPlan, UUID> {
}
