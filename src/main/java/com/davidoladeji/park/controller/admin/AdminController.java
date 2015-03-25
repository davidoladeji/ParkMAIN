package com.davidoladeji.park.controller.admin;


import com.davidoladeji.park.model.*;
import com.davidoladeji.park.service.implementation.*;
import com.davidoladeji.park.service.util.CustomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AccountServiceImpl accountService;
    @Autowired
    CarparkServiceImpl carparkService;
    @Autowired
    AirportServiceImpl airportService;
    @Autowired
    CarparkSpaceServiceImpl carparkSpaceService;
    @Autowired
    BookingServiceImpl bookingService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String dashBoard(ModelMap model) {


        /**
         *  Add all airports into a List
         *Get number of  all airports and pass to front
         *
         */
        List<Account> allAccounts = accountService.findAllAccounts();
        int numUsers = allAccounts.size();
        model.addAttribute("numUsers", numUsers);

        /**
         *  Add all airports into a List
         *Get number of  all airports and pass to front
         *
         */
        List<Airport> allAirports = airportService.findAllAirports();
        int numAirtports = allAirports.size();
        model.addAttribute("numAirtports", numAirtports);

        /**
         * Add all carparks into a List
         *Get number of  all carparks and pass to front
         *
         */
        List<Carpark> allCarparks = carparkService.findAllCarparks();
        int numCarparks = carparkService.countAllCarparks();
        model.addAttribute("numCarparks", numCarparks);


        /**
         * Add all spaces into a List
         *Get number of  all spaces and pass to front
         *
         */
        List<CarparkSpace> allSpaces = carparkSpaceService.findAllCarparkSpaces();
        int numSpaces = allSpaces.size();
        model.addAttribute("numSpaces", numSpaces);


        /**
         * Add all available spaces into a List
         *Get number of  all available spaces and pass to front
         *
         */

        int numAvailableSpaces = carparkSpaceService.countAllAvailableSpaces();
        model.addAttribute("numAvailableSpaces", numAvailableSpaces);


        CustomNumber customNumber = new CustomNumber();

        if (numSpaces >= 1 && numAvailableSpaces >= 1) {
            double availablespacepercebtage = customNumber.percentage(numAvailableSpaces, numSpaces);
            availablespacepercebtage = customNumber.round(availablespacepercebtage, 2);

            model.addAttribute("availablespacepercebtage", availablespacepercebtage);
        }


        /**
         * Add all booking into a List
         *Get number of  all available spaces and pass to front
         *
         */

        List<Booking> allBooking = bookingService.findAllBookings();
        int numBookings = bookingService.countAllBookings();
        model.addAttribute("numBookings", numBookings);


        return "admin/index";
    }
}
