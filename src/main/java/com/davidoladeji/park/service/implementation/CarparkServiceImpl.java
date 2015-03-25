package com.davidoladeji.park.service.implementation;


import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.repository.CarparkRepository;
import com.davidoladeji.park.service.interfaces.CarparkService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/5/2015.
 */

@Stateless(name = "CarparkServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class CarparkServiceImpl implements CarparkService {

    private static final int PAGE_SIZE = 5;

    @Autowired
    CarparkRepository carparkRepository;


    public void createCarpark(Carpark carpark) {
        carparkRepository.save(carpark);
    }

    public void deleteCarpark(Carpark carpark) {
        carparkRepository.delete(carpark);
    }

    public void deleteCarparkById(Long id) {
        carparkRepository.delete(carparkRepository.findOne(id));
    }

    public void updateCarparkById(Long id) {

        carparkRepository.save(carparkRepository.findOne(id));
    }

    public List<Carpark> findAllCarparks() {
        return carparkRepository.findAll();
    }

    public Carpark findCarparkById(Long id) {
        return carparkRepository.findOne(id);
    }

    public int countAllCarparks() {
        return carparkRepository.findAll().size();
    }


    public Page<Carpark> carparkPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "codename");
        return carparkRepository.findAll(request);
    }

    public List<Carpark> findAvailableCarparksInAirport(boolean available, Airport airport) {
        List<Carpark> carparkList = carparkRepository.findByAvailableAndAirport(available, airport);
        return carparkList;
    }

    public int getAvailableSpace(Carpark carpark, boolean status) {
        long availablespace = carparkRepository.countByCarparkSpaces_Booked(false);
        return ((int) availablespace);
    }

}

