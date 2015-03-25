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

        int carparkCreatedSpaces = space.getCarpark().getSpacesavailable();

        int caparkfamilycapacity = space.getCarpark().getCapacityfamily();

        int carparkdisabledcapacity = space.getCarpark().getCapacitydisabled();

        int carparkCreatedSpacesFamily = space.getCarpark().getCarparkSpaces().listIterator().


        List<CarparkSpace> carparkSpaceFamilyAtCarpark = carparkSpaceService.findAllBySpaceTypeInCarpark()


        if(carparkcapacity <= carparkCreatedSpaces ){
            carparkSpaceService.createCarparkSpace(space);
            if(spaceType.equalsIgnoreCase("disabled")){
                if(carparkdisabledcapacity <= )
            }
            return new ModelAndView(new RedirectView("/admin/spaces"));
        }else{

            String referer = request.getHeader("Referer");
            return new ModelAndView(new RedirectView("redirect:" + referer));
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

    @RequestMapping("/admin/spaces/delete/{spaceId}")
    public String deleteSpaceAction(@PathVariable("spaceId") Long id) {
        carparkSpaceService.deleteCarparkSpaceById(id);
        return "redirect://admin/spaces";
    }


}