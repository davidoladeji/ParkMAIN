package com.davidoladeji.park.controller.admin;

import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.model.CarparkSpace;
import com.davidoladeji.park.model.SpaceType;
import com.davidoladeji.park.service.implementation.AirportServiceImpl;
import com.davidoladeji.park.service.implementation.CarparkServiceImpl;
import com.davidoladeji.park.service.implementation.CarparkSpaceServiceImpl;
import com.davidoladeji.park.service.implementation.SpaceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 */

@Controller
public class CarparkSpaceController {

    @Autowired
    CarparkServiceImpl carparkService;

    @Autowired
    AirportServiceImpl airportService;

    @Autowired
    CarparkSpaceServiceImpl carparkSpaceService;

    @Autowired
    SpaceTypeServiceImpl spaceTypeService;

    @RequestMapping(value = "admin/spaces", method = RequestMethod.GET)
    public ModelAndView listSpaces(ModelAndView modell, @ModelAttribute("space") CarparkSpace space) {

        //List<CarparkSpace> allSpaces = carparkSpaceRepository.findAll();
        List<CarparkSpace> allSpaces = carparkSpaceService.findAllCarparkSpaces();
        modell.addObject("spacex", allSpaces);

        List<Carpark> allCarparks = carparkService.findAllCarparks();
        modell.addObject("carparkx", allCarparks);

        List<SpaceType> allSpaceTypes = spaceTypeService.findAllSpaceTypes();
        modell.addObject("spaceTypex", allSpaceTypes);


        int numSpaces = allSpaces.size();
        modell.addObject("numSpaces", numSpaces);
        modell.setViewName("admin/spaces");
        return modell;
    }


    @RequestMapping(value = "admin/spaces/addPage", method = RequestMethod.GET)
    public String addSpacePage(ModelMap modell) {

        modell.addAttribute("space", new CarparkSpace());

        modell.addAttribute("carparkx", carparkService.findAllCarparks());

        List<SpaceType> allSpaceTypes = spaceTypeService.findAllSpaceTypes();
        modell.addAttribute("spaceTypex", allSpaceTypes);


        return "admin/addSpace";
    }

    @RequestMapping(value = "/admin/spaces/addPage/add", method = RequestMethod.POST)
    public ModelAndView addSpace(ModelAndView model, @ModelAttribute("space") CarparkSpace space, BindingResult result, HttpServletRequest request) {

        int carparkcapacity = space.getCarpark().getCapacity();

        // Caparpark's Number of Created Spaces
        List<CarparkSpace> carparkSpacesAtCarpark = carparkSpaceService.findAllByCarpark(space.getCarpark());



        // Caparpark's Capacity for Regular
        int caparkregularcapacity = space.getCarpark().getCapacity() - (space.getCarpark().getCapacityfamily() + space.getCarpark().getCapacitydisabled());

        // Caparpark's Capacity for Family
        int caparkfamilycapacity = space.getCarpark().getCapacityfamily();


        // Caparpark's Capacity for Disabled
        int carparkdisabledcapacity = space.getCarpark().getCapacitydisabled();


        // List of created spaces that are of disabled type in that carpark
        List<CarparkSpace> carparkSpaceDisabled = carparkSpaceService.findAllBySpaceTypeInCarpark("disabled", space.getCarpark());

        // List of created spaces that are of family type in that carpark
        List<CarparkSpace> carparkSpaceFamily = carparkSpaceService.findAllBySpaceTypeInCarpark("family", space.getCarpark());

        //List of created spaces that are of regular type in that carpark
        List<CarparkSpace> carparkSpaceRegular = carparkSpaceService.findAllBySpaceTypeInCarpark("regular", space.getCarpark());




        //Check that the capacity is not full
        if(carparkcapacity > carparkSpacesAtCarpark.size() ){
            carparkSpaceService.createCarparkSpace(space);

            //If its a disabled space check that disabled space capacity is not full

            if(space.getSpaceType().getName().equalsIgnoreCase("disabled") ){

                if(carparkdisabledcapacity > carparkSpaceDisabled.size()){
                    carparkSpaceService.createCarparkSpace(space);
                }

            }else if (space.getSpaceType().getName().equalsIgnoreCase("family") ){

                if(caparkfamilycapacity > carparkSpaceFamily.size()){
                    carparkSpaceService.createCarparkSpace(space);
                }

            }else if (space.getSpaceType().getName().equalsIgnoreCase("regular") ){

                if(caparkregularcapacity > carparkSpaceRegular.size()){
                    carparkSpaceService.createCarparkSpace(space);
                }
            }

            return new ModelAndView(new RedirectView("/admin/spaces"));
        }else{

            model.setViewName("/admin/addSpace");
            return model;
        }


    }

    @RequestMapping(value = "admin/spaces/editPage/{id}", method = RequestMethod.GET)
    public ModelAndView editSpacePage(ModelAndView modell, @PathVariable("id") Long id) {

        modell = new ModelAndView("/admin/editSpace");

        List<SpaceType> allSpaceTypes = spaceTypeService.findAllSpaceTypes();
        modell.addObject("spaceTypex", allSpaceTypes);

        CarparkSpace space = carparkSpaceService.findCarparkSpaceById(id);
        modell.addObject("space", space);
        space.setBooked(false);

        modell.addObject("carparkx", carparkService.findAllCarparks());

        return modell;
    }


    @RequestMapping(value = "/admin/spaces/editPage", method = RequestMethod.POST)
    public ModelAndView editSpaceAction(@ModelAttribute("space") CarparkSpace space, BindingResult result, @RequestParam("id") Long id) {


        ModelAndView modell = new ModelAndView();
        if (result.hasErrors()) {
            modell.setViewName("redirect://admin/spaces/editSpace");
            return modell;
        } else {
            carparkSpaceService.updateCarparkSpaceById(id);

            modell.setViewName("redirect://admin/spaces");
            return modell;
        }

    }

    @RequestMapping("/admin/spaces/delete/{id}")
    public String deleteSpaceAction(@PathVariable("id") Long id) {
        carparkSpaceService.deleteCarparkSpaceById(id);
        return "redirect://admin/spaces";
    }


}
