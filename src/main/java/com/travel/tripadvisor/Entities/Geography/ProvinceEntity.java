package com.travel.tripadvisor.Entities.Geography;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document(collection = "Province")
@Getter
@Setter
public class ProvinceEntity {

    @Id
    private UUID provinceId;
    private String provinceName;
    private ArrayList<CityEntity> cityEntities;
}
