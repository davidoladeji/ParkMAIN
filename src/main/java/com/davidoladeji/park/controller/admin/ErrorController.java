package com.davidoladeji.park.controller.admin;

import com.davidoladeji.park.service.util.ResourceNotFoundException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Daveola on 3/2/2015.
 */

@Controller
public class ErrorController {

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();

            model.addObject("username", userDetail.getUsername());


        }
        model.addObject("title", "AirX - Error - 403");

        model.setViewName("403");
        return model;

    }


    // for 404 page not found
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public ModelAndView notFoundDenied() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "AirX - Error - 404");
        model.setViewName("404");
        return model;

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        return "404";
    }

}
