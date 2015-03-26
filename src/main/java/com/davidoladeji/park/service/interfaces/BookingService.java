package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Booking;
import com.davidoladeji.park.model.Carpark;
import org.springframework.stereotype.Service;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
@SOAPBinding(style = SOAPBinding.Style.RPC)
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

    public Booking findByCarRegistrationAndCarparkSpace_Carpark(String carregistration, Carpark carpark);
}
