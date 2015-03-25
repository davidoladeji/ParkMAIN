package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Booking;
import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.model.Search;
import com.davidoladeji.park.service.interfaces.BookingService;
import com.davidoladeji.park.service.interfaces.CarparkService;
import com.davidoladeji.park.service.interfaces.ScheduledService;
import com.davidoladeji.park.service.interfaces.SearchService;
import org.apache.log4j.Logger;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Date;
import java.util.List;


/**
 * Created by Daveola on 3/3/2015.
 */


//@Stateless(name = "ScheduledServiceImpl")
//@Interceptors(SpringLifecycleInterceptor.class)
public class ScheduledServiceImpl /*implements ScheduledService */{

    protected static Logger logger = Logger.getLogger("service");

    @Autowired
    private SearchService searchService;

    @Autowired
    private CarparkService carparkService;


    @Autowired
    BookingService bookingService;


    /**
     * Delete searches saved periodically
     */
    public void performService() {
        String threadName = Thread.currentThread().getName();
        logger.debug("   " + threadName + " cron service performing important stuff..");

        List<Search> searchList = searchService.findAllSearches();
        System.out.println("The number of current search(es): " + searchList.size());
        if (searchList.size() >= 2) {
            System.out.println("Delete all searches ...");
            searchService.deleteAllSearch();
        }
    }


    /**
     * Deactivate a Carpark from being available
     */

    public void performCarparksUpdate() {
        List<Carpark> carparkList = carparkService.findAllCarparks();
        for (int i = 0; i < carparkList.size(); i++) {
            carparkList.get(i).setSpacesavailable();
            if (carparkList.get(i).getSpacesavailable() == 0) {
                carparkList.get(i).setAvailable(false);
            } else if (carparkList.get(i).getSpacesavailable() >= 1) {
                carparkList.get(i).setAvailable(true);
            }

        }
    }


    public void setFamilyAvailable() {
        List<Carpark> carparkList = carparkService.findAllCarparks();
        int familyavailable = 0;
        for (int i = 0; i < carparkList.size(); i++) {

            for (i = 0; i < carparkList.get(i).getCarparkSpaces().size(); i++) {

                if (carparkList.get(i).getCarparkSpaces().iterator().next().getSpaceType().getName().equalsIgnoreCase("family")) {
                    familyavailable++;
                }
                carparkList.get(i).getCarparkSpaces().iterator().next();
            }
            carparkList.get(i).setFamilyavailable(familyavailable);
        }
    }


    public void setDisabledAvailable() {
        List<Carpark> carparkList = carparkService.findAllCarparks();
        int disabledavailable = 0;
        for (int i = 0; i < carparkList.size(); i++) {

            for (i = 0; i < carparkList.get(i).getCarparkSpaces().size(); i++) {

                if (carparkList.get(i).getCarparkSpaces().iterator().next().getSpaceType().getName().equalsIgnoreCase("disabled")) {
                    disabledavailable++;
                }
                carparkList.get(i).getCarparkSpaces().iterator().next();
            }
            carparkList.get(i).setFamilyavailable(disabledavailable);
        }

        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
    }


    @Scheduled(cron = "*/5 * * * * MON-FRI")
    public void deactivateBookings() {
        System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
        List<Booking> activeBookingsList = bookingService.findAllActiveBookings(true);
        System.out.println("Something happening");
        Date today = new Date();

        LocalTime timenow = new LocalTime();

        int count = 0;

        while (activeBookingsList.listIterator().hasNext() && count < activeBookingsList.size()) {

            LocalTime bookingtime = new LocalTime(activeBookingsList.listIterator().next().getDepartureTime());

            if (activeBookingsList.listIterator().next().getDepartureDate().after(today) && bookingtime.isAfter(timenow)) {

                activeBookingsList.listIterator().next().setActive(false);
            }

        }
    }

}
