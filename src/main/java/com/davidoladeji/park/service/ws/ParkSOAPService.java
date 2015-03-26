package com.davidoladeji.park.service.ws;

import com.davidoladeji.park.model.Booking;
import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.repository.BookingRepository;
import com.davidoladeji.park.repository.CarparkRepository;
import com.davidoladeji.park.service.interfaces.BookingService;
import com.davidoladeji.park.service.interfaces.CarparkService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */


@Stateless(name = "ParkService")
@Interceptors(SpringLifecycleInterceptor.class)
@WebService(serviceName = "ParkService")
public class ParkSOAPService extends SpringBeanAutowiringSupport {


    @Autowired
    BookingService bookingService;


    @Autowired
    CarparkService caparkService;



    public Booking findByCarRegistrationAndCarpark(String carregistration, Carpark carpark) {
        return bookingService.findByCarRegistrationAndCarparkSpace_Carpark(carregistration, carpark);
    }


    public List<Booking> findAllBookings() {
        return bookingService.findAllBookings();
    }


    public List<Booking> findAllActiveBookings(boolean active) {
        return bookingService.findAllActiveBookings(active);
    }


    public void updateBookingById(Long id) {
        bookingService.createBooking(bookingService.findBookingById(id));
    }



    public int countAllBookings() {
        return bookingService.findAllBookings().size();
    }

    public List<Carpark> findAllCarparks() {
        return caparkService.findAllCarparks();
    }


    @Transactional
    public void setGrantedEntry(boolean grantedEntry, Booking booking) {
        booking.setGrantedEntry(grantedEntry);
        bookingService.createBooking(bookingService.findBookingById(booking.getId()));
    }

    @Transactional
    public void setGrantedExit(boolean grantedExit, Booking booking) {
        booking.setGrantedExit(grantedExit);
        bookingService.createBooking(bookingService.findBookingById(booking.getId()));
    }
}
