package com.travel.tripadvisor.HelperEntities.ControllerHelperModels;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TripPinnedNotesOverviewList {

    public static class TripPinnedNotesOverview {
        public UUID noteId;
        public Date todoDate;
    }
    private ArrayList<TripPinnedNotesOverview> tripPinnedNotesOverviewsList;
}
