package com.travel.tripadvisor.HelperEntities.Amenities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "Amenities")
@Getter
@Setter
public class AmenitiesCategory {

    @Id()
    private UUID amenityId;
    private String amenityName;
    private String imageUrl;
    private List<AmenitiesSubCategory> amenitiesSubCategoryList;
    private Date createTimeStamp;

    AmenitiesCategory() {
        this.amenityId = UUID.randomUUID();
        this.createTimeStamp = new Date();
    }
}
