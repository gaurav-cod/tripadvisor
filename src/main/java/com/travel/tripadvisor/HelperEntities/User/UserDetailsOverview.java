package com.travel.tripadvisor.HelperEntities.User;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UserDetailsOverview {
    private UUID userId = null;
    private String userName = null;
    private String profileImageUrl = null;
    private String userAddressCity = null;
    private String userAddressCountry = null;
    private Date joiningDate = null;
}
