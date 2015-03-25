package com.davidoladeji.park.controller.admin;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.service.implementation.AirportServiceImpl;
import com.davidoladeji.park.service.implementation.CarparkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 */

@Controller
@Transactional
public class CarparkController {

    @Autowired
    AirportServiceImpl airportService;
    @Autowired
    CarparkServiceImpl carparkService;

    /**
     * This method manages the display of a page having the the
     * List of all Carparks
     *
     * @param modell
     * @param carpark
     * @return
     */
    @RequestMapping(value = "admin/carparks", method = RequestMethod.GET)
    public ModelAndView listCarparks(ModelAndView modell, @ModelAttribute("carpark") Carpark carpark) {


        List<Carpark> allCarparks = carparkService.findAllCarparks();


        List<Airport> allAirports = airportService.findAllAirports();
        modell.addObject("airportx", allAirports);


        modell.addObject("carparkx", allCarparks);

        int numCarparks = allCarparks.size();
        modell.addObject("numCarparks", numCarparks);
        modell.setViewName("admin/carparks");
        return modell;
    }


    @RequestMapping(value = "/admin/carparkspaged/{pageNumber}", method = RequestMethod.GET)
    public String getCarparkByPaging(@PathVariable Integer pageNumber, Model model) {
        Page<Carpark> page = carparkService.carparkPage(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        model.addAttribute("carparkPage", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "admin/carparkspaged";
    }


    /**
     * This controller method handles request for the page where
     * a new car can be added
     *
     * @param modell
     * @param carpark
     * @return
     */
    @RequestMapping(value = "admin/carparks/addPage", method = RequestMethod.GET)
    public ModelAndView addCarparkPage(ModelAndView modell, @ModelAttribute("carpark") Carpark carpark) {


        modell.addObject("airportx", airportService.findAllAirports());

        modell.setViewName("/admin/addCarpark");

        return modell;
    }

    /**
     * This method carries out the actual addition of a carpark to the
     * database via a form submit button (post method)
     * Automaically the capacity of a carpark on creation is
     * equal to its number of spaces available
     *
     * @param carpark
     * @param result
     * @param modell
     * @param capacity
     * @return
     */

    @RequestMapping(value = "/admin/carparks/addPage/add", method = RequestMethod.POST)
    public ModelAndView addCarpark(@Valid @ModelAttribute("carpark") Carpark carpark, BindingResult result, ModelAndView modell, @RequestParam("airport.id") Long id, @RequestParam("capacity") int capacity, @RequestParam("capacitydisabled") int capacitydisabled, @RequestParam("capacityfamily") int capacityfamily) {

        if (result.hasErrors()) {

            modell.addObject("errormessage", "Some kind of error, try again");
            modell.setViewName("admin/addCarpark");

            return modell;
        } else {

            try {
                //Available space on creation is equal to capacity
                carpark.setSpacesavailable(capacity);
                carpark.setFamilyavailable(capacityfamily);
                carpark.setDisabledavailable(capacitydisabled);
                carpark.setAirport(airportService.findAirportById(id));
                carparkService.createCarpark(carpark);

                modell.setViewName("redirect://admin/carparks");
                return modell;
            } catch (DataIntegrityViolationException e) {
                String errormessage = "Some kind of error, try again";
                modell.addObject("errormessage", errormessage);

                modell.setViewName("redirect://admin/addCarpark");
                return modell;
            } catch (DataAccessException e) {
            }

        }


        modell.setViewName("redirect://admin/carparks");

        return modell;


    }

    /**
     * This controller method directs to a page to edit a single Carpark
     *
     * @param model
     * @param id
     * @return
     */

    @RequestMapping(value = "admin/carparks/editPage/{id}", method = RequestMethod.GET)
    public ModelAndView editCarparkPage(ModelAndView model, @PathVariable("id") Long id) {

        model = new ModelAndView("/admin/editCarpark");

        Carpark carpark =
                carparkService.findCarparkById(id);
        model.addObject("carpark", carpark);

        model.addObject("airportx", airportService.findAllAirports());


        return model;
    }


    /**
     * This controller method carries out the actual commiting to the database
     * the chanages made to the carpark
     *
     * @param carpark
     * @param result
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/carparks/editPage", method = RequestMethod.POST)
    public ModelAndView editCarparkAction(@Valid @ModelAttribute("carpark") Carpark carpark, BindingResult result, @RequestParam(value = "id") Long id) {

        ModelAndView model = new ModelAndView();

        if (result.hasErrors()) {
            model.setViewName("redirect://admin/carparks/editCarpark");
            return model;
        } else {
            carparkService.updateCarparkById(id);
            model.setViewName("redirect://admin/carparks");
            return model;
        }

    }

    @RequestMapping("/admin/carparks/delete/{carparkId}")
    public String deleteCarparkAction(@PathVariable("carparkId") Long id) {
        carparkService.deleteCarparkById(id);

        return "redirect://admin/carparks";
    }

}
