package com.davidoladeji.park.service.implementation;

import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.model.CarparkSpace;
import com.davidoladeji.park.repository.CarparkSpaceRepository;
import com.davidoladeji.park.service.interfaces.CarparkSpaceService;
import org.jboss.spring.callback.SpringLifecycleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by Daveola on 3/11/2015.
 */

@Stateless(name = "CarparkSpaceServiceImpl")
@Interceptors(SpringLifecycleInterceptor.class)
public class CarparkSpaceServiceImpl implements CarparkSpaceService {

    @Autowired
    CarparkSpaceRepository carparkSpaceRepository;

    public void createCarparkSpace(CarparkSpace carparkSpace) {
        carparkSpaceRepository.save(carparkSpace);
    }

    public List<CarparkSpace> findAllCarparkSpaces() {
        return carparkSpaceRepository.findAll();
    }

    public void updateCarparkSpaceById(Long id) {
        carparkSpaceRepository.save(carparkSpaceRepository.findOne(id));
    }

    public CarparkSpace findCarparkSpaceById(Long id) {
        return carparkSpaceRepository.findOne(id);
    }

    public void deleteCarparkSpaceById(Long id) {
        carparkSpaceRepository.delete(carparkSpaceRepository.findOne(id));
    }

    public int countAllCarparkSpaces() {
        return carparkSpaceRepository.findAll().size();
    }

    public int countAllAvailableSpaces() {
        return carparkSpaceRepository.findByBooked(false).size();
    }

    public List<CarparkSpace> findAllAvailableSpaces() {
        return carparkSpaceRepository.findByBooked(false);
    }

    public CarparkSpace findOneBySpaceTypeAndAvailableSpace(String spaceTypeName, boolean availability) {
        return carparkSpaceRepository.findBySpaceType_NameAndBooked(spaceTypeName, availability);
    }

    public CarparkSpace findOneRegularAvailableSpace() {
        long regular = 1;
        List<CarparkSpace> carparkSpaceList = carparkSpaceRepository.findBySpaceType_IdAndBooked(regular, false);
        CarparkSpace carparkSpace = carparkSpaceList.get(0);
        return carparkSpace;
    }

    public CarparkSpace findOneFamilyAvailableSpace() {
        long family = 2;
        List<CarparkSpace> carparkSpaceList = carparkSpaceRepository.findBySpaceType_IdAndBooked(family, false);
        CarparkSpace carparkSpace = carparkSpaceList.get(0);
        return carparkSpace;
    }

    public CarparkSpace findOneDisabledAvailableSpace() {
        long disabled = 3;
        List<CarparkSpace> carparkSpaceList = carparkSpaceRepository.findBySpaceType_IdAndBooked(disabled, false);
        CarparkSpace carparkSpace = carparkSpaceList.get(0);
        return carparkSpace;
    }

    public List<CarparkSpace> findAllByCarpark(Carpark carpark) {
        return carparkSpaceRepository.findAllByCarpark(carpark);
    }

    public List<CarparkSpace> findAllBySpaceTypeAvailableSpace(String spaceTypeName, boolean availability) {
        return carparkSpaceRepository.findAllBySpaceType_NameAndBooked(spaceTypeName, availability);
    }

    public List<CarparkSpace> findAllBySpaceType_NameAndCarpark(String spaceTypeName, Carpark carpark) {
        return carparkSpaceRepository.findAllBySpaceType_NameAndCarpark(spaceTypeName, carpark);
    }


    public List<CarparkSpace> findAllByAirportCarparkTypeAndAvailablity(Long airportId, Long carparkId, Long spaceTypeId, boolean availability) {
        List<CarparkSpace> carparkSpaceList = carparkSpaceRepository.findByCarpark_Airport_IdAndCarpark_IdAndSpaceType_IdAndBooked(airportId, carparkId, spaceTypeId, availability);
        return carparkSpaceList;
    }


}
