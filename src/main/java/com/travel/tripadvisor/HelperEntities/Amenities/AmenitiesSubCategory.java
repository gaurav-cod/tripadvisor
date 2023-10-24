package com.travel.tripadvisor.HelperEntities.Amenities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "AmenitiesSubCategory")
@Getter
@Setter
public class AmenitiesSubCategory {
    @Id
    private UUID amenitySubCategoryId;
    private String amenitySubCategoryName;
    private Date createTimeStamp;

    AmenitiesSubCategory() {
        this.amenitySubCategoryId = UUID.randomUUID();
        this.createTimeStamp = new Date();
    }
}
