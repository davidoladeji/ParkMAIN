package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Booking;
import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.repository.BookingRepository;
import com.davidoladeji.park.service.interfaces.BookingService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */


@Stateless(name = "BookingServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class BookingServiceImpl implements BookingService {


    @Autowired
    BookingRepository bookingRepository;


    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }


    public Booking findByReceiptno(String receiptno) {
        return bookingRepository.findByReceiptno(receiptno);
    }

    public Booking findByCarRegistration(String carregistration) {
        return bookingRepository.findByCarRegistration(carregistration);
    }



    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }


    public List<Booking> findAllActiveBookings(boolean active) {
        return bookingRepository.findByActive(active);
    }


    public void updateBookingById(Long id) {
        bookingRepository.save(bookingRepository.findOne(id));
    }


    public Booking findBookingById(Long id) {
        return bookingRepository.findOne(id);
    }


    public void deleteBookingById(Long id) {
        bookingRepository.delete(bookingRepository.findOne(id));
    }


    public int countAllBookings() {
        return bookingRepository.findAll().size();
    }

    /**
     * Method to return the total amount from
     * Bookings
     */


    public double getTotalBookingPrice() {
        double totalSoldBookings = 0.0;
        int count = 0;
        List<Booking> bookingList = bookingRepository.findAll();

        if (!bookingList.isEmpty() && bookingList.size() >= 1) {
            do {
                totalSoldBookings += bookingList.iterator().next().getBase_price();
                count++;
            }
            while (bookingList.iterator().hasNext() && count < bookingList.size());
        }


        return totalSoldBookings;
    }

    /**
     * Method to return the total amount from
     * ACTIVE Bookings
     */


    public Booking findByCarRegistrationAndCarparkSpace_Carpark(String carRegistration, Carpark carpark){

        return bookingRepository.findByCarRegistrationAndCarparkSpace_Carpark(carRegistration, carpark);

    }

    public double getTotalActiveBookingPrice() {
        double totalSoldBookings = 0.0;
        int count = 0;
        List<Booking> bookingList = bookingRepository.findByActive(true);

        if (!bookingList.isEmpty() && bookingList.size() >= 1) {
            do {
                totalSoldBookings += bookingList.iterator().next().getBase_price();
                count++;
            }
            while (bookingList.iterator().hasNext() && count < bookingList.size());
        }


        return totalSoldBookings;
    }


}
