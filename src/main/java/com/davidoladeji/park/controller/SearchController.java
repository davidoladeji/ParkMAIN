package com.davidoladeji.park.controller;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.model.Search;
import com.davidoladeji.park.service.interfaces.AirportService;
import com.davidoladeji.park.service.interfaces.CarparkService;
import com.davidoladeji.park.service.interfaces.SearchService;
import com.davidoladeji.park.service.util.MyTimeDateUtil;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by Daveola on 3/25/2015.
 */

@Controller
@SessionAttributes({"search"})
public class SearchController {




    @Autowired
    AirportService airportService;

    @Autowired
    CarparkService carparkService;


    @Autowired
    SearchService searchService;




}
