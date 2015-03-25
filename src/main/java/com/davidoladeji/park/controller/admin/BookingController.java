package com.davidoladeji.park.controller.admin;

import com.davidoladeji.park.model.*;
import com.davidoladeji.park.service.interfaces.*;
import com.davidoladeji.park.service.util.Calculator;
import com.davidoladeji.park.service.util.MyTimeDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 * All booking related navigation and controlls in the admin page
 */

@Controller
public class BookingController {



    MyTimeDateUtil myTimeDateUtil = new MyTimeDateUtil();

    @Autowired
    AccountService accountService;

    @Autowired
    BookingService bookingService;

    @Autowired
    AirportService airportService;

    @Autowired
    CarparkService carparkService;


    @Autowired
    SpaceTypeService spaceTypeService;

    @Autowired
    CarparkSpaceService carparkSpaceService;


    @RequestMapping(value = "admin/bookings", method = RequestMethod.GET)
    public ModelAndView listBookings(ModelAndView model, @ModelAttribute("booking") Booking booking) {
/**
 * Create a list of all Bookings
 * Send to view as a list
 */
        List<Booking> allBookings = bookingService.findAllBookings();
        model.addObject("bookingx", allBookings);

/**
 *
 * Send total price of sold bookings to view
 */
        double totalSoldBookings = bookingService.getTotalBookingPrice();
        model.addObject("totalSoldBookings", totalSoldBookings);

/**
 * Send total price to view
 */

        List<Booking> allActiveBookings = bookingService.findAllActiveBookings(true);
        double totalActiveBookings = bookingService.getTotalActiveBookingPrice();
        model.addObject("totalActiveBookings", totalActiveBookings);
/**
 * Send a list of Spaces to view
 */

        List<CarparkSpace> allSpaces = carparkSpaceService.findAllCarparkSpaces();
        model.addObject("spacex", allSpaces);

/**
 * Sennd a the current date and time and day of the week to view
 */
        model.addObject("timex", myTimeDateUtil.getCurrentDateAndDayOfWeek());

        int numBookings = allBookings.size();
        model.addObject("numBookings", numBookings);
        model.setViewName("admin/bookings");
        return model;
    }


    @RequestMapping(value = "admin/bookings/addPage", method = RequestMethod.GET)
    public ModelAndView addBookingPage(ModelAndView model, @ModelAttribute("booking") Booking booking) {


        List<SpaceType> spaceTypeList = spaceTypeService.findAllSpaceTypes();
        model.addObject("spaceTypex", spaceTypeList);


        List<Airport> airportList = airportService.findAllAirports();
        model.addObject("airportx", airportList);

        List<Account> accountList = accountService.findByRoleName("Customer");
        model.addObject("accountx", accountList);

        List<CarparkSpace> carparkSpaceList = carparkSpaceService.findAllAvailableSpaces();
        model.addObject("spacex", carparkSpaceList);


        model.setViewName("admin/addBooking");
        return model;
    }

    @RequestMapping(value = "/admin/bookings/addPage/add", method = RequestMethod.POST)
    public ModelAndView addBooking(ModelAndView model, @Valid @ModelAttribute("booking") Booking booking, BindingResult result, @RequestParam("carparkSpace.id") Long spaceId) {
        if (result.hasErrors()) {

            model.setViewName("redirect:/admin/bookings/addPage");
            return model;
        } else {
            bookingService.createBooking(booking);
            model.setViewName("redirect:/admin/bookings");
            return model;
        }


    }

    @RequestMapping(value = "admin/bookings/viewBooking/{id}", method = RequestMethod.GET)
    public ModelAndView viewBookingDetails(ModelAndView modell, @PathVariable("id") Long id) {

        modell = new ModelAndView("/admin/editBooking");

        Booking booking = bookingService.findBookingById(id);
        modell.addObject("booking", booking);

        modell.addObject("airportx", carparkSpaceService.findAllCarparkSpaces());

        return modell;
    }


    @RequestMapping(value = "admin/bookings/editPage/{id}", method = RequestMethod.GET)
    public ModelAndView editBookingPage(ModelAndView modell, @PathVariable("id") Long id) {

        modell = new ModelAndView("/admin/editBooking");

        Booking booking = bookingService.findBookingById(id);
        modell.addObject("booking", booking);

        modell.addObject("airportx", carparkSpaceService.findAllCarparkSpaces());

        return modell;
    }


    @RequestMapping(value = "/admin/bookings/editPage", method = RequestMethod.POST)
    public ModelAndView editBookingAction(@ModelAttribute("booking") Booking booking, BindingResult result, @RequestParam("id") Long id) {

        ModelAndView modell = new ModelAndView();
        if (result.hasErrors()) {
            modell.setViewName("redirect://admin/bookings/editBooking");
            return modell;
        } else {
            bookingService.updateBookingById(id);
            modell.setViewName("redirect://admin/bookings");
            return modell;
        }

    }

    @RequestMapping("/admin/bookings/delete/{carparkId}")
    public String deleteBookingAction(@PathVariable("carparkId") Long id) {
        bookingService.deleteBookingById(id);
        return "redirect://admin/bookings";
    }

}
