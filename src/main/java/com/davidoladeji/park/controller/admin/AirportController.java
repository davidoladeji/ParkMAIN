package com.davidoladeji.park.controller.admin;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.service.implementation.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 */

@Controller
@Transactional
public class AirportController {
    @Autowired
    AirportServiceImpl airportService;


    @RequestMapping(value = "admin/airports", method = RequestMethod.GET)
    public ModelAndView listAirports(ModelAndView modell, @ModelAttribute("airport") Airport airport) {

        List<Airport> allAirports = airportService.findAllAirports();
        modell.addObject("airportx", allAirports);

        int numAirports = allAirports.size();
        modell.addObject("numAirports", numAirports);
        modell.setViewName("admin/airports");
        return modell;
    }


    @RequestMapping(value = "admin/airports/addPage", method = RequestMethod.GET)
    public String addAirportPage(ModelMap modell) {

        modell.addAttribute("airport", new Airport());

        modell.addAttribute("airportx", airportService.findAllAirports());


        return "admin/addAirport";
    }

    @RequestMapping(value = "/admin/airports/addPage/add", method = RequestMethod.POST)
    public String addAirport(@ModelAttribute("airport") Airport airport, BindingResult result) {
        airportService.createAirport(airport);
        return "redirect://admin/airports";
    }

    @RequestMapping(value = "admin/airports/editPage/{id}", method = RequestMethod.GET)
    public ModelAndView editAirportPage(ModelAndView modell, @PathVariable("id") Long id) {

        modell = new ModelAndView("/admin/editAirport");

        Airport airport = airportService.findAirportById(id);
        modell.addObject("airport", airport);


        modell.addObject("airportx", airportService.findAllAirports());

        return modell;
    }


    @RequestMapping(value = "/admin/airports/editPage", method = RequestMethod.POST)
    public ModelAndView editAirportAction(@ModelAttribute("airport") Airport airport, BindingResult result, @RequestParam("id") Long id) {

        ModelAndView modell = new ModelAndView();
        if (result.hasErrors()) {
            modell.setViewName("redirect://admin/airports/editAirport");
            return modell;
        } else {
            airportService.updateAirportById(id);
            modell.setViewName("redirect://admin/airports");
            return modell;
        }

    }

    @RequestMapping("/admin/airports/delete/{airportId}")
    public String deleteAirportAction(@PathVariable("airportId") Long id) {
        airportService.deleteAirportById(id);
        return "redirect://admin/airports";
    }

}
