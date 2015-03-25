package com.davidoladeji.park.controller;


/**
 * Created by Daveola on 3/16/2015.
 */


import com.davidoladeji.park.model.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller

public class RESTController {

    @RequestMapping(value = "/exchange", method = RequestMethod.GET)
    @ResponseBody
    public String exchange(@RequestParam(value = "symb") String symb, HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();


        Booking booking = (Booking) (session.getAttribute("booking"));
        if (booking == null) {
            return "";
        }
        double total = booking.getTotal();
        System.out.println("RESTController.exchange() " + booking.getTotal());

        String lastSymbol = (String) session.getAttribute("last.exchange.symbol");
        if (lastSymbol == null) {
            lastSymbol = "GBP";

        }
        // assign new symbol to last symbol
        session.setAttribute("last.exchange.symbol", symb);

        if (!lastSymbol.equals(symb)) {

            String url = "http://localhost:8282/exchange/{symbone}/{symbtwo}/{amount}";


            Object pages = restTemplate.getForObject(url, Object.class, lastSymbol, symb, booking.getTotal());
            // System.out.println("RESTController.exchange()" + pages);
            Map<String, Object> result = (Map<String, Object>) pages;

            String msg = (String) result.get("message");
            if (!"Unsuccessful conversion".equals(msg)) {

                double nTotal = (Double) result.get("conversionresult");

                System.out.println("New Total: " + nTotal);
                booking.setTotal(nTotal);
                total = nTotal;
            }
        }


        return total + "";
    }
}

