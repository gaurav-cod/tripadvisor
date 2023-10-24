package com.travel.tripadvisor.HelperEntities.TripPlanning;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class TripPinnedNotes {

    enum PINNED_TYPE {
        NOTE, RESTAURANT, HOTEL, ATTRACTION, LINK
    }

    static class RestaurantNotes {
        private String restaurantName;
        private UUID restaurantId;
        private Integer ratings;
        private Integer ratingCount;
        private Integer reviews;
        private String coverImageUrl;
        private Date openingHour;
        private Date closingHour;
    }

    static class HotelNotes {
        private String hotelName;
        private UUID hotelId;
        private Integer ratings;
        private Integer ratingCount;
        private Integer reviews;
        private String coverImageUrl;
    }

    static class AttractionPointNotes {
        private String pointName;
        private UUID pointId;
        private Integer ratings;
        private Integer ratingCount;
        private Integer reviews;
        private String coverImageUrl;
        private Date openingHour;
        private Date closingHour;
    }

    static class TripNotes {
        private UUID noteId;
        private String noteTitle;
        private String noteDescription;
    }
    static class TripPinnedURLs {
        private UUID URLId;
        private String url;
        private String title;
    }

    @Id
    private UUID noteId;
    private PINNED_TYPE pinnedType;
    private String commentOnNote;
//    private Integer index; // To sort things to do in order
    private Date todoDate;
    private TripPinnedURLs tripPinnedURLs;
    private TripNotes tripNotes;
    private AttractionPointNotes attractionPointNotes;
    private HotelNotes hotelNotes;
    private RestaurantNotes restaurantNotes;
    private Date createTimeStamp;
    private Date updatedTimeStamp;
}
