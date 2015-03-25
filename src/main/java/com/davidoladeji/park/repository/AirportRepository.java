package com.davidoladeji.park.repository;


/**
 * Created by Daveola on 25-Nov-14.
 *
 * Interface for AirportRepository extends JpaRepository
 * Provides CRUD facilities for Airport Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(Airport)
 * save(Airport)
 *
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */


import com.davidoladeji.park.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AirportRepository extends JpaRepository<Airport, Long> {


}
