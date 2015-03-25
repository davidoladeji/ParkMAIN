package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Booking;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
public interface BookingService {
    public void createBooking(Booking booking);

    public Booking findByReceiptno(String receiptno);

    public Booking findByCarRegistration(String carregistration);

    public List<Booking> findAllBookings();

    public List<Booking> findAllActiveBookings(boolean active);

    public void updateBookingById(Long id);

    public Booking findBookingById(Long id);

    public void deleteBookingById(Long id);

    public int countAllBookings();

    public double getTotalBookingPrice();

    public double getTotalActiveBookingPrice();
}
