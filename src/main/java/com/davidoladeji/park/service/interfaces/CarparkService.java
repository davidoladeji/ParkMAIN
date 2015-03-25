package com.davidoladeji.park.service.interfaces;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Carpark;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Remote
public interface CarparkService {

    public void createCarpark(Carpark carpark);

    public void deleteCarpark(Carpark carpark);

    public void deleteCarparkById(Long id);

    public Carpark findCarparkById(Long id);

    public void updateCarparkById(Long id);

    public List<Carpark> findAllCarparks();

    public int countAllCarparks();

    /**
     * Find Available Carparks in a specific airport
     *
     * @param available
     * @param airport
     * @return
     */

    public List<Carpark> findAvailableCarparksInAirport(boolean available, Airport airport);

    public int getAvailableSpace(Carpark carpark, boolean status);

}
