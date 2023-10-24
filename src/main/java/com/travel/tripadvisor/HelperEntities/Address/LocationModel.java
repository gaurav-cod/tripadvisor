package com.travel.tripadvisor.HelperEntities.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationModel {
    public Cordinates cordinates = null;
    public String address = null;
    public String city = null;
    public String state = null;
    public String country = null;
    public String pincode = null;
}

