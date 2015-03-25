package com.davidoladeji.park.controller;

import com.davidoladeji.park.service.interfaces.BookingService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Daveola on 3/14/2015.
 */
@Controller
@RequestMapping("/soapws")
public class SOAPController {

    /**
     * Handles and retrieves the common or admin page depending on the URI template.
     * A user must be log-in first he can access these pages.  Only the admin can see
     * the adminpage, however.
     */


    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "bookingService")
    private BookingService bookingService;

    /**
     * Handles and retrieves subscribed users and
     * display it in a JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/allbookings", method = RequestMethod.GET)
    public String getSubscribersPage(Model model) {
        logger.debug("Received request to show subscribers page");

        // Attach list of subscriptions to the Model
        model.addAttribute("subscriptions", bookingService.findAllActiveBookings(true));

        // This will resolve to /WEB-INF/jsp/subscribers.jsp
        return "bookings";
    }


}
