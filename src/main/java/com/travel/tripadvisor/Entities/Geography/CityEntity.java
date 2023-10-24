package com.travel.tripadvisor.Entities.Geography;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "City")
@Getter
@Setter
public class CityEntity {

    @Id
    private UUID cityId;
    private String cityName;
}
