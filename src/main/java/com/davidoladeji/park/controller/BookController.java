package com.davidoladeji.park.controller;

import com.davidoladeji.park.model.*;
import com.davidoladeji.park.service.interfaces.*;
import com.davidoladeji.park.service.util.MyTimeDateUtil;
import com.davidoladeji.park.service.util.Pricing;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by Daveola on 3/3/2015.
 * All pages navigations related to the Booking
 */

@Controller
@SessionAttributes({"search", "booking"})
public class BookController {


    @Autowired
    SearchService searchService;

    @Autowired
    CarparkSpaceService carparkSpaceService;

    @Autowired
    SpaceTypeService spaceTypeService;

    Account loggedInUser;

    @Autowired
    CarparkService carparkService;


    @Autowired
    AirportService airportService;

    @Autowired
    BookingService bookingService;

    @Autowired
    AccountService accountService;



    @ModelAttribute("search")
    public Search createBlankSearch() {
        return new Search();
    }


    @ModelAttribute("booking")
    public Booking createBlankBooking() {
        return new Booking();
    }



// Booking flow Starts with search
    @RequestMapping(value = "/spaces/search", method = RequestMethod.GET)
    public ModelAndView searchForSpace(ModelAndView model, @Valid @ModelAttribute("search") Search search, BindingResult result,
                                       @RequestParam(value = "airportid", required = false) Long airportid,
                                       @RequestParam(value = "traveldate", required = true) String traveldate,
                                       @RequestParam(value = "traveltime", required = true) String traveltime,
                                       @RequestParam(value = "travelenddate", required = true) String travelenddate,
                                       @RequestParam(value = "travelendtime", required = true) String travelendtime,
                                       @RequestParam(value = "spaceTypeId", required = false) Long spaceTypeId,
                                       HttpServletRequest request

    ) {


        if (result.hasErrors()) {


            String referer = request.getHeader("Referer");
            return new ModelAndView(new RedirectView("redirect:" + referer));
        }



        model = new ModelAndView("search");
        model.addObject("search", search);


        /**
         * Convert dates to users Local time using Joda time
         * and use that to find carpark spaces available at the specified times
         */
        MyTimeDateUtil myTimeDateUtil = new MyTimeDateUtil();

        Date traveldateConverted = myTimeDateUtil.convertStringtoDate(traveldate);
        Date travelenddateConverted = myTimeDateUtil.convertStringtoDate(travelenddate);
        Date traveltimeConverted = myTimeDateUtil.convertStringtoTime(traveltime);
        Date travelendtimeConverted = myTimeDateUtil.convertStringtoTime(travelendtime);
        search.setAirportid(airportid);


        int numdays = Days.daysBetween(myTimeDateUtil.convertUtilDateToLocalDate(traveldateConverted), myTimeDateUtil.convertUtilDateToLocalDate(travelenddateConverted)).getDays();
        search.setNumdays(numdays);
        search.setTraveldate(traveldateConverted);
        search.setTravelenddate(travelenddateConverted);
        search.setTraveltime(traveltimeConverted);
        search.setTravelendtime(travelendtimeConverted);
        search.setSpaceTypeId(spaceTypeId);


        List<Airport> airportList = airportService.findAllAirports();
        model.addObject("airportList", airportList);

        /**
         *
         * Retrieve the airport that user searched
         * and forward to view
         */

        Airport airport = airportService.findAirportById(airportid);
        model.addObject("airport", airport);


        /**
         * Return List of Carparks at a airport
         * With Available Space
         *
         */


        List<Carpark> carparkList = carparkService.findAvailableCarparksInAirport(true, airport);


        searchService.saveSearch(search);

        model.addObject("carparkList", carparkList);

        model.setViewName("searchresult");


        return model;

        //   }

    }



    @RequestMapping(value = "/spaces/{carparkId}", method = RequestMethod.GET)
    public ModelAndView gotoSpacesList(ModelAndView model, @ModelAttribute("search") Search search, @ModelAttribute Booking booking, @PathVariable("carparkId") Long carparkId) {

        model.addObject("search", search);

        Carpark carpark = carparkService.findCarparkById(carparkId);
        model.addObject("carpark", carpark);


        List<CarparkSpace> carparkSpaceList = null;

        /**
         * Get List of Carparkspaces
         * By searching for CarparkSpaces in a Specific Carpark as specified by user
         * The SpaceType chosen and the Booking Status of the Spaces
         */


        if (search.getSpaceTypeId().intValue() == 1) {
            carparkSpaceList = carparkSpaceService.findAllByAirportCarparkTypeAndAvailablity(search.getAirportid(), carpark.getId(), search.getSpaceTypeId(), false);
        } else if (search.getSpaceTypeId().intValue() == 2) {
            carparkSpaceList = carparkSpaceService.findAllByAirportCarparkTypeAndAvailablity(search.getAirportid(), carpark.getId(), search.getSpaceTypeId(), false);
        } else if (search.getSpaceTypeId().intValue() == 3) {
            carparkSpaceList = carparkSpaceService.findAllByAirportCarparkTypeAndAvailablity(search.getAirportid(), carpark.getId(), search.getSpaceTypeId(), false);
        }


        //Send list with model
        model.addObject("carparkSpaceList", carparkSpaceList);


        booking.setArrivalDate(search.getTraveldate());
        booking.setArrivalTime(search.getTraveltime());
        booking.setDepartureDate(search.getTravelenddate());
        booking.setDepartureTime(search.getTravelendtime());

        model.setViewName("spacesatcarpark");
        return model;
    }


    @RequestMapping(value = "/booking/{carparkSpaceId}", method = RequestMethod.GET)
    public ModelAndView gotoBookingForm(ModelAndView model, @ModelAttribute Search search, @ModelAttribute Booking booking, @PathVariable("carparkSpaceId") Long carparkId) {

        model.addObject("search", search);


        Carpark carpark = carparkService.findCarparkById(carparkId);
        model.addObject("carpark", carpark);

        booking.setSpaceType(spaceTypeService.findSpaceTypeById(search.getSpaceTypeId()));

        if (search.getSpaceTypeId().intValue() == 1) {
            booking.setCarparkSpace(carparkSpaceService.findOneRegularAvailableSpace());

        } else if (search.getSpaceTypeId().intValue() == 2) {
            booking.setCarparkSpace(carparkSpaceService.findOneFamilyAvailableSpace());

        } else if (search.getSpaceTypeId().intValue() == 3) {
            booking.setCarparkSpace(carparkSpaceService.findOneDisabledAvailableSpace());

        }


        // calculate the price using Pricing class


        double price = booking.getCarparkSpace().getCarpark().getRegularprice();
        double price1 = Pricing.getPriceByType(price, search.getSpaceTypeId().intValue());

        double price2 = Pricing.getPriceByBookingNumDays(price1, new LocalDate(booking.getArrivalDate()), new LocalDate(booking.getDepartureDate()));

        double price3 = Pricing.getPriceByHowAdvance(price2, new LocalDate(booking.getArrivalDate()));

        // we could do a minimum option pricing but not necessary in this case
       /* List<Double> prices = new ArrayList<Double>();
        if (price1 > 0) prices.add(price1);
        if (price2 > 0) prices.add(price2);
        if (price3 > 0) prices.add(price3);

        booking.setBase_price(Collections.min(prices));*/


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.findByAccountname(auth.getName());
        model.addObject("loggedInUser", account);

        //TODO If there is a disabled discount send a message to front of the difference


        booking.setBase_price(price3);
        booking.setTotal(Pricing.getTotalTripPrice(booking.getBase_price(), new LocalDate(booking.getArrivalDate()), new LocalDate(booking.getDepartureDate())));

        booking.setArrivalDate(search.getTraveldate());
        booking.setArrivalTime(search.getTraveltime());
        booking.setDepartureDate(search.getTravelenddate());
        booking.setDepartureTime(search.getTravelendtime());


        /**
         * Send Space Type List to front-end for drop-down in form
         */
        List<SpaceType> spaceTypeList = spaceTypeService.findAllSpaceTypes();
        model.addObject("spaceTypeList", spaceTypeList);
        model.setViewName("book");
        return model;
    }


    @RequestMapping(value = "/booking/payment-form", method = RequestMethod.GET)
    public ModelAndView bookingPayment(ModelAndView model, HttpServletRequest request,
                                       @ModelAttribute Booking booking) {





        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Account account = accountService.findByAccountname(auth.getName());
        model.addObject("loggedInUser", account);

        model.setViewName("payment-form");
        return model;
    }


    @RequestMapping(value = "/booking/payment-successful", method = RequestMethod.GET)
    public ModelAndView successfulBooking(ModelAndView model, SessionStatus sessionStatus, HttpServletRequest request,
                                          @ModelAttribute Booking booking) {


        if (sessionStatus.isComplete()) {

            model.setViewName("/home");
        } else {
            sessionStatus.setComplete();

            model.setViewName("payment-success");
            // Booking booking = (Booking)request.getSession().getAttribute("booking");

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Account account = accountService.findByAccountname(auth.getName());
            model.addObject("loggedInUser", account);

            //System.out.println("BookController.successfulBooking() "+ booking.getBase_price());

            booking.setAccount(account);
            booking.setActive(true);
            booking.setReceiptno();
            booking.setDestinationPrice(booking.getTotal());
            bookingService.createBooking(booking);
        }


        return model;
    }

}
