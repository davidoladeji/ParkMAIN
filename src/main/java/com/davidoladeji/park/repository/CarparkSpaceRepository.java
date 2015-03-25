package com.davidoladeji.park.repository;

import com.davidoladeji.park.model.Carpark;
import com.davidoladeji.park.model.CarparkSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 * Interface for CarparkSpaceRepository extends JpaRepository
 * Provides CRUD facilities for CarparkSpace Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(CarparkSpace)
 * save(CarparkSpace)
 * <p/>
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */

@Transactional
public interface CarparkSpaceRepository extends JpaRepository<CarparkSpace, Long> {
    List<CarparkSpace> findByBooked(boolean bookingstatus);

    CarparkSpace findBySpaceType_NameAndBooked(String spaceTypeName, boolean availability);

    List<CarparkSpace> findAllBySpaceType_NameAndBooked(String spaceTypeName, boolean availability);

    List<CarparkSpace> findAllByCarpark(Carpark carpark);

    List<CarparkSpace> findBySpaceType_IdAndBooked(Long spaceType, boolean status);

    List<CarparkSpace> findByCarpark_Airport_IdAndCarpark_IdAndSpaceType_IdAndBooked(Long airportId, Long carparkId, Long spaceTypeId, boolean status);

    List<CarparkSpace> findBySpaceTypeAndCarpark(String spaceTypeName, Carpark carpark);

}

