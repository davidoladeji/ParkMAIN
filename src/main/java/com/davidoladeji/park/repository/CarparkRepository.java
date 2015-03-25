package com.davidoladeji.park.repository;

import com.davidoladeji.park.model.Airport;
import com.davidoladeji.park.model.Carpark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daveola on 2/24/2015.
 * Interface for CarparkRepository extends JpaRepository
 * Provides CRUD facilities for Carpark Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(Carpark)
 * save(Carpark)
 * <p/>
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */
@Transactional
public interface CarparkRepository extends JpaRepository<Carpark, Long> {

    @Query(value = "select c from carpark c", countQuery = "select count(c) from carpark c")
    Page<Carpark> findAll(Pageable pageable);


    List<Carpark> findByAvailableAndAirport(boolean available, Airport airport);

    Long countByCarparkSpaces_Booked(boolean status);


}
