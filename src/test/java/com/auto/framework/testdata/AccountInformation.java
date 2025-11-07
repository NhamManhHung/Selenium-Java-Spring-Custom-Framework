package com.auto.framework.testdata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInformation {
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String day;
    private String month;
    private String year;
    private String address;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;
}
