package com.davidoladeji.park.controller;

import com.davidoladeji.park.model.Account;
import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Search;
import com.davidoladeji.park.service.interfaces.AccountService;
import com.davidoladeji.park.service.interfaces.AirportService;
import com.davidoladeji.park.service.util.MyTimeDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Daveola on 3/2/2015.
 */


@Controller
public class LoginController {


    @Autowired
    AccountService accountService;


    @Autowired
    AirportService airportService;

    MyTimeDateUtil timex = new MyTimeDateUtil();

    /**
     * When a user attempts to access a secure page such is routed to the login method
     *
     * @param model
     * @param account
     * @param locale
     * @param result
     * @param error
     * @param logout
     * @return
     */

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView model, @ModelAttribute("user") Account account, Locale locale, BindingResult result,
                                  @RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {

        // String username = "daveola";
        // model.addObject("username", username);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT, DateFormat.SHORT, locale);

        String formattedDate = dateFormat.format(date);

        model.addObject("serverTime", formattedDate);
        model.setViewName("login");

        return model;
    }

    /**
     * If the user login details are incorrect, I have used the spring message tentatively.
     *
     * @param locale
     * @return
     */

    @RequestMapping(value = "/failedlogin", method = RequestMethod.GET)
    public ModelAndView failedLoginPage(Locale locale) {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "AirX System: Failed Login");
        model.setViewName("failedlogin");

        String formattedDate = timex.getCurrentDateTime();

        model.addObject("serverTime", formattedDate);
        return model;

    }


    /**
     * This is the method routed to when a user logs our
     * It goes to an homepage from which they can carry out another search.
     *
     * @param model
     * @param result
     * @param search
     * @return
     */

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage(ModelAndView model, BindingResult result, @ModelAttribute("search") Search search) {

        model.setViewName("logout");
        List<Airport> airportList = airportService.findAllAirports();
        model.addObject("airportList", airportList);

        String formattedDate = timex.getCurrentDateTime();
        model.addObject("serverTime", formattedDate);
        return model;

    }


}
