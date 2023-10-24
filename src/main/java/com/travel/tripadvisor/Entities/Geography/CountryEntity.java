package com.travel.tripadvisor.Entities.Geography;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document(collection = "Country")
@Getter
@Setter
public class CountryEntity {

    @Id
    private UUID countryId;
    private String countryName;
    private ArrayList<ProvinceEntity> provinceEntities;
}
