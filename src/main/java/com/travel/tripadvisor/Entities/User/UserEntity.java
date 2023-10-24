package com.travel.tripadvisor.Entities.User;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Document(collection = "User")
@Getter
@Setter
public class UserEntity {

    @Getter
    @Setter
    private class UserAddress {
        String city = null;
        String state = null;
        String country = null;

        UserAddress() {

        }
    }

    @Id()
    private UUID userId;
    private String userName;
    private String profileImageUrl;
    private UserAddress userAddress;
    private String aboutMe;
    private ArrayList<String> uploadedPhotos;
    private ArrayList<UUID> userRatingReviewsIds;
    private ArrayList<UUID> favouritePlaces;
    private Date createTimeStamp;
    private Date updatedTimeStamp;

    UserEntity() {
        this.userId = UUID.randomUUID();
        this.createTimeStamp = new Date();
        this.userRatingReviewsIds = null;
        this.favouritePlaces = null;
        this.uploadedPhotos = null;
        this.profileImageUrl = null;
    }

    public void pushRatingReviewId(UUID id) {
        this.userRatingReviewsIds.add(id);
    }
    public void pushPhotoId(String imageUrl) {
        this.uploadedPhotos.add(imageUrl);
    }
    public void pushFavouritePlace(UUID id) {
        this.favouritePlaces.add(id);
    }
}
