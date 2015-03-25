package com.davidoladeji.park.controller;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Search;
import com.davidoladeji.park.model.SpaceType;
import com.davidoladeji.park.service.interfaces.AirportService;
import com.davidoladeji.park.service.interfaces.SpaceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "home"})
public class HomeController {

    @Autowired
    AirportService airportService;

    @Autowired
    SpaceTypeService spaceTypeService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homePage(ModelAndView model, @Valid @ModelAttribute("search") Search search, BindingResult result, HttpSession session) {

        /**
         * Send Space Type List to front-end for drop-down in form
         */


        List<SpaceType> spaceTypeList = spaceTypeService.findAllSpaceTypes();
        model.addObject("spaceTypeList", spaceTypeList);

        List<Airport> airportList = airportService.findAllAirports();
        model.addObject("airportList", airportList);


        session.removeAttribute("currency.session");
        session.removeAttribute("last.exchange.symbol");


        //return new ModelAndView(new RedirectView(getSuccessView()));
        model.setViewName("home");
        return model;
    }
}