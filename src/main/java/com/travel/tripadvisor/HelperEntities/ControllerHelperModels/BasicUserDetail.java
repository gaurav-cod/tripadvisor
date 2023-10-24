package com.travel.tripadvisor.HelperEntities.ControllerHelperModels;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BasicUserDetail {
    UUID id;
    String name;
}
