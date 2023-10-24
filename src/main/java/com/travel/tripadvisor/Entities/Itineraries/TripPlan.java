package com.travel.tripadvisor.Entities.Itineraries;

import com.travel.tripadvisor.HelperEntities.TripPlanning.TripPinnedNotes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Document(collection = "TripPlan")
@Getter
@Setter
public class TripPlan {

    // TODO: Shared with People List that can edit Plans

    enum USER_ACCESS {
        VIEWER, EDITOR, OWNER
    }
    enum TRIP_STATUS {
        PLANNING, ON_GOING, POST_POND, PAST, CANCELLED
    }
    class UserDetails {
        UUID userId;
        USER_ACCESS userAccessToNotes;
    }

    @Id()
    private UUID tripPlanId;
    private String tripTitle;
    private ArrayList<UserDetails> userDetailsList;
    private Date startingDate;
    private Date endingDate;
    private ArrayList<TripPinnedNotes> tripPinnedNotes;
    private Boolean isTripPublic;
    private TRIP_STATUS tripStatus;

    TripPlan() {
        this.tripPlanId = UUID.randomUUID();
        Date createdTimeStamp = new Date();
        Date updatedTimeStamp = new Date();
        this.isTripPublic = false;
        this.tripStatus = TRIP_STATUS.PLANNING;
    }
}
