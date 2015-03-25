package com.davidoladeji.park.service.util;

import com.davidoladeji.park.model.Account;
import com.davidoladeji.park.service.interfaces.CarparkService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daveola on 2/26/2015.
 */


public class Calculator {
    @Autowired
    CarparkService carparkService;

    public double calcProfileCompleteness(Account account) {

        double profilecompleteness;
        double percentage;
        int numfilledfields = 0;
        int fieldsPosssible = 8;


        /** Regular User can have
         * Firstname
         * LastName
         * Date of Birth
         * Gender
         * Address
         * Mobile
         * Username
         * Email
         *
         *
         * ADD LATER
         * avatar
         * Ethnicity
         *
         *
         * IN ADDITION
         * Administrator can have staffid
         *
         * IN ADDITION
         * Staff can have department
         * Staff can have manager
         *
         */

        if (account.getFirstName() != null && !account.getFirstName().isEmpty()) {
            numfilledfields += 1;
        }
        if (account.getLastName() != null && !account.getLastName().isEmpty()) {
            numfilledfields += 1;
        }
        if (account.getAddress() != null && !account.getAddress().isEmpty()) {
            numfilledfields += 1;
        }
        if (account.getDob() != null) {
            numfilledfields += 1;
        }
        if (account.getGender().getId() == 1 || account.getGender().getId() == 2 || !account.getGender().getId().toString().isEmpty() || account.getGender().getId() != null) {
            numfilledfields += 1;
        }
        if (account.getMobile() != null && !account.getMobile().isEmpty()) {
            numfilledfields += 1;
        }
        if (account.getEmail() != null && !account.getEmail().isEmpty()) {
            numfilledfields += 1;
        }


        // if Staff amd Admin have extra fields to test
        if (account.getUserRole().getId() == 1) {
            fieldsPosssible = 8;
            if (account.getCompany() != null && !account.getCompany().isEmpty()) {
                numfilledfields += 1;
            }
        } else if (account.getUserRole().getId() == 2) {
            fieldsPosssible = 8;
            if (account.getCompany() != null && !account.getCompany().isEmpty()) {
                numfilledfields += 1;
            }
        } else if (account.getUserRole().getId() == 3) {

            fieldsPosssible = 7;

        }
        CustomNumber customNumber = new CustomNumber();

        percentage = customNumber.percentage(numfilledfields, fieldsPosssible);

        profilecompleteness = customNumber.round(percentage, 2);
        return profilecompleteness;
    }




}
