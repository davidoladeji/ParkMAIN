package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.repository.AirportRepository;
import com.davidoladeji.park.service.interfaces.AirportService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.Stateful;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Stateful(name = "AirportServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public void createAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public List<Airport> findAllAirports() {
        return airportRepository.findAll();
    }

    public void updateAirportById(Long id) {
        airportRepository.save(airportRepository.findOne(id));
    }

    public Airport findAirportById(Long id) {
        return airportRepository.findOne(id);
    }

    public void deleteAirportById(Long id) {
        airportRepository.delete(airportRepository.findOne(id));
    }

    public int countAllAirports() {
        List<Airport> airportList = airportRepository.findAll();
        int numAirports = airportList.size();
        return numAirports;
    }

    public AirportRepository getAirportRepository() {
        return airportRepository;
    }

    public void setAirportRepository(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

}
