package com.davidoladeji.park.repository;

import com.davidoladeji.park.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daveola on 25-Nov-14.
 * <p/>
 * Interface for BookingRepository extends JpaRepository
 * Provides CRUD facilities for Booking Model
 * This contains
 * findAll() method
 * findOne(Long id)
 * delete(Booking)
 * save(Booking)
 * <p/>
 * Also allows finding by a particular field
 * More details at: http://docs.spring.io/spring-data/jpa/docs/1.6.5.RELEASE/reference/html/repositories.html
 */


@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByActive(boolean active);

    Booking findByCarRegistration(String carregistration);

    Booking findByReceiptno(String receiptno);
}

